package com.osama.insurco.ui.Order;

import static com.osama.insurco.Settings.WebService.ncode_mobile;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.android.volley.NetworkResponse;
import com.android.volley.VolleyError;
import com.loopj.android.http.RequestParams;
import com.orhanobut.hawk.Hawk;
import com.osama.insurco.R;
import com.osama.insurco.Settings.BaseActivity;
import com.osama.insurco.Settings.Settings;
import com.osama.insurco.Settings.WebService;
import com.osama.insurco.api.IResult;
import com.osama.insurco.api.VolleyService;
import com.osama.insurco.ui.Auth.VirficationOrderActivity;
import com.osama.insurco.ui.StaticsPages.TermsConditionActivity;
import com.osama.insurco.ui.camera.takeDoubleImgActivity;
import com.osama.insurco.ui.camera.takeDoubleImgHActivity;
import com.osama.insurco.ui.camera.takeDoubleImgHelathActivity;

import org.json.JSONObject;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;

public class NewOrderHelthActivity extends BaseActivity {
    EditText name;
    EditText phone;
    EditText email;
    IResult mResultCallback;


    CheckBox accept;
    TextView terms;
    LinearLayout next;
    LinearLayout lay_1;
    LinearLayout lay_2;
    LinearLayout Are_you_pregnant_lay;


    File ownershipFile;
    static File Emirate_IDFile_front;
    static File Emirate_IDFile_back;
    static Activity activity;
    File visa_page_imageFile;

    ImageView ownership;
    static ImageView Emirate_ID;
    ImageView visa_page_image;
    ProgressBar loading;
    LinearLayout submit;

    TextView OwnerShip_txt;
    TextView Emirate_ID_txt;
    TextView visa_page_image_txt;
    TextView chronic_txt;
    TextView Gender_txt;
    TextView Are_you_pregnant_txt;
    TextView has_you_insurance_txt;




    Spinner Gender;
    Spinner Are_you_pregnant;
    Spinner has_you_insurance;
    Spinner chronic;
    ImageView back;


    String type = "";
    String id = "";







    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_order_helth);
        getSupportActionBar().hide();
        activity = this;
        back = findViewById(R.id.back);
        name = findViewById(R.id.name);
        phone = findViewById(R.id.phone);
        email = findViewById(R.id.email);
        accept = findViewById(R.id.accept);
        terms = findViewById(R.id.terms);
        next = findViewById(R.id.next);
        lay_1 = findViewById(R.id.lay_1);
        Are_you_pregnant_lay = findViewById(R.id.Are_you_pregnant_lay);
        lay_2 = findViewById(R.id.lay_2);
        ownership = findViewById(R.id.ownership);
        Emirate_ID = findViewById(R.id.Emirate_ID);
        visa_page_image = findViewById(R.id.visa_page_image);
        loading = findViewById(R.id.loading);
        submit = findViewById(R.id.submit);
        OwnerShip_txt = findViewById(R.id.OwnerShip_txt);
        Emirate_ID_txt = findViewById(R.id.Emirate_ID_txt);
        visa_page_image_txt = findViewById(R.id.visa_page_image_txt);
        Gender = findViewById(R.id.Genders);
        Are_you_pregnant = findViewById(R.id.Are_you_pregnant);
        has_you_insurance = findViewById(R.id.has_you_insurance);
        chronic = findViewById(R.id.chronic);
        chronic_txt = findViewById(R.id.chronic_txt);
        Gender_txt = findViewById(R.id.Gender_txt);
        Are_you_pregnant_txt = findViewById(R.id.Are_you_pregnant_txt);
        has_you_insurance_txt = findViewById(R.id.has_you_insurance_txt);




        try {
            id = getIntent().getStringExtra("id");
        } catch (Exception e) {

        }
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
        getWindow().setStatusBarColor(ContextCompat.getColor(NewOrderHelthActivity.this, R.color.purple_200));
        Emirate_ID.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


//                startActivity(new Intent(NewOrderActivity.this, TakeImageCameraActivity2.class));

                type = "Emirate_ID";
                startActivity(new Intent(NewOrderHelthActivity.this, takeDoubleImgHActivity.class));

//                startActivity(new Intent(NewOrderHelthActivity.this, takeDoubleImgHelathActivity.class));

