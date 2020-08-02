package com.example.dvsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
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

public class Workshop extends AppCompatActivity {

     EditText n1,n2,n3,n4,n5;
     ProgressDialog d;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workshop);
        n1=findViewById(R.id.fullname);
        n2=findViewById(R.id.signemailid);
        n3=findViewById(R.id.contactno);
        n4=findViewById(R.id.msgg);
        n5=findViewById(R.id.selectcourse);
        Button b2=findViewById(R.id.sign_login2);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                feedback();
            }
        });

        Button b=findViewById(R.id.workshopenquiry);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i=new Intent(getApplicationContext(),Student_Enquiry.class);

                startActivity(i);
            }
        });
    }

    public void feedback(){

        d=new ProgressDialog(Workshop.this);
        d.setCancelable(false);
        d.setMessage("wait...");
        d.show();
        StringRequest st=new StringRequest(Request.Method.POST, "http://dvsapp.xyz/webservice/feedback.php", new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                try{
                    d.dismiss();

                    JSONObject obj=new JSONObject(response);
                    String res=obj.getString("status");

                    if(res.equals("1")){
                        cln();
                        Intent intent = new Intent(Workshop.this,MainActivity.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
                        startActivity(intent);
                        Toast.makeText(Workshop.this, "succes", Toast.LENGTH_LONG).show();

                    }
                    else{

                        d.dismiss();
                        cln();
                        Toast.makeText(Workshop.this, "try to again", Toast.LENGTH_LONG).show();
                    }

                }catch (Exception t){
                    d.dismiss();
                    Toast.makeText(Workshop.this, ""+t, Toast.LENGTH_LONG).show();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                d.dismiss();
                Toast.makeText(Workshop.this, "Server Error="+error, Toast.LENGTH_LONG).show();
            }
        }) {
            protected Map<String,String> getParams() {

                Map<String,String> mp=new HashMap<>();
                mp.put("name",n1.getText().toString());
                mp.put("college",n2.getText().toString());
                mp.put("date",n3.getText().toString());
                mp.put("topic",n4.getText().toString());
                mp.put("feedback",n5.getText().toString());

                return  mp;

            }

        };

        RequestQueue q= Volley.newRequestQueue(Workshop.this);
        q.add(st);
    }

    public void cln(){

        n1.setText(null);
        n1.requestFocus();
        n2.setText(null);
        n3.setText(null);
        n4.setText(null);
        n5.setText(null);

    }
}