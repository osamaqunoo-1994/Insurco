package com.osama.insurco.ui.camera;

import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.osama.insurco.R;
import com.osama.insurco.Settings.BaseActivity;
import com.osama.insurco.ui.Order.NewOrderActivity;
import com.osama.insurco.ui.Order.NewOrderHelthActivity;
import com.wildma.idcardcamera.camera.IDCardCamera;

import java.io.File;

import cz.msebera.android.httpclient.util.TextUtils;

public class takeDoubleImgHelathActivity extends BaseActivity {
    TextView next;
    ImageView front_img;
    ImageView bavk_img;
    ImageView back;
    static String type_front_or_back = "";


    File file_front = null;
    File file_back = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_take_double_img);

        getSupportActionBar().hide();


        next = findViewById(R.id.next);
        front_img = findViewById(R.id.front_img);
        bavk_img = findViewById(R.id.bavk_img);
        back = findViewById(R.id.back);

        front_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                type_front_or_back = "front";

                IDCardCamera.create(takeDoubleImgHelathActivity.this).openCamera(IDCardCamera.TYPE_IDCARD_BACK);
            }
        });
        bavk_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                type_front_or_back = "back";

                IDCardCamera.create(takeDoubleImgHelathActivity.this).openCamera(IDCardCamera.TYPE_IDCARD_BACK);
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
        if (resultCode == IDCardCamera.RESULT_CODE) {
            //获取图片路径，显示图片
            final String path = IDCardCamera.getImagePath(data);
            if (!TextUtils.isEmpty(path)) {

                if (type_front_or_back.equals("front")) {


                    file_front = new File(path);

                    if (requestCode == IDCardCamera.TYPE_IDCARD_FRONT) { //身份证正面
                        front_img.setImageBitmap(BitmapFactory.decodeFile(path));
                    } else if (requestCode == IDCardCamera.TYPE_IDCARD_BACK) {  //身份证反面
                        front_img.setImageBitmap(BitmapFactory.decodeFile(path));
                    }
                } else {
                    file_back = new File(path);

                    if (requestCode == IDCardCamera.TYPE_IDCARD_FRONT) { //身份证正面
                        bavk_img.setImageBitmap(BitmapFactory.decodeFile(path));
                    } else if (requestCode == IDCardCamera.TYPE_IDCARD_BACK) {  //身份证反面
                        bavk_img.setImageBitmap(BitmapFactory.decodeFile(path));
                    }
                }

            }
        }
        super.onActivityResult(requestCode, resultCode, data);

    }
}