package service;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.Build;
import android.os.IBinder;

import androidx.core.app.NotificationCompat;

import com.example.season9.E14Foreground;
import com.example.season9.R;

import app.app;

public class ForeGround extends Service {



    public static Boolean serviceStarted = false;
    public ForeGround() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public void onCreate() {
        super.onCreate();
        app.toasty("Service Started");
        serviceStarted  = true;


        Intent notificationIntent = new Intent(this , E14Foreground.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this , 0 , notificationIntent , 0);
        //////// Need Channel Id ////////
        Notification notification = new NotificationCompat.Builder(this, "SEASON9")
                .setSmallIcon(R.drawable.ic_baseline_create_24)
                .setContentTitle("Content Title")
                .setContentText("Content Text")
                .setContentIntent(pendingIntent).build();
        startForeground(100 , notification);
    }
}