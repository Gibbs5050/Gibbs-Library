package uk.ac.tees.b1448179.gibbse_library;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MyLoginActivity extends AppCompatActivity implements View.OnClickListener {
    //declare variables
    private TextView register,forgotPassword,guestHomePage1;
    private EditText editLoginTextEmail, editLoginTextPassword;
    private Button buttonLogin;
    private Button inputButton;
    private FirebaseAuth mAuth;
    private ProgressBar progressBar;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //initialise variables and set action listener
        register = (TextView) findViewById(R.id.RegisterLoginID);
        register.setOnClickListener(this);
        buttonLogin = (Button) findViewById(R.id.buttonLogin);
        buttonLogin.setOnClickListener(this);
        editLoginTextEmail = (EditText) findViewById(R.id.editLoginTextEmail);
        editLoginTextPassword = (EditText) findViewById(R.id.editLoginTextPassword);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        mAuth = FirebaseAuth.getInstance();
        forgotPassword = (TextView) findViewById(R.id.forgotPassword);
        forgotPassword.setOnClickListener(this); //set on click listener
        guestHomePage1 = (TextView) findViewById(R.id.loginHomePage2);
        guestHomePage1.setOnClickListener(this);

//        inputButton = findViewById(R.id.loginHomePage);

//        loginHomePage.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                // Show the input pop-up screen
//                InputPopup inputPopup = new InputPopup();
//                inputPopup.show(getSupportFragmentManager(), "input_popup");
//            }
//        });



        //get the name to display
//        String userInput = fullNameTextView.getText().toString();
//        Toast.makeText(ProfileFragment.this.getActivity(), "Welcome to your profile " + userInput + "!", Toast.LENGTH_SHORT).show();

    }


    //create the method that implements view on click listener
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.RegisterLoginID:
                startActivity(new Intent(this,RegisterUser.class)); //redirect to register layout
                register.setTextColor(getResources().getColor(R.color.amber)); //change colour on click
                break;
            case R.id.buttonLogin:
                userLogin();     //login user
                buttonLogin.setTextColor(getResources().getColor(R.color.amber)); //change colour on click
                break;
            case R.id.forgotPassword:
                startActivity(new Intent(this,IForgotPassword.class)); //redirect to forgot password layout
                forgotPassword.setTextColor(getResources().getColor(R.color.amber)); //change colour on click
                break;
            case R.id.loginHomePage2:
                startActivity(new Intent(this, MainActivity.class)); //redirect to homepage layout
                Toast.makeText(MyLoginActivity.this, "Welcome to Gibbs Library!", Toast.LENGTH_SHORT).show();
                guestHomePage1.setTextColor(getResources().getColor(R.color.amber)); //change colour on click
                break;

            default:
                throw new IllegalStateException("Unexpected value: " + v.getId());
        }
    }

    private void userLogin() {
        String email = editLoginTextEmail.getText().toString().trim();
        String password = editLoginTextPassword.getText().toString().trim();

        // set login conditions for error management
        if (email.isEmpty()){
            editLoginTextEmail.setError("Email is Required");
            editLoginTextEmail.requestFocus();
            return;
        }
        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            editLoginTextEmail.setError("Please enter a valid Email!");
            editLoginTextEmail.requestFocus();
            return;
        }
        //set password length
        if (password.length()<6){
            editLoginTextPassword.setError("Min Password length should be 6 characters");
            editLoginTextPassword.requestFocus();
            return;
        }

        progressBar.setVisibility(View.VISIBLE);
        mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

                if (task.isSuccessful()){

                    //verify email
                    FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
                    if (user.isEmailVerified()){
                        //redirect to user profile
                        startActivity(new Intent(MyLoginActivity.this, MainActivity.class));
                        Toast.makeText(MyLoginActivity.this, "Welcome to Gibbs Library! ", Toast.LENGTH_SHORT).show();
                    } else{
                        user.sendEmailVerification();
                        Toast.makeText(MyLoginActivity.this, "Check your Email to verify account", Toast.LENGTH_LONG).show();
                    }

                }else {
                    //display message for user
                    Toast.makeText(MyLoginActivity.this, "Oops! Failed to Login! Please check details and try again!",
                            Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}