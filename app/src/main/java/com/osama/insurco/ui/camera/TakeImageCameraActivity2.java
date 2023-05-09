package com.osama.insurco.ui.camera;

import static android.provider.MediaStore.Files.FileColumns.MEDIA_TYPE_IMAGE;
import static android.provider.MediaStore.Files.FileColumns.MEDIA_TYPE_VIDEO;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.LinearLayoutCompat;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.osama.insurco.R;
import com.osama.insurco.Settings.BaseActivity;
import com.osama.insurco.ui.Order.NewOrderActivity;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import de.markusfisch.android.cameraview.widget.CameraView;


public class TakeImageCameraActivity2 extends BaseActivity implements SurfaceHolder.Callback {

    Camera mCamera;
    FloatingActionButton capture;
    SurfaceView mPreview;
    ImageView front_image;
    ImageView back_image;

    TextView next;


    File img_front = null;
    File img_back = null;

    String type_img = "1";
    LinearLayoutCompat foucase;
    View image_co;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_take_image_camera2);

        mPreview = (SurfaceView) findViewById(R.id.preview);
        capture = findViewById(R.id.capture);
        foucase = findViewById(R.id.foucase);
        next = findViewById(R.id.next);
        back_image = findViewById(R.id.back_image);
        front_image = findViewById(R.id.front_image);
        image_co = findViewById(R.id.image_co);
        mPreview.getHolder().addCallback(this);
        mPreview.getHolder().setType(SurfaceHolder.SURFACE_TYPE_PUSH_BUFFERS);
        mCamera = Camera.open();






        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                takeDoubleImgActivity.save_img(img_front);

                finish();

            }
        });
        mCamera.setErrorCallback(new Camera.ErrorCallback() {
            @Override
            public void onError(int error, Camera camera) {


                Toast.makeText(TakeImageCameraActivity2.this, "خطا في الكاميرا الصلاحية ", Toast.LENGTH_LONG).show();
//                throw new IllegalStateException("Camera error code: " + error);
            }
        });
        foucase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
                Camera.AutoFocusCallback myAutoFocusCallback = new Camera.AutoFocusCallback() {

                    @Override
                    public void onAutoFocus(boolean arg0, Camera arg1) {
                        System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$11");


                    }
                };
                mCamera.autoFocus(myAutoFocusCallback);


            }
        });


        capture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                try {
//                    mCamera.setPreviewDisplay(mPreview.getHolder());
//                } catch (IOException e) {
//                    throw new RuntimeException(e);
//                }
//                mCamera.startPreview();
//                capture.setVisibility(View.GONE);
//                mCamera.takePicture(null, null, new Camera.PictureCallback() {
//                    @Override
//                    public void onPictureTaken(byte[] data, Camera camera) {
//
//
//                        System.out.println("7837843784738478347");
//                    }
//                });

                Camera.PictureCallback jpegCallback = new Camera.PictureCallback() {
                    public void onPictureTaken(final byte[] data, final Camera camera) {

                        Log.d("TAG", "onPictureTaken: ");
//                        pictureTakenCallBack.saveAsBitmap(data);
                    }
                };
                Camera.ShutterCallback shutterCallback = new Camera.ShutterCallback() {
                    public void onShutter() {
                        Log.d("TAG", "onShutter: ");
                    }
                };


                mCamera.takePicture(shutterCallback,jpegCallback, jpegCallback);



            }
        });

    }

    @Override
    public void onPause() {
        super.onPause();
        mCamera.stopPreview();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mCamera.release();
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

        System.out.println("989889899889");
        Camera.Parameters parameters = mCamera.getParameters();
        List<Camera.Size> previewSizes = parameters.getSupportedPreviewSizes();
        Camera.Size previewSize = previewSizes.get(0); //480h x 720w

        parameters.setPreviewSize(previewSize.width, previewSize.height);
//        parameters.setFlashMode(Camera.Parameters.FLASH_MODE_AUTO);
//        parameters.setFocusMode(Camera.Parameters.FOCUS_MODE_AUTO);
        mCamera.setParameters(parameters);


        Display display = ((WindowManager) getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay();
        if (display.getRotation() == Surface.ROTATION_0) {
            mCamera.setDisplayOrientation(90);
        } else if (display.getRotation() == Surface.ROTATION_270) {
            mCamera.setDisplayOrientation(180);
        }

        mCamera.startPreview();

    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        try {
            mCamera.setPreviewDisplay(mPreview.getHolder());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        System.out.println("PREVIEW" + "surfaceDestroyed");
    }

    private Camera.PictureCallback mPicture = new Camera.PictureCallback() {

        @Override
        public void onPictureTaken(byte[] data, Camera camera) {


            System.out.println("***********************");

//            SavePhotoTask(data);

            try {
                String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
                File f = new File(getApplicationContext().getCacheDir(), "IMG_" + timeStamp + ".jpg");
                f.createNewFile();
                FileOutputStream fos = new FileOutputStream(f);


                fos.write(data);
                fos.flush();
                fos.close();


                int[] location = new int[2];
                image_co.getLocationOnScreen(location);
                int x = location[0];
                int y = location[1];

                DisplayMetrics displayMetrics = new DisplayMetrics();
                getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
                int height = displayMetrics.heightPixels;
                int width = displayMetrics.widthPixels;


                System.out.println("x_location" + x);
//                System.out.println("height_location"+height);
//                System.out.println("width_location"+width);
                System.out.println("y_location" + y);
                System.out.println("getMeasuredWidth" + image_co.getMeasuredWidth());
                System.out.println("getMeasuredHeight" + image_co.getMeasuredHeight());

//                BitmapFactory.Options options = new BitmapFactory.Options();
//                options.inDither = false;
//                options.inPreferredConfig = Bitmap.Config.ARGB_8888;
//
//                Bitmap image = BitmapFactory.decodeByteArray(data, 0, data.length, options);

                Matrix matrix = new Matrix();

                matrix.postRotate(90);
                Bitmap bitmap = BitmapFactory.decodeFile(f.getPath());

                System.out.println("bitmap.getWidth()" + bitmap.getWidth());
                System.out.println("bitmap.getHeight()" + bitmap.getHeight());

                Bitmap bitmapfil = Bitmap.createBitmap(bitmap, bitmap.getWidth() / 3, 90, (int) ((bitmap.getWidth() / 3)), bitmap.getHeight() - 180, matrix, true);

//                Bitmap newBitmap = Bitmap.createBitmap(bitmapfil,
//                        x,
//                        y,
//                        width,
//                        image_co.getMeasuredHeight());


                File file = f;
                OutputStream os = new BufferedOutputStream(new FileOutputStream(file));
                bitmapfil.compress(Bitmap.CompressFormat.JPEG, 75, os);
                os.close();


                img_front = f;
                capture.setVisibility(View.GONE);
                next.setVisibility(View.VISIBLE);
//                if (type_img.equals("1")) {
//                    type_img = "2";
//                    front_image.setImageBitmap(newBitmap);
////                    mCamera.startPreview();
//
//                } else {
//                    img_back = f;
//                    back_image.setImageBitmap(newBitmap);
//                    capture.setVisibility(View.GONE);
//                    next.setVisibility(View.VISIBLE);
//
//
//                }


            } catch (IOException e) {
                e.printStackTrace();
            }


//            File pictureFile = getOutputMediaFile(1);
//            if (pictureFile == null){
//                Log.d("TAG", "Error creating media file, check storage permissions");
//                return;
//            }
//
//            try {
//                String filePath = pictureFile.getPath();
//                Bitmap bitmap = BitmapFactory.decodeFile(filePath);
//                front_image.setImageBitmap(bitmap);
//
//
//                FileOutputStream fos = new FileOutputStream(pictureFile);
//                fos.write(data);
//                fos.close();
//            } catch (FileNotFoundException e) {
//                Log.d("TAG", "File not found: " + e.getMessage());
//            } catch (IOException e) {
//                Log.d("TAG", "Error accessing file: " + e.getMessage());
//            }
        }
    };

    private static Uri getOutputMediaFileUri(int type) {
        return Uri.fromFile(getOutputMediaFile(type));
    }

    /**
     * Create a File for saving an image or video
     */
    private static File getOutputMediaFile(int type) {
        // To be safe, you should check that the SDCard is mounted
        // using Environment.getExternalStorageState() before doing this.

        File mediaStorageDir = new File(Environment.getExternalStoragePublicDirectory(
                Environment.DIRECTORY_PICTURES), "MyCameraApp");
        // This location works best if you want the created images to be shared
        // between applications and persist after your app has been uninstalled.

        // Create the storage directory if it does not exist
        if (!mediaStorageDir.exists()) {
            if (!mediaStorageDir.mkdirs()) {
                Log.d("MyCameraApp", "failed to create directory");
                return null;
            }
        }

        // Create a media file name
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        File mediaFile;
        if (type == 1) {
            mediaFile = new File(mediaStorageDir.getPath() + File.separator +
                    "IMG_" + timeStamp + ".jpg");
        } else if (type == MEDIA_TYPE_VIDEO) {
            mediaFile = new File(mediaStorageDir.getPath() + File.separator +
                    "VID_" + timeStamp + ".mp4");
        } else {
            return null;
        }

        return mediaFile;
    }

    public void SavePhotoTask(byte[] jpeg) {
        File imagesFolder = new File(Environment.getExternalStorageDirectory(), "msApp");
        imagesFolder.mkdirs();

        final File photo = new File(imagesFolder, "Yourimagename.jpg");
        try {
            FileOutputStream fos = new FileOutputStream(photo.getPath());
            fos.write(jpeg);
            fos.close();
        } catch (Exception e) {
            System.out.println("4rererere" + e.getMessage());
        }
    }

}