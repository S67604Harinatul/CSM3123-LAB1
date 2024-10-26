package com.example.custombroadcastreceiverapp;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

public class MyCustomBroadcastReceiver extends BroadcastReceiver {
    private static final String TAG = "MyBroadcastReceiver";

    @Override
    public void onReceive(Context context, Intent intent) {
        // Check if the action matches the expected custom action
        if ("com.example.CUSTOM_ACTION".equals(intent.getAction())) {
            Log.d(TAG, "Custom Broadcast Received!");
            Toast.makeText(context, "Custom Broadcast Received!", Toast.LENGTH_SHORT).show();
        }
    }
}

