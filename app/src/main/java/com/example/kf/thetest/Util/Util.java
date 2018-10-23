package com.example.kf.thetest.Util;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.text.TextUtils;
import android.util.Base64;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Method;
import java.security.MessageDigest;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

//import org.android.agoo.huawei.HuaWeiRegister;
//import org.android.agoo.xiaomi.MiPushRegistar;

/**
 * Created by dragonfly on 2017/10/11.
 */

public class Util {
    public static DecimalFormat df = new DecimalFormat("####0");//保留整数
    public static DecimalFormat df1 = new DecimalFormat("####0.0");//保留一位小数
    public static DecimalFormat df2 = new DecimalFormat("####0.00");//保留两位小数
    public static final String MY_PREFERENCE = "AppMessage";

    public static final String tv_normal = "tv_normal";
    public static final String tv_blue = "tv_blue";
    public static final String tv_main = "tv_main";
    public static final String white = "white";
    public static final String transparent = "transparent";
    public static final String tvcolor999 = "tvcolor999";
    public static final String activitybg = "activitybg";
    public static final String fragmentgrey = "fragmentgrey";
    public static final String aphblue = "cs_evaluate_background_selected";

    public static void getPersonMessage(Context context) {
        SharedPreferences setting = context.getSharedPreferences("AppMessage",
                Activity.MODE_PRIVATE);

    }

//    private static Gson gson = new Gson();
//
//    public static Object jsonStringToObject(String src, Class dest) {
//        return gson.fromJson(src, dest);
//    }

    /**
     * 设置状态栏栏透明
     * 全屏模式
     *
     * @param activity
     * @param rlhuawei
     */
    public static void initHome(Activity activity, RelativeLayout rlhuawei) {//
        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.KITKAT) {
            LinearLayout.LayoutParams df = (LinearLayout.LayoutParams) rlhuawei.getLayoutParams();
            df.height = Util.getBottomStatusHeight(activity);
            rlhuawei.setLayoutParams(df);
        }
        String mobilebrand = Util.getDeviceBrand();//厂商信息
        Log.w("mobleversion===", mobilebrand);
        if (!TextUtils.isEmpty(mobilebrand)) {
            if (mobilebrand.equals("HUAWEI") || mobilebrand.equals("HONOR") || mobilebrand.equals("google") || mobilebrand.equals("vivo") || mobilebrand.equals("Android")) {
                rlhuawei.setVisibility(View.VISIBLE);
            } else {
                rlhuawei.setVisibility(View.GONE);
            }
        } else {
            rlhuawei.setVisibility(View.GONE);
        }
        activity.getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);//View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
        activity.getWindow().addFlags(WindowManager.LayoutParams.FLAG_LAYOUT_IN_SCREEN);
        activity.getWindow().addFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
    }

    /**
     * 获取 虚拟按键的高度
     *
     * @param context
     * @return
     */
    public static int getBottomStatusHeight(Context context) {
        int totalHeight = getDpi(context);

        int contentHeight = getScreenHeight(context);

        return totalHeight - contentHeight;
    }

    /**
     * 获得屏幕高度
     *
     * @param context
     * @return
     */
    public static int getScreenHeight(Context context) {
        WindowManager wm = (WindowManager) context
                .getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics outMetrics = new DisplayMetrics();
        wm.getDefaultDisplay().getMetrics(outMetrics);
        return outMetrics.heightPixels;
    }

    /**
     * 获取手机厂商
     *
     * @return 手机厂商
     */
    public static String getDeviceBrand() {
        return Build.BRAND;
    }

    public static int getDpi(Context context) {
        int dpi = 0;
        WindowManager windowManager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        Display display = windowManager.getDefaultDisplay();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        @SuppressWarnings("rawtypes")
        Class c;
        try {
            c = Class.forName("android.view.Display");
            @SuppressWarnings("unchecked")
            Method method = c.getMethod("getRealMetrics", DisplayMetrics.class);
            method.invoke(display, displayMetrics);
            dpi = displayMetrics.heightPixels;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dpi;
    }

    /**
     * 状态栏颜色
     *
     * @param activity
     */
    public static void navigationRecommend(Context context, Activity activity, LinearLayout linearLayout, ImageView iamge) {//状态栏颜色å颜色
        Window window = activity.getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        if (iamge != null) {
            iamge.setVisibility(View.VISIBLE);
        }

        LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) linearLayout.getLayoutParams();
        params.height = dip2px(context, 75);
        linearLayout.setLayoutParams(params);
    }
