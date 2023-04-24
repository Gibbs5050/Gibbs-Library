package uk.ac.tees.b1448179.gibbse_library;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
//import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class BookActivity extends AppCompatActivity {

    private TextView txtBookName, txtAuthor, txtPages, txtDescription, longDescTextView;
    private TextView btnContinueReading, btnAddToAlreadyRead, linkUrl;
    private ImageView bookImage, btnAddToFavorites, btnBuyBook,catalogue_exitBook;
    private CheckBox markAsRead;
    public static final String BOOK_ID_NUMBER = "bookId";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);

        //run mtd init views
        initViews();

        //exit of activity click to close
        catalogue_exitBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Close the activity containing the web view
                finish();
            }
        });

        String longDescription = "Harry Potter and the Chamber, Harry Potter and the Chamber , Harry Potter and the Chamber, Harry Potter and the Chamber, Harry Potter and the Chamber, Harry Potter and the Chamber, Harry Potter and the Chamber, Harry Potter and the Chamber, Harry Potter and the Chamber" +
                ", Harry Potter and the Chamber, Harry Potter and the Chamber, Harry Potter and the Chamber, Harry Potter and the Chamber, Harry Potter and the Chamber";
        String longDescription1 = "A philosophical exploration of the entire seven-book Harry Potter series\n" +
                "\n" +
                "Harry Potter has been heralded as one of the most popular book series of all time and the philosophical nature of Harry, Hermione, and Ron's quest to rid the world of its ultimate evil is one of the many things that make this series special. The Ultimate Harry Potter and Philosophy covers all seven titles in J.K. Rowling's groundbreaking series and takes fans back to Godric's Hollow to discuss life after death, to consider what moral reasoning drove Harry to choose death, and to debate whether Sirius Black is a man or a dog.\n" +
                "\n" +
                "With publication timed to coincide with the release of the movie Harry Potter and the Deathly Hallows (Part 1), this book will be the definitive guide for all fans looking to... " +
                "read again to long - A philosophical exploration of the entire seven-book Harry Potter series" +
                "               " +
                "                \"Harry Potter has been heralded as one of the most popular book series of all time and the philosophical nature of Harry, Hermione, and Ron's quest to rid the world of its ultimate evil is one of the many things that make this series special. The Ultimate Harry Potter and Philosophy covers all seven titles in J.K. Rowling's groundbreaking series and takes fans back to Godric's Hollow to discuss life after death, to consider what moral reasoning drove Harry to choose death, and to debate whether Sirius Black is a man or a dog.\\n\" +\n" +
                "                 +\n" +
                "                \"With publication timed to coincide with the release of the movie Harry Potter and the Deathly Hallows (Part 1), this book will be the definitive guide for all fans looking to";

        //longDescTextView.setMovementMethod(new ScrollingMovementMethod());

//        //TODO: Get the data from recycler view in here
//        Books book = new Books(1,"Harry Potter and the Chamber\n of Secrets", "J. K. Rowling",2500,"https://m.media-amazon.com/images/I/51Q9uPHKhAL._SX324_BO1,204,203,200_.jpg",
//                "Description - An ancient prophecy seems to be coming true when a mysterious presence begins stalking the corridors of a school of magic and leaving its victims paralyzed.",longDescription,linkUrl.getText().toString());
//        setData(book);

