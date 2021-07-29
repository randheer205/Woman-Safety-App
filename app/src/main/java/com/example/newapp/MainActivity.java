package com.example.newapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.view.WindowManager;
import android.widget.Button;
import android.view.View;
import android.content.Intent;

import android.os.Bundle;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    public Button button;
    ProgressBar progressBar;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        progressBar=findViewById(R.id.loadpb);
        textView=findViewById(R.id.load_text);
        progressBar.setMax(100);
        progressBar.setScaleY(3f);

        progressAnimation();

    }

    private void progressAnimation() {
        load_animation la=new load_animation(this,progressBar,textView,0f,100f);
        la.setDuration(5000);
        progressBar.setAnimation(la);
    }

}