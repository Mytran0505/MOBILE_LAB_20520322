package com.example.a20520322_lab04_mobile;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Login extends AppCompatActivity {
    DatabaseReference firebasedb = FirebaseDatabase.getInstance().getReferenceFromUrl("https://lab04mobile-default-rtdb.firebaseio.com/");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        final EditText username = findViewById(R.id.edtUsername);
        final EditText password = findViewById(R.id.editPassword);
        final Button login = findViewById(R.id.btnLogin);
        final TextView signin = findViewById(R.id.tvSignUp);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String usernametxt = username.getText().toString();

                String passwordtxt = null;
                try {
                    passwordtxt = Security.encrypt(password.getText().toString());
                } catch (Exception e) {
                    e.printStackTrace();
                }
                if(usernametxt.isEmpty()|| passwordtxt.isEmpty()){
                    Toast.makeText(Login.this, "please enter your username or password", Toast.LENGTH_SHORT).show();
                }
                else {
                    String finalPasswordtxt = passwordtxt;
                    firebasedb.child("users").addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            if(snapshot.hasChild(usernametxt)){
                                final String getPassword = snapshot.child(usernametxt).child("password").getValue(String.class);
                                if(getPassword.equals(finalPasswordtxt)){
                                    Toast.makeText(Login.this, "Successfully Logged in", Toast.LENGTH_SHORT).show();
                                    startActivity(new Intent(Login.this, MainActivity.class));
                                    finish();
                                }
                                else {
                                    Toast.makeText(Login.this, "Username or Password is incorrect", Toast.LENGTH_SHORT).show();
                                }
                            }
                            else {
                                Toast.makeText(Login.this, "Username or Password is incorrect", Toast.LENGTH_SHORT).show();
                            }
                        }
                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {
                        }
                    });

                }

            }
        });

        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Login.this, SignUp.class));
            }
        });
    }
}