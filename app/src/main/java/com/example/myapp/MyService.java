package com.example.myapp;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Binder;
import android.os.IBinder;
import android.provider.Settings;
import android.util.Log;

public class MyService extends Service {
    private MediaPlayer player;
    private int count;
    static final String TAG="STARTED_SERVICE";
    private boolean isCounting =false;

    class MyServiceBinder extends Binder{
        public MyService getService(){
            return MyService.this;
        }
    }
    private IBinder mBinder =new MyServiceBinder();

    @Override
    public void onCreate() {
        super.onCreate();
        Log.i(TAG,"Service is created");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.i(TAG,"Service has started task");
        isCounting=true;
        new Thread((Runnable) ()->{
            setCount();
        }).start();


        player=MediaPlayer.create(this, Settings.System.DEFAULT_ALARM_ALERT_URI);
        player.setLooping(true);
        player.start();
        return START_STICKY;
//        return super.onStartCommand(intent, flags, startId);
    }

    public void setCount(){
        while(isCounting) {
            try {
                Thread.sleep(1000);
                if(isCounting) {
                    count = count + 1;
                    Log.i(TAG, String.valueOf(count));
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public int getCount() {
        return count;
    }

    @Override
    public IBinder onBind(Intent intent){
        Log.i(TAG,"onBind");

        return mBinder;
    }

    @Override
    public boolean onUnbind(Intent intent){
        Log.i(TAG,"onUnBind");

        return super.onUnbind(intent);

    }
    public void stop(){
        isCounting =false;
    }
    @Override
    public void onDestroy() {
        super.onDestroy();
//        isCounting=false;
        stop();
        Log.i(TAG,"Service has Destroyed");

        player.stop();

    }



}