package com.example.myapp.ui;

import android.app.job.JobParameters;
import android.app.job.JobService;
import android.util.Log;

import java.util.Random;

public class JobServiceDemo extends JobService {

    public static final String TAG="JobServiceDemo";

    private int randomNo;
    private boolean isRandomGenerateNo;
    public final int MIN=0;
    public final int MAX=100;
    @Override
    public boolean onStartJob(JobParameters params) {
        Log.i(TAG,"onStartJob");
        doBackgroundJob();
        return true;
    }

    private void doBackgroundJob(){
        new Thread((Runnable) ()->{
            isRandomGenerateNo=true;
            startRandomNumberGenerator();
        }).start();
    }

    @Override
    public boolean onStopJob(JobParameters params) {
        Log.i(TAG,"onStopJob");
        return true;
    }

    private void startRandomNumberGenerator(){
        while ((isRandomGenerateNo)){
            try {
                Thread.sleep(1000);
                if(isRandomGenerateNo){
                    randomNo=new Random().nextInt(MAX)+MIN;
                    Log.i(TAG,"Thread id : "+Thread.currentThread().getId()+" Random NO: "+randomNo);
                }
            } catch (InterruptedException e) {
                Log.e(TAG,"Thread Interrupted");
                e.printStackTrace();
            }

        }
    }

    private void startRandomNumber(){}

}
