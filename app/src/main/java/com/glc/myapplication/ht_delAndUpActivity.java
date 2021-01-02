package com.glc.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.glc.myapplication.db.MyHelper;
import com.glc.myapplication.entity.Title;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import static com.superrtc.mediamanager.EMediaManager.getContext;

public class ht_delAndUpActivity extends AppCompatActivity {
    private List<Title> titles = new ArrayList<>();
    private BaseAdapter adapter;
    private ListView lv;
    private ImageView fanhui;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ht_del_and_up);
        lv =findViewById(R.id.f2_Listview);
        fanhui=findViewById(R.id.image_fanhui);

        fanhui.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        getData();
    }

    private void getData() {
        MyHelper myHelper=new MyHelper(ht_delAndUpActivity.this);
        SQLiteDatabase db=myHelper.getReadableDatabase();
        Cursor cursor=db.query("information",null,null,null,null,null,null);
        while (cursor.moveToNext()){
            String title = cursor.getString(1);
            String time = cursor.getString(3);
            String content= cursor.getString(2);
            int columnIndex = cursor.getInt(cursor.getColumnIndex("_id"));
            titles.add(new Title(columnIndex,title, time, content));
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
                        view = View.inflate(ht_delAndUpActivity.this, R.layout.lv_item2, null);
                        TextView textView_time = view.findViewById(R.id.show_time);
                        TextView textView_title = view.findViewById(R.id.show_title);
                        TextView shanchu=view.findViewById(R.id.lv2_tv_shanchu);
                        try {
                            textView_time.setText(titles.get(i).getTime());
                            textView_title.setText(titles.get(i).getTitle());
                        }catch (Exception e){
                            e.printStackTrace();
                        }

                        //listView的每一项的点击事件
                       shanchu.setOnClickListener(new View.OnClickListener() {
                           @Override
                           public void onClick(View view) {
                              deleteInfo(titles.get(i).getId());

                           }
                       });

                        return view;
                    }
                };
                //设置适配器
                lv.setAdapter(adapter);

            }




//删除请求
private void  deleteInfo(long id){
        MyHelper myHelper=new MyHelper(ht_delAndUpActivity.this);
        SQLiteDatabase db=myHelper.getWritableDatabase();
        db.delete("information","_id=?",new String[]{id+""});
        db.close();
    Toast.makeText(this, "删除成功", Toast.LENGTH_SHORT).show();
    adapter.notifyDataSetChanged();
    titles.clear();
    getData();
        }
}