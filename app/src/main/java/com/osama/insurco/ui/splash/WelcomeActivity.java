package com.osama.insurco.ui.splash;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.ProgressBar;

import com.android.volley.NetworkResponse;
import com.android.volley.VolleyError;
import com.github.vivchar.viewpagerindicator.ViewPagerIndicator;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.orhanobut.hawk.Hawk;
import com.osama.insurco.Modules.AdsModules;
import com.osama.insurco.Modules.Slider;
import com.osama.insurco.R;
import com.osama.insurco.Settings.BaseActivity;
import com.osama.insurco.Settings.WebService;
import com.osama.insurco.api.IResult;
import com.osama.insurco.api.VolleyService;
import com.osama.insurco.ui.Auth.LoginActivity;
import com.osama.insurco.ui.Main.MainActivity;
import com.osama.insurco.ui.splash.Adapter.viewPager_Adapter_slider;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class WelcomeActivity extends BaseActivity {
    LinearLayout skip;
    ViewPager viewPager;
    IResult mResultCallback;

    ViewPagerIndicator view_pager_indicator;
    ProgressBar loading;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

//        if(LocaleUtil.isRTL()) viewPager.setRotationY(180);
        skip = findViewById(R.id.skip);
        viewPager = findViewById(R.id.viewPager);
        view_pager_indicator = findViewById(R.id.view_pager_indicator);
        loading = findViewById(R.id.loading);


//        if(LocaleUtil.isRTL()) rootView.setRotationY(180);
        getSupportActionBar().hide();

        getSupportActionBar().hide();


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (skip != null) {
                skip.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
            }
        }

// finally change the color
        getWindow().setStatusBarColor(ContextCompat.getColor(WelcomeActivity.this, R.color.white));


// finally change the color
        skip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


//                if (Hawk.contains("lang")) {
//                    Intent intent = new Intent(WelcomeActivity.this, MainActivity.class);
//                    intent.putExtra("from", "welcome");
//                    startActivity(intent);
//                } else {
//
//                }

                Intent intent = new Intent(WelcomeActivity.this, MainActivity.class);
                intent.putExtra("from", "welcome");
                startActivity(intent);
            }
        });


        try {
            List<AdsModules.Ad> ads = new ArrayList<>();


            ads.add(null);
            ads.add(null);
            ads.add(null);

            viewPager.setAdapter(new viewPager_Adapter_slider(WelcomeActivity.this, ads));

            view_pager_indicator.setupWithViewPager(viewPager);


            init_volley();

            VolleyService mVolleyService = new VolleyService(mResultCallback, WelcomeActivity.this);

            mVolleyService.getDataVolley("getAds", WebService.getAds);//category/1/product


        } catch (Exception e) {

        }


    }

    public void init_volley() {

        mResultCallback = new IResult() {
            @Override
            public void notifySuccess(String requestType, JSONObject response) {
                Log.d("TAG", "Volley requester " + requestType);
                Log.d("TAG", "Volley JSON post" + response);
                loading.setVisibility(View.GONE);
                //{"status":true,"code":200,"message":"User Profile","data"
                try {
                    boolean status = response.getBoolean("status");
                    if (status) {


                        if (requestType.equals("getAds")) {

//

                            Hawk.put("Ads", response.toString() + "");

                            JsonParser parser = new JsonParser();
                            JsonElement mJson = parser.parse(response.toString());

                            Gson gson = new Gson();
                            AdsModules allDiscountModules = gson.fromJson(mJson, AdsModules.class);


                            System.out.println(allDiscountModules.getAds().size() + "yuuyyuyuuyyuyu");

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

                        WebService.Make_Toast_color(WelcomeActivity.this, message, "error");

                    }


                } catch (Exception e) {
                    e.printStackTrace();
                }


            }


            @Override
            public void notifyError(String requestType, VolleyError error) {
                Log.d("TAG", "Volley requester " + requestType);
                Log.d("TAG", "Volley JSON post" + "That didn't work!" + error.getMessage());
                loading.setVisibility(View.GONE);

                try {
//                    btn_id.stopAnimation();
//                    btn_id.revertAnimation();

                    NetworkResponse response = error.networkResponse;
                    String response_data = new String(response.data);

                    JSONObject jsonObject = new JSONObject(response_data);

                    String message = jsonObject.getString("message");


                    WebService.Make_Toast_color(WelcomeActivity.this, message, "error");

                    Log.e("error response", response_data);

                } catch (Exception e) {

                }


            }

            @Override
            public void notify_Async_Error(String requestType, String error) {
                loading.setVisibility(View.GONE);

            }
        };


    }

}