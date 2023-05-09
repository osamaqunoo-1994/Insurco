package com.osama.insurco.ui.Order;

import static com.osama.insurco.Settings.WebService.ncode_mobile;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.text.Html;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.NetworkResponse;
import com.android.volley.VolleyError;
import com.loopj.android.http.RequestParams;
import com.orhanobut.hawk.Hawk;
import com.osama.insurco.BottomSheetes.BottomSheetDialogFragment_take_img;
import com.osama.insurco.R;
import com.osama.insurco.Settings.BaseActivity;
import com.osama.insurco.Settings.Settings;
import com.osama.insurco.Settings.WebService;
import com.osama.insurco.api.IResult;
import com.osama.insurco.api.VolleyService;
import com.osama.insurco.ui.Auth.LoginActivity;
import com.osama.insurco.ui.Auth.VirficationOrderActivity;
import com.osama.insurco.ui.Main.MainActivity;
import com.osama.insurco.ui.Order.Adapter.RecyclerView_city;
import com.osama.insurco.ui.StaticsPages.ContactUsActivity;
import com.osama.insurco.ui.StaticsPages.TermsConditionActivity;
import com.osama.insurco.ui.camera.TakeImageCameraActivity;
import com.osama.insurco.ui.camera.TakeImageCameraActivity2;
import com.osama.insurco.ui.camera.takeCarDoubleImgActivity;
import com.osama.insurco.ui.camera.takeDoubleImgActivity;
import com.wildma.idcardcamera.camera.IDCardCamera;

import org.json.JSONObject;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

import cz.msebera.android.httpclient.util.TextUtils;

public class NewOrderActivity extends BaseActivity {
    EditText name;
    EditText phone;
    EditText email;

    //activation_code
    CheckBox accept;
    TextView type_title;
    TextView terms;
    LinearLayout next;
    LinearLayout lay_1;
    LinearLayout lay_2;

    IResult mResultCallback;

    File ownershipFile;
    File Emirate_IDFile;
    File Driver_LicenseFile;

    AlertDialog alertDialog;

    static File ownership_photo_from_front;
    static File ownership_photo_from_back;

    static File driver_license_from_front;
    static File driver_license_from_back;

    static File car_front_image;
    static File car_back_image;

    static File car_right_side_image;
    static File car_left_side_image;

    static File emirate_id_front_image;
    static File emirate_id_back_image;
    static File other_file;
    static File vehicle_inspection_file;


    static ImageView ownership;
    static Activity activity;
    static ImageView Emirate_ID;
    ImageView back;
    static ImageView Driver_License;

    static ImageView car_image;
    static ImageView vehicle_licence;
    static File vehicle_licence_filr;
    static File other_image_file;
    static ImageView other_image;
    static ImageView other_image_1;


    ProgressBar loading;
    LinearLayout submit;

    static TextView OwnerShip_txt;
    static TextView Emirate_ID_txt;
    static TextView Driver_License_txt;
    static TextView car_image_txt;
    static TextView vehicle_inspection_txt;


    TextView select_1;
    TextView select_2;
    TextView select_3;
    TextView sect_oo_1;
    TextView sect_oo_2;
    TextView sect_oo_1x;
    TextView sect_oo_2x;
    TextView aqwe1;
    TextView aqwe2;
    TextView yes;
    TextView no;
    TextView sect_oo_xxx;


    LinearLayout lay_1_select;
    LinearLayout yes_or_no;


    LinearLayout tamen;
    LinearLayout lay_1_selectx;
    TextView edit_jaha;
    EditText name_bank;
    EditText addres_register;
    EditText address_data;


    LinearLayout aew_1;


    static String type = "";
    static String type_front_or_back = "";

    String id = "";

    String type_comprehensive = "comprehensive";
    String type_car = "";
    String insurance_type_Expired = "not_Expired";
    String Is_the_car_mortgaged = "yes";


    LinearLayout car_image_layout;
    LinearLayout vehicle_licence_layout;
    LinearLayout other_image_layout;
    LinearLayout select_area;
    Spinner select_area_sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_order);
        getSupportActionBar().hide();

        activity = this;

        try {
            id = getIntent().getStringExtra("id");
        } catch (Exception e) {

        }
        car_image = findViewById(R.id.car_image);
        car_image_txt = findViewById(R.id.car_image_txt);
        type_title = findViewById(R.id.type_title);
        select_area = findViewById(R.id.select_area);
        select_area_sp = findViewById(R.id.select_area_sp);

        vehicle_inspection_txt = findViewById(R.id.vehicle_inspection_txt);

        aew_1 = findViewById(R.id.aew_1);


        car_image_layout = findViewById(R.id.car_image_layout);
        vehicle_licence_layout = findViewById(R.id.vehicle_licence_layout);
        other_image_layout = findViewById(R.id.other_image_layout);
        vehicle_licence = findViewById(R.id.vehicle_licence);
        other_image = findViewById(R.id.other_image);
        other_image_1 = findViewById(R.id.other_image_1);


        aqwe2 = findViewById(R.id.aqwe2);
        name_bank = findViewById(R.id.name_bank);
        sect_oo_1x = findViewById(R.id.sect_oo_1x);
        sect_oo_2x = findViewById(R.id.sect_oo_2x);
        addres_register = findViewById(R.id.addres_register);
        aqwe1 = findViewById(R.id.aqwe1);
        tamen = findViewById(R.id.tamen);
        sect_oo_1 = findViewById(R.id.sect_oo_1);
        sect_oo_2 = findViewById(R.id.sect_oo_2);
        select_1 = findViewById(R.id.select_1);
        select_2 = findViewById(R.id.select_2);
        select_3 = findViewById(R.id.select_3);
        name = findViewById(R.id.name);
        phone = findViewById(R.id.phone);
        email = findViewById(R.id.email);
        accept = findViewById(R.id.accept);
        terms = findViewById(R.id.terms);
        next = findViewById(R.id.next);
        address_data = findViewById(R.id.address_data);
        lay_1_selectx = findViewById(R.id.lay_1_selectx);
        lay_1 = findViewById(R.id.lay_1);
        sect_oo_xxx = findViewById(R.id.sect_oo_xxx);
        yes = findViewById(R.id.yes);
        no = findViewById(R.id.no);
        yes_or_no = findViewById(R.id.yes_or_no);
        lay_1_select = findViewById(R.id.lay_1_select);
        edit_jaha = findViewById(R.id.edit_jaha);
        lay_2 = findViewById(R.id.lay_2);
        ownership = findViewById(R.id.ownership);
        Emirate_ID = findViewById(R.id.Emirate_ID);
        Driver_License = findViewById(R.id.Driver_License);
        loading = findViewById(R.id.loading);
        submit = findViewById(R.id.submit);
        OwnerShip_txt = findViewById(R.id.OwnerShip_txt);
        Emirate_ID_txt = findViewById(R.id.Emirate_ID_txt);
        Driver_License_txt = findViewById(R.id.Driver_License_txt);
        back = findViewById(R.id.back);



          ownership_photo_from_front=null;
         ownership_photo_from_back=null;

         driver_license_from_front=null;
         driver_license_from_back=null;

         car_front_image=null;
         car_back_image=null;

         car_right_side_image=null;
         car_left_side_image=null;

         emirate_id_front_image=null;
         emirate_id_back_image=null;
         other_file=null;
         vehicle_inspection_file=null;











        try {

            String namse = Settings.GetUser().getUser().getName().toString() + "";
            if (!namse.equals("null")) {
                name.setText(namse);
            }
            String mobile_s = Settings.GetUser().getUser().getMobile().toString() + "";
            if (!mobile_s.equals("null")) {
                phone.setText(mobile_s);
            }
            String emailee = Settings.GetUser().getUser().getEmail().toString() + "";
            if (!emailee.equals("null")) {
                email.setText(emailee);
            }


        } catch (Exception e) {

        }


