package com.example.fittoo;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class RemindersFragment extends Fragment {
    private RecyclerView remindersRecycler;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_reminders, container, false);
        
        remindersRecycler = view.findViewById(R.id.reminders_recycler);
        remindersRecycler.setLayoutManager(new LinearLayoutManager(getContext()));
        
        // TODO: Set up RecyclerView adapter
        
        return view;
    }
}