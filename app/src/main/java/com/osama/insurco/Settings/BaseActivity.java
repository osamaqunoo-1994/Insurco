package com.osama.insurco.Settings;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.os.LocaleList;

import com.orhanobut.hawk.Hawk;
import com.osama.insurco.R;
import com.osama.insurco.ui.splash.SplashActivity;

import java.util.Locale;

public class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);



        if (Hawk.contains("lang")) {

            if (Hawk.get("lang").toString().equals("en")) {
                setLocale(BaseActivity.this, "en");

            } else {
                setLocale(BaseActivity.this, "ar");

            }

        } else {

//            Hawk.put("lang", LocaleUtils.getLanguage(this));
            Hawk.put("lang", "ar");

            setLocale(BaseActivity.this, "ar");


        }




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


            config.setLocale(locale);
        } else {
            config.locale = locale;

        }


        if (Build.VERSION.SDK_INT == Build.VERSION_CODES.N) {
            config.setLocales(new LocaleList(locale));
            System.out.println("!!!!!s");

        }

        activity.getBaseContext().getResources().updateConfiguration(config,
                activity.getBaseContext().getResources().getDisplayMetrics());

    }

}