package com.example.kf.thetest.webview;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.EditText;
import android.widget.Toast;

import com.example.kf.thetest.R;

/**
 * Created by kf on 2018/1/31.
 */

public class WebViewTest extends AppCompatActivity implements webviewcookiesback{
    private WebView wb;
    private EditText edInput1, edInput2;
    private JavaScriptObject js;
    private LoadWebviewLogin loadWebviewLogin=null;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webviewtest);
        wb = (WebView) findViewById(R.id.wb);
        edInput1 = (EditText) findViewById(R.id.edInput1);
        edInput2 = (EditText) findViewById(R.id.edInput2);

        js = new JavaScriptObject(this);
        WebSettings ws = wb.getSettings();
//        ws.setJavaScriptCanOpenWindowsAutomatically(true);//可以弹窗
        ws.setJavaScriptEnabled(true);//可以加载js

        wb.getSettings().setDefaultTextEncodingName("utf-8");
        wb.getSettings().setJavaScriptEnabled(true);
        // 设置可以访问文件
        wb.getSettings().setAllowFileAccess(true);
        //如果访问的页面中有Javascript，则webview必须设置支持Javascript
        wb.getSettings().setJavaScriptEnabled(true);
//        wb.getSettings().setUserAgentString(MyApplication.getUserAgent());
        wb.getSettings().setCacheMode(WebSettings.LOAD_NO_CACHE);
        wb.getSettings().setAllowFileAccess(true);
        wb.getSettings().setAppCacheEnabled(true);
        wb.getSettings().setDomStorageEnabled(true);
        wb.getSettings().setDatabaseEnabled(true);
        wb.addJavascriptInterface(js, "myObj");
        String html = "http://www.touna.cn/user-login.html";
//        wb.loadUrl(html);
        loadWebviewLogin=new LoadWebviewLogin(this,this);

//        wb.loadUrl("file:///android_asset/demo.html");
//        wb.loadUrl("http://www.touna.cn/user-login.html");
        initWeb();
    }

    private void syncCookie(Context context, String url,String cookies) {
        CookieSyncManager.createInstance(context);
        CookieManager cookieManager = CookieManager.getInstance();
        cookieManager.setAcceptCookie(true);
        cookieManager.removeSessionCookie();//移除
        cookieManager.setCookie(url, cookies);//cookies是在HttpClient中获得的cookie
        CookieSyncManager.getInstance().sync();
    }

    private void initWeb() {
        wb.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {//7.0以下
                Log.w("webview====sol", url);
                return super.shouldOverrideUrlLoading(view, url);
            }

            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                return super.shouldOverrideUrlLoading(view, request);
            }

            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                Log.w("webview==onPageStarted", url);
                super.onPageStarted(view, url, favicon);
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                Log.w("webview==onPageFinished", url);
                super.onPageFinished(view, url);
            }

            @Override
            public void onLoadResource(WebView view, String url) {
                Log.w("webview==onLoadResource", url);
                super.onLoadResource(view, url);
                CookieManager cookiemanager = CookieManager.getInstance();
                String dfdf=cookiemanager.getCookie(url);
                if(!TextUtils.isEmpty(dfdf)){
                    Log.w("cookie==", dfdf);
                    if (url.contains("account/account")) {
                        syncCookie(WebViewTest.this, url,dfdf);
                        loadWebviewLogin.syncCookie(WebViewTest.this, url,dfdf);
                    }
                }
            }
            @Override
            public void onPageCommitVisible(WebView view, String url) {
                Log.w("webview==onPtVisible", url);
                super.onPageCommitVisible(view, url);
            }


        });
    }

    @Override
    public void getCookie(String cookies) {
        Toast.makeText(this,cookies,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void getErro() {

    }
}
