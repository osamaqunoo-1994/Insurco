package com.osama.insurco.Settings;




import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.orhanobut.hawk.Hawk;
import com.osama.insurco.Modules.AdsModules;
import com.osama.insurco.Modules.SettingsModules;
import com.osama.insurco.Modules.User;


public class Settings {
//Client ID
    //313951047594-ii3c2pt02ppdtv9m93g7ru8t9j5n97tp.apps.googleusercontent.com
    //Client Secret
    //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
    public static SettingsModules getSettings() {


        if (Hawk.contains("settings")) {
            JsonParser parser = new JsonParser();
            JsonElement mJson = parser.parse(Hawk.get("settings").toString());

            Gson gson = new Gson();
            SettingsModules userModules = gson.fromJson(mJson, SettingsModules.class);
            return userModules;
        } else {
            SettingsModules userModules = new SettingsModules();
            return userModules;

        }


    } public static AdsModules getAds() {


        if (Hawk.contains("Ads")) {
            JsonParser parser = new JsonParser();
            JsonElement mJson = parser.parse(Hawk.get("Ads").toString());

            Gson gson = new Gson();
            AdsModules userModules = gson.fromJson(mJson, AdsModules.class);
            return userModules;
        } else {
            AdsModules userModules = new AdsModules();
            return userModules;

        }


    }


    //


    public static User GetUser() {

        try {

            JsonParser parser = new JsonParser();
            JsonElement mJson = parser.parse(Hawk.get("user").toString());

            Gson gson = new Gson();
            User userModules = gson.fromJson(mJson, User.class);
            return userModules;
        } catch (Exception e) {
            Hawk.put("user", "");
            return null;

        }


    }


    public static boolean checkLogin() {


        try {
            if (Hawk.contains("user")) {

                return !Hawk.get("user").toString().equals("");
            } else {
                return false;
            }
        } catch (Exception e) {
            Hawk.put("user", "");

            return false;

        }


    }


}
