package com.example.kf.thetest;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;

/**
 * Created by kf on 2017/11/1.
 */

public class MyApplication extends Application {
    public static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
        IntentFilter filter = new IntentFilter(Intent.ACTION_TIME_TICK);

        MyBroadcastReceiver receiver = new MyBroadcastReceiver();
        registerReceiver(receiver, filter);
    }
}
