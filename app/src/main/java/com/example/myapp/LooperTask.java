package com.example.myapp;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;

import androidx.annotation.NonNull;

public class LooperTask extends Thread{

    private static final String TAG = "LooperTask";
    Handler handler;

     @Override
    public void run() {

         Looper.prepare();

         handler=new Handler(Looper.myLooper()){
             @Override
             public void handleMessage(@NonNull Message msg) {
                 super.handleMessage(msg);
             Log.i(TAG,"Thread id when message is CustomLooper: "+ Thread.currentThread().getId()+", Count : "+msg.obj);
             }
         };




         Looper.loop();
//        for(int i=0;i<5;i++){
//            Log.d(TAG,"run"+i);
//            SystemClock.sleep(1000);
//        }
//        Log.d(TAG,"End of run()");
    }
}