//                BottomSheetDialogFragment_take_img bottomSheetDialogFragment_take_img = new BottomSheetDialogFragment_take_img("");
//                bottomSheetDialogFragment_take_img.show(getSupportFragmentManager(), "");

//                com.github.dhaval2404.imagepicker.ImagePicker.Builder builder = new com.github.dhaval2404.imagepicker.ImagePicker.Builder(NewOrderActivity.this);
//                builder.crop()                    //Crop image(Optional), Check Customization for more option
//                        .compress(1024)            //Final image size will be less than 1 MB(Optional)
//                        .start();
            }
        });
        ownership.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


//                startActivity(new Intent(NewOrderActivity.this, TakeImageCameraActivity2.class));

//                startActivity(new Intent(NewOrderHelthActivity.this, takeDoubleImgHelathActivity.class));

//                BottomSheetDialogFragment_take_img bottomSheetDialogFragment_take_img = new BottomSheetDialogFragment_take_img("");
//                bottomSheetDialogFragment_take_img.show(getSupportFragmentManager(), "");

                type = "ownership";
                com.github.dhaval2404.imagepicker.ImagePicker.Builder builder = new com.github.dhaval2404.imagepicker.ImagePicker.Builder(NewOrderHelthActivity.this);
                builder.crop()                    //Crop image(Optional), Check Customization for more option
                        .compress(1024)            //Final image size will be less than 1 MB(Optional)
                        .start();
            }
        });
        visa_page_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


//                startActivity(new Intent(NewOrderActivity.this, TakeImageCameraActivity2.class));

//                startActivity(new Intent(NewOrderHelthActivity.this, takeDoubleImgHelathActivity.class));

