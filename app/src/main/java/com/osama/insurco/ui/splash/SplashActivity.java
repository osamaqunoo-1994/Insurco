package com.osama.insurco.ui.splash;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.animation.Animator;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.LocaleList;
import android.util.Log;

import com.airbnb.lottie.LottieAnimationView;
import com.android.volley.NetworkResponse;
import com.android.volley.VolleyError;
import com.orhanobut.hawk.Hawk;
import com.osama.insurco.R;
import com.osama.insurco.Settings.BaseActivity;
import com.osama.insurco.Settings.WebService;
import com.osama.insurco.api.IResult;
import com.osama.insurco.api.VolleyService;
import com.osama.insurco.ui.Order.OrderActivity;
import com.osama.insurco.ui.camera.TakeImageCameraActivity2;
import com.osama.insurco.ui.camera.TakeImageCameraActivitynew;
import com.osama.insurco.ui.camera.takeDoubleImgActivity;

import org.json.JSONObject;

import java.util.Locale;

public class SplashActivity extends BaseActivity {
    IResult mResultCallback;
    LottieAnimationView animationView;

    Boolean aBoolean=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        getSupportActionBar().hide();
        animationView=findViewById(R.id.animationView);



        animationView.addAnimatorListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {
                Log.e("Animation:","start");
            }

            @Override
            public void onAnimationEnd(Animator animation) {
                Log.e("Animation:","end");
                //Your code for remove the fragment


                if(aBoolean){


                    Intent intent = new Intent(SplashActivity.this, SelectLanguageActivity.class);
                    intent.putExtra("from", "welcome");
                    startActivity(intent);
                }
                aBoolean=true;




            }

            @Override
            public void onAnimationCancel(Animator animation) {
                Log.e("Animation:","cancel");
            }

            @Override
            public void onAnimationRepeat(Animator animation) {
                Log.e("Animation:","repeat");
            }
        });

// finally change the color
        getWindow().setStatusBarColor(ContextCompat.getColor(SplashActivity.this, R.color.purple_200));

        if (Hawk.contains("lang")) {

            if (Hawk.get("lang").toString().equals("en")) {
                setLocale(SplashActivity.this, "en");

            } else {
                setLocale(SplashActivity.this, "ar");

            }

        } else {

//            Hawk.put("lang", LocaleUtils.getLanguage(this));
            Hawk.put("lang", "ar");

            setLocale(SplashActivity.this, "ar");


        }
        try {


            init_volley();

            VolleyService mVolleyService = new VolleyService(mResultCallback, SplashActivity.this);

            mVolleyService.getDataVolley("settings", WebService.settings);//category/1/product


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
                try {
                    boolean status = response.getBoolean("status");
                    if (status) {


                        if (requestType.equals("settings")) {

//
//                            JsonParser parser = new JsonParser();
//                            JsonElement mJson = parser.parse(response.toString());
//
//                            Gson gson = new Gson();
//                            LikeCards allDiscountModules = gson.fromJson(mJson, LikeCards.class);

                            Hawk.put("settings", response.toString() + "");


                            if(aBoolean){



                                Intent intent = new Intent(SplashActivity.this, SelectLanguageActivity.class);
                                intent.putExtra("from", "welcome");
                                startActivity(intent);
                            }
                            aBoolean=true;
//                            final Handler handler = new Handler();
//                            handler.postDelayed(new Runnable() {
//                                @Override
//                                public void run() {
//
////                                    Intent intent = getIntent();
////                                    String action = intent.getAction().toString();
////                                    Uri data = intent.getData();
////
////                                    if (data != null) {
////                                        Intent intent1 = new Intent(SplashActivity.this, OrderActivity.class);
////                                        intent1.putExtra("from","url");
////                                        startActivity(intent1);
////                                        finish();
////                                    } else {
////
////                                    }
//
//
//
//
//
//
//
////                                    startActivity(new Intent(SplashActivity.this, WelcomeActivity.class));
//
////                                    if(Settings.checkLogin()){
////
////                                    }else{
////                                        startActivity(new Intent(SplashActivity.this, LoginActivity.class));
////                                        finish();
////                                    }
//
//                                }
//                            }, 2000); // After 1 seconds

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

                        WebService.Make_Toast_color(SplashActivity.this, message, "error");

                    }


                } catch (Exception e) {
                    e.printStackTrace();
                }


            }


            @Override
            public void notifyError(String requestType, VolleyError error) {
                Log.d("TAG", "Volley requester " + requestType);
                Log.d("TAG", "Volley JSON post" + "That didn't work!" + error.getMessage());

                try {
//                    btn_id.stopAnimation();
//                    btn_id.revertAnimation();

                    NetworkResponse response = error.networkResponse;
                    String response_data = new String(response.data);

                    JSONObject jsonObject = new JSONObject(response_data);

                    String message = jsonObject.getString("message");


                    WebService.Make_Toast_color(SplashActivity.this, message, "error");

                    Log.e("error response", response_data);

                } catch (Exception e) {

                }


            }

            @Override
            public void notify_Async_Error(String requestType, String error) {

            }
        };


    }

    public static void setLocale(Activity activity, String local) {
//        if (!BuildConfig.DEBUG)
//            Thread.setDefaultUncaughtExceptionHandler(new DefaultExceptionHandler(activity));
//        if (!BuildConfig.ENGLISH) {
        String languageToLoad = local; // your language
        Locale locale = new Locale(languageToLoad);
        Locale.setDefault(locale);
        Configuration config = new Configuration();
        config.locale = locale;


        if (Build.VERSION.SDK_INT > 17) {


            System.out.println("!!!!!");
            config.setLocale(locale);
        } else {
            config.locale = locale;
            System.out.println("!!!!!x");

        }


        if (Build.VERSION.SDK_INT == Build.VERSION_CODES.N) {
            config.setLocales(new LocaleList(locale));
            System.out.println("!!!!!s");

        }

        activity.getBaseContext().getResources().updateConfiguration(config,
                activity.getBaseContext().getResources().getDisplayMetrics());

    }

}