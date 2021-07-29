package com.example.newapp;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity3 extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        Button save=(Button)findViewById(R.id.save_button);
        final SharedPreferences shpr=getSharedPreferences("person_details",MODE_PRIVATE);
        final SharedPreferences.Editor saver=shpr.edit();

        String ofnm,olnm,op1phone,op2phone,op3phone,op1name,op2name,op3name;
        TextView fnmtv=(TextView)findViewById(R.id.edit_fnm);
        TextView lnmtv=(TextView)findViewById(R.id.edit_lnm);
        TextView p3tv=(TextView)findViewById(R.id.edit_phone_3);
        TextView p1tv=(TextView)findViewById(R.id.edit_phone_1);
        TextView p2tv=(TextView)findViewById(R.id.edit_phone_2);
        TextView p1nm=(TextView)findViewById(R.id.person1_name);
        TextView p2nm=(TextView)findViewById(R.id.person2_name);
        TextView p3nm=(TextView)findViewById(R.id.person3_name);

        ofnm=shpr.getString("first_name","FIRST NAME");
        olnm=shpr.getString("last_name","LAST NAME");
        op1phone=shpr.getString("person1_phone","999");
        op2phone=shpr.getString("person2_phone","999");
        op3phone=shpr.getString("person3_phone","999");
        op1name=shpr.getString("person1_name","P1 NAME");
        op2name=shpr.getString("person2_name","P2 NAME");
        op3name=shpr.getString("person3_name","P3 NAME");

        fnmtv.setText(ofnm);
        lnmtv.setText(olnm);
        p1tv.setText(op1phone);
        p2tv.setText(op2phone);
        p3tv.setText(op3phone);
        p1nm.setText(op1name);
        p2nm.setText(op2name);
        p3nm.setText(op3name);


            save.setOnClickListener(
                    new View.OnClickListener()
                    {

                        public void onClick(View arg)
                        {
                            String fnm,lnm,p1phone,p2phone,p3phone,p1name,p2name,p3name;
                            TextView fnmtv=(TextView)findViewById(R.id.edit_fnm);
                            TextView lnmtv=(TextView)findViewById(R.id.edit_lnm);
                            TextView p3tv=(TextView)findViewById(R.id.edit_phone_3);
                            TextView p1tv=(TextView)findViewById(R.id.edit_phone_1);
                            TextView p2tv=(TextView)findViewById(R.id.edit_phone_2);
                            TextView p1nm=(TextView)findViewById(R.id.person1_name);
                            TextView p2nm=(TextView)findViewById(R.id.person2_name);
                            TextView p3nm=(TextView)findViewById(R.id.person3_name);
                            fnm= fnmtv.getText().toString();
                            lnm= lnmtv.getText().toString();
                            p1phone=p1tv.getText().toString();
                            p2phone=p2tv.getText().toString();
                            p3phone=p3tv.getText().toString();
                            p1name=p1nm.getText().toString();
                            p2name=p2nm.getText().toString();
                            p3name=p3nm.getText().toString();
                            saver.putString("first_name",fnm);
                            saver.putString("last_name",lnm);
                            saver.putString("person1_phone",p1phone);
                            saver.putString("person2_phone",p2phone);
                            saver.putString("person3_phone",p3phone);
                            saver.putString("person1_name",p1name);
                            saver.putString("person2_name",p2name);
                            saver.putString("person3_name",p3name);
                            saver.commit();
                            System.out.println("First Name : "+shpr.getString("first_name","Name2"));
                            System.out.println("Last Name : "+shpr.getString("last_name","Name2"));
                            System.out.println("person1_phone: "+shpr.getString("person1_phone","Name2"));
                            System.out.println("person2_phone: "+shpr.getString("person2_phone","Name2"));
                            System.out.println("person3_phone: "+shpr.getString("person3_phone","Name2"));
                            Intent intent=new Intent(MainActivity3.this,MainActivity2.class);
                            startActivity(intent);
                        }
                    }
            );
     //   }

    }

    @Override
    public void onBackPressed() {
        Intent intent=new Intent(MainActivity3.this,MainActivity2.class);
        startActivity(intent);
    }
}