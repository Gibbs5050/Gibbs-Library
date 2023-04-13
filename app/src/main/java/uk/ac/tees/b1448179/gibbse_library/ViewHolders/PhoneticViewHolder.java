package uk.ac.tees.b1448179.gibbse_library.ViewHolders;

import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import uk.ac.tees.b1448179.gibbse_library.R;

public class PhoneticViewHolder extends RecyclerView.ViewHolder {

    public TextView textView_phonetic;
    public ImageButton imageButton_audio;


    public PhoneticViewHolder(@NonNull View itemView) {
        super(itemView);

        //initialize
        textView_phonetic = itemView.findViewById(R.id.textView_phonetic);
        imageButton_audio = itemView.findViewById(R.id.imageButton_audio);
    }
}
