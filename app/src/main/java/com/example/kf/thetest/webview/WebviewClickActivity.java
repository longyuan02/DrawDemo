package com.example.kf.thetest.webview;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.http.SslError;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
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
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.kf.thetest.R;

import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by kf on 2018/3/2.
 */

public class WebviewClickActivity extends AppCompatActivity {
    //    private static final String DEFAULT_URL = "file:///android_asset/JsoupParHtml.html";
    //    private static final String DEFAULT_URL = "file:///android_asset/demo.html";
    private static final String DEFAULT_URL = "file:///android_asset/js.js";
    //    private static final String URLS = "https://www.touna.cn/user-login.html";
    private static final String URLS = "https://login.yirendai.com/auth/tologin?";
    //    private static final String URLS="https://www.touna.cn/loginvc.do?t=1520416882&code=undefined";
    private int ERROR = -1;
    private int NONE = 0;
    private int PASSWORD = 2;
    private int USERNAME = 1;
    private ImageView imgAA;
    WebView webView, wbImage;
    CookieManager cookiemanager;
    List<String> list = new ArrayList<String>();
    EditText edInput2, edInput3;
    boolean isture = true;
    TextView tvCli, tvCli2;
    private Bitmap bitmap;
    //js文本
    private String wholeJS = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webviewtest);
        edInput2 = (EditText) findViewById(R.id.edInput2);
        edInput3 = (EditText) findViewById(R.id.edInput3);
        imgAA = (ImageView) findViewById(R.id.imgAA);
        webView = (WebView) findViewById(R.id.wb);
        wbImage = (WebView) findViewById(R.id.wbImage);
        tvCli = (TextView) findViewById(R.id.tvCli);
        tvCli2 = (TextView) findViewById(R.id.tvCli2);
        webView.getSettings().setDefaultTextEncodingName("UTF-8");
        webView.loadDataWithBaseURL(null, URLS, "text/html", "utf-8", null);
        WebSettings webSettings = webView.getSettings();

        // 设置与Js交互的权限
        webSettings.setJavaScriptEnabled(true);
        webSettings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN); //支持内容重新布局
        // 设置允许JS弹窗
        webSettings.setJavaScriptCanOpenWindowsAutomatically(true);
        webSettings.setAllowFileAccessFromFileURLs(true);
        webSettings.setAllowUniversalAccessFromFileURLs(true);
        webSettings.setAllowContentAccess(true);
        webSettings.setBlockNetworkImage(false);
        webSettings.setAllowFileAccess(true);//访问文件
        webView.getSettings().setRenderPriority(WebSettings.RenderPriority.HIGH);
        webView.getSettings().setCacheMode(WebSettings.LOAD_NO_CACHE);  //设置 缓存模式网络获取
        // 开启 DOM storage API 功能
        webView.getSettings().setDomStorageEnabled(true);
        //开启 database storage API 功能
        webView.getSettings().setDatabaseEnabled(true);
        //开启 Application Caches 功能
        webView.getSettings().setAppCacheEnabled(true);

        webView.getSettings().setUseWideViewPort(true);
        webView.getSettings().setLoadWithOverviewMode(true);

        CookieSyncManager.createInstance(webView.getContext());
        CookieSyncManager.getInstance().sync();
        cookiemanager = CookieManager.getInstance();
        cookiemanager.removeAllCookie();
        CookieSyncManager.getInstance().sync();
//        AndroidDriver fdfdf = new AndroidDriver("http://localhost:8888/wd/hub");
        initData();
        getImage(URLS);
        tvCli.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public void onClick(View v) {
//                webView.loadUrl("javascript:window.local_obj.getLabel(" + "$(\".out-tips label\").text())");
                innerHtml();
                addJs();
                webView.loadUrl("javascript:" + "js()");
                webView.loadUrl("javascript:" + "binding()");
                webView.loadUrl("javascript:" + "margin()");
            }
        });
        tvCli2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                webView.loadUrl("javascript:" + "margin()");
//                webView.loadUrl("javascript:" + "binding()");

            }
        });
    }

    public void buttonClick(View view) {
        String name = edInput2.getText().toString().trim();
        String password = edInput3.getText().toString().trim();
        innerHtml();
//        webView.clearCache(true);
//        webView.loadUrl("javascript:" + "document.getElementById('uname').value=17338119840" + ";"
//                + "document.getElementById('upwd').value=1qaz2wsx" + ";"
//                +"document.getElementById('btn_login').click();");
//        try {
////            name= URLDecoder.decode(name, "UTF-8");
//            name= URLEncoder.encode(name, "GBK");
//        } catch (UnsupportedEncodingException e) {
//            e.printStackTrace();
//        }
//        webView.loadUrl("javascript:" + "document.getElementById('uname').value=\'"+ name + "\';"
//                +"document.getElementById('upwd').value=\'"+password+ "\';"+
//                "document.getElementById('btn_login').click();"
//        );
//        webView.loadUrl("javascript:" + "document.getElementById('uname').value=\'" + name + "\';");
//
//        webView.loadUrl("javascript:"+"$(\"#inpntCode\").text('767676');");
//        (myFunction('"+answerString+"'));");
//        refreshHtmlContent(URL);
    }

    public void buttonClick2(View view) {
        webView.loadUrl("javascript:" + "document.getElementById('upwd').value=1qaz2wsx" + ";");
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
                Log.i("onPageStarted====", url);
                super.onPageStarted(view, url, favicon);
            }

            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                Log.i("shouldOeUrlLoading====", url);
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
                String dfd = "";
                for (int i = 0; i < list.size(); i++) {
                    dfd = dfd + "," + list.get(i);
                }
                Log.e("onPageFinished===", dfd + "**" + url);
