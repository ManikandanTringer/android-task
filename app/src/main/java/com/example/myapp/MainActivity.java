package com.example.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button fragmentTask,serviceTask,broadcastTask,shopping,bottomNavBtn,layoutDemoBtn,dialogSnackbar,menus_task;
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
        bottomNavBtn=(Button) findViewById(R.id.bottomNavBtn);
        bottomNavBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getBaseContext(),FrontPage.class);
                startActivity(intent);
            }
        });
        layoutDemoBtn=(Button) findViewById(R.id.layoutDemo);
        layoutDemoBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getBaseContext(),LayoutDemo.class);
                startActivity(intent);
            }
        });

        dialogSnackbar=(Button) findViewById(R.id.dialog_snackbar);
        dialogSnackbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getBaseContext(),DialogSnackbar.class);
                startActivity(intent);
            }
        });
        menus_task=(Button) findViewById(R.id.menus_task);
        menus_task.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getBaseContext(),MenusTaskActivity.class);
                startActivity(intent);
            }
        });


    }

//    @Override
//    public void onClick(View view) {
//
//    }
}