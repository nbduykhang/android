package com.dank.android.locationgooglemaps;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.dank.android.locationgooglemaps.model.ClevelandItem;

public class InfoActivity extends AppCompatActivity {
    WebView webCleveland;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
        addControls();
    }

    private void addControls() {
        webCleveland = (WebView) findViewById(R.id.webCleveland);
        Intent intent = getIntent();
        ClevelandItem cleveland = (ClevelandItem) intent.getSerializableExtra("DSCLEVELAND");
        webCleveland.loadUrl(cleveland.getLink());
        webCleveland.setWebViewClient(new WebViewClient());
    }
}