//    @org.jetbrains.annotations.Nullable
//    public static Object jsonStringToObjectKotlin(@org.jetbrains.annotations.NotNull String entity, @org.jetbrains.annotations.NotNull kotlin.reflect.KClass<SortDataList> kClass) {
//        return null;
//    }

//    public static String jsonObjectToString(Object ob) {
//        return gson.toJson(ob);
//    }

    public static void finishBack(Activity at, String inputname, String input, int id) {
        Intent intent = new Intent();
        intent.putExtra(inputname, input);
        at.setResult(id, intent);
    }

    //    public static String getYesterday() {//计算期一天时间
//        Calendar calendar = Calendar.getInstance();
//        String datestr = getTodayDate();
//        String[] array = datestr.split("\\-");
//        String yearstr = array[array.length - 3];
//        String monthstr = array[array.length - 2];
//        String date = array[array.length - 1];
//        int dateint = Integer.parseInt(date);
//        if (dateint == 1) {
//            calendar.add(Calendar.DATE, -1);    //得到前一天
//        }
////        calendar.add(Calendar.MONTH, -1);    //得到前一个月
//        int year = calendar.get(Calendar.YEAR);
//        int month = calendar.get(Calendar.MONTH) + 1;
//        int datedd = calendar.get(Calendar.DATE);
//        datestr = year + "-" + month + "-" + datedd;
//        return datestr;
//    }
    public static String getYesterday() {//计算前一天时间
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        int datedd = calendar.get(Calendar.DATE);
        if (datedd == 1) {
            calendar.add(Calendar.MONTH, -1);    //得到前一个月
            calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
        } else {
            calendar.add(Calendar.DAY_OF_MONTH, -1);//得到前一天
        }
        return format.format(calendar.getTime());
    }

    /**
     * 获得今天的日期
     */
    public static String getTodayDate() {
        Date date = new Date(System.currentTimeMillis());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(date);
    }

