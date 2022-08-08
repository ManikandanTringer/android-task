package com.example.myapp;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class MainActivity extends AppCompatActivity {

    private Button fragmentTask,serviceTask,broadcastTask,toolbarTask,bottomNavBtn,layoutDemoBtn,dialogSnackbar,menus_task,calculator_btn,thread_task,adapter_task;
    private Toolbar toolbar;

    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar=findViewById(R.layout.appbar);
//        setSupportActionBar(toolbar);


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
        toolbarTask=(Button)findViewById(R.id.toolbarTask);
        toolbarTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getBaseContext(),AppBarDemo.class);
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

        calculator_btn=(Button) findViewById(R.id.calculator_btn);
        calculator_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getBaseContext(),CalculatorActivity.class);
                startActivity(intent);
            }
        });
        thread_task=(Button) findViewById(R.id.thread_task);
        thread_task.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getBaseContext(),ThreadActivity.class);
                startActivity(intent);
            }
        });

        adapter_task=(Button) findViewById(R.id.adapter_task);
        adapter_task.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getBaseContext(),List_ArrayAdapter.class);
                startActivity(intent);
            }
        });
    }

//    @Override
//    public void onClick(View view) {
//
//    }
}