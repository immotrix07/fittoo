package com.example.fittoo;

import android.app.Service;
import android.content.Intent;
import android.os.CountDownTimer;
import android.os.IBinder;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;

public class WorkoutTimerService extends Service {
    private static final String ACTION_UPDATE_TIME = "com.example.fittoo.UPDATE_TIME";
    private static final String EXTRA_TIME_REMAINING = "timeRemaining";
    
    private CountDownTimer timer;
    private long totalTimeMs = 1800000; // 30 minutes

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        startTimer();
        return START_STICKY;
    }

    private void startTimer() {
        timer = new CountDownTimer(totalTimeMs, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                sendTimeUpdate(millisUntilFinished);
            }

            @Override
            public void onFinish() {
                sendTimeUpdate(0);
                stopSelf();
            }
        }.start();
    }

    private void sendTimeUpdate(long timeRemaining) {
        Intent intent = new Intent(ACTION_UPDATE_TIME);
        intent.putExtra(EXTRA_TIME_REMAINING, timeRemaining);
        LocalBroadcastManager.getInstance(this).sendBroadcast(intent);
    }

    @Override
    public void onDestroy() {
        if (timer != null) {
            timer.cancel();
        }
        super.onDestroy();
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}