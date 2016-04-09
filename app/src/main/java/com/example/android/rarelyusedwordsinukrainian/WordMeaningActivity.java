package com.example.android.rarelyusedwordsinukrainian;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebSettings;
import android.webkit.WebView;

/**
 * Created by User on 01.04.16.
 */
public class WordMeaningActivity extends AppCompatActivity implements OnClickListener {
    /**
     * Called when the activity is first created.
     */
    public static final String EXT_LabelToShow = "label";
    public static final String EXT_TextToShow = "text";
    private WebView web;

    /**
     * Called when the activity is first created.
     */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //Get data from MainActivity
        Intent intent = getIntent();
        String cells = intent.getStringExtra(EXT_TextToShow);
        String label = intent.getStringExtra(EXT_LabelToShow);
        setTitle(label);

        //Get access to the WebView and load an HTML page
        web = (WebView) findViewById(R.id.webView);
        final WebSettings webSettings = web.getSettings();

        // Set the font size (in sp).
        webSettings.setDefaultFontSize(24);
        web.setBackgroundColor(Color.TRANSPARENT);

        //webSettings.setJavaScriptEnabled(true);
        web.loadDataWithBaseURL("file:///android_res/drawable/", "<!Doctype html><html><head><meta charset=utf-8></head>" +
                "<body>" + cells + "</body></html>", "text/html", "utf-8", "");
    }

    public void onClick(View v) {
        finish();
    }
}