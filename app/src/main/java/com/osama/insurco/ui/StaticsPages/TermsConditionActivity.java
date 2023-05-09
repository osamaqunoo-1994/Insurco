package com.osama.insurco.ui.StaticsPages;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.osama.insurco.R;
import com.osama.insurco.Settings.Settings;

public class TermsConditionActivity extends AppCompatActivity {
    TextView details;
    ImageView back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_terms_condition);
        getSupportActionBar().hide();
// finally change the color
        getWindow().setStatusBarColor(ContextCompat.getColor(TermsConditionActivity.this, R.color.purple_200));


        details = findViewById(R.id.details);
        back = findViewById(R.id.back);


        try {

            details.setText(Settings.getSettings().getSettings().getTermsConditions().getDescription().toString() + "");

        } catch (Exception e) {

        }
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });


    }
}