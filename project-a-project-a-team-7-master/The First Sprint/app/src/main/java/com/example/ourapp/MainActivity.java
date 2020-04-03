package com.example.ourapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText UsrName;
    private EditText PassWrd;
    private Button Login;
    private Button ForgetPass;
    private Button Create;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        UsrName = (EditText) findViewById(R.id.etUser);
        PassWrd = (EditText)findViewById(R.id.etPass);
        Login = (Button) findViewById(R.id.btnlogin);
        ForgetPass = (Button) findViewById(R.id.btnForget);
        Create = (Button) findViewById(R.id.btnCreate);
    }

    public void Logi(View v){
    startActivity(new Intent(MainActivity.this,homepage.class));
    }
    public void createAccount(View v){
        startActivity(new Intent(MainActivity.this,createAccount.class));
    }
    public void forgotpass(View v){
        startActivity(new Intent(getApplicationContext(),forgetpassword.class));
    }

}
