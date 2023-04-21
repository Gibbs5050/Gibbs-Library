package uk.ac.tees.b1448179.gibbse_library.AllFragmentsContainer;

//import static androidx.core.content.ContextCompat.Api23Impl.getSystemService;

import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.NotificationManager;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.vectordrawable.graphics.drawable.ArgbEvaluator;
//import androidx.navigation.fragment.NavHostFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;

import uk.ac.tees.b1448179.gibbse_library.AllBooksActivity;
import uk.ac.tees.b1448179.gibbse_library.BookRecViewAdapter;
import uk.ac.tees.b1448179.gibbse_library.Books;
import uk.ac.tees.b1448179.gibbse_library.DictionaryActivity;
import uk.ac.tees.b1448179.gibbse_library.FavouriteBooks;
import uk.ac.tees.b1448179.gibbse_library.FindMe;
import uk.ac.tees.b1448179.gibbse_library.LibraryCatalogue;
import uk.ac.tees.b1448179.gibbse_library.MyLoginActivity;
import uk.ac.tees.b1448179.gibbse_library.OnlineBookSites;
import uk.ac.tees.b1448179.gibbse_library.R;
import uk.ac.tees.b1448179.gibbse_library.WebSwitchActivity;
//import android.widget.EditText;


/*
 * A simple {@link Fragment} subclass.
 * Use the {@link HomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeFragment extends Fragment {

    //create instance of allbooks activities in fragment(create local variable)
    private AllBooksActivity allBooksActivity;
    private RecyclerView booksRecView;
    private BookRecViewAdapter adapter;
    EditText buttonSearch;
//    ImageView buttonSearch9;
    ImageView search_bar;

    @SuppressLint("MissingInflatedId")
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_home, container,false);

        adapter = new BookRecViewAdapter(this.getActivity());
        booksRecView = v.findViewById(R.id.booksRecView);
        booksRecView.setAdapter(adapter);
        booksRecView.setLayoutManager(new LinearLayoutManager(this.getActivity()));
        //first initialize search view
        buttonSearch = v.findViewById(R.id.buttonSearch);
        search_bar = v.findViewById(R.id.search_bar);




        //Initialize the instance of AllBooksActivity
        allBooksActivity = new AllBooksActivity();
        RecyclerView booksRecView = v.findViewById(R.id.booksRecView);

        // layout manager to display items horizontally
        LinearLayoutManager layoutManager = new LinearLayoutManager(this.getActivity(), LinearLayoutManager.HORIZONTAL, false);
        booksRecView.setLayoutManager(layoutManager);


        // adapter and set to the RecyclerView
          booksRecView.setAdapter(adapter);


        //add book
        ArrayList<Books> books = new ArrayList<>();

        books.add(new Books(1,"Harry Potter and the ..", "J. K. Rowling",2500,"https://m.media-amazon.com/images/I/51Q9uPHKhAL._SX324_BO1,204,203,200_.jpg",
                "Description - An ancient prophecy seems to be coming true when a mysterious presence begins stalking the corridors of a school of magic and leaving its victims paralyzed.","Long description"));
        books.add(new Books(2,"Gulliver's Travels", "Jonathan Swift",1760,"https://m.media-amazon.com/images/W/IMAGERENDERING_521856-T1/images/I/51-8gPee03L.jpg",
                "Description - A keystone of English literature, \"Gulliver’s Travels\" was one of the books that gave birth to the novel form, though it did not yet have the rules of the genre as an organizing tool. A parody of the then popular travel narrative, \"Gulliver’s Travels\" combines adventure with savage satire, mocking English customs and the politics of the day","Long description"));
        books.add(new Books(3,"Moby-Dick", "Herman Melville",1300,"https://books.google.co.uk/books/content?id=XV8XAAAAYAAJ&printsec=frontcover&img=1&zoom=1&edge=curl&imgtk=AFLRE72L-MupQeXaFAn5qDqavWvjl4Z566MZ4wsU_2oAfViKaPDPLhyTNhHmHQAl5CbY6x9RNrGFiVF-_uRVZL24SfBU43kcH8wocOwLUFziYx2Z6M4k6LE9a0w3kNAu8LH0aOHc74X_.jpg",
                "Description - A literary classic that wasn't recognized for its merits until decades after its publication, Herman Melville's Moby-Dick tells the tale of a whaling ship and its crew, who are carried progressively further out to sea by the fiery Captain Ahab. Obsessed with killing the massive whale, which had previously bitten off Ahab's leg, the seasoned seafarer steers his ship to confront the creature, while the rest of the shipmates, including the young narrator, Ishmael, and the harpoon expert, Queequeg, must contend with their increasingly dire journey. The book invariably lands on any short list of the greatest American novels","Long description"));
        books.add(new Books(4,"The beautyful ones ..\n", "Ayi Kwei Armah",2000,"https://pictures.abebooks.com/inventory/31241979424.jpg",
                "Description - The central story in this book tells of an upright man resisting the temptations of easy bribes and easy satisfactions and winning for his honesty nothing but scorn.","Long description"));
        books.add(new Books(5,"The Ultimate Harry Potter and Philosophy", "Gregory Bassham",91,"data:image/jpeg;base64,/9j/4AAQSkZJRgABAQAAAQABAAD/2wCEAAkGBwgHBgkIBwgKCgkLDRYPDQwMDRsUFRAWIB0iIiAdHx8kKDQsJCYxJx8fLT0tMTU3Ojo6Iys/RD84QzQ5OjcBCgoKDQwNGg8PGjclHyU3Nzc3Nzc3Nzc3Nzc3Nzc3Nzc3Nzc3Nzc3Nzc3Nzc3Nzc3Nzc3Nzc3Nzc3Nzc3Nzc3N//AABEIAKIAawMBIgACEQEDEQH/xAAaAAACAwEBAAAAAAAAAAAAAAABAgADBQQG/8QAOhAAAgEDAgMGBAQDCAMAAAAAAQIDAAQREiEFEzEiQVFhcZEUMoGxBiNyoTNCwRVSYpLC0eHwFlOy/8QAGQEBAQEBAQEAAAAAAAAAAAAAAAEDAgQF/8QAIREBAQACAgICAwEAAAAAAAAAAAECESExAxIEURMy8EH/2gAMAwEAAhEDEQA/APEwpGYkzGnyj+UVZyUxkRLj9NJFjlJ+kfarRM+NIchcEYHgev2HtXsjAvIXOOUufDTS8lM45S79OzVpnl1auY+rxz5Y+1BJZBIrB" +
                "21KMKe8elAnJT/1Lv8A4aUwrkfkj/LV2qTbtP2VAXJ6AHb6ZqxmKHCXEnZdguAehG5+tBzwWjXDlYIFdgM4AFF7CRDh7cA6xHjA+Y5AHup9qtgdopA8M8kbnSCVyDg9fagk0w5oFzNgYZevbIbb7k1FUrYyOGKwAhVZm7I2C9T9K" +
                "aXhs8JjEtvpMpxHsO0cA/1HvVj3VwHkCXMrBicnURqz198/vVclxcSGMyTSMY/4eons+nsPagI4VcsFK2hOpNa4A3XGc+1IeGzhJW+GGmLBc4G2c4/+TTJfXcbKUuZlKgBcOdgCCB7qvtSLdTojIk0gV10sNR3GMY9Nz70Nublpn5F9q" +
                "YJHj5F9hTYqYqptZF/CT9I+1NQi/hJ+kU+AaQLV1tcPazpNHjUuevmCD+xqvA1DU2le84zgeNaMPB5LjiNzZW0ome3lSORljbAJbTn0FcZ+TDD9qslvQf23eHG6bAADGwAZW+6ioONXikFNK4bUMA9dJX7GuY22nhkN+znlzOyIAhIyPE9" +
                "M+VWPZFLRbhpECkJt39pmUfuprn8nj+15GPil3Hci4DguIjEM9yk5pk4zdKykBBp0AYGNk+WqzaInx3NuFX4QdrsE6t8bUYOGTXLtHCyNKLQXQQdWBYDA8+1Uvl8U7prIW4vdNEYjyypjMXydFKqv+kGqeIcQn4hKJLjTkAgYGOpJ/rVsnC" +
                "5Fm4jGJY2+ATVIVOx8h9M+1LDw4T3FhBFcq0l6pZRobsgZ6+PQ0/N4vv8AuzWTgNCnkASWRAWOhipypU7eIPSlrWXc3HIUcURimG4qiRH8pP0iiTSQnEaD/CKfrUg6ZbKWOygvJDFyLh2SPt7krjO3lqFX3gvuH3fOkniE13yr1WUhsg9tG" +
                "/rVnEHVfw5wSMRRyut3cllY7oGEeDgHvwfatG4tLa84tZXF0Yfh4eF8PhkjEmCCRpYDfbT3+G1Z5euX7R1J9PN5f4OC1JjMcLEoWQahk5OG61dPc3EttHbc0CFGDY0jJwSRv4ZJ2860btLC04feyLam4mj4m9tEvxHWHS2H28CFroRODLxq" +
                "y4fcWrJBcQRmS5+JJ5UjxA49FfY+Wanr49dHLNhhvuL3F2kLQh5Yi8gChMqvaJ9dqSaK+js14hHOORMgtFmiYdnSQ+nbodga0vw7LAvGboKEWKOyniZ+Z2Xk5bKcE9xPT1rPsOXPwOeCVeX8IouLezD4M0pKozE95VM7UuGHWl3XMl7eR" +
                "fFcq50m7zzjoB1DSVIP0NZ8PFbi24vaCOUH4aIxxalBG+T9etemupLWHhfGrOw0PIbeyleJpgCjnPMUHvCk9f8Aaq/xDw+x4vxaa7SaIyR8KtpLOKOUH4hgFDAbjJUats5P0rO4+P8AyOpKwowQT2UXJJCxrpUegHSrBWsh4U3B73iEdn" +
                "IzreCKCF7gauWVO509dJx7VjgnSMjB769GNmuGdiE71AdqXfvo1VNGPyk/SKOSOlJGfy0z00itO3/spOGu93Mpu2+SM6104YDBI2OVzU3oZqxCadFwutmCqx7s7VeeFtJxZuGKkcl0JzbgA7M+rSACfE1pyS/h5Y5ZbeRUnjupOSHZ9Lx" +
                "CVdLHz5er6+eKr4TJHN+OoriKRWhbi6yiQZA0mUHO48K59l04RwiXlzyiJDHbShLhkYExMSRuPUHfpV91DLwXjXErKykV5o3a1aQRgltx0Bzg5HUb0lxcyiXiljaosK3V63NcEkuokLDHlnfbyra43DZzcU45eBG5w48sSsk3zxvnLAeW2" +
                "4pvkZLcNW34NJdXLMjpdi1eB49LBipbfPp0rjYRiPQqjTjp3V6OWysmS44a92YbP/yRFM7yajy+W3ayeu+Bnpk1x2VlY3Mdu1ystncSXUsTQj8w8tY9WvGQcahg4O/dSZ8Hq8dxuBcpMAB/KRj2rJKKScKMV7vjljw1oHa1KXjLfRQiCKR" +
                "k0xMgOvtYbqSN+hzQg/DvARcQ6GmvLM8amsGuhNo/JVFYPttkajv0OPOsc+3cZltw+O04Nwq6aZZF4hzmRNOOWY2CkZ7+tWk1tcPteH3Vv+FuHzPzIAnEysgl0lQpZkJ9dK9djmuO+PDRwbh99aIRJeQlGgMvaimRhryP7pBUj1rTDLjTn" +
                "KM8nwpaBz9agNduVkZ/LT9IoEZ6ge1BCNC/pFOGXFAmkHuFX20UMjFZpxCmBlj35YA/sSfpVW3jQO9BbDaIYtS3Nsi5AyZOhOevf3VWbOAbi5t9wW2fvwTjy6D3pQik576S7PLtpWwMhD0HfipViqwhha0fM8LSJcOvz7EAKQR65/anvba3" +
                "ktJFe7iRg5CnPZbAyN+4ZAHTvrO4XKkcMpcgKGz7j/iq76+M6ctU0x+PeTXG56utcuuTh3OuBJPc2ywAhXZJRnQMAke+fT0rnmuJk4RFw8yWT26ytKEjYlw7KoZic+AA8NulclyVklLgDBC/aqtNZ10hRSCPHb6V6W3nmv4oZrkQDQuiNYYVjAA8lAGT3nvrzOK9BwnK2CA7ZJI9M134+0y6XzaYimT87af2NOFXG9Z3GZSqQ46htVdkUvMjVx0YZrXfOnGuET+GPQVDSIfy19BRzUQwog0Fp8DxFUct5O8bW4X+aQZ/79aTiF7Gsbwg6nYFdugqnjEg1xIp3GWbHd0xWZ5DpWWWWuHciDpQzvTAbikXYms3ZugFGr7iQPHGoWMaQN1GM+tcxxtipFy4Pg56Vs8MfFlGPAn71iZGN60LC5iSHlu+k6iRmtMLy4y6DjD6pIx4LmuRLm4jULHIVUdBVnEX5l0SpBUKAMGuWpbyTp6JPkX0FHFCIEqvpVuBitmav671TdTNFAzKd9vvXQRXHxEYtj+oVLeFnbKdmkbU5yelLkDNOpGM+f8AtSP1rDbU8bAI225AANITj5aVKbTigG5NQrTCien9aCsjaoMnvrTseA8V4hAJ7WykaA9JXIjRvQsRn6Zqu94Vf2C6ru1dE/vgh191JAovplrenCetH0ot59fCgOlHLeU9lfQU2psUithFz4Cm1ZFbs01GuTibYgUeLCukEFWAO+SKxpw6zMsramB65rnK8OpOVfhQaj40CfasnQjYVM0M7edSgbOOlbH4Ys4J7qa6u0EsFogcxnpI5OFU+WxP0rGrc/DUoIuLXIUyFGBPQ6dX+9S9N/jYY5+WTLp6e4M01wrTtBda8Ku5Kpt0AHQD+lJNay6CI7ULqO4EmoMMHbB+/lVqxkPHGbGB/wAoBWVhl9wurPUHJ8q554nTWY4JouwpCq2QRvuTnwzWb7ku7p4ziUAtrtkUflsNS+XlXHnwru45Ir34VTnQuDXHjyrSdPhfIxk8uUxd81x24lXO25q6O4VozvuM91ZbN+aWx39O6ortns5yenfXfsw071ulSKQ5BbVsPGs9mLEljk95qFmY5OaBz4GpbtUBod9TBxkioQd9jt5VAamfClornoFNBOmKdZXikV4zhl3FKe/Y+1NPFJG2l1IIGaLLZzGvb8eVF/OR1bvKHY1Lr8SytEY7YybjBLGsbS2M6T7UuCDuKnrHqvzfLcdVFDEl2OWO5oYPjTb0KryXkX+ZvU112LPbSRXsE0AkhcFVkPQ+neK5G+ZvU10C+cFcQ223dyh40Gj8dexoIxNYAJ2BgA9zf89fGjdcSv7wyG5l4e2TpYgAfMoTbHl9qzI72SMKFigOO8xg5qNeSFtRjh7jjl7bADp9KDQa6vniW1aexZHGACw2wAu5+g/6atfiXEmd9VxYKWcsfl/m1ZHsxrM+Pchg0Fvgrp2iG3nQS/kQgiK3znOTGDQaUPEuIJcvdJcWQkcYbWF2wx6D6+xqv+0b+CSRlns8uNbYAK5AVdvPYfvXCt/IoOmK3DZBB5Y2oC9kDAqkIIBG0Y3BGMUGlHdXkcTxtNYnXnOSM9rJ/wBZ/wCijc317cWzxST2bBlYkDGTnY4I7+1Wd8dJzOZogDaSv8IYIPlUN9KFAEcGy6c8sdKDTPEeIBxmawBHa7u7I3/zGs68Esz82WW3JEYxobqBt9TSTXplTtRQ7nJxHjFQX0mll0Q6WyccsbZ8KDnNTaoalBH+Zv1Gko1KCL1o/wA1SpRS1KNSiB31KlSiiOlQ1KlBF76g6/SjUoJRqVKD/9k=.jpg",
                "Description - A literary classic that wasn't recognized for its merits until decades after its publication, Herman Melville's Moby-Dick tells the tale of a whaling ship and its crew, who are carried progressively further out to sea by the fiery Captain Ahab. Obsessed with killing the massive whale, which had previously bitten off Ahab's leg, the seasoned seafarer steers his ship to confront the creature, while the rest of the shipmates, including the young narrator, Ishmael, and the harpoon expert, Queequeg, must contend with their increasingly dire journey. The book invariably lands on any short list of the greatest American novels","Long description"));

        books.add(new Books(6,"Moby-Dick", "Herman Melville",1300,"https://books.google.co.uk/books/content?id=XV8XAAAAYAAJ&printsec=frontcover&img=1&zoom=1&edge=curl&imgtk=AFLRE72L-MupQeXaFAn5qDqavWvjl4Z566MZ4wsU_2oAfViKaPDPLhyTNhHmHQAl5CbY6x9RNrGFiVF-_uRVZL24SfBU43kcH8wocOwLUFziYx2Z6M4k6LE9a0w3kNAu8LH0aOHc74X_.jpg",
                "Description - A literary classic that wasn't recognized for its merits until decades after its publication, Herman Melville's Moby-Dick tells the tale of a whaling ship and its crew, who are carried progressively further out to sea by the fiery Captain Ahab. Obsessed with killing the massive whale, which had previously bitten off Ahab's leg, the seasoned seafarer steers his ship to confront the creature, while the rest of the shipmates, including the young narrator, Ishmael, and the harpoon expert, Queequeg, must contend with their increasingly dire journey. The book invariably lands on any short list of the greatest American novels","Long description"));



        adapter.setBooks(books); //pass array list




        // add on query text listener for search view so when user type something in search view

//        //create a progress dialog
//        ProgressDialog progressDialog;

//        //initialize it
//        progressDialog = new ProgressDialog(this.getActivity());



////
////        String query = "name";

        //search button click
        search_bar.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceType")
            @Override
            public void onClick(View v) {
                //create a dialog prompt
                AlertDialog.Builder builder = new AlertDialog.Builder(HomeFragment.this.getActivity());
                View customLayout = getLayoutInflater().inflate(R.layout.gibbs_dialog, null); //use designed layout as custom layout
                builder.setView(customLayout);
                //customise dialog layout
                TextView titleTextView = customLayout.findViewById(R.id.title_text_view);
                TextView messageTextView = customLayout.findViewById(R.id.message_text_view);
                TextView negativeButton = customLayout.findViewById(R.id.negative_button);
                TextView positiveButton = customLayout.findViewById(R.id.positive_button);

                titleTextView.setText("Redirecting...");
                messageTextView.setText("Explore Library dictionary" +
                        " to learn new words or continue to book search? " +
                        "(Click cancel to go to dictionary)");

                //create and initialize dialog
                AlertDialog dialog = builder.create();
                dialog.show();

                negativeButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // handle negative button click


                        Intent myIntent = new Intent(HomeFragment.this.getActivity(), DictionaryActivity.class);
//                myIntent.putExtra(query,query);//show web view
                        startActivity(myIntent);
                        dialog.dismiss();
                    }
                });


                positiveButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // handle intent positive button click
                        String value = buttonSearch.getText().toString();

                        Intent myIntent = new Intent(HomeFragment.this.getActivity(), WebSwitchActivity.class);
                        myIntent.putExtra("url","https://www.google.com/search?tbm=bks&q="+ value);//show web view
                        startActivity(myIntent);
//                        HomeFragment.this.startActivity(myIntent);
                        dialog.dismiss();
                    }
                });
            }
        });




//                .setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//
//
//
//
////
////                progressDialog.setTitle("Fetching response for " + query);
////                progressDialog.show();
////
////                //call API
//////                RequestManager manager = new RequestManager(HomeFragment.this.getActivity());
////                Intent myIntent = new Intent(HomeFragment.this.getActivity(), DictionaryActivity.class);
////                HomeFragment.this.startActivity(myIntent); //implement the intent ie switch to the fragment required
//                Intent myIntent = new Intent(HomeFragment.this.getActivity(), DictionaryActivity.class);
////                myIntent.putExtra(query,query);//show web view
//                startActivity(myIntent);
////                manager.getWordMeaning(listener,query);
//
//            }
//        });


//                setOnQueryTextListener(new SearchView.OnQueryTextListener() {
//            @Override
//            public boolean onQueryTextSubmit(String query) {
//
//                progressDialog.setTitle("Fetching response for " + query);
//                progressDialog.show();
//
//                //call API
////                RequestManager manager = new RequestManager(HomeFragment.this.getActivity());
////                Intent myIntent = new Intent(HomeFragment.this.getActivity(), DictionaryActivity.class);
////                HomeFragment.this.startActivity(myIntent); //implement the intent ie switch to the fragment required
//                Intent myIntent = new Intent(HomeFragment.this.getActivity(), DictionaryActivity.class);
//                            myIntent.putExtra(query,query);//show web view
//                            startActivity(myIntent);
////                manager.getWordMeaning(listener,query);
//
//                return true;
//            }
//
//            @Override
//            public boolean onQueryTextChange(String newText) {
//                return false;
//            }
//        });
//
////        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
////            @Override
////            public boolean onQueryTextSubmit(String query) {
////
//////                progressDialog.setTitle("Fetching response for " + query);
//////                progressDialog.show();
////
////////                @SuppressLint("ResourceType")
////////                @Override
//////                public void onClick(View v) {
////                    //create a dialog prompt
////
////                    //dialog to confirm if you want to search dictionary or web
////                    AlertDialog.Builder builder = new AlertDialog.Builder(HomeFragment.this.getActivity());
////                    View customLayout = getLayoutInflater().inflate(R.layout.gibbs_dialog, null); //use designed layout as custom layout
////                    builder.setView(customLayout);
////                    //customise dialog layout
////                    TextView titleTextView = customLayout.findViewById(R.id.title_text_view);
////                    TextView messageTextView = customLayout.findViewById(R.id.message_text_view);
////                    Button negativeButton = customLayout.findViewById(R.id.negative_button);
////                    Button positiveButton = customLayout.findViewById(R.id.positive_button);
////
////                    titleTextView.setText("Redirecting to web..");
////                    messageTextView.setText("Do you want to search library dictionary for meaning of word first? (Click cancel to search dictionary first)");
////
////                    //create and initialize dialog
////                    AlertDialog dialog = builder.create();
////                    dialog.show();
////
//////                    negativeButton.setOnClickListener(new View.OnClickListener() {
//////                        @Override
//////                        public void onClick(View v) {
//////                            // handle negative button click - go to dictionary
//////
//////
//////                            Toast.makeText(getContext(), "Fantastic! Opening Dictionary....!!", Toast.LENGTH_LONG).show();
//////                            Intent myIntent = new Intent(HomeFragment.this.getActivity(),DictionaryActivity.class);
//////                            HomeFragment.this.startActivity(myIntent);
////////                            dialog.dismiss();
//////                        }
//////                    });
//////
//////
//////                    positiveButton.setOnClickListener(new View.OnClickListener() {
//////                        @Override
//////                        public void onClick(View v) {
//////                            // handle intent positive button click
//////
////////
//////////                                String query = "puppies";
////////                                int startIndex = 1;
////////                                int numResults = 10;
////////                                String searchType = "Books";
////////                                String cseId = "009fa0a6fd822445b";
////////                                String apiKey = "AIzaSyCH84UPsOZUSBQ3s59qVdkzo1dXpBLLk08";
////////
////////                            OkHttpClient client = new OkHttpClient();
////////
////////                            String url = "https://www.googleapis.com/customsearch/v1"
////////                                    + "?key=" + apiKey      //my api key
////////                                    + "&cx=" + cseId        //Custom Search Engine ID
////////                                    + "&q=" + query
////////                                    + "&start=" + startIndex
////////                                    + "&num=" + numResults
////////                                    + "&searchType=" + searchType;
////////
////////                            Request request = new Request.Builder()
////////                                    .url(url)
////////                                    .build();
////////
////////                            Response response = null;
////////                            try {
////////                                response = client.newCall(request).execute();
////////                            } catch (IOException e) {
////////                                e.printStackTrace();
////////                            }
////////                            String jsonResponse = null;
////////                            try {
////////                                jsonResponse = response.body().string();
////////                            } catch (IOException e) {
////////                                e.printStackTrace();
////////                            }
////////
////////// Use Gson to parse the JSON response into a SearchResponse object
////////                            SearchResponse searchResponse = new Gson().fromJson(jsonResponse, SearchResponse.class);
//////
////////
////////                            String query = "puppies";
////////                                int startIndex = 1;
////////                                int numResults = 10;
////////                                String searchType = "image";
////////                                String apiKey = "AIzaSyCH84UPsOZUSBQ3s59qVdkzo1dXpBLLk08";
////////
////////                                // Create the Google Custom Search API URL
////////                                String url = "https://www.googleapis.com/customsearch/v1?key=" + apiKey + "&cx=" + SEARCH_ENGINE_ID + "&q=" + query + "&start=" + startIndex + "&num=" + numResults + "&searchType=" + searchType;
////////
////////                                // Use Volley library to make API request
////////                                JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null,
////////                                        response -> {
////////                                            // Handle response from API
////////                                        },
////////                                        error -> {
////////                                            // Handle error from API
////////                                        });
////////
////////                                // Add request to Volley request queue
////////                                Volley.newRequestQueue(this).add(request);
//////
//////
////////
////////
////////
////////
////////
////////
////////                            Intent myIntent = new Intent(HomeFragment.this.getActivity(), WebSwitchActivity.class);
////////                            myIntent.putExtra("url","http://www.google.com/search?q=");//show web view
////////                            startActivity(myIntent);
//////
//////
//////                            dialog.dismiss();
////////                        HomeFragment.this.startActivity(myIntent);
//////                        }
//////                    });
//////
//////
//////
//////
////////                //call API
////////                RequestManager manager = new RequestManager(HomeFragment.this.getActivity());
////////                manager.getWordMeaning(listener,query);
//////
//////                return true;
//////            }
////
////            @Override
////            public boolean onQueryTextChange(String newText) {
////                return false;
////            }
////        });
//
//
//
//
////
////        //Implement book search
////        //retrieve search reference
////        SearchView searchView = v.findViewById(R.id.searchView);
////        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
////            @Override
////            public boolean onQueryTextSubmit(String query) {
////                // TODO: Implement book search using query
////
////                String query = URLEncoder.encode(query, "UTF-8"); // URL-encode the query parameter
////                int maxResults = 10; // Set the maximum number of search results to retrieve
////
////                String apiUrl = "https://www.googleapis.com/books/v1/volumes?q=" + query + "&maxResults=" + maxResults + "&key=" + apiKey;
////
////// Call the API using the code we discussed earlier
////// Once you retrieve the book search result, you can use it to populate your app UI
////
////
////
////                return false;
////            }
////
////            @Override
////            public boolean onQueryTextChange(String newText) {
////                // TODO: Implement search suggestions using newText
////                String query = URLEncoder.encode(query, "UTF-8"); // URL-encode the query parameter
////                int maxResults = 10; // Set the maximum number of search results to retrieve
////
////                String apiUrl = "https://www.googleapis.com/books/v1/volumes?q=" + query + "&maxResults=" + maxResults + "&key=" + apiKey;
////
////// Call the API using the code we discussed earlier
////// Once you retrieve the book search result, you can use it to populate your app UI
////
////
////                return false;
////            }
////        });
////        String apiUrl = "https://www.googleapis.com/books/v1/volumes?q=" + query + "&maxResults=" + maxResults + "&key=" + apiKey;
////
////        HttpURLConnection connection = null;
////        try {
////            URL url = new URL(apiUrl);
////            connection = (HttpURLConnection) url.openConnection();
////            connection.setRequestMethod("GET");
////
////            InputStream inputStream = connection.getInputStream();
////            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
////            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
////
////            StringBuilder stringBuilder = new StringBuilder();
////            String line;
////            while ((line = bufferedReader.readLine()) != null) {
////                stringBuilder.append(line);
////            }
////            String response = stringBuilder.toString();
////
////            //ToDo create a class book search result
////            Gson gson = new Gson();
////            BookSearchResult bookSearchResult = gson.fromJson(response, BookSearchResult.class);
////
////            // Use the book search result in your app UI
////        } catch (IOException e) {
////            e.printStackTrace();
////        } finally {
////            if (connection != null) {
////                connection.disconnect();
////            }
////        }
//
//
//





        //to set up on click listener for drawer layout
        DrawerLayout drawerLayout = v.findViewById(R.id.drawerLayout);
        ImageView menuButton = v.findViewById(R.id.imageMenu);
        menuButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.openDrawer(GravityCompat.START);
            }
        });


//        // Set up an OnClickListener for the navigation drawer button
//        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
//            @Override
//            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//                // Handle navigation drawer item clicks here
//                return true;
//            }
//        });
        //private DashboardFragmentListener listener;
        //declaration and initialization
        CardView myCatalogue = v.findViewById(R.id.myCatalogue);
        myCatalogue.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceType")
            @Override
            public void onClick(View v) {

                //pull out shelve
                drawerLayout.openDrawer(GravityCompat.START);
            }
        });

        CardView textSpotMe = v.findViewById(R.id.textSpotMe);
        textSpotMe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(HomeFragment.this.getActivity(), FindMe.class);
                HomeFragment.this.startActivity(myIntent);
            }
        });

//        //declare and initialize object
//        ImageView imageViewSelectBook2 = v.findViewById(R.id.imageViewSelectBook2);
//        //animation
//        Animation anim = AnimationUtils.loadAnimation(this.getActivity(), R.anim.landing_anim);
//        imageViewSelectBook2.setAnimation(anim);


        //set Up drawer buttons
        Button signOut = v.findViewById(R.id.signOut);
        FirebaseAuth auth = FirebaseAuth.getInstance();
        signOut.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("RestrictedApi")
            @Override
            public void onClick(View v) {

                auth.signOut();
                startActivity(new Intent(getContext(), MyLoginActivity.class));
                Toast.makeText(getContext(), "Logged out successfully!!", Toast.LENGTH_LONG).show();

                // Define the animation
                ObjectAnimator anim = ObjectAnimator.ofInt(signOut, "backgroundColor", Color.BLUE, Color.RED);
                anim.setDuration(1000); // Duration in milliseconds
                anim.setEvaluator(new ArgbEvaluator());
                // Start the animation
                anim.start();
            }
        });


        //set up drawer link to catalog
        ImageView drawer_shelve = v.findViewById(R.id.drawer_shelve);
        drawer_shelve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(HomeFragment.this.getActivity(), LibraryCatalogue.class);
                HomeFragment.this.startActivity(myIntent); //implement the intent ie switch to the fragment required
            }
        });

        //set up trending books find
        CardView trendingBooks = v.findViewById(R.id.trendingBooks);
        trendingBooks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(HomeFragment.this.getActivity(), AllBooksActivity.class);
                HomeFragment.this.startActivity(myIntent); //implement the intent ie switch to the fragment required
            }
        });


//        //make text blink
//        TextView textView8 = v.findViewById(R.id.textView8);
////        Handler handler = new Handler();
////        Runnable runnable = new Runnable() {
////            boolean visible = true;
////
////            @Override
////            public void run() {
////                textView8.setVisibility(visible ? View.VISIBLE : View.INVISIBLE);
////                visible = !visible;
////                handler.postDelayed(this, 500); // changes delay time (in milliseconds) as needed
////            }
////        };
////        handler.post(runnable); //executes blink
//////
//////
//
        //top books store set up
        CardView topBookStores = v.findViewById(R.id.topBookStores);
        topBookStores.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(HomeFragment.this.getActivity(), OnlineBookSites.class);
                HomeFragment.this.startActivity(myIntent); //implement the intent ie switch to the fragment required

                    }
                });

        //set up my dictionary click
        CardView myDictionary = v.findViewById(R.id.myDictionary);
        myDictionary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(HomeFragment.this.getActivity(),DictionaryActivity.class);
                HomeFragment.this.startActivity(myIntent);
            }
        });

        //create text for about app
        String aboutAppText = "This is a web based Library and the best place to explore different flexible learning platforms.\n " +
                "With the help of so many amazing books and E-Learning features, Gibbs Library creates a safe and less noisy space where you can learn and develop skills in any field. \n \n" +
                "We have done our research, Now Let's learn together!";

        //set up my about click listener
        CardView myAbout = v.findViewById(R.id.myAbout);
        myAbout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //create a dialog prompt
                AlertDialog.Builder builder = new AlertDialog.Builder(HomeFragment.this.getActivity());
                View customLayout = getLayoutInflater().inflate(R.layout.gibbs_dialog, null); //use designed layout as custom layout
                builder.setView(customLayout);
                //customise dialog layout
                TextView titleTextView = customLayout.findViewById(R.id.title_text_view);
                TextView messageTextView = customLayout.findViewById(R.id.message_text_view);
                Button negativeButton = customLayout.findViewById(R.id.negative_button);
                Button positiveButton = customLayout.findViewById(R.id.positive_button);

                titleTextView.setText("About Gibbs Library");
                messageTextView.setText(aboutAppText);

                //create and initialize dialog
                AlertDialog dialog = builder.create();
                dialog.show();

                negativeButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // handle negative button click
                        dialog.dismiss();
                    }
                });
                positiveButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // handle intent positive button click
                        dialog.dismiss();
                    }
                });
            }
        });

        //set up my browser click listener
        CardView myBrowser = v.findViewById(R.id.myBrowser);
        myBrowser.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceType")
            @Override
            public void onClick(View v) {

                // handle intent positive button click
                Intent myIntent = new Intent(HomeFragment.this.getActivity(), WebSwitchActivity.class);
                myIntent.putExtra("url","https://google.com/");//show web view
                startActivity(myIntent);
        }
    });

        //set up my favourite card view
        CardView myFavorite = v.findViewById(R.id.myFavorite);
        myFavorite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(HomeFragment.this.getActivity(), FavouriteBooks.class);
                HomeFragment.this.startActivity(myIntent); //implement the intent ie switch to the fragment required
            }
        });

        return v;

    }

    private Object getSystemService(Class<NotificationManager> notificationManagerClass) {
        return null;
    }


//    //method for google search
//    private void searchImages() {
//        String query = "puppies";
//        int startIndex = 1;
//        int numResults = 10;
//        String searchType = "image";
//        String apiKey = "YOUR_API_KEY";
//
//        // Create the Google Custom Search API URL
//        String url = "https://www.googleapis.com/customsearch/v1?key=" + apiKey + "&cx=" + SEARCH_ENGINE_ID + "&q=" + query + "&start=" + startIndex + "&num=" + numResults + "&searchType=" + searchType;
//
//        // Use Volley library to make API request
//        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null,
//                response -> {
//                    // Handle response from API
//                },
//                error -> {
//                    // Handle error from API
//                });
//
//        // Add request to Volley request queue
////        Volley.newRequestQueue(this).add(request);
//    }
}