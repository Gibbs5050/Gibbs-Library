package uk.ac.tees.b1448179.gibbse_library;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class HomePage extends AppCompatActivity implements View.OnClickListener {
private Button logout,user_profile;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        logout = (Button) findViewById(R.id.home_page_button);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                Toast.makeText(HomePage.this, "Logged out successfully!!", Toast.LENGTH_LONG).show();
                startActivity(new Intent(HomePage.this,MainActivity.class));
            }
        });
        user_profile = (Button) findViewById(R.id.user_profile);
        user_profile.setOnClickListener(this);

    }
//set on click for each scenario in homepage
    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.user_profile:
                startActivity(new Intent(this, ProfileActivity.class));

        }
    }
}