//                BottomSheetDialogFragment_take_img bottomSheetDialogFragment_take_img = new BottomSheetDialogFragment_take_img("");
//                bottomSheetDialogFragment_take_img.show(getSupportFragmentManager(), "");

                type = "visa_page_image";
                com.github.dhaval2404.imagepicker.ImagePicker.Builder builder = new com.github.dhaval2404.imagepicker.ImagePicker.Builder(NewOrderHelthActivity.this);
                builder.crop()                    //Crop image(Optional), Check Customization for more option
                        .compress(1024)            //Final image size will be less than 1 MB(Optional)
                        .start();
            }
        });
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                name.setError(null);
                phone.setError(null);
                email.setError(null);
                chronic_txt.setError(null);
                Gender_txt.setError(null);
                Are_you_pregnant_txt.setError(null);
                has_you_insurance_txt.setError(null);
                accept.setError(null);

                if (name.getText().toString().equals("") |
                        phone.getText().toString().equals("") |
                        email.getText().toString().equals("")|
                        chronic.getSelectedItemId()==0|
                        Gender.getSelectedItemId()==0|
                        (Are_you_pregnant.getSelectedItemId()==0 &&Gender.getSelectedItemId()==2 ) |
                        has_you_insurance.getSelectedItemId()==0|
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
                    if (chronic.getSelectedItemId()==0) {
                        chronic_txt.setError(getResources().getString(R.string.required));
                    }
                    if (Gender.getSelectedItemId()==0) {
                        Gender_txt.setError(getResources().getString(R.string.required));
                    }
                    if (Are_you_pregnant.getSelectedItemId()==0) {
                        Are_you_pregnant_txt.setError(getResources().getString(R.string.required));
                    }
                    if (has_you_insurance.getSelectedItemId()==0) {
                        has_you_insurance_txt.setError(getResources().getString(R.string.required));
                    }
                    if (!accept.isChecked()) {
                        accept.setError(getResources().getString(R.string.required));
                    }
                } else {
                    InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(view.getWindowToken(), 0);


                    lay_1.setVisibility(View.GONE);
                    lay_2.setVisibility(View.VISIBLE);


                }
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

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (ownershipFile == null |
                        Emirate_IDFile_front == null) {


                    if (ownershipFile == null) {
                        OwnerShip_txt.setError(getResources().getString(R.string.required));
                    }
                    if (Emirate_IDFile_front == null) {
                        Emirate_ID_txt.setError(getResources().getString(R.string.required));

                    }


                } else {

                    loading.setVisibility(View.VISIBLE);
                    submit.setVisibility(View.GONE);


                    RequestParams requestParams = new RequestParams();


                    try {


                        requestParams.put("insurance_type_id", id + "");
                        requestParams.put("name", name.getText().toString() + "");
                        requestParams.put("nationality", "Em");
                        requestParams.put("date_birth", "5/2/1994");
                        requestParams.put("email", email.getText().toString() + "");
                        requestParams.put("mobile", ncode_mobile + phone.getText().toString() + "");

                        requestParams.put("id_number", "353450020");
                        requestParams.put("file_number", "353450020");

//                        System.out.println("Gender.getSelectedItem()"+Gender.getSelectedItem());
                        if (Gender.getSelectedItemId()==1) {
                            requestParams.put("gender", "male");

                        } else if(Gender.getSelectedItemId()==2) {
                            requestParams.put("gender", "female");

                        }

                        requestParams.put("emirate_id", "0");
                        requestParams.put("married", "no");
                        if (has_you_insurance.getSelectedItemId()==1) {
                            requestParams.put("has_existing_active_healthinsurance", "yes");

                        } else if (has_you_insurance.getSelectedItemId()==2) {
                            requestParams.put("has_existing_active_healthinsurance", "no");

                        }
                        if (chronic.getSelectedItemId()==1) {
                            requestParams.put("has_chronic_conditions", "yes");
                        } else if (chronic.getSelectedItemId()==2) {
                            requestParams.put("has_chronic_conditions", "no");
                        }

                        requestParams.put("health_insurance_policy_expire", "2025/10/10");
                        if (Are_you_pregnant.getSelectedItemId()==1) {
                            requestParams.put("are_you_pregnant", "yes");

                        } else if (Are_you_pregnant.getSelectedItemId()==2) {
                            requestParams.put("are_you_pregnant", "no");

                        }
                        requestParams.put("passport_image", ownershipFile);
                        requestParams.put("emirate_id_front_image", Emirate_IDFile_front);
                        requestParams.put("emirate_id_back_image", Emirate_IDFile_back);


                        if(visa_page_imageFile!=null){
                            requestParams.put("visa_page_image", visa_page_imageFile);

                        }
                    } catch (Exception e) {

                    }

                    init_volley();
//                    WebService.loading(ContactUsActivity.this, true);
                    VolleyService mVolleyService = new VolleyService(mResultCallback, NewOrderHelthActivity.this);
                    mVolleyService.postDataasync_with_file("sendHealthRequest", WebService.sendHealthRequest, requestParams);//category/1/product

//activation_code
                }


            }
        });


        String spinnerArray[] = {getResources().getString(R.string.selectGender),getResources().getString(R.string.Male), getResources().getString(R.string.female)};


        ArrayAdapter<String> spinnerArrayAdapter = new ArrayAdapter<String>
                (this, android.R.layout.simple_spinner_item,
                        spinnerArray); //selected item will look like a spinner set from XML
        spinnerArrayAdapter.setDropDownViewResource(android.R.layout
                .simple_spinner_dropdown_item);
        Gender.setAdapter(spinnerArrayAdapter);
        Gender.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(Gender.getSelectedItemId()==0){

                }
               else if(Gender.getSelectedItemId()==1){
                    Are_you_pregnant_lay.setVisibility(View.GONE);
                }else{
                    Are_you_pregnant_lay.setVisibility(View.VISIBLE);

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        String spinnerArray2c[] = {getResources().getString(R.string.Selectx),getResources().getString(R.string.yes), getResources().getString(R.string.No)};


        ArrayAdapter<String> spinnerArrayAdapter1x = new ArrayAdapter<String>
                (this, android.R.layout.simple_spinner_item,
                        spinnerArray2c); //selected item will look like a spinner set from XML
        spinnerArrayAdapter1x.setDropDownViewResource(android.R.layout
                .simple_spinner_dropdown_item);
        Are_you_pregnant.setAdapter(spinnerArrayAdapter1x);

//        String spinnerArray1[] = {getResources().getString(R.string.yes), getResources().getString(R.string.No)};
        String spinnerArray1[] = {getResources().getString(R.string.Selectx),getResources().getString(R.string.yes), getResources().getString(R.string.No)};


        ArrayAdapter<String> spinnerArrayAdapter1 = new ArrayAdapter<String>
                (this, android.R.layout.simple_spinner_item,
                        spinnerArray1); //selected item will look like a spinner set from XML
        spinnerArrayAdapter1.setDropDownViewResource(android.R.layout
                .simple_spinner_dropdown_item);
        has_you_insurance.setAdapter(spinnerArrayAdapter1);
//        String spinnerArray2[] = {getResources().getString(R.string.yes), getResources().getString(R.string.No)};
        String spinnerArray2[] = {getResources().getString(R.string.Selectx),getResources().getString(R.string.yes), getResources().getString(R.string.No)};


        ArrayAdapter<String> spinnerArrayAdapter2 = new ArrayAdapter<String>
                (this, android.R.layout.simple_spinner_item,
                        spinnerArray2); //selected item will look like a spinner set from XML
        spinnerArrayAdapter2.setDropDownViewResource(android.R.layout
                .simple_spinner_dropdown_item);
        chronic.setAdapter(spinnerArrayAdapter2);


        terms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(NewOrderHelthActivity.this, TermsConditionActivity.class));
            }
        });
    }

    public static void save_img(File front_file, File back_file) {

        Emirate_IDFile_front = front_file;
        Emirate_IDFile_back = back_file;

        Emirate_ID.setImageDrawable(activity.getResources().getDrawable(R.drawable.ic_baseline_check_circle_111));


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {


        if (type.equals("ownership")) {
            Uri uri = data.getData();


            if (uri != null) {
//                SignUpFragment.get_image(uri);

                File file = new File(uri.getPath());
                ownershipFile = file;
                ownership.setImageDrawable(getResources().getDrawable(R.drawable.ic_baseline_check_circle_111));
//                    Emirate_ID.setImageDrawable(getResources().getDrawable(R.drawable.ic_baseline_check_circle_111));
//                    Driver_License.setImageDrawable(getResources().getDrawable(R.drawable.ic_baseline_check_circle_111));
//                    Bitmap myBitmap = BitmapFactory.decodeFile(file.getAbsolutePath());
//                    imagex.setImageBitmap(myBitmap);
            }


        }  else if (type.equals("visa_page_image")) {
            Uri uri = data.getData();


            if (uri != null) {
//                SignUpFragment.get_image(uri);

                File file = new File(uri.getPath());
                visa_page_imageFile = file;
                visa_page_image.setImageDrawable(getResources().getDrawable(R.drawable.ic_baseline_check_circle_111));
//                    Emirate_ID.setImageDrawable(getResources().getDrawable(R.drawable.ic_baseline_check_circle_111));
//                    Driver_License.setImageDrawable(getResources().getDrawable(R.drawable.ic_baseline_check_circle_111));
//                    Bitmap myBitmap = BitmapFactory.decodeFile(file.getAbsolutePath());
//                    imagex.setImageBitmap(myBitmap);
            }

        }


        super.onActivityResult(requestCode, resultCode, data);
    }

    public void init_volley() {

        mResultCallback = new IResult() {
            @Override
            public void notifySuccess(String requestType, JSONObject response) {
                Log.d("TAG", "Volley requester " + requestType);
                Log.d("TAG", "Volley JSON post" + response);
                //{"status":true,"code":200,"message":"User Profile","data"
                WebService.loading(NewOrderHelthActivity.this, false);
                loading.setVisibility(View.GONE);
                submit.setVisibility(View.VISIBLE);


                try {
                    boolean status = response.getBoolean("status");
                    String mesg = response.getString("message");
                    if (status) {


                        if (requestType.equals("sendHealthRequest")) {

//
                            WebService.Make_Toast_color(NewOrderHelthActivity.this, mesg, "success");


                            Intent intent = new Intent(NewOrderHelthActivity.this, VirficationOrderActivity.class);
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

                        WebService.Make_Toast_color(NewOrderHelthActivity.this, message, "error");

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
                WebService.loading(NewOrderHelthActivity.this, false);
                loading.setVisibility(View.GONE);
                submit.setVisibility(View.VISIBLE);

                try {
//                    btn_id.stopAnimation();
//                    btn_id.revertAnimation();

                    NetworkResponse response = error.networkResponse;
                    String response_data = new String(response.data);

                    JSONObject jsonObject = new JSONObject(response_data);

                    String message = jsonObject.getString("message");


                    WebService.Make_Toast_color(NewOrderHelthActivity.this, message, "error");

                    Log.e("error response", response_data);

                } catch (Exception e) {

                }


            }

            @Override
            public void notify_Async_Error(String requestType, String error) {
//                loading.setVisibility(View.GONE);
                WebService.loading(NewOrderHelthActivity.this, false);

            }
        };


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

}