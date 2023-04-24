package uk.ac.tees.b1448179.gibbse_library;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class FavouriteBooks extends AppCompatActivity {

    private ImageView imageView2;
    private TextView greeting;
    private RecyclerView booksRecView5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favourite_books);

        imageView2 = findViewById(R.id.imageView2);
        greeting = findViewById(R.id.greeting);
        booksRecView5 = findViewById(R.id.booksRecView5);
        //reuse adapter for favorite books
        BookRecViewAdapter adapter = new BookRecViewAdapter(this);
        booksRecView5.setAdapter(adapter);
        booksRecView5.setLayoutManager(new LinearLayoutManager(this));
        adapter.setBooks(BookUtil.getInstance().getFavouriteBooks());

    }
    //handle back stack
    @Override
    public void onBackPressed(){
        Intent intent = new Intent(this,MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK); //clear back stack in android
        startActivity(intent);
    }
}