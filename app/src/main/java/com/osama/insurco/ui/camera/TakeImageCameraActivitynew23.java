package com.osama.insurco.ui.camera;

import static android.Manifest.permission.CAMERA;
import static android.Manifest.permission.WRITE_EXTERNAL_STORAGE;

import android.Manifest;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.hardware.Camera;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.camera.core.ImageCapture;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.osama.insurco.R;
import com.osama.insurco.Settings.BaseActivity;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import de.markusfisch.android.cameraview.widget.CameraView;


public class TakeImageCameraActivitynew23 extends BaseActivity {


    FloatingActionButton capture;

    TextView next;

    File ff;
    CameraView cameraView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_take_image_cameranew);
//         cameraView = new CameraView(this);


        capture = findViewById(R.id.capture);//RELATIVELAYOUT OR
        next = findViewById(R.id.next);//RELATIVELAYOUT OR
        cameraView = findViewById(R.id.camera_view);//RELATIVELAYOUT OR

        cameraView.setUseOrientationListener(true);

        cameraView.setTapToFocus();
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                takeDoubleImgHActivity.save_img(ff);

                finish();
            }
        });
        capture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cameraView.getCamera().takePicture(new Camera.ShutterCallback() {
                    @Override
                    public void onShutter() {
                        System.out.println("&&&&&&&&&&&&&&&&777");
                    }
                }, new Camera.PictureCallback() {
                    @Override
                    public void onPictureTaken(byte[] data, Camera camera) {
                        System.out.println("@@@@@@@@@@@@@@@@@@@@");
//                        saveImage(data);
                        next.setVisibility(View.VISIBLE);
                        capture.setVisibility(View.GONE);

                    }
                }, new Camera.PictureCallback() {
                    @Override
                    public void onPictureTaken(byte[] data, Camera camera) {
                        System.out.println("454557845788738998298981919:::" + data.length);
                    }
                });
            }
        });
        cameraView.setOnCameraListener(new CameraView.OnCameraListener() {
            @Override
            public void onConfigureParameters(Camera.Parameters parameters) {
//                Camera.Size size = findBestPreviewSize(
//                        parameters.getSupportedPreviewSizes(),
//                        cameraView.getFrameWidth() * 1000,
//                        cameraView.getFrameHeight() * 1000);
//                parameters.setPreviewSize(size.width, size.height);
//                CameraView.setAutoFocus(parameters);

            }

            @Override
            public void onCameraError() {

            }

            @Override
            public void onCameraReady(Camera camera) {
            }

            @Override
            public void onPreviewStarted(Camera camera) {

            }

            @Override
            public void onCameraStopping(Camera camera) {

            }
        });
    }

    private void saveImage(byte[] bytes) {
        FileOutputStream outStream;
        try {
            String fileName = "TUTORIALWING_" + System.currentTimeMillis() + ".jpg";
            File file = new File(Environment.getExternalStorageDirectory(), fileName);
            outStream = new FileOutputStream(file);
            outStream.write(bytes);
            outStream.close();
            Toast.makeText(TakeImageCameraActivitynew23.this, "Picture Saved: " + fileName, Toast.LENGTH_LONG).show();


            ff = file;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void onResume() {

        super.onResume();
        cameraView.openAsync(CameraView.findCameraId(
                Camera.CameraInfo.CAMERA_FACING_BACK));
    }
}