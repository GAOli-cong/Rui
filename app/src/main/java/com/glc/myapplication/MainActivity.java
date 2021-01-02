package com.glc.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.glc.myapplication.fragment.fragment1;
import com.glc.myapplication.fragment.fragment2;
import com.glc.myapplication.fragment.fragment3;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ViewPager vp;
    private LinearLayout btn1;
    private TextView tv1;
    private ImageView imgIndex;
    private LinearLayout btn2;
    private TextView tv2;
    private ImageView imgDongtai;
    private LinearLayout btn3;
    private TextView tv3;
    private ImageView imgMe;

    List<Fragment> fragments = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        vp = findViewById(R.id.vp_vp1);
        btn1 = findViewById(R.id.ly_btn1);
        tv1 = findViewById(R.id.tv_index);
        imgIndex = findViewById(R.id.img_index);
        btn2 = findViewById(R.id.ly_btn2);
        tv2 = findViewById(R.id.tv_dongtai);
        imgDongtai = findViewById(R.id.img_dongtai);
        btn3 = findViewById(R.id.ly_btn3);
        tv3 = findViewById(R.id.tv_wode);
        imgMe = findViewById(R.id.img_me);
        fragments.add(new fragment1());
        fragments.add(new fragment2());
        fragments.add(new fragment3());



        vp.setOffscreenPageLimit(3);
        vp.setAdapter(new MyPageAdapter(getSupportFragmentManager()));
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                vp.setCurrentItem(0);
                tv1.setTextColor(Color.parseColor("#DDA0DD"));
                tv2.setTextColor(Color.parseColor("#dbdbdb"));
                tv3.setTextColor(Color.parseColor("#dbdbdb"));
                imgIndex.setImageResource(R.drawable.a1);
                imgDongtai.setImageResource(R.drawable.aa2);
                imgMe.setImageResource(R.drawable.aa3);

            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                vp.setCurrentItem(1);
                tv2.setTextColor(Color.parseColor("#DDA0DD"));
                tv1.setTextColor(Color.parseColor("#dbdbdb"));
                tv3.setTextColor(Color.parseColor("#dbdbdb"));
                imgIndex.setImageResource(R.drawable.aa1);
                imgDongtai.setImageResource(R.drawable.a2);
                imgMe.setImageResource(R.drawable.aa3);

            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                vp.setCurrentItem(2);
                tv3.setTextColor(Color.parseColor("#DDA0DD"));
                tv1.setTextColor(Color.parseColor("#dbdbdb"));
                tv2.setTextColor(Color.parseColor("#dbdbdb"));
                imgIndex.setImageResource(R.drawable.aa1);
                imgDongtai.setImageResource(R.drawable.aa2);
                imgMe.setImageResource(R.drawable.a3);
            }
        });


        vp.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                switch (position) {
                    case 0:
                        tv1.setTextColor(Color.parseColor("#DDA0DD"));
                        tv2.setTextColor(Color.parseColor("#dbdbdb"));
                        tv3.setTextColor(Color.parseColor("#dbdbdb"));
                        imgIndex.setImageResource(R.drawable.a1);
                        imgDongtai.setImageResource(R.drawable.aa2);
                        imgMe.setImageResource(R.drawable.aa3);
                        break;
                    case 1:
                        tv2.setTextColor(Color.parseColor("#DDA0DD"));
                        tv1.setTextColor(Color.parseColor("#dbdbdb"));
                        tv3.setTextColor(Color.parseColor("#dbdbdb"));
                        imgIndex.setImageResource(R.drawable.aa1);
                        imgDongtai.setImageResource(R.drawable.a2);
                        imgMe.setImageResource(R.drawable.aa3);

                        break;
                    case 2:
                        tv3.setTextColor(Color.parseColor("#DDA0DD"));
                        tv1.setTextColor(Color.parseColor("#dbdbdb"));
                        tv2.setTextColor(Color.parseColor("#dbdbdb"));
                        imgIndex.setImageResource(R.drawable.aa1);
                        imgDongtai.setImageResource(R.drawable.aa2);
                        imgMe.setImageResource(R.drawable.a3);
                        break;


                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });


    }


    class MyPageAdapter extends FragmentPagerAdapter{

        public MyPageAdapter(@NonNull FragmentManager fm) {
            super(fm);
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
            return fragments.get(position);
        }

        @Override
        public int getCount() {
            return fragments.size();
        }
    }

}
