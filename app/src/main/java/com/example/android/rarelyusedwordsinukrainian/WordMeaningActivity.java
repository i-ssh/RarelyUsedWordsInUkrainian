package com.example.android.rarelyusedwordsinukrainian;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.view.View.OnClickListener;

/**
 * Created by User on 01.04.16.
 */
public class WordMeaningActivity extends Activity implements OnClickListener{
    /** Called when the activity is first created. */
    public static final String EXT_TextToShow="text";
    private WebView web;

    /** Called when the activity is first created. */
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_meaning);
    //Get data from MainActivity
        Intent intent = getIntent();
        String cells = intent.getStringExtra(EXT_TextToShow);
    //Get access to the WebView and load an HTML page
        web = (WebView) findViewById(R.id.webView);
        final WebSettings webSettings = web.getSettings();
    // Set the font size (in sp).
        webSettings.setDefaultFontSize(24);
        web.setBackgroundColor(Color.TRANSPARENT);
        //webSettings.setJavaScriptEnabled(true);
        web.loadDataWithBaseURL("file:///android_res/drawable/","<!Doctype html><html><head><meta charset=utf-8></head>" +
                "<body>"+cells+"</body></html>","text/html","utf-8","");
    }
    public void onClick(View v){
        finish();
    }
}
