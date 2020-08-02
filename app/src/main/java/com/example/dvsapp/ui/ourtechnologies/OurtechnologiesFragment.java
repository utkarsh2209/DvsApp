package com.example.dvsapp.ui.ourtechnologies;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.dvsapp.Ai;
import com.example.dvsapp.Android;
import com.example.dvsapp.Angular;
import com.example.dvsapp.Bigdata;
import com.example.dvsapp.Cybersecurity;
import com.example.dvsapp.Datascience;
import com.example.dvsapp.Deeplearning;
import com.example.dvsapp.Digitalmar;
import com.example.dvsapp.Dotnet;
import com.example.dvsapp.Flutter;
import com.example.dvsapp.Ionic;
import com.example.dvsapp.Ios;
import com.example.dvsapp.Iot;
import com.example.dvsapp.Java;
import com.example.dvsapp.Machinelearning;
import com.example.dvsapp.Meanstack;
import com.example.dvsapp.Nodejs;
import com.example.dvsapp.Php;
import com.example.dvsapp.Python;
import com.example.dvsapp.R;
import com.example.dvsapp.Salesforce;
import com.example.dvsapp.Seo;

    public class OurtechnologiesFragment extends Fragment implements View.OnClickListener {


    private OurtechnologiesViewModel ourtechnologiesViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        ourtechnologiesViewModel =
                ViewModelProviders.of(this).get(OurtechnologiesViewModel.class);
        View root = inflater.inflate(R.layout.fragment_ourtechnlogies, container, false);
        final TextView textView = root.findViewById(R.id.text_ourtechnologies);
        Button flutter=root.findViewById(R.id.buttonflutter);
               flutter.setOnClickListener(this);
        Button ionic=root.findViewById(R.id.buttonionic);
        ionic.setOnClickListener(this);
        Button ios=root.findViewById(R.id.buttonios);
        ios.setOnClickListener(this);
        Button iot=root.findViewById(R.id.buttoniot);
        iot.setOnClickListener(this);
        Button java=root.findViewById(R.id.buttonjava);
        java.setOnClickListener(this);
        Button means=root.findViewById(R.id.buttonmeanstack);
        means.setOnClickListener(this);
        Button cyber=root.findViewById(R.id.buttoncybersecurity);
        cyber.setOnClickListener(this);
        Button deep=root.findViewById(R.id.buttondeeplearning);
        deep.setOnClickListener(this);
        Button data1=root.findViewById(R.id.buttondatascience);
        data1.setOnClickListener(this);
        Button big=root.findViewById(R.id.buttonbigdata);
        big.setOnClickListener(this);
        Button and=root.findViewById(R.id.buttonandroid);
        and.setOnClickListener(this);
        Button php=root.findViewById(R.id.buttonphp);
        php.setOnClickListener(this);
        Button python=root.findViewById(R.id.buttonpython);
        python.setOnClickListener(this);
        Button angular=root.findViewById(R.id.buttonangular);
        angular.setOnClickListener(this);
        Button react=root.findViewById(R.id.buttonreact);
        react.setOnClickListener(this);
        Button dot=root.findViewById(R.id.buttondotnet);
        dot.setOnClickListener(this);
        Button sales=root.findViewById(R.id.buttonsalesforce);
        sales.setOnClickListener(this);
        Button seo=root.findViewById(R.id.buttonseo);
        seo.setOnClickListener(this);
        Button digital=root.findViewById(R.id.buttondigitalmarketing);
        digital.setOnClickListener(this);
        Button node=root.findViewById(R.id.buttonnodejs);
        node.setOnClickListener(this);
        Button ml=root.findViewById(R.id.buttonpythonwithmachine);
        ml.setOnClickListener(this);

        Button ai=root.findViewById(R.id.buttonai);
        ai.setOnClickListener(this);
//        b.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                Intent i=new Intent(getActivity(),Flutter.class);
//                i.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
//                startActivity(i);
//
//
//            }
//        });
        ourtechnologiesViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });



        return root;

    }


    @Override
    public void onClick(View v) {

        if(v.getId() == R.id.buttonandroid){
            Intent i=new Intent(getActivity(), Android.class);
            i.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
            startActivity(i);
        }
        if(v.getId()==R.id.buttonflutter){
            Intent i=new Intent(getActivity(),Flutter.class);
                i.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
                startActivity(i);
        }
        if(v.getId()==R.id.buttonios){
            Intent i=new Intent(getActivity(), Ios.class);
            i.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
            startActivity(i);
        }
        if(v.getId()==R.id.buttoniot){
            Intent i=new Intent(getActivity(), Iot.class);
            i.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
            startActivity(i);
        }
        if(v.getId()==R.id.buttonjava){
            Intent i=new Intent(getActivity(), Java.class);
            i.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
            startActivity(i);
        }
        if(v.getId()==R.id.buttonmeanstack){
            Intent i=new Intent(getActivity(), Meanstack.class);
            i.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
            startActivity(i);
        }
        if(v.getId()==R.id.buttoncybersecurity){
            Intent i=new Intent(getActivity(), Cybersecurity.class);
            i.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
            startActivity(i);
        }
        if(v.getId()==R.id.buttondeeplearning){
            Intent i=new Intent(getActivity(), Deeplearning.class);
            i.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
            startActivity(i);
        }
        if(v.getId()==R.id.buttondatascience){
            Intent i=new Intent(getActivity(), Datascience.class);
            i.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
            startActivity(i);
        }
        if(v.getId()==R.id.buttonbigdata){
            Intent i=new Intent(getActivity(), Bigdata.class);
            i.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
            startActivity(i);
        }
        if(v.getId()==R.id.buttonreact){
            Intent i=new Intent(getActivity(),Flutter.class);
            i.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
            startActivity(i);
        }
        if(v.getId()==R.id.buttonphp){
            Intent i=new Intent(getActivity(), Php.class);
            i.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
            startActivity(i);
        }
        if(v.getId()==R.id.buttonpython){
            Intent i=new Intent(getActivity(), Python.class);
            i.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
            startActivity(i);
        }
        if(v.getId()==R.id.buttonangular){
            Intent i=new Intent(getActivity(), Angular.class);
            i.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
            startActivity(i);
        }
        if(v.getId()==R.id.buttonionic){
            Intent i=new Intent(getActivity(), Ionic.class);
            i.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
            startActivity(i);
        }
        if(v.getId()==R.id.buttondotnet){
            Intent i=new Intent(getActivity(), Dotnet.class);
            i.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
            startActivity(i);
        }
        if(v.getId()==R.id.buttonsalesforce){
            Intent i=new Intent(getActivity(), Salesforce.class);
            i.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
            startActivity(i);
        }
        if(v.getId()==R.id.buttonseo){
            Intent i=new Intent(getActivity(), Seo.class);
            i.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
            startActivity(i);
        }
        if(v.getId()==R.id.buttondigitalmarketing){
            Intent i=new Intent(getActivity(), Digitalmar.class);
            i.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
            startActivity(i);
        }
        if(v.getId()==R.id.buttonnodejs){
            Intent i=new Intent(getActivity(), Nodejs.class);
            i.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
            startActivity(i);
        }

        if(v.getId()==R.id.buttonai){
            Intent i=new Intent(getActivity(), Ai.class);
            i.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
            startActivity(i);
        }

        if(v.getId()==R.id.buttonpythonwithmachine){
            Intent i=new Intent(getActivity(), Machinelearning.class);
            i.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
            startActivity(i);
        }

    }
}