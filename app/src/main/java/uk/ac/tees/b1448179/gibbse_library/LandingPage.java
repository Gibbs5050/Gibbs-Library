package uk.ac.tees.b1448179.gibbse_library;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class LandingPage extends AppCompatActivity implements View.OnClickListener {

    private TextView logoView, clickLogin,clickSignUp, guestHomePage;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landing_page);

        //initialize
        clickLogin = (TextView) findViewById(R.id.clickLogin);
        clickSignUp = (TextView) findViewById(R.id.clickSignUp);
        guestHomePage = (TextView) findViewById(R.id.guestHomePage);
        logoView = findViewById(R.id.logoView);
        clickLogin.setOnClickListener(this);
        clickSignUp.setOnClickListener(this);
        guestHomePage.setOnClickListener(this);

        //animation

        ImageView imageView5 = findViewById(R.id.imageView5);
        Animation anim = AnimationUtils.loadAnimation(this, R.anim.landing_anim);
        imageView5.setAnimation(anim);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.clickLogin:
               startActivity(new Intent(this,MainActivity.class));
                Toast.makeText(LandingPage.this, "Please Login to continue!", Toast.LENGTH_SHORT).show();
               //create colour in colour.xml for on click colour change to show when clicked
                clickLogin.setTextColor(getResources().getColor(R.color.amber));
                break;


            case R.id.clickSignUp:
                startActivity(new Intent(this,RegisterUser.class)); //redirect to homepage layout
                Toast.makeText(LandingPage.this, "Follow instructions to sign up!", Toast.LENGTH_SHORT).show();
                clickSignUp.setTextColor(getResources().getColor(R.color.amber)); //change colour on click
                break;


            case R.id.guestHomePage:
                startActivity(new Intent(this,MainActivity2.class)); //redirect to homepage layout
                Toast.makeText(LandingPage.this, "Welcome to Gibbs Library!", Toast.LENGTH_SHORT).show();
                guestHomePage.setTextColor(getResources().getColor(R.color.amber)); //change colour on click
                break;


            default:
                throw new IllegalStateException("Unexpected value: " + v.getId());
        }
    }
}