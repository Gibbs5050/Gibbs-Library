package uk.ac.tees.b1448179.gibbse_library;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

public class ReadingNow extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reading_now);

        RecyclerView reading_now_view = findViewById(R.id.reading_now_view);

        //reuse adapter
        BookRecViewAdapter adapter = new BookRecViewAdapter(this);
        reading_now_view.setAdapter(adapter);
        reading_now_view.setLayoutManager(new LinearLayoutManager(this));
        adapter.setBooks(BookUtil.getInstance().getReadingNow());
    }
    //handle back stack
    @Override
    public void onBackPressed(){
        Intent intent = new Intent(this,MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK); //clear back stack in android
        startActivity(intent);
    }
}