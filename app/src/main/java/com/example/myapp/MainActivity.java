package com.example.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button fragmentTask,serviceTask,broadcastTask,shopping;
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
        broadcastTask=(Button) findViewById(R.id.broadcast);
        broadcastTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getBaseContext(),BroadcastTask.class);
                startActivity(intent);
            }
        });
        shopping=(Button)findViewById(R.id.shopping);
        shopping.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getBaseContext(),Shopping.class);
                startActivity(intent);
            }
        });

    }

//    @Override
//    public void onClick(View view) {
//
//    }
}