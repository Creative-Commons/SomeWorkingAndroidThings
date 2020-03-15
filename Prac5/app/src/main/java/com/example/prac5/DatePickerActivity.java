package com.example.prac5;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;

public class DatePickerActivity extends AppCompatActivity {

    Button submit;
    DatePicker dp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date_picker);

        submit = findViewById(R.id.submitD);
        dp = findViewById(R.id.dp);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String date = dp.getDayOfMonth() + "/" + dp.getMonth() + "/" + dp.getYear();
                final AlertDialog alertDialog = new AlertDialog.Builder(getApplicationContext()).create();
                alertDialog.setMessage("Date: " + date);;
                alertDialog.setButton(DialogInterface.BUTTON_POSITIVE, "OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        alertDialog.dismiss();
                    }
                });
                alertDialog.show();
            }
        });
    }
}
