package com.example.dvsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class Login_activity extends AppCompatActivity {

     SharedPreferences sp;
    Button bt;

    TextView tv;
ProgressDialog d;
     EditText n1,n2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_activity);
        sp=getSharedPreferences("dvs",MODE_PRIVATE);
         n1=findViewById(R.id.txtloginemail);
         n2=findViewById(R.id.loginpass);
        Button button = findViewById(R.id.login1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent = new Intent(Login_activity.this,MainActivity.class);
//                startActivity(intent);

                login();
            }
        });

        TextView textView = findViewById(R.id.createaccount);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Login_activity.this,Sign_activity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
                startActivity(intent);
            }
        });

        Button button1 = findViewById(R.id.guestuser);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Login_activity.this,MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
                startActivity(intent);
            }
        });
    }


    public void login(){

        final SharedPreferences.Editor editor=sp.edit();

        d=new ProgressDialog(Login_activity.this);
        d.setCancelable(false);
        d.setMessage("wait...");
        d.show();
        StringRequest st=new StringRequest(Request.Method.POST, "http://dvsapp.xyz/webservice/login.php", new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                try{
                    d.dismiss();

                    JSONObject obj=new JSONObject(response);
                    String res=obj.getString("status");

                    if(res.equals("1")){

                         editor.putString("user",n1.getText().toString());
                         editor.putString("pass",n2.getText().toString());
                         editor.commit();

                        Intent loginIntent=new Intent (Login_activity.this, MainActivity.class);
                        loginIntent.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
                        startActivity(loginIntent);
                        cln();

                    }
                    else{

                        d.dismiss();
                        cln();
                        Toast.makeText(Login_activity.this, "Go to Registration", Toast.LENGTH_LONG).show();
                    }

                }catch (Exception t){}
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                d.dismiss();
                Toast.makeText(Login_activity.this, "Server Error="+error, Toast.LENGTH_LONG).show();
            }
        }) {
            protected Map<String, String> getParams() {

                Map<String,String> mp=new HashMap<>();
                mp.put("user",n1.getText().toString());
                mp.put("password",n2.getText().toString());

                return  mp;

            }

        };
        RequestQueue q= Volley.newRequestQueue(Login_activity.this);
        q.add(st);
    }

    public void cln(){

       n1.setText(null);
       n1.requestFocus();
       n2.setText(null);

    }

}