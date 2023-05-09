package com.osama.insurco.ui.splash.Adapter;

import android.content.Context;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.viewpager.widget.PagerAdapter;


import com.airbnb.lottie.LottieAnimationView;
import com.bumptech.glide.Glide;
import com.osama.insurco.Modules.AdsModules;
import com.osama.insurco.Modules.Slider;
import com.osama.insurco.R;

import java.util.List;


public class viewPager_Adapter_slider extends PagerAdapter {


    private List<AdsModules.Ad> IMAGES;
    private LayoutInflater inflater;
    private Context context;


    public viewPager_Adapter_slider(Context context, List<AdsModules.Ad> IMAGES) {
        this.context = context;
        this.IMAGES = IMAGES;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }

    @Override
    public int getCount() {
        return IMAGES.size();
    }

    @Override
    public Object instantiateItem(ViewGroup view, final int position) {
        View imageLayout = inflater.inflate(R.layout.item_slider, view, false);

        assert imageLayout != null;

////        TextView title = imageLayout.findViewById(R.id.title);
//        TextView titel = imageLayout.findViewById(R.id.titel);
        TextView title = imageLayout.findViewById(R.id.title);
        TextView des = imageLayout.findViewById(R.id.des);
        ImageView image = imageLayout.findViewById(R.id.image);
        LottieAnimationView animationView = imageLayout.findViewById(R.id.animationView);
//        ImageView love = imageLayout.findViewById(R.id.love);
//        VideoView videoView = imageLayout.findViewById(R.id.videoView);
//        ProgressBar progress = imageLayout.findViewById(R.id.progress);



        if(position==0){
            title.setText(context.getResources().getString(R.string.asd1));
            des.setText(context.getResources().getString(R.string.asd11));
            animationView.setAnimation(R.raw.w_1);
        }else if(position==1){
            title.setText(context.getResources().getString(R.string.asd2));
            des.setText(context.getResources().getString(R.string.asd22));
            animationView.setAnimation(R.raw.w_2);

        } else{
            title.setText(context.getResources().getString(R.string.asd3));
            des.setText(context.getResources().getString(R.string.asd33));
            animationView.setAnimation(R.raw.w_3);

        }


//
//        title.setText(IMAGES.get(position).getName().toString());
//        des.setText(IMAGES.get(position).getDetails().toString());


//        Glide.with(context).load(IMAGES.get(position).getImage() + "").into(image);


//

//

        view.addView(imageLayout, 0);

        return imageLayout;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view.equals(object);
    }

    @Override
    public void restoreState(Parcelable state, ClassLoader loader) {
    }

    @Override
    public Parcelable saveState() {
        return null;
    }


}