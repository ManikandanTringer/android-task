package com.example.myapp;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

public class MyBroadcastReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {

        Toast.makeText(context,"Notification msg:"+intent.getStringExtra("reply"), Toast.LENGTH_LONG).show();
        Log.d("data-value", String.valueOf(intent.getIntExtra("msg",0)));

    }
}
