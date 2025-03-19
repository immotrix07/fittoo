package com.example.fittoo;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import com.bumptech.glide.Glide;
import com.google.android.material.snackbar.Snackbar;

public class WorkoutDetailsActivity extends AppCompatActivity {
    private WorkoutPlan workout;
    private ImageView exerciseAnimation;
    private TextView nameText;
    private TextView descriptionText;
    private TextView setsText;
    private TextView repsText;
    private TextView restTimeText;
    private TextView equipmentText;
    private Button startWorkoutButton;
    private Button markCompletedButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout_details);

        // Get workout data from intent
        workout = getIntent().getParcelableExtra("workout");
        if (workout == null) {
            finish();
            return;
        }

        initializeViews();
        setupViews();
        setupButtons();
    }

    private void initializeViews() {
        exerciseAnimation = findViewById(R.id.exerciseAnimation);
        nameText = findViewById(R.id.nameText);
        descriptionText = findViewById(R.id.descriptionText);
        setsText = findViewById(R.id.setsText);
        repsText = findViewById(R.id.repsText);
        restTimeText = findViewById(R.id.restTimeText);
        equipmentText = findViewById(R.id.equipmentText);
        startWorkoutButton = findViewById(R.id.startWorkoutButton);
        markCompletedButton = findViewById(R.id.markCompletedButton);
    }

    private void setupViews() {
        // Load exercise animation
        Glide.with(this)
                .asGif()
                .load(workout.getAnimationResourceId())
                .into(exerciseAnimation);

        // Set text views
        nameText.setText(workout.getName());
        descriptionText.setText(workout.getDescription());
        setsText.setText(String.format("Sets: %d", workout.getSets()));
        repsText.setText(String.format("Reps: %d", workout.getReps()));
        restTimeText.setText(String.format("Rest: %d seconds", workout.getRestTime()));
        equipmentText.setText(String.format("Equipment: %s", workout.getEquipment()));

        // Update completed status
        updateCompletedStatus();
    }

    private void setupButtons() {
        startWorkoutButton.setOnClickListener(v -> startWorkout());
        markCompletedButton.setOnClickListener(v -> toggleWorkoutCompletion());
    }

    private void startWorkout() {
        // TODO: Implement workout timer and guidance
        Snackbar.make(findViewById(android.R.id.content),
                "Starting workout...", Snackbar.LENGTH_SHORT).show();
    }

    private void toggleWorkoutCompletion() {
        workout.setCompleted(!workout.isCompleted());
        updateCompletedStatus();
        saveWorkoutProgress();
    }

    private void updateCompletedStatus() {
        markCompletedButton.setText(workout.isCompleted() ? 
                "Mark as Incomplete" : "Mark as Completed");
    }

    private void saveWorkoutProgress() {
        // TODO: Implement local storage for workout progress
        String message = workout.isCompleted() ? "Workout completed!" : "Workout marked as incomplete";
        Snackbar.make(findViewById(android.R.id.content), message, Snackbar.LENGTH_SHORT).show();
    }
}