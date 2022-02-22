package com.example.myecomerce;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SplashScreen  extends AppCompatActivity {
    //  LottieAnimationView lottie;
    Animation topAinm, bottomAnim;
    TextView logo;
    private static  int SPLASH_SCREEN = 8000;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.splashscreen);


     //   topAinm = AnimationUtils.loadAnimation(this,R.anim.top_animation);
     //   bottomAnim = AnimationUtils.loadAnimation(this,R.anim.bottom_animation);

        //  img1 = findViewById(R.id.img1);
        logo = findViewById(R.id.textView2);

        //  lottie.setAnimation(topAinm);
        logo.setAnimation(bottomAnim);

        // lottie = findViewById(R.id.lottie);


        //  lottie.animate().translationY(1400).setDuration(1000).setStartDelay(4000);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashScreen.this, Sanh.class);
                startActivity(intent);
                finish();


            }
        },SPLASH_SCREEN);
    }}


