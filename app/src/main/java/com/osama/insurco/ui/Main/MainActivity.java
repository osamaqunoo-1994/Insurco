package com.osama.insurco.ui.Main;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentTransaction;

import android.Manifest;
import android.app.Activity;
import android.app.FragmentManager;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;

import com.etebarian.meowbottomnavigation.MeowBottomNavigation;
import com.osama.insurco.R;
import com.osama.insurco.ui.Company.CompanySelectionActivity;
import com.osama.insurco.ui.Main.Fragments.AboutFragment;
import com.osama.insurco.ui.Main.Fragments.HomeFragment;
import com.osama.insurco.ui.Main.Fragments.SettingsFragment;
import com.osama.insurco.ui.camera.TakeImageCameraActivitynew;
import com.osama.insurco.ui.camera.takeDoubleImgActivity;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;

public class MainActivity extends AppCompatActivity {
    MeowBottomNavigation bottomNavigation;

    private static FragmentTransaction fragmentTransaction;
    private static androidx.fragment.app.FragmentManager fragmentManager;



    public static Activity activity;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        activity=this;
        getSupportActionBar().hide();

        getWindow().setNavigationBarColor(getResources().getColor(R.color.purple_200));

// finally change the color
        getWindow().setStatusBarColor(ContextCompat.getColor(MainActivity.this, R.color.purple_200));

        bottomNavigation = findViewById(R.id.bottomNavigation);


        bottomNavigation.add(new MeowBottomNavigation.Model(1, R.drawable.icon_material_perm_device_information));
        bottomNavigation.add(new MeowBottomNavigation.Model(2, R.drawable.icon_awesome_home));
        bottomNavigation.add(new MeowBottomNavigation.Model(3, R.drawable.icon_ionic_md_settings));

        bottomNavigation.show(2, true);


        fragmentManager = getSupportFragmentManager();

        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.container, new HomeFragment());
        //  fragmentTransaction.commit();
        fragmentTransaction.commitAllowingStateLoss();


        bottomNavigation.setOnClickMenuListener(new Function1<MeowBottomNavigation.Model, Unit>() {
            @Override
            public Unit invoke(MeowBottomNavigation.Model model) {

                System.out.println("modelmodelmodel" + model.getId());
                if (model.getId() == 1) {

                    fragmentTransaction = fragmentManager.beginTransaction();

                    fragmentTransaction.replace(R.id.container, new AboutFragment());
                    fragmentTransaction.addToBackStack(null);

                    //  fragmentTransaction.commit();
                    fragmentTransaction.commitAllowingStateLoss();
                } else if (model.getId() == 2) {

                    fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.container, new HomeFragment());
                    fragmentTransaction.addToBackStack(null);

                    //  fragmentTransaction.commit();
                    fragmentTransaction.commitAllowingStateLoss();
                } else if (model.getId() == 3) {

                    fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.container, new SettingsFragment());
                    fragmentTransaction.addToBackStack(null);

                    //  fragmentTransaction.commit();
                    fragmentTransaction.commitAllowingStateLoss();
                }


                System.out.println("modelmodel" + model.getId());

                // YOUR CODES
                return null;
            }
        });

        bottomNavigation.setOnShowListener(new Function1<MeowBottomNavigation.Model, Unit>() {
            @Override
            public Unit invoke(MeowBottomNavigation.Model model) {
                // YOUR CODES
                return null;
            }
        });
        int check = ActivityCompat.checkSelfPermission(MainActivity.this, Manifest.permission.WRITE_EXTERNAL_STORAGE);
        if (check != PackageManager.PERMISSION_GRANTED) {
            //Do something
//            startActivity(new Intent(MainActivity.this, TakeImageCameraActivitynew.class));
            ActivityCompat.requestPermissions(MainActivity.this,  new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1024);

        }

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {


        System.out.println("09090909111@@@@@@@");

        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }
}