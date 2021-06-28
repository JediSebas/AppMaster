package com.jedisebas.appmaster.ui.calendar.ui.main;

import android.app.IntentService;
import android.app.Notification;
import android.app.PendingIntent;
import android.content.ContentResolver;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.core.app.NotificationManagerCompat;

import com.jedisebas.appmaster.R;

public class MyIntentService extends IntentService {

    public static CharSequence builderTitle="Title";
    public static CharSequence builderText="Text";

    public MyIntentService() {
        super("MyIntentService");
    }

    public static void setBuilderTitle(String title) {
        builderTitle = title;
    }

    public static void setBuilderText(String text) {
        builderText = text;
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        Uri sound = Uri.parse(ContentResolver.SCHEME_ANDROID_RESOURCE + "://" + getBaseContext().getPackageName() + "/" + R.raw.customsound);
        Notification.Builder builder = new Notification.Builder(this);
        builder.setContentTitle(builderTitle);
        builder.setContentText(builderText);
        builder.setSmallIcon(R.drawable.ic_dashboard_black_24dp);
        builder.setWhen(System.currentTimeMillis());
        builder.setShowWhen(true);
        builder.setSound(sound);

        Intent notifyIntent = new Intent(this, Calendar2.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, notifyIntent, PendingIntent.FLAG_UPDATE_CURRENT);

        builder.setContentIntent(pendingIntent);
        Notification notification = builder.build();
        notification.defaults = Notification.DEFAULT_VIBRATE;
        NotificationManagerCompat managerCompat = NotificationManagerCompat.from(this);
        managerCompat.notify(0, notification);

    }
}
