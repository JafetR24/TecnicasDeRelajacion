package com.decagon.tecnicasderelajacion;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

public class Activity_Intro extends AppCompatActivity {

    TextView title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__intro);
        getSupportActionBar().hide();

        final Intent intent = new Intent(this,MainActivity.class);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        title = findViewById(R.id.Title_Intro);

        startAnimation();

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(intent);
                finish();
            }
        }, 4000);
    }

    private void startAnimation(){
        Animation animation = AnimationUtils.loadAnimation(this,R.anim.anim);
        title.startAnimation(animation);
    }

}
