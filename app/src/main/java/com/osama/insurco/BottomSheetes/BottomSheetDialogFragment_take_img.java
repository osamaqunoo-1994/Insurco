package com.osama.insurco.BottomSheetes;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.EditText;
import android.widget.ImageView;

import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.osama.insurco.R;
import com.wildma.idcardcamera.camera.IDCardCamera;

import cz.msebera.android.httpclient.util.TextUtils;


public class BottomSheetDialogFragment_take_img extends BottomSheetDialogFragment {
    private ItemClickListener mItemClickListener;

    public void addItemClickListener(ItemClickListener listener) {
        mItemClickListener = listener;
    }



ImageView front_img;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.bottom_sh_add_img, container, false);


        front_img=v.findViewById(R.id.front_img);

        front_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                IDCardCamera.create(getActivity()).openCamera(IDCardCamera.TYPE_IDCARD_BACK);

            }
        });




//'new','waiting','Inprogress','completed','closed','return','return_completed','return_closed'
        return v;
    }


//    categories_bottomSheetDialogFragment = new Categories_BottomSheetDialogFragment("");
//                categories_bottomSheetDialogFragment.show(getSupportFragmentManager(), "");

//    @NonNull

//    @Override
//    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
//        return new BottomSheetDialog(getContext(), R.style.MyTransparentBottomSheetDialogTheme);
//
//    }

    public BottomSheetDialogFragment_take_img(String id) {

    }

    @Override
    public void setupDialog(Dialog dialog, int style) {
        View contentView = View.inflate(getContext(), R.layout.bottom_sh_add_img, null);
        dialog.setContentView(contentView);
        ((View) contentView.getParent()).setBackgroundColor(getResources().getColor(android.R.color.transparent));
    }


    //Define your Interface method here
    public interface ItemClickListener {
        void onItemClick(String service,String freelancer_communication, String service_described, String would_recommended, String note);
    }

    //
    @Override
    public void onStart() {
        super.onStart();
        if (getDialog() != null && getDialog().getWindow() != null && Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            Window window = getDialog().getWindow();
            window.findViewById(com.google.android.material.R.id.container).setFitsSystemWindows(false);
            // dark navigation bar icons
            View decorView = window.getDecorView();
            decorView.setSystemUiVisibility(decorView.getSystemUiVisibility() | View.SYSTEM_UI_FLAG_LIGHT_NAVIGATION_BAR);
        }
    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == IDCardCamera.RESULT_CODE) {
            //获取图片路径，显示图片
            final String path = IDCardCamera.getImagePath(data);
            if (!TextUtils.isEmpty(path)) {

                if (requestCode == IDCardCamera.TYPE_IDCARD_FRONT) { //身份证正面
                    front_img.setImageBitmap(BitmapFactory.decodeFile(path));
                } else if (requestCode == IDCardCamera.TYPE_IDCARD_BACK) {  //身份证反面
                    front_img.setImageBitmap(BitmapFactory.decodeFile(path));
                }
            }
        }
    }
}
