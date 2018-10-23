package com.example.kf.thetest.webview;

/**
 * Created by kf on 2018/1/31.
 */

import android.graphics.Bitmap;
import android.net.http.SslError;
import android.os.Build;
import android.os.Bundle;
import android.os.Message;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.webkit.JavascriptInterface;
import android.webkit.SslErrorHandler;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.example.kf.thetest.R;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;

public class JSoupHtmlActivity extends AppCompatActivity {

    //assets下的文件的JsoupParHtml.html所在的绝对路径
//    private static final String DEFAULT_URL = "file:///android_asset/JsoupParHtml.html";
//    private static final String DEFAULT_URL = "file:///android_asset/demo.html";
    private static final String URL = "https://m.touna.cn/new/index.html#/login";
    //    private static final String URL = "https://www.touna.cn/user-login.html";
//https://www.touna.cn/user-login.html
//    String dfdf="http://www.touna.cn/?utm_source=SEM-bdpz-pc&utm_medium=cpt&utm_campaign=title";
//                                                app/src/main/asset/JsoupParHtml.html
    private int ERROR = -1;
    private int NONE = 0;
    private int PASSWORD = 2;
    private int USERNAME = 1;
    WebView webView;
    CookieManager cookiemanager;
    List<String> list = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webviewtest);
        webView = (WebView) findViewById(R.id.wb);
        CookieSyncManager.createInstance(webView.getContext());
        CookieSyncManager.getInstance().sync();
        cookiemanager = CookieManager.getInstance();
//        String cookie=cookiemanager.getCookie(dfdf);
//        Log.e("loginWeb===",cookie);
        initData();
    }

    public void buttonClick(View view) {
        webView.loadUrl("javascript:window.local_obj.showSource('<head>'+"
                + "document.getElementsByTagName('html')[0].innerHTML+'</head>');");

//        webView.loadUrl("javascript:window.local_obj.getHTML('<html>'+document.body.innerHTML+'</html>');");
    }

    private void initData() {
        //下面三行设置主要是为了待webView成功加载html网页之后，我们能够通过webView获取到具体的html字符串
        webView.getSettings().setJavaScriptEnabled(true);
//        webView.addJavascriptInterface(new JavaScriptInterface(), "local_obj");
        webView.addJavascriptInterface(new InJavaScriptLocalObj(), "local_obj");
        webView.setWebChromeClient(new WebChromeClient() {
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                super.onProgressChanged(view, newProgress);
            }

            @Override
            public void onReceivedTitle(WebView view, String title) {
                super.onReceivedTitle(view, title);
            }
        });
        webView.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                Log.i("HTMLurl====", url);
                super.onPageStarted(view, url, favicon);
            }

            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                Log.i("HTMLurl====", url);
                view.loadUrl(url);
                return true;
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                String cookie = cookiemanager.getCookie(url);
                if (!TextUtils.isEmpty(cookie)) {
                    String cookies = getCoocieList(cookie);
                    if (!TextUtils.isEmpty(cookies)) {
                        if (!list.contains(cookies)) {
                            list.add(cookies);
                        }
                    }
                }
                String dfd="";
                for (int i = 0; i < list.size(); i++) {
                    dfd=dfd+","+list.get(i);
                }
                Log.e("onPageFinished===", dfd+"**"+url);
                view.loadUrl("javascript:window.local_obj.getHTML('<head>'+"
                        + "document.getElementsByTagName('html')[0].innerHTML+'</head>');");