//    public static int getColor(Context context, String str) {
//        int color = 0;
//        switch (str) {
//            case tv_blue:
//                color = ContextCompat.getColor(context, R.color.login_blue);
//                break;
//            case tv_normal:
//                color = ContextCompat.getColor(context, R.color.tv_color);
//                break;
//            case tv_main:
//                color = ContextCompat.getColor(context, R.color.tv_main);
//                break;
//            case white:
//                color = ContextCompat.getColor(context, R.color.white);
//                break;
//            case transparent:
//                color = ContextCompat.getColor(context, R.color.transparency);
//                break;
//            case tvcolor999:
//                color = ContextCompat.getColor(context, R.color.tvcolor999);
//                break;
//            case fragmentgrey:
//                color = ContextCompat.getColor(context, R.color.fragmentgrey);
//                break;
//            case activitybg:
//                color = ContextCompat.getColor(context, R.color.activitybg);
//                break;
//            case aphblue:
//                color = ContextCompat.getColor(context, R.color.cs_evaluate_background_selected);
//                break;
//            default:
//                break;
//        }
//
//        return color;
//    }

    public static String formatDateTime() {
        SimpleDateFormat mDateFormat = new SimpleDateFormat("MM-dd HH:mm");
        long time = System.currentTimeMillis();
        if (0 == time) {
            return "";
        }
        return mDateFormat.format(new java.sql.Date(time));
    }

    // 时间转换年月日时分秒
    public static String serverToClientTimeYear(String times) {
        if (times == null)
            return "";
        if (times.length() == 13) {
            times = times.substring(0, times.length() - 3);
        }

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        // 前面的lSysTime是秒数，先乘1000得到毫秒数，再转为java.util.Date类型
        Date dt = new Date(Long.parseLong(times) * 1000);
        String sDateTime = sdf.format(dt); // 得到精确到秒的表示：2006-08-31 21:08:00
        return sDateTime;
    }

    public static boolean currentHoursIsOk() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH");
        Date date = new Date(System.currentTimeMillis());
        String currentTime = sdf.format(date);
        if (!TextUtils.isEmpty(currentTime)) {
            if (currentTime.length() > 2) {
                currentTime = currentTime.substring(currentTime.length() - 2, currentTime.length());
            }
        }
        return Integer.parseInt(currentTime) >= 22;
    }

    //"yyyy年MM月dd日HH时mm分ss秒"
    // 时间转换年月日时分秒
    public static String serverToClientTimeYearMonth(String times) {
        if (times == null)
            return "";
        if (times.length() == 13) {
            times = times.substring(0, times.length() - 3);
        }

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日HH时mm分ss秒");
        // 前面的lSysTime是秒数，先乘1000得到毫秒数，再转为java.util.Date类型
        Date dt = new Date(Long.parseLong(times) * 1000);
        String sDateTime = sdf.format(dt); // 得到精确到秒的表示：2006-08-31 21:08:00
        return sDateTime;
    }

    public static String serverToClientTimeYYMMDD() {
        long data = System.currentTimeMillis();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日");
        // 前面的lSysTime是秒数，先乘1000得到毫秒数，再转为java.util.Date类型
        Date dt = new Date(data);
        String sDateTime = sdf.format(dt); // 得到精确到秒的表示：2006-08-31 21:08:00
        if (sDateTime.length() >= 11) {
            sDateTime = sDateTime.substring(0, 11);
        }

        return sDateTime;
    }

    // 时间转换年月日时分秒
    public static String serverToClientTimeYearnumber(String times) {
        if (times == null)
            return "";

        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd HH:mm:ss");
        // 前面的lSysTime是秒数，先乘1000得到毫秒数，再转为java.util.Date类型
        Date dt = new Date(Long.parseLong(times) * 1000);
        String sDateTime = sdf.format(dt); // 得到精确到秒的表示：20060831 21:08:00
        return sDateTime;
    }

    public static String data(String time) {
        SimpleDateFormat sdr = new SimpleDateFormat("yyyy年MM月dd日HH时mm分ss秒",
                Locale.CHINA);
        Date date;
        String times = null;
        try {
            date = sdr.parse(time);
            long l = date.getTime();
            String stf = String.valueOf(l);
            times = stf.substring(0, 10);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return times;
    }

    public static String dataDate(String time) {
        SimpleDateFormat sdr = new SimpleDateFormat("yyyy年MM月dd日HH时mm分ss秒",
                Locale.CHINA);
        Date date;
        for (int i = time.length(); i < 14; i++) {
            time = time + "0";
        }
        String times = null;
        try {
            date = sdr.parse(time);
            long l = date.getTime();
            String stf = String.valueOf(l);
            times = stf.substring(0, 10);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return times;
    }

//    public static void Perssion(Context context, int id) {
//        if (id == 0) {
//            AndPermission.with((Activity) context)
//                    .requestCode(101)
//                    .permission(Manifest.permission.WRITE_CONTACTS,
//                            Manifest.permission.READ_SMS,
//                            Manifest.permission.WRITE_EXTERNAL_STORAGE,
//                            Manifest.permission.CALL_PHONE)
//
//                    .send();
//        } else if (id == 1) {//存储
//            AndPermission.with((Activity) context)
//                    .requestCode(101)
//                    .permission(Manifest.permission.WRITE_CONTACTS,
//                            Manifest.permission.READ_SMS,
//                            Manifest.permission.WRITE_EXTERNAL_STORAGE)
//                    .send();
//        } else if (id == 2) {//電話
//            AndPermission.with((Activity) context)
//                    .requestCode(101)
//                    .permission(Manifest.permission.WRITE_CONTACTS,
//                            Manifest.permission.READ_SMS,
//                            Manifest.permission.CALL_PHONE)
//                    .send();
//        } else if (id == 3) {//照相
//            AndPermission.with((Activity) context)
//                    .requestCode(101)
//                    .permission(Manifest.permission.WRITE_CONTACTS,
//                            Manifest.permission.READ_SMS,
//                            Manifest.permission.CAMERA)
//                    .send();
//        } else if (id == 4) {
//            AndPermission.with((Activity) context)
//                    .requestCode(101)
//                    .permission(Manifest.permission.READ_EXTERNAL_STORAGE)
//                    .send();
//        }
//    }

    public static boolean putBitmap(Context context, String key, Bitmap bitmap) {
        SharedPreferences sp = context.getSharedPreferences(MY_PREFERENCE,
                Context.MODE_PRIVATE);

//        paraCheck(sp, key);
        if (bitmap == null || bitmap.isRecycled()) {
            return false;
        } else {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, baos);
            String imageBase64 = new String(Base64.encode(baos.toByteArray(),
                    Base64.DEFAULT));
            SharedPreferences.Editor e = sp.edit();
            e.putString(key, imageBase64);
            e.putString("picImg", "");
            return e.commit();
        }
    }

    /**
     * 存储图片
     *
     * @param context
     * @param key
     * @param defaultValue
     * @return
     */
    public static Bitmap getBitmap(Context context, String key,
                                   Bitmap defaultValue) {
        SharedPreferences sp = context.getSharedPreferences(MY_PREFERENCE,
                Context.MODE_PRIVATE);

//        paraCheck(sp, key);
        String imageBase64 = sp.getString(key, "");
        if (TextUtils.isEmpty(imageBase64)) {
            return defaultValue;
        }

        byte[] base64Bytes = Base64.decode(imageBase64.getBytes(),
                Base64.DEFAULT);
        ByteArrayInputStream bais = new ByteArrayInputStream(base64Bytes);
        Bitmap ret = BitmapFactory.decodeStream(bais);
        if (ret != null) {
            return ret;
        } else {
            return defaultValue;
        }
    }

    /**
     * 缓存图片
     *
     * @param image_url
     * @param imageView
     * @param sendcontext
     */
//    static DiskLruCache mDiskLruCache = null;

//    public static void SaveImageDisk(final String image_url, ImageView imageView, Context sendcontext, DiskLruCache mDLruCache) {
//        mDiskLruCache = mDLruCache;
//        if (!TextUtils.isEmpty(image_url) && !image_url.equals("null")) {
//
//            ImageLoader mImageLoader = VolleySingleton.getVolleySingleton(sendcontext).getImageLoader();
//            try {
//                File cacheDir = ToDiskLruCache.getDiskCacheDir(sendcontext, image_url);
//                if (!cacheDir.exists()) {
//                    cacheDir.mkdirs();
//                }
//                try {
//                    mDiskLruCache = DiskLruCache.open(cacheDir, 1, 1, 10 * 1024 * 1024);
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//                String key = ToDiskLruCache.hashKeyForDisk(image_url);
//                DiskLruCache.Snapshot snapShot = null;
//                if (mDiskLruCache != null) {
//                    snapShot = mDiskLruCache.get(key);
//                }
//
//                if (snapShot != null) {
//                    InputStream is = snapShot.getInputStream(0);
//                    Bitmap bitmap = BitmapFactory.decodeStream(is);
//                    imageView.setImageBitmap(bitmap);
//                } else {
//                    mImageLoader.get(image_url, ImageLoader.getImageListener(imageView, R.drawable.ic_launcher, R.drawable.ic_launcher));
//                    new Thread(new Runnable() {
//                        @Override
//                        public void run() {
//                            try {
//                                String key = ToDiskLruCache.hashKeyForDisk(image_url);
//                                DiskLruCache.Editor editor = mDiskLruCache.edit(key);
//                                if (editor != null) {
//                                    OutputStream outputStream = editor.newOutputStream(0);
//                                    if (ToDiskLruCache.downloadUrlToStream(image_url, outputStream)) {
//                                        editor.commit();
//                                    } else {
//                                        editor.abort();
//                                    }
//                                }
//                                mDiskLruCache.flush();
//                            } catch (IOException e) {
//                                e.printStackTrace();
//                            }
//                        }
//                    }).start();
//                }
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//    }

    /**
     * 获取手机厂商
     *
     * @return 手机厂商
     */
//    public static String getDeviceBrand() {
//        return android.os.Build.BRAND;
//    }
//
//    public static void registorPush(Context context) {
//        String mobilebrand = Util.getDeviceBrand();//厂商信息
//        if (!TextUtils.isEmpty(mobilebrand)) {
//            if (mobilebrand.equals("HUAWEI") || mobilebrand.equals("HONOR")) {
//                HuaWeiRegister.register(context);
//            } else if (mobilebrand.equals("Xiaomi")) {
////                PushAgent mPushAgent = PushAgent.getInstance(context);
//////注册推送服务，每次调用register方法都会回调该接口
////                mPushAgent.register(new IUmengRegisterCallback() {
////
////                    @Override
////                    public void onSuccess(String deviceToken) {
////                        //注册成功会返回device token
////                        Log.i("deviceToken======", deviceToken);
////                    }
////
////                    @Override
////                    public void onFailure(String s, String s1) {
////
////                    }
////                });
//                MiPushRegistar.register(context, "2882303761517676979", "5791767629979");
//            } else {
//                JPushInterface.setDebugMode(true);
//                JPushInterface.init(context);
//            }
//        } else {
//            JPushInterface.setDebugMode(true);
//            JPushInterface.init(context);
//        }
//    }

    /**
     * 获取UserId
     *
     * @param context
     * @return
     */
//    public static String getUserId(Context context) {
//        String userId = "";
//        GetPersonMessage getPersonMessage = new GetPersonMessage(context);
//        userId = getPersonMessage.getUserId();
//        return userId;
//    }

    /**
     * 转换加密格式
     *
     * @param str
     * @return
     */
    public static String getSha1(String str) {
        if (str == null || str.length() == 0) {
            return null;
        }
        char hexDigits[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
                'a', 'b', 'c', 'd', 'e', 'f'};
        try {
            MessageDigest mdTemp = MessageDigest.getInstance("SHA1");
            mdTemp.update(str.getBytes("UTF-8"));

            byte[] md = mdTemp.digest();
            int j = md.length;
            char buf[] = new char[j * 2];
            int k = 0;
            for (int i = 0; i < j; i++) {
                byte byte0 = md[i];
                buf[k++] = hexDigits[byte0 >>> 4 & 0xf];
                buf[k++] = hexDigits[byte0 & 0xf];
            }
            return new String(buf);
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * 版本号
     *
     * @param context
     * @return
     */
    public static String getVersionName(Context context) {
        // 获取packagemanager的实例
        PackageManager packageManager = context.getPackageManager();
        // getPackageName()是你当前类的包名，0代表是获取版本信息
        PackageInfo packInfo = null;
        try {
            packInfo = packageManager.getPackageInfo(context.getPackageName(), 0);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        String version = packInfo.versionName;
        return version;
    }

    //转成double类型
    public static double getDoubleSimple(String str) {
        double strdb = 0;
        if (!TextUtils.isEmpty(str) && !str.equals("null")) {
            strdb = Double.parseDouble(str);
        }
        return strdb;
    }

    /**
     * 取显示更新次数
     *
     * @param context
     * @return
     */
    public static String getShowUpVersion(Context context, String versiont) {
        String versionCount = "";
        SharedPreferences sp = context.getSharedPreferences("updata", Context.MODE_PRIVATE);
        versionCount = sp.getString("updata", "");
        if (!versiont.equals(sp.getString("versiont", ""))) {//版本号与存储不同提示更新
            versionCount = "";
        }
        return versionCount;
    }

    /**
     * 取显示更新次数
     *
     * @param context
     * @return
     */
    public static void setShowUpVersion(Context context, String versiont) {
        String versionCount = "";
        SharedPreferences sp = context.getSharedPreferences("updata", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putString("updata", "1");
        editor.putString("versiont", versiont);
        editor.commit();
    }


    /**
     * 初始化当天的日期
     */
//    public static String initTodayData(Context context) {
//        String CURRENTDATE = Util.getTodayDate();
//        //在创建方法中有判断，如果数据库已经创建了不会二次创建的
//        DbUtils.createDb(context, Constant.DB_NAME);
//
//        //获取当天的数据
//        List<StepData> list = DbUtils.getQueryByWhere(StepData.class, "today", new String[]{CURRENTDATE});
//        if (list.size() == 0 || list.isEmpty()) {
//            //如果获取当天数据为空，则步数为0
//            StepDetector.CURRENT_STEP = 0;
//        } else if (list.size() == 1) {
//            //如果数据库中存在当天的数据那么获取数据库中的步数
//            StepDetector.CURRENT_STEP = Integer.parseInt(list.get(0).getStep());
//        } else {
//            Log.e("TAG===", "出错了！");
//        }
//        return CURRENTDATE;
//    }

//    public static String getStep(Context context) {
//        String stepNub = "0";
//        List<StepData> list;
//        list = DbUtils.getQueryByWhere(StepData.class, "today", new String[]{initTodayData(context)});
//        if (list.size() == 0) {
//            stepNub = "0";
//        } else {
//            stepNub = list.get(0).getStep();
//        }
//        return stepNub;
//    }

    /**
     * 保存当日已有数据
     */
//    public static void saveGoingYSD(Context context, String step) {
//        int tempStep = StepDetector.CURRENT_STEP;
//        List<StepData> list = DbUtils.getQueryByWhere(StepData.class, "today", new String[]{"CURRENTDATE"});
//        if (list.size() == 0 || list.isEmpty()) {
//            StepData data = new StepData();
//            data.setToday(initTodayData(context));
//            data.setStep(step + "");
//            data.setPreviousStep(step + "");
//            DbUtils.insert(data);
//        } else if (list.size() == 1) {
//            //修改数据
//            StepData data = list.get(0);
//            data.setToday(initTodayData(context));
//            data.setStep(step + "");
//            data.setPreviousStep(step + "");
//            DbUtils.update(data);
//        }
//        List<StepData> list11 = DbUtils.getQueryByWhere(StepData.class, "holdStep", new String[]{"CURRENTDATE"});
//    }

    /**
     * 屏幕密度转换
     */
    public static int dip2px(Context context, float dpValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }

    /**
     *
     */
    public static int px2dip(Context context, float pxValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (pxValue / scale + 0.5f);
    }

    public static int printDayOfWeek(Calendar canlendar) {
        int index = 1;
        switch (canlendar.get(Calendar.DAY_OF_WEEK)) {
            case Calendar.SUNDAY:
//                System.out.println("MainActivityFilter" + "今天是周日");
                index = 7;
                break;
            case Calendar.MONDAY:
//                System.out.println("MainActivityFilter" + "今天是周一");
                index = 1;
                break;
            case Calendar.TUESDAY:
//                System.out.println("MainActivityFilter" + "今天是周二");
                index = 2;
                break;
            case Calendar.WEDNESDAY:
//                System.out.println("MainActivityFilter" + "今天是周三");
                index = 3;
                break;
            case Calendar.THURSDAY:
//                System.out.println("MainActivityFilter" + "今天是周四");
                index = 4;
                break;
            case Calendar.FRIDAY:
//                System.out.println("MainActivityFilter" + "今天是周五");
                index = 5;
                break;
            case Calendar.SATURDAY:
//                System.out.println("MainActivityFilter" + "今天是周六");
                index = 6;
                break;
            default:
                break;
        }
        return index;
    }

    /**
     * 获取今天被选中
     *
     * @return
     */
    public static String getCurrentDetailDivision() {
        String currentStr = String.valueOf(System.currentTimeMillis());
        currentStr = currentStr.substring(0, currentStr.length() - 3);
        String strs = serverToClientTimeYearShort(currentStr);
        return strs;
    }

    // 时间转换年月日时分秒
    public static String serverToClientTimeYearShort(String times) {
        if (times == null)
            return "";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        // 前面的lSysTime是秒数，先乘1000得到毫秒数，再转为java.util.Date类型
        Date dt = new Date(Long.parseLong(times) * 1000);
        String sDateTime = sdf.format(dt); // 得到精确到秒的表示：2006-08-31 21:08:00
        return sDateTime;
    }

    public static String getCurrentYMD(String str) {
        String time = "";
        String dataStr = "";
        if (!TextUtils.isEmpty(str)) {
            dataStr = str;
        } else {
            dataStr = String.valueOf(System.currentTimeMillis());
            if (dataStr.length() > 10) {
                dataStr = dataStr.substring(0, 10);
            }
        }
        time = Util.serverToClientTimeYearShort(dataStr);
        return time.substring(0, 10);
    }

    /**
     * 判断是否挂在SD卡
     *
     * @return
     */
    public static boolean hasSdcard() {
        String state = Environment.getExternalStorageState();
        if (Environment.MEDIA_MOUNTED.equals(Environment.getExternalStorageState()) || !Environment.isExternalStorageRemovable()) {
            return true;
        } else {
            return false;
        }
    }

    private static final int REQUEST_EXTERNAL_STORAGE = 1;
    private static String[] PERMISSIONS_STORAGE = {
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.WRITE_EXTERNAL_STORAGE
    };

    public static void verifyStoragePermissions(Activity activity) {
        // Check if we have write permission
        int permission = ActivityCompat.checkSelfPermission(activity, Manifest.permission.WRITE_EXTERNAL_STORAGE);

        if (permission != PackageManager.PERMISSION_GRANTED) {
            // We don't have permission so prompt the user
            ActivityCompat.requestPermissions(
                    activity, PERMISSIONS_STORAGE, REQUEST_EXTERNAL_STORAGE
            );
        }
    }

    /**
     * 获取bitmap
     *
     * @param url
     * @return
     */
    public static Bitmap getBitmap(String url) {
        String loacal = url.replaceAll("\\/", "");
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inSampleSize = 1;
        return BitmapFactory.decodeFile(Environment.getExternalStorageDirectory().getAbsolutePath() + "/" + loacal, options);
    }

    /**
     * 通过uri获取图片并进行压缩
     *
     * @param uri
     */
    public static Bitmap getBitmapFormUri(Activity ac, Uri uri) throws FileNotFoundException, IOException {
        InputStream input = ac.getContentResolver().openInputStream(uri);
        BitmapFactory.Options onlyBoundsOptions = new BitmapFactory.Options();
        onlyBoundsOptions.inJustDecodeBounds = true;
        onlyBoundsOptions.inDither = true;//optional
        onlyBoundsOptions.inPreferredConfig = Bitmap.Config.ARGB_8888;//optional
        BitmapFactory.decodeStream(input, null, onlyBoundsOptions);
        input.close();
        int originalWidth = onlyBoundsOptions.outWidth;
        int originalHeight = onlyBoundsOptions.outHeight;
        if ((originalWidth == -1) || (originalHeight == -1))
            return null;
        //图片分辨率以480x800为标准
        float hh = 800f;//这里设置高度为800f
        float ww = 480f;//这里设置宽度为480f
        //缩放比。由于是固定比例缩放，只用高或者宽其中一个数据进行计算即可
        int be = 1;//be=1表示不缩放
        if (originalWidth > originalHeight && originalWidth > ww) {//如果宽度大的话根据宽度固定大小缩放
            be = (int) (originalWidth / ww);
        } else if (originalWidth < originalHeight && originalHeight > hh) {//如果高度高的话根据宽度固定大小缩放
            be = (int) (originalHeight / hh);
        }
        if (be <= 0)
            be = 1;
        //比例压缩
        BitmapFactory.Options bitmapOptions = new BitmapFactory.Options();
        bitmapOptions.inSampleSize = be;//设置缩放比例
        bitmapOptions.inDither = true;//optional
        bitmapOptions.inPreferredConfig = Bitmap.Config.ARGB_8888;//optional
        input = ac.getContentResolver().openInputStream(uri);
        Bitmap bitmap = BitmapFactory.decodeStream(input, null, bitmapOptions);
        input.close();

        return compressImage(bitmap);//再进行质量压缩
    }

    /**
     * 质量压缩方法
     *
     * @param image
     * @return
     */
    public static Bitmap compressImage(Bitmap image) {

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        image.compress(Bitmap.CompressFormat.JPEG, 100, baos);//质量压缩方法，这里100表示不压缩，把压缩后的数据存放到baos中
        int options = 100;
        while (baos.toByteArray().length / 1024 > 100) {  //循环判断如果压缩后图片是否大于100kb,大于继续压缩
            baos.reset();//重置baos即清空baos
            //第一个参数 ：图片格式 ，第二个参数： 图片质量，100为最高，0为最差  ，第三个参数：保存压缩后的数据的流
            image.compress(Bitmap.CompressFormat.JPEG, options, baos);//这里压缩options%，把压缩后的数据存放到baos中
            options -= 10;//每次都减少10
        }
        ByteArrayInputStream isBm = new ByteArrayInputStream(baos.toByteArray());//把压缩后的数据baos存放到ByteArrayInputStream中
        Bitmap bitmap = BitmapFactory.decodeStream(isBm, null, null);//把ByteArrayInputStream数据生成图片
        return bitmap;
    }

}
