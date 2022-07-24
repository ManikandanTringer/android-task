package com.example.myapp;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class RegisterFragment extends Fragment {
    private Button registerBtn;
    EditText username,password,phonenumber,email;
    String usernameValue,passwordValue,phoneValue,emailValue;
    View view;

    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    @Override
    public void onAttach(Context context){
//        sharedPreferences=context.getSharedPreferences("usersFile",Context.MODE_PRIVATE);
//        editor=sharedPreferences.edit();
        super.onAttach(context);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view=inflater.inflate(R.layout.fragment_register, container, false);
//        username=view.findViewById(R.id.username);
//        password=view.findViewById(R.id.password);
//        registerBtn=view.findViewById(R.id.registerBtn);
//        phonenumber=view.findViewById(R.id.phonenumber);
//        email=view.findViewById(R.id.email);

        registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

//                usernameValue=username.getText().toString();
//                passwordValue=password.getText().toString();
//                phoneValue=phonenumber.getText().toString();
//                emailValue=email.getText().toString();
//                editor.putString("userName",usernameValue);
//                editor.putString("passwordValue",passwordValue);
//                editor.putString("phoneValue",phoneValue);
//                editor.putString("emailValue",emailValue);
//                editor.apply();
                Toast.makeText(getContext(),"Registered",Toast.LENGTH_LONG).show();

            }
        });



        return view;
    }
}