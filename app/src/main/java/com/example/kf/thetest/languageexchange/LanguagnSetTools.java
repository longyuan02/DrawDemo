package com.example.kf.thetest.languageexchange;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.util.Log;

import java.util.Locale;

public class LanguagnSetTools {
    private Context lContext;
    private SharedPreferences preferences = null;

    public LanguagnSetTools(Context context) {
        this.lContext = context;
        preferences = context.getSharedPreferences("language", Context.MODE_PRIVATE);

    }

    public void resetLanguage(int type) {
        SharedPreferences.Editor editor = preferences.edit();
        editor.putInt("language", type);
        editor.commit();
    }

    public void setLanguage() {
        //读取SharedPreferences数据，默认选中第一项
        int language = preferences.getInt("language", 0);
        Log.i("setLanguage=TT==",language+"");
        //根据读取到的数据，进行设置
        Resources resources = lContext.getResources();
        DisplayMetrics displayMetrics = resources.getDisplayMetrics();
        Configuration configuration = resources.getConfiguration();

        switch (language){
            case 0:
                configuration.setLocale(Locale.getDefault());
                break;
            case 1:
                configuration.setLocale( Locale.US);
                break;
            case 2:
                configuration.setLocale(Locale.TAIWAN);
                break;
            default:
                break;
        }

        resources.updateConfiguration(configuration, displayMetrics);

    }
}
