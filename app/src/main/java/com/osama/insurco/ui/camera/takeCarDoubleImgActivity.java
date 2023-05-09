package com.osama.insurco.ui.camera;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.osama.insurco.R;
import com.osama.insurco.Settings.BaseActivity;
import com.osama.insurco.ui.Order.NewOrderActivity;
import com.wildma.idcardcamera.camera.IDCardCamera;

import java.io.File;

import cz.msebera.android.httpclient.util.TextUtils;

public class takeCarDoubleImgActivity extends BaseActivity {
    TextView next;
    TextView front_txt;
    TextView secand_txt;
    ImageView front_img;
    ImageView bavk_img;
    ImageView left_side;
    ImageView right_side;
    ImageView back;
    static String type_front_or_back = "";


    File file_front = null;
    File file_back = null;
    File file_left = null;
    File file_right = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_take_double_img2);

        getSupportActionBar().hide();


        next = findViewById(R.id.next);
        right_side = findViewById(R.id.right_side);
        left_side = findViewById(R.id.left_side);
        front_img = findViewById(R.id.front_img);
        bavk_img = findViewById(R.id.bavk_img);
        back = findViewById(R.id.back);
        front_txt = findViewById(R.id.front_txt);
        secand_txt = findViewById(R.id.secand_txt);

        front_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                type_front_or_back = "front";

                com.github.dhaval2404.imagepicker.ImagePicker.Builder builder = new com.github.dhaval2404.imagepicker.ImagePicker.Builder(takeCarDoubleImgActivity.this);
                builder.crop()                    //Crop image(Optional), Check Customization for more option
                        .compress(1024)            //Final image size will be less than 1 MB(Optional)
                        .start();
            }
        });
        left_side.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                type_front_or_back = "left_side";

                com.github.dhaval2404.imagepicker.ImagePicker.Builder builder = new com.github.dhaval2404.imagepicker.ImagePicker.Builder(takeCarDoubleImgActivity.this);
                builder.crop()                    //Crop image(Optional), Check Customization for more option
                        .compress(1024)            //Final image size will be less than 1 MB(Optional)
                        .start();
            }

        });
        right_side.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                type_front_or_back = "right_side";

                com.github.dhaval2404.imagepicker.ImagePicker.Builder builder = new com.github.dhaval2404.imagepicker.ImagePicker.Builder(takeCarDoubleImgActivity.this);
                builder.crop()                    //Crop image(Optional), Check Customization for more option
                        .compress(1024)            //Final image size will be less than 1 MB(Optional)
                        .start();
            }
        });
        bavk_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                type_front_or_back = "back";

                com.github.dhaval2404.imagepicker.ImagePicker.Builder builder = new com.github.dhaval2404.imagepicker.ImagePicker.Builder(takeCarDoubleImgActivity.this);
                builder.crop()                    //Crop image(Optional), Check Customization for more option
                        .compress(1024)            //Final image size will be less than 1 MB(Optional)
                        .start();
            }
        });
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (file_front == null | file_back == null) {

                    if (file_front == null) {
                        front_txt.setError(getResources().getString(R.string.required));
                    }
                    if (file_back == null) {
                        secand_txt.setError(getResources().getString(R.string.required));
                    }


                } else {


                    NewOrderActivity.save_img_4(file_front, file_back, file_left, file_right);
                    finish();

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
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {

        if (resultCode == Activity.RESULT_OK) {


            Uri uri = data.getData();


            if (uri != null) {
//                SignUpFragment.get_image(uri);

                File file = new File(uri.getPath());
                Bitmap myBitmap = BitmapFactory.decodeFile(file.getAbsolutePath());

                if (type_front_or_back.equals("front")) {
                    file_front = file;
                    front_img.setImageBitmap(myBitmap);
                } else if (type_front_or_back.equals("left_side")) {
                    file_left = file;
                    left_side.setImageBitmap(myBitmap);
                } else if (type_front_or_back.equals("right_side")) {
                    file_right = file;
                    right_side.setImageBitmap(myBitmap);
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
        super.onActivityResult(requestCode, resultCode, data);
    }


}