// finally change the color
        getWindow().setStatusBarColor(ContextCompat.getColor(NewOrderActivity.this, R.color.purple_200));

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (name.getText().toString().equals("") |
                        phone.getText().toString().equals("") |
                        type_car.toString().equals("") |
                        email.getText().toString().equals("") |
                        !accept.isChecked()
                ) {
                    if (name.getText().toString().equals("")) {
                        name.setError(getResources().getString(R.string.required));
                    }
                    if (phone.getText().toString().equals("")) {
                        phone.setError(getResources().getString(R.string.required));
                    }
                    if (email.getText().toString().equals("")) {
                        email.setError(getResources().getString(R.string.required));
                    }
                    if (type_car.toString().equals("")) {
                        type_title.setError(getResources().getString(R.string.required));
                    } else {
                        type_title.setError(null);
                    }
                    if (!accept.isChecked()) {
                        accept.setError(getResources().getString(R.string.required));
                    } else {
                        accept.setError(null);
                    }
                } else {


                    InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(view.getWindowToken(), 0);


                    lay_1.setVisibility(View.GONE);
                    lay_2.setVisibility(View.VISIBLE);


                }
            }
        });
        ownership.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                type = "examination_of_the_vehicle_image";
//                startActivity(new Intent(NewOrderActivity.this, TakeImageCameraActivity2.class));

//                startActivity(new Intent(NewOrderActivity.this, takeDoubleImgActivity.class));

//                BottomSheetDialogFragment_take_img bottomSheetDialogFragment_take_img = new BottomSheetDialogFragment_take_img("");
//                bottomSheetDialogFragment_take_img.show(getSupportFragmentManager(), "");

                com.github.dhaval2404.imagepicker.ImagePicker.Builder builder = new com.github.dhaval2404.imagepicker.ImagePicker.Builder(NewOrderActivity.this);
                builder.crop()                    //Crop image(Optional), Check Customization for more option
                        .compress(1024)            //Final image size will be less than 1 MB(Optional)
                        .start();
            }
        });
        vehicle_licence.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                type = "vehicle_licence";
//                startActivity(new Intent(NewOrderActivity.this, TakeImageCameraActivity2.class));

                startActivity(new Intent(NewOrderActivity.this, takeDoubleImgActivity.class));

//                BottomSheetDialogFragment_take_img bottomSheetDialogFragment_take_img = new BottomSheetDialogFragment_take_img("");
//                bottomSheetDialogFragment_take_img.show(getSupportFragmentManager(), "");

//                com.github.dhaval2404.imagepicker.ImagePicker.Builder builder = new com.github.dhaval2404.imagepicker.ImagePicker.Builder(NewOrderActivity.this);
//                builder.crop()                    //Crop image(Optional), Check Customization for more option
//                        .compress(1024)            //Final image size will be less than 1 MB(Optional)
//                        .start();
            }
        });

        String spinnerArray[] = {getResources().getString(R.string.select),getResources().getString(R.string.AbuDhabi), getResources().getString(R.string.Ajman), getResources().getString(R.string.Dubai), getResources().getString(R.string.Fujairah)};


        ArrayAdapter<String> spinnerArrayAdapter = new ArrayAdapter<String>
                (this, android.R.layout.simple_spinner_item,
                        spinnerArray); //selected item will look like a spinner set from XML
        spinnerArrayAdapter.setDropDownViewResource(android.R.layout
                .simple_spinner_dropdown_item);
        select_area_sp.setAdapter(spinnerArrayAdapter);

//        other.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//
//                type = "other";
////                startActivity(new Intent(NewOrderActivity.this, TakeImageCameraActivity2.class));
//
////                startActivity(new Intent(NewOrderActivity.this, takeDoubleImgActivity.class));
//
////                BottomSheetDialogFragment_take_img bottomSheetDialogFragment_take_img = new BottomSheetDialogFragment_take_img("");
////                bottomSheetDialogFragment_take_img.show(getSupportFragmentManager(), "");
//
//                com.github.dhaval2404.imagepicker.ImagePicker.Builder builder = new com.github.dhaval2404.imagepicker.ImagePicker.Builder(NewOrderActivity.this);
//                builder.crop()                    //Crop image(Optional), Check Customization for more option
//                        .compress(1024)            //Final image size will be less than 1 MB(Optional)
//                        .start();
//            }
//        });
//        aew_2.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//
//                type = "vehicle_inspection";
////                startActivity(new Intent(NewOrderActivity.this, TakeImageCameraActivity2.class));
//
////                startActivity(new Intent(NewOrderActivity.this, takeDoubleImgActivity.class));
//
////                BottomSheetDialogFragment_take_img bottomSheetDialogFragment_take_img = new BottomSheetDialogFragment_take_img("");
////                bottomSheetDialogFragment_take_img.show(getSupportFragmentManager(), "");
//
//                com.github.dhaval2404.imagepicker.ImagePicker.Builder builder = new com.github.dhaval2404.imagepicker.ImagePicker.Builder(NewOrderActivity.this);
//                builder.crop()                    //Crop image(Optional), Check Customization for more option
//                        .compress(1024)            //Final image size will be less than 1 MB(Optional)
//                        .start();
//            }
//        });
        car_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                type = "car_image";
//                startActivity(new Intent(NewOrderActivity.this, TakeImageCameraActivity2.class));

                startActivity(new Intent(NewOrderActivity.this, takeCarDoubleImgActivity.class));

//                BottomSheetDialogFragment_take_img bottomSheetDialogFragment_take_img = new BottomSheetDialogFragment_take_img("");
//                bottomSheetDialogFragment_take_img.show(getSupportFragmentManager(), "");

