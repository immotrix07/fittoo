package com.example.fittoo;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.chip.Chip;
import com.google.android.material.chip.ChipGroup;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;

public class ResultsActivity extends AppCompatActivity {
    private TextView weightSummary, heightSummary, waistSummary;
    private TextView whtrValue, whtrStatus;
    private TextView bmrValue, tdeeValue;
    private ChipGroup goalChipGroup;
    private ExtendedFloatingActionButton continueButton;

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

        // Set up goal selection
        setupGoalSelection();

        // Set up continue button
        setupContinueButton();
    }

    private void initializeViews() {
        weightSummary = findViewById(R.id.weightSummary);
        heightSummary = findViewById(R.id.heightSummary);
        waistSummary = findViewById(R.id.waistSummary);
        whtrValue = findViewById(R.id.whtrValue);
        whtrStatus = findViewById(R.id.whtrStatus);
        bmrValue = findViewById(R.id.bmrValue);
        tdeeValue = findViewById(R.id.tdeeValue);
        goalChipGroup = findViewById(R.id.goalChipGroup);
        continueButton = findViewById(R.id.continueButton);
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
        goalChipGroup.setOnCheckedChangeListener((group, checkedId) -> {
            Chip chip = findViewById(checkedId);
            if (chip != null) {
                // Enable continue button when a goal is selected
                continueButton.setEnabled(true);
            }
        });
    }

    private void setupContinueButton() {
        continueButton.setEnabled(false); // Initially disabled until goal is selected
        continueButton.setOnClickListener(v -> {
            int selectedChipId = goalChipGroup.getCheckedChipId();
            if (selectedChipId != View.NO_ID) {
                Chip selectedChip = findViewById(selectedChipId);
                String selectedGoal = selectedChip.getText().toString();
                // TODO: Handle the selected goal (e.g., save to SharedPreferences)
                // For now, just finish the activity
                finish();
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