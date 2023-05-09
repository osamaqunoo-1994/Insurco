package com.osama.insurco.ui.Main.Fragments;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.os.LocaleList;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

import com.orhanobut.hawk.Hawk;
import com.osama.insurco.R;
import com.osama.insurco.Settings.Settings;
import com.osama.insurco.ui.Auth.LoginActivity;
import com.osama.insurco.ui.Main.MainActivity;
import com.osama.insurco.ui.Order.OrderActivity;
import com.osama.insurco.ui.StaticsPages.ContactUsActivity;
import com.osama.insurco.ui.StaticsPages.FaqsActivity;
import com.osama.insurco.ui.StaticsPages.TermsConditionActivity;
import com.osama.insurco.ui.splash.SelectLanguageActivity;
import com.osama.insurco.ui.splash.SplashActivity;

import java.util.Locale;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SettingsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SettingsFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public SettingsFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HomeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static SettingsFragment newInstance(String param1, String param2) {
        SettingsFragment fragment = new SettingsFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    TextView faqs;
    TextView contact_us;
    TextView oreder_compagtim;
    TextView terms;
    TextView language;
    TextView login;
    TextView logout;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View v = inflater.inflate(R.layout.fragment_settings, container, false);


        faqs = v.findViewById(R.id.faqs);
        contact_us = v.findViewById(R.id.contact_us);
        terms = v.findViewById(R.id.terms);
        language = v.findViewById(R.id.language);
        oreder_compagtim = v.findViewById(R.id.oreder_compagtim);
        login = v.findViewById(R.id.login);
        logout = v.findViewById(R.id.logout);


        try {

            if (Settings.checkLogin()) {
                login.setVisibility(View.GONE);
                logout.setVisibility(View.VISIBLE);
            } else {
                login.setVisibility(View.VISIBLE);
                logout.setVisibility(View.GONE);

            }

        } catch (Exception e) {

        }
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                new AlertDialog.Builder(getContext())
                        .setMessage(getResources().getString(R.string.AreYouwantChangeLlogout))
                        .setCancelable(false)
                        .setPositiveButton(getResources().getString(R.string.yes), new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {

                                Hawk.put("user", "");

                                if (Settings.checkLogin()) {
                                    login.setVisibility(View.GONE);
                                    logout.setVisibility(View.VISIBLE);
                                } else {
                                    login.setVisibility(View.VISIBLE);
                                    logout.setVisibility(View.GONE);
                                }

                            }
                        })
                        .setNegativeButton(getResources().getString(R.string.No), null)
                        .show();

            }
        });

        faqs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), FaqsActivity.class));
            }
        });
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), LoginActivity.class));
            }
        });


        contact_us.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), ContactUsActivity.class));
            }
        });


        terms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), TermsConditionActivity.class));
            }
        });

        oreder_compagtim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(getActivity(), OrderActivity.class);
                intent1.putExtra("from", "settings");
                startActivity(intent1);
            }
        });
        language.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), SelectLanguageActivity.class);
                intent.putExtra("from", "settings");
                startActivity(intent);


//                new AlertDialog.Builder(getContext())
//                        .setMessage(getResources().getString(R.string.AreYouwantChangeLangouage))
//                        .setCancelable(false)
//                        .setPositiveButton(getResources().getString(R.string.yes), new DialogInterface.OnClickListener() {
//                            public void onClick(DialogInterface dialog, int id) {
//
//                                if (Hawk.contains("lang")) {
//
//
//                                    if (Hawk.get("lang".toString()).equals("ar")) {
//                                        Hawk.put("lang", "en");
//
//                                        setLocale(getActivity(), Hawk.get("lang").toString());
//                                        Intent intent = new Intent(getContext(), SplashActivity.class);
//                                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
//                                        startActivity(intent);
//                                        MainActivity.activity.finish();
//
//                                    } else {
//                                        Hawk.put("lang", "ar");
//
//                                        setLocale(getActivity(), Hawk.get("lang").toString());
//                                        Intent intent = new Intent(getContext(), SplashActivity.class);
//                                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
//                                        startActivity(intent);
//                                        MainActivity.activity.finish();
//                                    }
//
//                                } else {
//
//                                    Hawk.put("lang", "ar");
//                                    setLocale(getActivity(), Hawk.get("lang").toString());
//                                    Intent intent = new Intent(getContext(), SplashActivity.class);
//                                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
//                                    startActivity(intent);
//                                    MainActivity.activity.finish();
//
//                                }
//
//
//                            }
//                        })
//                        .setNegativeButton(getResources().getString(R.string.No), null)
//                        .show();

            }
        });


        return v;

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

    @Override
    public void onResume() {
        try {

            if (Settings.checkLogin()) {
                login.setVisibility(View.GONE);
                logout.setVisibility(View.VISIBLE);
            } else {
                login.setVisibility(View.VISIBLE);
                logout.setVisibility(View.GONE);

            }

        } catch (Exception e) {

        }
        super.onResume();
    }
}