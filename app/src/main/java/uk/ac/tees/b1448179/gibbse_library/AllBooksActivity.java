package uk.ac.tees.b1448179.gibbse_library;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
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
        booksRecView.setLayoutManager(new LinearLayoutManager(this));


        //add book
        ArrayList<Books> books = new ArrayList<>();

        books.add(new Books(1,"Harry Potter and the Chamber of Secrets", "J. K. Rowling",2500,"https://m.media-amazon.com/images/I/51Q9uPHKhAL._SX324_BO1,204,203,200_.jpg",
                "Description - An ancient prophecy seems to be coming true when a mysterious presence begins stalking the corridors of a school of magic and leaving its victims paralyzed.","Long description"));
        books.add(new Books(2,"Gulliver's Travels", "Jonathan Swift",1760,"https://m.media-amazon.com/images/W/IMAGERENDERING_521856-T1/images/I/51-8gPee03L.jpg",
                "Description - A keystone of English literature, \"Gulliver’s Travels\" was one of the books that gave birth to the novel form, though it did not yet have the rules of the genre as an organizing tool. A parody of the then popular travel narrative, \"Gulliver’s Travels\" combines adventure with savage satire, mocking English customs and the politics of the day","Long description"));
        books.add(new Books(3,"The beautyful ones are not yet born\n", "Ayi Kwei Armah",2000,"https://pictures.abebooks.com/inventory/31241979424.jpg",
                "Description - The central story in this book tells of an upright man resisting the temptations of easy bribes and easy satisfactions and winning for his honesty nothing but scorn.","Long description"));
        books.add(new Books(4,"Moby-Dick", "Herman Melville",1300,"https://books.google.co.uk/books/content?id=XV8XAAAAYAAJ&printsec=frontcover&img=1&zoom=1&edge=curl&imgtk=AFLRE72L-MupQeXaFAn5qDqavWvjl4Z566MZ4wsU_2oAfViKaPDPLhyTNhHmHQAl5CbY6x9RNrGFiVF-_uRVZL24SfBU43kcH8wocOwLUFziYx2Z6M4k6LE9a0w3kNAu8LH0aOHc74X_.jpg",
                "Description - A literary classic that wasn't recognized for its merits until decades after its publication, Herman Melville's Moby-Dick tells the tale of a whaling ship and its crew, who are carried progressively further out to sea by the fiery Captain Ahab. Obsessed with killing the massive whale, which had previously bitten off Ahab's leg, the seasoned seafarer steers his ship to confront the creature, while the rest of the shipmates, including the young narrator, Ishmael, and the harpoon expert, Queequeg, must contend with their increasingly dire journey. The book invariably lands on any short list of the greatest American novels","Long description"));
        adapter.setBooks(books); //pass array list
    }
}