package uk.ac.tees.b1448179.gibbse_library;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

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

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    //declare variables
    private TextView register;
    private EditText editLoginTextEmail, editLoginTextPassword;
    private Button buttonLogin;

    private FirebaseAuth mAuth;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    //set Action listener
        register = (TextView) findViewById(R.id.RegisterLoginID);
        register.setOnClickListener(this);

        //initialise variables
        buttonLogin = (Button) findViewById(R.id.buttonLogin);
        buttonLogin.setOnClickListener(this);
        editLoginTextEmail = (EditText) findViewById(R.id.editLoginTextEmail);
        editLoginTextPassword = (EditText) findViewById(R.id.editLoginTextPassword);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        mAuth = FirebaseAuth.getInstance();

    }

    //create the method that implements view on click listener
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.RegisterLoginID:
                startActivity(new Intent(this,RegisterUser.class));
                break;
            case R.id.buttonLogin:
                userLogin();
                break;

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
                        startActivity(new Intent(MainActivity.this, HomePage.class));
                    } else{
                        user.sendEmailVerification();
                        Toast.makeText(MainActivity.this, "Check your Email to verify account", Toast.LENGTH_LONG).show();
                    }

                }else {
                    //display message for user
                    Toast.makeText(MainActivity.this, "Oops! Failed to Login! Please check details and try again!",
                            Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}