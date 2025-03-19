package com.example.fittoo;

import com.example.fittoo.ActiveWorkoutActivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.widget.Button;
import android.content.Intent;
import java.util.ArrayList;
import java.util.List;

public class WorkoutFragment extends Fragment implements WorkoutAdapter.OnWorkoutClickListener {
    private RecyclerView recyclerView;
    private WorkoutAdapter workoutAdapter;
    private List<WorkoutModel> workoutList;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_workouts, container, false);
        recyclerView = view.findViewById(R.id.workout_recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        // Load workout data
        loadWorkoutData();

        Button startButton = view.findViewById(R.id.start_workout_btn);
        startButton.setOnClickListener(v -> {
            // Start workout functionality
            startWorkoutSession();
        });

        return view;
    }

    private void loadWorkoutData() {
        workoutList = new ArrayList<>();
        workoutList.add(new WorkoutModel("Push-ups", "Build upper body strength with this classic exercise targeting chest, shoulders, and triceps", R.drawable.pushups_gif));
        workoutList.add(new WorkoutModel("Squats", "A fundamental lower body exercise that targets quads, hamstrings, and glutes", R.drawable.squats_gif));
        workoutList.add(new WorkoutModel("Lunges", "Improve balance and strengthen legs with this dynamic lower body movement", R.drawable.lunges_gif));

        workoutAdapter = new WorkoutAdapter(new ArrayList<>(workoutList), this);
        recyclerView.setAdapter(workoutAdapter);
    }

    @Override
    public void onWorkoutClick(Workout workout) {
        // Handle workout click
    }

    private void startWorkoutSession() {
        // Start workout timer service
        Intent serviceIntent = new Intent(getActivity(), WorkoutTimerService.class);
        getActivity().startService(serviceIntent);
        
        // Launch workout activity
        Intent workoutIntent = new Intent(getActivity(), ActiveWorkoutActivity.class);
        startActivity(workoutIntent);
    }

    @Override
    public void onStartWorkoutClick(Workout workout) {
        startWorkoutSession();
    }
}