package uk.ac.tees.b1448179.gibbse_library.ViewHolders;

import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import uk.ac.tees.b1448179.gibbse_library.R;

public class DefinitionViewHolder extends RecyclerView.ViewHolder {

    public TextView textView_definition,textView_example, textView_synonyms,textView_antonyms;

    public DefinitionViewHolder(@NonNull View itemView) {
        super(itemView);

        //initialize
        textView_definition = itemView.findViewById(R.id.textView_definition);
        textView_example = itemView.findViewById(R.id.textView_example);
        textView_synonyms = itemView.findViewById(R.id.textView_synonyms);
        textView_antonyms = itemView.findViewById(R.id.textView_antonyms);
    }
}
