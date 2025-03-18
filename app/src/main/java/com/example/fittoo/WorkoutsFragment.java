package com.example.fittoo;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.chip.Chip;
import com.google.android.material.chip.ChipGroup;

import java.util.ArrayList;
import java.util.List;

public class WorkoutsFragment extends Fragment implements WorkoutAdapter.OnWorkoutClickListener {
    private RecyclerView workoutRecycler;
    private WorkoutAdapter workoutAdapter;
    private List<Workout> workoutList;
    private ChipGroup categoryChipGroup;
    private ChipGroup difficultyChipGroup;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_workouts, container, false);
        
        workoutRecycler = view.findViewById(R.id.workout_recycler);
        workoutRecycler.setLayoutManager(new LinearLayoutManager(getContext()));
        
        categoryChipGroup = view.findViewById(R.id.category_chip_group);
        difficultyChipGroup = view.findViewById(R.id.difficulty_chip_group);
        
        setupWorkoutList();
        workoutAdapter = new WorkoutAdapter(workoutList, this);
        workoutRecycler.setAdapter(workoutAdapter);
        
        setupFilterListeners();
        
        return view;
    }

    private void setupFilterListeners() {
        categoryChipGroup.setOnCheckedChangeListener((group, checkedId) -> {
            String category = "All";
            if (checkedId != View.NO_ID) {
                Chip chip = group.findViewById(checkedId);
                if (chip != null) {
                    category = chip.getText().toString();
                }
            }
            applyFilters(category, getSelectedDifficulty());
        });

        difficultyChipGroup.setOnCheckedChangeListener((group, checkedId) -> {
            applyFilters(getSelectedCategory(), getSelectedDifficulty());
        });
    }

    private String getSelectedCategory() {
        int checkedId = categoryChipGroup.getCheckedChipId();
        if (checkedId != View.NO_ID) {
            Chip chip = categoryChipGroup.findViewById(checkedId);
            if (chip != null) {
                return chip.getText().toString();
            }
        }
        return "All";
    }

    private String getSelectedDifficulty() {
        int checkedId = difficultyChipGroup.getCheckedChipId();
        if (checkedId != View.NO_ID) {
            Chip chip = difficultyChipGroup.findViewById(checkedId);
            if (chip != null) {
                return chip.getText().toString();
            }
        }
        return "";
    }

    private void applyFilters(String category, String difficulty) {
        workoutAdapter.filter(category, difficulty);
    }

    private void setupWorkoutList() {
        workoutList = new ArrayList<>();
        
        // Add beginner workouts
        workoutList.add(new Workout(
            "Beginner Full Body",
            "Basic full body workout perfect for beginners",
            "fullbody_wo",
            3,
            10,
            "45 sec",
            "Strength",
            "Beginner"
        ));
        
        workoutList.add(new Workout(
            "Jump Rope Cardio",
            "High-intensity jump rope workout for endurance",
            "placeholder",
            4,
            60,
            "30 sec",
            "HIIT",
            "Beginner"
        ));
        
        workoutList.add(new Workout(
            "Basic Core",
            "Foundation core exercises for beginners",
            "core_wo",
            3,
            12,
            "30 sec",
            "Strength",
            "Beginner"
        ));
        
        // Add intermediate workouts
        workoutList.add(new Workout(
            "Full Body Strength",
            "Complete full body workout targeting all major muscle groups",
            "fullbody_wo",
            4,
            12,
            "60 sec",
            "Strength",
            "Intermediate"
        ));
        
        workoutList.add(new Workout(
            "Running Intervals",
            "Alternating between high and low intensity running",
            "placeholder",
            6,
            30,
            "30 sec",
            "Steady State",
            "Intermediate"
        ));
        
        workoutList.add(new Workout(
            "Core Power",
            "Intensive core workout for stronger abs and better stability",
            "core_wo",
            3,
            15,
            "45 sec",
            "Strength",
            "Intermediate"
        ));
        
        workoutList.add(new Workout(
            "Intermediate HIIT",
            "Balanced high-intensity interval training",
            "hiit_wo",
            4,
            40,
            "40 sec",
            "HIIT",
            "Intermediate"
        ));
        
        // Add advanced workouts
        workoutList.add(new Workout(
            "HIIT Cardio Pro",
            "High-intensity interval training for maximum calorie burn",
            "hiit_wo",
            5,
            45,
            "30 sec",
            "HIIT",
            "Advanced"
        ));
        
        workoutList.add(new Workout(
            "Ab Shredder",
            "Advanced ab workout for definition and strength",
            "placeholder",
            4,
            20,
            "30 sec",
            "Strength",
            "Advanced"
        ));
        
        workoutList.add(new Workout(
            "Elite Endurance",
            "Advanced endurance training with complex movements",
            "placeholder",
            5,
            50,
            "40 sec",
            "Steady State",
            "Advanced"
        ));
        
        workoutList.add(new Workout(
            "Power HIIT",
            "Intense HIIT workout with advanced exercises",
            "placeholder",
            6,
            35,
            "30 sec",
            "HIIT",
            "Advanced"
        ));
    }

    @Override
    public void onWorkoutClick(Workout workout) {
        Toast.makeText(getContext(), "Opening " + workout.getName(), Toast.LENGTH_SHORT).show();
        // TODO: Navigate to workout details
    }

    @Override
    public void onStartWorkoutClick(Workout workout) {
        Toast.makeText(getContext(), "Starting " + workout.getName(), Toast.LENGTH_SHORT).show();
        // TODO: Start workout session
    }
}