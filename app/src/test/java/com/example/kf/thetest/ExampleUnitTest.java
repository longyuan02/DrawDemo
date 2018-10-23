package com.example.kf.thetest;

import android.os.Build;
import android.support.annotation.RequiresApi;
import android.text.TextUtils;

import org.junit.Test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    private int year;
    private int month;
    private int date;
    @RequiresApi(api = Build.VERSION_CODES.N)
    @Test
    public void addition_isCorrect() throws Exception {
        assertEquals(4, 2 + 2);
//        Calendar cd = Calendar.getInstance();
//        cd.setTime(ConverToDate("2018-1-1"));
//        int year = cd.get(Calendar.YEAR);
//        int month = cd.get(Calendar.MONTH)+1;
//        int date = cd.get(Calendar.DATE);
////        cd.getWeekYear();
//        System.out.println("data==" + date + "**" + month+"**"+year+"-"+month+"-"+date);
////        Calendar a = Calendar.getInstance();
////        cd.set(Calendar.DATE, 1);
////        cd.roll(Calendar.DATE, -1);
//        int maxDate = cd.get(Calendar.DATE);
//        System.out.println("data==" + year + "**" + maxDate + "***");
//        printDayOfWeek();
        Calendar ca = Calendar.getInstance();//得到一个Calendar的实例 ca.setTime(new Date()); //设置时间为当前时间
//        ca.add(Calendar.YEAR, -1); //年份减1
        ca.add(Calendar.MONTH, +1); //年份减1
        Date lastMonth = ca.getTime(); //结果
        ConverToString(lastMonth);
        getCurrentTime();
        System.out.println("currenttime="+System.currentTimeMillis());
//        System.out.println("data==" + year + "**" + getCurrentTime() + "***"+printDayOfWeek()+"lastMonth："+ConverToString(lastMonth)+"currenttime="+System.currentTimeMillis());
    }

    /**
     * 获取当前时间
     * @return
     */
    @RequiresApi(api = Build.VERSION_CODES.N)
    private String getCurrentTime() {
        Calendar cd = Calendar.getInstance();
        year = cd.get(Calendar.YEAR);
        month = cd.get(Calendar.MONTH) + 1;
        date = cd.get(Calendar.DATE);
        return getCurrentTimeStr("");
    }

    /**
     *获取当前时间str格式
     * @return
     */
    private String getCurrentTimeStr(String str) {//非空为本月一日周几
        String monthstr = "";
        String datestr = "";
        String alltime="";
        if (month < 10) {
            monthstr = "0" + String.valueOf(month);
        } else {
            monthstr = String.valueOf(month);
        }
        if (date < 10) {
            datestr = "0" + String.valueOf(date);
        }else {
            datestr = String.valueOf(date);
        }
        if(str==null||str.equals("")){
            alltime=String.valueOf(year)+"-"+datestr+"-"+datestr;
        }else {
            alltime=String.valueOf(year)+"-"+datestr+"-"+str;
        }
        return alltime;
    }

    //把字符串转为日期
    public Date ConverToDate(String strDate) throws Exception {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");//
        return df.parse(strDate);
    }
    public String ConverToString(Date date){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        System.out.println(sdf.format(date));
//        sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        System.out.println(sdf.format(date));
//        sdf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
//        System.out.println(sdf.format(date));
        return sdf.format(date);
    }

    /**
     * 获取当月最大天数
     *
     * @param cd
     * @return
     */
    @RequiresApi(api = Build.VERSION_CODES.N)
    private int getMaxDate(Calendar cd) {
        cd.set(Calendar.DATE, 1);
        cd.roll(Calendar.DATE, -1);
        int maxDate = cd.get(Calendar.DATE);
        return maxDate;
    }

    /**
     * 切换时设置时间
     */
    @RequiresApi(api = Build.VERSION_CODES.N)
    private void setCanledarDate(Calendar cd, String time) {
        try {
            cd.setTime(ConverToDate("time"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private int printDayOfWeek(){
        int index = 1;
        Calendar cd = Calendar.getInstance();
        try {
            cd.setTime(ConverToDate(getCurrentTimeStr("1")));
        } catch (Exception e) {
            e.printStackTrace();
        }
        switch (cd.get(Calendar.DAY_OF_WEEK)) {
            case Calendar.SUNDAY:
                System.out.println("MainActivityFilter" + "今天是周日");
                index = 7;
                break;
            case Calendar.MONDAY:
                System.out.println("MainActivityFilter" + "今天是周一");
                index = 1;
                break;
            case Calendar.TUESDAY:
                System.out.println("MainActivityFilter" + "今天是周二");
                index = 2;
                break;
            case Calendar.WEDNESDAY:
                System.out.println("MainActivityFilter" + "今天是周三");
                index = 3;
                break;
            case Calendar.THURSDAY:
                System.out.println("MainActivityFilter" + "今天是周四");
                index = 4;
                break;
            case Calendar.FRIDAY:
                System.out.println("MainActivityFilter" + "今天是周五");
                index = 5;
                break;
            case Calendar.SATURDAY:
                System.out.println("MainActivityFilter" + "今天是周六");
                index = 6;
                break;
            default:
                break;
        }
        return index;
    }
}