package com.example.ourapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class forgetpassword extends AppCompatActivity {

    String mail;
    EditText email;
    Button done;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgetpassword);

    }


    public void Goback(View v){

    startActivity(new Intent(getApplicationContext(), MainActivity.class));
    }
    public void recognizeEmail(View v){
        email = findViewById(R.id.emailforgot);
        mail = email.getText().toString();
        done = findViewById(R.id.forgotemailbtn);
        if (mail.isEmpty()){
            Toast.makeText(getApplicationContext(), "please enter a valid email address", Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(getApplicationContext(), "if this email exists a notification has been sent", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(getApplicationContext(), MainActivity.class));
        }


    }
}
