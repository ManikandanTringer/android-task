package com.example.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class ServiceTask extends AppCompatActivity {

    //count variable
    int counter=0;
    private ServiceConnection serviceConnection;
    private MyService myService;
    private Button bind;
    private Button unbind,count;
    boolean isServiceBound=false;
    private Intent serviceIntent;
    private TextView display;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service_task);
        display=(TextView) findViewById(R.id.displayValue);

        serviceIntent=new Intent(getApplicationContext(),MyService.class);
        bind=(Button) findViewById(R.id.bind);
        unbind=(Button) findViewById(R.id.unbind);
        count=(Button)findViewById(R.id.count);
       bind.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               bindServ();
           }
       });
       unbind.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               unBindService();
           }
       });
       count.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               countButtonPressed();
           }
       });


    }

    private void unBindService() {
        if(isServiceBound){
            unbindService(serviceConnection);
            isServiceBound=false;
        }
    }

    private void bindServ() {
        if(serviceConnection == null){
            serviceConnection=new ServiceConnection() {
                @Override
                public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                   MyService.MyServiceBinder myServiceBinder=(MyService.MyServiceBinder)iBinder;
                   myService=myServiceBinder.getService();
                    isServiceBound=true;
                }

                @Override
                public void onServiceDisconnected(ComponentName componentName) {
                    isServiceBound=false;
                }
            };
        }
        bindService(serviceIntent,serviceConnection, Context.BIND_AUTO_CREATE);

    }


    //Counter Functionality
    public void countButtonPressed(){
        if(isServiceBound){
            display.setText(String.valueOf(myService.getCount()));
            String a= String.valueOf(myService.getCount());
            Log.d("bind",a);
        }else{
            display.setText("No Count");
            String a= String.valueOf(myService.getCount());

            Log.d("bindnoo",a);
        }
//        counter++;
//        TextView countDisplay=(TextView) findViewById(R.id.displayValue);
//        countDisplay.setText(Integer.toString(counter));

    }

    public void startButtonPressed(View view) {
        Intent intent=new Intent(this,MyService.class);
        startService(intent);
    }
    public void stopButtonPressed(View view) {
        Intent intent=new Intent(this,MyService.class);
        stopService(intent);
    }
}