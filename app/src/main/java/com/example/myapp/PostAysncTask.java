package com.example.myapp;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.Buffer;

public class GetAysncTask extends AsyncTask<Void,Void,String> {

    AsyncTaskActivity asyncTaskActivity;
    private AsyncCallBack asyncCallBack;
    private ProgressBar progressBar;
    private static final String TAG = "GetAysncTask";

    GetAysncTask setInstance(Context context,ProgressBar progressBar){
        this.asyncTaskActivity=(AsyncTaskActivity)context;
        asyncCallBack=(AsyncCallBack) context;
        this.progressBar=progressBar;
        return this;

    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    protected String doInBackground(Void... voids) {
        HttpGet httpGet=new HttpGet("https://reqres.in/api/users?page=2");
        HttpClient client=new DefaultHttpClient();
        String result="";
        try{
            HttpResponse response=client.execute(httpGet);
            int statusCode=response.getStatusLine().getStatusCode();
            Log.d(TAG,String.valueOf(statusCode));
            if(statusCode == 200){
                InputStream inputStream=response.getEntity().getContent();
                BufferedReader reader=new BufferedReader(new InputStreamReader(inputStream));
                String line;
                while ((line = reader.readLine() != null )){
                    result+=line;

                }
                Log.d(TAG,String.valueOf(result));
            }
        }catch (IOException e){
            e.printStackTrace();
        }
        finally {
            asyncTaskActivity.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    progressBar.setVisibility(View.GONE);
                }
            });
        }
        return result;
    }

    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }



    @Override
    protected void onPostExecute(String result) {
        super.onPostExecute(result);
        asyncCallBack.setResult(result);


    }

}