//        Books book1 = new Books(2,"Harry Potter","test author",45,"https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcShsbvaxiaInDqm7p2mWG_Y" +
//                "GY7wj84Ssb-Vv6-hDdM3fPy4xd4wk0TWJzxdFM6gcA10Wew&usqp=CAU","A philosophical exploration of the entire seven-book Harry Potter series",getString(R.string.bookLong));
//        setData(book);

        //call items by id and handle intent of null selections
        Intent intent = getIntent();
        if(null != intent){
            int bookId = intent.getIntExtra(BOOK_ID_NUMBER,1);
            if(bookId != -1){
                Books incomingBooks = BookUtil.getInstance().getBookById(bookId);
                if(null != incomingBooks){
                    setData(incomingBooks);

                    //method to handle reading now
                    handleReadingNow(incomingBooks);

                    //method to handle favorite
                    handleFavouriteBooks(incomingBooks);
                }
            }

        }


        //set read button
       btnAddToAlreadyRead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(BookActivity.this, WebSwitchActivity.class);
                myIntent.putExtra("url",linkUrl.getText().toString());//show in webview
                startActivity(myIntent);
            }
        });


        BookUtil.getInstance();

    }

    //Handle favorite books
    private void handleFavouriteBooks(Books books) {
        ArrayList<Books> handleFavouriteBooks = BookUtil.getInstance().getFavouriteBooks();

        //to check if book is in another array list   as well
        boolean existingInFavouriteBooks = false; //check if in list
        for (Books b: handleFavouriteBooks){
            if(b.getId() == books.getId()){
                existingInFavouriteBooks = true;
            }
        }

        //confirm if book is not already in list and move to reading now, if already in list button deactivate
        if (existingInFavouriteBooks){
            btnAddToFavorites.setEnabled(false);
        }else{
            btnAddToFavorites.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(BookUtil.getInstance().favouriteBooks(books)){
//                        btnAddToFavorites.setTextColor(getResources().getColor(R.color.amber)); //change colour on click
                        Toast.makeText(BookActivity.this, "Book Added to Reading Now List!", Toast.LENGTH_SHORT).show();
                        Intent myIntent = new Intent(BookActivity.this, FavouriteBooks.class);
//                        Intent myIntent2 = new Intent(BookActivity.this, MainActivity.class);
                        startActivity(myIntent);
                    }else {
                        Toast.makeText(BookActivity.this, "Oops, Looks like something went wrong", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }

    }

    //method to handle books being read - enable and disable button
    private void handleReadingNow(Books books) {
        ArrayList<Books> readingNow = BookUtil.getInstance().getReadingNow();

        //to check if book is in another array list   as well
        boolean existingInReadingNow = false; //check if in list
        for (Books b: readingNow){
            if(b.getId() == books.getId()){
                existingInReadingNow = true;
            }
        }

        //confirm if book is not already in list and move to reading now, if already in list button deactivate
        if (existingInReadingNow){
            Toast.makeText(BookActivity.this, "Already added", Toast.LENGTH_SHORT).show();
            markAsRead.setEnabled(false); //disable button
        }else{
            markAsRead.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(BookUtil.getInstance().readingNow(books)){ //if adding book is successful
                        markAsRead.setTextColor(getResources().getColor(R.color.amber)); //change colour on click
                        Toast.makeText(BookActivity.this, "Book Added to Reading Now List!", Toast.LENGTH_SHORT).show();
                        Intent myIntent = new Intent(BookActivity.this, ReadingNow.class);
//                        Intent myIntent2 = new Intent(BookActivity.this, MainActivity.class);
                        startActivity(myIntent);
                    }else {
                        Toast.makeText(BookActivity.this, "Oops, Looks like something went wrong", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }



    }
//    //set what read button does
//     private void handleRead(final Books book){
//         ArrayList<Books> readBook = BookUtil.getInstance().getBookById("bookId");
//     }

    private void setData(Books book) {
        //get and set book info
        txtBookName.setText((book.getName()));
        txtAuthor.setText(book.getAuthor());
        txtPages.setText(String.valueOf(book.getPages()));
        txtDescription.setText(book.getLongDesc());
        linkUrl.setText(book.getBookLocation());


        //set data in ui elements
        Glide.with(this)
                .asBitmap().load(book.getImageUrl())
                .into(bookImage);

    }


    // initViews method
    private void initViews() {
        txtAuthor = findViewById(R.id.textViewAuthorName);
        txtBookName = findViewById(R.id.textViewBookName);
        txtPages = findViewById(R.id.textViewPages);
        txtDescription = findViewById(R.id.longDescTextView);
        btnBuyBook = findViewById(R.id.buyBook);
        catalogue_exitBook = findViewById(R.id.catalogue_exitBook);
        linkUrl = findViewById(R.id.linkUrl);
        markAsRead = findViewById(R.id.markAsRead);
        btnAddToAlreadyRead = findViewById(R.id.buttonRead);

        btnAddToFavorites = findViewById(R.id.buttonFavorites);
//        btnContinueReading = findViewById(R.id.contRead);

        bookImage = findViewById(R.id.imageViewBook);
    }
}