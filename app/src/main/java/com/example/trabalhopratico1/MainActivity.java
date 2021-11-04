package com.example.trabalhopratico1;

import androidx.appcompat.app.AppCompatActivity;

import java.io.InputStream;

import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.os.Bundle;
import android.app.ProgressDialog;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.ImageView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.androidgamesdk.gametextinput.Listener;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    private  FloatingActionButton btnDown;
    private EditText edtUrl;
    private ImageView imgDow;
    private DownloadTask task;

    String param0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnDown = findViewById(R.id.btnDown);
        edtUrl = findViewById(R.id.edtUrl);
        imgDow = findViewById(R.id.imgDow);

        btnDown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                param0 = edtUrl.getText().toString();

                if(param0.length() != 0){
                    task = new DownloadTask();
                    task.setListener(createListener());
                    task.execute(param0);

                }
            }
        });
    }
    @Override
    protected void onDestroy() {
        task.setListener(null);
        super.onDestroy();
    }

    private DownloadTask.Listener createListener() {
        return new DownloadTask.Listener() {
            @Override
            public void onSuccess(Bitmap bmp) {
                imgDow.setImageBitmap(bmp);
            }
        };
    }

    @Override
    public void onClick(View view) {

    }
}


