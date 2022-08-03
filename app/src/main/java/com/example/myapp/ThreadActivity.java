package com.example.myapp;

import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class ThreadActivity extends AppCompatActivity {

    private static final String TAG = "ThreadActivity";
    private Button startThread;

    private Handler mainHandler=new Handler();

    private volatile boolean isStopThread=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thread);

        startThread=(Button) findViewById(R.id.startThread);

    }

    public void startThread(View view){
        isStopThread=false;

////        using thread
//        SampleThread thread=new SampleThread(10);
//        thread.start();

//        using runnable
        SampleRunnable runnable=new SampleRunnable(10);
        new Thread(runnable).start();
    }
    public void stopThread(View view){
        isStopThread=true;
    }

    class SampleThread extends Thread{
        int seconds;
        SampleThread(int seconds){
            this.seconds=seconds;
        }
        @Override
        public void run() {
            for (int i=0;i<seconds;i++){
                Log.d(TAG, "startThread: "+i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    class SampleRunnable implements Runnable{
        int seconds;
        SampleRunnable(int seconds){
            this.seconds=seconds;
        }
        @Override
        public void run() {
            for (int i=0;i<seconds;i++){
                if(isStopThread)
                    return;
                if(i==5){
//                    Handler threadHandler=new Handler(Looper.getMainLooper());
                    mainHandler.post(new Runnable() {
                        @Override
                        public void run() {
                            startThread.setText("Running");
                        }
                    });

                /*
                    startThread.post(new Runnable() {
                        @Override
                        public void run() {

                        }
                    });

                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {

                        }
                    });
                 */


                }
                Log.d(TAG, "startThread: "+i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }
    }
}