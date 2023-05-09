package com.osama.insurco.ui.Order;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.android.volley.NetworkResponse;
import com.android.volley.VolleyError;
import com.loopj.android.http.RequestParams;
import com.orhanobut.hawk.Hawk;
import com.osama.insurco.R;
import com.osama.insurco.Settings.WebService;
import com.osama.insurco.api.IResult;
import com.osama.insurco.api.VolleyService;
import com.osama.insurco.ui.Auth.LoginActivity;
import com.osama.insurco.ui.Order.Adapter.RecyclerView_services_provided;

import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DetailsCompanyActivity extends AppCompatActivity {
    TextView company_name;
    TextView date;
    TextView price;
    TextView price_;
    TextView repair_price;
    TextView endurance_value;
    RecyclerView list_qustion;
    ImageView back;
    IResult mResultCallback;
    LinearLayout in_;
    LinearLayout nodata_found;
    LinearLayout pdf;
    LinearLayout car_pr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_company);

        getSupportActionBar().hide();
        nodata_found = findViewById(R.id.nodata_found);

        company_name = findViewById(R.id.company_name);
        date = findViewById(R.id.date);
        list_qustion = findViewById(R.id.list_qustion);
        car_pr = findViewById(R.id.car_pr);
        back = findViewById(R.id.back);
        price = findViewById(R.id.price);
        price_ = findViewById(R.id.price_);
        in_ = findViewById(R.id.in_);
        pdf = findViewById(R.id.pdf);
        repair_price = findViewById(R.id.repair_price);
        endurance_value = findViewById(R.id.endurance_value);


        LinearLayoutManager layoutManager1
                = new LinearLayoutManager(DetailsCompanyActivity.this, LinearLayoutManager.VERTICAL, false);
        list_qustion.setLayoutManager(layoutManager1);


        try {

            company_name.setText(OrderActivity.ordier_company.getCompanyInsurance().getName());

            pdf.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String url = OrderActivity.ordier_company.getInsurance_file() + "";
                    Intent i = new Intent(Intent.ACTION_VIEW);
                    i.setData(Uri.parse(url));
                    startActivity(i);
                }
            });
            try {
                //2022-11-24T07:36:11.000000Z

                Date userDob = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'").parse(OrderActivity.ordier_company.getCreatedAt().toString());
//            userDob.setTimeZone(TimeZone.getTimeZone("UTC"));
                Date today = new Date();
                long diff = today.getTime() - userDob.getTime();
                int numOfDays = (int) (diff / (1000 * 60 * 60 * 24));
                int hours = (int) (diff / (1000 * 60 * 60));
                int minutes = (int) (diff / (1000 * 60));
                int seconds = (int) (diff / (1000));

                System.out.println("numOfDays" + numOfDays);
                System.out.println("hours" + hours);
                System.out.println("minutes" + minutes);
                if (hours > 8) {
                    date.setText(getResources().getString(R.string.finish));

                } else if (hours == 8) {
                    date.setText(getResources().getString(R.string.finish));

                } else {
                    date.setText(getResources().getString(R.string.Expires_in) + " " + hours + " " + getResources().getString(R.string.hours));

                }

            } catch (Exception e) {

            }

            if (OrderActivity.ordier_company.getVehiclePrice() != null) {
                if (!OrderActivity.ordier_company.getVehiclePrice().toString().equals("null")) {
                    car_pr.setVisibility(View.VISIBLE);

                    price.setText(OrderActivity.ordier_company.getVehiclePrice() + "");

                } else {
                    car_pr.setVisibility(View.GONE);
                }

            } else {
                car_pr.setVisibility(View.GONE);

            }
            if (OrderActivity.ordier_company.getRepairPlace() != null) {
                if (!OrderActivity.ordier_company.getRepairPlace().toString().equals("null")) {
                    car_pr.setVisibility(View.VISIBLE);

                    repair_price.setText(OrderActivity.ordier_company.getRepairPlace() + "");

                } else {
                    repair_price.setVisibility(View.GONE);
                }

            } else {
                repair_price.setVisibility(View.GONE);

            }
            if (OrderActivity.ordier_company.getEnduranceValue() != null) {
                if (!OrderActivity.ordier_company.getEnduranceValue().toString().equals("null")) {
                    car_pr.setVisibility(View.VISIBLE);

                    endurance_value.setText(OrderActivity.ordier_company.getEnduranceValue() + "");

                } else {
                    endurance_value.setVisibility(View.GONE);
                }

            } else {
                endurance_value.setVisibility(View.GONE);

            }
            price_.setText(OrderActivity.ordier_company.getInsurancePolicyPrice() + "");

            if (OrderActivity.ordier_company.getCompanyInsurance().getInsurance_service() != null) {
                list_qustion.setAdapter(new RecyclerView_services_provided(DetailsCompanyActivity.this, OrderActivity.ordier_company.getCompanyInsurance().getInsurance_service()));

            }
            if (OrderActivity.ordier_company.getCompanyInsurance().getInsurance_service().size() == 0) {
                nodata_found.setVisibility(View.VISIBLE);
            } else {
                nodata_found.setVisibility(View.GONE);

            }


        } catch (Exception e) {

        }

        in_.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RequestParams requestParams = new RequestParams();


                try {

                    requestParams.put("mobile", OrderActivity.ordier.getMobile() + "");
                    requestParams.put("company_insurance_id", OrderActivity.ordier_company.getCompanyInsuranceId() + "");

                } catch (Exception e) {

                }

                init_volley();
                WebService.loading(DetailsCompanyActivity.this, true);
                VolleyService mVolleyService = new VolleyService(mResultCallback, DetailsCompanyActivity.this);
                mVolleyService.postDataasync_with_file("payNow", WebService.payNow, requestParams);//category/1/product

            }
        });
        back.setOnClickListener(new View.OnClickListener() {
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
                WebService.loading(DetailsCompanyActivity.this, false);
//                progress.setVisibility(View.GONE);


                try {
                    boolean status = response.getBoolean("status");
                    String mesg = response.getString("message");
                    if (status) {


                        if (requestType.equals("payNow")) {
                            String paymentUrl = response.getString("paymentUrl");
                            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(paymentUrl));
                            startActivity(browserIntent);
//
//                            WebService.Make_Toast_color(ContactUsActivity.this, mesg, "success");


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
//                            finish();

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

                        WebService.Make_Toast_color(DetailsCompanyActivity.this, message, "error");

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
                WebService.loading(DetailsCompanyActivity.this, false);


                try {
//                    btn_id.stopAnimation();
//                    btn_id.revertAnimation();

                    NetworkResponse response = error.networkResponse;
                    String response_data = new String(response.data);

                    JSONObject jsonObject = new JSONObject(response_data);

                    String message = jsonObject.getString("message");


                    WebService.Make_Toast_color(DetailsCompanyActivity.this, message, "error");

                    Log.e("error response", response_data);

                } catch (Exception e) {

                }


            }

            @Override
            public void notify_Async_Error(String requestType, String error) {
//                loading.setVisibility(View.GONE);
                WebService.loading(DetailsCompanyActivity.this, false);

            }
        };


    }

}