package com.example.custombroadcastreceiverapp;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;

public class MainActivity extends AppCompatActivity {
    private MyCustomBroadcastReceiver myReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Instantiate the custom broadcast receiver
        myReceiver = new MyCustomBroadcastReceiver();

        // Set up the button to send a custom broadcast
        Button sendBroadcastButton = findViewById(R.id.sendBroadcastButton);
        sendBroadcastButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create an intent with a custom action
                Intent intent = new Intent("com.example.CUSTOM_ACTION");
                // Send the broadcast
                LocalBroadcastManager.getInstance(MainActivity.this).sendBroadcast(intent);
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        // Register the receiver for the custom broadcast
        LocalBroadcastManager.getInstance(this)
                .registerReceiver(myReceiver, new IntentFilter("com.example.CUSTOM_ACTION"));
    }

    @Override
    protected void onStop() {
        super.onStop();
        // Unregister the receiver to avoid memory leaks
        LocalBroadcastManager.getInstance(this).unregisterReceiver(myReceiver);
    }
}
