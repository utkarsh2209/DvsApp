package com.example.dvsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Machinelearning extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_machinelearning);
        Button b=findViewById(R.id.downloadflutter);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userr,password;
                SharedPreferences sp;
                sp=getSharedPreferences("dvs",MODE_PRIVATE);

                userr=sp.getString("user",null);
                password=sp.getString("pass",null);
                if(userr!=null && password!=null){
                    Intent intent = new Intent();
                    intent.setAction("android.intent.action.VIEW");
                    intent.addCategory("android.intent.category.BROWSABLE");
                    intent.setData(Uri.parse((String)"https://drive.google.com/file/d/0B469ZxCYjASMTm4wbFY4RFhENTg/view"));
                    startActivity(intent);
                }
                else{

                    Toast.makeText(getApplicationContext(), "go to registration", Toast.LENGTH_LONG).show();
                }

            }
        });
        Button enqry=findViewById(R.id.enquiry);
        enqry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Machinelearning.this,Student_Enquiry.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
                startActivity(intent);

            }
        });
    }
}