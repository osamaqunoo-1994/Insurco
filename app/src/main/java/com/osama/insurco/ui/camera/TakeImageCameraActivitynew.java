package com.osama.insurco.ui.camera;

import static android.provider.MediaStore.Files.FileColumns.MEDIA_TYPE_VIDEO;

import android.Manifest;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.hardware.Camera;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;


import android.os.Environment;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;


import androidx.annotation.NonNull;
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

import static android.Manifest.permission.CAMERA;
import static android.Manifest.permission.WRITE_EXTERNAL_STORAGE;




public class TakeImageCameraActivitynew extends BaseActivity implements SurfaceHolder.Callback, Camera.PictureCallback {


    FloatingActionButton capture;


    private SurfaceHolder surfaceHolder;
    private Camera camera;

    public static final int REQUEST_CODE = 100;

    private SurfaceView surfaceView;

    private String[] neededPermissions = new String[]{CAMERA, WRITE_EXTERNAL_STORAGE};





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_take_image_cameranew);


        capture = findViewById(R.id.capture);//RELATIVELAYOUT OR

        surfaceView = findViewById(R.id.preview);
        if (surfaceView != null) {
            boolean result = checkPermission();
            if (result) {
                setupSurfaceHolder();
            }
        }


        //        cameraView.addPictureTakenListener(new Function1<Image, Unit>() {
//            @Override
//            public Unit invoke(Image image) {
//
//
//                System.out.println("98898989");
//
//                return null;
//            }
//        });


        capture.setOnClickListener(new View.OnClickListener()     //THE BUTTON CODE
        {
            public void onClick(View v) {


                captureImage();

            }

        });


    }
    private boolean checkPermission() {
        int currentAPIVersion = Build.VERSION.SDK_INT;
        if (currentAPIVersion >= android.os.Build.VERSION_CODES.M) {
            ArrayList<String> permissionsNotGranted = new ArrayList<>();
            for (String permission : neededPermissions) {
                if (ContextCompat.checkSelfPermission(this, permission) != PackageManager.PERMISSION_GRANTED) {
                    System.out.println("jkjkjkjkjk"+permission);
                    permissionsNotGranted.add(permission);

                }
            }
            if (permissionsNotGranted.size() > 0) {
                boolean shouldShowAlert = false;
                for (String permission : permissionsNotGranted) {
                    shouldShowAlert = ActivityCompat.shouldShowRequestPermissionRationale(this, permission);
                }
                if (shouldShowAlert) {
                    showPermissionAlert(permissionsNotGranted.toArray(new String[permissionsNotGranted.size()]));
                } else {
                    requestPermissions(permissionsNotGranted.toArray(new String[permissionsNotGranted.size()]));
                }
                return false;
            }
        }
        return true;
    }
    private void showPermissionAlert(final String[] permissions) {
        AlertDialog.Builder alertBuilder = new AlertDialog.Builder(this);
        alertBuilder.setCancelable(true);
        alertBuilder.setTitle(R.string.permission_required);
        alertBuilder.setMessage(R.string.permission_message);
        alertBuilder.setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
//                requestPermissions(permissions);
            }
        });
        AlertDialog alert = alertBuilder.create();
        alert.show();
    }
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode) {
            case REQUEST_CODE:
                for (int result : grantResults) {
                    if (result == PackageManager.PERMISSION_DENIED) {
                        Toast.makeText(TakeImageCameraActivitynew.this, R.string.permission_warning, Toast.LENGTH_LONG).show();
//                        setViewVisibility(R.id.showPermissionMsg, View.VISIBLE);
                        System.out.println("#@#@#@#@#");
                        return;
                    }
                }
                System.out.println("#@#@#@#@#XXXXXX");

                setupSurfaceHolder();
                break;
        }
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    private void setViewVisibility(int id, int visibility) {
        View view = findViewById(id);
        if (view != null) {
            view.setVisibility(visibility);
        }
    }

    private void setupSurfaceHolder() {
//        setViewVisibility(R.id.startBtn, View.VISIBLE);
//        setViewVisibility(R.id.surfaceView, View.VISIBLE);

        surfaceHolder = surfaceView.getHolder();
        surfaceHolder.addCallback(this);
        setBtnClick();
    }

    private void setBtnClick() {

        if (capture != null) {
            capture.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    captureImage();
                }
            });
        }
    }
    public void captureImage() {
        if (camera != null) {
            camera.takePicture(null, null, this);
        }
    }



    private void startCamera() {
        camera = Camera.open();
        camera.setDisplayOrientation(90);
        try {
            camera.setPreviewDisplay(surfaceHolder);
            camera.startPreview();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void resetCamera() {
        if (surfaceHolder.getSurface() == null) {
            // Return if preview surface does not exist
            return;
        }

        if (camera != null) {
            // Stop if preview surface is already running.
            camera.stopPreview();
            try {
                // Set preview display
                camera.setPreviewDisplay(surfaceHolder);
            } catch (IOException e) {
                e.printStackTrace();
            }
            // Start the camera preview...
            camera.startPreview();
        }
    }


    private void requestPermissions(String[] permissions) {

        System.out.println("#####"+permissions[0]);
        ActivityCompat.requestPermissions(TakeImageCameraActivitynew.this, permissions, REQUEST_CODE);
    }

    @Override
    protected void onResume() {
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }


        super.onResume();
    }

    @Override
    public void onPictureTaken(byte[] data, Camera camera) {
        saveImage(data);
        resetCamera();

    }
    private void saveImage(byte[] bytes) {
        FileOutputStream outStream;
        try {
            String fileName = "TUTORIALWING_" + System.currentTimeMillis() + ".jpg";
            File file = new File(Environment.getExternalStorageDirectory(), fileName);
            outStream = new FileOutputStream(file);
            outStream.write(bytes);
            outStream.close();
            Toast.makeText(TakeImageCameraActivitynew.this, "Picture Saved: " + fileName, Toast.LENGTH_LONG).show();




        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void surfaceCreated(@NonNull SurfaceHolder holder) {
        startCamera();

    }

    @Override
    public void surfaceChanged(@NonNull SurfaceHolder holder, int format, int width, int height) {
        resetCamera();

    }

    @Override
    public void surfaceDestroyed(@NonNull SurfaceHolder holder) {
        releaseCamera();

    }
    private void releaseCamera() {
        if (camera != null) {
            camera.stopPreview();
            camera.release();
            camera = null;
        }
    }

}