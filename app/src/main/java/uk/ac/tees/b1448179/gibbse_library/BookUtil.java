package uk.ac.tees.b1448179.gibbse_library;

import static android.content.ContentValues.TAG;

import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//database
public class BookUtil {
    //make class singleton
    private static BookUtil instance;

    private static ArrayList<Books> allBooks;
    private static ArrayList<Books> favouriteBooks;
    private static ArrayList<Books> readingNow;
//
//    FirebaseFirestore db = FirebaseFirestore.getInstance();

    //arraylist for items
    private BookUtil(){
        if(null == allBooks){
            allBooks = new ArrayList<>();
            initData();
        }
        if(null == favouriteBooks){
            favouriteBooks = new ArrayList<>();
            initData();
        }
        if(null == readingNow){
            readingNow = new ArrayList<>();
            initData();
        }
    }


    //adding books t fire store




//
//
//    public void addBooksToFirestore(List<Books> allBooks) {
//        for (Books book : allBooks) {
//            Map<String, Object> bookData = new HashMap<>();
//            bookData.put("name", book.getName());
//            bookData.put("author", book.getAuthor());
//            bookData.put("imageUrl", book.getImageUrl());
//            bookData.put("shortDesc", book.getShortDesc());
//            bookData.put("longDesc", book.getLongDesc());
//            bookData.put("bookLocation", book.getBookLocation());
//
//            // add the book data to Firestore
//            db.collection("books").document((String) book.getName()).set(bookData);
//        }
//    }
//
//

