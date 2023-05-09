package com.osama.insurco.ui.Order.Adapter;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.osama.insurco.Modules.MotoTypeInsuranceModules;
import com.osama.insurco.Modules.Orders;
import com.osama.insurco.R;
import com.osama.insurco.api.IResult;
import com.osama.insurco.ui.Company.CompanySelectionActivity;
import com.osama.insurco.ui.Order.OrderActivity;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;


/**
 * Created by osama on 10/16/2017.
 */
public class RecyclerView_order extends RecyclerView.Adapter<RecyclerView_order.MyViewHolder> {
    public static List<Orders.Item> alldata = new ArrayList<Orders.Item>();
    static int Postion_opend = -1;
    IResult mResultCallback;


    static AlertDialog alertDialog;
    private ItemClickListener mItemClickListener;


    /**
     * View holder class
     */
    Context context;

    public void addItemClickListener(ItemClickListener listener) {
        mItemClickListener = listener;
    }

    public void Refr() {


        this.notifyDataSetChanged();
    }

    public void RefreshData() {
        this.notifyDataSetChanged();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        //        CircleImageView story_image;
//        ProgressBar progress;
//        LinearLayout add_to_my;
//        ImageView image_category;
//        TextView title_category;


        TextView title;
        TextView date;
        ImageView img;

        public MyViewHolder(View view) {
            super(view);
            //  title_cared_product_rec = (TextView) view.findViewById(R.id.title_cared_product_rec);


            title = view.findViewById(R.id.title);
            date = view.findViewById(R.id.date);
            img = view.findViewById(R.id.img);


////            simpleRatingBar = view.findViewById(R.id.simpleRatingBar);

        }
    }

