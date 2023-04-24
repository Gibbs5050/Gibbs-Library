package uk.ac.tees.b1448179.gibbse_library;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.io.File;
//
//import android.content.res.AssetManager;
//import android.os.Bundle;
//import android.support.v7.app.AppCompatActivity;
//import android.util.Log;
//import android.webkit.WebView;
//
//import java.io.IOException;
//import java.io.InputStream;
//import java.util.List;

public class FileReaderActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_local_database);

        RecyclerView recyclerView = findViewById(R.id.recycler_view_files);
        TextView emptyFolder_textview = findViewById(R.id.emptyFolder_textview);


        //enable reading from file
        String path = getIntent().getStringExtra("path");
        File root = new File(path);
        File[] filesAndFolders = root.listFiles();

        //check for empty folder and set visible text view
        if(filesAndFolders==null || filesAndFolders.length ==0){
            emptyFolder_textview.setVisibility(View.VISIBLE);
            return;
        }

        emptyFolder_textview.setVisibility(View.INVISIBLE);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new FileReaderAdapter(getApplicationContext(),filesAndFolders));

//
//        //Epub reader implementation
//        WebView webview = findViewById(R.id.webview);
//
//        webview.loadUrl("mobyD.html");
//
//        webview.setWebViewClient(new WebViewClient() {
//            @Override
//            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
//                // Handle the URL here
//                webview.loadUrl("epubStyles.css");
//                webview.loadDataWithBaseURL("mobyD.html", "<html><head><link rel='stylesheet' href='styles.css'></head><body>" + webview + "</body></html>", "text/html", "UTF-8", null);
//
//
//                return true; // Return true to indicate that the URL has been handled
//            }
//        });

    }

}

