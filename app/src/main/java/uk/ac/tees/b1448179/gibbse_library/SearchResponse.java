package uk.ac.tees.b1448179.gibbse_library;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;

import com.google.gson.Gson;

import java.io.IOException;
import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class SearchResponse extends AppCompatActivity {
    private String kind;
    private SearchInformation searchInformation;
    private List<Item> items;
    ProgressDialog progressDialog;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search_engine);




        // add on query text listener for search view so when user type something in search view

//        //create a progress dialog
//        ProgressDialog progressDialog;

//        //initialize it
//        progressDialog = new ProgressDialog(this.getActivity());



////
////        String query = "name";

        SearchView searchView1 = findViewById(R.id.searchView1);
//        Button button = findViewById(R.id.button);

        searchView1.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                // This method is called when the user submits the search query.
                // Here, you can get the search query text and do something with it.



//                                String query = "puppies";
                                int startIndex = 1;
                                int numResults = 10;
                                String searchType = "Books";
                                String cseId = "009fa0a6fd822445b";
                                String apiKey = "AIzaSyCH84UPsOZUSBQ3s59qVdkzo1dXpBLLk08";

                            OkHttpClient client = new OkHttpClient();

                            String url = "https://www.googleapis.com/customsearch/v1"
                                    + "?key=" + apiKey      //my api key
                                    + "&cx=" + cseId        //Custom Search Engine ID
                                    + "&q=" + query
                                    + "&start=" + startIndex
                                    + "&num=" + numResults
                                    + "&searchType=" + searchType;

                            Request request = new Request.Builder()
                                    .url(url)
                                    .build();

                            Response response = null;
                            try {
                                response = client.newCall(request).execute();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                            String jsonResponse = null;
                            try {
                                jsonResponse = response.body().string();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }

// Use Gson to parse the JSON response into a SearchResponse object
                            SearchResponse searchResponse = new Gson().fromJson(jsonResponse, SearchResponse.class);

//
//
//                                // Create the Google Custom Search API URL
//                                String url = "https://www.googleapis.com/customsearch/v1?key=" + apiKey + "&cx=" + SEARCH_ENGINE_ID + "&q=" + query + "&start=" + startIndex + "&num=" + numResults + "&searchType=" + searchType;
//
//                                // Use Volley library to make API request
//                                JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null,
//                                        response -> {
//                                            // Handle response from API
//                                        },
//                                        error -> {
//                                            // Handle error from API
//                                        });
//
//                                // Add request to Volley request queue
//                                Volley.newRequestQueue(this).add(request);







//
//                            Intent myIntent = new Intent(SearchResponse.this, WebSwitchActivity.class);
//                            myIntent.putExtra("url","http://www.google.com/search?q=");//show web view
//                            startActivity(myIntent);

//
//                            dialog.dismiss();
////                        DashboardFragment.this.startActivity(myIntent);




//                //call API
//                RequestManager manager = new RequestManager(DashboardFragment.this.getActivity());
//                manager.getWordMeaning(listener,query);

                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });









//
////                doSomethingWithSearchQuery(query);
//                return true;
//            }



//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                String searchQuery = searchView.getQuery().toString();
//                // Here, you can get the search query text and do something with it.
//                doSomethingWithSearchQuery(searchQuery);
//            }
//        });






//                .setOnClickListener(new View.OnClickListener() {
//            @SuppressLint("ResourceType")
//            @Override
//            public void onClick(View v) {
//                //create a dialog prompt
//                AlertDialog.Builder builder = new AlertDialog.Builder(SearchResponse.this);
//                View customLayout = getLayoutInflater().inflate(R.layout.gibbs_dialog, null); //use designed layout as custom layout
//                builder.setView(customLayout);
//                //customise dialog layout
//                TextView titleTextView = customLayout.findViewById(R.id.title_text_view);
//                TextView messageTextView = customLayout.findViewById(R.id.message_text_view);
//                Button negativeButton = customLayout.findViewById(R.id.negative_button);
//                Button positiveButton = customLayout.findViewById(R.id.positive_button);
//
//                titleTextView.setText("Switching to Web View...");
//                messageTextView.setText("Do you want to continue to Web search view?");
//
//                //create and initialize dialog
//                AlertDialog dialog = builder.create();
//                dialog.show();
//
//                negativeButton.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        // handle negative button click
//                        dialog.dismiss();
//                    }
//                });
//
//
//                positiveButton.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        // handle intent positive button click
//                        Intent myIntent = new Intent(SearchResponse.this, WebSwitchActivity.class);
//                        myIntent.putExtra("url","https://google.com/");//show web view
//                        startActivity(myIntent);
//                        dialog.dismiss();
////                        DashboardFragment.this.startActivity(myIntent);
//                    }
//                });
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
////                RequestManager manager = new RequestManager(DashboardFragment.this.getActivity());
////                Intent myIntent = new Intent(DashboardFragment.this.getActivity(), DictionaryActivity.class);
////                DashboardFragment.this.startActivity(myIntent); //implement the intent ie switch to the fragment required
//                Intent myIntent = new Intent(DashboardFragment.this.getActivity(), DictionaryActivity.class);
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
////                    AlertDialog.Builder builder = new AlertDialog.Builder(DashboardFragment.this.getActivity());
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
//////                            Intent myIntent = new Intent(DashboardFragment.this.getActivity(),DictionaryActivity.class);
//////                            DashboardFragment.this.startActivity(myIntent);
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
////////                            Intent myIntent = new Intent(DashboardFragment.this.getActivity(), WebSwitchActivity.class);
////////                            myIntent.putExtra("url","http://www.google.com/search?q=");//show web view
////////                            startActivity(myIntent);
//////
//////
//////                            dialog.dismiss();
////////                        DashboardFragment.this.startActivity(myIntent);
//////                        }
//////                    });
//////
//////
//////
//////
////////                //call API
////////                RequestManager manager = new RequestManager(DashboardFragment.this.getActivity());
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












    }

    public String getKind() {
        return kind;
    }

    public SearchInformation getSearchInformation() {
        return searchInformation;
    }

    public List<Item> getItems() {
        return items;
    }

    public static class SearchInformation {
        private long totalResults;

        public long getTotalResults() {
            return totalResults;
        }
    }

    public static class Item {
        private String title;
        private String link;

        public String getTitle() {
            return title;
        }

        public String getLink() {
            return link;
        }
    }

    }

