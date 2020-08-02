package com.example.dvsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
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

public class Sign_activity extends AppCompatActivity {

    EditText n1,n2,n3,n4;
    RadioGroup g;
    ProgressDialog d;
    RadioButton rbtn;
    static String genderr;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_activity);
        n1=findViewById(R.id.fullname);
        n2=findViewById(R.id.signemailid);
        n3=findViewById(R.id.contactno);
        n4=findViewById(R.id.createpass);
        g=findViewById(R.id.ggg);

        Button button = findViewById(R.id.sign_login2);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent = new Intent(Sign_activity.this,Login_activity.class);
//                startActivity(intent);

                   int myid=g.getCheckedRadioButtonId();
                   rbtn=findViewById(myid);
                   genderr=rbtn.getText().toString();
                register();
            }
        });
    }

    public void register(){

        d=new ProgressDialog(Sign_activity.this);
        d.setCancelable(false);
        d.setMessage("wait...");
        d.show();
        StringRequest st=new StringRequest(Request.Method.POST, "http://dvsapp.xyz/webservice/register.php", new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                try{
                    d.dismiss();

                    JSONObject obj=new JSONObject(response);
                    String res=obj.getString("status");

                    if(res.equals("1")){
                        cln();
                        Intent intent = new Intent(Sign_activity.this,Login_activity.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
               startActivity(intent);

                    }
                    else{

                        d.dismiss();
                        cln();
                        Toast.makeText(Sign_activity.this, "try to Registration", Toast.LENGTH_LONG).show();
                    }

                }catch (Exception t){
                    Toast.makeText(Sign_activity.this, ""+t, Toast.LENGTH_LONG).show();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                d.dismiss();
                Toast.makeText(Sign_activity.this, "Server Error="+error, Toast.LENGTH_LONG).show();
            }
        }) {
            protected Map<String,String> getParams() {

                Map<String,String> mp=new HashMap<>();
                mp.put("name",n1.getText().toString());
                mp.put("user",n2.getText().toString());
                mp.put("contact",n3.getText().toString());
                mp.put("password",n4.getText().toString());
                mp.put("gender",genderr);

                return  mp;

            }

        };

        RequestQueue q= Volley.newRequestQueue(Sign_activity.this);
        q.add(st);
    }

    public void cln(){

        n1.setText(null);
        n1.requestFocus();
        n2.setText(null);
        n3.setText(null);
        n4.setText(null);

    }

}