package com.example.myapp;

import android.os.Bundle;

import androidx.constraintlayout.widget.Group;
import androidx.constraintlayout.widget.Placeholder;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class ConstraintFragment extends Fragment {

    private Placeholder placeholder;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_constraint, container, false);
//        Constraint layout group the view
//        Group group=view.findViewById(R.id.group);
//        group.setVisibility(View.GONE);

//        Placeholder
        placeholder=(Placeholder) view.findViewById(R.id.placeholder);

        return view;
    }

    public void swapView(View view) {

//        placeholder.setContentId(view.getId());
    }
}