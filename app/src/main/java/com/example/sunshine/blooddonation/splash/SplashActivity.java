package com.example.sunshine.blooddonation.splash;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.ImageView;

import com.example.sunshine.blooddonation.R;
import com.example.sunshine.blooddonation.intro.introActivity;

public class SplashActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        SplashAnimation();



    }

    //timer for splash screen
    private void SplashAnimation() {
        ImageView imageView = findViewById(R.id.splashlogo);
        //define an object animator
        ObjectAnimator translateAnimation =
                ObjectAnimator.ofFloat(imageView, View.TRANSLATION_Y, -900, 0);
        //set the number of repeat count if 0 the repeating will be only 1;
        translateAnimation.setDuration(1000);
        translateAnimation.setInterpolator(new AccelerateDecelerateInterpolator());
        translateAnimation.start();

        translateAnimation.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                //intent to open intro screen activity
                Intent intent = new Intent(SplashActivity.this, introActivity.class);
                //make sure that the receiver .exist if not then no need to send an intent.
                if (intent.resolveActivity(SplashActivity.this.getPackageManager()) != null) {
                    startActivity(intent);
                    overridePendingTransition(R.anim.left,R.anim.outright);

                }

            }
        });

    }


    @Override
    protected void onStop() {
        finish();
        super.onStop();
    }

}
