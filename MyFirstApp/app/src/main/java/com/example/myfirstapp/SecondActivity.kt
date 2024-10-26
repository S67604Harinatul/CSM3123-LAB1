package com.example.myfirstapp

import android.widget.TextView
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_second)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets

        }
        val message = intent.getStringExtra("EXTRA_MESSAGE")
        val textView: TextView = findViewById(R.id.textViewSecond)
        textView.text = message

        val buttonBack: Button = findViewById(R.id.buttonBack) // Ensure you have this ID in your XML
        buttonBack.setOnClickListener { finish() }
    }
}