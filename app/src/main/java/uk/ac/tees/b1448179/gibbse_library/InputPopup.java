package uk.ac.tees.b1448179.gibbse_library;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class InputPopup extends DialogFragment {



        private EditText inputEditText;
        private Button submitButton;

//    public InputPopup(EditText inputEditText, Button submitButton) {
//        this.inputEditText = inputEditText;
//        this.submitButton = submitButton;
//    }
//
//    public InputPopup(int contentLayoutId, EditText inputEditText, Button submitButton) {
//        super(contentLayoutId);
//        this.inputEditText = inputEditText;
//        this.submitButton = submitButton;
//}

    public InputPopup(EditText inputEditText, Button submitButton) {
        this.inputEditText = inputEditText;
        this.submitButton = submitButton;

    }

//    public InputPopup() {
//            // Required empty public constructor
//        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            // Inflate the layout for this fragment
            View view = inflater.inflate(R.layout.activity_input_popup, container, false);

            // Get the UI elements from the layout
            inputEditText = view.findViewById(R.id.inputEditText);
            submitButton = view.findViewById(R.id.submitButton);

            // Set up the submit button click listener
            submitButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    // Handle the user input here
                    String userInput = inputEditText.getText().toString();

                    // Dismiss the pop-up screen
                    dismiss();
                }
            });

            return view;
        }

    }






//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
////        setContentView(R.layout.activity_input_popup);
////    }
//}