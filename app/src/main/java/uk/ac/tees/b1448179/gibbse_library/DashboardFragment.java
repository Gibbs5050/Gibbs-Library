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
        ImageView imageViewSelectBook = v.findViewById(R.id.imageViewSelectBook);
        imageViewSelectBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(DashboardFragment.this.getActivity(),LibraryCatalogue.class);
                DashboardFragment.this.startActivity(myIntent);
            }
        });

        TextView textView8 = v.findViewById(R.id.textView8);
        //animation
        Animation anim = AnimationUtils.loadAnimation(this.getActivity(), R.anim.landing_anim);
        textView8.setAnimation(anim);



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


        ImageView drawer_shelve = v.findViewById(R.id.drawer_shelve);
        drawer_shelve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(DashboardFragment.this.getActivity(), LibraryCatalogue.class);
                DashboardFragment.this.startActivity(myIntent); //implement the intent ie switch to the fragment required
            }
        });

        ImageView button_viewAllBooks = v.findViewById(R.id.button_viewAllBooks);
        button_viewAllBooks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(DashboardFragment.this.getActivity(), AllBooksActivity.class);
                DashboardFragment.this.startActivity(myIntent); //implement the intent ie switch to the fragment required


            }
        });


        //make text blink
        TextView textView9 = v.findViewById(R.id.textView9); // replace with your text view ID
        Handler handler = new Handler();

        Runnable runnable = new Runnable() {
            boolean visible = true;

            @Override
            public void run() {
                textView9.setVisibility(visible ? View.VISIBLE : View.INVISIBLE);
                visible = !visible;
                handler.postDelayed(this, 500); // change delay time (in milliseconds) as needed
            }
        };

        handler.post(runnable);
        ImageView button_visit_external_bookstore = v.findViewById(R.id.button_visit_external_bookstore);
        button_visit_external_bookstore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(DashboardFragment.this.getActivity(), OnlineBookSites.class);
                DashboardFragment.this.startActivity(myIntent); //implement the intent ie switch to the fragment required

                    }
                });

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



//            }
//        });

        ImageView myDictionary = v.findViewById(R.id.myDictionary);
        myDictionary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(DashboardFragment.this.getActivity(),DictionaryActivity.class);
                DashboardFragment.this.startActivity(myIntent);
            }
        });
        ImageView myFavorite = v.findViewById(R.id.aboutApp);

        //set on click for about
        ImageView aboutApp = v.findViewById(R.id.aboutApp);
        aboutApp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //create alert dialog to select
                AlertDialog.Builder builder = new AlertDialog.Builder(DashboardFragment.this.getActivity());
                builder.setTitle(getString(R.string.app_name)); //makes title app name
                builder.setMessage("Gibbs Library! is the best place to explore different online flexible learning platforms, " +
                        "with so many amazing books and E-Learning features.\n" + "Visit Google.com and search for your favorite books in our library's web viewer:");
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
                        Intent myIntent = new Intent(DashboardFragment.this.getActivity(), WebSwitchActivity.class);
                        myIntent.putExtra("url","https://google.com/");//show website
                        startActivity(myIntent);

                    }
                });
                builder.create().show();



            }
        });

        ImageView button_my_favorites = v.findViewById(R.id.button_my_favorites);
        button_my_favorites.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(DashboardFragment.this.getActivity(), FavouriteBooks.class);
                DashboardFragment.this.startActivity(myIntent); //implement the intent ie switch to the fragment required
            }
        });

        return v;

    }
}