package com.example.kf.thetest.languageexchange;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;

import com.example.kf.thetest.R;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    ImageButton btn_settings;
    AlertDialog dialog;
    private LanguagnSetTools languagnSetTools=null;

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        //读取SharedPreferences数据，初始化语言设置

        getSupportActionBar().hide();
        setContentView(R.layout.activity_language);
        languagnSetTools=new LanguagnSetTools(this);
        languagnSetTools.setLanguage();
        btn_settings = (ImageButton) findViewById(R.id.btn_settings);

        //点击设置按钮进入语言设置
        btn_settings.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {

                //创建单选框
                final AlertDialog.Builder builder = new
                        AlertDialog.Builder(MainActivity.this);
                builder.setSingleChoiceItems(new String[]{"Auto", "简体中文"},
                        getSharedPreferences("language", Context.MODE_PRIVATE).getInt("language",0),
                        new DialogInterface.OnClickListener() {
                            //点击单选框某一项以后
                            public void onClick(DialogInterface dialogInterface, int i) {

                                //将选中项存入SharedPreferences，以便重启应用后读取设置
//                                SharedPreferences preferences = getSharedPreferences("language", Context.MODE_PRIVATE);
//                                SharedPreferences.Editor editor = preferences.edit();
//                                editor.putInt("language",i);
//                                editor.apply();
                                Log.i("setLanguage===",i+"");
                                languagnSetTools.resetLanguage(i);
                                dialog.dismiss();

                                Intent intent = new Intent(MainActivity.this, MainActivity.class);
                                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                                startActivity(intent);

                                /* 重新在新的任务栈开启新应用
                                Intent intent = new Intent(MainActivity.this, MainActivity.class);
                                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                                startActivity(intent);
                                android.os.Process.killProcess(android.os.Process.myPid()); */
                            }
                        });

                dialog = builder.create();
                dialog.show();
            }
        });

    }


    private void setLanguage() {
        //读取SharedPreferences数据，默认选中第一项
        SharedPreferences preferences = getSharedPreferences("language", Context.MODE_PRIVATE);
        int language = preferences.getInt("language", 0);

        //根据读取到的数据，进行设置
        Resources resources = getResources();
        DisplayMetrics displayMetrics = resources.getDisplayMetrics();
        Configuration configuration = resources.getConfiguration();

        switch (language){
            case 0:
                configuration.setLocale(Locale.getDefault());
                break;
            case 1:
                configuration.setLocale( Locale.CHINESE);
                break;
            case 2:
                configuration.setLocale(Locale.TAIWAN);
                break;
            default:
                break;
        }

        resources.updateConfiguration(configuration,displayMetrics);

    }

}