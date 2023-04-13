package uk.ac.tees.b1448179.gibbse_library.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import uk.ac.tees.b1448179.gibbse_library.DictionaryModels.Meanings;
import uk.ac.tees.b1448179.gibbse_library.DictionaryModels.Phonetics;
import uk.ac.tees.b1448179.gibbse_library.R;
import uk.ac.tees.b1448179.gibbse_library.ViewHolders.MeaningsViewHolder;
import uk.ac.tees.b1448179.gibbse_library.ViewHolders.PhoneticViewHolder;

public class MeaningAdaptor extends RecyclerView.Adapter<MeaningsViewHolder> {
    private Context context;
    private List<Meanings> meaningsList;

    public MeaningAdaptor(Context context, List<Meanings> meaningsList) {
        this.context = context;
        this.meaningsList = meaningsList;
    }

    @NonNull
    @Override
    public MeaningsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MeaningsViewHolder(LayoutInflater.from(context).inflate(R.layout.meaning_list_items, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MeaningsViewHolder holder, int position) {
        holder.textView_partsOfSpeech.setText("Parts of Speech:   " + meaningsList.get(position).getPartOfSpeech());
        holder.recycler_definitions.setHasFixedSize(true);
        holder.recycler_definitions.setLayoutManager(new GridLayoutManager(context, 1));

        DefinitionAdapter definitionAdapter = new DefinitionAdapter(context, meaningsList.get(position).getDefinitions());
        holder.recycler_definitions.setAdapter(definitionAdapter);

    }

    @Override
    public int getItemCount() {
        return meaningsList.size();
    }
}
