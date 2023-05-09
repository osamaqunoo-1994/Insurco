package com.osama.insurco.ui.Main.adapter;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.VideoView;

import androidx.viewpager.widget.PagerAdapter;

import com.bumptech.glide.Glide;
import com.osama.insurco.Modules.AdsModules;
import com.osama.insurco.R;

import java.util.List;


public class viewPager_Home_Adapter_slider extends PagerAdapter {


    private List<AdsModules.Ad> IMAGES;
    private LayoutInflater inflater;
    private Context context;
    VideoView video;


    public viewPager_Home_Adapter_slider(Context context, List<AdsModules.Ad> IMAGES) {
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
        View imageLayout = inflater.inflate(R.layout.item_slider_inside, view, false);

        assert imageLayout != null;

        ImageView image = imageLayout.findViewById(R.id.image);
        VideoView video = imageLayout.findViewById(R.id.video);
        ProgressBar progress = imageLayout.findViewById(R.id.progress);

        if (IMAGES.get(position).getFile_type().toString().equals("image")) {
            TextView title = imageLayout.findViewById(R.id.title);
            TextView des = imageLayout.findViewById(R.id.des);
//        ImageView love = imageLayout.findViewById(R.id.love);
//        VideoView videoView = imageLayout.findViewById(R.id.videoView);
//        ProgressBar progress = imageLayout.findViewById(R.id.progress);
            title.setVisibility(View.VISIBLE);
            des.setVisibility(View.VISIBLE);
            image.setVisibility(View.VISIBLE);
            video.setVisibility(View.GONE);
            progress.setVisibility(View.GONE);

//            title.setText(IMAGES.get(position).getName().toString());
//            des.setText(IMAGES.get(position).getDetails().toString());


            Glide.with(context).load(IMAGES.get(position).getImage() + "").into(image);

            image.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
//                    url

                    String url = "" + IMAGES.get(position).getUrl();
                    Intent i = new Intent(Intent.ACTION_VIEW);
                    i.setData(Uri.parse(url));
                    context.startActivity(i);
                }
            });
//

//
        } else {
            TextView title = imageLayout.findViewById(R.id.title);
            TextView des = imageLayout.findViewById(R.id.des);
            title.setVisibility(View.GONE);
            des.setVisibility(View.GONE);
            image.setVisibility(View.GONE);
            video.setVisibility(View.VISIBLE);
            progress.setVisibility(View.VISIBLE);
            Uri uri = Uri.parse("" + IMAGES.get(position).getVideo().toString());

            video.setVideoURI(uri);
//            new BackgroundAsyncTask().execute(""+IMAGES.get(position).getVideo().toString());

            // creating object of
            // media controller class
            MediaController mediaController = new MediaController(context);

            video.setOnCompletionListener(new MediaPlayer.OnCompletionListener()
            {
                public void onCompletion(MediaPlayer mp)
                {
                    // Do whatever u need to do here
                    video.start();

                }
            });
            video.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {

                public void onPrepared(MediaPlayer arg0) {
                    progress.setVisibility(View.GONE);

                    video.start();
                }
            });
            video.start();

            // sets the anchor view
            // anchor view for the videoView
//            mediaController.setAnchorView(videoView);

            // sets the media player to the videoView
//            mediaController.setMediaPlayer(videoView);

            // sets the media controller to the videoView
//            video.setMediaController(mediaController);

            // starts the video
        }

////        TextView title = imageLayout.findViewById(R.id.title);
//        TextView titel = imageLayout.findViewById(R.id.titel);


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

    public class BackgroundAsyncTask extends AsyncTask<String, Uri, Void> {
        Integer track = 0;

        protected void onPreExecute() {


        }

        protected void onProgressUpdate(final Uri... uri) {

            try {


                if (video != null) {
                    video.setVideoURI(uri[0]);
                    video.requestFocus();
                    video.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {

                        public void onPrepared(MediaPlayer arg0) {
                            video.start();
                        }
                    });

                }


            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            } catch (IllegalStateException e) {
                e.printStackTrace();
            } catch (SecurityException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }


        }

        @Override
        protected Void doInBackground(String... params) {
            try {
                Uri uri = Uri.parse(params[0]);

                publishProgress(uri);
            } catch (Exception e) {
                e.printStackTrace();

            }

            return null;
        }

    }
}