package uk.ac.tees.b1448179.gibbse_library;


import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.os.Bundle;

import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import uk.ac.tees.b1448179.gibbse_library.Adapters.MeaningAdaptor;
import uk.ac.tees.b1448179.gibbse_library.Adapters.PhoneticsAdapter;
import uk.ac.tees.b1448179.gibbse_library.DictionaryModels.APIResponse;


public class DictionaryActivity extends AppCompatActivity {

    SearchView search_view;
    TextView textView_word;
    RecyclerView recycler_phonetics, recycler_meanings;
    ProgressDialog progressDialog;
    PhoneticsAdapter phoneticsAdapter;
    MeaningAdaptor meaningAdaptor;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dictionary);

        //initialize variables
        search_view = findViewById(R.id.search_view);
        textView_word = findViewById(R.id.textView_word);
        recycler_phonetics = findViewById(R.id.recycler_phonetics);
        recycler_meanings = findViewById(R.id.recycler_meanings);
        progressDialog = new ProgressDialog(this);


        //loading on launching app
        progressDialog.setTitle("Loading....");
        progressDialog.show();
        //call API
        RequestManager manager = new RequestManager(DictionaryActivity.this);
        manager.getWordMeaning(listener,"Hello");

       // add on query text listener for search view so when user type something in search view
        search_view.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {

                progressDialog.setTitle("Fetching response for " + query);
                progressDialog.show();

                //call API
                RequestManager manager = new RequestManager(DictionaryActivity.this);
                manager.getWordMeaning(listener,query);

                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });

      //  class to show data - view holder and costume adapter


    }

    //on fetch data listener
    private final OnFetchDataListener listener = new OnFetchDataListener() {
        @Override
        public void onFetchData(APIResponse apiResponse, String message) {
            progressDialog.dismiss();
            if (apiResponse==null){
                Toast.makeText(DictionaryActivity.this, "No data found!", Toast.LENGTH_SHORT).show();
                return;
            }
            showData(apiResponse);
        }

        @Override
        public void onError(String message) {
            progressDialog.dismiss();
            Toast.makeText(DictionaryActivity.this, message, Toast.LENGTH_SHORT).show();

        }
    };

    private void showData(APIResponse apiResponse) {
        textView_word.setText("Word:  " +apiResponse.getWord());
        recycler_phonetics.setHasFixedSize(true);
        recycler_phonetics.setLayoutManager(new GridLayoutManager(this,1));
        phoneticsAdapter = new PhoneticsAdapter(this,apiResponse.getPhonetics());
        recycler_phonetics.setAdapter(phoneticsAdapter);

        recycler_meanings.setHasFixedSize(true);
        recycler_meanings.setLayoutManager(new GridLayoutManager(this,1));
        meaningAdaptor = new MeaningAdaptor(this,apiResponse.getMeanings());
        recycler_meanings.setAdapter(meaningAdaptor);

    }
}

