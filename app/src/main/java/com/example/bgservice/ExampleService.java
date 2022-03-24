package com.example.bgservice;

import static com.example.bgservice.App.CHANNEL_ID;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;

public class ExampleService extends Service {

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

    }


    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        String input=intent.getStringExtra("inp");
        Intent notificationIntnet= new Intent(this,MainActivity.class);
        PendingIntent pendingIntent=PendingIntent.getActivity(this,
                0, notificationIntnet,0);

        Notification notification= new NotificationCompat.Builder(this,CHANNEL_ID)
                .setContentTitle("Example service")
                .setContentText(input)
                .setSmallIcon(R.drawable.ic_baseline_insert_emoticon_24)
                .setContentIntent(pendingIntent)
                .build();
             startForeground(1,notification);

        return START_NOT_STICKY;

    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
