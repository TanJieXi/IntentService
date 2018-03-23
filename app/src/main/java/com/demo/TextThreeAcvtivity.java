package com.demo;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.lang.ref.WeakReference;

public class TextThreeAcvtivity extends AppCompatActivity implements MyService.OnCallBack {
    private ImageView iv_image;
    private MyHander mHandler;
    private BitMapBean mBitMapBean;
    private TextView tv_text;


    @Override
    protected void onRestart() {
        super.onRestart();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_three_acvtivity);
        iv_image = findViewById(R.id.iv_image);
        tv_text = findViewById(R.id.tv_text);
        mHandler = new MyHander(this,iv_image,tv_text,this);
        MyService.setOnCallBack(this);
    }

    public void btnClick(View view) {
        Intent intent = new Intent(this,TextTwoActivity.class);
        startActivity(intent);
    }

    @Override
    public void onFetch(Bitmap bitmap, int times,String paths) {
        Message message = new Message();
        mBitMapBean = new BitMapBean(bitmap,paths);
        message.obj = mBitMapBean;
        mHandler.sendMessageDelayed(message,times * 1000);
    }

    private static class MyHander extends Handler{
       /* private WeakReference<Activity> mActivityWeakReference;
        private WeakReference<ImageView> mImageViewWeakReference;
        private WeakReference<TextView> mTextViewWeakReference;*/
        private WeakReference<Context> cc;
        public MyHander(Activity ac, ImageView iv, TextView tv, Context context) {
            cc = new WeakReference<Context>(context);
           /* mActivityWeakReference = new WeakReference<Activity>(ac);
            mImageViewWeakReference = new WeakReference<ImageView>(iv);
            mTextViewWeakReference = new WeakReference<TextView>(tv);*/
        }

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            TextThreeAcvtivity context = (TextThreeAcvtivity) cc.get();
          /* TextThreeAcvtivity activity = (TextThreeAcvtivity) mActivityWeakReference.get();
            mImageViewWeakReference.get().setImageBitmap(((BitMapBean) msg.obj).getBitmap());
            mTextViewWeakReference.get().setText(((BitMapBean) msg.obj).getPath().concat("----》下载成功"));*/

            context.iv_image.setImageBitmap(((BitMapBean) msg.obj).getBitmap());
            context.tv_text.setText(((BitMapBean) msg.obj).getPath().concat("----》下载成功"));
        }
    }


}
