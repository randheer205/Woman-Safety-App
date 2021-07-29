package com.example.newapp;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Build;
import android.provider.Settings;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MenuItem;
import android.view.View;
import android.os.Bundle;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView;

import java.util.logging.LogManager;


public class MainActivity2 extends AppCompatActivity {
    String person1_pn,person2_pn,person3_pn,first_nm,last_nm,person1_nm,person2_nm,person3_nm;
    String TAG="THIS IS LOG TAG";
    private GestureDetector GD;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Fragment selectedFragment = new call();
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                selectedFragment).commit();
        BottomNavigationView bottomNavigationView=findViewById(R.id.bnv);
        bottomNavigationView.setOnNavigationItemSelectedListener(nav_listener);
    }

    public String[] persondetails()
    {
        String pd[]=new String[8];
        SharedPreferences sharedPreferences=getSharedPreferences("person_details", MODE_PRIVATE);
        first_nm=sharedPreferences.getString("first_name","First Name");
        last_nm=sharedPreferences.getString("last_name","Last Name");
        person1_pn=sharedPreferences.getString("person1_phone","9999999999");
        person2_pn=sharedPreferences.getString("person2_phone","9999999999");
        person3_pn=sharedPreferences.getString("person3_phone","9999999999");
        person1_nm=sharedPreferences.getString("person1_name","IMP-Person 1");
        person2_nm=sharedPreferences.getString("person2_name","IMP-Person 2");
        person3_nm=sharedPreferences.getString("person3_name","IMP-Person 3");
        System.out.println("\nTHIS IS IN MAINACTIVITY 2 :\n");
        System.out.println("First Name : "+sharedPreferences.getString("first_name","Name2"));
        System.out.println("Last Name : "+sharedPreferences.getString("last_name","Name2"));
        System.out.println("person1_phone: "+sharedPreferences.getString("person1_phone","Name2"));
        System.out.println("person2_phone: "+sharedPreferences.getString("person2_phone","Name2"));
        System.out.println("person3_phone: "+sharedPreferences.getString("person3_phone","Name2"));
        pd[0]=first_nm;
        pd[1]=last_nm;
        pd[2]=person1_pn;
        pd[3]=person2_pn;
        pd[4]=person3_pn;
        pd[5]=person1_nm;
        pd[6]=person2_nm;
        pd[7]=person3_nm;
        return pd;
    }

    public void playsound() {
        final MediaPlayer mp=MediaPlayer.create(this,R.raw.sos);
        mp.start();
    }

    private BottomNavigationView.OnNavigationItemSelectedListener nav_listener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    Fragment selectedFragment = new call();
                    switch (item.getItemId()) {
                        case R.id.call:
                            selectedFragment = new call();
                            break;
                        case R.id.maps:
                            selectedFragment=new maps();
                            /*Intent intent4=new Intent(MainActivity2.this,MainActivity4.class);
                            startActivity(intent4);*/
                            break;
                        case R.id.tips:
                            selectedFragment = new tips();
                            break;
                        case R.id.laws:
                            selectedFragment = new laws();
                            break;
                        case R.id.profile:
                            selectedFragment = new home();
                            break;
                    }
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                            selectedFragment).commit();
                    return true;
                }
            };

    public void  onBackPressed()
    {
        finish();
        Log.i("LOG_TAG","THIS IS BACKPRESS");
        System.exit(1);
        ActivityCompat.finishAffinity(MainActivity2.this);
    }

}