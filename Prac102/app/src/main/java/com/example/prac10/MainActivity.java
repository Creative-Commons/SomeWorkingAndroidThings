package com.example.prac10;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText name, password;
    Button insert, update, delete, showData;
    DBHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db = new DBHelper(getApplicationContext());

        name = findViewById(R.id.name);
        password = findViewById(R.id.password);

        insert = findViewById(R.id.insert);
        update = findViewById(R.id.update);
        delete = findViewById(R.id.delete);
        showData = findViewById(R.id.showData);

        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean isInserted = db.insertData(name.getText().toString(), password.getText().toString());
                if(isInserted){
                    Toast.makeText(getApplicationContext(), "Inserted", Toast.LENGTH_SHORT).show();
                } else{
                    Toast.makeText(getApplicationContext(), "Insert Failed", Toast.LENGTH_SHORT).show();
                }
            }
        });

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean isUpdated= db.updateData(name.getText().toString(), password.getText().toString());
                if(isUpdated){
                    Toast.makeText(getApplicationContext(), "Updated", Toast.LENGTH_SHORT).show();
                } else{
                    Toast.makeText(getApplicationContext(), "Update Failed", Toast.LENGTH_SHORT).show();
                }
            }
        });

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean isDeleted = db.deleteData(name.getText().toString(), password.getText().toString());
                if(isDeleted){
                    Toast.makeText(getApplicationContext(), "Deleted", Toast.LENGTH_SHORT).show();
                } else{
                    Toast.makeText(getApplicationContext(), "Deletion Failed", Toast.LENGTH_SHORT).show();
                }
            }
        });

        showData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cursor res  = db.showData();
                if(res.getCount() == 0){
                    Toast.makeText(getApplicationContext(), "No Data", Toast.LENGTH_SHORT).show();
                } else{
                    StringBuffer stringBuffer = new StringBuffer();
                    while(res.moveToNext()){
                        stringBuffer.append("Name: " + res.getString(0));
                        stringBuffer.append("Password: " + res.getString(1) + "\n");
                    }
//                    final AlertDialog.Builder alertDialog = new AlertDialog.Builder(getApplicationContext());
//                    alertDialog.setTitle("Employees")
//                            .setMessage(stringBuffer)
//                            .setPositiveButton("OK", new DialogInterface.OnClickListener() {
//                                @Override
//                                public void onClick(DialogInterface dialogInterface, int i) {
//
//                                }
//                            })
//                            .setCancelable(true);
                    Toast.makeText(getApplicationContext(), stringBuffer, Toast.LENGTH_SHORT).show();
                    //alertDialog.show();
                }
            }
        });
    }
}
