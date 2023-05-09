package com.osama.insurco.ui.Auth;

import static com.osama.insurco.Settings.WebService.ncode_mobile;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.android.volley.NetworkResponse;
import com.android.volley.VolleyError;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.Task;
import com.loopj.android.http.RequestParams;
import com.orhanobut.hawk.Hawk;
import com.osama.insurco.R;
import com.osama.insurco.Settings.WebService;
import com.osama.insurco.api.IResult;
import com.osama.insurco.api.VolleyService;
import com.osama.insurco.ui.Main.MainActivity;
import com.osama.insurco.ui.StaticsPages.ContactUsActivity;
import com.osama.insurco.ui.splash.SelectLanguageActivity;
import com.osama.insurco.ui.splash.SplashActivity;
import com.osama.insurco.ui.splash.WelcomeActivity;

import org.json.JSONObject;

public class LoginActivity extends AppCompatActivity {
    TextView forgot;
    TextView reg;
    LinearLayout login;

    IResult mResultCallback;

    EditText phone;
    EditText password;

    ProgressBar loading;
    ImageView close;


//    908431000445-b05tn2v1epi3tfbhe12fjdgjb2nomul6.apps.googleusercontent.com
//    e3A9nqbrX2urmr84PavyWcD8

    private static final String EMAIL = "email";
    private static final String PUBLIC_PROFILE = "public_profile";
    GoogleSignInClient mGoogleSignInClient;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getSupportActionBar().hide();

        forgot = findViewById(R.id.forgot);
        reg = findViewById(R.id.reg);
        login = findViewById(R.id.login);
        phone = findViewById(R.id.phone);
        password = findViewById(R.id.password);
        loading = findViewById(R.id.loading);
        close = findViewById(R.id.close);


// finally change the color
        getWindow().setStatusBarColor(ContextCompat.getColor(LoginActivity.this, R.color.purple_200));



        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken("908431000445-b05tn2v1epi3tfbhe12fjdgjb2nomul6.apps.googleusercontent.com")//Client Secret :: gfoVyl298MxKZAoWD4YNZmI9
                .requestEmail()
                .build();
        mGoogleSignInClient = GoogleSignIn.getClient(LoginActivity.this, gso);





        SignInButton signInButton = findViewById(R.id.sign_in_button);
        signInButton.setSize(SignInButton.SIZE_STANDARD);
        signInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    signIn();

                } catch (Exception e) {

                }

            }
        });

        forgot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this, ForgotPasswordActivity.class));

            }
        });

        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this, RegisterActivity.class));

            }
        });
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if (phone.getText().toString().equals("") | password.getText().toString().equals("")) {

                    if (phone.getText().toString().equals("")) {
                        phone.setError(getResources().getString(R.string.required));
                    }
                    if (password.getText().toString().equals("")) {
                        password.setError(getResources().getString(R.string.required));
                    }
                } else {

                    loading.setVisibility(View.VISIBLE);
                    login.setVisibility(View.GONE);
                    RequestParams requestParams = new RequestParams();


                    try {


                        if (phone.getText().toString().toString().contains("971")) {

                            String oio = phone.getText().toString().toString();
                            oio = oio.replace("971", "");
                            phone.setText(oio + "");

                        }


                        requestParams.put("email", ncode_mobile + phone.getText().toString() + "");
                        requestParams.put("password", password.getText().toString() + "");
                        requestParams.put("fcm_token", 1 + "");
                        requestParams.put("device_type", "android");


                    } catch (Exception e) {

                    }

                    init_volley();
//                    WebService.loading(ContactUsActivity.this, true);
                    VolleyService mVolleyService = new VolleyService(mResultCallback, LoginActivity.this);
                    mVolleyService.postDataasync_with_file("loginForUsers", WebService.loginForUsers, requestParams);//category/1/product


                }


//                startActivity(new Intent(LoginActivity.this, MainActivity.class));

            }
        });

        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
    private void signIn() {
        Intent signInIntent = mGoogleSignInClient.getSignInIntent();
        startActivityForResult(signInIntent, 123);
    }
    public void init_volley() {

        mResultCallback = new IResult() {
            @Override
            public void notifySuccess(String requestType, JSONObject response) {
                Log.d("TAG", "Volley requester " + requestType);
                Log.d("TAG", "Volley JSON post" + response);
                //{"status":true,"code":200,"message":"User Profile","data"
                WebService.loading(LoginActivity.this, false);
//                progress.setVisibility(View.GONE);
                loading.setVisibility(View.GONE);
                login.setVisibility(View.VISIBLE);


                try {
                    boolean status = response.getBoolean("status");
                    String mesg = response.getString("message");
                    if (status) {


                        if (requestType.equals("loginForUsers")) {

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
                        }

                    } else {
//                        btn_id.revertAnimation();
//                        {"status":false,"code":201,"message":"Please Enter True Mobile Number and Password"}
                        String message = response.getString("message");

                        WebService.Make_Toast_color(LoginActivity.this, message, "error");

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
                WebService.loading(LoginActivity.this, false);
                loading.setVisibility(View.GONE);
                login.setVisibility(View.VISIBLE);

                try {
//                    btn_id.stopAnimation();
//                    btn_id.revertAnimation();

                    NetworkResponse response = error.networkResponse;
                    String response_data = new String(response.data);

                    JSONObject jsonObject = new JSONObject(response_data);

                    String message = jsonObject.getString("message");


                    WebService.Make_Toast_color(LoginActivity.this, message, "error");

                    Log.e("error response", response_data);

                } catch (Exception e) {

                }


            }

            @Override
            public void notify_Async_Error(String requestType, String error) {
//                loading.setVisibility(View.GONE);
                WebService.loading(LoginActivity.this, false);

            }
        };


    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // Result returned from launching the Intent from GoogleSignInClient.getSignInIntent(...);
        if (requestCode == 123) {
            // The Task returned from this call is always completed, no need to attach
            // a listener.
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);


            handleSignInResult(task);
        }
    }
    private void handleSignInResult(Task<GoogleSignInAccount> completedTask) {
        try {
            GoogleSignInAccount account = completedTask.getResult(ApiException.class);

            // Signed in successfully, show authenticated UI.
//            updateUI(account);

            String idToken = account.getIdToken();


            loading.setVisibility(View.VISIBLE);
            login.setVisibility(View.GONE);
            RequestParams requestParams = new RequestParams();


            try {




                requestParams.put("first_name",  account.getDisplayName()+"");
                requestParams.put("last_name",  account.getFamilyName()+"");
                requestParams.put("email",  account.getEmail()+"");
                requestParams.put("social_img", account.getPhotoUrl()+"");
                requestParams.put("provider",  "google");
                requestParams.put("social_token", idToken + "");
                requestParams.put("fcm_token", 1 + "");
                requestParams.put("device_type", "android");





            } catch (Exception e) {

            }

            init_volley();
//                    WebService.loading(ContactUsActivity.this, true);
            VolleyService mVolleyService = new VolleyService(mResultCallback, LoginActivity.this);
            mVolleyService.postDataasync_with_file("loginForUsers", WebService.loginBySocial, requestParams);//category/1/product






        } catch (ApiException e) {
            // The ApiException status code indicates the detailed failure reason.
            // Please refer to the GoogleSignInStatusCodes class reference for more information.
            Log.w("TAG", "signInResult:failed code=" + e.getStatusCode());
//            updateUI(null);
        }
    }
}