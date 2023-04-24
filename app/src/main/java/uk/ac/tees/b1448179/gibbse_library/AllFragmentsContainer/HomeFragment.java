package uk.ac.tees.b1448179.gibbse_library.AllFragmentsContainer;

//import static androidx.core.content.ContextCompat.Api23Impl.getSystemService;

import android.Manifest;
import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.NotificationManager;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.vectordrawable.graphics.drawable.ArgbEvaluator;
//import androidx.navigation.fragment.NavHostFragment;
import android.os.Environment;
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
import uk.ac.tees.b1448179.gibbse_library.BookActivity;
import uk.ac.tees.b1448179.gibbse_library.BookRecViewAdapter;
import uk.ac.tees.b1448179.gibbse_library.BookUtil;
import uk.ac.tees.b1448179.gibbse_library.Books;
import uk.ac.tees.b1448179.gibbse_library.DictionaryActivity;
import uk.ac.tees.b1448179.gibbse_library.FavouriteBooks;
import uk.ac.tees.b1448179.gibbse_library.FileReaderActivity;
import uk.ac.tees.b1448179.gibbse_library.FindMe;
import uk.ac.tees.b1448179.gibbse_library.LibraryCatalogue;
import uk.ac.tees.b1448179.gibbse_library.MyLoginActivity;
import uk.ac.tees.b1448179.gibbse_library.OnlineBookSites;
import uk.ac.tees.b1448179.gibbse_library.PDFViewer;
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
    Button exploreButton;
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
        exploreButton = v.findViewById(R.id.exploreButton);

        //click to go to files
        exploreButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(checkPermission()){
                    //permission allowed
                    Intent intent = new Intent(HomeFragment.this.getActivity(), FileReaderActivity.class);
                    String path = Environment.getExternalStorageDirectory().getPath();
                    intent.putExtra("path",path);
                    startActivity(intent);
                }else{
                    //permission not allowed
                    requestPermission();

                }
            }
        });






        //Initialize the instance of AllBooksActivity
        allBooksActivity = new AllBooksActivity();
        RecyclerView booksRecView = v.findViewById(R.id.booksRecView);

        // layout manager to display items horizontally
        LinearLayoutManager layoutManager = new LinearLayoutManager(this.getActivity(), LinearLayoutManager.HORIZONTAL, false);
        booksRecView.setLayoutManager(layoutManager);

        // set up RecyclerView
          booksRecView.setAdapter(adapter);

        //add book
        ArrayList<Books> books = new ArrayList<>();

//        // Create an intent to start the new activity
//        Intent intent = new Intent(this.getActivity(), BookActivity.class);
//
//
////        // Add any extra data to the intent, if needed
////        intent.putExtra("key", value);
//
//        // Start the new activity
//        startActivity(intent);




        books.add(new Books(1,"Harry Potter and the ..", "J. K. Rowling",2500,"https://m.media-amazon.com/images/I/51Q9uPHKhAL._SX324_BO1,204,203,200_.jpg",
                "Description - An ancient prophecy seems to be coming true when a mysterious presence begins stalking the corridors of a school of magic and leaving its victims paralyzed.","Long description","https://www.gutenberg.org/files/2701/2701-h/2701-h.htm",""));
        books.add(new Books(2,"The Deadly Thinkers", "Wm. Gray Beyer",132,"https://www.gutenberg.org/cache/epub/70623/pg70623.cover.medium.jpg",
                "Description - Click to view description","Urei was what they called the huge Unified Reflexive Electronic Integrator, and the vast machine seemed to be developing a personality of its own. Then men began to suspect that Urei had acquired sentience, and with that came the fear of its interference with human minds.","https://www.gutenberg.org/files/2701/2701-h/2701-h.htm",""));
        books.add(new Books(3,"Moby-Dick", "Herman Melville",1300,"https://books.google.co.uk/books/content?id=XV8XAAAAYAAJ&printsec=frontcover&img=1&zoom=1&edge=curl&imgtk=AFLRE72L-MupQeXaFAn5qDqavWvjl4Z566MZ4wsU_2oAfViKaPDPLhyTNhHmHQAl5CbY6x9RNrGFiVF-_uRVZL24SfBU43kcH8wocOwLUFziYx2Z6M4k6LE9a0w3kNAu8LH0aOHc74X_.jpg",
                "Description - A literary classic that wasn't recognized for its merits until decades after its publication, Herman Melville's Moby-Dick tells the tale of a whaling ship and its crew, who are carried progressively further out to sea by the fiery Captain Ahab. Obsessed with killing the massive whale, which had previously bitten off Ahab's leg, the seasoned seafarer steers his ship to confront the creature, while the rest of the shipmates, including the young narrator, Ishmael, and the harpoon expert, Queequeg, must contend with their increasingly dire journey. The book invariably lands on any short list of the greatest American novels","Long description","https://www.gutenberg.org/files/2701/2701-h/2701-h.htm",""));
        books.add(new Books(4,"The beautyful ones ..\n", "Ayi Kwei Armah",2000,"https://pictures.abebooks.com/inventory/31241979424.jpg",
                "Description - The central story in this book tells of an upright man resisting the temptations of easy bribes and easy satisfactions and winning for his honesty nothing but scorn.","Long description","https://www.gutenberg.org/files/2701/2701-h/2701-h.htm",""));
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

                Intent MyIntent= new Intent(HomeFragment.this.getActivity(),FindMe.class);
                startActivity(MyIntent);
            }
        });

        //set up my browser click listener
