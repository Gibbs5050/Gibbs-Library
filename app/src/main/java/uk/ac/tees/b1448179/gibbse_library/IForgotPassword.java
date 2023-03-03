package uk.ac.tees.b1448179.gibbse_library;

import static uk.ac.tees.b1448179.gibbse_library.R.id.resetLogin;

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
import com.google.firebase.auth.FirebaseAuth;

public class IForgotPassword extends AppCompatActivity implements View.OnClickListener {

    private EditText emailEditText;
    private TextView resetLogin;
    private Button resetPasswordButton;
    private ProgressBar progressBar;

    FirebaseAuth auth;

        @SuppressLint("MissingInflatedId") //suppress warnings from the Android lint tool
        @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_iforgot_password);

        emailEditText  = (EditText) findViewById(R.id.editTextForgotEmailAddress);
        resetPasswordButton = (Button) findViewById(R.id.resetPasswordButton);
        progressBar = (ProgressBar) findViewById(R.id.progressBarReset);
        resetLogin = (TextView) findViewById(R.id.resetLogin);
        resetLogin.setOnClickListener(this);
        auth = FirebaseAuth.getInstance();
        //set on click listener
        resetPasswordButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetPassword();
            }
        });
    }
    //create method for the resetPassword
    private void resetPassword(){
            String email = emailEditText.getText().toString().trim(); //convert to string and trim for excess input


            if (email.isEmpty()){
                emailEditText.setError("Please Enter Email to proceed");
                emailEditText.requestFocus();
                return;
            }
            if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
                emailEditText.setError("Please provide valid Email Address");
                emailEditText.requestFocus();
                return;
            }

            progressBar.setVisibility(View.VISIBLE);
            auth.sendPasswordResetEmail(email).addOnCompleteListener(new OnCompleteListener<Void>() {
                @Override
                public void onComplete(@NonNull Task<Void> task) {
                    if (task.isSuccessful()){
                        Toast.makeText(IForgotPassword.this, "Reset Link Sent to Email", Toast.LENGTH_LONG).show();
                        startActivity(new Intent(IForgotPassword.this,MainActivity.class));  //redirect to login layout


                    }else{
                        Toast.makeText(IForgotPassword.this, "Oops! Looks like something went wrong, Try Again", Toast.LENGTH_LONG).show();
                    }

                }
            });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            //  case R.id.banner:
            // startActivity(new Intent(this, MainActivity.class));
            // break;
            case R.id.resetLogin:
                startActivity(new Intent(this, MainActivity.class));


        }

    }
}