package com.example.kf.thetest.webview;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

/**
 * Created by kf on 2018/4/3.
 */

public class LoadWebviewLogin {
    private WebView wb;
    private Context context;
    private String cookies = "";
    private webviewcookiesback cookiesback;

    public LoadWebviewLogin(Context context, webviewcookiesback webviewcookiesback) {
        this.cookiesback = webviewcookiesback;
        this.context = context;
        this.cookies = "";
        wb = new WebView(context);
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
        String html = "http://www.touna.cn/user-login.html";
        wb.loadUrl(html);
        initWeb();
    }

    private void initWeb() {
        wb.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {//7.0以下
                Log.w("LoadWebviewLogin====sol", url);
                return super.shouldOverrideUrlLoading(view, url);
            }

            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                return super.shouldOverrideUrlLoading(view, request);
            }

            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                Log.w("LoadWebviewLogin==onPageStarted", url);
                super.onPageStarted(view, url, favicon);
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                Log.w("LoadWebviewLogin==onPageFinished", url);
                if (cookiesback != null) {
                    if (!TextUtils.isEmpty(cookies)) {
                        cookiesback.getCookie(cookies);
                    } else {
                        cookiesback.getErro();
                    }
                }

                super.onPageFinished(view, url);
            }

            @Override
            public void onLoadResource(WebView view, String url) {
                Log.w("LoadWebviewLogin==onLoadResource", url);
                super.onLoadResource(view, url);
                if (url.contains("account/account")) {
                    CookieManager cookiemanager = CookieManager.getInstance();
                    cookies = cookiemanager.getCookie(url);
                    Log.w("LoadWebviewLogincookie==", cookies);
                    if (!TextUtils.isEmpty(cookies)) {
                        syncCookie(context, url, cookies);
                    }
                }
            }

            @Override
            public void onPageCommitVisible(WebView view, String url) {
                Log.w("LoadWebviewLogin==onPtVisible", url);
                super.onPageCommitVisible(view, url);
            }

        });
    }

    public void syncCookie(Context context, String url, String cookies) {
        CookieSyncManager.createInstance(context);
        CookieManager cookieManager = CookieManager.getInstance();
        cookieManager.setAcceptCookie(true);
        cookieManager.removeSessionCookie();//移除
        cookieManager.setCookie(url, cookies);//cookies是在HttpClient中获得的cookie
        CookieSyncManager.getInstance().sync();
    }
}
