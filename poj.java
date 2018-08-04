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
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    private Location mLocation;
    private double latitude, longitude, speed;
    private double old_latitude, old_longitude;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void sms(View view) {
        SmsManager smsManager = SmsManager.getDefault();
        String msg = getPosition();
        msg += ", Time = ";
        msg += getTime();
        smsManager.sendTextMessage("7025266580", null, msg, null, null);
        Toast.makeText(this, "Message Sent", Toast.LENGTH_SHORT).show();
    }

    public void getGPS(View view) {
        getPosition();
    }

    private String getPosition() {
        LocationManager manager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        if (checkSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            return null ;
        }
        if (mLocation != null){
            old_latitude = latitude;
            old_longitude = longitude;
        }
        mLocation = manager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
        latitude = mLocation.getLatitude();
        longitude = mLocation.getLongitude();
        speed = mLocation.getSpeed();
        String lat = "Latitude = ";
        lat += String.valueOf(latitude);
        lat += ", Longitude = ";
        lat += String.valueOf(longitude);
        Log.v("MainActivity", lat);
        return lat;
    }

    private String getTime() {
        Date date = Calendar.getInstance().getTime();
        SimpleDateFormat format = new SimpleDateFormat("hh:mm aaa");
        String timeText = format.format(date);
        return timeText;
    }

    private double getDistance2(){
               Location exlocation = new Location();
        exlocation.setLatitude(latitude);
        exlocation.setLongitude(longitude);

        Location newlocation = new Location();
        newlocation.setLatitude(new_latitude);
        newlocation.setLongitude(new_longitude);

        double distace = newlocation.distaceTo(newlocation);
        return distace;
    }

    private double getDistance(){

        double distance = Location.distanceBetween(latitude, longitude, new_latitude, new_longitude);
        return distance;
    }
    
    private void onLocationChange(){
        if (getDistance() >= 100){
            
        }
    }