//                view.loadUrl("javascript:window.local_obj.getHTML('<head>'+"
//                        + "document.getElementsByTagName('html')[0].innerHTML+'</head>');");
//                view.loadUrl("javascript:window.local_obj.getHTML('<html>'+document.body.innerHTML+'</html>');");
            }

            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                Log.i("shouldOeUrlLoading====", "");
                return super.shouldOverrideUrlLoading(view, request);
            }

            @Override
            public void onLoadResource(WebView view, String url) {
//                getHtml();
                Log.e("logonLoadResource-->", "onLoadResource-->>" + url);
//                webView.loadUrl("javascript:window.local_obj.getName(" + "document.getElementsByTagName('input')[0].value);");
                super.onLoadResource(view, url);
            }

            @Override
            public void onPageCommitVisible(WebView view, String url) {
                super.onPageCommitVisible(view, url);
            }

            @Override
            public WebResourceResponse shouldInterceptRequest(WebView view, String url) {
                String cookie = cookiemanager.getCookie(url);
                if (!TextUtils.isEmpty(cookie)) {
//                Log.e("loginWeb===Response", url + "***" + cookie);
                    Log.e("cookie======", cookie);
                }
                try {
                    return new WebResourceResponse("application/x-javascript", "utf-8", getBaseContext().getAssets().open(DEFAULT_URL));
                } catch (IOException e) {
                    e.printStackTrace();
                }

                return super.shouldInterceptRequest(view, url);
            }

            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public WebResourceResponse shouldInterceptRequest(WebView view, WebResourceRequest request) {
                request.getUrl().toString();
                String url = request.getUrl().toString();

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
        webView.clearCache(true);
        webView.loadUrl(URLS);
    }

    final class InJavaScriptLocalObj {
        @JavascriptInterface
        public void getName(String str) {
            Log.e("getName====", str);
        }

        @JavascriptInterface
        public void getLabel(String str) {
            Log.e("getName====", str);
            tvCli.setText(str);
        }

        @JavascriptInterface
        public void setMessage() {

        }
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

    public Bitmap getImage(String url) {
        final Handler handler = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                if (msg.what == 0x123) {
                    //使用ImageView显示图片
                    imgAA.setImageBitmap(bitmap);
                }
            }
        };
        new Thread() {
            @Override
            public void run() {
                try {
                    URL url = new URL("https://www.touna.cn/loginvc.do?t=1520416882&code=undefined");//URl对象，指向本地服务器的一张图片
                    url.getContent();
                    InputStream is = url.openStream();//打开输入流
                    bitmap = BitmapFactory.decodeStream(is);//解析成bitmap对象
                    handler.sendEmptyMessage(0x123);//handler机制UI显示图片
                    OutputStream os = openFileOutput("demon.png", MODE_PRIVATE);//打开一个文件对应的输入流
                    byte[] bytes = new byte[1024];
                    int has;
                    while ((has = is.read(bytes)) > 0) {
                        os.write(bytes, 0, has);//将URL对应的图片下载到本地
                    }
                    is.close();//关闭流
                    os.close();//关闭流
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }.start();
        return bitmap;
    }
    private void innerHtml() {
        webView.loadUrl("javascript:" + "$(\".header\").hide();\n" +
                "$(\"h1\").hide();\n" +
                "$(\".tips\").hide();\n" +
                "$(\".m-row\").hide();\n" +
                "$(\".full_container\").hide();\n" +
                "$(\".footer\").hide();\n" +
                "$(\".bg\").attr(\"id\",\"main\");\n");
    }
    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public void addJs() {
        //获取js文本
        InputStream mIs = null;
        try {
            mIs = getResources().getAssets().open("js.js");
            if (mIs != null) {
                byte buff[] = new byte[1024];
                ByteArrayOutputStream fromFile = new ByteArrayOutputStream();
                FileOutputStream out = null;
                do {
                    int numread = 0;
                    numread = mIs.read(buff);
                    if (numread <= 0) {
                        break;
                    }
                    fromFile.write(buff, 0, numread);
                } while (true);
                wholeJS = fromFile.toString();
            } else {
                Toast.makeText(WebviewClickActivity.this, "js加载失败", Toast.LENGTH_SHORT).show();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        //webview添加读取的js
//        webView.loadUrl("javascript:" + wholeJS);
        webView.evaluateJavascript(wholeJS, new ValueCallback<String>() {
            @Override
            public void onReceiveValue(String value) {
            }
        });
    }
}
