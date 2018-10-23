package com.example.kf.thetest.webview;

import android.graphics.Bitmap;
import android.net.http.SslError;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.webkit.JavascriptInterface;
import android.webkit.SslErrorHandler;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.kf.thetest.R;

/**
 * Created by kf on 2018/3/14.
 */

public class LuJinSuoWebviewActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView tv_phone, tv_account,tv_erro;
    private EditText edt_accountInput, edt_ps, edt_input_vc;
    private Button btn_commit;
    private ImageView img_fresh;
    private WebView web_view, webView1;
    CookieManager cookiemanager;
    private String URL = "https://user.lu.com/user/login";

    //    private String URL="https://user.lu.com/user/lpreg?action=se_lu&seo=se_lu&marketFeedbackCode=eyJ1cmxUaWQiOiItNzc5MCIsInVybFNvdXJjZSI6IjE4MzgyIn0";
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lujinsuo);
        tv_phone = (TextView) findViewById(R.id.tv_phone);
        tv_account = (TextView) findViewById(R.id.tv_account);
        tv_erro= (TextView) findViewById(R.id.tv_erro);
        edt_accountInput = (EditText) findViewById(R.id.edt_accountInput);
        edt_input_vc = (EditText) findViewById(R.id.edt_input_vc);
        edt_ps = (EditText) findViewById(R.id.edt_ps);
        btn_commit = (Button) findViewById(R.id.btn_commit);
        img_fresh = (ImageView) findViewById(R.id.img_fresh);
        web_view = (WebView) findViewById(R.id.web_view);
        webView1 = (WebView) findViewById(R.id.webView1);
        webviewPermission(web_view);
        webviewPermission(webView1);
        setWebViewClient();
        web_view.loadUrl(URL);
        web_view.addJavascriptInterface(new JavaScript(),"android");
        initListener();
    }

    private void webviewPermission(WebView webView) {
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
    }

    private void setWebViewClient() {
        web_view.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                Log.e("shouldOverrideUrl----->", url);
                return super.shouldOverrideUrlLoading(view, url);
            }

            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                return super.shouldOverrideUrlLoading(view, request);
            }

            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                Log.e("onPageFinished-------->", url);
                if (!TextUtils.isEmpty(url)) {
                    if (url.contains("/my/account")) {
                        Toast.makeText(LuJinSuoWebviewActivity.this, "同步成功", Toast.LENGTH_SHORT).show();
                    }
                }
            }

            @Override
            public void onLoadResource(WebView view, String url) {
                super.onLoadResource(view, url);
                Log.e("logonLoadResource-->", "onLoadResource-->>" + url);
                if (!TextUtils.isEmpty(url)) {
                    if (url.contains("user/captcha/captcha")) {
                        webView1.loadUrl(url);
                    }
                    web_view.loadUrl("javascript:window.android.getErro(" + "$(\".errorContent\").text());");
//                                                       "document.getElementsByTagName('input')[0].value);"
                }
                String cookie = cookiemanager.getCookie(url);
                if (!TextUtils.isEmpty(cookie)) {
//                Log.e("loginWeb===Response", url + "***" + cookie);
                    Log.e("cookie======", cookie);
                }
            }

            @Override
            public WebResourceResponse shouldInterceptRequest(WebView view, String url) {
                return super.shouldInterceptRequest(view, url);
            }

            @Override
            public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                super.onReceivedError(view, errorCode, description, failingUrl);
            }

            @Override
            public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error) {
                super.onReceivedError(view, request, error);
            }

            @Override
            public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error) {
                handler.proceed();
            }
        });
    }

    private void initListener() {
        tv_phone.setOnClickListener(this);
        tv_account.setOnClickListener(this);
        btn_commit.setOnClickListener(this);
        img_fresh.setOnClickListener(this);
        edt_ps.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                showVerification();
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_phone:
                setPhoneChange();
                break;
            case R.id.tv_account:
                setAccountChange();
                break;
            case R.id.btn_commit:
                loginCommit();
                break;
            case R.id.img_fresh:
                webView1.reload();
                break;
            default:
                break;
        }

    }

    /**
     * 设置点击账号登陆切换
     */
    private void setAccountChange() {
        web_view.loadUrl("javascript:" + "$(\"#loginForm\").validate().settings.messages.userName.required = \"请填写用户名\";\n"
                + "$(\".login-tab\").attr(\"data-role\",\"userName\");" +
                "$(\".login-tab\").click();");
    }

    /**
     * 设置点击手机号登陆切换
     */
    private void setPhoneChange() {//setPhoneChange
        web_view.loadUrl("javascript:" + "$(\"#loginForm\").validate().settings.messages.userName.required = \"请填写手机号码\";\n"
                + "$(\".login-tab\").attr(\"data-role\",\"mobile\");" +
                "$(\".login-tab\").click();");
    }

    /**
     * 获取焦点时显示验证码
     */
    private void showVerification() {
        web_view.loadUrl("javascript:" + "$(\".J_validNumBox\").removeClass(\"hidden\");");
    }

    /**
     * 登陆按钮
     */
    private void loginCommit() {
        web_view.loadUrl("javascript:" +
                "$(\"#userNameLogin\").val(\"" + edt_accountInput.getText().toString().trim() + "\");" +
                "$(\"#pwd\").val(\"" + edt_ps.getText().toString().trim() + "\");" +
                "$(\"#validNum\").val(\"" + edt_input_vc.getText().toString().trim() + "\");" +
                "$(\"#loginBtn\").click();"
        );
    }
    class JavaScript{
        @JavascriptInterface
        public void getErro(String erro){
            tv_erro.setText(erro);
        }
    }

}
