package com.example.fittoo;

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
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class DashboardActivity extends AppCompatActivity {
    private BottomNavigationView bottomNav;
    private FloatingActionButton fabAddProgress;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        bottomNav = findViewById(R.id.bottom_navigation);
        fabAddProgress = findViewById(R.id.fab_add_progress);

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

        fabAddProgress.setOnClickListener(view -> {
            // Handle progress update creation
        });
    }

    private boolean loadFragment(Fragment fragment) {
        if (fragment != null) {
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.fragment_container, fragment);
            transaction.commit();
            return true;
        }
        return false;
    }

    @Override
    protected void onStart() {
        super.onStart();
        SharedPreferences sharedPreferences = getSharedPreferences("GOAL_PREFS", MODE_PRIVATE);
        TextView goalTitle = findViewById(R.id.goal_title);

        String selectedGoal = sharedPreferences.getString("SELECTED_GOAL", "Weight Loss");
        updateUIForGoal(selectedGoal);
    }

    private void updateUIForGoal(String goal) {
        TextView goalTitle = findViewById(R.id.goal_title);
        goalTitle.setText(goal + " Dashboard");
        TextView btnWorkouts = findViewById(R.id.btn_workouts);
        TextView btnDiet = findViewById(R.id.btn_diet);

        switch (goal) {
            case "Muscle Gain":
                btnWorkouts.setText("Strength Training");
                btnDiet.setText("High Protein Diet");
                break;
            case "Weight Loss":
                btnWorkouts.setText("Cardio Plans");
                btnDiet.setText("Calorie Deficit");
                break;
            default:
                btnWorkouts.setText("Workout Plans");
                btnDiet.setText("Diet Recommendations");
        }
    }
}