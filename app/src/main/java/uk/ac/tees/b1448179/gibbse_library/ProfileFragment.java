package uk.ac.tees.b1448179.gibbse_library;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;




public class ProfileFragment extends Fragment {

    private Button signOut;
    private FirebaseUser user;
    private DatabaseReference reference; //to select users uniquely
    private TextView user_return_home;

    FirebaseAuth auth;

//    // TODO: Rename parameter arguments, choose names that match
//    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
//    private static final String ARG_PARAM1 = "param1";
//    private static final String ARG_PARAM2 = "param2";
//
//    // TODO: Rename and change types of parameters
//    private String mParam1;
//    private String mParam2;
//
//    public ProfileFragment() {
//        // Required empty public constructor
//    }
//
//    /**
//     * Use this factory method to create a new instance of
//     * this fragment using the provided parameters.
//     *
//     * @param param1 Parameter 1.
//     * @param param2 Parameter 2.
//     * @return A new instance of fragment ProfileFragment.
//     */
//    // TODO: Rename and change types and number of parameters
//    public static ProfileFragment newInstance(String param1, String param2) {
//        ProfileFragment fragment = new ProfileFragment();
//        Bundle args = new Bundle();
//        args.putString(ARG_PARAM1, param1);
//        args.putString(ARG_PARAM2, param2);
//        fragment.setArguments(args);
//        return fragment;
//    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       View v = inflater.inflate(R.layout.fragment_profile, container, false);

        user_return_home = v.findViewById(R.id.user_return_home);
        user_return_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(ProfileFragment.this.getActivity(), MainActivity2.class);
                ProfileFragment.this.startActivity(myIntent); //implement the intent ie switch to the fragment required}
            }
        });

        signOut = v.findViewById(R.id.signOut);

        auth = FirebaseAuth.getInstance();

        signOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                auth.signOut();
                startActivity(new Intent(getContext(),MainActivity.class));
                Toast.makeText(getContext(), "Logged out successfully!!", Toast.LENGTH_LONG).show();
            }
        });


        user = FirebaseAuth.getInstance().getCurrentUser();
        reference = FirebaseDatabase.getInstance().getReference("Users");
        String userID = user.getUid();

        final TextView greetingTextView = v.findViewById(R.id.greeting);
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

                    greetingTextView.setText("Welcome, " + fullName + "!");
                    fullNameTextView.setText(fullName);
                    emailTextView.setText(email);
                    ageTextView.setText(age);
                    genderTextView.setText(gender);

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
              //  Toast.makeText(ProfileFragment.this, "Oops! something wrong happened", Toast.LENGTH_SHORT).show();
            }
        });


       return v;




    }

  /*

    public class ProfileActivity extends AppCompatActivity {

        private FirebaseUser user;
        private DatabaseReference reference; //to select users uniquely
        private Button logout;
        private TextView user_return_home;

        @SuppressLint("MissingInflatedId")
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            // setContentView(R.layout.activity_profile);
            user_return_home = (TextView)findViewById(R.id.user_return_home);
            user_return_home.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(new Intent(ProfileActivity.this,HomePage.class));
                }
            });
            logout = (Button) findViewById(R.id.signOut);
            logout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    FirebaseAuth.getInstance().signOut();
                    Toast.makeText(ProfileActivity.this, "Logged out successfully!!", Toast.LENGTH_LONG).show();
                    startActivity(new Intent(ProfileActivity.this,MainActivity.class));
                }
            });

            user = FirebaseAuth.getInstance().getCurrentUser();
            reference = FirebaseDatabase.getInstance().getReference("Users");
            String userID = user.getUid();

            final TextView greetingTextView = (TextView) findViewById(R.id.greeting);
            final TextView fullNameTextView = (TextView) findViewById(R.id.fullName);
            final TextView emailTextView = (TextView) findViewById(R.id.emailAddress);
            final TextView ageTextView = (TextView) findViewById(R.id.age);

            reference.child(userID).addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    User userProfile = snapshot.getValue(User.class);
                    if(userProfile != null){
                        String fullName = userProfile.fullName;
                        String email = userProfile.email;
                        String age = userProfile.age;

                        greetingTextView.setText("Welcome, " + fullName + "!");
                        fullNameTextView.setText(fullName);
                        emailTextView.setText(email);
                        ageTextView.setText(age);

                    }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {
                    Toast.makeText(ProfileActivity.this, "Oops! something wrong happened", Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
    */

}

