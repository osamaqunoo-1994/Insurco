package com.osama.insurco.ui.Order;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.android.volley.NetworkResponse;
import com.android.volley.VolleyError;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.osama.insurco.Modules.Orders;
import com.osama.insurco.R;
import com.osama.insurco.Settings.WebService;
import com.osama.insurco.api.IResult;
import com.osama.insurco.api.VolleyService;
import com.osama.insurco.ui.Order.Adapter.RecyclerView_company;
import com.osama.insurco.ui.Order.Adapter.RecyclerView_order;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class CampanySelectionActivity extends AppCompatActivity {
    ImageView back;
    IResult mResultCallback;
    RecyclerView all_company;

    List<Orders.Item> orders = new ArrayList<>();
    LinearLayout nodata_found;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_campany_selection);
        getSupportActionBar().hide();

        back = findViewById(R.id.back);
        all_company = findViewById(R.id.all_company);
        nodata_found = findViewById(R.id.nodata_found);

// finally change the color
        getWindow().setStatusBarColor(ContextCompat.getColor(CampanySelectionActivity.this, R.color.purple_200));
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        LinearLayoutManager layoutManager1
                = new LinearLayoutManager(CampanySelectionActivity.this, LinearLayoutManager.VERTICAL, false);
        all_company.setLayoutManager(layoutManager1);


        try {


            if(OrderActivity.ordier.getCompany()!=null){
                all_company.setAdapter(new RecyclerView_company(CampanySelectionActivity.this, OrderActivity.ordier.getCompany()));
                System.out.println("!!!!84784764875847587");

                if (OrderActivity.ordier.getCompany().size() == 0) {
                    nodata_found.setVisibility(View.VISIBLE);
                    System.out.println("84784764875847587");
                } else {
                    nodata_found.setVisibility(View.GONE);
                    System.out.println("@@@@84784764875847587");

                }
            }else{
                nodata_found.setVisibility(View.VISIBLE);

            }


//            init_volley();
//            WebService.loading(OrderActivity.this, true);
//            VolleyService mVolleyService = new VolleyService(mResultCallback, OrderActivity.this);
//
//            JSONObject jsonObject = new JSONObject();
//            jsonObject.put("form_type", "327");
//            jsonObject.put("id", "motor");
//
//            mVolleyService.postDataVolley("reSendActivationCode", WebService.reSendActivationCode, jsonObject);//category/1/product
//

        } catch (Exception e) {
e.printStackTrace();
        }


    }

    public void init_volley() {

        mResultCallback = new IResult() {
            @Override
            public void notifySuccess(String requestType, JSONObject response) {
                Log.d("TAG", "Volley requester " + requestType);
                Log.d("TAG", "Volley JSON post" + response);
                //{"status":true,"code":200,"message":"User Profile","data"
                WebService.loading(CampanySelectionActivity.this, false);

                try {
                    boolean status = response.getBoolean("status");
                    if (status) {


                        if (requestType.equals("reSendActivationCode")) {

//

//                            Hawk.put("Ads", response.toString() + "");
//
//                            JsonParser parser = new JsonParser();
//                            JsonElement mJson = parser.parse(response.toString());
//
//                            Gson gson = new Gson();
//                            Orders orders_objext = gson.fromJson(mJson, Orders.class);
////
////
//                            orders.clear();
//                            orders.add(orders_objext.getItem());
//
//                            all_order.setAdapter(new RecyclerView_order(OrderActivity.this, orders));
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

//                        String user = response.getString("user");
//
//
//                        Hawk.put("user", user);
//                        String message = response.getString("message");
//                        WebService.Make_Toast_color(LoginActivity.this, message, "success");
//                        finish();
//
                    } else {
//                        btn_id.revertAnimation();
//                        {"status":false,"code":201,"message":"Please Enter True Mobile Number and Password"}
                        String message = response.getString("message");

                        WebService.Make_Toast_color(CampanySelectionActivity.this, message, "error");

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
                WebService.loading(CampanySelectionActivity.this, false);

                try {
//                    btn_id.stopAnimation();
//                    btn_id.revertAnimation();

                    NetworkResponse response = error.networkResponse;
                    String response_data = new String(response.data);

                    JSONObject jsonObject = new JSONObject(response_data);

                    String message = jsonObject.getString("message");


                    WebService.Make_Toast_color(CampanySelectionActivity.this, message, "error");

                    Log.e("error response", response_data);

                } catch (Exception e) {

                }


            }

            @Override
            public void notify_Async_Error(String requestType, String error) {
//                loading.setVisibility(View.GONE);
                WebService.loading(CampanySelectionActivity.this, false);

            }
        };


    }

}