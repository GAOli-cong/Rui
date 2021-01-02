package com.glc.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.media.Image;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.kaisengao.likeview.like.KsgLikeView;

public class XiangQingActivity extends AppCompatActivity {
private TextView tv_title;
private TextView tv_time;
private TextView tv_content;
private ImageView iv_fanhui;
private KsgLikeView xiangqing_live_view;
private Handler handler=new Handler();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xiang_qing);
        tv_title=findViewById(R.id.xiangqing_title);
        tv_time=findViewById(R.id.xiangqing_time);
        tv_content=findViewById(R.id.xiangqing_content);
        iv_fanhui=findViewById(R.id.xiangqiang_fanhui);
        xiangqing_live_view=findViewById(R.id.xiangqing_live_view);

        AssetManager mgr = getAssets();
        tv_title.setTypeface(Typeface.createFromAsset(mgr, "font/fanxing.ttf"));



        xiangqing_live_view.addLikeImage(R.drawable.heart0);
        xiangqing_live_view.addLikeImage(R.drawable.heart1);
        xiangqing_live_view.addLikeImage(R.drawable.heart2);
        xiangqing_live_view.addLikeImage(R.drawable.heart3);
        xiangqing_live_view.addLikeImage(R.drawable.heart4);
        xiangqing_live_view.addLikeImage(R.drawable.heart5);
        xiangqing_live_view.addLikeImage(R.drawable.heart6);
        xiangqing_live_view.addLikeImage(R.drawable.heart7);
        xiangqing_live_view.addLikeImage(R.drawable.heart8);

        handler.post(new Runnable() {
            @Override
            public void run() {
                try {
                    xiangqing_live_view.addFavor();//飘出小心心
                }catch (Exception e){
                    e.printStackTrace();
                }
                handler.postDelayed(this,500);
            }
        });


        iv_fanhui.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        Intent intent=getIntent();
        String titleStr=intent.getStringExtra("title");
        String timeStr=intent.getStringExtra("time");
        String contentStr=intent.getStringExtra("content");
        tv_title.setText(titleStr);
        tv_time.setText(timeStr);
        tv_content.setText("\u3000\u3000"+contentStr);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        handler.removeCallbacksAndMessages(null);
    }
}
