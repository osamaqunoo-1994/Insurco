package com.osama.insurco.ui.Auth;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.osama.insurco.R;

public class VirficationActivity extends AppCompatActivity {
ImageView close;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_virfication);
        getSupportActionBar().hide();
        close=findViewById(R.id.close);

// finally change the color
        getWindow().setStatusBarColor(ContextCompat.getColor(VirficationActivity.this, R.color.purple_200));

        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}