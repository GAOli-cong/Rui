package com.glc.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class HouTaiActivity extends AppCompatActivity {
private Button addButton;
private Button deleteButton;
private ImageView fanhui;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hou_tai);
        addButton=findViewById(R.id.button_add);
        deleteButton=findViewById(R.id.button_delete);
        fanhui=findViewById(R.id.image_fanhui);
        fanhui.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HouTaiActivity.this,ht_AddActivity.class));
            }
        });

        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HouTaiActivity.this,ht_delAndUpActivity.class));
            }
        });
    }
}
