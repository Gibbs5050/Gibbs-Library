package uk.ac.tees.b1448179.gibbse_library.AllFragmentsContainer;


import android.annotation.SuppressLint;

import android.os.Bundle;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import uk.ac.tees.b1448179.gibbse_library.R;



public class CatalogueFragment extends Fragment {

    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_catalogue, container, false);




        return v;
    }
}


