package com.osama.insurco.Settings;

import android.app.Activity;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.os.Build;
import android.os.LocaleList;

import com.orhanobut.hawk.Hawk;

import java.util.Locale;


public class Application extends android.app.Application {




    //insurcoAlias
    //insurco.jks
    //123456
    //








    static Application activity;

//    public static List<CityModules> AllCity = new ArrayList<CityModules>();

    static String statis_id = "";

//    public static MyOfferModule myOfferModule;

    @Override
    public void onCreate() {
        super.onCreate();

//        Fabric.with(this, new Crashlytics());
//        // the following line is important
//        Fresco.initialize(this);
//
//
        activity = this;
        Hawk.init(this).build();

//        if (!Places.isInitialized()) {
//            Places.initialize(Application.this, "AIzaSyCX9U6fj5-Tt5lK_23d2RFsr4Nlp3yqdoM", Locale.UK);
//        }
        if (Hawk.contains("lang")) {

            if (Hawk.get("lang".toString()).equals("ar")) {
                Locale locale = new Locale(Hawk.get("lang").toString());
                Locale.setDefault(locale);
                Configuration config = new Configuration();
                config.locale = locale;
                getBaseContext().getResources().updateConfiguration(config,
                        getBaseContext().getResources().getDisplayMetrics());
            } else {
                Locale locale = new Locale(Hawk.get("lang").toString());
                Locale.setDefault(locale);
                Configuration config = new Configuration();
                config.locale = locale;
                getBaseContext().getResources().updateConfiguration(config,
                        getBaseContext().getResources().getDisplayMetrics());

            }

        }else{
            Hawk.put("lang", "en");

            Locale locale = new Locale("en");
            Locale.setDefault(locale);
            Configuration config = new Configuration();
            config.locale = locale;
            getBaseContext().getResources().updateConfiguration(config,
                    getBaseContext().getResources().getDisplayMetrics());
        }
////        else {
////
//////            Hawk.put("lang", LocaleUtils.getLanguage(this));
////            Hawk.put("lang", "ar");
//
//        if (!Hawk.contains("langas")) {
////            Hawk.put("lang", "ar");
////            Hawk.put("langas", "ar");
////            System.out.println("(*(*(*(*(*");
//        }

//        if (Hawk.contains("lang")) {
//            setLocale(Application.this, Hawk.get("lang").toString());
//
//
////            Locale locale = new Locale(Hawk.get("lang").toString());
////            Locale.setDefault(locale);
////            Configuration config = new Configuration();
////            config.locale = locale;
////            getBaseContext().getResources().updateConfiguration(config,
////                    getBaseContext().getResources().getDisplayMetrics());
//
//        } else {
//
//            Hawk.put("lang", "ar");
//
//            Locale locale = new Locale(Hawk.get("lang").toString());
//            Locale.setDefault(locale);
//            Configuration config = new Configuration();
//            config.locale = locale;
//            getBaseContext().getResources().updateConfiguration(config,
//                    getBaseContext().getResources().getDisplayMetrics());
//
//
//        }

//        if (Hawk.contains("lang")) {
//            Hawk.put("lang", "ar");
//
//        } else {
//            Hawk.put("lang", "ar");
//        }
////
//        Locale locale = new Locale(Hawk.get("lang").toString());
//        Locale.setDefault(locale);
//        Configuration config = new Configuration();
//        config.locale = locale;
//        getBaseContext().getResources().updateConfiguration(config,
//                getBaseContext().getResources().getDisplayMetrics());
////        }


        try {
//            if (Hawk.contains("AllCity")) {
//
//
//                if (!Hawk.get("AllCity").toString().equals("")) {
//
//                    JSONArray jsonArray = new JSONArray(Hawk.get("AllCity").toString());
//                    AllCity.clear();
//                    for (int i = 0; i < jsonArray.length(); i++) {
//
//
//                        JsonParser parser = new JsonParser();
//                        JsonElement mJson = parser.parse(jsonArray.getString(i));
//
//                        Gson gson = new Gson();
//
//                        CityModules Store_M = gson.fromJson(mJson, CityModules.class);
//                        AllCity.add(Store_M);
//
//                    }
//
//                }
//            }
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    // check version on play store and force update
    public static String getversionName() {
        PackageManager packageManager = activity.getPackageManager();
        PackageInfo packageInfo = null;
        try {
            packageInfo = packageManager.getPackageInfo(activity.getPackageName(), 0);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        String currentVersion = packageInfo.versionName;

        System.out.println("currentVersion" + currentVersion);

        return currentVersion;
    }

    public static void setLocale(Activity activity, String local) {
//        if (!BuildConfig.DEBUG)
//            Thread.setDefaultUncaughtExceptionHandler(new DefaultExceptionHandler(activity));
//        if (!BuildConfig.ENGLISH) {
        String languageToLoad = local; // your language
        Locale locale = new Locale(languageToLoad);
        Locale.setDefault(locale);
        Configuration config = new Configuration();


        if (Build.VERSION.SDK_INT > 17) {
            config.setLocale(locale);
        } else {
            config.locale = locale;
        }
        if (Build.VERSION.SDK_INT == Build.VERSION_CODES.N) {
            config.setLocales(new LocaleList(locale));
        }

        activity.getBaseContext().getResources().updateConfiguration(config,
                activity.getBaseContext().getResources().getDisplayMetrics());

    }

}
