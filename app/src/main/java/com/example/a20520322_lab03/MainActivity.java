package com.example.a20520322_lab03;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Database database;
    EditText edtFullName;
    EditText edtPhone;
    Button btnAddLocal;
    Button btnQueryLocal;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtFullName = (EditText) findViewById(R.id.editTextFullName);
        edtPhone = (EditText) findViewById(R.id.editTextPhone);
        btnAddLocal = (Button) findViewById(R.id.buttonAddLocal);
        btnQueryLocal = (Button) findViewById(R.id.buttonQueryLocal);

        btnAddLocal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String fullname = edtFullName.getText().toString();
                String phone = edtPhone.getText().toString();
                if(fullname.equals("") || phone.equals(""))
                    Toast.makeText(MainActivity.this, "Please enter all the information", Toast.LENGTH_SHORT).show();
                else{
                    database.QueryData("INSERT INTO Personal VALUES (null, '"+fullname+"', '"+phone+"')");
                    Toast.makeText(MainActivity.this, "successfully added", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnQueryLocal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent listPersonal = new Intent(MainActivity.this, ListPersonalLocal.class);
                startActivity(listPersonal);
            }
        });
    }
}