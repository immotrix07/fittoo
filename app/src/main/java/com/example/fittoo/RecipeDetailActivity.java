package com.example.fittoo;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class RecipeDetailActivity extends AppCompatActivity {
    public static final String EXTRA_MEAL_NAME = "meal_name";
    public static final String EXTRA_MEAL_CALORIES = "meal_calories";
    public static final String EXTRA_MEAL_INGREDIENTS = "meal_ingredients";
    public static final String EXTRA_MEAL_INSTRUCTIONS = "meal_instructions";
    public static final String EXTRA_MEAL_IMAGE_RES_ID = "meal_image_res_id";
    public static final String EXTRA_MEAL_DIET_TYPE = "meal_diet_type";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_detail);

        // Setup toolbar
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }

        // Get views
        ImageView ivMealImage = findViewById(R.id.iv_meal_detail_image);
        TextView tvMealName = findViewById(R.id.tv_meal_detail_name);
        TextView tvCalories = findViewById(R.id.tv_meal_detail_calories);
        TextView tvIngredients = findViewById(R.id.tv_meal_detail_ingredients);
        TextView tvInstructions = findViewById(R.id.tv_meal_detail_instructions);
        TextView tvDietType = findViewById(R.id.tv_meal_detail_diet_type);

        // Get data from intent
        String mealName = getIntent().getStringExtra(EXTRA_MEAL_NAME);
        int calories = getIntent().getIntExtra(EXTRA_MEAL_CALORIES, 0);
        String ingredients = getIntent().getStringExtra(EXTRA_MEAL_INGREDIENTS);
        String instructions = getIntent().getStringExtra(EXTRA_MEAL_INSTRUCTIONS);
        int imageResId = getIntent().getIntExtra(EXTRA_MEAL_IMAGE_RES_ID, 0);
        String dietType = getIntent().getStringExtra(EXTRA_MEAL_DIET_TYPE);

        // Set data to views
        if (imageResId != 0) {
            ivMealImage.setImageResource(imageResId);
        }
        
        tvMealName.setText(mealName);
        if (calories > 0) {
            tvCalories.setText(String.format("%d kcal", calories));
        }
        // Format ingredients as bullet points
        if (ingredients != null && !ingredients.isEmpty()) {
            String[] ingredientList = ingredients.split(", ");
            StringBuilder formattedIngredients = new StringBuilder();
            for (String ingredient : ingredientList) {
                formattedIngredients.append("• ").append(ingredient).append("\n");
            }
            tvIngredients.setText(formattedIngredients.toString());
        }

        // Format instructions as numbered steps
        if (instructions != null && !instructions.isEmpty()) {
            String[] instructionSteps = instructions.split("\n");
            StringBuilder formattedInstructions = new StringBuilder();
            for (int i = 0; i < instructionSteps.length; i++) {
                formattedInstructions.append(i + 1).append(". ").append(instructionSteps[i]).append("\n");
            }
            tvInstructions.setText(formattedInstructions.toString());
        }
        tvDietType.setText(dietType);
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}