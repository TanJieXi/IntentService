package com.demo;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by 谭杰栖 on 2018/2/27.
 */

public class HttpHelperNoHandler {

    private static BufferedInputStream sBis;
    private static ByteArrayOutputStream sBaos;
    private HttpHelperNoHandler mHttpHelper;

    private HttpHelperNoHandler() {

    }

    public static void downLoadData(final String path, final CallBackListener callBackListener) {
        try {
            URL url = new URL(path);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setConnectTimeout(5000);
            connection.setDoInput(true);
            connection.setDoOutput(true);
            connection.connect();
            if (connection.getResponseCode() == 200) {
                sBis = new BufferedInputStream(connection.getInputStream());
                sBaos = new ByteArrayOutputStream();

                int len = 0;
                byte[] buf = new byte[1024];
                while ((len = sBis.read(buf)) != -1) {
                    sBaos.write(buf, 0, len);
                }
                sBaos.flush();

                byte[] bytes = sBaos.toByteArray();
                final Bitmap bitmap = BitmapFactory.decodeByteArray(bytes, 0, bytes.length);
                callBackListener.onFetch(bitmap);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                sBis.close();
                sBaos.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }


    public interface CallBackListener {
        void onFetch(Bitmap bitmap);
    }


}
