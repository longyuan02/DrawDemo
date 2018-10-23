package com.example.kf.thetest.calendar;

import java.io.Serializable;

/**
 * Created by kf on 2018/1/23.
 */

public class CalendarData implements Serializable {
    private String time;
    private String selecte;
    private String date;
    private String record;

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getSelecte() {
        return selecte;
    }

    public void setSelecte(String selecte) {
        this.selecte = selecte;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getRecord() {
        return record;
    }

    public void setRecord(String record) {
        this.record = record;
    }
}
