package uk.ac.tees.b1448179.gibbse_library;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

public class LandingPage extends AppCompatActivity implements View.OnClickListener {

    private TextView appDesc;
    private Button landingButtonGetStarted;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landing_page);

        landingButtonGetStarted = (Button) findViewById(R.id.landingButtonGetStarted);
        landingButtonGetStarted.setOnClickListener(this);
        appDesc = findViewById(R.id.titleID_description3);
        //animation
        Animation anim = AnimationUtils.loadAnimation(this, R.anim.landing_anim);
        appDesc.setAnimation(anim);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.landingButtonGetStarted:
               startActivity(new Intent(this,MainActivity.class));

        }
    }
}