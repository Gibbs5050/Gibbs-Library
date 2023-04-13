package uk.ac.tees.b1448179.gibbse_library.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import uk.ac.tees.b1448179.gibbse_library.DictionaryModels.Definitions;
import uk.ac.tees.b1448179.gibbse_library.DictionaryModels.Meanings;
import uk.ac.tees.b1448179.gibbse_library.R;
import uk.ac.tees.b1448179.gibbse_library.ViewHolders.DefinitionViewHolder;
import uk.ac.tees.b1448179.gibbse_library.ViewHolders.MeaningsViewHolder;

public class DefinitionAdapter extends RecyclerView.Adapter<DefinitionViewHolder> {
    private Context context;
    private List<Definitions> definitionsList;

    public DefinitionAdapter(Context context, List<Definitions> definitionsList) {
        this.context = context;
        this.definitionsList = definitionsList;
    }

    @NonNull
    @Override
    public DefinitionViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new DefinitionViewHolder(LayoutInflater.from(context).inflate(R.layout.definitions__list_items, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull DefinitionViewHolder holder, int position) {
        holder.textView_definition.setText("Parts of Speech:   " + definitionsList.get(position).getDefinition());
        holder.textView_example.setText("Example:     " + definitionsList.get(position).getExample());

        //to add to list we create string builders
        StringBuilder synonyms = new StringBuilder();
        StringBuilder antonyms = new StringBuilder();

        synonyms.append(definitionsList.get(position).getSynonyms());
        antonyms.append(definitionsList.get(position).getAntonyms());

        holder.textView_synonyms.setText(synonyms);
        holder.textView_antonyms.setText(antonyms);

        //make text view selective
        holder.textView_synonyms.setSelected(true);
        holder.textView_antonyms.setSelected(true);

    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
