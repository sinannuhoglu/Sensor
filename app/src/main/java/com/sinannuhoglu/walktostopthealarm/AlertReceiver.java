package com.sinannuhoglu.walktostopthealarm;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;

import androidx.core.app.NotificationCompat;

public class AlertReceiver extends BroadcastReceiver {
    public static int selectedMusic = 0;
    private static final int[] musicIds = new int[] {R.raw.music1, R.raw.music2,R.raw.music3,R.raw.music4}; 
    private static MediaPlayer mediaPlayer;
    public static boolean isAlarmRinging = false;

    @Override
    public void onReceive(Context context, Intent intent) {
        isAlarmRinging = true;

        mediaPlayer = MediaPlayer.create(context, musicIds[selectedMusic]);
        mediaPlayer.start();
        NotificationHelper notificationHelper = new NotificationHelper(context);
        NotificationCompat.Builder nb = notificationHelper.getChannelNotification();
        notificationHelper.getManager().notify(1, nb.build());
    }


    public static void stopMediaPlayer() {
        if (mediaPlayer != null) {
            mediaPlayer.stop();
            mediaPlayer.release();
            mediaPlayer = null;
            isAlarmRinging = false;
        }
    }
}

