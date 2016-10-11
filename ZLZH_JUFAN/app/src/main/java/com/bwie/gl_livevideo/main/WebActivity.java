package com.bwie.gl_livevideo.main;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.bwie.gl_livevideo.R;

public class WebActivity extends Activity {

    private WebView wb;
    private ProgressDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);

        Intent intent = getIntent();
        String url = intent.getStringExtra("url");

        wb = (WebView) findViewById(R.id.web);

        wb.loadUrl(url);
        //wb.loadUrl("http:///www.baidu.com");

        WebSettings web = wb.getSettings();
//		//设置支持缩放
        web.setSupportZoom(true);
        //开启JS
        web.setJavaScriptEnabled(true);
        //设置连接时的状态
        wb.setWebViewClient(new WebViewClient() {

            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                //如何加载
                view.loadUrl(url);
                return true;
            }

            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                //开始
                super.onPageStarted(view, url, favicon);
                if (dialog == null) {
                    dialog = ProgressDialog.show(WebActivity.this, "提示", "努力加载中。。。");
                }

            }

            @Override
            public void onPageFinished(WebView view, String url) {
                //结束
                super.onPageFinished(view, url);
                dialog.dismiss();
            }

            @Override
            public void onReceivedError(WebView view, int errorCode,
                                        String description, String failingUrl) {
                //发生错误的时候也执行关闭操作
                super.onReceivedError(view, errorCode, description, failingUrl);

            }

        });

        wb.setWebChromeClient(new WebChromeClient() {
            @Override
            public boolean onJsAlert(WebView view, String url, String message,
                                     JsResult result) {

                return super.onJsAlert(view, url, message, result);
            }
        });

    }
}
