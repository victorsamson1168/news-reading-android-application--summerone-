package com.example.summerone;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class Webvv extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webvv);
        WebView v=(WebView)findViewById(R.id.webvi);
        Bundle bundle=getIntent().getExtras();
        String link=bundle.getString("linkage");
        v.getSettings().setJavaScriptEnabled(true);
        v.setWebViewClient(new WebViewClient());
        v.loadUrl(link);


    }


}
