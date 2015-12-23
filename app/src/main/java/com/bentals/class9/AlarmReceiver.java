package com.bentals.class9;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

import java.util.Calendar;

public class AlarmReceiver extends BroadcastReceiver {
    private int alarmId = 0;
    private AlarmManager alarmManager;

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.e("AlarmReceiver", "RECEIVED");
    }

    public AlarmReceiver() { }

    public void setAlarm(Context context, long timeInMillis)
    {
        alarmManager = ( AlarmManager)context.getSystemService(Context.ALARM_SERVICE);
        Intent i = new Intent(context, AlarmReceiver.class);
        PendingIntent pi = PendingIntent.getBroadcast(context, alarmId, i, 0);
        alarmManager.set(AlarmManager.RTC_WAKEUP, timeInMillis, pi);
    }

    public void cancelAlarm(Context context)
    {
        alarmManager = ( AlarmManager)context.getSystemService(Context.ALARM_SERVICE);
        Intent intent = new Intent(context, AlarmReceiver.class);
        PendingIntent sender = PendingIntent.getBroadcast(context, alarmId, intent, 0);
        alarmManager.cancel(sender);
    }
}
