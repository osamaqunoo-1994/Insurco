package com.osama.insurco.ui.StaticsPages;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.android.volley.NetworkResponse;
import com.android.volley.VolleyError;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.orhanobut.hawk.Hawk;
import com.osama.insurco.Modules.FaqsModules;
import com.osama.insurco.R;
import com.osama.insurco.Settings.WebService;
import com.osama.insurco.api.IResult;
import com.osama.insurco.api.VolleyService;
import com.osama.insurco.ui.StaticsPages.adapter.RecyclerView_faqs;
import com.osama.insurco.ui.splash.SplashActivity;
import com.osama.insurco.ui.splash.WelcomeActivity;

import org.json.JSONObject;

public class FaqsActivity extends AppCompatActivity {
    ImageView back;
    RecyclerView list_faq;
    IResult mResultCallback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faqs);

        getSupportActionBar().hide();

        back = findViewById(R.id.back);
        list_faq = findViewById(R.id.list_faq);
// finally change the color
        getWindow().setStatusBarColor(ContextCompat.getColor(FaqsActivity.this, R.color.purple_200));


        LinearLayoutManager layoutManager1
                = new LinearLayoutManager(FaqsActivity.this, LinearLayoutManager.VERTICAL, false);
        list_faq.setLayoutManager(layoutManager1);


        try {


            init_volley();

            VolleyService mVolleyService = new VolleyService(mResultCallback, FaqsActivity.this);
            WebService.loading(FaqsActivity.this, true);
            mVolleyService.getDataVolley("getFaqs", WebService.getFaqs);//category/1/product


        } catch (Exception e) {

        }


        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
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
                WebService.loading(FaqsActivity.this, false);

                //{"status":true,"code":200,"message":"User Profile","data"
                try {
                    boolean status = response.getBoolean("status");
                    if (status) {


                        if (requestType.equals("getFaqs")) {


                            JsonParser parser = new JsonParser();
                            JsonElement mJson = parser.parse(response.toString());

                            Gson gson = new Gson();
                            FaqsModules faqsModules = gson.fromJson(mJson, FaqsModules.class);


                            list_faq.setAdapter(new RecyclerView_faqs(FaqsActivity.this, faqsModules.getFaqs()));

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

                        WebService.Make_Toast_color(FaqsActivity.this, message, "error");

                    }


                } catch (Exception e) {
                    e.printStackTrace();
                }


            }


            @Override
            public void notifyError(String requestType, VolleyError error) {
                Log.d("TAG", "Volley requester " + requestType);
                Log.d("TAG", "Volley JSON post" + "That didn't work!" + error.getMessage());
                WebService.loading(FaqsActivity.this, false);

                try {
//                    btn_id.stopAnimation();
//                    btn_id.revertAnimation();

                    NetworkResponse response = error.networkResponse;
                    String response_data = new String(response.data);

                    JSONObject jsonObject = new JSONObject(response_data);

                    String message = jsonObject.getString("message");


                    WebService.Make_Toast_color(FaqsActivity.this, message, "error");

                    Log.e("error response", response_data);

                } catch (Exception e) {

                }


            }

            @Override
            public void notify_Async_Error(String requestType, String error) {
                WebService.loading(FaqsActivity.this, false);

            }
        };


    }

}