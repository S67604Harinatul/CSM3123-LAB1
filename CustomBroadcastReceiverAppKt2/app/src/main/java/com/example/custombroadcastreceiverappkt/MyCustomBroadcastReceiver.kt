package com.example.custombroadcastreceiverappkt
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log
import android.widget.Toast
class MyCustomBroadcastReceiver : BroadcastReceiver() {
    private val TAG = "MyBroadcastReceiver"
    override fun onReceive(context: Context, intent: Intent) {
        // Check if the action matches the expected custom action
        if (intent.action == "com.example.CUSTOM_ACTION") {
            Log.d(TAG, "Custom Broadcast Received!")
            Toast.makeText(context, "Custom Broadcast Received!",
                Toast.LENGTH_SHORT).show()
        }
    }
}