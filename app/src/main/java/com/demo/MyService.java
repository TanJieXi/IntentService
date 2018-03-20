package com.demo;

import android.app.IntentService;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created by 谭杰栖 on 2018/2/27.
 */

public class MyService extends IntentService {
    private static OnCallBack mOnCallBack;
    public MyService() {
        super("MyService");
    }

    @Override
    protected void onHandleIntent(@Nullable final Intent intent) {
        if(intent == null){
            return;
        }
        final String path = intent.getStringExtra("urlpath");
        final int times = intent.getIntExtra("times",0);
        Log.i("textsidksla","---->onHandleIntent--->");

        HttpHelper.getInstance().downLoadData(path, new HttpHelper.CallBackListener() {
            @Override
            public void onFetch(byte[] bytes) {
                mOnCallBack.onFetch(BitmapFactory.decodeByteArray(bytes, 0, bytes.length),times,path);
            }
        });


    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.i("textsidksla","---->onCreate--->");
    }

    @Override
    public int onStartCommand(@Nullable Intent intent, int flags, int startId) {
        Log.i("textsidksla","---->onStartCommand--->");
        return super.onStartCommand(intent, flags, startId);
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i("textsidksla","---->onDestroy--->");
    }

    interface OnCallBack{
        void onFetch(Bitmap bitmap,int times,String path);
    }

    public static void setOnCallBack(OnCallBack onCallBack){
        mOnCallBack = onCallBack;
    }
}
