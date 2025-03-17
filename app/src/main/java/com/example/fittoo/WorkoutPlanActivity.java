package com.example.fittoo;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class WorkoutPlanActivity extends AppCompatActivity {
    private TextView goalText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout_plan);

        goalText = findViewById(R.id.goalText);
        
        // Get the selected goal from intent
        String selectedGoal = getIntent().getStringExtra("selected_goal");
        if (selectedGoal != null) {
            goalText.setText("Selected Goal: " + selectedGoal);
        }
    }

    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
    }
}