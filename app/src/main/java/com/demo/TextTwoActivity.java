package com.demo;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

public class TextTwoActivity extends AppCompatActivity{
    private ImageView iv_image;
    private String[] urls = {"https://ps.ssl.qhimg.com/dmfd/365_365_/t01ecacfed9b0d76f31.jpg"
            , "https://p.ssl.qhimg.com/dmfd/364_259_/t01ccdc27d55aad46a4.jpg",
            "https://ps.ssl.qhimg.com/dmfd/365_207_/t012d48f06bb5ce8487.jpg",
            "https://ps.ssl.qhimg.com/dm/364_207_/t01471c2a136510cfd0.jpg",
            "https://ps.ssl.qhimg.com/dmfd/365_365_/t01ecacfed9b0d76f31.jpg"
            , "https://p.ssl.qhimg.com/dmfd/364_259_/t01ccdc27d55aad46a4.jpg",
            "https://ps.ssl.qhimg.com/dmfd/365_207_/t012d48f06bb5ce8487.jpg",
            "https://ps.ssl.qhimg.com/dm/364_207_/t01471c2a136510cfd0.jpg"};

    private Handler mHandler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_two);


        iv_image = findViewById(R.id.iv_image);


    }


    public void btnClick(View view) {
        for (int i = 0, len = urls.length; i < len; i++) {
            Intent intent = new Intent(this, MyService.class);
            intent.putExtra("urlpath", urls[i]);
            intent.putExtra("times", i);
            startService(intent);
        }
        finish();
    }
}
