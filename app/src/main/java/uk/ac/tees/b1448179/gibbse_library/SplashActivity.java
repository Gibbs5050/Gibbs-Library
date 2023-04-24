
package uk.ac.tees.b1448179.gibbse_library;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class SplashActivity extends AppCompatActivity {
    private ImageView imageView11;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        //Create Logo Animation
        imageView11 = (ImageView) findViewById(R.id.imageView11);
        Animation anim = AnimationUtils.loadAnimation(this, R.anim.landing_anim);
        imageView11.setAnimation(anim);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(SplashActivity.this, LandingPage.class));
                finish();
            }
        }, 3500); //delay time for splash screen

    }

}
