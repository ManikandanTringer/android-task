package com.example.myapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;

import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class BroadcastTask extends AppCompatActivity {

    private Button send;
    private BroadcastReceiver broadcastReceiver;
    LocalBroadcastManager localBroadcastManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_broadcast_task);
        send=(Button)findViewById(R.id.send);
        localBroadcastManager=LocalBroadcastManager.getInstance(getApplicationContext());
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent("my.custom.action.tag");
//                intent.addCategory(Intent.CATEGORY_DEFAULT);
//                intent.Action();

                localBroadcastManager.sendBroadcast(intent);
            }
        });
        broadcastReceiver=new MyBroadcastReceiver();

    }

    @Override
    protected void onStart() {
        super.onStart();
        IntentFilter intentFilter=new IntentFilter("my.custom.action.tag");
        localBroadcastManager.registerReceiver(broadcastReceiver,intentFilter);

    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
        if(broadcastReceiver != null) {
            unregisterReceiver(broadcastReceiver);
        }
    }
}