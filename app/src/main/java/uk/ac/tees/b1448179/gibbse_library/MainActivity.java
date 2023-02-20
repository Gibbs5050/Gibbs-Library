package uk.ac.tees.b1448179.gibbse_library;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView register;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    //set Action listener
        register = (TextView) findViewById(R.id.RegisterLoginID);
        register.setOnClickListener(this);
    }

    //create the method that implements view on click listener
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.RegisterLoginID:
                startActivity(new Intent(this,RegisterUser.class));
                break;

        }
    }
}