    public RecyclerView_order(Context context, List<Orders.Item> alldata) {
        this.alldata = alldata;
        this.context = context;
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {


//        holder.setIsRecyclable(false);


//        holder.price.setText(alldata.get(position).getPrice() + " $ ");
//        holder.duration.setText(alldata.get(position).getExpectedDuration() + "");
//        holder.name_priza.setText(alldata.get(position).getPrizeTitle() + "");
//        holder.title.setText(alldata.get(position).getName() +"");
//


        try {
            //2022-11-24T07:36:11.000000Z

            if(alldata.get(position).getCompany().size()!=0){

                Date userDob = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'").parse(alldata.get(position).getCompany().get(0).getCreatedAt().toString());
//            userDob.setTimeZone(TimeZone.getTimeZone("UTC"));//2023-02-21T08:17:54.000000Z
                Date today = new Date();
                long diff = today.getTime() - userDob.getTime();
                int numOfDays = (int) (diff / (1000 * 60 * 60 * 24));
                int hours = (int) (diff / (1000 * 60 * 60));
                int minutes = (int) (diff / (1000 * 60));
                int seconds = (int) (diff / (1000));


                hours=8-hours;

                System.out.println("numOfDays" + numOfDays);
                System.out.println("hours" + hours);
                System.out.println("minutes" + minutes);
                if (hours <= 0) {

                    if(minutes >10){
                        holder.date.setText(context.getResources().getString(R.string.Expires_in) + " " + minutes + " " + context.getResources().getString(R.string.minutes));

                    }else{
                        holder.date.setText(context.getResources().getString(R.string.finish));

                    }

                } else {
                    holder.date.setText(context.getResources().getString(R.string.Expires_in) + " " + hours + " " + context.getResources().getString(R.string.hours));

                }

            }


//             else if (hours == 8) {
//                holder.date.setText(context.getResources().getString(R.string.finish));
//
//            }
        } catch (Exception e) {

        }


//
//        Glide.with(context).load(alldata.get(position).getImage()).into(holder.image);


//
//        holder.title.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//
//
//                if (isChecked) {
//                    alldata.get(position).setSelected(true);
//                } else {
//                    alldata.get(position).setSelected(false);
//
//                }
//
//
//                if (mItemClickListener != null)
//                    mItemClickListener.onItemClick(alldata);
//
//            }
//        });


////        holder.details.setText(alldata.get(position).getName());
////        if (alldata.get(position).getRate() != null) {
////            if (!alldata.get(position).getRate().equals("null")) {
////
////                holder.ratingbar.setStar(Integer.valueOf(alldata.get(position).getRate()));
////
////
////            }
////        }


//        if (alldata.get(position).getTag().equals("order")) {
//            holder.title.setText(context.getResources().getString(R.string.order_notfication) + "");
//
//        } else {
//            holder.title.setText(alldata.get(position).getTag() + "");
//
//        }
//
//        holder.desc.setText(alldata.get(position).getMessage() + "");
////////
////
////
//
//        try {
//
//            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm");
//
//            String dateInStrings = alldata.get(position).getCreatedAt() + "";
//            String dateInString = dateInStrings.substring(0, 19);
//
////                SimpleDateFormat formatterOut = new SimpleDateFormat("dd MMM");
//
//            Date date = formatter.parse(dateInString);
////                holder.date.setText(formatterOut.format(date));
//            holder.date.setText(Settings.printDifference_2(date, (Activity) context));
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
////


////        System.out.println(alldata.get(position).getImage() + "");
//        Picasso.with(context).load(alldata.get(position).getCampaignImage()).into(holder.image_product);
//////
////
////        try {
////
////
//////
////        System.out.println(alldata.get(position).getImage() + "");
////        Picasso.with(context).load(alldata.get(position).getImage()).into(holder.image);
////        holder.title_category.setText(alldata.get(position).getName());
////        holder.title.setText(alldata.get(position).getTitle()+"");
////        holder.description.setText(alldata.get(position).getDetails()+"");
////////
////
////        int random = ThreadLocalRandom.current().nextInt(1, 5);
////       holder.ratingbar.setStar(random);
//
//
//        //   wallet, dafter, receipt, payment
////
////        if (position == Postion_opend) {
////            holder.back_ground.setBackground(context.getResources().getDrawable(R.drawable.button_login));
////
////            holder.text.setTextColor(context.getResources().getColor(R.color.white));
////        } else {
////            holder.text.setTextColor(context.getResources().getColor(R.color.textColor));
////            holder.back_ground.setBackground(context.getResources().getDrawable(R.drawable.search_background));
////
////        }
//
////            double v=Double.valueOf(alldata.get(position).getRate());
////
////
////
////            holder.simpleRatingBar.setRating((float) v);
////
////
////        }catch (Exception e){
////
////        }
////
////
////        holder.image_user.setOnClickListener(new View.OnClickListener() {
////            @Override
////            public void onClick(View view) {
//////                if (alldata.get(position).getType().equals("user")) {
//////                    Intent intent = new Intent(context, ProfileTravilingActivity.class);
//////                    intent.putExtra("id_user", alldata.get(position).getId() + "");
//////                    intent.putExtra("type", "other_frinds");
//////
//////                    context.startActivity(intent);
//////                } else {
//////                    Intent intent = new Intent(context, ProfileTourGuidActivity.class);
//////                    intent.putExtra("id_user", alldata.get(position).getId() + "");
//////                    intent.putExtra("type", "other_frinds");
//////
//////                    context.startActivity(intent);
//////                }
////            }
////        });
////
//
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                OrderActivity.ordier = alldata.get(position);

                Intent intent = new Intent(context, CompanySelectionActivity.class);
                context.startActivity(intent);
////                overridePendingTransition(R.anim.fade_in_info, R.anim.fade_out_info);
//
//
//                Intent intent = new Intent(context, ShowFullImageActivity.class);
//
//
//                intent.putExtra("url", alldata.get(position).getImage() + "");
////                intent.putExtra("type", "other" + "");
////                intent.putExtra("text", alldata.get(position).getName() + "");
//                context.startActivity(intent);
////                overridePendingTransition(R.anim.fade_in_info, R.anim.fade_out_info);
//
//                Postion_opend = position;
//                Refr();
//

            }
        });
//
//        holder.addToCart.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                JSONObject jsonObject = new JSONObject();
//
//                try {
//
//
//                    jsonObject.put("campaign_id", alldata.get(position).getId()+"");
//
//
//                } catch (Exception e) {
//
//                }
//
//
//                init_volley();
//
//                VolleyService mVolleyService = new VolleyService(mResultCallback, context);
//
//                WebService.loading((Activity) context, true);
//
//                mVolleyService.postDataVolley("addCampaignToCart", WebService.addCampaignToCart, jsonObject);
//
//
//            }
//        });
//

    }

    static PopupWindow popupWindow;


    @Override
    public int getItemCount() {
        return alldata.size();
    }

    public static int getIcCount() {
        return alldata.size();
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {


        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_order, parent, false);


        // Fresco.initialize(context);


        return new MyViewHolder(v);
    }

    //Define your Interface method here
    public interface ItemClickListener {
        void onItemClick(List<MotoTypeInsuranceModules.InsurancesType> alldata);
    }


}