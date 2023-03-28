package uk.ac.tees.b1448179.gibbse_library;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class BookActivity extends AppCompatActivity {

    private TextView txtBookName, txtAuthor, txtPages, txtDescription;
    private Button btnContinueReading, btnAddToFavorites, btnAddToAlreadyRead, btnBuyBook;
    private ImageView bookImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);

        //run mtd init views
        initViews();

        String longDescription = " The three firm friends, Harry, Ron and Hermione, are soon immersed in the daily round of Potions, \" +\n" +
                "                \"Herbology, Charms, Defence Against the Dark Arts, and Quidditch. But then horrible and mysterious things begin to happen. \" +\n" +
                "                \"Harry keeps hearing strange voices, sinister and dark messages appear on the wall, \" +\n" +
                "                \"and then Ron's sister Ginny disappears... The three firm friends, Harry, Ron and Hermione, are soon immersed in the daily round of Potions, \\\" +\\n\" +\n" +
                "                \"                \\\"Herbology, Charms, Defence Against the Dark Arts, and Quidditch. But then horrible and mysterious things begin to happen. \\\" +\\n\" +\n" +
                "                \"                \\\"Harry keeps hearing strange voices, sinister and dark messages appear on the wall, \\\" +\\n\" +\n" +
                "                \"                \\\"and then Ron's sister Ginny disappears...\" +\n" +
                "                \"The three firm friends, Harry, Ron and Hermione, are soon immersed in the daily round of Potions, \\\" +\\n\" +\n" +
                "                \"                \\\"Herbology, Charms, Defence Against the Dark Arts, and Quidditch. But then horrible and mysterious things begin to happen. \\\" +\\n\" +\n" +
                "                \"                \\\"Harry keeps hearing strange voices, sinister and dark messages appear on the wall, \\\" +\\n\" +\n" +
                "                \"                \\\"and then Ron's sister Ginny disappears...\" +\n" +
                "                \"The three firm friends, Harry, Ron and Hermione, are soon immersed in the daily round of Potions, \\\" +\\n\" +\n" +
                "                \"                \\\"Herbology, Charms, Defence Against the Dark Arts, and Quidditch. But then horrible and mysterious things begin to happen. \\\" +\\n\" +\n" +
                "                \"                \\\"Harry keeps hearing strange voices, sinister and dark messages appear on the wall, \\\" +\\n\" +\n" +
                "                \"                \\\"and then Ron's sister Ginny disappears...";
        //TODO: Get the data from recycler view in here
        Books book = new Books(1,"Harry Potter and the Chamber\n of Secrets", "J. K. Rowling",2500,"https://m.media-amazon.com/images/I/51Q9uPHKhAL._SX324_BO1,204,203,200_.jpg",
                "Description - An ancient prophecy seems to be coming true when a mysterious presence begins stalking the corridors of a school of magic and leaving its victims paralyzed.",longDescription);
        setData(book);
    }

    private void setData(Books book) {
        //get and set book info
        txtBookName.setText((book.getName()));
        txtAuthor.setText(book.getAuthor());
        txtPages.setText(String.valueOf(book.getPages()));
        txtDescription.setText(book.getLongDesc());

        //set data in ui elements
        Glide.with(this)
                .asBitmap().load(book.getImageUrl())
                .into(bookImage);



    }

    //method for initViews
    private void initViews() {
        txtAuthor = findViewById(R.id.textViewAuthorName);
        txtBookName = findViewById(R.id.textViewBookName);
        txtPages = findViewById(R.id.textViewPages);
        txtDescription = findViewById(R.id.longDescTextView);

        btnAddToAlreadyRead = findViewById(R.id.buttonRead);
        btnAddToFavorites = findViewById(R.id.buttonFavorites);
        btnContinueReading = findViewById(R.id.contRead);

        bookImage = findViewById(R.id.imageViewBook);
    }
}