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


public class SignUp extends AppCompatActivity {
    DatabaseReference firebasedb = FirebaseDatabase.getInstance().getReferenceFromUrl("https://lab04mobile-default-rtdb.firebaseio.com/");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        final EditText fullname = findViewById(R.id.edtFullName);
        final EditText phone = findViewById(R.id.edtPhone);
        final EditText username = findViewById(R.id.edtUsername);
        final EditText password = findViewById(R.id.edtPassword);
        final Button signup = findViewById(R.id.btnSignUp);
        final TextView login = findViewById(R.id.tvLogin);
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String fullnametxt = fullname.getText().toString();
                final String phonetxt = phone.getText().toString();
                final String usernametxt = username.getText().toString();
                final String passwordtxt = password.getText().toString();

                boolean isLeter = true;
                if(fullnametxt.isEmpty()||phonetxt.isEmpty()||usernametxt.isEmpty()||passwordtxt.isEmpty())
                    Toast.makeText(SignUp.this, "please enter enough the information", Toast.LENGTH_SHORT).show();
                else if(!( usernametxt.matches("[a-zA-Z]+"))){
                        Toast.makeText(SignUp.this, "username contains only letters", Toast.LENGTH_SHORT).show();
                    }
                else if(!(username.length() >= 6)){
                    Toast.makeText(SignUp.this, "username must be 6 characters or more in length", Toast.LENGTH_SHORT).show();

                }
                    else if(!(passwordtxt.length() >= 6)){
                        Toast.makeText(SignUp.this, "password must be 6 characters or more in length", Toast.LENGTH_SHORT).show();
                    }
                    else {
                        firebasedb.child("users").addListenerForSingleValueEvent(new ValueEventListener() {
                            @Override
                            public void onDataChange(@NonNull DataSnapshot snapshot) {
                                if (snapshot.hasChild(usernametxt))
                                    Toast.makeText(SignUp.this, "Username is already registered ", Toast.LENGTH_SHORT).show();
                                else {
                                    firebasedb.child("users").child(usernametxt).child("fullname").setValue(fullnametxt);
                                    firebasedb.child("users").child(usernametxt).child("phone").setValue(phonetxt);
                                    try {
                                        firebasedb.child("users").child(usernametxt).child("password").setValue(Security.encrypt(passwordtxt));
                                    } catch (Exception e) {
                                        throw new RuntimeException(e);
                                    }
//                                    try {
//                                        firebasedb.child("users").child("password").setValue(Security.encrypt(passwordtxt));
//                                    } catch (Exception e) {
//                                        e.printStackTrace();
//                                    }
                                    Toast.makeText(SignUp.this, "Registration Successfully", Toast.LENGTH_SHORT).show();
                                    finish();
                                }
                            }

                            @Override
                            public void onCancelled(@NonNull DatabaseError error) {

                            }
                        });
                    }
                }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // startActivity(new Intent(SignUp.this, Login.class));
                startActivity(new Intent(SignUp.this, Login.class));
            }
        });
    }

}