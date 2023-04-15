package uk.ac.tees.b1448179.gibbse_library;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
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
                startActivity(new Intent(getContext(),MainActivity.class));
                Toast.makeText(getContext(), "Logged out successfully!!", Toast.LENGTH_LONG).show();
            }
        });


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


