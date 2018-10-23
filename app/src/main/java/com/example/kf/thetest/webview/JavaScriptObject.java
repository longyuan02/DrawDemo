package com.example.kf.thetest.webview;

import android.content.Context;
import android.webkit.JavascriptInterface;
import android.widget.Toast;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

/**
 * Created by kf on 2018/1/31.
 */

public class JavaScriptObject {
    Context mContxt;
    public JavaScriptObject(Context mContxt) {
        this.mContxt = mContxt;
    }
    @JavascriptInterface
    public void fun2(String name,String psd) {
        Toast.makeText(mContxt, "账号："+name+" 密码："+psd, Toast.LENGTH_LONG).show();
        Document document = Jsoup.parse("");
    }

}
