package com.example.summerone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;

public class SplashScreen extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        ImageView he=(ImageView) findViewById(R.id.newheader);
        he.setTranslationY(-100f);


        ImageView ma=(ImageView) findViewById(R.id.main_logo);
        he.animate().translationYBy(100f).setDuration(3800);
        ma.animate().setDuration(1000).scaleY(1.5f).scaleX(1.5f);
        ma.animate().setDuration(2000).scaleY(0.8f).scaleX(0.8f);



        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {



                Intent startnew=new Intent(getApplicationContext(),MainActivity.class);
                startActivity(startnew);
                finish();

            }
        },2000);
    }
}
