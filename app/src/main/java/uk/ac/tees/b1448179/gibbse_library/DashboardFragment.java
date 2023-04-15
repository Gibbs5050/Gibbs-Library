package uk.ac.tees.b1448179.gibbse_library;

import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
//import androidx.core.view.GravityCompat;
//import androidx.drawerlayout.widget.DrawerLayout;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.vectordrawable.graphics.drawable.ArgbEvaluator;
//import androidx.navigation.fragment.NavHostFragment;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
//import android.widget.EditText;


/*
 * A simple {@link Fragment} subclass.
 * Use the {@link DashboardFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DashboardFragment extends Fragment {

    @SuppressLint("MissingInflatedId")
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_dashboard, container,false);


        //private DashboardFragmentListener listener;
        //declaration and initialization
        CardView myCatalogue = v.findViewById(R.id.myCatalogue);
        myCatalogue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(DashboardFragment.this.getActivity(),LibraryCatalogue.class);
                DashboardFragment.this.startActivity(myIntent);
            }
        });

        CardView findMe = v.findViewById(R.id.findMe);
        findMe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(DashboardFragment.this.getActivity(),FindMe.class);
                DashboardFragment.this.startActivity(myIntent);
            }
        });

        //declare and initialize object
        ImageView imageViewSelectBook2 = v.findViewById(R.id.imageViewSelectBook2);
        //animation
        Animation anim = AnimationUtils.loadAnimation(this.getActivity(), R.anim.landing_anim);
        imageViewSelectBook2.setAnimation(anim);


        //set Up drawer buttons
        Button signOut = v.findViewById(R.id.signOut);
        FirebaseAuth auth = FirebaseAuth.getInstance();
        signOut.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("RestrictedApi")
            @Override
            public void onClick(View v) {

                auth.signOut();
                startActivity(new Intent(getContext(),MainActivity.class));
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
                Intent myIntent = new Intent(DashboardFragment.this.getActivity(), LibraryCatalogue.class);
                DashboardFragment.this.startActivity(myIntent); //implement the intent ie switch to the fragment required
            }
        });

        //set up trending books find
        CardView trendingBooks = v.findViewById(R.id.trendingBooks);
        trendingBooks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(DashboardFragment.this.getActivity(), AllBooksActivity.class);
                DashboardFragment.this.startActivity(myIntent); //implement the intent ie switch to the fragment required
            }
        });


        //make text blink
        TextView textView8 = v.findViewById(R.id.textView8);
        Handler handler = new Handler();
        Runnable runnable = new Runnable() {
            boolean visible = true;

            @Override
            public void run() {
                textView8.setVisibility(visible ? View.VISIBLE : View.INVISIBLE);
                visible = !visible;
                handler.postDelayed(this, 500); // changes delay time (in milliseconds) as needed
            }
        };
        handler.post(runnable); //executes blink
//
//
//
        //top books store set up
        CardView topBookStores = v.findViewById(R.id.topBookStores);
        topBookStores.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(DashboardFragment.this.getActivity(), OnlineBookSites.class);
                DashboardFragment.this.startActivity(myIntent); //implement the intent ie switch to the fragment required

                    }
                });


//
//                //what visit button does
//                builder.setPositiveButton("Visit", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//                        //ToDo show website
//                        Intent myIntent = new Intent(DashboardFragment.this.getActivity(), WebSwitchActivity.class);
//                        myIntent.putExtra("url","https://google.com/");//show website
//                        startActivity(myIntent);
//
//                    }
//                });
//                builder.create().show();
//
//
//
//            }
//        });




        //set up my dictionary click
        CardView myDictionary = v.findViewById(R.id.myDictionary);
        myDictionary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(DashboardFragment.this.getActivity(),DictionaryActivity.class);
                DashboardFragment.this.startActivity(myIntent);
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
                //create alert dialog to select
                AlertDialog.Builder builder = new AlertDialog.Builder(DashboardFragment.this.getActivity());
                builder.setTitle(getString(R.string.app_name)); //makes title app name
                builder.setMessage(aboutAppText);
                //what dialog exit button does
                builder.setNegativeButton("Close", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //close dialog
                    }
                });
                builder.create().show();
            }
        });

        //set up my browser click listener
        CardView myBrowser = v.findViewById(R.id.myBrowser);
        myBrowser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //create alert dialog to select
                AlertDialog.Builder builder = new AlertDialog.Builder(DashboardFragment.this.getActivity());
                builder.setTitle("Switching to Web View..."); //makes title app name
                builder.setMessage("Do you want to continue to Web search view?");
                //what dialog exit button does
                builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //close dialog
                    }
                });
                //what visit button does
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //ToDo show website
                        Intent myIntent = new Intent(DashboardFragment.this.getActivity(), WebSwitchActivity.class);
                        myIntent.putExtra("url","https://google.com/");//show website
                        startActivity(myIntent);

                    }
                });
                builder.create().show();
            }
        });

        //set up my favourite card view
        CardView myFavorite = v.findViewById(R.id.myFavorite);
        myFavorite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(DashboardFragment.this.getActivity(), FavouriteBooks.class);
                DashboardFragment.this.startActivity(myIntent); //implement the intent ie switch to the fragment required
            }
        });

        return v;

    }
}