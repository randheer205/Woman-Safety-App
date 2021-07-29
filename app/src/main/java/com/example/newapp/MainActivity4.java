package com.example.newapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.os.Bundle;
import android.telephony.SmsManager;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

public class MainActivity4 extends AppCompatActivity {

    Button btlocation;
    TextView textView1, textView2, textView3, textView4, textView5;
    FusedLocationProviderClient fusedLocationProviderClient;
    Geocoder geocoder= null;
    List<Address> addresses;
    EditText editTextNumber;
    String perpn[]=new String[8];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
            //Assig var
        btlocation = findViewById(R.id.bt_location);
        textView1 = findViewById(R.id.text_view1);
        textView2 = findViewById(R.id.text_view2);
        textView3 = findViewById(R.id.text_view3);
        textView4 = findViewById(R.id.text_view4);
        textView5 = findViewById(R.id.text_view5);
        //editTextNumber = findViewById(R.id.editTextNumber);

        //Initilize fusedLocationProviderClient
        fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this);

        btlocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // CHeck Permission
                ActivityCompat.requestPermissions(MainActivity4.this, new String[] {Manifest.permission.SEND_SMS}, PackageManager.PERMISSION_GRANTED);
                ActivityCompat.requestPermissions(MainActivity4.this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, PackageManager.PERMISSION_GRANTED);
                getLocation();

            }
        });
        }

    private void getLocation() {

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        fusedLocationProviderClient.getLastLocation().addOnCompleteListener(new OnCompleteListener<Location>() {
            @Override
            public void onComplete(@NonNull Task<Location> task) {
                // Inilitilize location
                Location location = task.getResult();
                if (location != null) {
                    try {
                        //Initilize geocoder
                        geocoder = new Geocoder(MainActivity4.this, Locale.getDefault());
                        // INitilize address list
                        addresses = geocoder.getFromLocation(
                                location.getLatitude(), location.getLongitude(), 1
                        );
                        // set latitude on textview
                        textView1.setText(Html.fromHtml(
                                "<font color = '#6200EE'><b>Latitude : </b><br></font>"
                                        + addresses.get(0).getLatitude()
                        ));
                        // set longitude on textview
                        textView2.setText(Html.fromHtml(
                                "<font color = '#6200EE'><b>Longitude : </b><br></font>"
                                        + addresses.get(0).getLongitude()
                        ));
                        // set country on textview
                        textView3.setText(Html.fromHtml(
                                "<font color = '#6200EE'><b>Country : </b><br></font>"
                                        + addresses.get(0).getCountryName()
                        ));
                        // set locality on textview
                        textView4.setText(Html.fromHtml(
                                "<font color = '#6200EE'><b>Locality : </b><br></font>"
                                        + addresses.get(0).getLocality()
                        ));
                        // set address on textview
                        textView5.setText(Html.fromHtml(
                                "<font color = '#6200EE'><b>Address : </b><br></font>"
                                        + addresses.get(0).getAddressLine(0)
                        ));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

    }
    public void sendLocation(View view) {
        List<Address> s = addresses;
        String address = addresses.get(0).getAddressLine(0);
        String city = addresses.get(0).getLocality();
        String state = addresses.get(0).getAdminArea();
        String country = addresses.get(0).getCountryName();
        String postalcode = addresses.get(0).getPostalCode();
        String knonName = addresses.get(0).getFeatureName();

        String myCurrentLocation ="Help me I am in danger. My Location:\n"+ address+"\n" + city +"\n" +state+"\n" + country+"\n"+ postalcode +"\n"+ knonName;


        SharedPreferences sharedPreferences=getSharedPreferences("person_details", MODE_PRIVATE);
        String number1 =sharedPreferences.getString("person1_phone","9999999999");
        String number2 = sharedPreferences.getString("person2_phone","9999999999");
        String number3 = sharedPreferences.getString("person3_phone","9999999999");
        SmsManager smsManager = SmsManager.getDefault();
        smsManager.sendTextMessage(number1, null, myCurrentLocation, null, null);
        smsManager.sendTextMessage(number2, null, myCurrentLocation, null, null);
        smsManager.sendTextMessage(number3, null, myCurrentLocation, null, null);


    }
    @Override
    public void onBackPressed() {
        Intent intent=new Intent(MainActivity4.this,MainActivity2.class);
        startActivity(intent);
    }
}