package com.example.myapp;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class LinearFragment extends Fragment {

    private TextView textView1;
    View view;
    LinearLayout linearLayout;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @SuppressLint("ResourceType")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        view = inflater.inflate(R.layout.fragment_linear, container, false);
        textView1=view.findViewById(R.id.textview1);
        linearLayout=view.findViewById(R.id.linear_layout);
        //Layout params
        if(linearLayout.getOrientation() != LinearLayout.VERTICAL) {
            linearLayout.setOrientation(LinearLayout.VERTICAL);
        }
        else{
            Toast.makeText(getContext(),"Orientation is already vertical",Toast.LENGTH_LONG);
        }
        textView1.setLayoutParams(new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT

        ));
        textView1.setEms(2);

//        linearLayout.addView(textView1);

        //Create a button in java file
        Button btn = new Button(getContext());
        btn.setText("Welcome");
        btn.setBackgroundColor(Color.parseColor("#FCFCFC"));
//        btn.setTextColor(Color.parseColor("#FCFCFC"));
        btn.setId(10101);
        btn.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT));
//        btn.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, 150));
//        btn.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, 50));
        linearLayout.addView(btn);
        Button btn1=view.findViewById(10101);
         btn1.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 Toast.makeText(getContext(),"Welcoming You",Toast.LENGTH_LONG).show();
             }
         });



        return view;

    }
}