package com.bentals.class9;

import android.app.IntentService;
import android.content.Intent;


public class AlarmService extends IntentService {

    public AlarmService() {
        super("AlarmService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        NotificationUtils.notify(getApplicationContext(), "Good morning!!!", "Wake up!");
    }

}
