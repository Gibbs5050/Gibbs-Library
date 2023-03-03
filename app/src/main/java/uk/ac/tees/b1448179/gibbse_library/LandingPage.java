package uk.ac.tees.b1448179.gibbse_library;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LandingPage extends AppCompatActivity implements View.OnClickListener {

    private Button landingButtonGetStarted;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landing_page);

        landingButtonGetStarted = (Button) findViewById(R.id.landingButtonGetStarted);
        landingButtonGetStarted.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.landingButtonGetStarted:
               startActivity(new Intent(this,MainActivity.class));

        }
    }
}