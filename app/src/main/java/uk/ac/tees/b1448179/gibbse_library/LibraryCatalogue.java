package uk.ac.tees.b1448179.gibbse_library;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class LibraryCatalogue extends AppCompatActivity {
//catalogue_exit
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_library_catalogue);


        //initialize exit of activity
        ImageView catalogue_exit = findViewById(R.id.catalogue_exit);
        catalogue_exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Close the activity containing the web view
                finish();
            }
        });
    }
}