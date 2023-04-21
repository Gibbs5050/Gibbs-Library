package uk.ac.tees.b1448179.gibbse_library;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

public class LandingPage extends AppCompatActivity implements View.OnClickListener {

    private TextView logoView, clickLogin,clickSignUp, guestHomePage;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landing_page);

        //initialize
        clickLogin = (TextView) findViewById(R.id.clickLogin);
        clickSignUp = (TextView) findViewById(R.id.clickSignUp);
        guestHomePage = (TextView) findViewById(R.id.guestHomePage);
        logoView = findViewById(R.id.logoView);
        clickLogin.setOnClickListener(this);
        clickSignUp.setOnClickListener(this);
        guestHomePage.setOnClickListener(this);

        //animation

        ImageView imageView5 = findViewById(R.id.imageView5);
        Animation anim = AnimationUtils.loadAnimation(this, R.anim.landing_anim);
        imageView5.setAnimation(anim);


        // Create the NotificationChannel
        NotificationChannel channel = null;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            channel = new NotificationChannel("LibraryGuest", "NewGuestAlert", NotificationManager.IMPORTANCE_DEFAULT);
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            channel.setDescription("My Channel Description");
        }
// Register the channel with the system; you can't change the importance or other notification behaviors after this
        NotificationManager notificationManager = null;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            notificationManager = getSystemService(NotificationManager.class);
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            notificationManager.createNotificationChannel(channel);
        }

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.clickLogin:
               startActivity(new Intent(this,MainActivity.class));
                Toast.makeText(LandingPage.this, "Please Login to continue!", Toast.LENGTH_SHORT).show();
               //create colour in colour.xml for on click colour change to show when clicked
                clickLogin.setTextColor(getResources().getColor(R.color.amber));
                break;


            case R.id.clickSignUp:
                startActivity(new Intent(this,RegisterUser.class)); //redirect to homepage layout
                Toast.makeText(LandingPage.this, "Follow instructions to sign up!", Toast.LENGTH_SHORT).show();
                clickSignUp.setTextColor(getResources().getColor(R.color.amber)); //change colour on click
                break;


            case R.id.guestHomePage:
                guestHomePage.setTextColor(getResources().getColor(R.color.amber)); //change colour on click

                //create notification of click access

                NotificationCompat.Builder builder = new NotificationCompat.Builder(this, "LibraryGuest")
                        .setSmallIcon(R.drawable.ic_notifyy_foreground)
                        .setContentTitle("Guest Alert!!")
                        .setContentText("Gibbs Library has been accessed without login")
                        .setPriority(NotificationCompat.PRIORITY_DEFAULT);
                NotificationManagerCompat notificationManager = NotificationManagerCompat.from(this);
                int notificationId = 1; // Unique id for the notification
                notificationManager.notify(notificationId, builder.build());


                //create a dialog prompt
                AlertDialog.Builder builder1 = new AlertDialog.Builder(LandingPage.this);
                View customLayout = getLayoutInflater().inflate(R.layout.activity_input_popup, null); //use designed layout as custom layout
                builder1.setView(customLayout);
                //customise dialog layout
                // Get the UI elements from the layout
                EditText inputEditText = customLayout.findViewById(R.id.nameInput);
                Button submitButton = customLayout.findViewById(R.id.submitButton);

                //create and initialize dialog
                AlertDialog dialog = builder1.create();
                dialog.show();

                submitButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // handle submit button click against robot
                        String value = inputEditText.getText().toString();
                        if (value != null) {

                            Toast.makeText(LandingPage.this, "Hello "+value+"!! :) \n Welcome To Gibbs Library!   :)", Toast.LENGTH_SHORT).show();

                            Intent myIntent = new Intent(LandingPage.this, MainActivity2.class);
//
                            startActivity(myIntent);


//                            System.out.println("Hello "+value+"! Welcome To Gibbs Library!");
//                            dialog.dismiss();
                        } else if (value == ""){

                            Toast.makeText(LandingPage.this, "Empty Input! Please Enter your Name to confirm you are human!", Toast.LENGTH_SHORT).show();
                            System.out.println("Empty Input! Please Enter your Name to confirm you are human!");
                        }



                    }
                });

//
//                positiveButton.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        // handle intent positive button click
//                        Intent myIntent = new Intent(DashboardFragment.this, SearchResponse.class);
////                        myIntent.putExtra("url","https://google.com/");//show web view
//                        startActivity(myIntent);
////                        DashboardFragment.this.startActivity(myIntent);
//                    }
//                });

            //notify

//                NotificationCompat.Builder builder = new NotificationCompat.Builder(this, "LibraryGuest")
//                        .setSmallIcon(R.drawable.ic_notifyy_foreground)
//                        .setContentTitle("Guest Alert!!")
//                        .setContentText("Gibbs Library has been accessed without login")
//                        .setPriority(NotificationCompat.PRIORITY_DEFAULT);
//                NotificationManagerCompat notificationManager = NotificationManagerCompat.from(this);
//                int notificationId = 1; // Unique id for the notification
//                notificationManager.notify(notificationId, builder.build());
//                startActivity(new Intent(this,MainActivity2.class)); //redirect to homepage layout
//                Toast.makeText(LandingPage.this, "Welcome to Gibbs Library!", Toast.LENGTH_SHORT).show();

                break;


            default:
                throw new IllegalStateException("Unexpected value: " + v.getId());
        }
    }

//    private void showPopup() {
//    }
//
//    //using another layout on this to display pop up
//    public void showPopup(View view) {
//        // Inflate the pop-up layout
//        View popupView = getLayoutInflater().inflate(R.layout.activity_input_popup, null);
//
//        // Create a pop-up window
//        int width = LinearLayout.LayoutParams.MATCH_PARENT;
//        int height = LinearLayout.LayoutParams.WRAP_CONTENT;
//        final PopupWindow popupWindow = new PopupWindow(popupView, width, height, true);
//
//        // Get the EditText and Button views from the layout
//        EditText editText = popupView.findViewById(R.id.nameInput);
//        Button buttonOk = popupView.findViewById(R.id.submitButton);
//
//        // Set a click listener for the Button to get the text from the EditText view
//        buttonOk.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                String value = editText.getText().toString();
//                // Do something with the value (e.g. display it in a TextView)
//                popupWindow.dismiss();
//            }
//        });
//
//        // Show the pop-up window at the center of the screen
//        popupWindow.showAtLocation(view, Gravity.CENTER, 0, 0);
//    }

}