    private void initData() {
        //ToDo TBA
        //add book
//        ArrayList<Books> books = new ArrayList<>();
        allBooks.add(new Books(1,"Harry Potter and the Chamber of Secrets", "J. K. Rowling",40,"https://m.media-amazon.com/images/I/51Q9uPHKhAL._SX324_BO1,204,203,200_.jpg",
                "Description - An ancient prophecy seems to be coming true when a mysterious presence begins stalking the corridors of a school of magic and leaving its victims paralyzed.","Harry Potter and the Chamber of Secrets is the second book in J.K. Rowling's Harry Potter series. The story follows Harry Potter, a young wizard attending Hogwarts School of Witchcraft and Wizardry, as he and his friends Ron and Hermione investigate a series of attacks on students by a mysterious monster. Harry discovers the monster is actually a basilisk, a giant serpent that can kill with a single glance. With the help of his friends and new Defense Against the Dark Arts teacher, Gilderoy Lockhart, Harry must enter the Chamber of Secrets to defeat the basilisk and save his schoolmates, including Ron's younger sister Ginny who has been taken hostage by the evil wizard, Tom Riddle.","https://www.gutenberg.org/files/2701/2701-h/2701-h.htm","https://www.amazon.co.uk/Harry-Potter-Chamber-Secrets/dp/1408855666/ref=asc_df_1408855666/?tag=googshopuk-21&linkCode=df0&hvadid=311219507756&hvpos=&hvnetw=g&hvrand=3915440458131912900&hvpone=&hvptwo=&hvqmt=&hvdev=c&hvdvcmdl=&hvlocint=&hvlocphy=1006928&hvtargid=pla-364195446164&psc=1&th=1&psc=1"));
        allBooks.add(new Books(2,"The Deadly Thinkers", "Wm. Gray Beyer",132,"https://www.gutenberg.org/cache/epub/70623/pg70623.cover.medium.jpg",
                "Description - Click to view description","Urei was what they called the huge Unified Reflexive Electronic Integrator, and the vast machine seemed to be developing a personality of its own. Then men began to suspect that Urei had acquired sentience, and with that came the fear of its interference with human minds.","https://www.gutenberg.org/files/70623/70623-h/70623-h.htm","https://www.amazon.co.uk/Deadly-Secrets-Base-Novel-Horror-ebook/dp/B09W43F4TZ"));
        allBooks.add(new Books(3,"The beautyful ones are not yet born\n", "Ayi Kwei Armah",2000,"https://pictures.abebooks.com/inventory/31241979424.jpg",
                "Description - The central story in this book tells of an upright man resisting the temptations of easy bribes and easy satisfactions and winning for his honesty nothing but scorn.","Long description","https://www.gutenberg.org/files/2701/2701-h/2701-h.htm",""));
        allBooks.add(new Books(4,"Moby-Dick", "Herman Melville",1300,"https://books.google.co.uk/books/content?id=XV8XAAAAYAAJ&printsec=frontcover&img=1&zoom=1&edge=curl&imgtk=AFLRE72L-MupQeXaFAn5qDqavWvjl4Z566MZ4wsU_2oAfViKaPDPLhyTNhHmHQAl5CbY6x9RNrGFiVF-_uRVZL24SfBU43kcH8wocOwLUFziYx2Z6M4k6LE9a0w3kNAu8LH0aOHc74X_.jpg",
                "Description - A literary classic that wasn't recognized for its merits until decades after its publication, Herman Melville's Moby-Dick tells the tale of a whaling ship and its crew, who are carried progressively further out to sea by the fiery Captain Ahab. Obsessed with killing the massive whale, which had previously bitten off Ahab's leg, the seasoned seafarer steers his ship to confront the creature, while the rest of the shipmates, including the young narrator, Ishmael, and the harpoon expert, Queequeg, must contend with their increasingly dire journey. The book invariably lands on any short list of the greatest American novels","Long description","https://www.gutenberg.org/files/2701/2701-h/2701-h.htm",""));
        allBooks.add(new Books(5,"Moby-Dick", "Herman Melville",1300,"https://books.google.co.uk/books/content?id=XV8XAAAAYAAJ&printsec=frontcover&img=1&zoom=1&edge=curl&imgtk=AFLRE72L-MupQeXaFAn5qDqavWvjl4Z566MZ4wsU_2oAfViKaPDPLhyTNhHmHQAl5CbY6x9RNrGFiVF-_uRVZL24SfBU43kcH8wocOwLUFziYx2Z6M4k6LE9a0w3kNAu8LH0aOHc74X_.jpg",
                "Description - A literary classic that wasn't recognized for its merits until decades after its publication, Herman Melville's Moby-Dick tells the tale of a whaling ship and its crew, who are carried progressively further out to sea by the fiery Captain Ahab. Obsessed with killing the massive whale, which had previously bitten off Ahab's leg, the seasoned seafarer steers his ship to confront the creature, while the rest of the shipmates, including the young narrator, Ishmael, and the harpoon expert, Queequeg, must contend with their increasingly dire journey. The book invariably lands on any short list of the greatest American novels","Long description","https://www.gutenberg.org/files/2701/2701-h/2701-h.htm",""));


//        // Reference to a collection
//        CollectionReference collectionRef = db.collection("users");
//
//        // Reference to a document
//        DocumentReference books = db.collection("users").document("books");
//
//        // Create a new user with a full name etc for firestore
//        Map<String, Object> allBooks = new HashMap<>();
//        allBooks.put("name", "Harry Potter and the Chamber of Secrets");
//        allBooks.put("author", "J. K. Rowling");
//        allBooks.put("imageUrl", "https://www.gutenberg.org/cache/epub/70623/pg70623.cover.medium.jpg");
//        allBooks.put("shortDesc", "book.getShortDesc()");
//        allBooks.put("longDesc", "book.getLongDesc()");
//        allBooks.put("bookLocation", "book.getBookLocation()");
//
//        // Add query to store data - new document with a generated ID
//        db.collection("users")
//                .add(allBooks)
//                .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
//                    @Override
//                    public void onSuccess(DocumentReference documentReference) {
//                        Log.d(TAG, "DocumentSnapshot added with ID: " + documentReference.getId());
//                    }
//                })
//                .addOnFailureListener(new OnFailureListener() {
//                    @Override
//                    public void onFailure(@NonNull Exception e) {
//                        Log.w(TAG, "Error adding document", e);
//                    }
//                });

    }

    public static BookUtil getInstance(){
        if(null != instance){
            return instance;
        }else {
            instance = new BookUtil();
            return instance;
        }
    }

    //create getters to get array lists
    public static ArrayList<Books> getAllBooks() {
        return allBooks;
    }

    public static ArrayList<Books> getFavouriteBooks() {
        return favouriteBooks;
    }

    public static ArrayList<Books> readingNow() {
        return readingNow;
    }
    public static ArrayList<Books> favouriteBooks() {
        return favouriteBooks;
    }


    public Books getBookById(int id) {
        for (Books b: allBooks){
            if(b.getId() == id){
                return b;
            }
        }
        return null;
    }

    public ArrayList<Books> getReadingNow() {
        return readingNow;
    }
    //method to add book to a list
    public boolean readingNow(Books books){
        return readingNow.add(books);
    }
    //method to add book to a list
    public boolean favouriteBooks(Books books){
        return favouriteBooks.add(books);
    }
}
