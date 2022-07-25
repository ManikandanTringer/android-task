package com.example.myapp;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class Shopping extends AppCompatActivity{
    private Button signupBtn,registerBtn;
    Fragment fragment;
    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;



    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        setContentView(R.layout.activity_shopping);
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_formtype,
                new SignupFragment()).commit();
        signupBtn=(Button) findViewById(R.id.signupBtn);
        registerBtn=(Button)findViewById(R.id.registerBtn);
        signupBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                replaceFragment(new SignupFragment());
            }
        });
        registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                replaceFragment(new RegisterFragment());
            }
        });
//        newFragment();

    }

    private void replaceFragment(Fragment fragment) {

        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_formtype,
                fragment).commit();
//        FragmentManager fragmentManager=getSupportFragmentManager();
//        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
//        fragmentTransaction.replace(R.id.fragment_formtype,fragment);
//        fragmentTransaction.commit();

    }

    private void newFragment() {
        SignupFragment fragment=new SignupFragment();
        fragmentManager=getSupportFragmentManager();
        fragmentTransaction=fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.fragment_formtype,fragment);
        fragmentTransaction.commit();
    }

//    private  void replaceFragment(){
//        RegisterFragment fragment=new RegisterFragment();
//        fragmentManager=getSupportFragmentManager();
//        fragmentTransaction=fragmentManager.beginTransaction();
//        fragmentTransaction.addToBackStack(null);
//        fragmentTransaction.replace(R.id.formtype,fragment);
//        fragmentTransaction.commit();
//
//    }

//    @Override
//    public void changeFragment() {
//        replaceFragment();
//    }
}