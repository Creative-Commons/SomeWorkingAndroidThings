package com.example.prac5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button keyboard, alerts, pickers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        keyboard = findViewById(R.id.keyboard);
        alerts = findViewById(R.id.alerts);
        pickers = findViewById(R.id.pickers);

        keyboard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), KeyboardActivity.class);
                startActivity(i);
            }
        });

        alerts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), AlertActivity.class);
                startActivity(i);
            }
        });

        pickers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), PickerActivity.class);
                startActivity(i);
            }
        });
    }
}
