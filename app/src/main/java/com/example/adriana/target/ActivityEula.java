package com.example.adriana.target;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebSettings;
import android.webkit.WebView;

/**
 * Created by adriana on 11/03/2018.
 */

public class ActivityEula extends AppCompatActivity {
    protected WebView mWebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eula);
        mWebView = (WebView) findViewById(R.id.activity_eula_webView);
        mWebView.loadUrl("https://www.linkedin.com/legal/mobile/eula");
        WebSettings webSettings = mWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
    }
}
