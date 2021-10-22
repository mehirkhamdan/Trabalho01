package com.example.trabalhopratico1;

import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class DownloadTask extends AsyncTask<Bitmap, String, Void> {

    private FloatingActionButton btnDown;
    private TextView edtUrl;
    private ImageView imgDow;

    public DownloadTask(FloatingActionButton btnDown, TextView edtUrl, ImageView imgDow){

        this.btnDown = btnDown;
        this.edtUrl = edtUrl;
        this.imgDow = imgDow;
    }

    @Override
    protected void onPreExecute(){

        btnDown.setEnabled(false);
        edtUrl.setVisibility(View.VISIBLE);
        imgDow.setVisibility(View.INVISIBLE);
    }


    @Override
    protected Void doInBackground(Bitmap... bitmaps) {
        return null;
    }

    protected void OnProgressUpdate(String... values){


    }

    protected void onPostExecute(Void aVoid){

        btnDown.setEnabled(true);
        edtUrl.setVisibility(View.VISIBLE);
        imgDow.setVisibility(View.VISIBLE);
    }
}
