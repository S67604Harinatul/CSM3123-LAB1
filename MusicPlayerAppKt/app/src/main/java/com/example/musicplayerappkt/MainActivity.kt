package com.example.musicplayerappkt

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button

class MainActivity : AppCompatActivity() {
    private lateinit var startMusicButton: Button
    private lateinit var stopMusicButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // Initialize buttons using findViewById
        startMusicButton = findViewById(R.id.startMusicButton)
        stopMusicButton = findViewById(R.id.stopMusicButton)

        startMusicButton.setOnClickListener {
            val intent = Intent(this, MusicService::class.java)
            startService(intent) // Start the foreground service
        }
        stopMusicButton.setOnClickListener {
            val intent = Intent(this, MusicService::class.java)
            stopService(intent) // Stop the foreground service
        }
    }
}
