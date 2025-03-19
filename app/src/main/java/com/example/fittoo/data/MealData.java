package com.example.fittoo.data;

import com.example.fittoo.R;
import com.example.fittoo.models.MealPlan;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MealData {
    public static List<MealPlan> getSampleMeals() {
        List<MealPlan> meals = new ArrayList<>();
        
        // Vegetarian Recipes
        meals.add(new MealPlan(
                "Oatmeal Bowl",
                300,
                "Healthy breakfast with whole grains and fresh fruits",
                R.drawable.oatmeal,
                "Vegetarian"
        ));

                MealPlan quinoaSalad = new MealPlan(
                "Quinoa & Chickpea Salad",
                280,
                "Protein-packed salad with fresh veggies",
                R.drawable.quinoa_salad,
                "Vegetarian"
        );
        quinoaSalad.setIngredients(Arrays.asList("1 cup quinoa", "½ cup chickpeas", "½ cucumber", "½ tomato", "1 tbsp olive oil"));
        quinoaSalad.setInstructions(Arrays.asList("Mix all ingredients", "Drizzle oil & lemon", "Toss and serve!"));
        meals.add(quinoaSalad);

        // Vegan Recipes
                MealPlan chiaPudding = new MealPlan("Chia Seed Pudding", 220, 
                "Creamy vegan pudding with fresh berries", R.drawable.chia_pudding, "Vegan");
        chiaPudding.setIngredients(Arrays.asList("2 tbsp chia seeds", "1 cup almond milk", "1 tbsp maple syrup", "½ cup berries"));
        chiaPudding.setInstructions(Arrays.asList("Mix chia with milk", "Let sit 2 hours", "Add syrup & berries"));
        meals.add(chiaPudding);

                MealPlan sweetPotatoMeal = new MealPlan("Roasted Sweet Potatoes", 250, 
                "Hearty vegan meal with black beans", R.drawable.sweet_potato, "Vegan");
        sweetPotatoMeal.setIngredients(Arrays.asList("1 sweet potato", "½ cup black beans", "1 tbsp olive oil", "½ tsp paprika"));
        sweetPotatoMeal.setInstructions(Arrays.asList("Toss potatoes with oil", "Roast at 200°C", "Mix with beans"));
        meals.add(sweetPotatoMeal);

        // Keto Recipes
        MealPlan scrambledEggs = new MealPlan("Scrambled Eggs & Avocado", 350, 
                "High-fat keto breakfast", R.drawable.eggs_avocado, "Keto");
        scrambledEggs.setIngredients(Arrays.asList("2 eggs", "1 tbsp butter", "½ avocado", "Salt & pepper"));
        scrambledEggs.setInstructions(Arrays.asList("Heat butter in pan", "Scramble eggs", "Serve with avocado"));
        meals.add(scrambledEggs);

        MealPlan zucchiniNoodles = new MealPlan("Zucchini Noodles", 180, 
                "Low-carb pesto pasta alternative", R.drawable.zucchini_noodles, "Keto");
        zucchiniNoodles.setIngredients(Arrays.asList("1 zucchini", "2 tbsp pesto", "1 tbsp olive oil"));
        zucchiniNoodles.setInstructions(Arrays.asList("Spiralize zucchini", "Sauté 3 minutes", "Add pesto"));
        meals.add(zucchiniNoodles);

        // High-Protein Recipes
        MealPlan chickenSalad = new MealPlan("Grilled Chicken Salad", 400, 
                "Lean protein with fresh greens", R.drawable.meal_grilled_chicken, "High-Protein");
        chickenSalad.setIngredients(Arrays.asList("1 chicken breast", "1 cup spinach", "½ avocado", "1 tbsp olive oil"));
        chickenSalad.setInstructions(Arrays.asList("Grill chicken", "Toss salad", "Combine & serve"));
        meals.add(chickenSalad);

        MealPlan bakedSalmon = new MealPlan("Baked Salmon", 380, 
                "Omega-3 rich meal with veggies", R.drawable.salmon, "High-Protein");
        bakedSalmon.setIngredients(Arrays.asList("1 salmon fillet", "½ cup broccoli", "½ zucchini", "1 tbsp olive oil"));
        bakedSalmon.setInstructions(Arrays.asList("Season salmon", "Bake 15 mins", "Serve with veggies"));
        meals.add(bakedSalmon);

        return meals;
    }
}