 package com.example.xiaowen.scorviewactivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.xiaowen.scorviewactivity.utils.CommonUtils;

 public class MainActivity extends AppCompatActivity {
//    private ActivityMainBinding binding;
public final static String PARAM = "isRecyclerView";
     private ImageView iv_song_list;
     private TextView tv_recyclerview,tv_txt_show;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        iv_song_list= (ImageView) findViewById(R.id.iv_song_list);
        tv_recyclerview= (TextView) findViewById(R.id.tv_recyclerview);
        tv_txt_show= (TextView) findViewById(R.id.tv_txt_show);
        
        setTitle("仿网易云音乐歌单详情页");
        Glide.with(this)
                .load(NeteasePlaylistActivity.IMAGE_URL_LARGE)
                .crossFade(500)
                .override((int) CommonUtils.getDimens(R.dimen.movie_detail_width), (int) CommonUtils.getDimens(R.dimen.movie_detail_height))
                .into(iv_song_list);

        tv_recyclerview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // RecyclerView列表显示
            }
        });
        tv_txt_show.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View v) {
                // 一般文本显示
                start(MainActivity.this,iv_song_list,false);
            }
        });


        tv_recyclerview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                intent.setClass(MainActivity.this,CustomActivity.class);
                startActivity(intent);
            }
        });
    }


     /**
      * @param context        activity
      * @param imageView      imageView
      * @param isRecyclerView 是否为列表
      */
     public   void start(Activity context, ImageView imageView, boolean isRecyclerView) {
         Intent intent = new Intent(context, NeteasePlaylistActivity.class);
         intent.putExtra(PARAM, isRecyclerView);
         ActivityOptionsCompat options = ActivityOptionsCompat.makeSceneTransitionAnimation(context,
                 imageView, CommonUtils.getString(R.string.transition_book_img));//与xml文件对应
         ActivityCompat.startActivity(context, intent, options.toBundle());
     }
}
