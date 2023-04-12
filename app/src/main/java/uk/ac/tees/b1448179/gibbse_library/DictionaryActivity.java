package uk.ac.tees.b1448179.gibbse_library;


import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


public class DictionaryActivity extends AppCompatActivity {

    // private EditText editText;
    //private TextView textView;
    //    private RapidApiConnect client;
    //private Button searchButton;
    private EditText searchEditText;
    private TextView textView_dictionary;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dictionary);

        searchEditText = findViewById(R.id.searchEditText);
        textView_dictionary = findViewById(R.id.textView_dictionary);


    }
}