//                com.github.dhaval2404.imagepicker.ImagePicker.Builder builder = new com.github.dhaval2404.imagepicker.ImagePicker.Builder(NewOrderActivity.this);
//                builder.crop()                    //Crop image(Optional), Check Customization for more option
//                        .compress(1024)            //Final image size will be less than 1 MB(Optional)
//                        .start();
            }
        });
        Emirate_ID.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                type = "Emirate_ID";
                startActivity(new Intent(NewOrderActivity.this, takeDoubleImgActivity.class));


//                com.github.dhaval2404.imagepicker.ImagePicker.Builder builder = new com.github.dhaval2404.imagepicker.ImagePicker.Builder(NewOrderActivity.this);
//                builder.crop()                    //Crop image(Optional), Check Customization for more option
//                        .compress(1024)            //Final image size will be less than 1 MB(Optional)
//                        .start();
            }
        });
        other_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                type = "other_image";
//                startActivity(new Intent(NewOrderActivity.this, takeDoubleImgActivity.class));

                com.github.dhaval2404.imagepicker.ImagePicker.Builder builder = new com.github.dhaval2404.imagepicker.ImagePicker.Builder(NewOrderActivity.this);
                builder.crop()                    //Crop image(Optional), Check Customization for more option
                        .compress(1024)            //Final image size will be less than 1 MB(Optional)
                        .start();
//                com.github.dhaval2404.imagepicker.ImagePicker.Builder builder = new com.github.dhaval2404.imagepicker.ImagePicker.Builder(NewOrderActivity.this);
//                builder.crop()                    //Crop image(Optional), Check Customization for more option
//                        .compress(1024)            //Final image size will be less than 1 MB(Optional)
//                        .start();
            }
        });  other_image_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                type = "other_image_1";
//                startActivity(new Intent(NewOrderActivity.this, takeDoubleImgActivity.class));

                com.github.dhaval2404.imagepicker.ImagePicker.Builder builder = new com.github.dhaval2404.imagepicker.ImagePicker.Builder(NewOrderActivity.this);
                builder.crop()                    //Crop image(Optional), Check Customization for more option
                        .compress(1024)            //Final image size will be less than 1 MB(Optional)
                        .start();
//                com.github.dhaval2404.imagepicker.ImagePicker.Builder builder = new com.github.dhaval2404.imagepicker.ImagePicker.Builder(NewOrderActivity.this);
//                builder.crop()                    //Crop image(Optional), Check Customization for more option
//                        .compress(1024)            //Final image size will be less than 1 MB(Optional)
//                        .start();
            }
        });
        Driver_License.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                type = "Driver_License";
                startActivity(new Intent(NewOrderActivity.this, takeDoubleImgActivity.class));


//                com.github.dhaval2404.imagepicker.ImagePicker.Builder builder = new com.github.dhaval2404.imagepicker.ImagePicker.Builder(NewOrderActivity.this);
//                builder.crop()                    //Crop image(Optional), Check Customization for more option
//                        .compress(1024)            //Final image size will be less than 1 MB(Optional)
//                        .start();
            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (lay_1.getVisibility() == View.VISIBLE) {
                    finish();

                } else {
                    lay_1.setVisibility(View.VISIBLE);
                    lay_2.setVisibility(View.GONE);


                }
            }
        });


        sect_oo_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                type_comprehensive = "comprehensive";
                sect_oo_1.setBackground(getResources().getDrawable(R.drawable.button_selected));
                sect_oo_2.setBackground(getResources().getDrawable(R.drawable.border_not_selected));

                show_image();
            }
        });

        sect_oo_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                type_comprehensive = "against_others";

                sect_oo_1.setBackground(getResources().getDrawable(R.drawable.border_not_selected));
                sect_oo_2.setBackground(getResources().getDrawable(R.drawable.button_selected));

                show_image();

            }
        });
        sect_oo_1x.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sect_oo_1x.setBackground(getResources().getDrawable(R.drawable.button_selected));
                sect_oo_2x.setBackground(getResources().getDrawable(R.drawable.border_not_selected));
                type_comprehensive = "comprehensive";

            }
        });

        sect_oo_2x.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sect_oo_1x.setBackground(getResources().getDrawable(R.drawable.border_not_selected));
                sect_oo_2x.setBackground(getResources().getDrawable(R.drawable.button_selected));

                type_comprehensive = "against_others";

            }
        });
        yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Is_the_car_mortgaged = "yes";
                yes.setBackground(getResources().getDrawable(R.drawable.button_selected));
                no.setBackground(getResources().getDrawable(R.drawable.border_not_selected));
                name_bank.setVisibility(View.GONE);
                addres_register.setVisibility(View.GONE);
                address_data.setVisibility(View.VISIBLE);
                sect_oo_xxx.setVisibility(View.VISIBLE);

                lay_1_selectx.setVisibility(View.GONE);

                show_image();
            }

        });

        no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Is_the_car_mortgaged = "no";

                yes.setBackground(getResources().getDrawable(R.drawable.border_not_selected));
                no.setBackground(getResources().getDrawable(R.drawable.button_selected));

                name_bank.setVisibility(View.GONE);
                address_data.setVisibility(View.GONE);
                addres_register.setVisibility(View.GONE);
                lay_1_selectx.setVisibility(View.VISIBLE);
                sect_oo_xxx.setVisibility(View.GONE);

                show_image();

            }
        });
        aqwe1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insurance_type_Expired = "not_Expired";

                aqwe1.setBackground(getResources().getDrawable(R.drawable.button_selected));
                aqwe2.setBackground(getResources().getDrawable(R.drawable.border_not_selected));

                show_image();
            }
        });

        aqwe2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insurance_type_Expired = "Expired";

                aqwe1.setBackground(getResources().getDrawable(R.drawable.border_not_selected));
                aqwe2.setBackground(getResources().getDrawable(R.drawable.button_selected));

                show_image();

            }
        });

        select_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                type_car = "My_vehicle";
                select_1.setBackground(getResources().getDrawable(R.drawable.button_selected));
                select_2.setBackground(getResources().getDrawable(R.drawable.border_not_selected));
                select_3.setBackground(getResources().getDrawable(R.drawable.border_not_selected));

                lay_1_select.setVisibility(View.VISIBLE);
                tamen.setVisibility(View.VISIBLE);
                edit_jaha.setVisibility(View.GONE);
                yes_or_no.setVisibility(View.GONE);


                lay_1_selectx.setVisibility(View.GONE);
                sect_oo_xxx.setVisibility(View.GONE);
                address_data.setVisibility(View.GONE);
                addres_register.setVisibility(View.GONE);
                name_bank.setVisibility(View.GONE);


                aew_1.setVisibility(View.GONE);


                show_image();
            }
        });


        select_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                type_car = "Used_Car";

                select_1.setBackground(getResources().getDrawable(R.drawable.border_not_selected));
                select_2.setBackground(getResources().getDrawable(R.drawable.button_selected));
                select_3.setBackground(getResources().getDrawable(R.drawable.border_not_selected));
                lay_1_select.setVisibility(View.VISIBLE);
                edit_jaha.setVisibility(View.GONE);
                select_area.setVisibility(View.VISIBLE);
                tamen.setVisibility(View.GONE);
                yes_or_no.setVisibility(View.GONE);


                lay_1_selectx.setVisibility(View.GONE);
                sect_oo_xxx.setVisibility(View.GONE);
                address_data.setVisibility(View.GONE);
                addres_register.setVisibility(View.GONE);
                name_bank.setVisibility(View.GONE);


                aew_1.setVisibility(View.GONE);

                show_image();

            }
        });


        select_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                type_car = "New_Car";

                select_1.setBackground(getResources().getDrawable(R.drawable.border_not_selected));
                select_2.setBackground(getResources().getDrawable(R.drawable.border_not_selected));
                select_3.setBackground(getResources().getDrawable(R.drawable.button_selected));

                lay_1_select.setVisibility(View.GONE);
                edit_jaha.setVisibility(View.VISIBLE);
                yes_or_no.setVisibility(View.VISIBLE);
                tamen.setVisibility(View.GONE);


                lay_1_selectx.setVisibility(View.GONE);
                sect_oo_xxx.setVisibility(View.GONE);
                address_data.setVisibility(View.GONE);
                addres_register.setVisibility(View.GONE);
                name_bank.setVisibility(View.GONE);
                edit_jaha.setVisibility(View.GONE);


                aew_1.setVisibility(View.VISIBLE);

                show_image();

            }
        });

        edit_jaha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                LayoutInflater layoutInflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                final View popupView = layoutInflater.inflate(R.layout.alert_dialog_select, null);

                RecyclerView rec_all_data = popupView.findViewById(R.id.rec_all_data);


                LinearLayoutManager layoutManager1
                        = new LinearLayoutManager(NewOrderActivity.this, LinearLayoutManager.VERTICAL, false);
                rec_all_data.setLayoutManager(layoutManager1);


                List<String> list_data = new ArrayList<>();
                list_data.add("أبوظبي");
                list_data.add("دبي");
                list_data.add("الشارقة");
                list_data.add("عجمان");
                list_data.add("أم القيوين");
                list_data.add("رأس الخيمة");
                list_data.add("الفجيرة");


                RecyclerView_city recyclerView_city = new RecyclerView_city(NewOrderActivity.this, list_data);
                recyclerView_city.addItemClickListener(new RecyclerView_city.ItemClickListener() {
                    @Override
                    public void onItemClick(String title) {
                        edit_jaha.setText(title);
                        alertDialog.dismiss();
                    }
                });
                rec_all_data.setAdapter(recyclerView_city);

                final AlertDialog.Builder builder = new AlertDialog.Builder(NewOrderActivity.this);

