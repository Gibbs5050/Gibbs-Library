package uk.ac.tees.b1448179.gibbse_library;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class Books extends AppCompatActivity {

    private int id;
    private String name;
    private String author;
    private int pages;
    private String imageUrl;
    private String shortDesc;
    private String longDesc;
    private String bookLocation;
    private String storeURL;
    private boolean isExpanded; //for drop down of description

    //constructor
    public Books(int id, String name, String author, int pages, String imageUrl, String shortDesc, String longDesc, String bookLocation, String storeURL ) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.pages = pages;
        this.imageUrl = imageUrl;
        this.shortDesc = shortDesc;
        this.longDesc = longDesc;
        this.bookLocation=bookLocation;
        this.storeURL =  storeURL;
        this.isExpanded = false;
    }

    //getter and setter for dropdown
    public boolean isExpanded() {
        return isExpanded;
    }

    public void setExpanded(boolean expanded) {
        isExpanded = expanded;
    }

    //getters and setters
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public int getPages() {
        return pages;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getShortDesc() {
        return shortDesc;
    }

    public String getLongDesc() {
        return longDesc;
    }


    public String getBookLocation() {
        return bookLocation;


    }
    public String getStoreURL() {
        return storeURL;
    }

    //create tostring
    @Override
    public String toString() {
        return "Books{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", pages=" + pages +
                ", imageUrl='" + imageUrl + '\'' +
                ", shortDesc='" + shortDesc + '\'' +
                ", longDesc='" + longDesc + '\'' +
                ", bookLocation=" + bookLocation + '\'' +
                ", storeURL=" + storeURL + '\'' +
                '}';

    }

//    public Books(int contentLayoutId, int id, String name, String author, int pages, String imageUrl, String shortDesc, String longDesc) {
//        super(contentLayoutId);
//        this.id = id;
//        this.name = name;
//        this.author = author;
//        this.pages = pages;
//        this.imageUrl = imageUrl;
//        this.shortDesc = shortDesc;
//        this.longDesc = longDesc;
//    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_books);
    }
}