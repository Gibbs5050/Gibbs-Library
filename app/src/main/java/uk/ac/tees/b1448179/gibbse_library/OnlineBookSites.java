package uk.ac.tees.b1448179.gibbse_library;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class OnlineBookSites extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_online_book_sites);

        //declare and initalize text view and make text blink
        TextView textViewTop = findViewById(R.id.textViewTop); // replace with your text view ID
        Handler handler = new Handler();

        Runnable runnable = new Runnable() {
            boolean visible = true;

            @Override
            public void run() {
                textViewTop.setVisibility(visible ? View.VISIBLE : View.INVISIBLE);
                visible = !visible;
                handler.postDelayed(this, 1000); // change delay time (in milliseconds) as needed
            }
        };
        handler.post(runnable);


        //animation
        ImageView imageView9  = findViewById(R.id.imageView9);
        Animation anim = AnimationUtils.loadAnimation(this, R.anim.landing_anim);
        imageView9.setAnimation(anim);


        //initialize link 1 for google books
        TextView textViewGoogleBooks = findViewById(R.id.textViewGoogleBooks);
        textViewGoogleBooks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //create alert dialog to select
                AlertDialog.Builder builder = new AlertDialog.Builder(OnlineBookSites.this);
                builder.setTitle("Google Books"); //makes title app name
                builder.setMessage("More than 100,000 books for consultation, download or on-line purchase:");
                //what dialog exit button does
                builder.setNegativeButton("Dismiss", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //close dialog
                    }
                });
                //what visit button does
                builder.setPositiveButton("Visit", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //ToDo show website
                        Intent myIntent = new Intent(OnlineBookSites.this, WebSwitchActivity.class);
                        myIntent.putExtra("url","https://books.google.com/?hl=en");//show website
                        startActivity(myIntent);

                    }
                });
                builder.create().show();



            }
        });

        //initialize library 2
        TextView textViewBookBoon = findViewById(R.id.textViewBookBoon);
        textViewBookBoon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //create alert dialog to select
                AlertDialog.Builder builder = new AlertDialog.Builder(OnlineBookSites.this);
                builder.setTitle("Book Boon");  //makes title app name
                builder.setMessage("Making knowledge accessible doesn’t just mean making it affordable. " +
                        "it is a priority that anyone can use our eBooks anywhere at any time. " +
                        "That’s why bookboon created a very easy-to-use platform that can be accessed online and offline" +
                        " that allows you to find your eBooks and start reading within just a few clicks. " +
                        "You can finish any one of our hands-on eBooks in 1 to 2 hours allowing you to implement" +
                        " tomorrow what you’ve learned today. After all, you don’t know what challenges might arise for which you need some inspiration:");
                //what dialog exit button does
                builder.setNegativeButton("Dismiss", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //close dialog
                    }
                });
                //what visit button does
                builder.setPositiveButton("Visit", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //ToDo show website
                        Intent myIntent = new Intent(OnlineBookSites.this, WebSwitchActivity.class);
                        myIntent.putExtra("url","https://bookboon.com/");//show website
                        startActivity(myIntent);

                    }
                });
                builder.create().show();



            }
        });


        //initialize library 3
        TextView textViewIbiblo = findViewById(R.id.textViewIbiblo);
        textViewIbiblo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //create alert dialog to select
                AlertDialog.Builder builder = new AlertDialog.Builder(OnlineBookSites.this);
                builder.setTitle("Ibiblo");  //makes title app name
                builder.setMessage("E-books, magazines, academic essays, software, music and radio:");
                //what dialog exit button does
                builder.setNegativeButton("Dismiss", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //close dialog
                    }
                });
                //what visit button does
                builder.setPositiveButton("Visit", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //ToDo show website
                        Intent myIntent = new Intent(OnlineBookSites.this, WebSwitchActivity.class);
                        myIntent.putExtra("url","https://www.ibiblio.org/");//show website
                        startActivity(myIntent);

                    }
                });
                builder.create().show();



            }
        });
        //initialize library 4
        TextView textViewOpenLibrary = findViewById(R.id.textViewOpenLibrary);
        textViewOpenLibrary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //create alert dialog to select
                AlertDialog.Builder builder = new AlertDialog.Builder(OnlineBookSites.this);
                builder.setTitle("Open Library");  //makes title app name
                builder.setMessage("More than one million e-books of classic literature to download:");
                //what dialog exit button does
                builder.setNegativeButton("Dismiss", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //close dialog
                    }
                });
                //what visit button does
                builder.setPositiveButton("Visit", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //ToDo show website
                        Intent myIntent = new Intent(OnlineBookSites.this, WebSwitchActivity.class);
                        myIntent.putExtra("url","https://openlibrary.org/");//show website
                        startActivity(myIntent);

                    }
                });
                builder.create().show();



            }
        });

        //initialize library 5
        TextView textViewInternetArchive = findViewById(R.id.textViewInternetArchive);
        textViewInternetArchive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //create alert dialog to select
                AlertDialog.Builder builder = new AlertDialog.Builder(OnlineBookSites.this);
                builder.setTitle("Internet Archive"); //makes title app name
                builder.setMessage("The largest digital library for downloading e-books and audio-books for free");
                //what dialog exit button does
                builder.setNegativeButton("Dismiss", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //close dialog
                    }
                });
                //what visit button does
                builder.setPositiveButton("Visit", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //ToDo show website
                        Intent myIntent = new Intent(OnlineBookSites.this, WebSwitchActivity.class);
                        myIntent.putExtra("url","https://archive.org/");//show website
                        startActivity(myIntent);

                    }
                });
                builder.create().show();



            }
        });

        //initialize library 6
        TextView textViewBartleby = findViewById(R.id.textViewBartleby);
        textViewBartleby.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //create alert dialog to select
                AlertDialog.Builder builder = new AlertDialog.Builder(OnlineBookSites.this);
                builder.setTitle("Bartleby"); //makes title app name
                builder.setMessage("An immense collection of books for consultation, including fiction, essay and poetry");
                //what dialog exit button does
                builder.setNegativeButton("Dismiss", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //close dialog
                    }
                });
                //what visit button does
                builder.setPositiveButton("Visit", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //ToDo show website
                        Intent myIntent = new Intent(OnlineBookSites.this, WebSwitchActivity.class);
                        myIntent.putExtra("url","https://www.bartleby.com/");//show website
                        startActivity(myIntent);

                    }
                });
                builder.create().show();



            }
        });



        //initialize library 7
        @SuppressLint({"MissingInflatedId", "LocalSuppress"})
        TextView textViewEbookCentral = findViewById(R.id.textViewEbookCentral);
        textViewEbookCentral.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //create alert dialog to select
                AlertDialog.Builder builder = new AlertDialog.Builder(OnlineBookSites.this);
                builder.setTitle("Ebook Central"); //makes title app name
                builder.setMessage("Ebook Central is a collection of over 210,000 books and other authoritative content to which we have full-text access. " +
                        "It covers multiple subject areas.\n" +
                        "A short form may pop up asking you to indicate which School/Department you are in. Please pick from the drop-down list");
                //what dialog exit button does
                builder.setNegativeButton("Dismiss", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //close dialog
                    }
                });
                //what visit button does
                builder.setPositiveButton("Visit", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //ToDo show website
                        Intent myIntent = new Intent(OnlineBookSites.this, WebSwitchActivity.class);
                        myIntent.putExtra("url","https://ebookcentral.proquest.com/lib/tees/home.action");//show website
                        startActivity(myIntent);

                    }
                });
                builder.create().show();



            }
        });

    }
}