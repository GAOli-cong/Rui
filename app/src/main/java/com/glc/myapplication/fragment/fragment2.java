package com.glc.myapplication.fragment;

import android.content.Intent;
import android.content.res.AssetManager;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Typeface;
import android.media.Image;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.RetryPolicy;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.glc.myapplication.R;
import com.glc.myapplication.XiangQingActivity;
import com.glc.myapplication.db.MyHelper;
import com.glc.myapplication.entity.Title;
import com.kaisengao.likeview.like.KsgLikeView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class fragment2 extends Fragment {
    private ListView lv;
    private TextView shijian;
    private List<Title> titles = new ArrayList<>();
    private BaseAdapter adapter;
    private KsgLikeView ksgLikeView;
    private Handler handler;
    private TextView aixinkaigaun;
    private int flag = 1;
    private ImageView shuaxin;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment2, null);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        lv = view.findViewById(R.id.f2_Listview);
        shijian = view.findViewById(R.id.shijianzhou);
        shuaxin = view.findViewById(R.id.img_f2_shuaxin);

        ksgLikeView = view.findViewById(R.id.f2_live_view);
        aixinkaigaun = view.findViewById(R.id.f2_aixikaiguan);
        ksgLikeView.addLikeImage(R.drawable.heart0);
        ksgLikeView.addLikeImage(R.drawable.heart1);
        ksgLikeView.addLikeImage(R.drawable.heart2);
        ksgLikeView.addLikeImage(R.drawable.heart3);
        ksgLikeView.addLikeImage(R.drawable.heart4);
        ksgLikeView.addLikeImage(R.drawable.heart5);
        ksgLikeView.addLikeImage(R.drawable.heart6);
        ksgLikeView.addLikeImage(R.drawable.heart7);
        ksgLikeView.addLikeImage(R.drawable.heart8);

        //设置字体样式
        AssetManager mgr = getActivity().getAssets();
        shijian.setTypeface(Typeface.createFromAsset(mgr, "font/fanxing.ttf"));

        shuaxin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                titles.clear();
                getData();
                Toast.makeText(getContext(), "刷新成功", Toast.LENGTH_SHORT).show();
            }
        });
        //爱心发射开关按钮
        aixinkaigaun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (flag == 0) {
                    aixinkaigaun.setText("开启");
                    aixinkaigaun.setBackgroundDrawable(getActivity().getResources().getDrawable(R.drawable.heart0));
                    autoLove();

                    flag = 1;
                } else if (flag == 1) {
                    aixinkaigaun.setText("关闭");
                    aixinkaigaun.setBackgroundDrawable(getActivity().getResources().getDrawable(R.drawable.heart6));
                    handler.removeCallbacksAndMessages(null);

                    flag = 0;

                }
            }
        });
        autoLove();
        getData();


    }

    //请求得到服务器数据
    private void getData() {
        MyHelper myHelper=new MyHelper(getContext());
        SQLiteDatabase db=myHelper.getReadableDatabase();
        Cursor cursor=db.query("information",null,null,null,null,null,null);
        while (cursor.moveToNext()){
            String title = cursor.getString(1);
            String time = cursor.getString(3);
            String content= cursor.getString(2);
            titles.add(new Title(title, time, content));
        }
        adapter = new BaseAdapter() {
            @Override
            public int getCount() {
                return titles.size();
            }

            @Override
            public Object getItem(int i) {
                return null;
            }

            @Override
            public long getItemId(int i) {
                return 0;
            }

            @Override
            public View getView(int i, View view, ViewGroup viewGroup) {
                view = View.inflate(getContext(), R.layout.lv_item, null);
                TextView textView_time = view.findViewById(R.id.show_time);
                TextView textView_title = view.findViewById(R.id.show_title);
                View view1 = view.findViewById(R.id.line_normal);
                textView_time.setText(titles.get(i).getTime());
                textView_title.setText(titles.get(i).getTitle());
                //listView的每一项的点击事件
                lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        Log.d("woshiss", titles.get(0).getTitle());
                        //跳转传值bundle
                        Intent intent = new Intent(getActivity(), XiangQingActivity.class);
                        Bundle bundle = new Bundle();
                        bundle.putString("title", titles.get(i).getTitle());
                        bundle.putString("time", titles.get(i).getTime());
                        bundle.putString("content", titles.get(i).getContent());
                        intent.putExtras(bundle);
                        startActivity(intent);
                    }
                });
                //最后一项时，竖线不再显示
//                        if(i==jsonArray.length()-1){
//                            view1.setVisibility(View.GONE);
//                        }

                return view;
            }
        };
        //设置适配器
        lv.setAdapter(adapter);


}

    //定时执行小心心
    private void  autoLove(){
        handler=new Handler();
       handler.post(new Runnable() {
           @Override
           public void run() {
            ksgLikeView.addFavor();
            handler.postDelayed(this,1);
           }
       });
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        handler.removeCallbacksAndMessages(null);
    }
}
