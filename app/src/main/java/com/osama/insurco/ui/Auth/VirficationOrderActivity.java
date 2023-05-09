package com.osama.insurco.ui.Auth;

import static com.osama.insurco.Settings.WebService.ncode_mobile;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.android.volley.NetworkResponse;
import com.android.volley.VolleyError;
import com.loopj.android.http.RequestParams;
import com.orhanobut.hawk.Hawk;
import com.osama.insurco.R;
import com.osama.insurco.Settings.WebService;
import com.osama.insurco.api.IResult;
import com.osama.insurco.api.VolleyService;

import org.json.JSONObject;

public class VirficationOrderActivity extends AppCompatActivity {
    ImageView close;
    EditText a1, a2, a3, a4, a5, a6;
    IResult mResultCallback;

    String mobile = "";
    LinearLayout nextlay;
    TextView recend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_virfication_order);
        getSupportActionBar().hide();
        close = findViewById(R.id.close);
        a1 = findViewById(R.id.a1);
        a2 = findViewById(R.id.a2);
        a3 = findViewById(R.id.a3);
        a4 = findViewById(R.id.a4);
        a5 = findViewById(R.id.a5);
        a6 = findViewById(R.id.a6);
        nextlay = findViewById(R.id.nextlay);
        recend = findViewById(R.id.recend);
        try {
            mobile = getIntent().getStringExtra("mobile");
        } catch (Exception e) {

        }


