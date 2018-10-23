package com.example.kf.thetest;

import android.app.ActivityManager;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import java.util.List;

/**
 * Created by kf on 2017/11/1.
 */

public class MyBroadcastReceiver extends BroadcastReceiver {
    private MyService myService;

    @Override
    public void onReceive(Context context, Intent intent) {
        boolean isServiceRunning = false;


        if (intent.getAction().equals(Intent.ACTION_TIME_TICK)) {

            //检查Service状态
            Log.i("Lv====", "12121");
            if (!isServiceExisted(context, MyService.class.getName())) {
                Intent i = new Intent(context, MyService.class);
                context.startService(i);
            }
//            ActivityManager manager = (ActivityManager) MyApplication.getContext().getSystemService(Context.ACTIVITY_SERVICE);
//            for (ActivityManager.RunningServiceInfo service : manager.getRunningServices(Integer.MAX_VALUE)) {
//                Log.i("broadcast=====", service.service.getClassName());
//                if ("com.example.kf.thetest.MyService".equals(service.service.getClassName()))
//
//                {
//                    isServiceRunning = true;
//                }
//
//            }
//            if (!isServiceRunning) {
//                Intent i = new Intent(context, MyService.class);
//                context.startService(i);
//            }


        }
    }

    public static boolean isServiceExisted(Context context, String className) {
        ActivityManager activityManager = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
        List<ActivityManager.RunningServiceInfo> serviceList = activityManager.getRunningServices(Integer.MAX_VALUE);
        if (!(serviceList.size() > 0)) {
            return false;
        }
        for (int i = 0; i < serviceList.size(); i++) {
            ActivityManager.RunningServiceInfo serviceInfo = serviceList.get(i);
            ComponentName serviceName = serviceInfo.service;
            Log.i("Lvv===", serviceName.getClassName());
            if (serviceName.getClassName().equals(className)) {
                return true;
            }
        }
        return false;
    }
}
