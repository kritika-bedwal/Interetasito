package com.example.akshay.parth;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Source extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_source);

    }


    public void Tutor(View view) {
        Intent i=new Intent(this,tutor.class);
        startActivity(i);
    }

    public void findvideos(View view) {
        Intent i = new Intent(this,WebView.class);
        i.putExtra("value",1);
        startActivity(i);

    }

    public void findpdf(View view) {
        Intent i = new Intent(this,WebView.class);
        i.putExtra("value",2);
        startActivity(i);

    }
}
