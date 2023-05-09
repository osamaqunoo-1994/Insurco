package com.osama.insurco.ui.camera;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.pm.PackageManager;
import android.graphics.PixelFormat;
import android.hardware.Camera;
import android.os.Build;
import android.os.Bundle;
import android.widget.Toast;

import com.osama.insurco.R;
import com.osama.insurco.Settings.BaseActivity;

import de.markusfisch.android.cameraview.widget.CameraView;


public class TakeImageCameraActivity extends BaseActivity {

    private static final int REQUEST_CAMERA = 1;

    private static boolean frontFacing = false;

    private CameraView cameraView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_take_image_camera);


        cameraView =findViewById(R.id.camera_view);

        checkPermissions();

        cameraView = new CameraView(this);
        cameraView.setUseOrientationListener(true);
        cameraView.setOnClickListener(v -> invertCamera());

        setContentView(cameraView);


    }

    private void checkPermissions() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            String permission = android.Manifest.permission.CAMERA;
            if (checkSelfPermission(permission) !=
                    PackageManager.PERMISSION_GRANTED) {
                requestPermissions(new String[]{permission}, REQUEST_CAMERA);
            }
        }
    }


    @Override
    public void onResume() {
        super.onResume();
        openCameraView();
    }

    @Override
    public void onPause() {
        super.onPause();
        closeCameraView();
    }

    @Override
    public void onRequestPermissionsResult(
            int requestCode,
            String[] permissions,
            int[] grantResults) {
        if (requestCode == REQUEST_CAMERA &&
                grantResults.length > 0 &&
                grantResults[0] != PackageManager.PERMISSION_GRANTED) {
            Toast.makeText(
                    this,
                    "error_camera",
                    Toast.LENGTH_SHORT).show();
            finish();
        }
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

    }
    private void openCameraView() {
        cameraView.openAsync(CameraView.findCameraId(getFacing()));
    }

    private void closeCameraView() {
        cameraView.close();
    }

    private void invertCamera() {
        frontFacing ^= true;
        closeCameraView();
        openCameraView();
    }

    private int getFacing() {
        return frontFacing ?
                Camera.CameraInfo.CAMERA_FACING_FRONT :
                Camera.CameraInfo.CAMERA_FACING_BACK;
    }
}