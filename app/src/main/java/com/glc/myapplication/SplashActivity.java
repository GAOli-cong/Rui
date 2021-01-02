package com.glc.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.Window;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.RelativeLayout;

public class SplashActivity extends AppCompatActivity {
    private Button btnSkip;
private Handler handler=new Handler();
    private Runnable runnableToMain = new Runnable() {
        @Override
        public void run() {
            toMainActivity();
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //设置没有标题栏
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_splash);
        btnSkip=findViewById(R.id.splash_btn_skip);
        initEvent();

        //延迟四秒
        handler.postDelayed(runnableToMain,4000);

    }
    public void initEvent(){
        btnSkip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //防止Activity被打开两次
                handler.removeCallbacks(runnableToMain);
                toMainActivity();
            }
        });
    }


    /**
     * 跳转到登录界面
     */
    private void toMainActivity(){
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        handler.removeCallbacks(runnableToMain);
    }
}
