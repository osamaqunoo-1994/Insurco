package com.osama.insurco.ui.Main.Fragments;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

import com.android.volley.NetworkResponse;
import com.android.volley.VolleyError;
import com.github.vivchar.viewpagerindicator.ViewPagerIndicator;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.orhanobut.hawk.Hawk;
import com.osama.insurco.Modules.Orders;
import com.osama.insurco.R;
import com.osama.insurco.Settings.Settings;
import com.osama.insurco.Settings.WebService;
import com.osama.insurco.api.IResult;
import com.osama.insurco.api.VolleyService;
import com.osama.insurco.ui.Main.DetailsInsuranceActivity;
import com.osama.insurco.ui.Main.adapter.viewPager_Home_Adapter_slider;
import com.osama.insurco.ui.Order.Adapter.RecyclerView_order;
import com.osama.insurco.ui.Order.Adapter.RecyclerView_ordermator;
import com.osama.insurco.ui.Order.OrderActivity;
import com.osama.insurco.ui.camera.TakeImageCameraActivity2;
import com.osama.insurco.ui.splash.Adapter.viewPager_Adapter_slider;
import com.osama.insurco.ui.splash.WelcomeActivity;

import org.json.JSONObject;

import java.util.Timer;
import java.util.TimerTask;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public HomeFragment() {
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
    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
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

    ViewPager view_pager;
    IResult mResultCallback;

    LinearLayout Life_Insurance;
    LinearLayout Travel_Insurance;
    LinearLayout Motor_Insurance;
    LinearLayout Health_Insurance;

    VideoView video;
    ViewPagerIndicator view_pager_indicator;
    TextView comparison1;
    LinearLayout comparison1_lay;
int pos=0;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        view_pager = view.findViewById(R.id.view_pager);
        Life_Insurance = view.findViewById(R.id.Life_Insurance);
        Travel_Insurance = view.findViewById(R.id.Travel_Insurance);
        Motor_Insurance = view.findViewById(R.id.Motor_Insurance);
        Health_Insurance = view.findViewById(R.id.Health_Insurance);
        view_pager_indicator = view.findViewById(R.id.view_pager_indicator);
        comparison1 = view.findViewById(R.id.comparison1);
        comparison1_lay = view.findViewById(R.id.comparison1_lay);


        if (Settings.getAds().getAds() != null) {
            view_pager.setAdapter(new viewPager_Home_Adapter_slider(getContext(), Settings.getAds().getAds()));
            view_pager_indicator.setupWithViewPager(view_pager);
            Handler handler = new Handler();

            Runnable update = new Runnable()  {

                public void run() {
                    if ( pos == Settings.getAds().getAds().size()) {

                        pos = 0;
                    }
                    view_pager.setCurrentItem(pos++, true);
                }
            };


            new Timer().schedule(new TimerTask() {

                @Override
                public void run() {
                    handler.post(update);
                }
            }, 2000, 2500);



        }


//        video = view.findViewById(R.id.video);


        Life_Insurance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

//                Toast.makeText(getContext(), getResources().getString(R.string.CommingSoon), Toast.LENGTH_LONG).show();

                String url = "https://web.insurco.ae/";
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);

            }
        });
        Travel_Insurance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = "https://web.insurco.ae/";
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
//                Toast.makeText(getContext(), getResources().getString(R.string.CommingSoon), Toast.LENGTH_LONG).show();
            }
        });
        Motor_Insurance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getContext(), DetailsInsuranceActivity.class);
//                Intent intent = new Intent(getContext(), TakeImageCameraActivity2.class);

                intent.putExtra("from", "Motor");
                startActivity(intent);

            }
        });
        comparison1_lay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent1 = new Intent(getActivity(), OrderActivity.class);
                intent1.putExtra("from", "settings");
                startActivity(intent1);

            }
        });
        Health_Insurance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getContext(), DetailsInsuranceActivity.class);

                intent.putExtra("from", "Health");
                startActivity(intent);
            }
        });

        if (Hawk.contains("Email")) {


            String email = Hawk.get("Email").toString();


            init_volley();
//            WebService.loading(OrderActivity.this, true);
            VolleyService mVolleyService = new VolleyService(mResultCallback, getContext());
            try {
                JSONObject jsonObject = new JSONObject();
                jsonObject.put("email", email);
//                jsonObject.put("form_type", "motor");

                mVolleyService.postDataVolley("returnInsuranceCompanies", WebService.returnInsuranceCompanies, jsonObject);//category/1/product

            } catch (Exception e) {

            }

        }
        return view;

    }

    @Override
    public void onResume() {
//        String path = "android.resource://" + getActivity().getPackageName() + "/" + R.raw.flowers;
//        video.setVideoURI(Uri.parse(path));
//        video.start();
//        video.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
//            @Override
//            public void onPrepared(MediaPlayer mp) {
//                mp.setLooping(true);
//            }
//        });
        super.onResume();
    }

    public void init_volley() {

        mResultCallback = new IResult() {
            @Override
            public void notifySuccess(String requestType, JSONObject response) {
                Log.d("TAG", "Volley requester " + requestType);
                Log.d("TAG", "Volley JSON post" + response);
                //{"status":true,"code":200,"message":"User Profile","data"
                WebService.loading(getActivity(), false);

                try {
                    boolean status = response.getBoolean("status");
                    if (status) {


                        if (requestType.equals("returnInsuranceCompanies")) {

//

//                            Hawk.put("Ads", response.toString() + "");
//
                            JsonParser parser = new JsonParser();
                            JsonElement mJson = parser.parse(response.toString());

                            Gson gson = new Gson();
                            Orders orders_objext = gson.fromJson(mJson, Orders.class);
//
                            if (orders_objext.getHealth().size() == 0 & orders_objext.getMotor().size() == 0) {
//                                comparison1_lay.setVisibility(View.GONE);
                            } else {
//                                comparison1_lay.setVisibility(View.VISIBLE);
                                int oo = orders_objext.getHealth().size() + orders_objext.getMotor().size();
                                comparison1.setText(oo + "");
                            }
//

                            try {
//                                String gfg = getIntent().getStringExtra("from");
//                                if (gfg.toString().equals("url")) {
//                                    if (orders_objext.getItem().size() != 0) {
//
//
//                                        OrderActivity.ordier = orders_objext.getItem().get(0);
//
//                                        Intent intent = new Intent(OrderActivity.this, CompanySelectionActivity.class);
//                                        startActivity(intent);
//
//
//                                    }
//
//                                }

                            } catch (Exception e) {

                            }

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

                        WebService.Make_Toast_color(getActivity(), message, "error");

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
                WebService.loading(getActivity(), false);

                try {
//                    btn_id.stopAnimation();
//                    btn_id.revertAnimation();

                    NetworkResponse response = error.networkResponse;
                    String response_data = new String(response.data);

                    JSONObject jsonObject = new JSONObject(response_data);

                    String message = jsonObject.getString("message");


                    WebService.Make_Toast_color(getActivity(), message, "error");

                    Log.e("error response", response_data);

                } catch (Exception e) {

                }


            }

            @Override
            public void notify_Async_Error(String requestType, String error) {
//                loading.setVisibility(View.GONE);
                WebService.loading(getActivity(), false);

            }
        };


    }

}