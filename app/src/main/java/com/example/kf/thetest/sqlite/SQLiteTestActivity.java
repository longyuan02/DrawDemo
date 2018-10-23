package com.example.kf.thetest.sqlite;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.example.kf.thetest.R;

/**
 * Created by kf on 2018/4/8.
 */

public class SQLiteTestActivity extends AppCompatActivity{
    private SimplePersonService personService = null;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sqlite);
        DbHelper db = new DbHelper(this, Constant.TAG_SQLITETEST, null, 2);
        db.getWritableDatabase();
        personService = new SimplePersonService(this);
    }
    public void clickSave(View view){
        PlatformMessage platformMessage=new PlatformMessage();
        for (int i = 0; i < 5; i++) {
            platformMessage.setUserName("12345"+i);
            platformMessage.setPassword("simple"+i);
            platformMessage.setPlatformId("20"+i);
            platformMessage.setSaveTime("111111");
            personService.save(platformMessage);
        }
    }
    public void getValue(View view){
//        personService.getCount();
//        PlatformMessage ddff=personService.findById(2);
//        Log.i(Constant.TAG_SQLITETEST, personService.getCount()+ "");
//        boolean dfd=personService.filtrationData("123459");
//        if(personService.filtrationData("123453")){
//        PlatformMessage platformMessage=new PlatformMessage();
//        platformMessage.setUserName("123454");
//        platformMessage.setPassword("simple50");
//        platformMessage.setPlatformId("204");
//        platformMessage.setSaveTime("11111150");
//            personService.update(platformMessage);
//        }
//        PlatformMessage dfdf=personService.findByCondition("123458");
        boolean dfdf=personService.filtrationData("123457","207");
        PlatformMessage ddd=personService.findByCondition("123454","204");
//        Log.i(Constant.TAG_SQLITETEST,ddd.getPassword()+ "*"+ddd.getPlatformId()+ "*"+ddd.getUserName()+ "*"+ddd.getSaveTime()+ "*");
            Log.i(Constant.TAG_SQLITETEST,dfdf+"");
    }
}
