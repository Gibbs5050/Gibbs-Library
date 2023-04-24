package uk.ac.tees.b1448179.gibbse_library.MyNotes;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.PopupMenu;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.Query;

import uk.ac.tees.b1448179.gibbse_library.MyLoginActivity;
import uk.ac.tees.b1448179.gibbse_library.Notes_Activity;
import uk.ac.tees.b1448179.gibbse_library.R;

public class Notesfragment extends Fragment {

    FloatingActionButton addNoteBtn;
    RecyclerView recyclerView;
    ImageButton menuBtn;
    NoteAdapter noteAdapter;

    @SuppressLint("MissingInflatedId")
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_note, container,false);

        addNoteBtn = v.findViewById(R.id.add_note_btn);
        recyclerView = v.findViewById(R.id.recyler_view);
        menuBtn = v.findViewById(R.id.menu_btn);

        addNoteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Notesfragment.this.getActivity(), Notes_Activity.class));

            }
        });
        Animation anim = AnimationUtils.loadAnimation(this.getContext(), R.anim.landing_anim);
        addNoteBtn.setAnimation(anim);

//        addNoteBtn.setOnClickListener((view)-> startActivity(new Intent(Notesfragment.this.getActivity(),NotesActivity.class)) );
        menuBtn.setOnClickListener((view)->showMenu() );
        setupRecyclerView();
        return v;
    }

    void showMenu(){
        PopupMenu popupMenu  = new PopupMenu(Notesfragment.this.getActivity(),menuBtn);
        popupMenu.getMenu().add("Logout");
        popupMenu.show();
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                if(menuItem.getTitle()=="Logout"){
                    FirebaseAuth.getInstance().signOut();
                    startActivity(new Intent(Notesfragment.this.getActivity(), MyLoginActivity.class));
                    getActivity().finish();
                    return true;
                }
                return false;
            }
        });

    }

    void setupRecyclerView(){
        Query query  = Utility.getCollectionReferenceForNotes().orderBy("timestamp",Query.Direction.DESCENDING);
        FirestoreRecyclerOptions<Note> options = new FirestoreRecyclerOptions.Builder<Note>()
                .setQuery(query,Note.class).build();
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getContext()));
        noteAdapter = new NoteAdapter(options,this.getContext());
        recyclerView.setAdapter(noteAdapter);
    }

    @Override
    public void onStart() {
        super.onStart();
        noteAdapter.startListening();
    }

    @Override
    public void onStop() {
        super.onStop();
        noteAdapter.stopListening();
    }

    @Override
    public void onResume() {
        super.onResume();
        noteAdapter.notifyDataSetChanged();
    }
}