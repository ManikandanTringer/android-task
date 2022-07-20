package com.example.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button fragmentTask,serviceTask;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragmentTask=(Button) findViewById(R.id.fragmentTask);
        fragmentTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(getBaseContext(),FragmentTask.class);
                startActivity(intent);
            }
        });
        serviceTask=(Button) findViewById(R.id.serviceTask);
        serviceTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(getBaseContext(),ServiceTask.class);
                startActivity(intent);
            }
        });

    }
}