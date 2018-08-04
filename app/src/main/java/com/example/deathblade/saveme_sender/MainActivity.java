package com.example.deathblade.saveme_sender;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    void sms(View view){
        SmsManager smsManager;
        smsManager.sendTextMessage("7025266580");
    }



}