//        CardView myBrowser = v.findViewById(R.id.pdfViewer);
//        myBrowser.setOnClickListener(new View.OnClickListener() {
//            @SuppressLint("ResourceType")
//            @Override
//            public void onClick(View v) {
//
//                // handle intent positive button click
//                Intent myIntent = new Intent(HomeFragment.this.getActivity(), WebSwitchActivity.class);
//                myIntent.putExtra("url","https://google.com/");//show web view
//                startActivity(myIntent);
//        }
//    });

        //set up pdf reader

        CardView pdfReader = v.findViewById(R.id.pdfViewer);
        pdfReader.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // handle intent positive button click
                Intent i = new Intent(allBooksActivity.getApplicationContext(), PDFViewer.class);
//                Intent i = new Intent( getA HomeFragment.this.getActivity(), PDFViewer.class);
//                myIntent.putExtra("url","https://google.com/");//show web view
                startActivity(i);

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

        //Set up view all link to book activity
        TextView viewAllTrending = v.findViewById(R.id.viewAllTrending);
        viewAllTrending.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewAllTrending.setTextColor(getResources().getColor(R.color.amber)); //change colour on click
                Intent myIntent = new Intent(HomeFragment.this.getActivity(), AllBooksActivity.class);
                startActivity(myIntent);

            }
        });

        //Set up view all link to book catalogue
        TextView viewAllTopPicks = v.findViewById(R.id.viewAllTopPicks);
        viewAllTopPicks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewAllTopPicks.setTextColor(getResources().getColor(R.color.amber)); //change colour on click
                Intent myIntent = new Intent(HomeFragment.this.getActivity(), AllBooksActivity.class);
                startActivity(myIntent);

            }
        });

        //load read items on new recycler view
        RecyclerView booksRecView1 = v.findViewById(R.id.booksRecView1);

        //reuse adapter
        BookRecViewAdapter adapter = new BookRecViewAdapter(this.getContext());
        booksRecView1.setAdapter(adapter);
        booksRecView1.setLayoutManager(new LinearLayoutManager(this.getContext(),LinearLayoutManager.HORIZONTAL,false)); //set layout and configure as horizontal
        adapter.setBooks(BookUtil.getInstance().getReadingNow());


//        // layout manager to display items horizontally
//        LinearLayoutManager layoutManager1 = new LinearLayoutManager(this.getActivity(), LinearLayoutManager.HORIZONTAL, false);


        return v;

    }

    private Object getSystemService(Class<NotificationManager> notificationManagerClass) {
        return null;
    }

    //method to handle file requests to read and write from folder
    private boolean checkPermission(){
        int result = ContextCompat.checkSelfPermission(HomeFragment.this.getActivity(), Manifest.permission.WRITE_EXTERNAL_STORAGE);
        if(result == PackageManager.PERMISSION_GRANTED){
            return true;
        }else
            return false;
    }

    private void requestPermission(){
        if(ActivityCompat.shouldShowRequestPermissionRationale(HomeFragment.this.getActivity(),Manifest.permission.WRITE_EXTERNAL_STORAGE)){
            Toast.makeText(HomeFragment.this.getActivity(),"Storage permission is requires,please allow from settings",Toast.LENGTH_SHORT).show();
        }else
            ActivityCompat.requestPermissions(HomeFragment.this.getActivity(),new String[] {Manifest.permission.WRITE_EXTERNAL_STORAGE},111);
    }
}