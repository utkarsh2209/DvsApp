package com.example.dvsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;

public class Splash_screen extends AppCompatActivity {

     String userr,password;
    SharedPreferences sp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        sp=getSharedPreferences("dvs",MODE_PRIVATE);

        userr=sp.getString("user",null);
        password=sp.getString("pass",null);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if(userr!=null&& password!=null){
                    Intent i=new Intent(Splash_screen.this, MainActivity.class);
                    startActivity (i);
                    finish();
                }
                else {
                    Intent i = new Intent(Splash_screen.this, Login_activity.class);
                    startActivity(i);
                    finish();
                }
            }

        },5*1000);
    }
}