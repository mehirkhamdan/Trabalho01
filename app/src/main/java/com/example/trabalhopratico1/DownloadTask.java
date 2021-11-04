package com.example.trabalhopratico1;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Log;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class DownloadTask extends AsyncTask<String, Void, Bitmap> {

    private Listener listener;

    @Override
    protected Bitmap doInBackground(String... params) {

        return downloadImage(params[0]) ;
    }

    @Override
    protected void onProgressUpdate(Void... progress) {

    }

    @Override
    protected void onPostExecute(Bitmap bmp) {
        if (listener != null) {
            listener.onSuccess(bmp);
        }
    }

    private Bitmap downloadImage(String address) {
        Bitmap bmp = null;

        HttpURLConnection urlConnection = null;

        try {
            URL url = new URL( address );

            urlConnection = (HttpURLConnection) url.openConnection();

            urlConnection.connect();
            int resp = urlConnection.getResponseCode();
            switch (resp){
                case HttpURLConnection.HTTP_OK:
                    try(InputStream is = urlConnection.getInputStream()){
                        bmp = BitmapFactory.decodeStream(is);

                    } catch(IOException e){
                        e.printStackTrace();
                    }
                    break;
                case HttpURLConnection.HTTP_UNAUTHORIZED:

                default:
                    break;
            }
        } catch (Exception e) {
            Log.d("debug", "downloadImage error");
            e.printStackTrace();
        } finally {
            if (urlConnection != null) {
                urlConnection.disconnect();
            }
        }
        return bmp;
    }

    void setListener(Listener listener) {
        this.listener = listener;
    }

    interface Listener {
        void onSuccess(Bitmap bmp);
    }
}

