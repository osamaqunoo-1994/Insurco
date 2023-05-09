package com.osama.insurco.ui.camera;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.osama.insurco.R;
import com.osama.insurco.Settings.BaseActivity;
import com.osama.insurco.ui.Order.NewOrderActivity;
import com.osama.insurco.ui.Order.NewOrderHelthActivity;
import com.wildma.idcardcamera.camera.IDCardCamera;

import java.io.File;

import cz.msebera.android.httpclient.util.TextUtils;

public class takeDoubleImgHActivity extends BaseActivity {
    TextView next;
    static ImageView front_img;
    static ImageView bavk_img;
    ImageView back;
    static String type_front_or_back = "";


    static File file_front = null;
    static File file_back = null;

    static Activity activity;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_take_double_img);

        getSupportActionBar().hide();

        activity = this;
        next = findViewById(R.id.next);
        front_img = findViewById(R.id.front_img);
        bavk_img = findViewById(R.id.bavk_img);
        back = findViewById(R.id.back);

        front_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                type_front_or_back = "front";

                if (ContextCompat.checkSelfPermission(takeDoubleImgHActivity.this, Manifest.permission.CAMERA)
                        != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(takeDoubleImgHActivity.this, new String[]{Manifest.permission.CAMERA}, 10);

                    // Permission is not granted
                } else {
                    com.github.dhaval2404.imagepicker.ImagePicker.Builder builder = new com.github.dhaval2404.imagepicker.ImagePicker.Builder(takeDoubleImgHActivity.this);
                    builder.crop()
                            .cameraOnly()	//User can only capture image using Camera
                            .compress(1024)            //Final image size will be less than 1 MB(Optional)
                            .start();
//                    startActivity(new Intent(takeDoubleImgHActivity.this, TakeImageCameraActivity3.class));
                }

//                IDCardCamera.create(takeDoubleImgActivity.this).openCamera(IDCardCamera.TYPE_IDCARD_BACK);
            }
        });
        bavk_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                type_front_or_back = "back";

                if (ContextCompat.checkSelfPermission(takeDoubleImgHActivity.this, Manifest.permission.CAMERA)
                        != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(takeDoubleImgHActivity.this, new String[]{Manifest.permission.CAMERA}, 10);

                    // Permission is not granted
                } else {
                    com.github.dhaval2404.imagepicker.ImagePicker.Builder builder = new com.github.dhaval2404.imagepicker.ImagePicker.Builder(takeDoubleImgHActivity.this);
                    builder.crop()
                            .cameraOnly()	//User can only capture image using Camera
                            .compress(1024)            //Final image size will be less than 1 MB(Optional)
                            .start();
//                    startActivity(new Intent(takeDoubleImgHActivity.this, TakeImageCameraActivity3.class));
                }
//                IDCardCamera.create(takeDoubleImgActivity.this).openCamera(IDCardCamera.TYPE_IDCARD_BACK);
            }
        });


        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (file_front != null && file_back != null) {
                    NewOrderHelthActivity.save_img(file_front, file_back);
                    finish();
                } else {

                }
            }
        });


        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == Activity.RESULT_OK) {


            Uri uri = data.getData();


            if (uri != null) {
//                SignUpFragment.get_image(uri);

                File file = new File(uri.getPath());
                Bitmap myBitmap = BitmapFactory.decodeFile(file.getAbsolutePath());

                if (type_front_or_back.equals("front")) {
                    file_front = file;
                    front_img.setImageBitmap(myBitmap);
                } else if (type_front_or_back.equals("back")) {
                    file_back = file;
                    bavk_img.setImageBitmap(myBitmap);
                }


//                ownership.setImageDrawable(getResources().getDrawable(R.drawable.ic_baseline_check_circle_111));
//                Emirate_ID.setImageDrawable(getResources().getDrawable(R.drawable.ic_baseline_check_circle_111));
//                Driver_License.setImageDrawable(getResources().getDrawable(R.drawable.ic_baseline_check_circle_111));
//                    Bitmap myBitmap = BitmapFactory.decodeFile(file.getAbsolutePath());
//                    imagex.setImageBitmap(myBitmap);
            }


        }
//        if (resultCode == IDCardCamera.RESULT_CODE) {
//            //获取图片路径，显示图片
//            final String path = IDCardCamera.getImagePath(data);
//            if (!TextUtils.isEmpty(path)) {
//
//                if (type_front_or_back.equals("front")) {
//
//
//                    file_front = new File(path);
//
//                    if (requestCode == IDCardCamera.TYPE_IDCARD_FRONT) { //身份证正面
//                        front_img.setImageBitmap(BitmapFactory.decodeFile(path));
//                    } else if (requestCode == IDCardCamera.TYPE_IDCARD_BACK) {  //身份证反面
//                        front_img.setImageBitmap(BitmapFactory.decodeFile(path));
//                    }
//                } else {
//                    file_back = new File(path);
//
//                    if (requestCode == IDCardCamera.TYPE_IDCARD_FRONT) { //身份证正面
//                        bavk_img.setImageBitmap(BitmapFactory.decodeFile(path));
//                    } else if (requestCode == IDCardCamera.TYPE_IDCARD_BACK) {  //身份证反面
//                        bavk_img.setImageBitmap(BitmapFactory.decodeFile(path));
//                    }
//                }
//
//            }
//        }
        super.onActivityResult(requestCode, resultCode, data);

    }

    public static void save_img(File front_file) {

        if (type_front_or_back.equals("front")) {

            file_front = front_file;

//            if (requestCode == IDCardCamera.TYPE_IDCARD_FRONT) { //身份证正面
//                front_img.setImageBitmap(BitmapFactory.decodeFile(path));
//            } else if (requestCode == IDCardCamera.TYPE_IDCARD_BACK) {  //身份证反面
//                front_img.setImageBitmap(BitmapFactory.decodeFile(path));
//            }

            front_img.setImageBitmap(BitmapFactory.decodeFile(file_front.getPath()));

//            front_img.setImageDrawable(activity.getResources().getDrawable(R.drawable.ic_baseline_check_circle_111));

        } else {

            file_back = front_file;


            bavk_img.setImageBitmap(BitmapFactory.decodeFile(file_front.getPath()));


        }

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (ContextCompat.checkSelfPermission(takeDoubleImgHActivity.this, Manifest.permission.CAMERA)
                != PackageManager.PERMISSION_GRANTED) {


            // Permission is not granted
        } else {
            com.github.dhaval2404.imagepicker.ImagePicker.Builder builder = new com.github.dhaval2404.imagepicker.ImagePicker.Builder(takeDoubleImgHActivity.this);
            builder.crop()
                    .cameraOnly()	//User can only capture image using Camera
                    .compress(1024)            //Final image size will be less than 1 MB(Optional)
                    .start();
//            startActivity(new Intent(takeDoubleImgHActivity.this, TakeImageCameraActivity3.class));
        }
    }
}