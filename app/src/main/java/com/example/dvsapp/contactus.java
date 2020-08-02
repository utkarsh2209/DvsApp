package com.example.dvsapp;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link contactus#newInstance} factory method to
 * create an instance of this fragment.
 */
public class contactus extends Fragment {
    EditText n1,n2,n3,n4,n5;
    ProgressDialog d;
    Button btt;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public contactus() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment contactus.
     */
    // TODO: Rename and change types and number of parameters
    public static contactus newInstance(String param1, String param2) {
        contactus fragment = new contactus();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root=inflater.inflate(R.layout.fragment_contactus, container, false);

        n1=root.findViewById(R.id.firstname);
        n2=root.findViewById(R.id.lastname);
        n3=root.findViewById(R.id.signemailid);
        n4=root.findViewById(R.id.contactno);
        n5=root.findViewById(R.id.selectcourse);
        btt=root.findViewById(R.id.sign_login2);

        btt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                contactus();
            }
        });
        Button k=root.findViewById(R.id.sign_cancel);
        k.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cln();
            }
        });


        return  root;
    }

    public void contactus(){

        d=new ProgressDialog(getActivity());
        d.setCancelable(false);
        d.setMessage("wait...");
        d.show();
        StringRequest st=new StringRequest(Request.Method.POST, "http://dvsapp.xyz/webservice/contactus.php", new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                try{
                    d.dismiss();

                    JSONObject obj=new JSONObject(response);
                    String res=obj.getString("status");

                    if(res.equals("1")){
                        cln();
                        Intent intent = new Intent(getActivity(),MainActivity.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
                        startActivity(intent);
                        Toast.makeText(getActivity(), "succes", Toast.LENGTH_LONG).show();

                    }
                    else{

                        d.dismiss();
                        cln();
                        Toast.makeText(getActivity(), "try to again", Toast.LENGTH_LONG).show();
                    }

                }catch (Exception t){
                    d.dismiss();
                    Toast.makeText(getActivity(), ""+t, Toast.LENGTH_LONG).show();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                d.dismiss();
                Toast.makeText(getActivity(), "Server Error="+error, Toast.LENGTH_LONG).show();
            }
        }) {
            protected Map<String,String> getParams() {

                Map<String,String> mp=new HashMap<>();
                mp.put("name1",n1.getText().toString());
                mp.put("name2",n2.getText().toString());
                mp.put("email",n3.getText().toString());
                mp.put("mobile",n4.getText().toString());
                mp.put("msg",n5.getText().toString());

                return  mp;

            }

        };

        RequestQueue q= Volley.newRequestQueue(getActivity());
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