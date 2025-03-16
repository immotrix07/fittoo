package com.example.fittoo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;

public class ResultsActivity extends AppCompatActivity {
    private TextView headerTitle, weightSummary, heightSummary, waistSummary;
    private TextView whtrValue, whtrStatus;
    private TextView bmrValue, tdeeValue;
    private TextView recommendationText;
    private ExtendedFloatingActionButton continueButton;
    private View infoButton;
    private RadioGroup goalRadioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);

        // Initialize views
        initializeViews();
        
        // Get data from intent
        Bundle data = getIntent().getExtras();
        if (data != null) {
            displayUserData(data);
            displayMetabolicData(data);
        }

        // Set up continue button
        setupContinueButton();

        // Set up goal selection
        setupGoalSelection();
    }

    private void initializeViews() {
        headerTitle = findViewById(R.id.headerTitle);
        weightSummary = findViewById(R.id.weightSummary);
        heightSummary = findViewById(R.id.heightSummary);
        waistSummary = findViewById(R.id.waistSummary);
        whtrValue = findViewById(R.id.whtrValue);
        whtrStatus = findViewById(R.id.whtrStatus);
        bmrValue = findViewById(R.id.bmrValue);
        tdeeValue = findViewById(R.id.tdeeValue);
        recommendationText = findViewById(R.id.recommendationText);
        continueButton = findViewById(R.id.continueButton);
        infoButton = findViewById(R.id.infoButton);
        goalRadioGroup = findViewById(R.id.goalRadioGroup);
    }

    private void displayUserData(Bundle data) {
        double weight = data.getDouble("weight");
        double height = data.getDouble("height");
        double waist = data.getDouble("waist");

        weightSummary.setText(String.format("Weight: %.1f kg", weight));
        heightSummary.setText(String.format("Height: %.1f cm", height));
        waistSummary.setText(String.format("Waist: %.1f cm", waist));

        // Calculate and display WHtR
        double whtr = waist / height;
        whtrValue.setText(String.format("%.2f", whtr));
        
        // Set WHtR status and color
        if (whtr > 0.5) {
            whtrStatus.setText("High Risk");
            whtrStatus.setTextColor(getResources().getColor(android.R.color.holo_red_dark));
        } else {
            whtrStatus.setText("Healthy Range");
            whtrStatus.setTextColor(getResources().getColor(android.R.color.holo_green_dark));
        }
    }

    private void displayMetabolicData(Bundle data) {
        double bmr = data.getDouble("bmr");
        double tdee = data.getDouble("tdee");

        bmrValue.setText(String.format("BMR: %.0f calories/day", bmr));
        tdeeValue.setText(String.format("TDEE: %.0f calories/day", tdee));
    }

    private void setupGoalSelection() {
        goalRadioGroup.setOnCheckedChangeListener((group, checkedId) -> {
            continueButton.setEnabled(checkedId != -1);
        });
        
        // Automatically select recommended goal
        goalRadioGroup.check(R.id.weightLossRadio);
        // Listener will be automatically triggered by check() call
    }

    private void setupContinueButton() {
        // Button state managed entirely by radio group selection listener
        continueButton.setOnClickListener(v -> {
            int selectedId = goalRadioGroup.getCheckedRadioButtonId();
            if (selectedId != -1) {
                String selectedGoal;
                if (selectedId == R.id.weightLossRadio) {
                    selectedGoal = "Weight Loss";
                } else if (selectedId == R.id.muscleGainRadio) {
                    selectedGoal = "Muscle Gain";
                } else if (selectedId == R.id.recompRadio) {
                    selectedGoal = "Body Recomposition";
                } else {
                    selectedGoal = "General Fitness";
                }

                // Start WorkoutPlanActivity with the selected goal
                Intent intent = new Intent(this, DashboardActivity.class);
                intent.putExtra("selected_goal", selectedGoal);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
            }
        });
    }

    @Override
    public void finish() {
        super.finish();
        // Add exit animation
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
    }
}