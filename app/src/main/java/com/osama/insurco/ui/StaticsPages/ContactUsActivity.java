package com.osama.insurco.ui.StaticsPages;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.Spinner;

import com.android.volley.NetworkResponse;
import com.android.volley.VolleyError;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.loopj.android.http.RequestParams;
import com.osama.insurco.Modules.MotoTypeInsuranceModules;
import com.osama.insurco.R;
import com.osama.insurco.Settings.WebService;
import com.osama.insurco.api.IResult;
import com.osama.insurco.api.VolleyService;
import com.osama.insurco.ui.Main.DetailsInsuranceActivity;
import com.osama.insurco.ui.Main.adapter.RecyclerView_car_ins;

import org.json.JSONObject;

import java.io.File;

public class ContactUsActivity extends AppCompatActivity {
    EditText name;
    EditText subject;
    EditText email;
    EditText phone;
    EditText message;
    LinearLayout file;
    LinearLayout subment;
    ImageView file_img;

    ProgressBar progress;

    File file_file = null;


    Spinner spinner;
    IResult mResultCallback;

    ImageView close;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_us);
        getSupportActionBar().hide();
        getWindow().setStatusBarColor(ContextCompat.getColor(ContactUsActivity.this, R.color.purple_200));

        name = findViewById(R.id.name);
        subject = findViewById(R.id.subject);
        email = findViewById(R.id.email);
        phone = findViewById(R.id.phone);
        message = findViewById(R.id.message);
        file = findViewById(R.id.file);
        subment = findViewById(R.id.subment);
        file_img = findViewById(R.id.file_img);
        progress = findViewById(R.id.progress);
        spinner = findViewById(R.id.spinner);
        close = findViewById(R.id.close);
// finally change the color


        String spinnerArray[] = {"complaint", "suggestion"};


        ArrayAdapter<String> spinnerArrayAdapter = new ArrayAdapter<String>
                (this, android.R.layout.simple_spinner_item,
                        spinnerArray); //selected item will look like a spinner set from XML
        spinnerArrayAdapter.setDropDownViewResource(android.R.layout
                .simple_spinner_dropdown_item);
        spinner.setAdapter(spinnerArrayAdapter);


        file_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                com.github.dhaval2404.imagepicker.ImagePicker.Builder builder = new com.github.dhaval2404.imagepicker.ImagePicker.Builder(ContactUsActivity.this);
                builder.crop()                    //Crop image(Optional), Check Customization for more option
                        .compress(1024)            //Final image size will be less than 1 MB(Optional)
                        .start();
            }
        });

        file.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                com.github.dhaval2404.imagepicker.ImagePicker.Builder builder = new com.github.dhaval2404.imagepicker.ImagePicker.Builder(ContactUsActivity.this);
                builder.crop()                    //Crop image(Optional), Check Customization for more option
                        .compress(1024)            //Final image size will be less than 1 MB(Optional)
                        .start();
            }
        });

        subment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (name.getText().toString().equals("") |
                        subject.getText().toString().equals("") |
                        email.getText().toString().equals("") |
                        phone.getText().toString().equals("") |
                        message.getText().toString().equals("")
                ) {

                    if (name.getText().toString().equals("")) {
                        name.setError(getResources().getString(R.string.required));
                    }
                    if (subject.getText().toString().equals("")) {
                        subject.setError(getResources().getString(R.string.required));
                    }
                    if (email.getText().toString().equals("")) {
                        email.setError(getResources().getString(R.string.required));
                    }
                    if (phone.getText().toString().equals("")) {
                        phone.setError(getResources().getString(R.string.required));
                    }
                    if (message.getText().toString().equals("")) {
                        message.setError(getResources().getString(R.string.required));
                    }


                } else {

                    progress.setVisibility(View.VISIBLE);
                    subment.setVisibility(View.GONE);


                    RequestParams requestParams = new RequestParams();


                    try {

                        requestParams.put("type", spinner.getSelectedItem().toString() + "");
                        requestParams.put("name", name.getText().toString() + "");
                        requestParams.put("email", email.getText().toString() + "");
                        requestParams.put("phone", phone.getText().toString() + "");
                        requestParams.put("title", subject.getText().toString() + "");
                        requestParams.put("message", message.getText().toString() + "");

                        if (file_file != null) {
                            requestParams.put("image", file_file);

                        }

                    } catch (Exception e) {

                    }

                    init_volley();
//                    WebService.loading(ContactUsActivity.this, true);
                    VolleyService mVolleyService = new VolleyService(mResultCallback, ContactUsActivity.this);
                    mVolleyService.postDataasync_with_file("sendContactMsg", WebService.sendContactMsg, requestParams);//category/1/product


                }


            }
        });


        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {

        if (resultCode == Activity.RESULT_OK) {


            Uri uri = data.getData();


            if (uri != null) {
//                SignUpFragment.get_image(uri);

                File file = new File(uri.getPath());

                file_file = file;

                file_img.setImageDrawable(getResources().getDrawable(R.drawable.ic_baseline_check_circle_111));
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
                WebService.loading(ContactUsActivity.this, false);
                progress.setVisibility(View.GONE);
                subment.setVisibility(View.VISIBLE);
                name.setText("");
                email.setText("");
                subject.setText("");
                message.setText("");
                phone.setText("");


                try {
                    boolean status = response.getBoolean("status");
                    String mesg = response.getString("message");
                    if (status) {


                        if (requestType.equals("sendContactMsg")) {

//
                            WebService.Make_Toast_color(ContactUsActivity.this, mesg, "success");


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

                        WebService.Make_Toast_color(ContactUsActivity.this, message, "error");

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
                WebService.loading(ContactUsActivity.this, false);

                try {
//                    btn_id.stopAnimation();
//                    btn_id.revertAnimation();

                    NetworkResponse response = error.networkResponse;
                    String response_data = new String(response.data);

                    JSONObject jsonObject = new JSONObject(response_data);

                    String message = jsonObject.getString("message");


                    WebService.Make_Toast_color(ContactUsActivity.this, message, "error");

                    Log.e("error response", response_data);

                } catch (Exception e) {

                }


            }

            @Override
            public void notify_Async_Error(String requestType, String error) {
//                loading.setVisibility(View.GONE);
                WebService.loading(ContactUsActivity.this, false);

            }
        };


    }

}