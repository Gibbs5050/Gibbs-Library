package uk.ac.tees.b1448179.gibbse_library;

import static android.content.ContentValues.TAG;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

import uk.ac.tees.b1448179.gibbse_library.AllFragmentsContainer.HomeFragment;

public class RegisterUser extends AppCompatActivity implements View.OnClickListener {

   // private ImageView banner;    ToDo - create banner for navigation
    private TextView registerUser,editRegisterSignIn, termsAndConditions;
    private EditText editTextFullName, editTextAge, editTextEmail, editTextPassword;
    private ProgressBar progressBar;
    private FirebaseAuth mAuth;
    private CheckBox checkBoxTerms;
    private AutoCompleteTextView editTextGender;
    private FirebaseFirestore db;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_user);



        //initialize fire store
        db = FirebaseFirestore.getInstance();

        mAuth = FirebaseAuth.getInstance();
       // banner = (ImageView) findViewById(R.id.banner); ToDo use banner by setting onclick
       // banner.setOnClickListener(this);

        registerUser = (Button) findViewById(R.id.registerButton);
        registerUser.setOnClickListener(this);

        editTextFullName = (EditText) findViewById(R.id.nameRegisterText);
        editTextAge = (EditText) findViewById(R.id.ageRegisterText);
        editTextGender = (AutoCompleteTextView)findViewById(R.id.gender);
        editTextEmail = (EditText) findViewById(R.id.emailRegisterText);
        editTextPassword = (EditText) findViewById(R.id.passwordRegisterText);
        editRegisterSignIn = (TextView) findViewById(R.id.editRegisterSignIn);
        editRegisterSignIn.setOnClickListener(this); //set on click listener
        checkBoxTerms = (CheckBox) findViewById(R.id.checkBoxTerms);
        progressBar = (ProgressBar) findViewById(R.id.progressBar2);
        termsAndConditions = (TextView) findViewById(R.id.termsAndConditions);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
          //  case R.id.banner:
               // startActivity(new Intent(this, MainActivity.class));
               // break;
            case R.id.registerButton:
                registerUser.setTextColor(getResources().getColor(R.color.amber)); //change colour on click

                //implement must agree to terms and conditions using if or case break out.
                if (checkBoxTerms.isChecked()){
                    registerUser();
                }
                else {
                    Toast.makeText(RegisterUser.this,"You must agree to terms and conditions",Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.termsAndConditions:
                termsAndConditions.setTextColor(getResources().getColor(R.color.amber)); //change colour on click
                //create a dialog prompt
                AlertDialog.Builder builder = new AlertDialog.Builder(RegisterUser.this);
                View customLayout = getLayoutInflater().inflate(R.layout.gibbs_dialog, null); //use designed layout as custom layout
                builder.setView(customLayout);
                //customise dialog layout
                TextView titleTextView = customLayout.findViewById(R.id.title_text_view);
                TextView messageTextView = customLayout.findViewById(R.id.message_text_view);
                Button negativeButton = customLayout.findViewById(R.id.negative_button);
                Button positiveButton = customLayout.findViewById(R.id.positive_button);

                titleTextView.setText("Terms and Conditions");
                messageTextView.setText("TermsAndConditions");

                //create and initialize dialog
                AlertDialog dialog = builder.create();
                dialog.show();

                negativeButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // handle negative button click
                        dialog.dismiss();
                    }
                });
                positiveButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // handle intent positive button click
                        dialog.dismiss();
                    }
                });

                break;

                //navigate to sign in if already created an account
            case R.id.editRegisterSignIn:
                editRegisterSignIn.setTextColor(getResources().getColor(R.color.amber)); //change colour on click
                startActivity(new Intent(this, MyLoginActivity.class));
                break;
            default:
                break;
        }
    }
    private void registerUser(){

            String email = editTextEmail.getText().toString().trim();
            String password = editTextPassword.getText().toString().trim();
            String fullName = editTextFullName.getText().toString().trim();
            String age = editTextAge.getText().toString().trim();
            String gender =  editTextGender.getText().toString().trim();



            if(fullName.isEmpty()){
                editTextFullName.setError("Full Name is required!");
                editTextFullName.requestFocus();
                return;
            }
            if(email.isEmpty()){
                editTextEmail.setError("Email is required!");
                editTextEmail.requestFocus();
                return;
            }
            //checks for email format validity
            if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
                editTextEmail.setError("Please enter a valid Email address!");
                editTextEmail.requestFocus();
                return;
            }
            //set minimum password limit to 6 as firebase takes 6 upwards
            if (password.length()<6){
                editTextPassword.setError("Please enter a minimum of 6 characters!");
                editTextPassword.requestFocus();
                return;
            }
        // handle invalid gender input
        if (!gender.matches("^(male|female|Male|Female)$")) {
            editTextGender.setError("Please use either male or female gender");
            editTextGender.requestFocus();
            return;
        }
        //create autocomplete for gender options
        AutoCompleteTextView editTextGender = findViewById(R.id.gender);
        String[] suggestions = getResources().getStringArray(R.array.suggestions);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, suggestions);
        editTextGender.setAdapter(adapter);




        //use progress bar for indicating if user has register on firebase or not
            progressBar.setVisibility(View.VISIBLE);
            mAuth.createUserWithEmailAndPassword(email, password)
                    .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()){
                                User user = new User(fullName, age,  email, gender); //create object for user and a class

                                //send user data to firebase real time database
                                FirebaseDatabase.getInstance().getReference("Users")
                                        .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                                        .setValue(user).addOnCompleteListener(new OnCompleteListener<Void>() {
                                            @Override
                                            public void onComplete(@NonNull Task<Void> task) {
                                                if (task.isSuccessful()){
                                                    Toast.makeText(RegisterUser.this, "User Registration Successful!", Toast.LENGTH_SHORT).show();
                                                    progressBar.setVisibility(View.VISIBLE);


                                                    // Create a new user with a full name etc for firestore
                                                    Map<String, Object> user = new HashMap<>();
                                                    user.put("fullName", fullName);
                                                    user.put("age", age);
                                                    user.put("email", email);
                                                    user.put("gender", gender);

                                                    // Add query to store data - new document with a generated ID
                                                    db.collection("users")
                                                            .add(user)
                                                            .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                                                                @Override
                                                                public void onSuccess(DocumentReference documentReference) {
                                                                    Toast.makeText(RegisterUser.this, "Data has been stored Successfully!", Toast.LENGTH_SHORT).show();
                                                                    startActivity(new Intent(RegisterUser.this,MainActivity.class));  //redirect to login layout
                                                                    finish();
//                                                                    Log.d(TAG, "DocumentSnapshot added with ID: " + documentReference.getId());
                                                                }
                                                            })
                                                            .addOnFailureListener(new OnFailureListener() {
                                                                @Override
                                                                public void onFailure(@NonNull Exception e) {
                                                                    Log.w(TAG, "Error adding document", e);
                                                                }
                                                            });

                                                }else{
                                                    Toast.makeText(RegisterUser.this, "Failed to register! Please try Again!", Toast.LENGTH_SHORT).show();
                                                    progressBar.setVisibility(View.GONE);
                                                }
                                            }
                                        });
                            }
                        }
                    });

        }

    }