package com.example.fittoo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.AutoCompleteTextView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.chip.ChipGroup;
import com.google.android.material.chip.Chip;

public class MainActivity extends AppCompatActivity {
    private TextInputEditText weightInput;
    private TextInputEditText heightInput;
    private TextInputEditText waistInput;
    private TextInputEditText ageInput;
    private ChipGroup genderGroup;
    private AutoCompleteTextView activitySpinner;
    private Button calculateButton;
    private TextView resultTitle;
    private TextView goalText;
    private TextView bmrText;
    private TextView tdeeText;
    private TextView whtrText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initializeViews();
        setupActivitySpinner();
        setupCalculateButton();
    }

    private void initializeViews() {
        weightInput = findViewById(R.id.weightInput);
        heightInput = findViewById(R.id.heightInput);
        waistInput = findViewById(R.id.waistInput);
        ageInput = findViewById(R.id.ageInput);
        genderGroup = findViewById(R.id.genderGroup);
        activitySpinner = findViewById(R.id.activitySpinner);
        calculateButton = findViewById(R.id.calculateButton);
        resultTitle = findViewById(R.id.resultTitle);
        goalText = findViewById(R.id.goalText);
        bmrText = findViewById(R.id.bmrText);
        tdeeText = findViewById(R.id.tdeeText);
        whtrText = findViewById(R.id.whtrText);
    }

    private void setupActivitySpinner() {
        ArrayAdapter<FitnessCalculator.ActivityLevel> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_dropdown_item_1line,
                FitnessCalculator.ActivityLevel.values());
        activitySpinner.setAdapter(adapter);
    }

    private void setupCalculateButton() {
        calculateButton.setOnClickListener(v -> calculateFitnessRecommendation());
    }

    private void calculateFitnessRecommendation() {
        try {
            String weightStr = weightInput.getText().toString().trim();
            String heightStr = heightInput.getText().toString().trim();
            String waistStr = waistInput.getText().toString().trim();
            String ageStr = ageInput.getText().toString().trim();

            if (weightStr.isEmpty() || heightStr.isEmpty() || waistStr.isEmpty() || ageStr.isEmpty()) {
                showError("Please fill in all fields");
                return;
            }

            double weight = Double.parseDouble(weightStr);
            double height = Double.parseDouble(heightStr);
            double waist = Double.parseDouble(waistStr);
            int age = Integer.parseInt(ageStr);

            Chip selectedGender = findViewById(genderGroup.getCheckedChipId());
            if (selectedGender == null) {
                showError("Please select a gender");
                return;
            }

            FitnessCalculator.Gender gender = selectedGender.getId() == R.id.maleChip ?
                    FitnessCalculator.Gender.MALE : FitnessCalculator.Gender.FEMALE;

            String selectedActivity = activitySpinner.getText().toString();
            FitnessCalculator.ActivityLevel activityLevel = FitnessCalculator.ActivityLevel.valueOf(selectedActivity);

            FitnessCalculator.FitnessData data = new FitnessCalculator.FitnessData(
                    weight, height, waist, age, gender, activityLevel);

            FitnessCalculator.FitnessRecommendation recommendation =
                    FitnessCalculator.calculateRecommendation(data);

            // Launch ResultsActivity with the calculated data
            Intent intent = new Intent(this, ResultsActivity.class);
            intent.putExtra("weight", weight);
            intent.putExtra("height", height);
            intent.putExtra("waist", waist);
            intent.putExtra("bmr", recommendation.getBmr());
            intent.putExtra("tdee", recommendation.getTdee());
            startActivity(intent);
            overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);

        } catch (NumberFormatException e) {
            showError("Please enter valid numbers");
        } catch (IllegalArgumentException e) {
            showError(e.getMessage());
        }
    }

    private void displayResults(FitnessCalculator.FitnessRecommendation recommendation) {
        resultTitle.setVisibility(View.VISIBLE);
        goalText.setText(String.format("Recommended Goal: %s", recommendation.getGoal()));
        bmrText.setText(String.format("BMR: %.2f calories/day", recommendation.getBmr()));
        tdeeText.setText(String.format("TDEE: %.2f calories/day", recommendation.getTdee()));
        whtrText.setText(String.format("Waist-to-Height Ratio: %.2f", recommendation.getWhtr()));
    }

    private void showError(String message) {
        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(this);
        builder.setTitle("Error")
                .setMessage(message)
                .setPositiveButton("OK", null)
                .show();
    }
}