// finally change the color
        getWindow().setStatusBarColor(ContextCompat.getColor(VirficationOrderActivity.this, R.color.purple_200));

        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        inti();
    }

    public void inti() {
        a1.requestFocus();

        a1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {


                if (a1.getText().toString().equals("")) {
                    a1.setBackground(getResources().getDrawable(R.drawable.back_edit));
                } else {
                    a2.requestFocus();
                    a1.setBackground(getResources().getDrawable(R.drawable.back_editselected));

                }

            }
        });
        a2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (a2.getText().toString().equals("")) {
                    a1.requestFocus();

                    a3.setBackground(getResources().getDrawable(R.drawable.back_edit));
                } else {
                    a3.requestFocus();

                    a2.setBackground(getResources().getDrawable(R.drawable.back_editselected));

                }
            }
        });
        a3.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (a3.getText().toString().equals("")) {
                    a2.requestFocus();

                    a3.setBackground(getResources().getDrawable(R.drawable.back_edit));
                } else {
                    a4.requestFocus();

                    a3.setBackground(getResources().getDrawable(R.drawable.back_editselected));

                }
            }
        });
        a4.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (a4.getText().toString().equals("")) {
                    a3.requestFocus();

                    a4.setBackground(getResources().getDrawable(R.drawable.back_edit));
                } else {
                    a5.requestFocus();

                    a4.setBackground(getResources().getDrawable(R.drawable.back_editselected));
                    hideKeyboard(VirficationOrderActivity.this);
                    RequestParams requestParams = new RequestParams();


                    try {

                        requestParams.put("mobile", ncode_mobile + mobile + "");
                        requestParams.put("code", a1.getText().toString() + a2.getText().toString() + a3.getText().toString() + a4.getText().toString() + a5.getText().toString() + a6.getText().toString() + "");


                    } catch (Exception e) {

                    }

                    init_volley();
                    WebService.loading(VirficationOrderActivity.this, true);
                    VolleyService mVolleyService = new VolleyService(mResultCallback, VirficationOrderActivity.this);
                    mVolleyService.postDataasync_with_file("actMotorHealthReq", WebService.actMotorHealthReq, requestParams);//category/1/product

                }
            }
        });


        nextlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                RequestParams requestParams = new RequestParams();

                try {

                    requestParams.put("mobile", ncode_mobile + mobile + "");
                    requestParams.put("code", a1.getText().toString() + a2.getText().toString() + a3.getText().toString() + a4.getText().toString() + a5.getText().toString() + a6.getText().toString() + "");

                } catch (Exception e) {

                }

                init_volley();
                WebService.loading(VirficationOrderActivity.this, true);
                VolleyService mVolleyService = new VolleyService(mResultCallback, VirficationOrderActivity.this);
                mVolleyService.postDataasync_with_file("actMotorHealthReq", WebService.actMotorHealthReq, requestParams);//category/1/product

            }
        });
        recend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                RequestParams requestParams = new RequestParams();

                try {

                    requestParams.put("mobile", ncode_mobile + mobile + "");
//                    requestParams.put("code", a1.getText().toString() + a2.getText().toString() + a3.getText().toString() + a4.getText().toString() + a5.getText().toString() + a6.getText().toString() + "");

                } catch (Exception e) {

                }

                init_volley();
                WebService.loading(VirficationOrderActivity.this, true);
                VolleyService mVolleyService = new VolleyService(mResultCallback, VirficationOrderActivity.this);
                mVolleyService.postDataasync_with_file("reSendActivationCode", WebService.reSendActivationCode, requestParams);//category/1/product

            }
        });
    }

    public static void hideKeyboard(Activity activity) {
        InputMethodManager imm = (InputMethodManager) activity.getSystemService(Activity.INPUT_METHOD_SERVICE);
        //Find the currently focused view, so we can grab the correct window token from it.
        View view = activity.getCurrentFocus();
        //If no view currently has focus, create a new one, just so we can grab a window token from it
        if (view == null) {
            view = new View(activity);
        }
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }

    public void init_volley() {

        mResultCallback = new IResult() {
            @Override
            public void notifySuccess(String requestType, JSONObject response) {
                Log.d("TAG", "Volley requester " + requestType);
                Log.d("TAG", "Volley JSON post" + response);
                //{"status":true,"code":200,"message":"User Profile","data"
                WebService.loading(VirficationOrderActivity.this, false);
//                progress.setVisibility(View.GONE);
//                loading.setVisibility(View.GONE);
//                login.setVisibility(View.VISIBLE);


                try {
                    boolean status = response.getBoolean("status");
                    String mesg = response.getString("message");
                    if (status) {


                        if (requestType.equals("actMotorHealthReq")) {

//
                            WebService.Make_Toast_color(VirficationOrderActivity.this, mesg, "success");


//                            Hawk.put("user", response.toString() + "");
//
//                            JsonParser parser = new JsonParser();
//                            JsonElement mJson = parser.parse(response.toString());
//
//                            Gson gson = new Gson();
//                            MotoTypeInsuranceModules motoTypeInsuranceModules = gson.fromJson(mJson, MotoTypeInsuranceModules.class);
////
//                            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
//                            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
//                            startActivity(intent);
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
                        } else {

                            String message = response.getString("message");

                            WebService.Make_Toast_color(VirficationOrderActivity.this, message, "success");

                        }

                    } else {
//                        btn_id.revertAnimation();
//                        {"status":false,"code":201,"message":"Please Enter True Mobile Number and Password"}
                        String message = response.getString("message");

                        WebService.Make_Toast_color(VirficationOrderActivity.this, message, "error");

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
                WebService.loading(VirficationOrderActivity.this, false);
//                loading.setVisibility(View.GONE);
//                login.setVisibility(View.VISIBLE);

                try {
//                    btn_id.stopAnimation();
//                    btn_id.revertAnimation();

                    NetworkResponse response = error.networkResponse;
                    String response_data = new String(response.data);

                    JSONObject jsonObject = new JSONObject(response_data);

                    String message = jsonObject.getString("message");


                    WebService.Make_Toast_color(VirficationOrderActivity.this, message, "error");

                    Log.e("error response", response_data);

                } catch (Exception e) {

                }


            }

            @Override
            public void notify_Async_Error(String requestType, String error) {
//                loading.setVisibility(View.GONE);
                WebService.loading(VirficationOrderActivity.this, false);

            }
        };


    }


}