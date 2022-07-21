package com.example.myapp;

import static com.example.myapp.NotificationApp.CHANNEL_ID;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.RemoteAction;
import android.app.RemoteInput;
import android.app.Service;
import android.content.Intent;
import android.os.Build;
import android.os.IBinder;

import androidx.annotation.RequiresApi;
import androidx.core.app.NotificationCompat;

public class ServiceForeground extends Service {
    private String ACTION_STOP="stop";
    private String ACTION_SEND="send";

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }
    @Override
    public void onCreate() {
        super.onCreate();
    }
    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        String input=intent.getStringExtra("EXTRA_INPUT");
        Intent notificationIntent=new Intent(this,ServiceForeground.class);
        PendingIntent pendingIntent=PendingIntent.getActivity(this,0,notificationIntent,0);

//        RemoteInput remoteInput=new RemoteInput.Builder("key_reply_text")
//                .setLabel("Your Reply")
//                .build();
//
//        Intent replyIntent=new Intent(this,MyBroadcastReceiver.class);
//        PendingIntent replyPendingIntent=PendingIntent.getBroadcast(this,0,replyIntent,0);
//        NotificationCompat.Action replyAction=new NotificationCompat.Action.Builder(R.drawable.ic_reply_24,"Reply",replyPendingIntent)
//                .addRemoteInput(remoteInput).build();
//        NotificationCompat.MessagingStyle messagingStyle=new NotificationCompat.MessagingStyle("Me");
//        messagingStyle.setConversationTitle("Group Chat");
        Intent stop=new Intent(this,ServiceForeground.class);
        stop.setAction(ACTION_STOP);
        PendingIntent actionStop=PendingIntent.getForegroundService(this,0,stop,PendingIntent.FLAG_CANCEL_CURRENT);
        Intent replyIntent=new Intent(this,MyBroadcastReceiver.class);
        //        PendingIntent replyPendingIntent=PendingIntent.getBroadcast(this,0,replyIntent,0);
        replyIntent.putExtra("reply",input);
        PendingIntent actionSend=PendingIntent.getBroadcast(this,0,replyIntent,PendingIntent.FLAG_UPDATE_CURRENT);
        Notification notification=new NotificationCompat.Builder(this,CHANNEL_ID)
                .setContentTitle("Music Play")
                .setContentText(input)
                .setSmallIcon(R.drawable.ic_baseline_music_note_24)
                .addAction(R.mipmap.ic_launcher,"cancel",actionStop)
                .addAction(R.mipmap.ic_launcher_round,"Send",actionSend)
                .setContentIntent(pendingIntent)
                .build();
        startForeground(1,notification);
        if(ACTION_STOP.equals(intent.getAction())){
            stopSelf();
        }
        return START_NOT_STICKY;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}