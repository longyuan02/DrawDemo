package com.example.kf.thetest.calendar;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;

import com.example.kf.thetest.R;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by kf on 2018/1/23.
 */

public class CalendarActivity extends AppCompatActivity {
    private Calendar canlendar;
    private RecyclerView rlv;
    private int year;
    private int month;
    private int date;
    private List<CalendarData> list=new ArrayList<CalendarData>();
    private CalendarAdapter adapter=null;
    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);
        rlv = (RecyclerView) findViewById(R.id.rlv);
        canlendar = Calendar.getInstance();
        getCurrentTime();
        canlendar.add(Calendar.MONTH,-1);
        printDayOfWeek();
        for (int i = 0; i < getMaxDate(canlendar) + printDayOfWeek()+1; i++) {
            CalendarData c = new CalendarData();
            if(i>printDayOfWeek()){
                c.setDate(String.valueOf(i-printDayOfWeek()));
                c.setSelecte("0");
                c.setRecord("1");
                list.add(c);
            }else {
                c.setDate(String.valueOf(getMaxDate(canlendar)-i));
                c.setSelecte("0");
                c.setRecord("0");
                list.add(c);
            }

        }
        rlv.setLayoutManager(new GridLayoutManager(this,7));
        adapter=new CalendarAdapter(this);
        adapter.setList(list);
        rlv.setAdapter(adapter);
    }

    /**
     * 获取当前时间
     * @return
     */
    @RequiresApi(api = Build.VERSION_CODES.N)
    private String getCurrentTime() {
        Calendar cd = Calendar.getInstance();
        year = cd.get(java.util.Calendar.YEAR);
        month = cd.get(java.util.Calendar.MONTH) + 1;
        date = cd.get(java.util.Calendar.DATE);
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
        if(!TextUtils.isEmpty(str)){
            alltime=String.valueOf(year)+"-"+datestr+"-"+str;
        }else {
            alltime=String.valueOf(year)+"-"+datestr+"-"+datestr;
        }
        return alltime;
    }

    //把字符串转为日期
    public Date ConverToDate(String strDate) throws Exception {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");//
        return df.parse(strDate);
    }

    /**
     * 获取当月最大天数
     *
     * @param cd
     * @return
     */
    @RequiresApi(api = Build.VERSION_CODES.N)
    private int getMaxDate(Calendar cd) {
        cd.set(java.util.Calendar.DATE, 1);
        cd.roll(java.util.Calendar.DATE, -1);
        int maxDate = cd.get(java.util.Calendar.DATE);
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
        int index = 0;
        java.util.Calendar cd = java.util.Calendar.getInstance();
        try {
            cd.setTime(ConverToDate(getCurrentTimeStr("1")));
        } catch (Exception e) {
            e.printStackTrace();
        }
        switch (cd.get(java.util.Calendar.DAY_OF_WEEK)) {
            case java.util.Calendar.SUNDAY:
                System.out.println("MainActivityFilter" + "今天是周日");
                index = 6;
                break;
            case java.util.Calendar.MONDAY:
                System.out.println("MainActivityFilter" + "今天是周一");
                index = 0;
                break;
            case java.util.Calendar.TUESDAY:
                System.out.println("MainActivityFilter" + "今天是周二");
                index = 1;
                break;
            case java.util.Calendar.WEDNESDAY:
                System.out.println("MainActivityFilter" + "今天是周三");
                index = 2;
                break;
            case java.util.Calendar.THURSDAY:
                System.out.println("MainActivityFilter" + "今天是周四");
                index = 3;
                break;
            case java.util.Calendar.FRIDAY:
                System.out.println("MainActivityFilter" + "今天是周五");
                index = 4;
                break;
            case java.util.Calendar.SATURDAY:
                System.out.println("MainActivityFilter" + "今天是周六");
                index = 5;
                break;
            default:
                break;
        }
        return index;
    }
}
