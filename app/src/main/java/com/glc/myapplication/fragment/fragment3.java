package com.glc.myapplication.fragment;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.bitmap.BitmapTransformation;
import com.bumptech.glide.request.RequestOptions;
import com.glc.myapplication.HouTaiActivity;
import com.glc.myapplication.R;
import com.glc.myapplication.TianQiActivity;
import com.glc.myapplication.kuaidiActivity;
import com.glc.myapplication.util.BlurBitmapUtil;

import org.json.JSONException;
import org.json.JSONObject;

import java.security.MessageDigest;

public class fragment3 extends Fragment {
    private ImageView hBack;
    private ImageView hHead;

    private LinearLayout ll_tianqi;
    private LinearLayout ll_kuaidi;
    private EditText login_username;
    private EditText login_password;
    private Button btn_login;
    private Button btnRegister;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment3,null);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        hBack=view.findViewById(R.id.h_back);
        hHead=view.findViewById(R.id.h_head);

        ll_tianqi=view.findViewById(R.id.f3_ll_tianqi);
        //ll_kuaidi=view.findViewById(R.id.f3_ll_kuaidi);
//   btnRegister =view.findViewById(R.id.btn_registerActivity);
        login_username = view.findViewById(R.id.edt_login_username);
        login_password = view.findViewById(R.id.edt_login_password);
        btn_login = view.findViewById(R.id.btn_login);



        //glide 4.设置高斯模糊
        Glide.with(getActivity())
                .load(R.drawable.f3bg)
                .apply(RequestOptions.bitmapTransform(new GlideBlurformation(getActivity())))
                .into(hBack);
        //圆形头像
        RequestOptions options = RequestOptions.circleCropTransform();
        Glide.with(getActivity()).load(R.drawable.f3bg).apply(options).into(hHead);

        //天气按钮点击事件
        ll_tianqi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), TianQiActivity.class));
            }
        });

        //快递按钮点击事件
//        ll_kuaidi.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//               startActivity(new Intent(getActivity(), kuaidiActivity.class));
//            }
//        });




        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String usernameStr = login_username.getText().toString().trim();
                String passwordStr = login_password.getText().toString().trim();
                if (usernameStr.equals("") || passwordStr.equals("")) {
                    Toast.makeText(getActivity(), "用户名密码不能为空", Toast.LENGTH_SHORT).show();
                } else{
                    if (login_username.getText().toString().equals("20200504") && login_password.getText().toString().equals("20200504")) {
//                    JSONObject jsonObject = new JSONObject();
//                    try {
//                        jsonObject.put("username", usernameStr);
//                        jsonObject.put("password", passwordStr);
//                    } catch (JSONException e) {
//                        e.printStackTrace();
//                    }
//                    String url = "http://47.95.9.22:8085/user/login";//后台登录地址
//                    RequestQueue requestQueue = Volley.newRequestQueue(getActivity());
//                    JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST, url, jsonObject, new Response.Listener<JSONObject>() {
//                        @Override
//                        public void onResponse(JSONObject jsonObject) {
//                            try {
//                                Log.d("信心", jsonObject.toString());
//                                String msg = jsonObject.getString("msg");
//                                Log.d("msg", msg);
//                                if (msg.equals("登录成功")) {
                        startActivity(new Intent(getActivity(), HouTaiActivity.class));

                        Toast.makeText(getContext(), "恭喜宝贝登录成功，请不要卸载本软件，否则我们的时间轴将不复存在！！！", Toast.LENGTH_SHORT).show();
//                                    JSONObject detail = jsonObject.getJSONObject("detail");
//                                    String username = detail.getString("username");
//                                    String phone = detail.getString("phone");
//
//
//
//
//                                } else if (msg.equals("用户名或密码错误")) {
//                                    Toast.makeText(getActivity(), "用户名密码有误", Toast.LENGTH_SHORT).show();
//                                }
//
//                            } catch (JSONException e) {
//                                e.printStackTrace();
//                            }
//
//                        }
//                    }, new Response.ErrorListener() {
//                        @Override
//                        public void onErrorResponse(VolleyError volleyError) {
//                            Toast.makeText(getActivity(), "网络出错", Toast.LENGTH_SHORT).show();
//                        }
//                    });
//                    requestQueue.add(jsonObjectRequest);
//                }else {
//                    Toast.makeText(getActivity(), "请使用最高权限账户登录", Toast.LENGTH_SHORT).show();
//                }

                    }else {
                        Toast.makeText(getContext(), "小笨蛋，账号和密码都是我们的生日年月日  8位数！！！", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });

    }


    //高斯工具实现类
    public class GlideBlurformation extends BitmapTransformation {
        private Context context;
        public GlideBlurformation(Context context) {
            this.context = context;
        }
        @Override
        protected Bitmap transform(@NonNull BitmapPool pool, @NonNull Bitmap toTransform, int outWidth, int outHeight) {
            return BlurBitmapUtil.instance().blurBitmap(context, toTransform, 20,outWidth,outHeight);
        }
        @Override
        public void updateDiskCacheKey(MessageDigest messageDigest) {
        }
    }
}