//                view.loadUrl("javascript:window.local_obj.getHTML('<html>'+document.body.innerHTML+'</html>');");
            }

            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                return super.shouldOverrideUrlLoading(view, request);
            }

            @Override
            public void onLoadResource(WebView view, String url) {
//                getHtml();
                Log.e("logonLoadResource-->", "onLoadResource-->>" + url);
                super.onLoadResource(view, url);
            }

            @Override
            public void onPageCommitVisible(WebView view, String url) {
                super.onPageCommitVisible(view, url);
            }

            @Override
            public WebResourceResponse shouldInterceptRequest(WebView view, String url) {
                String cookie = cookiemanager.getCookie(url);
//                if (!TextUtils.isEmpty(cookie)) {
                    Log.e("loginWeb===Response", url);
//                }
//                Log.e("cookie======",url);
                return super.shouldInterceptRequest(view, url);
            }

            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public WebResourceResponse shouldInterceptRequest(WebView view, WebResourceRequest request) {
                request.getUrl().toString();
                return super.shouldInterceptRequest(view, request);
            }

            @Override
            public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error) {
                super.onReceivedError(view, request, error);
            }

            @Override
            public void onReceivedHttpError(WebView view, WebResourceRequest request, WebResourceResponse errorResponse) {
                super.onReceivedHttpError(view, request, errorResponse);
            }

            @Override
            public void onFormResubmission(WebView view, Message dontResend, Message resend) {
                super.onFormResubmission(view, dontResend, resend);
            }

            @Override
            public void onReceivedError(WebView view, int errorCode,
                                        String description, String failingUrl) {
                super.onReceivedError(view, errorCode, description, failingUrl);
            }

            @Override
            public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error) {
//                super.onReceivedSslError(view, handler, error);
                handler.proceed();
            }

        });
        webView.loadUrl(URL);
    }

    final class InJavaScriptLocalObj {
        @JavascriptInterface
        public void showSource(String html) {
            refreshHtmlContent(html);
        }
    }


    private void refreshHtmlContent(final String html) {
        Log.i("网页内容", html);
        webView.postDelayed(new Runnable() {
            @Override
            public void run() {
                //解析html字符串为对象
                Document document = Jsoup.parse(html);
                Elements dfdfd = document.getAllElements();
                Elements login = document.getElementsByClass("loginbox");
                Element loginId = login.get(0).getElementById("uname");
                loginId.getElementsByAttribute("value").attr("value", "1234567890-=");


                //获取进行处理之后的字符串并重新加载
                String body = document.toString();
                webView.loadDataWithBaseURL(null, body, "text/html", "utf-8", null);

//                //解析html字符串为对象
//                Document document = Jsoup.parse(html);
//                //通过类名获取到一组Elements，获取一组中第一个element并设置其html
//                Elements elements = document.getElementsByClass("loadDesc");
//                elements.get(0).html("<p>加载完成</p>");
////                elements.get(1).text("输入");
//
//                //通过ID获取到element并设置其src属性
//                Element element = document.getElementById("imageView");
////                element.attr("src","file:///android_asset/dragon.png");
//
//                //通过类名获取到一组Elements，获取一组中第一个element并设置其文本
//                elements = document.select("p.hint");
//                elements.get(0).text("您好，我是龙猫军团！");
//
//                //获取进行处理之后的字符串并重新加载
//                String body = document.toString();
//                webView.loadDataWithBaseURL(null, body, "text/html", "utf-8", null);
            }
        }, 2000);
    }

    final class JavaScriptInterface {
        String mPassword;
        String mUsername;

        @JavascriptInterface
        public void getHTML(final String html) {
            saveUserDataWebView(webView, html);
        }
    }
    private void getHtml() {
        webView.loadUrl("javascript:window.android.getHTML('<html>'+document.body.innerHTML+'</html>');");
    }

    private void saveUserDataWebView(final WebView webView, String html) {
        Document document = Jsoup.parse(html);
        Elements elements = document.select("input");
        boolean isContainsPassword = false;
        for (Element element : elements) {
            String type = element.attr("type");

            if ("password".equals(type)) {
                isContainsPassword = true;
                break;
            }
        }


        if (!isContainsPassword) {
            return;
        }

        for (final Element element : elements) {
            final String className = element.className();
            final String type = element.attr("type");
            webView.post(new Runnable() {
                @Override
                public void run() {
                    Log.e("this element id is = ", element.attr("id") + " type = " + type);
                    String id = element.attr("id");
                    if (filterData(type, id)) {
                        int handType = handleType(type);
                        if (handType == NONE) {
                            handType = handleId(id);
                            if (handType == NONE) {
                                handleClassName(className);
                            }
                        }

                        switch (handType) {
                            case 2:
                                if (id == null) {

                                } else {
                                    savePasswordById(id, webView);
                                }


                                break;
                            case 1:
                                if (id == null) {

                                } else {
                                    saveUsernameById(id, webView);
                                }

                                break;
                            case 0:

                                break;
                        }
                    }

                }
            });

        }
    }

    private int handleClassName(String className) {
        if (className == null) {
            return ERROR;
        }

        if (className.contains("password")) {
            return PASSWORD;
        }

        if (className.contains("captcha")) {
            return ERROR;
        }


        return USERNAME;
    }


    private boolean filterData(String type, String id) {
        if ("captcha".equals(type)) {
            return false;
        } else if ("login_vcode".equals(type)) {
            return false;
        } else if ("button".equals(type)) {
            return false;
        } else if ("hidden".equals(type)) {
            return false;
        } else if ("submit".equals(type)) {
            return false;
        } else if ("checkbox".equals(type)) {
            return false;
        } else if ("captcha".equals(id)) {
            return false;
        } else if ("inp_ChkCode".equals(id)) {
            return false;
        } else {
            return true;
        }
    }


    private int handleId(String id) {
        if (id == null) {
            return NONE;
        }

        if (id.contains("captcha")) {
            return ERROR;
        }

        if (id.contains("password")) {
            return PASSWORD;
        }

        if (id.contains("Phone")) {
            return USERNAME;
        }

        if (id.contains("username")) {
            return USERNAME;
        }

        if (id.contains("code")) {
            return ERROR;
        }


        return USERNAME;
    }

    private int handleType(String type) {
        if (type == null) {
            return NONE;
        }

        if (type.contains("tel")) {
            return ERROR;
        }

        if (type.contains("pwd")) {
            return PASSWORD;
        }

        if (type.contains("password")) {
            return PASSWORD;
        }


        return NONE;
    }

    private void saveUsernameById(String id, WebView webView) {
        webView.loadUrl("javascript:window.local_obj.save_username(document.getElementById('" + id + "').value)");
    }

    private void savePasswordById(String id, WebView webView) {
        webView.loadUrl("javascript:window.local_obj.save_password(document.getElementById('" + id + "').value)");
    }

    private String getCoocieList(String str) {
        String getStr = "";
        if (!TextUtils.isEmpty(str)) {
            String[] arrs = str.split(";");
            for (int i = 0; i < arrs.length; i++) {
                if (arrs[i].contains("sid")) {
                    getStr = arrs[i];
                }
            }
        }
        return getStr;
    }
}
