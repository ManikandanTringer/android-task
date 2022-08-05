package com.example.myapp;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public class ThreadActivity extends AppCompatActivity {

    private static final String TAG = "ThreadActivity";
    private Button startThread,stopThread;
    private TextView countDisplay;

//    private Handler mainHandler=new Handler();
//    private boolean mStopLoop;
    Handler handler;
    LooperTask looperThread;

    int count=0;
    private volatile boolean isStopThread=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thread);

        ActionBar actionBar=getSupportActionBar();
        actionBar.setTitle("  Music Player ");
//        actionBar.setSubtitle("SubTitle");
        actionBar.setIcon(R.drawable.ic_baseline_music_note_24);
        actionBar.setDisplayUseLogoEnabled(true);
        actionBar.setDisplayShowHomeEnabled(true);




        countDisplay=(TextView) findViewById(R.id.countDisplay);
        startThread=(Button) findViewById(R.id.startThread);
        handler=new Handler();
        looperThread=new LooperTask();
        looperThread.start();

        handler=new Handler(Looper.getMainLooper());
        Log.i(TAG,"Thread id of Main thread: "+Thread.currentThread().getId());


    }
// Action Bar Menus
    @Override
    public boolean onCreateOptionsMenu(@NonNull Menu menu) {
        getMenuInflater().inflate(R.menu.download,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId())
        {
            case R.id.refresh:
                Toast.makeText(this, "Refresh the activity", Toast.LENGTH_SHORT).show();
                break;
            case R.id.download:
                startActivity(new Intent(ThreadActivity.this,DownloadActivity.class));
                Toast.makeText(this, "Download clicked", Toast.LENGTH_SHORT).show();
                break;
            case R.id.copy:
                Toast.makeText(this, "Copy the selected item", Toast.LENGTH_SHORT).show();
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    public void startThread(View view){
        isStopThread=true;

        executeOnCustomLooper();

////        using thread
//        SampleThread thread=new SampleThread(10);
//        thread.start();

//        using runnable
//        SampleRunnable runnable=new SampleRunnable(10);
//        new Thread(runnable).start();
    }
    public void stopThread(View view){
        isStopThread=false;
    }

    public void sampleFunction(View view) {
        Toast.makeText(this, "Pressed", Toast.LENGTH_SHORT).show();
    }


    public void executeOnCustomLooper(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (isStopThread){
                    try{
                        Thread.sleep(1000);
                        count++;
                        Message message=new Message();
                        message.obj=""+count;
                        looperThread.handler.sendMessage(message);
                    }catch (InterruptedException exception){
                        Log.i(TAG,"Thread for interrupted");
                    }

                }
            }
        }).start();

    }


    private Message getMessageWithCount(String count){
        Message message=new Message();
        message.obj=""+count;
        return message;
    }

    class SampleThread extends Thread{
        int seconds;
        SampleThread(int seconds){
            this.seconds=seconds;
        }
        @Override
        public void run() {
            for (int i=0;i<seconds;i++){
                Log.d(TAG, "startThread: "+Thread.currentThread().getId() +i);
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
            for (int i=1;i<=seconds;i++){
                if(isStopThread)
                    return;
                if(i==5){
                    Handler threadHandler=new Handler(Looper.getMainLooper());
                    threadHandler.post(new Runnable() {
                        @Override
                        public void run() {
                            Log.i(TAG," "+seconds);
                            startThread.setText("Running");
                        }

                    });

                    countDisplay.post(new Runnable() {
                        @Override
                        public void run() {
                            countDisplay.setText("Completed");
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