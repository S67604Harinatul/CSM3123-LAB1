package com.example.myfirstapp

import android.os.Bundle
import android.widget.Toast
import android.widget.Button
import android.widget.TextView
import android.graphics.Color
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button: Button = findViewById(R.id.button)
        val textView: TextView = findViewById(R.id.textView)


        button.setOnClickListener {
            textView.text = "Button Clicked!"
            textView.setTextColor(Color.RED)

            val intent = Intent(this, SecondActivity::class.java)
            intent.putExtra("EXTRA_MESSAGE", "Hello from MainActivity!");
            startActivity(intent)

            Toast.makeText(this, "Button was clicked!",
                Toast.LENGTH_SHORT).show();
        }
    }
}