package com.example.deathblade.saveme_sender;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationManager;
import android.support.v4.app.LoaderManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    void sms(View view) {
        SmsManager smsManager = SmsManager.getDefault();
        String msg = getPosition();
        smsManager.sendTextMessage("7025266580", null, msg, null, null);

    }


    public void getGPS(View view) {
        getPosition();
    }

    private String getPosition() {
        LocationManager manager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        if (checkSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            return;
        }
        Location location = manager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
        String lat = "Latitude = ";
        lat += String.valueOf(location.getLatitude());
        lat += ", Longitude = ";
        lat += String.valueOf(location.getLongitude());
        Log.v("MainActivity", lat);
        return lat;
    }












































































}