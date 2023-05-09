package com.osama.insurco.ui.Order;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.NetworkResponse;
import com.android.volley.VolleyError;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.orhanobut.hawk.Hawk;
import com.osama.insurco.Modules.MotoTypeInsuranceModules;
import com.osama.insurco.Modules.Orders;
import com.osama.insurco.R;
import com.osama.insurco.Settings.WebService;
import com.osama.insurco.api.IResult;
import com.osama.insurco.api.VolleyService;
import com.osama.insurco.ui.Company.CompanySelectionActivity;
import com.osama.insurco.ui.Main.DetailsInsuranceActivity;
import com.osama.insurco.ui.Main.adapter.RecyclerView_car_ins;
import com.osama.insurco.ui.Main.adapter.RecyclerView_health_ins;
import com.osama.insurco.ui.Order.Adapter.RecyclerView_order;
import com.osama.insurco.ui.Order.Adapter.RecyclerView_ordermator;
import com.osama.insurco.ui.StaticsPages.FaqsActivity;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class OrderActivity extends AppCompatActivity {
    ImageView back;
    IResult mResultCallback;
    RecyclerView all_ordermotor;
    RecyclerView all_orderhealth;

    static Orders orders_objext;

    public static Orders.Item ordier;
    public static Orders.Company_ ordier_company;

    TextView titlemotor;
    TextView title_health;
    TextView no_data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
        getSupportActionBar().hide();
        back = findViewById(R.id.back);
        all_orderhealth = findViewById(R.id.all_orderhealth);
        all_ordermotor = findViewById(R.id.all_ordermotor);
        titlemotor = findViewById(R.id.titlemotor);
        title_health = findViewById(R.id.title_health);
        no_data = findViewById(R.id.no_data);

// finally change the color
        getWindow().setStatusBarColor(ContextCompat.getColor(OrderActivity.this, R.color.purple_200));
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        LinearLayoutManager layoutManager1
                = new LinearLayoutManager(OrderActivity.this, LinearLayoutManager.VERTICAL, false);
        all_orderhealth.setLayoutManager(layoutManager1);


        LinearLayoutManager layoutManager2
                = new LinearLayoutManager(OrderActivity.this, LinearLayoutManager.VERTICAL, false);
        all_ordermotor.setLayoutManager(layoutManager2);


        try {


            if (Hawk.contains("Email")) {


                String email = Hawk.get("Email").toString();


                init_volley();
                WebService.loading(OrderActivity.this, true);
                VolleyService mVolleyService = new VolleyService(mResultCallback, OrderActivity.this);

                JSONObject jsonObject = new JSONObject();
                jsonObject.put("email", email);
//                jsonObject.put("form_type", "motor");

                mVolleyService.postDataVolley("returnInsuranceCompanies", WebService.returnInsuranceCompanies, jsonObject);//category/1/product

            } else {
                titlemotor.setVisibility(View.GONE);
                title_health.setVisibility(View.GONE);
                no_data.setVisibility(View.VISIBLE);

            }
        } catch (Exception e) {

        }


    }

    public void init_volley() {

        mResultCallback = new IResult() {
            @Override
            public void notifySuccess(String requestType, JSONObject response) {
                Log.d("TAG", "Volley requester " + requestType);
                Log.d("TAG", "Volley JSON post" + response);
                //{"status":true,"code":200,"message":"User Profile","data"
                WebService.loading(OrderActivity.this, false);

                try {
                    boolean status = response.getBoolean("status");
                    if (status) {


                        if (requestType.equals("returnInsuranceCompanies")) {

//

//                            Hawk.put("Ads", response.toString() + "");
//
                            JsonParser parser = new JsonParser();
                            JsonElement mJson = parser.parse(response.toString());

                            Gson gson = new Gson();
                            orders_objext = gson.fromJson(mJson, Orders.class);
//
//

                            all_orderhealth.setAdapter(new RecyclerView_order(OrderActivity.this, orders_objext.getHealth()));
                            all_ordermotor.setAdapter(new RecyclerView_ordermator(OrderActivity.this, orders_objext.getMotor()));


                            if (orders_objext.getMotor().size() == 0) {
                                titlemotor.setVisibility(View.GONE);
                            } else {
                                titlemotor.setVisibility(View.VISIBLE);

                            }

                            if (orders_objext.getHealth().size() == 0) {
                                title_health.setVisibility(View.GONE);
                            } else {
                                title_health.setVisibility(View.VISIBLE);

                            }
                            if (orders_objext.getHealth().size() == 0 & orders_objext.getMotor().size() == 0) {
                                no_data.setVisibility(View.VISIBLE);
                            } else {
                                no_data.setVisibility(View.GONE);

                            }

                            try {
//                                String gfg = getIntent().getStringExtra("from");
//                                if (gfg.toString().equals("url")) {
//                                    if (orders_objext.getItem().size() != 0) {
//
//
//                                        OrderActivity.ordier = orders_objext.getItem().get(0);
//
//                                        Intent intent = new Intent(OrderActivity.this, CompanySelectionActivity.class);
//                                        startActivity(intent);
//
//
//                                    }
//
//                                }

                            } catch (Exception e) {

                            }

//                            viewPager.setAdapter(new viewPager_Adapter_slider(WelcomeActivity.this, allDiscountModules.getAds()));
//
//                            view_pager_indicator.setupWithViewPager(viewPager);


//                            all_discount.setAdapter(new RecyclerView_all_discounts(AllCardsActivity.this, allDiscountModules.getResult()));
//                            cards_rec.setAdapter(new RecyclerView_card_home(getContext(), homeModule.getResult().getCategories()));
//                            Discounts_rec.setAdapter(new RecyclerView_discounts_home(getContext(), homeModule.getResult().getDiscounts()));
//                            Intent intent = new Intent(VirficationActivity.this, MainActivity.class);
//                        intent.putExtra("mobile", mobile.getText().toString());
//                            startActivity(intent);
                        }

//                        String user = response.getString("user");
//
//
//                        Hawk.put("user", user);
//                        String message = response.getString("message");
//                        WebService.Make_Toast_color(LoginActivity.this, message, "success");
//                        finish();
//
                    } else {
//                        btn_id.revertAnimation();
//                        {"status":false,"code":201,"message":"Please Enter True Mobile Number and Password"}
                        String message = response.getString("message");

                        WebService.Make_Toast_color(OrderActivity.this, message, "error");

                    }


                } catch (Exception e) {
                    e.printStackTrace();
                }


            }


            @Override
            public void notifyError(String requestType, VolleyError error) {
                Log.d("TAG", "Volley requester " + requestType);
                Log.d("TAG", "Volley JSON post" + "That didn't work!" + error.getMessage());
//                loading.setVisibility(View.GONE);
                WebService.loading(OrderActivity.this, false);

                try {
//                    btn_id.stopAnimation();
//                    btn_id.revertAnimation();

                    NetworkResponse response = error.networkResponse;
                    String response_data = new String(response.data);

                    JSONObject jsonObject = new JSONObject(response_data);

                    String message = jsonObject.getString("message");


                    WebService.Make_Toast_color(OrderActivity.this, message, "error");

                    Log.e("error response", response_data);

                } catch (Exception e) {

                }


            }

            @Override
            public void notify_Async_Error(String requestType, String error) {
//                loading.setVisibility(View.GONE);
                WebService.loading(OrderActivity.this, false);

            }
        };


    }

}