//            alertDialog_country =
                builder.setView(popupView);


                alertDialog = builder.show();
            }
        });
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                send();
//                if (emirate_id_front_image == null || driver_license_from_front == null) {
//
//
//                    if (emirate_id_front_image == null) {
//                        Emirate_ID_txt.setError(getResources().getString(R.string.required));
//
//                    }
//                    if (driver_license_from_front == null) {
//                        Driver_License_txt.setError(getResources().getString(R.string.required));
//
//                    }
//                } else {
//
//                    if (type_car.toString().equals("Used_Car")) {
//                        if (ownership_photo_from_front == null) {//
//
//
//                            OwnerShip_txt.setError(getResources().getString(R.string.required));
//
//
//                        } else {
//                            sub_();
//
//                        }
//
//                    } else {
//                        sub_();
//
//                    }
//
//
//                }

//                if (type_car.toString().equals("My_vehicle") && insurance_type_Expired.toString().equals("Expired")) {
//
//                    if (emirate_id_front_image == null || driver_license_from_front == null | vehicle_inspection_file == null | car_left_side_image == null) {
//                        if (car_left_side_image == null) {
//                            car_image_txt.setError(getResources().getString(R.string.required));
//                        }
//                        if (vehicle_inspection_file == null) {
//                            vehicle_inspection_txt.setError(getResources().getString(R.string.required));
//                        }
//                        if (emirate_id_front_image == null) {
//                            Emirate_ID_txt.setError(getResources().getString(R.string.required));
//
//                        }
//                        if (driver_license_from_front == null) {
//                            Driver_License_txt.setError(getResources().getString(R.string.required));
//
//                        }
//                    } else {
//                        sub_();
//
//                    }
//
//
//                } else if (type_car.toString().equals("My_vehicle") && insurance_type_Expired.toString().equals("not_Expired")) {
//                    if (emirate_id_front_image == null || driver_license_from_front == null) {
////                        if (car_left_side_image == null) {
////                            car_image_txt.setError(getResources().getString(R.string.required));
////                        }
////                        if (vehicle_inspection_file == null) {
////                            vehicle_inspection_txt.setError(getResources().getString(R.string.required));
////                        }
//                        if (emirate_id_front_image == null) {
//                            Emirate_ID_txt.setError(getResources().getString(R.string.required));
//
//                        }
//                        if (driver_license_from_front == null) {
//                            Driver_License_txt.setError(getResources().getString(R.string.required));
//
//                        }
//                    } else {
//                        sub_();
//
//                    }
//
//
//                } else {
//                    sub_();
//
//                }


            }
        });


        terms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(NewOrderActivity.this, TermsConditionActivity.class));
            }
        });
    }

    public void init_volley() {

        mResultCallback = new IResult() {
            @Override
            public void notifySuccess(String requestType, JSONObject response) {
                Log.d("TAG", "Volley requester " + requestType);
                Log.d("TAG", "Volley JSON post" + response);
                //{"status":true,"code":200,"message":"User Profile","data"
                WebService.loading(NewOrderActivity.this, false);
                loading.setVisibility(View.GONE);
                submit.setVisibility(View.VISIBLE);


                try {
                    boolean status = response.getBoolean("status");
                    String mesg = response.getString("message");
                    if (status) {


                        if (requestType.equals("sendMotorRequest")) {

//
                            WebService.Make_Toast_color(NewOrderActivity.this, mesg, "success");


                            Intent intent = new Intent(NewOrderActivity.this, VirficationOrderActivity.class);
                            intent.putExtra("mobile", phone.getText().toString() + "");
                            Hawk.put("Email", email.getText().toString() + "");
                            startActivity(intent);

                            finish();
//                            Hawk.put("Ads", response.toString() + "");
//
//                            JsonParser parser = new JsonParser();
//                            JsonElement mJson = parser.parse(response.toString());
//
//                            Gson gson = new Gson();
//                            MotoTypeInsuranceModules motoTypeInsuranceModules = gson.fromJson(mJson, MotoTypeInsuranceModules.class);
////
////
//
//                            all_insurance.setAdapter(new RecyclerView_car_ins(DetailsInsuranceActivity.this, motoTypeInsuranceModules.getInsurancesTypes()));
//

//                            viewPager.setAdapter(new viewPager_Adapter_slider(WelcomeActivity.this, allDiscountModules.getAds()));
//
//                            view_pager_indicator.setupWithViewPager(viewPager);


//                            all_discount.setAdapter(new RecyclerView_all_discounts(AllCardsActivity.this, allDiscountModules.getResult()));
//                            cards_rec.setAdapter(new RecyclerView_card_home(getContext(), homeModule.getResult().getCategories()));
//                            Discounts_rec.setAdapter(new RecyclerView_discounts_home(getContext(), homeModule.getResult().getDiscounts()));
//                            Intent intent = new Intent(VirficationActivity.this, MainActivity.class);
//                        intent.putExtra("mobile", mobile.getText().toString());
//                            startActivity(intent);
                        }

                    } else {
//                        btn_id.revertAnimation();
//                        {"status":false,"code":201,"message":"Please Enter True Mobile Number and Password"}
                        String message = response.getString("message");

                        WebService.Make_Toast_color(NewOrderActivity.this, message, "error");

                    }


                } catch (Exception e) {
                    e.printStackTrace();
                }


            }


            @Override
            public void notifyError(String requestType, VolleyError error) {
                Log.d("TAG", "Volley requester " + requestType);
                Log.d("TAG", "Volley JSON post" + "That didn't work!" + error.getMessage());
//                loading.setVisibility(View.GONE);
                WebService.loading(NewOrderActivity.this, false);
                loading.setVisibility(View.GONE);
                submit.setVisibility(View.VISIBLE);

                try {
//                    btn_id.stopAnimation();
//                    btn_id.revertAnimation();

                    NetworkResponse response = error.networkResponse;
                    String response_data = new String(response.data);

                    JSONObject jsonObject = new JSONObject(response_data);

                    String message = jsonObject.getString("message");


                    WebService.Make_Toast_color(NewOrderActivity.this, message, "error");

                    Log.e("error response", response_data);

                } catch (Exception e) {

                }


            }

            @Override
            public void notify_Async_Error(String requestType, String error) {
//                loading.setVisibility(View.GONE);
                WebService.loading(NewOrderActivity.this, false);

                loading.setVisibility(View.GONE);
                submit.setVisibility(View.VISIBLE);

                WebService.Make_Toast_color(NewOrderActivity.this, error, "error");

            }
        };


    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {


        if (type_front_or_back.equals("other")) {
            Uri uri = data.getData();


            if (uri != null) {
//                SignUpFragment.get_image(uri);

                File file = new File(uri.getPath());
                other_file = file;
//                other.setImageDrawable(getResources().getDrawable(R.drawable.ic_baseline_check_circle_111));
//                    Emirate_ID.setImageDrawable(getResources().getDrawable(R.drawable.ic_baseline_check_circle_111));
//                    Driver_License.setImageDrawable(getResources().getDrawable(R.drawable.ic_baseline_check_circle_111));
//                    Bitmap myBitmap = BitmapFactory.decodeFile(file.getAbsolutePath());
//                    imagex.setImageBitmap(myBitmap);
            }

        } else if (type_front_or_back.equals("vehicle_inspection")) {
            Uri uri = data.getData();

            if (uri != null) {
//                SignUpFragment.get_image(uri);

                File file = new File(uri.getPath());
                vehicle_inspection_file = file;
//                ivehicle_inspection_img.setImageDrawable(getResources().getDrawable(R.drawable.ic_baseline_check_circle_111));
//                    Emirate_ID.setImageDrawable(getResources().getDrawable(R.drawable.ic_baseline_check_circle_111));
//                    Driver_License.setImageDrawable(getResources().getDrawable(R.drawable.ic_baseline_check_circle_111));
//                    Bitmap myBitmap = BitmapFactory.decodeFile(file.getAbsolutePath());
//                    imagex.setImageBitmap(myBitmap);
            }
        } else if (type.equals("examination_of_the_vehicle_image")) {
            Uri uri = data.getData();

            if (uri != null) {
//                SignUpFragment.get_image(uri);

                File file = new File(uri.getPath());
                vehicle_inspection_file = file;
//                ownership_photo_from_back = file;
                ownership.setImageDrawable(activity.getResources().getDrawable(R.drawable.ic_baseline_check_circle_111));

//                ivehicle_inspection_img.setImageDrawable(getResources().getDrawable(R.drawable.ic_baseline_check_circle_111));
//                    Emirate_ID.setImageDrawable(getResources().getDrawable(R.drawable.ic_baseline_check_circle_111));
//                    Driver_License.setImageDrawable(getResources().getDrawable(R.drawable.ic_baseline_check_circle_111));
//                    Bitmap myBitmap = BitmapFactory.decodeFile(file.getAbsolutePath());
//                    imagex.setImageBitmap(myBitmap);
            }
        }else if (type.equals("other_image")) {
            Uri uri = data.getData();

            if (uri != null) {
//                SignUpFragment.get_image(uri);

                File file = new File(uri.getPath());
                other_file = file;

                other_image.setImageDrawable(activity.getResources().getDrawable(R.drawable.ic_baseline_check_circle_111));

//                ivehicle_inspection_img.setImageDrawable(getResources().getDrawable(R.drawable.ic_baseline_check_circle_111));
//                    Emirate_ID.setImageDrawable(getResources().getDrawable(R.drawable.ic_baseline_check_circle_111));
//                    Driver_License.setImageDrawable(getResources().getDrawable(R.drawable.ic_baseline_check_circle_111));
//                    Bitmap myBitmap = BitmapFactory.decodeFile(file.getAbsolutePath());
//                    imagex.setImageBitmap(myBitmap);
            }
        }else if (type.equals("other_image_1")) {
            Uri uri = data.getData();

            if (uri != null) {
//                SignUpFragment.get_image(uri);

                File file = new File(uri.getPath());
                other_file = file;

                other_image_1.setImageDrawable(activity.getResources().getDrawable(R.drawable.ic_baseline_check_circle_111));

//                ivehicle_inspection_img.setImageDrawable(getResources().getDrawable(R.drawable.ic_baseline_check_circle_111));
//                    Emirate_ID.setImageDrawable(getResources().getDrawable(R.drawable.ic_baseline_check_circle_111));
//                    Driver_License.setImageDrawable(getResources().getDrawable(R.drawable.ic_baseline_check_circle_111));
//                    Bitmap myBitmap = BitmapFactory.decodeFile(file.getAbsolutePath());
//                    imagex.setImageBitmap(myBitmap);
            }
        }

        super.onActivityResult(requestCode, resultCode, data);
    }


    public static void save_img(File front_file, File back_file) {

        if (type.equals("ownership")) {


            ownership_photo_from_front = front_file;
            ownership_photo_from_back = back_file;

            ownership.setImageDrawable(activity.getResources().getDrawable(R.drawable.ic_baseline_check_circle_111));
            OwnerShip_txt.setError(null);

        } else if (type.equals("Emirate_ID")) {


            emirate_id_front_image = front_file;
            emirate_id_back_image = back_file;
            Emirate_ID.setImageDrawable(activity.getResources().getDrawable(R.drawable.ic_baseline_check_circle_111));
            Emirate_ID_txt.setError(null);




        } else if (type.equals("vehicle_licence")) {

            ownership_photo_from_front = front_file;
            ownership_photo_from_back = back_file;

//            vehicle_licence = front_file;
//            vehicle_licence_filr = back_file;
            vehicle_licence.setImageDrawable(activity.getResources().getDrawable(R.drawable.ic_baseline_check_circle_111));

            vehicle_inspection_txt.setError(null);
        }
//        else if (type.equals("other_image")) {
//
//
////            vehicle_licence = front_file;
//            other_image_file = back_file;
//            other_image.setImageDrawable(activity.getResources().getDrawable(R.drawable.ic_baseline_check_circle_111));
//
//        }

        else if (type.equals("Driver_License")) {




            driver_license_from_front = front_file;
            driver_license_from_back = back_file;
            Driver_License.setImageDrawable(activity.getResources().getDrawable(R.drawable.ic_baseline_check_circle_111));

            Driver_License_txt.setError(null);




        }

    }

    public static void save_img_4(File front_file, File back_file, File left_file, File right_file) {
        car_front_image = front_file;
        car_back_image = back_file;
        car_right_side_image = right_file;
        car_left_side_image = left_file;

        car_image.setImageDrawable(activity.getResources().getDrawable(R.drawable.ic_baseline_check_circle_111));
        car_image_txt.setError(null);

    }

    public static File bitmapToFile(Context context, Bitmap bitmap, String fileNameToSave) { // File name like "image.png"
        //create a file to write bitmap data
        File file = null;
        try {
            file = new File(Environment.getExternalStorageDirectory() + File.separator + fileNameToSave);
            file.createNewFile();

//Convert bitmap to byte array
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.PNG, 0, bos); // YOU can also save it in JPEG
            byte[] bitmapdata = bos.toByteArray();

//write the bytes in file
            FileOutputStream fos = new FileOutputStream(file);
            fos.write(bitmapdata);
            fos.flush();
            fos.close();
            return file;
        } catch (Exception e) {
            e.printStackTrace();
            return file; // it will return null
        }
    }

    @Override
    public void onBackPressed() {

        if (lay_1.getVisibility() == View.VISIBLE) {
            finish();

        } else {
            lay_1.setVisibility(View.VISIBLE);
            lay_2.setVisibility(View.GONE);


        }


    }

    public void sub_() {

        loading.setVisibility(View.VISIBLE);
        submit.setVisibility(View.GONE);


        RequestParams requestParams = new RequestParams();


        try {


            requestParams.put("insurance_type_id", "" + id);
            requestParams.put("name", name.getText().toString() + "");
            requestParams.put("date_birth", "5/2/1994");
            requestParams.put("email", email.getText().toString() + "");
            requestParams.put("mobile", ncode_mobile + phone.getText().toString() + "");
            requestParams.put("title", "Test For Contact Us System");
            requestParams.put("license_issue_date", "2020/10/10");
            requestParams.put("id_number", "353450020");
            requestParams.put("insurance_type", type_comprehensive);
            requestParams.put("agency_id", "1");
            requestParams.put("vehicle_type_id", "1");
            requestParams.put("manufacturing_year", "2019");
            requestParams.put("cylinder_number", "8");
            requestParams.put("vehicle_structure_id", "1");
            requestParams.put("motor_choice_id", "Gulf");
            requestParams.put("traffic_code", "2432343");
            requestParams.put("driving_license_issuance_date", "2021/12/12");
            requestParams.put("driving_license_expiration_date", "2025/12/12");
            requestParams.put("expiry_date_current_insurance", "2030/09/09");
            requestParams.put("current_price", "22552");
            requestParams.put("has_accident", "no");
            requestParams.put("type_car",type_car );
            requestParams.put("insurance_validity",insurance_type_Expired );//type_comprehensive


            if(type_car.toString().equals("New_Car")){
                requestParams.put("is_mortgaged",Is_the_car_mortgaged );
                requestParams.put("name_mortgaged_bank",name_bank.getText().toString());
                requestParams.put("insurance_documents",address_data.getText().toString());

            }else{
                requestParams.put("is_mortgaged","" );
                requestParams.put("name_mortgaged_bank","");

            }



//
//            ownership_photo_from_front صورة الملكية من الامام
//            ownership_photo_from_back صورة الملكية من الخلف
//            driver_license_from_front رخصة القيادة من الامام
//            driver_license_from_back رخصة القيادة من الخلف
//            car_front_image المركبة من الامام
//            car_back_image المركبة من الخلف
//            car_right_side_image المركبة من اليمين
//            car_left_side_image المركبة من اليسار


//            emirate_id_front_image الهوية من الامام
//            emirate_id_back_image الهوية من الخلف
//            examination_of_the_vehicle_image صورة الفخص




//            Bitmap b = Bitmap.createBitmap(100, 100, Bitmap.Config.ARGB_8888);
//            Canvas c = new Canvas(b);
//
//            File file = bitmapToFile(NewOrderActivity.this, b, "image.png");

            if (ownership_photo_from_front != null) {
                requestParams.put("ownership_photo_from_front", ownership_photo_from_front);

            }
            if (ownership_photo_from_back != null) {
                requestParams.put("ownership_photo_from_back", ownership_photo_from_back);

            }
            if (driver_license_from_front != null) {
                requestParams.put("driver_license_from_front", driver_license_from_front);

            }
            if (driver_license_from_back != null) {
                requestParams.put("driver_license_from_back", driver_license_from_back);

            }

            if (car_front_image != null) {
                requestParams.put("car_front_image", car_front_image);
            }
            if (car_back_image != null) {
                requestParams.put("car_back_image", car_back_image);
            }
            if (car_right_side_image != null) {
                requestParams.put("car_right_side_image", car_right_side_image);
            }
            if (car_left_side_image != null) {
                requestParams.put("car_left_side_image", car_left_side_image);
            }
            if (emirate_id_front_image != null) {
                requestParams.put("emirate_id_front_image", emirate_id_front_image);
                requestParams.put("emirate_id_back_image", emirate_id_back_image);
            }
            if (other_file != null) {
                requestParams.put("other_photos", other_file);
            }
            if (vehicle_inspection_file != null) {
                requestParams.put("examination_of_the_vehicle_image", vehicle_inspection_file);
            }



        } catch (Exception e) {
            e.printStackTrace();
        }

        init_volley();
//                    WebService.loading(ContactUsActivity.this, true);
        VolleyService mVolleyService = new VolleyService(mResultCallback, NewOrderActivity.this);
        mVolleyService.postDataasync_with_file("sendMotorRequest", WebService.sendMotorRequest, requestParams);//category/1/product

    }


    public void show_image() {
        other_image_layout.setVisibility(View.VISIBLE);
        vehicle_licence_layout.setVisibility(View.VISIBLE);
        car_image_layout.setVisibility(View.VISIBLE);
        select_area.setVisibility(View.GONE);
        sect_oo_2x.setVisibility(View.VISIBLE);

        OwnerShip_txt.setText(getResources().getString(R.string.examination2));//اختياري
        car_image_txt.setText(getResources().getString(R.string.vehicle2));//اختياري



        if (type_car.toString().equals("My_vehicle") && type_comprehensive.toString().equals("comprehensive") && insurance_type_Expired.toString().equals("not_Expired")
        ) {
            other_image_layout.setVisibility(View.GONE);

            OwnerShip_txt.setText(getResources().getString(R.string.examination));//اختياري
            car_image_txt.setText(getResources().getString(R.string.vehicle));//اختياري






        } else if (type_car.toString().equals("My_vehicle") && type_comprehensive.toString().equals("comprehensive") && insurance_type_Expired.toString().equals("Expired")
        ) {
            other_image_layout.setVisibility(View.GONE);
            OwnerShip_txt.setText(getResources().getString(R.string.examination2));
            car_image_txt.setText(getResources().getString(R.string.vehicle2));




        } else if (type_car.toString().equals("My_vehicle") && type_comprehensive.toString().equals("against_others") && insurance_type_Expired.toString().equals("not_Expired")
        ) {
            other_image_layout.setVisibility(View.GONE);
            vehicle_licence_layout.setVisibility(View.GONE);


            OwnerShip_txt.setText(getResources().getString(R.string.examination));
            car_image_txt.setText(getResources().getString(R.string.vehicle2));







        } else if (type_car.toString().equals("My_vehicle") && type_comprehensive.toString().equals("against_others") && insurance_type_Expired.toString().equals("Expired")
        ) {
            other_image_layout.setVisibility(View.GONE);




            OwnerShip_txt.setText(getResources().getString(R.string.examination2));
            car_image_txt.setText(getResources().getString(R.string.vehicle2));



        }

        //---------------------------------------------------------------------


        else if (type_car.toString().equals("Used_Car") && type_comprehensive.toString().equals("comprehensive")
        ) {
            select_area.setVisibility(View.VISIBLE);
            other_image_layout.setVisibility(View.GONE);
            vehicle_licence_layout.setVisibility(View.GONE);
            car_image_layout.setVisibility(View.GONE);
        } else if (type_car.toString().equals("Used_Car") && type_comprehensive.toString().equals("against_others")
        ) {
            select_area.setVisibility(View.VISIBLE);
            other_image_layout.setVisibility(View.GONE);
            vehicle_licence_layout.setVisibility(View.GONE);
            car_image_layout.setVisibility(View.GONE);

        }

        //---------------------------------------------------------------------


        else if (type_car.toString().equals("New_Car")
        ) {
            select_area.setVisibility(View.VISIBLE);
            other_image_layout.setVisibility(View.GONE);
            vehicle_licence_layout.setVisibility(View.GONE);
            car_image_layout.setVisibility(View.GONE);


            if (Is_the_car_mortgaged.toString().equals("yes")) {
                name_bank.setVisibility(View.VISIBLE);
                address_data.setVisibility(View.VISIBLE);
                addres_register.setVisibility(View.GONE);
                lay_1_selectx.setVisibility(View.VISIBLE);
                sect_oo_xxx.setVisibility(View.GONE);
                sect_oo_2x.setVisibility(View.GONE);
                sect_oo_1x.setBackground(getResources().getDrawable(R.drawable.button_selected));
                sect_oo_2x.setBackground(getResources().getDrawable(R.drawable.border_not_selected));

                 type_comprehensive = "comprehensive";

            } else {
                name_bank.setVisibility(View.GONE);
                address_data.setVisibility(View.GONE);
                addres_register.setVisibility(View.GONE);
                lay_1_selectx.setVisibility(View.VISIBLE);
                sect_oo_xxx.setVisibility(View.GONE);
                sect_oo_2x.setVisibility(View.VISIBLE);
            }


        }


    }
    public void send() {
//        other_image_layout.setVisibility(View.VISIBLE);
//        vehicle_licence_layout.setVisibility(View.VISIBLE);
//        car_image_layout.setVisibility(View.VISIBLE);
//        select_area.setVisibility(View.GONE);
//
//        OwnerShip_txt.setText(getResources().getString(R.string.examination2));//اختياري
//        car_image_txt.setText(getResources().getString(R.string.vehicle2));//اختياري



        if (type_car.toString().equals("My_vehicle") && type_comprehensive.toString().equals("comprehensive") && insurance_type_Expired.toString().equals("not_Expired")
        ) {
//            other_image_layout.setVisibility(View.GONE);
//
//            OwnerShip_txt.setText(getResources().getString(R.string.examination));//اختياري
//            car_image_txt.setText(getResources().getString(R.string.vehicle));//اختياري
//


            if(driver_license_from_front==null | emirate_id_front_image==null| ownership_photo_from_front==null){

                if(driver_license_from_front==null){
                    Driver_License_txt.setError(getResources().getString(R.string.required));
                }
                if(emirate_id_front_image==null){
                    Emirate_ID_txt.setError(getResources().getString(R.string.required));
                }
                if(ownership_photo_from_front==null){
                    vehicle_inspection_txt.setError(getResources().getString(R.string.required));
                }
            }else{
                sub_();
            }




        } else if (type_car.toString().equals("My_vehicle") && type_comprehensive.toString().equals("comprehensive") && insurance_type_Expired.toString().equals("Expired")
        ) {
//            other_image_layout.setVisibility(View.GONE);
//            OwnerShip_txt.setText(getResources().getString(R.string.examination2));
//            car_image_txt.setText(getResources().getString(R.string.vehicle2));
//


            if(driver_license_from_front==null | emirate_id_front_image==null| ownership_photo_from_front==null){

                if(driver_license_from_front==null){
                    Driver_License_txt.setError(getResources().getString(R.string.required));
                }
                if(emirate_id_front_image==null){
                    Emirate_ID_txt.setError(getResources().getString(R.string.required));
                }
                if(ownership_photo_from_front==null){
                    vehicle_inspection_txt.setError(getResources().getString(R.string.required));
                }


            }else if(car_front_image==null && vehicle_inspection_file==null){
//                if(ownership_photo_from_front!=null){
//                    OwnerShip_txt.setError(getResources().getString(R.string.required));
//                }
//                if(car_front_image==null){
//                    car_image_txt.setError(getResources().getString(R.string.required));
//                }



                Toast toast = Toast.makeText(this, Html.fromHtml("<font color='#e83d31' ><b>" + getResources().getString(R.string.required2) + "</b></font>"), Toast.LENGTH_LONG);
                toast.setGravity(Gravity.TOP, 0, 0);
                toast.show();

            }



            else{
                sub_();
            }




        } else if (type_car.toString().equals("My_vehicle") && type_comprehensive.toString().equals("against_others") && insurance_type_Expired.toString().equals("not_Expired")
        ) {
//            other_image_layout.setVisibility(View.GONE);
//            vehicle_licence_layout.setVisibility(View.GONE);
//
//
//            OwnerShip_txt.setText(getResources().getString(R.string.examination));
//            car_image_txt.setText(getResources().getString(R.string.vehicle2));
//
//



            if(driver_license_from_front==null | emirate_id_front_image==null| car_front_image==null){

                if(driver_license_from_front==null){
                    Driver_License_txt.setError(getResources().getString(R.string.required));
                }
                if(emirate_id_front_image==null){
                    Emirate_ID_txt.setError(getResources().getString(R.string.required));
                }
                if(car_front_image==null){
                    car_image_txt.setError(getResources().getString(R.string.required));
                }
            }else{
                sub_();
            }





        } else if (type_car.toString().equals("My_vehicle") && type_comprehensive.toString().equals("against_others") && insurance_type_Expired.toString().equals("Expired")
        ) {
//            other_image_layout.setVisibility(View.GONE);
//
//
//
//
//            OwnerShip_txt.setText(getResources().getString(R.string.examination2));
//            car_image_txt.setText(getResources().getString(R.string.vehicle2));
//
//            if(driver_license_from_front==null | emirate_id_front_image==null| vehicle_licence_filr==null| car_front_image==null| ownership_photo_from_front==null){
//
//                if(driver_license_from_front==null){
//                    Driver_License_txt.setError(getResources().getString(R.string.required));
//                }
//                if(emirate_id_front_image==null){
//                    Emirate_ID_txt.setError(getResources().getString(R.string.required));
//                }
//                if(vehicle_licence_filr==null){
//                    vehicle_inspection_txt.setError(getResources().getString(R.string.required));
//                }
//                if(car_front_image==null){
//                    car_image_txt.setError(getResources().getString(R.string.required));
//                }
//                if(ownership_photo_from_front==null){
//                    OwnerShip_txt.setError(getResources().getString(R.string.required));
//                }
//            }else{
//                sub_();
//            }

            if(driver_license_from_front==null | emirate_id_front_image==null| ownership_photo_from_front==null){

                if(driver_license_from_front==null){
                    Driver_License_txt.setError(getResources().getString(R.string.required));
                }
                if(emirate_id_front_image==null){
                    Emirate_ID_txt.setError(getResources().getString(R.string.required));
                }
                if(ownership_photo_from_front==null){
                    vehicle_inspection_txt.setError(getResources().getString(R.string.required));
                }


            }else if(car_front_image==null && vehicle_inspection_file==null){
//                if(ownership_photo_from_front!=null){
//                    OwnerShip_txt.setError(getResources().getString(R.string.required));
//                }
//                if(car_front_image==null){
//                    car_image_txt.setError(getResources().getString(R.string.required));
//                }



                Toast toast = Toast.makeText(this, Html.fromHtml("<font color='#e83d31' ><b>" + getResources().getString(R.string.required2) + "</b></font>"), Toast.LENGTH_LONG);
                toast.setGravity(Gravity.TOP, 0, 0);
                toast.show();

            }



            else{
                sub_();
            }


        }

        //---------------------------------------------------------------------


        else if (type_car.toString().equals("Used_Car") && type_comprehensive.toString().equals("comprehensive")
        ) {
//            select_area.setVisibility(View.VISIBLE);
//            other_image_layout.setVisibility(View.GONE);
//            vehicle_licence_layout.setVisibility(View.GONE);
//            car_image_layout.setVisibility(View.GONE);


            if(driver_license_from_front==null | emirate_id_front_image==null| vehicle_inspection_file==null){

                if(driver_license_from_front==null){
                    Driver_License_txt.setError(getResources().getString(R.string.required));
                }
                if(emirate_id_front_image==null){
                    Emirate_ID_txt.setError(getResources().getString(R.string.required));
                }
                if(vehicle_inspection_file==null){
                    OwnerShip_txt.setError(getResources().getString(R.string.required));
                }
            }else{
                sub_();
            }


        } else if (type_car.toString().equals("Used_Car") && type_comprehensive.toString().equals("against_others")
        ) {
//            select_area.setVisibility(View.VISIBLE);
//            other_image_layout.setVisibility(View.GONE);
//            vehicle_licence_layout.setVisibility(View.GONE);
//            car_image_layout.setVisibility(View.GONE);
            if(driver_license_from_front==null | emirate_id_front_image==null| vehicle_inspection_file==null){

                if(driver_license_from_front==null){
                    Driver_License_txt.setError(getResources().getString(R.string.required));
                }
                if(emirate_id_front_image==null){
                    Emirate_ID_txt.setError(getResources().getString(R.string.required));
                }
                if(vehicle_inspection_file==null){
                    OwnerShip_txt.setError(getResources().getString(R.string.required));
                }
            }else{
                sub_();
            }

        }

        //---------------------------------------------------------------------


        else if (type_car.toString().equals("New_Car")
        ) {
//            select_area.setVisibility(View.VISIBLE);
//            other_image_layout.setVisibility(View.GONE);
//            vehicle_licence_layout.setVisibility(View.GONE);
//            car_image_layout.setVisibility(View.GONE);


            if(driver_license_from_front==null | emirate_id_front_image==null| vehicle_inspection_file==null){

                if(driver_license_from_front==null){
                    Driver_License_txt.setError(getResources().getString(R.string.required));
                }
                if(emirate_id_front_image==null){
                    Emirate_ID_txt.setError(getResources().getString(R.string.required));
                }
                if(vehicle_inspection_file==null){
                    OwnerShip_txt.setError(getResources().getString(R.string.required));
                }
            }else{
                sub_();
            }

            if (Is_the_car_mortgaged.toString().equals("yes")) {
//                name_bank.setVisibility(View.VISIBLE);
//                address_data.setVisibility(View.VISIBLE);
//                addres_register.setVisibility(View.GONE);
//                lay_1_selectx.setVisibility(View.VISIBLE);
//                sect_oo_xxx.setVisibility(View.GONE);

            } else {
//                name_bank.setVisibility(View.GONE);
//                address_data.setVisibility(View.GONE);
//                addres_register.setVisibility(View.GONE);
//                lay_1_selectx.setVisibility(View.VISIBLE);
//                sect_oo_xxx.setVisibility(View.GONE);
            }


        }


    }


}