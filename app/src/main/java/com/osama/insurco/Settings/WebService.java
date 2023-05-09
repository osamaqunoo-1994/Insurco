package com.osama.insurco.Settings;

import android.app.Activity;
import android.widget.Toast;


import com.kaopiz.kprogresshud.KProgressHUD;
import com.loopj.android.http.AsyncHttpClient;
import com.orhanobut.hawk.Hawk;
import com.osama.insurco.R;

import java.util.HashMap;
import java.util.Map;

import es.dmoral.toasty.Toasty;


public class WebService {
//https://www.insurco.ae/contact-app/

    public static KProgressHUD kProgressHUD;

    public static String Domain = "https://www.insurco.ae/public/api/";
    public static String ncode_mobile = "+971";

    static String v_code = "v3";

    public static String settings = Domain + "settings";
    public static String getAds = Domain + "getAds";
    public static String getMotoTypeInsurance = Domain + "getMotoTypeInsurance";
    public static String getHelthTypeInsurance = Domain + "getHelthTypeInsurance";
    public static String sendContactMsg = Domain + "sendContactMsg";
    public static String getFaqs = Domain + "getFaqs";
    public static String forgotPassword = Domain + "forgotPassword";
    public static String loginForUsers = Domain + "loginForUsers";
    public static String loginBySocial = Domain + "loginBySocial";
    public static String signUpUsers = Domain + "signUpUsers";
    public static String sendMotorRequest = Domain + "sendMotorRequest";
    public static String reSendActivationCode = Domain + "reSendActivationCode";
    public static String actMotorHealthReq = Domain + "actMotorHealthReq";
    public static String returnInsuranceCompanies = Domain + "returnInsuranceCompanies";
    public static String payNow = Domain + "payNow";
    public static String sendHealthRequest = Domain + "sendHealthRequest";




    public static void Header_Async(AsyncHttpClient client, boolean is_token) {

        client.addHeader("Accept", "application/json");
        client.addHeader("Auth-Role", "user");
        client.addHeader("Accept-Language", Hawk.get("lang").toString());
        client.addHeader("v", v_code);
        System.out.println("app_v" + Application.getversionName());
        client.addHeader("app_v", Application.getversionName());
        if (Settings.checkLogin()) {
            if (Settings.GetUser().getUser() != null) {

                System.out.println("Authorization: " + "Bearer " + Settings.GetUser().getUser().getAccessToken());

                client.addHeader("Authorization", "Bearer " + Settings.GetUser().getUser().getAccessToken());
            }
        }
        client.addHeader("deviceType", "android");

        if (Settings.checkLogin()) {
//            client.addHeader("auth", "token " + Settings.GetUser().getApiToken());
//            System.out.println("auth " + "token " + Settings.GetUser().getApiToken());

        }
//        if (is_token) {
//            if (Hawk.contains("api_token")) {
//                if (!Hawk.get("api_token").toString().equals("")) {
//                    client.addHeader("auth", Hawk.get("api_token").toString());
////                    System.out.println("Authorization " + " Bearer " + Settings.GetUser().getAccessToken());
//                }
//            }
//
//        }
    }


    public static Map<String, String> setHeaderVolley() {

        Map<String, String> heder = new HashMap<String, String>();
        heder.put("Accept", "application/json");
        heder.put("Accept-Language", Hawk.get("lang").toString());
        heder.put("v", v_code);
        heder.put("deviceType", "android");

        System.out.println("app_v" + Application.getversionName());
        heder.put("app_v", Application.getversionName());
        if (Settings.checkLogin()) {

            if (Settings.GetUser().getUser() != null) {
                heder.put("Authorization", "Bearer " + Settings.GetUser().getUser().getAccessToken());
                System.out.println("Authorization " + "Bearer " + Settings.GetUser().getUser().getAccessToken());

            }

        }
        return heder;
    }

