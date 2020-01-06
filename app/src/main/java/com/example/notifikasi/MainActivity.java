package com.example.notifikasi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        NotificationManager notificationManagerCompat = (NotificationManager) getApplicationContext().getSystemService(Context.NOTIFICATION_SERVICE);
        NotificationCompat.Builder builder = new NotificationCompat.Builder(getApplicationContext(), "Channel_1")
                .setContentTitle("Pengingat")
                .setSmallIcon(R.drawable.ic_launcher_background)
                .setContentText("Sisa Waktu Pengembalian tersisa 1 hari lagi")
                .setVibrate(new long[]{1000,1000,1000,1000,1000});
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            NotificationChannel channel = new NotificationChannel("Channel_1", "PENGINGAT", NotificationManager.IMPORTANCE_DEFAULT);
            channel.enableVibration(true);
            channel.setVibrationPattern(new long[]{1000,1000,1000,1000,1000});
            builder.setChannelId("Channel_1");
            if (notificationManagerCompat != null){
                notificationManagerCompat.createNotificationChannel(channel);
            }
        }
        Notification notification= builder.build();
        if (notificationManagerCompat!= null){
            notificationManagerCompat.notify(100, notification);
        }
    }
}
