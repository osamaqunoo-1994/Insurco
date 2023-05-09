package com.osama.insurco.ui.Main;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.android.volley.NetworkResponse;
import com.android.volley.VolleyError;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.orhanobut.hawk.Hawk;
import com.osama.insurco.Modules.AdsModules;
import com.osama.insurco.Modules.MotoTypeInsuranceModules;
import com.osama.insurco.R;
import com.osama.insurco.Settings.WebService;
import com.osama.insurco.api.IResult;
import com.osama.insurco.api.VolleyService;
import com.osama.insurco.ui.Main.adapter.RecyclerView_car_ins;
import com.osama.insurco.ui.Main.adapter.RecyclerView_health_ins;
import com.osama.insurco.ui.splash.Adapter.viewPager_Adapter_slider;
import com.osama.insurco.ui.splash.WelcomeActivity;

import org.json.JSONObject;

public class DetailsInsuranceActivity extends AppCompatActivity {
    String from = "";
    IResult mResultCallback;
    RecyclerView all_insurance;
    ImageView back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_insurance);


        getSupportActionBar().hide();


// finally change the color
        getWindow().setStatusBarColor(ContextCompat.getColor(DetailsInsuranceActivity.this, R.color.purple_200));

        all_insurance = findViewById(R.id.all_insurance);
        back = findViewById(R.id.back);

        all_insurance.setLayoutManager(new GridLayoutManager(this, 2));

        try {

            from = getIntent().getStringExtra("from");


            init_volley();
            WebService.loading(DetailsInsuranceActivity.this, true);
            VolleyService mVolleyService = new VolleyService(mResultCallback, DetailsInsuranceActivity.this);


            if (from.equals("Motor")) {
                mVolleyService.getDataVolley("getMotoTypeInsurance", WebService.getMotoTypeInsurance);//category/1/product

            } else if (from.equals("Health")) {
                mVolleyService.getDataVolley("getHelthTypeInsurance", WebService.getHelthTypeInsurance);//category/1/product

            }

        } catch (Exception e) {

        }

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    public void init_volley() {

        mResultCallback = new IResult() {
            @Override
            public void notifySuccess(String requestType, JSONObject response) {
                Log.d("TAG", "Volley requester " + requestType);
                Log.d("TAG", "Volley JSON post" + response);
                //{"status":true,"code":200,"message":"User Profile","data"
                WebService.loading(DetailsInsuranceActivity.this, false);

                try {
                    boolean status = response.getBoolean("status");
                    if (status) {


                        if (requestType.equals("getMotoTypeInsurance")) {

//

//                            Hawk.put("Ads", response.toString() + "");
//
                            JsonParser parser = new JsonParser();
                            JsonElement mJson = parser.parse(response.toString());

                            Gson gson = new Gson();
                            MotoTypeInsuranceModules motoTypeInsuranceModules = gson.fromJson(mJson, MotoTypeInsuranceModules.class);
//
//

                            all_insurance.setAdapter(new RecyclerView_car_ins(DetailsInsuranceActivity.this, motoTypeInsuranceModules.getInsurancesTypes()));


//                            viewPager.setAdapter(new viewPager_Adapter_slider(WelcomeActivity.this, allDiscountModules.getAds()));
//
//                            view_pager_indicator.setupWithViewPager(viewPager);


//                            all_discount.setAdapter(new RecyclerView_all_discounts(AllCardsActivity.this, allDiscountModules.getResult()));
//                            cards_rec.setAdapter(new RecyclerView_card_home(getContext(), homeModule.getResult().getCategories()));
//                            Discounts_rec.setAdapter(new RecyclerView_discounts_home(getContext(), homeModule.getResult().getDiscounts()));
//                            Intent intent = new Intent(VirficationActivity.this, MainActivity.class);
//                        intent.putExtra("mobile", mobile.getText().toString());
//                            startActivity(intent);
                        } else {

                            JsonParser parser = new JsonParser();
                            JsonElement mJson = parser.parse(response.toString());

                            Gson gson = new Gson();
                            MotoTypeInsuranceModules motoTypeInsuranceModules = gson.fromJson(mJson, MotoTypeInsuranceModules.class);
//
//

                            all_insurance.setAdapter(new RecyclerView_health_ins(DetailsInsuranceActivity.this, motoTypeInsuranceModules.getInsurancesTypes()));


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

                        WebService.Make_Toast_color(DetailsInsuranceActivity.this, message, "error");

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
                WebService.loading(DetailsInsuranceActivity.this, false);

                try {
//                    btn_id.stopAnimation();
//                    btn_id.revertAnimation();

                    NetworkResponse response = error.networkResponse;
                    String response_data = new String(response.data);

                    JSONObject jsonObject = new JSONObject(response_data);

                    String message = jsonObject.getString("message");


                    WebService.Make_Toast_color(DetailsInsuranceActivity.this, message, "error");

                    Log.e("error response", response_data);

                } catch (Exception e) {

                }


            }

            @Override
            public void notify_Async_Error(String requestType, String error) {
//                loading.setVisibility(View.GONE);
                WebService.loading(DetailsInsuranceActivity.this, false);

            }
        };


    }

}