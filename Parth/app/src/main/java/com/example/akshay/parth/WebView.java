package com.example.akshay.parth;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebViewClient;

public class WebView extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);



        android.webkit.WebView myWebView = (android.webkit.WebView) findViewById(R.id.myWebView);
        WebSettings webSettings = myWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        myWebView.setWebViewClient(new WebViewClient()); // set the WebViewClient
        Intent i = getIntent();
        int i1=i.getIntExtra("value",1);

        if(i1==1){

            myWebView.loadUrl("https://www.youtube.com/watch?v=MSBjhBeDx9c");
        }else{

            myWebView.loadUrl("https://drive.google.com/open?id=0B3XR0Z3DX_S1V1YzYlllUHNQNkk");

        }


    }
}
