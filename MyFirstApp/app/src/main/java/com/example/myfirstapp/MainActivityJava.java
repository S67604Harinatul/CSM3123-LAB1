package com.example.myfirstapp;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivityJava extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView textView = findViewById(R.id.textView);
        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setText("Button Clicked!");
                textView.setTextColor(Color.RED);

                Toast.makeText(MainActivityJava.this, "Button was clicked!",
                        Toast.LENGTH_SHORT).show();
            }
        });
        Intent intent = new Intent(MainActivityJava.this, SecondActivity.class);
        intent.putExtra("EXTRA_MESSAGE", "Hello from MainActivity!");
        startActivity(intent);


    }

}