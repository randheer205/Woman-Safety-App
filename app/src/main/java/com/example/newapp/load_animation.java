package com.example.newapp;

import android.content.Context;
import android.content.Intent;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.ProgressBar;
import android.widget.TextView;

import org.w3c.dom.Text;

public class load_animation extends Animation {
    private Context context;
    private ProgressBar pb;
    private TextView tv;
    private float from,to ;

    public load_animation(Context context , ProgressBar progressBar, TextView textView, float from, float to)
    {
        this.context=context;
        this.pb=progressBar;
        this.tv=textView;
        this.from=from;
        this.to=to;
    }

    protected void applyTransformation(float interpolatedTime, Transformation t)
    {
        super.applyTransformation(interpolatedTime, t);
        float value=from +(to-from)*interpolatedTime;
        pb.setProgress((int)value);
        tv.setText((int)value+"%");

        if(value==to)
        {
            context.startActivity(new Intent(context,MainActivity2.class));
            value=0;
        }
    }

}
