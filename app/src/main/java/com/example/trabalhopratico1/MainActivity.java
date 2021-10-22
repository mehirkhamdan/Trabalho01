package com.example.trabalhopratico1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private FloatingActionButton btnDown;
    private TextView edtUrl;
    private ImageView imgDow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnDown = findViewById(R.id.btnDown);
        edtUrl = findViewById(R.id.edtUrl);
        imgDow = findViewById(R.id.imgDow);

        btnDown.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        DownloadTask download = new DownloadTask(btnDown, edtUrl, imgDow);
        download.execute();

    }
}