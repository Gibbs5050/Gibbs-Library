package uk.ac.tees.b1448179.gibbse_library.AllFragmentsContainer;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import uk.ac.tees.b1448179.gibbse_library.MyLoginActivity;
import uk.ac.tees.b1448179.gibbse_library.R;
import uk.ac.tees.b1448179.gibbse_library.User;

public class ProfileFragment extends Fragment {

    private Button signOut;
    private FirebaseUser user;
    private DatabaseReference reference; //to select users uniquely
    FirebaseAuth auth;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_profile, container, false);

        signOut = v.findViewById(R.id.signOut);
        auth = FirebaseAuth.getInstance();
        signOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                auth.signOut();
                startActivity(new Intent(getContext(), MyLoginActivity.class));
                Toast.makeText(getContext(), "Logged out successfully!!", Toast.LENGTH_LONG).show();
            }
        });

        //upload profile picture
        ImageView imageView = v.findViewById(R.id.imageView2);
        String imageUrl = "https://avatars.githubusercontent.com/u/57678647?v=4.jpg";

        Glide.with(this)
                .load(imageUrl)
                .into(imageView);




        //Display Current Date and Time

        TextView currentDateTimeTextView = v.findViewById(R.id.currentDateTime);
        Date currentDateTime = Calendar.getInstance().getTime();

        //format date to display date and time
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy hh:mm:ss a");
        String formattedDateTime = sdf.format(currentDateTime);

        //Setting the formatted date and time as textview
        currentDateTimeTextView.setText("Current Time: " + formattedDateTime);

                //make text blink

        Handler handler = new Handler();
        Runnable runnable = new Runnable() {
            boolean visible = true;

            @Override
            public void run() {
                currentDateTimeTextView.setVisibility(visible ? View.VISIBLE : View.INVISIBLE);
                visible = !visible;
                handler.postDelayed(this, 500); // changes delay time (in milliseconds) as needed
            }
        };
        handler.post(runnable); //executes blink








        user = FirebaseAuth.getInstance().getCurrentUser();
        reference = FirebaseDatabase.getInstance().getReference("Users");
        String userID = user.getUid();

        //final TextView greetingTextView = v.findViewById(R.id.greeting);
        final TextView fullNameTextView = v.findViewById(R.id.fullName);
        final TextView emailTextView = v.findViewById(R.id.emailAddress);
        final TextView ageTextView = v.findViewById(R.id.age);
        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) final TextView genderTextView = v.findViewById(R.id.genderView);


        reference.child(userID).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                User userProfile = snapshot.getValue(User.class);
                if(userProfile != null){
                    String fullName = userProfile.fullName;
                    String email = userProfile.email;
                    String age = userProfile.age;
                    String gender = userProfile.gender;

                  //  greetingTextView.setText("Welcome, " + fullName + "!");
                    fullNameTextView.setText(fullName);
                    emailTextView.setText(email);
                    ageTextView.setText(age);
                    genderTextView.setText(gender);

                    //get the name to display
                    String userInput = fullNameTextView.getText().toString();
                    Toast.makeText(ProfileFragment.this.getActivity(), "Welcome to your profile " + userInput + "!. This User is a " + ageTextView.getText().toString() + "years old "+ genderTextView.getText().toString(), Toast.LENGTH_SHORT).show();

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getContext(), "Oops! something wrong happened", Toast.LENGTH_LONG).show();
              //Toast.makeText(ProfileFragment.this, "Oops! something wrong happened", Toast.LENGTH_SHORT).show();
            }
        });


       return v;
    }
}


