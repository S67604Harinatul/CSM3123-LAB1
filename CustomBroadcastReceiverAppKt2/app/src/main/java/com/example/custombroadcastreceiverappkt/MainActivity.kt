package com.example.custombroadcastreceiverappkt

import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import android.widget.Button
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.localbroadcastmanager.content.LocalBroadcastManager

public class MainActivity : AppCompatActivity() {

private lateinit var myReceiver: MyCustomBroadcastReceiver

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        //myReceiver = MyCustomBroadcastReceiver()

        val sendBroadcastButton: Button = findViewById(R.id.sendBroadcastButton)

        sendBroadcastButton.setOnClickListener {
            // Create an intent with the custom action
            val intent = Intent("com.example.CUSTOM_ACTION")
            // Send the broadcast
            LocalBroadcastManager.getInstance(this).sendBroadcast(intent)
        }
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top,systemBars.right, systemBars.bottom)
            insets
        }
    }

    override fun onStart() {
        super.onStart()
        // Register the receiver with the intent filter
        LocalBroadcastManager.getInstance(this)
            .registerReceiver(myReceiver,
                IntentFilter("com.example.CUSTOM_ACTION"))
    }
    override fun onStop() {
        super.onStop() // Unregister the receiver to prevent memory leaks

        LocalBroadcastManager.getInstance(this).unregisterReceiver(myReceiver)
    }
}

