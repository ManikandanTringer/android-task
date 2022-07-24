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

public class SignupFragment extends Fragment {

    private Button signupBtn,registerBtn;
    EditText username;
    EditText password;
    CallbackFragment callbackFragment;
    String userName,passwordValue;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    View view;
    @Override
    public void onAttach(Context context){
        sharedPreferences=context.getSharedPreferences("usersFile",Context.MODE_PRIVATE);
        editor=sharedPreferences.edit();
        super.onAttach(context);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view=inflater.inflate(R.layout.fragment_signup, container, false);
        username=view.findViewById(R.id.username);
        password=view.findViewById(R.id.password);
        signupBtn=view.findViewById(R.id.signupBtn);
        registerBtn=view.findViewById(R.id.registerBtn);
        signupBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

//                userName=username.getText().toString();
//                passwordValue=password.getText().toString();
//                String uName,uPass;
//                uName=sharedPreferences.getString("userName",null);
//                uPass=sharedPreferences.getString("passwordValue",null);
//                if(userName.equals(uName) && passwordValue.equals(uPass)){
//                    Toast.makeText(getContext(),"Sign Up",Toast.LENGTH_LONG).show();
//
//                }else{
//                    Toast.makeText(getContext(),"Error",Toast.LENGTH_LONG).show();
//                    }
            }
        });

        registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                if(callbackFragment != null){
//                    callbackFragment.changeFragment();
//                }
            }
        });

        return view;
    }
    public void setCallbackFragment(CallbackFragment callbackFragment){
        this.callbackFragment=callbackFragment;
    }
}