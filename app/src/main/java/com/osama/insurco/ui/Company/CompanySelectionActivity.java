package com.osama.insurco.ui.Company;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.osama.insurco.R;
import com.osama.insurco.ui.Auth.VirficationActivity;
import com.osama.insurco.ui.Order.Adapter.RecyclerView_company;
import com.osama.insurco.ui.Order.Adapter.RecyclerView_order;
import com.osama.insurco.ui.Order.OrderActivity;

public class CompanySelectionActivity extends AppCompatActivity {
RecyclerView all_company;
ImageView back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_company_selection);
        getSupportActionBar().hide();
        back = findViewById(R.id.back);

        all_company=findViewById(R.id.all_company);
// finally change the color
        getWindow().setStatusBarColor(ContextCompat.getColor(CompanySelectionActivity.this, R.color.purple_200));
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        LinearLayoutManager layoutManager1
                = new LinearLayoutManager(CompanySelectionActivity.this, LinearLayoutManager.VERTICAL, false);
        all_company.setLayoutManager(layoutManager1);

        all_company.setAdapter(new RecyclerView_company(CompanySelectionActivity.this, OrderActivity.ordier.getCompany()));




    }
}