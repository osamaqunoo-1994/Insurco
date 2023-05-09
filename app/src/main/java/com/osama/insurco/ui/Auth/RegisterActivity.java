package com.osama.insurco.ui.Auth;

import static com.osama.insurco.Settings.WebService.ncode_mobile;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.android.volley.NetworkResponse;
import com.android.volley.VolleyError;
import com.loopj.android.http.RequestParams;
import com.orhanobut.hawk.Hawk;
import com.osama.insurco.R;
import com.osama.insurco.Settings.WebService;
import com.osama.insurco.api.IResult;
import com.osama.insurco.api.VolleyService;
import com.osama.insurco.ui.Main.MainActivity;
import com.osama.insurco.ui.StaticsPages.TermsConditionActivity;

import org.json.JSONObject;

public class RegisterActivity extends AppCompatActivity {
    LinearLayout regester;
    TextView terms;

    ImageView close;
    EditText name;
    EditText phone;
    EditText email;
    EditText password;
    CheckBox check;
    ProgressBar loading;
    IResult mResultCallback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        regester = findViewById(R.id.regester);
        terms = findViewById(R.id.terms);
        name = findViewById(R.id.name);
        phone = findViewById(R.id.phone);
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        check = findViewById(R.id.check);
        loading = findViewById(R.id.loading);
        close = findViewById(R.id.close);
        getSupportActionBar().hide();


// finally change the color
        getWindow().setStatusBarColor(ContextCompat.getColor(RegisterActivity.this, R.color.purple_200));
        regester.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (name.getText().toString().equals("") |
                        phone.getText().toString().equals("") |
                        email.getText().toString().equals("") |
                        password.getText().toString().equals("")) {

                    if (name.getText().toString().equals("")) {
                        name.setError(getResources().getString(R.string.required));
                    }
                    if (email.getText().toString().equals("")) {
                        email.setError(getResources().getString(R.string.required));
                    }
                    if (phone.getText().toString().equals("")) {
                        phone.setError(getResources().getString(R.string.required));
                    }
                    if (password.getText().toString().equals("")) {
                        password.setError(getResources().getString(R.string.required));
                    }

                } else {

                    loading.setVisibility(View.VISIBLE);
                    regester.setVisibility(View.GONE);
                    RequestParams requestParams = new RequestParams();


                    try {

                        requestParams.put("name", name.getText().toString() + "");
                        requestParams.put("username", name.getText().toString() + "");
                        requestParams.put("mobile",ncode_mobile +phone.getText().toString() + "");
                        requestParams.put("email", email.getText().toString() + "");
                        requestParams.put("password", password.getText().toString() + "");
                        requestParams.put("confirm_password", password.getText().toString() + "");
                        requestParams.put("fcm_token", 1 + "");
                        requestParams.put("device_type", "android");


                    } catch (Exception e) {

                    }

                    init_volley();
//                    WebService.loading(ContactUsActivity.this, true);
                    VolleyService mVolleyService = new VolleyService(mResultCallback, RegisterActivity.this);
                    mVolleyService.postDataasync_with_file("signUpUsers", WebService.signUpUsers, requestParams);//category/1/product


                }


            }
        });
        terms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RegisterActivity.this, TermsConditionActivity.class));

            }
        });
        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
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
                WebService.loading(RegisterActivity.this, false);
//                progress.setVisibility(View.GONE);
                loading.setVisibility(View.GONE);
                regester.setVisibility(View.VISIBLE);


                try {
                    boolean status = response.getBoolean("status");
                    String mesg = response.getString("message");
                    if (status) {


                        if (requestType.equals("signUpUsers")) {

//
//                            WebService.Make_Toast_color(ContactUsActivity.this, mesg, "success");


                            Hawk.put("user", response.toString() + "");
//
//                            JsonParser parser = new JsonParser();
//                            JsonElement mJson = parser.parse(response.toString());
//
//                            Gson gson = new Gson();
//                            MotoTypeInsuranceModules motoTypeInsuranceModules = gson.fromJson(mJson, MotoTypeInsuranceModules.class);
////
                            Intent intent = new Intent(RegisterActivity.this, MainActivity.class);
//                            intent.putExtra("", "");
                            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                            startActivity(intent);
                            finish();

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

                        WebService.Make_Toast_color(RegisterActivity.this, message, "error");

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
                WebService.loading(RegisterActivity.this, false);
                loading.setVisibility(View.GONE);
                regester.setVisibility(View.VISIBLE);

                try {
//                    btn_id.stopAnimation();
//                    btn_id.revertAnimation();

                    NetworkResponse response = error.networkResponse;
                    String response_data = new String(response.data);

                    JSONObject jsonObject = new JSONObject(response_data);

                    String message = jsonObject.getString("message");


                    WebService.Make_Toast_color(RegisterActivity.this, message, "error");

                    Log.e("error response", response_data);

                } catch (Exception e) {

                }


            }

            @Override
            public void notify_Async_Error(String requestType, String error) {
//                loading.setVisibility(View.GONE);
                WebService.loading(RegisterActivity.this, false);

            }
        };


    }

}