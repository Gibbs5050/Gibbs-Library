package uk.ac.tees.b1448179.gibbse_library;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;

import okhttp3.Response;

public class WebSwitchActivity extends AppCompatActivity {

    private WebView webView;
    ImageView catalogue_exit2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_switch);

//        Response response = client.newCall(request).execute();
//        String jsonResponse = response.body().string();


        Intent intent = getIntent();
        if (null != intent) {
            String url = intent.getStringExtra("url"); //make website activity reuseable
            //load a website
            webView = findViewById(R.id.webview);
            webView.loadUrl(url);
            webView.setWebViewClient(new WebViewClient());
            webView.getSettings().setJavaScriptEnabled(true); //enable javascript

            //initialize exit
            catalogue_exit2 = findViewById(R.id.catalogue_exit2);
            catalogue_exit2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // Close the activity containing the web view
//                    finish();
                    Intent myIntent = new Intent(WebSwitchActivity.this,MainActivity2.class);
                    WebSwitchActivity.this.startActivity(myIntent);
                }
            });
        }
    }


    //make the webView back button hover with web pages
    @Override
    public void onBackPressed(){

        if(webView.canGoBack()){
            webView.goBack();
        }else{
            super.onBackPressed();
        }
    }
}