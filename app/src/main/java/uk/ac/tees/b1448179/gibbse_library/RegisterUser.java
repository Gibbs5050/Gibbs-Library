package uk.ac.tees.b1448179.gibbse_library;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

public class RegisterUser extends AppCompatActivity implements View.OnClickListener {

    private ImageView banner;
    private TextView registerUser,editRegisterSignIn;
    private EditText editTextFullName, editTextAge, editTextEmail, editTextPassword;
    private ProgressBar progressBar;
    private FirebaseAuth mAuth;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_user);

        mAuth = FirebaseAuth.getInstance();
        banner = (ImageView) findViewById(R.id.banner);
        banner.setOnClickListener(this);

        registerUser = (Button) findViewById(R.id.registerButton);
        registerUser.setOnClickListener(this);

        editTextFullName = (EditText) findViewById(R.id.nameRegisterText);
        editTextAge = (EditText) findViewById(R.id.ageRegisterText);
        editTextEmail = (EditText) findViewById(R.id.emailRegisterText);
        editTextPassword = (EditText) findViewById(R.id.passwordRegisterText);
        editRegisterSignIn = (TextView) findViewById(R.id.editRegisterSignIn);
        editRegisterSignIn.setOnClickListener(this); //set on click listener

        progressBar = (ProgressBar) findViewById(R.id.progressBar2);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.banner:
                startActivity(new Intent(this, MainActivity.class));
                break;
            case R.id.registerButton:
                registerUser();
                //navigate to sign in if already created an account
            case R.id.editRegisterSignIn:
                startActivity(new Intent(this,MainActivity.class));

        }
    }
    private void registerUser(){

            String email = editTextEmail.getText().toString().trim();
            String password = editTextPassword.getText().toString().trim();
            String fullName = editTextFullName.getText().toString().trim();
            String age = editTextAge.getText().toString().trim();

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

            //use progress bar for indicating if user has register on firebase or not
            progressBar.setVisibility(View.VISIBLE);
            mAuth.createUserWithEmailAndPassword(email, password)
                    .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()){
                                User user = new User(fullName, age, email); //create object for user and a class

                                //send user data to firebase real time database
                                FirebaseDatabase.getInstance().getReference("Users")
                                        .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                                        .setValue(user).addOnCompleteListener(new OnCompleteListener<Void>() {
                                            @Override
                                            public void onComplete(@NonNull Task<Void> task) {
                                                if (task.isSuccessful()){
                                                    Toast.makeText(RegisterUser.this, "User Registration Successful!", Toast.LENGTH_SHORT).show();
                                                    progressBar.setVisibility(View.VISIBLE);
                                                    startActivity(new Intent(RegisterUser.this,MainActivity.class));  //redirect to login layout


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