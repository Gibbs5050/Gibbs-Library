package uk.ac.tees.b1448179.gibbse_library;

import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
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
        ImageView button_alreadyReadBooks = v.findViewById(R.id.button_alreadyReadBooks);
        ImageView myDictionary = v.findViewById(R.id.myDictionary);
        myDictionary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(DashboardFragment.this.getActivity(),DictionaryActivity.class);
                DashboardFragment.this.startActivity(myIntent);
            }
        });
        ImageView myFavorite = v.findViewById(R.id.aboutApp);
        ImageView aboutApp = v.findViewById(R.id.aboutApp);
        ImageView button_currentlyReadBooks = v.findViewById(R.id.button_currentlyReadBooks);
        button_currentlyReadBooks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(DashboardFragment.this.getActivity(), MyLocalDatabase.class);
                DashboardFragment.this.startActivity(myIntent); //implement the intent ie switch to the fragment required
            }
        });

        return v;

    }
}