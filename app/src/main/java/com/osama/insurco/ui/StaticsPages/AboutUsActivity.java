package com.osama.insurco.ui.StaticsPages;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.os.Bundle;

import com.osama.insurco.R;
import com.osama.insurco.ui.splash.WelcomeActivity;

public class AboutUsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);
        getSupportActionBar().hide();


// finally change the color
        getWindow().setStatusBarColor(ContextCompat.getColor(AboutUsActivity.this, R.color.purple_200));

    }
}