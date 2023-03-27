package uk.ac.tees.b1448179.gibbse_library;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class AllBooksActivity extends AppCompatActivity {

    private RecyclerView booksRecView;
    private BookRecViewAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_books);

        adapter = new BookRecViewAdapter(this);
        booksRecView = findViewById(R.id.booksRecView);
        booksRecView.setAdapter(adapter);
        booksRecView.setLayoutManager(new GridLayoutManager(this,2));


        //add book
        ArrayList<Books> books = new ArrayList<>();
        books.add(new Books(1,"Moby-Dick", "Herman Melville",1300,"https://books.google.co.uk/books/content?id=XV8XAAAAYAAJ&printsec=frontcover&img=1&zoom=1&edge=curl&imgtk=AFLRE72L-MupQeXaFAn5qDqavWvjl4Z566MZ4wsU_2oAfViKaPDPLhyTNhHmHQAl5CbY6x9RNrGFiVF-_uRVZL24SfBU43kcH8wocOwLUFziYx2Z6M4k6LE9a0w3kNAu8LH0aOHc74X_.jpg",
                "A cool book","Long description"));
        adapter.setBooks(books); //pass array list
    }
}