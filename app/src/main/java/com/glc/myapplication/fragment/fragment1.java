package com.glc.myapplication.fragment;

import android.content.res.AssetManager;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.glc.myapplication.R;
import com.kaisengao.likeview.like.KsgLikeView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class fragment1 extends Fragment {
    private TextView tv1;//倒计时
    private Handler handler;
    private Handler handler2;
    private ImageView image1;
    private ImageView image2;//小红心
    private ImageView image3;
    private KsgLikeView mLikeView;
    private LinearLayout lv_center;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment1, null);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        tv1 = view.findViewById(R.id.tv_textDaojishi);
        image1 = view.findViewById(R.id.f1_image1);
        image2 = view.findViewById(R.id.f1_image2);
        image3 = view.findViewById(R.id.f1_image3);
        lv_center=view.findViewById(R.id.lv_lv_center);
        //设置字体样式
        AssetManager mgr = getActivity().getAssets();
        tv1.setTypeface(Typeface.createFromAsset(mgr, "font/fanxing.ttf"));

        mLikeView = view.findViewById(R.id.live_view);
        mLikeView.addLikeImage(R.drawable.heart0);
        mLikeView.addLikeImage(R.drawable.heart1);
        mLikeView.addLikeImage(R.drawable.heart2);
        mLikeView.addLikeImage(R.drawable.heart3);
        mLikeView.addLikeImage(R.drawable.heart4);
        mLikeView.addLikeImage(R.drawable.heart5);
        mLikeView.addLikeImage(R.drawable.heart6);
        mLikeView.addLikeImage(R.drawable.heart7);
        mLikeView.addLikeImage(R.drawable.heart8);
        //小红心点击出现飘心效果
        lv_center.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mLikeView.addFavor();
            }
        });
        //自动定时执行小心心飘出
        handler2=new Handler();
        handler2.post(new Runnable() {
            @Override
            public void run() {
                try {
                    mLikeView.addFavor();//飘出小心心
                }catch (Exception e){
                    e.printStackTrace();
                }

                handler2.postDelayed(this,1000);
            }
        });

        //时间每隔一秒刷新
        handler = new Handler();
        handler.post(new Runnable() {
            @Override
            public void run() {
                String s = dateDiff("2020-05-04 22:20:00");
                tv1.setText(s);
                tv1.setTextColor(Color.parseColor("#DDA0DD"));
                handler.postDelayed(this, 1000);
            }
        });

        //设置圆形头像效果
        RequestOptions options = RequestOptions.circleCropTransform();
        Glide.with(getActivity()).load(R.drawable.f1t1).apply(options).into(image1);
        Glide.with(getActivity()).load(R.drawable.f1t2).apply(options).into(image3);

    }

    /**
     * 获取时间差的方法
     *
     * @param endTime
     * @return
     */
    public String dateDiff(String endTime) {
        String strTime = null;
        // 按照传入的格式生成一个simpledateformate对象
        SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        long nd = 1000 * 24 * 60 * 60;// 一天的毫秒数
        long nh = 1000 * 60 * 60;// 一小时的毫秒数
        long nm = 1000 * 60;// 一分钟的毫秒数
        long ns = 1000;// 一秒钟的毫秒数
        long diff;
        long day = 0;
        Date curDate = new Date(System.currentTimeMillis());//获取当前时间
        String str = sd.format(curDate);
        try {
            // 获得两个时间的毫秒时间差异
            diff = sd.parse(endTime).getTime()
                    - sd.parse(str).getTime();
            day = diff / nd;// 计算差多少天
            long hour = diff % nd / nh;// 计算差多少小时
            long min = diff % nd % nh / nm;// 计算差多少分钟
            long sec = diff % nd % nh % nm / ns;// 计算差多少秒
            String s = day + "天" + hour + "时" + min + "分" + sec + "秒";
            return s.replaceAll("-", "");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
       handler.removeCallbacksAndMessages(null);
       handler2.removeCallbacksAndMessages(null);
    }
}
