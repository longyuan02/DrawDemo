package com.example.kf.thetest.servicetest;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.example.kf.thetest.MainActivity;

/**
 * Created by kf on 2018/2/11.
 */

public class NotificationClickReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        //todo 跳转之前要处理的逻辑
        Intent newIntent = new Intent(context, MainActivity.class).addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(newIntent);
    }
}