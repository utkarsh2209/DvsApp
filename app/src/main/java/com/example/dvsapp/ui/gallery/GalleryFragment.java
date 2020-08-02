package com.example.dvsapp.ui.gallery;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.dvsapp.R;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONObject;

public class GalleryFragment extends Fragment {

    private GalleryViewModel galleryViewModel;

    ImageView n1,n2,n3,n4,n5,n6,n7;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        galleryViewModel =
                ViewModelProviders.of(this).get(GalleryViewModel.class);
        View root = inflater.inflate(R.layout.fragment_gallery, container, false);
        final TextView textView = root.findViewById(R.id.text_gallery);
        n1=root.findViewById(R.id.g1);
        n2=root.findViewById(R.id.g2);
        n3=root.findViewById(R.id.g3);
        n4=root.findViewById(R.id.g4);
        n5=root.findViewById(R.id.g5);
        n6=root.findViewById(R.id.g6);
        n7=root.findViewById(R.id.g7);

        Picasso.with(getActivity()).load("http://dvsapp.xyz/webservice/uploadimage/banner.png").into(n1);
        Picasso.with(getActivity()).load("http://dvsapp.xyz/webservice/uploadimage/home1.jpg").into(n2);
        Picasso.with(getActivity()).load("http://dvsapp.xyz/webservice/uploadimage/home2.jpg").into(n3);
        Picasso.with(getActivity()).load("http://dvsapp.xyz/webservice/uploadimage/home3.jpg").into(n4);
        Picasso.with(getActivity()).load("http://dvsapp.xyz/webservice/uploadimage/home4.jpg").into(n5);
        Picasso.with(getActivity()).load("http://dvsapp.xyz/webservice/uploadimage/hme5.jpg").into(n6);
        Picasso.with(getActivity()).load("http://dvsapp.xyz/webservice/uploadimage/hhhh.jpg").into(n7);
        galleryViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }

//    public  void gallery_server(){
//
//
//        StringRequest st=new StringRequest(Request.Method.GET, "", new Response.Listener<String>() {
//            @Override
//            public void onResponse(String response) {
//                  try{
//
//                      JSONObject jsonObject=new JSONObject(response);
//
//
//                      JSONArray arr=jsonObject.getJSONArray("data");
//                      for(int i=0;i<arr.length();i++){
//
//                          JSONObject
//                      }
//
//
//
//                  }
//                  catch (Exception tt){}
//
//            }
//        }, new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError error) {
//
//            }
//        });
//
//        RequestQueue q= Volley.newRequestQueue(getActivity());
//        q.add(st);
//
//    }
}