    public static Map<String, String> setHeaderVolley_without_token() {

        Map<String, String> heder = new HashMap<String, String>();
        heder.put("Accept", "application/json");
        heder.put("Accept-Language", Hawk.get("lang").toString());
        heder.put("v", v_code);
        System.out.println("app_v" + Application.getversionName());
        heder.put("app_v", Application.getversionName());
        heder.put("deviceType", "android");
//        heder.put("auth", "token b3fa2fc50774258476f5be97bce049a564aa30c5bb8859c3047626146b0ff7d1a8ea7e6673fafb2f8275eb48683fa8520f465ae0b5dbecfe32853a6e191fe7cc");

        if (Settings.checkLogin()) {
//            heder.put("auth", "token " + Settings.GetUser().getApiToken());
//            System.out.println("auth " + "token " + Settings.GetUser().getApiToken());
            if (Settings.GetUser().getUser() != null) {

                heder.put("Authorization", "Bearer " + Settings.GetUser().getUser().getAccessToken());
                System.out.println("Authorization " + "Bearer " + Settings.GetUser().getUser().getAccessToken());
            }
        }
        return heder;
    }


    public static void loading(Activity activity, boolean stopOrstart) {

        if (stopOrstart) {
            if (kProgressHUD != null) {
                kProgressHUD.dismiss();

            }
            kProgressHUD = KProgressHUD.create(activity)
                    .setStyle(KProgressHUD.Style.SPIN_INDETERMINATE)
                    .setCancellable(true)
                    .setAnimationSpeed(2)
                    .setBackgroundColor(activity.getResources().getColor(R.color.purple_200))
                    .setDimAmount(0.5f)
                    .show();
        } else {
            if (kProgressHUD != null) {
                kProgressHUD.dismiss();

            }
        }

    }

    public static void Make_Toast(Activity activity, String message) {
        Toast.makeText(activity, message, Toast.LENGTH_LONG).show();
    }

    public static void Make_Toast_color(Activity activity, String message, String type) {
        if (type.equals("success")) {
//            Toast.makeText(activity,message,Toast.LENGTH_LONG).show();
            Toasty.success(activity, message, Toast.LENGTH_SHORT, true).show();

        } else {
//            Toast.makeText(activity,message,Toast.LENGTH_LONG).show();

            Toasty.error(activity, message, Toast.LENGTH_SHORT, true).show();

        }

    }

    public static void Make_Toast_colors(Activity activity, String message, String type) {
        if (type.equals("success")) {

//            Alerter.create(activity)
//                    .setText(message)
//                    .setBackgroundColorRes(R.color.cookie_success)
//                    .enableInfiniteDuration(false)
//                    .setDuration(1500)
//
//                    .enableVibration(true)
//                    .setExitAnimation(R.anim.alerter_slide_out_to_top)
//                    .addButton(activity.getString(R.string.ok), R.style.ExampleButton_ok, v -> {
//                        try {
//                            setWifiEnabled(activity,true);
//                        } catch (Exception e) {
//                            e.printStackTrace();
//                        }
//                        Alerter.hide(); })
//
//                    .addButton(activity.getString(R.string.no_cancel),R.style.ExampleButton_cancel, v ->
//                            Alerter.hide())
//                    .show();

//            Toasty.success(activity, message, Toast.LENGTH_SHORT, true).show();

        } else {


            try {


                if (message == null) {
                    message = "هنالك خطا في الاتصال بالانترنت";
                }

//                Alerter.create(activity)
//                        .setText(message)
//                        .setBackgroundColorRes(R.color.error)
//                        .enableInfiniteDuration(false)
//                        .setDuration(1000)
//
//                        .enableVibration(true)
//                        .setExitAnimation(R.anim.alerter_slide_out_to_top)
//                    .addButton(activity.getString(R.string.ok), R.style.ExampleButton_ok, v -> {
//                        try {
//                            setWifiEnabled(activity,true);
//                        } catch (Exception e) {
//                            e.printStackTrace();
//                        }
//                        Alerter.hide(); })
//
//                    .addButton(activity.getString(R.string.no_cancel),R.style.ExampleButton_cancel, v ->
//                            Alerter.hide())
//                        .show();


            } catch (Exception e) {

            }


//            Toasty.error(activity, message, Toast.LENGTH_SHORT, true).show();

        }

    }

    public static void Make_Toast_color_info(Activity activity, String message, String type) {
//
//        Alerter.create(activity)
//                .setText(message)
//                .setIcon(R.drawable.ic_danger)
//                .setBackgroundColorRes(R.color.yalow)
//                .enableInfiniteDuration(false)
//                .setDuration(1500)
//
//                .enableVibration(true)
//                .setExitAnimation(R.anim.alerter_slide_out_to_top)
//
//                .show();


    }

}
