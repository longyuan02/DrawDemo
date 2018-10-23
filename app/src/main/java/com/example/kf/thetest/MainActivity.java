package com.example.kf.thetest;

import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.RadioButton;

import com.prolificinteractive.materialcalendarview.CalendarDay;
import com.prolificinteractive.materialcalendarview.CalendarMode;
import com.prolificinteractive.materialcalendarview.MaterialCalendarView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {
    private MyBroadcastReceiver receiver;
    private MaterialCalendarView calendarView;
    private RadioButton rd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        calendarView = (MaterialCalendarView) findViewById(R.id.calendarView);
        rd= (RadioButton) findViewById(R.id.rd);
//        Intent i = new Intent(this, MyService.class);
//        startService(i);
        IntentFilter filter = new IntentFilter(Intent.ACTION_TIME_TICK);
        receiver = new MyBroadcastReceiver();
        registerReceiver(receiver, filter);
        rd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e("sssss",rd.isChecked()+"***"+rd.isSelected());
                if(rd.isSelected()){
                    rd.setSelected(false);
                    rd.setChecked(false);
                }else {
                    rd.setSelected(true);
                    rd.setChecked(true);
                }
            }
        });


//        CalendarDay today = CalendarDay.from(2016, 5, 2);
//        calendarView.setCurrentDate(today);
//        calendarView.setSelectedDate(today);

//        try {
//            dfdf();
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
        try {
            dfdf();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    private void dfdf() throws ParseException {
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH) + 1;
        int date = calendar.get(Calendar.DATE);
        SimpleDateFormat sdf = new SimpleDateFormat("yyMMdd");
        Date date1 = null;
        date1 = sdf.parse(String.valueOf(year) + String.valueOf(month) + String.valueOf(date) + "");
        CalendarDay today = CalendarDay.from(year, month, date);
        calendarView.setSelectedDate(today);
        calendarView.state().edit()
                .setFirstDayOfWeek(Calendar.WEDNESDAY)
                .setMinimumDate(CalendarDay.from(2017, 11, 3))
                .setMaximumDate(CalendarDay.from(2017, 11, 12))
                .setCalendarDisplayMode(CalendarMode.MONTHS)
                .commit();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(receiver);
    }
}
