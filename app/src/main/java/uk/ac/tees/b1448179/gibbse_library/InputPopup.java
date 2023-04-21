package uk.ac.tees.b1448179.gibbse_library;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.PopupWindow;

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
            inputEditText = view.findViewById(R.id.nameInput);
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
//    private void showPopup() {
//    }

    //using another layout on this to display pop up
    public void showPopup(View view) {
        // Inflate the pop-up layout
        View popupView = getLayoutInflater().inflate(R.layout.activity_input_popup, null);

        // Create a pop-up window
        int width = LinearLayout.LayoutParams.MATCH_PARENT;
        int height = LinearLayout.LayoutParams.WRAP_CONTENT;
        final PopupWindow popupWindow = new PopupWindow(popupView, width, height, true);

        // Get the EditText and Button views from the layout
        EditText editText = popupView.findViewById(R.id.nameInput);
        Button buttonOk = popupView.findViewById(R.id.submitButton);

        // Set a click listener for the Button to get the text from the EditText view
        buttonOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String value = editText.getText().toString();
                // Do something with the value (e.g. display it in a TextView)
                popupWindow.dismiss();
            }
        });

        // Show the pop-up window at the center of the screen
        popupWindow.showAtLocation(view, Gravity.CENTER, 0, 0);
    }

    }






//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
////        setContentView(R.layout.activity_input_popup);
////    }
//}