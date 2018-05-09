package com.dank.android.rsslistfood;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class FoodDetailActivity extends AppCompatActivity {
    WebView webFood;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_detail);

        addControls();

        Intent intent = getIntent();
        String link = intent.getStringExtra("LINKFOOD");

        webFood.loadUrl(link);
        webFood.setWebViewClient(new WebViewClient());
    }

    private void addEvents() {
    }

    private void addControls() {
        webFood = (WebView) findViewById(R.id.webFood);
    }
}
