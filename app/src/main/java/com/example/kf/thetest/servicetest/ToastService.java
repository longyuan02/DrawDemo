package com.example.kf.thetest.servicetest;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.Build;
import android.os.IBinder;
import android.support.annotation.IntDef;
import android.support.annotation.Nullable;
import android.support.v7.app.NotificationCompat;
import android.util.Log;

import com.example.kf.thetest.MainActivity;
import com.example.kf.thetest.R;

/**
 * Created by kf on 2018/2/11.
 */

public class ToastService extends Service{
    private NotificationManager nm;
    private NotificationCompat.Builder builder;
    private MyBinder mBinder = new MyBinder();
    public static final String TAG=ToastService.class.getSimpleName()+"======";
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return mBinder;
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
    public class MyBinder extends Binder{
        public void startDownload() {
            Log.d(TAG, "startDownload() executed");
            // 执行具体的下载任务
//            updateNotification(10);
//            Dfdffd();
//            jump();
            showNotification();
        }
    }
    /**
     * 更新通知(显示通知栏信息)
     *
     * @param stepN
     */
    private void updateNotification(int stepN) {
        String content = "今日步数:" + stepN + " 步";
        builder = new NotificationCompat.Builder(this);
        builder.setPriority(Notification.PRIORITY_MIN);
        Intent resultIntent=new Intent(this,MainActivity.class);
        resultIntent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
        resultIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        PendingIntent contentIntent = PendingIntent.getActivity(this, 0,resultIntent, PendingIntent.FLAG_UPDATE_CURRENT);
        builder.setContentIntent(contentIntent);
        builder.setSmallIcon(R.mipmap.ic_launcher);
        builder.setTicker("健步走");
        builder.setContentTitle("健步走");
        //设置不可清除
        builder.setOngoing(false);
        builder.setContentText(content);
        builder.setAutoCancel(true);
        Notification notification = builder.build(); //上面均为构造Notification的构造器中设置的属性

        startForeground(0, notification);
        nm = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        nm.notify(100, notification);
    }
    private void Dfdffd(){
        NotificationManager barmanager=(NotificationManager)getSystemService(NOTIFICATION_SERVICE);
        Notification notice;
        Notification.Builder builder = new Notification.Builder(this).setTicker("11212")
                .setSmallIcon(R.mipmap.ic_launcher).setWhen(System.currentTimeMillis());
        Intent appIntent=null;
        appIntent = new Intent(this,NotificationClickReceiver.class);
        appIntent.setAction(Intent.ACTION_MAIN);
        appIntent.addCategory(Intent.CATEGORY_LAUNCHER);
        appIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK| Intent.FLAG_ACTIVITY_RESET_TASK_IF_NEEDED);//关键的一步，设置启动模式
        PendingIntent contentIntent =PendingIntent.getActivity(this, 0,appIntent,PendingIntent.FLAG_UPDATE_CURRENT);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            notice = builder.setContentIntent(contentIntent).setContentTitle("标题").setContentText("内容").build();
            notice.flags=Notification.FLAG_AUTO_CANCEL;
            barmanager.notify(10,notice);
        }
    }
    private void jump(){
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this);

        builder.setContentTitle("1111");
        builder.setContentText("22222");
        builder.setSubText("");
        builder.setContentInfo("");
//设置一个大图标，参数是bitmap
//        builder.setLargeIcon(BitmapFactory.decodeResource(context.getResources(), android.R.drawable.star_on));
//如果只设置SmallIcon，那么图片会显示在通知的最左边。
// 如果LargeIcon与SmallIcon同时设置,出现在最左边的是LargeIcon,SmallIcon出现在右下角
//开发过程中如果如果右下角没有需求要显示图片的话直接设置SmallIcon即可
        builder.setSmallIcon(R.mipmap.ic_launcher);

//收到通知一般有三种用户提示方式：声音，震动，呼吸灯
        builder.setDefaults(Notification.DEFAULT_ALL);
//第一次消息收到后的提示
        builder.setTicker("来新消息了");
//所有设置必须在builder.build之前
//commit，确认刚才的设置，并且生成一个Notification对象

//创建一个pendingIntent对象用于点击notification之后跳转
        PendingIntent intent1 = PendingIntent.getActivity(this,0,new Intent(this,MainActivity.class),PendingIntent.FLAG_UPDATE_CURRENT);
        builder.setContentIntent(intent1);
//设置点击之后notification消失
        builder.setAutoCancel(false);
        Notification build = builder.build();

//创建并在通知栏弹出一个消息
        nm = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        nm.notify(1, build);//1为notification一个标签，可以通过这个标签进行取消等操作
    }



        private void showNotification() {
            // 创建一个NotificationManager的引用
            NotificationManager notificationManager = (NotificationManager) this.getSystemService(NOTIFICATION_SERVICE);

            // 定义Notification的各种属性
            NotificationCompat.Builder builder = new NotificationCompat.Builder(this);
            builder.setSmallIcon(R.mipmap.ic_launcher);
            // 设置通知的事件消息
            builder.setContentTitle("标题");
            builder.setContentText("内容");
            builder.setDefaults(Notification.DEFAULT_ALL);
            builder.setAutoCancel(true);//打开应用后消失
            Intent clickIntent = new Intent(this, NotificationClickReceiver.class); //点击通知之后要发送的广播
            Intent activityClick=new Intent(this,MainActivity.class);
            int id = (int) (System.currentTimeMillis() / 1000);
            PendingIntent pi=PendingIntent.getActivity(this.getApplicationContext(),0,activityClick,0);
            PendingIntent contentIntent = PendingIntent.getBroadcast(this.getApplicationContext(), id, clickIntent, PendingIntent.FLAG_UPDATE_CURRENT);
            builder.setContentIntent(pi);
            Notification build = builder.build();
            notificationManager.notify(id, build);
        }
}
