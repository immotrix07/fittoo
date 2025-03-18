package com.example.fittoo;

import android.widget.HorizontalScrollView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.content.SharedPreferences;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.chip.Chip;
import com.google.android.material.chip.ChipGroup;

public class DashboardActivity extends AppCompatActivity {
    private BottomNavigationView bottomNav;

    private ChipGroup filterChipGroup;
    private WorkoutAdapter workoutAdapter;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        bottomNav = findViewById(R.id.bottom_navigation);
        filterChipGroup = findViewById(R.id.filter_chip_group);

        setupChipGroupListeners();

        loadFragment(new WorkoutsFragment());

        bottomNav.setOnItemSelectedListener(item -> {
            Fragment selectedFragment = null;
            int itemId = item.getItemId();
            if (itemId == R.id.nav_workouts) {
                selectedFragment = new WorkoutsFragment();
            } else if (itemId == R.id.nav_diet) {
                selectedFragment = new DietFragment();
            } else if (itemId == R.id.nav_progress) {
                selectedFragment = new ProgressFragment();
            } else if (itemId == R.id.nav_reminders) {
                selectedFragment = new RemindersFragment();
            }
            return loadFragment(selectedFragment);
        });

    }

    private boolean loadFragment(Fragment fragment) {
        if (fragment != null) {
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.fragment_container, fragment);
            transaction.commit();

            // Show filter bar only for WorkoutsFragment
            HorizontalScrollView filterScrollView = findViewById(R.id.filter_scroll_view);
            if (fragment instanceof WorkoutsFragment) {
                filterScrollView.setVisibility(View.VISIBLE);
            } else {
                filterScrollView.setVisibility(View.GONE);
            }
            return true;
        }
        return false;
    }

    @Override
    protected void onStart() {
        super.onStart();
        SharedPreferences sharedPreferences = getSharedPreferences("GOAL_PREFS", MODE_PRIVATE);
        String selectedGoal = sharedPreferences.getString("SELECTED_GOAL", "Weight Loss");
        updateUIForGoal(selectedGoal);
    }

    private void updateUIForGoal(String goal) {
        // Update the UI based on selected goal without using TextViews
        switch (goal) {
            case "Muscle Gain":
                // Update UI elements for Muscle Gain goal
                break;
            case "Weight Loss":
                // Update UI elements for Weight Loss goal
                break;
            default:
                // Default UI updates
        }
    }

    private void setupChipGroupListeners() {
        Chip chipAll = findViewById(R.id.chip_all);
        Chip chipHiit = findViewById(R.id.chip_hiit);
        Chip chipSteadyState = findViewById(R.id.chip_steady_state);
        Chip chipBeginner = findViewById(R.id.chip_beginner);
        Chip chipAdvanced = findViewById(R.id.chip_advanced);

        filterChipGroup.setOnCheckedChangeListener((group, checkedId) -> {
            String category = "All";
            String difficultyLevel = "";

            if (checkedId == R.id.chip_hiit) {
                category = "HIIT";
            } else if (checkedId == R.id.chip_steady_state) {
                category = "Steady State";
            } else if (checkedId == R.id.chip_beginner) {
                difficultyLevel = "Beginner";
            } else if (checkedId == R.id.chip_advanced) {
                difficultyLevel = "Advanced";
            }

            if (workoutAdapter != null) {
                workoutAdapter.filter(category, difficultyLevel);
            }
        });
    }
}