package com.osama.insurco.ui.splash;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.os.LocaleList;
import android.view.View;
import android.widget.TextView;

import com.orhanobut.hawk.Hawk;
import com.osama.insurco.R;
import com.osama.insurco.Settings.BaseActivity;
import com.osama.insurco.ui.Main.MainActivity;
import com.osama.insurco.ui.Order.OrderActivity;

import java.util.Locale;

public class SelectLanguageActivity extends BaseActivity {
    TextView english;
    TextView arabic;
    TextView Turki;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_language);
        getSupportActionBar().hide();


// finally change the color
        getWindow().setStatusBarColor(ContextCompat.getColor(SelectLanguageActivity.this, R.color.purple_200));

        english = findViewById(R.id.english);
        arabic = findViewById(R.id.arabic);
        Turki = findViewById(R.id.Turki);


        if (Hawk.contains("lang")) {

            if (Hawk.get("lang").toString().equals("ar")) {
                english.setBackground(getResources().getDrawable(R.drawable.button_w));
                arabic.setBackground(getResources().getDrawable(R.drawable.button_login));
                Turki.setBackground(getResources().getDrawable(R.drawable.button_w));
                english.setTextColor(getResources().getColor(R.color.purple_200));
                arabic.setTextColor(getResources().getColor(R.color.white));
                Turki.setTextColor(getResources().getColor(R.color.purple_200));
            }
            if (Hawk.get("lang").toString().equals("en")) {

                english.setBackground(getResources().getDrawable(R.drawable.button_login));
                arabic.setBackground(getResources().getDrawable(R.drawable.button_w));
                Turki.setBackground(getResources().getDrawable(R.drawable.button_w));

                english.setTextColor(getResources().getColor(R.color.white));
                arabic.setTextColor(getResources().getColor(R.color.purple_200));
                Turki.setTextColor(getResources().getColor(R.color.purple_200));
            }
            if (Hawk.get("lang").toString().equals("tr")) {

            }

        }


        english.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                english.setBackground(getResources().getDrawable(R.drawable.button_login));
//                arabic.setBackground(getResources().getDrawable(R.drawable.button_w));
//                Turki.setBackground(getResources().getDrawable(R.drawable.button_w));
//
//                english.setTextColor(getResources().getColor(R.color.white));
//                arabic.setTextColor(getResources().getColor(R.color.purple_200));
//                Turki.setTextColor(getResources().getColor(R.color.purple_200));
                Hawk.put("lang", "en");

                setLocale(SelectLanguageActivity.this, "en");
                cloase_all_activity();


            }
        });

        arabic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                english.setBackground(getResources().getDrawable(R.drawable.button_w));
//                arabic.setBackground(getResources().getDrawable(R.drawable.button_login));
//                Turki.setBackground(getResources().getDrawable(R.drawable.button_w));
//                english.setTextColor(getResources().getColor(R.color.purple_200));
//                arabic.setTextColor(getResources().getColor(R.color.white));
//                Turki.setTextColor(getResources().getColor(R.color.purple_200));
                Hawk.put("lang", "ar");

                setLocale(SelectLanguageActivity.this, "ar");

                cloase_all_activity();

            }
        });

        Turki.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                english.setBackground(getResources().getDrawable(R.drawable.button_w));
//                arabic.setBackground(getResources().getDrawable(R.drawable.button_w));
//                Turki.setBackground(getResources().getDrawable(R.drawable.button_login));
//                english.setTextColor(getResources().getColor(R.color.purple_200));
//                arabic.setTextColor(getResources().getColor(R.color.purple_200));
//                Turki.setTextColor(getResources().getColor(R.color.white));
                Hawk.put("lang", "en");

                setLocale(SelectLanguageActivity.this, "en");
                cloase_all_activity();
            }
        });


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

    public void cloase_all_activity() {
        try {
            String fro = getIntent().getStringExtra("from");


            if (fro.equals("settings")) {
                Intent intent = new Intent(SelectLanguageActivity.this, SplashActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                MainActivity.activity.finish();
            } else {

                startActivity(new Intent(SelectLanguageActivity.this, WelcomeActivity.class));
                finish();
            }


        } catch (Exception e) {

        }
    }

}