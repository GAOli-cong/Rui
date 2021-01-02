package com.glc.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.glc.myapplication.db.MyHelper;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ht_AddActivity extends AppCompatActivity {
private EditText edt1;
//private EditText edt2;
private EditText edt3;
private Button queding;
private ImageView fanhui;
private MyHelper myHelper=new MyHelper(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ht__add);
        edt1=findViewById(R.id.edt_ht_title);
      //  edt2=findViewById(R.id.edt_ht_time);
        edt3=findViewById(R.id.edt_ht_content);
        queding=findViewById(R.id.ht_button_submit);
        fanhui=findViewById(R.id.image_fanhui);
        fanhui.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });


        queding.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(edt1.getText().toString().equals("")||edt3.getText().toString().equals("")){
                    Toast.makeText(ht_AddActivity.this, "小可爱，请输入完整，才能添加成功哟", Toast.LENGTH_SHORT).show();
                }else {
                    getData();

                }
            }
        });
    }

    private void getData() {
        String s1 = edt1.getText().toString().trim();
       // String s2 = edt2.getText().toString().trim();
        String s3 = edt3.getText().toString().trim();
        SQLiteDatabase db=myHelper.getWritableDatabase();
        ContentValues contentValues=new ContentValues();

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日");// HH:mm:ss

        Date date = new Date(System.currentTimeMillis());
        String s2 = simpleDateFormat.format(date);
        contentValues.put("title",s1);
        contentValues.put("time",s2);
        contentValues.put("content",s3);
        db.insert("information",null,contentValues);
        db.close();
        Toast.makeText(this, "添加成功", Toast.LENGTH_SHORT).show();






    }
}
