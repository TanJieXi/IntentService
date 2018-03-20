package com.demo;

import android.graphics.Bitmap;

/**
 * Created by 谭杰栖 on 2018/2/27.
 */

public class BitMapBean {
    private Bitmap mBitmap;
    private String path;

    public BitMapBean(Bitmap bitmap, String path) {
        mBitmap = bitmap;
        this.path = path;
    }

    public Bitmap getBitmap() {
        return mBitmap;
    }

    public void setBitmap(Bitmap bitmap) {
        mBitmap = bitmap;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
