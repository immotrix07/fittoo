package com.example.fittoo.data;

import com.example.fittoo.R;
import com.example.fittoo.models.MealPlan;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MealData {
    public static void addMeal(MealPlan meal) {
        MEALS.add(meal);
    }

    private static final List<MealPlan> MEALS = new ArrayList<>();

    public static List<MealPlan> getSampleMeals() {
        return MEALS;
    }

    static {
        // Vegetarian Recipes
        MealPlan oatmeal = new MealPlan(
                "Oatmeal Bowl",
                300,
                "Healthy breakfast with whole grains and fresh fruits",
                R.drawable.oatmeal_bowl,
                "Diet"
        );
        oatmeal.setIngredients(Arrays.asList("1/2 cup rolled oats", "1 cup almond milk", "1 tbsp honey", "1/2 banana", "1 tbsp chia seeds"));
        oatmeal.setInstructions(Arrays.asList("Combine oats and milk", "Cook on medium heat 5 mins", "Top with banana and seeds"));
        MEALS.add(oatmeal);

        MEALS.add(createQuinoaSalad());

        // Vegan Recipes
        MealPlan chiaPudding = new MealPlan("Chia Seed Pudding", 220, 
                "Creamy vegan pudding with fresh berries", R.drawable.chia_seed_pudding, "Vegan");
        chiaPudding.setIngredients(Arrays.asList("2 tbsp chia seeds", "1 cup almond milk", "1 tbsp maple syrup", "1/2 cup berries"));
        chiaPudding.setInstructions(Arrays.asList("Mix chia with milk", "Let sit 2 hours", "Add syrup & berries"));
        MEALS.add(chiaPudding);

        MealPlan sweetPotatoMeal = new MealPlan("Roasted Sweet Potatoes", 250, 
                "Hearty vegan meal with black beans", R.drawable.roasted_sweet_potatoes, "Vegan");
        sweetPotatoMeal.setIngredients(Arrays.asList("1 sweet potato", "1/2 cup black beans", "1 tbsp olive oil", "1/2 tsp paprika"));
        sweetPotatoMeal.setInstructions(Arrays.asList("Toss potatoes with oil", "Roast at 200°C", "Mix with beans"));
        MEALS.add(sweetPotatoMeal);

        // Keto Recipes
        MealPlan scrambledEggs = new MealPlan("Scrambled Eggs & Avocado", 350, 
                "High-fat keto breakfast", R.drawable.eggs_avocado, "Keto");
        scrambledEggs.setIngredients(Arrays.asList("2 eggs", "1 tbsp butter", "1/2 avocado", "Salt & pepper"));
        scrambledEggs.setInstructions(Arrays.asList("Heat butter in pan", "Scramble eggs", "Serve with avocado"));
        MEALS.add(scrambledEggs);

        MealPlan zucchiniNoodles = new MealPlan("Zucchini Noodles", 180, 
                "Low-carb pesto pasta alternative", R.drawable.zucchini_noodles, "Keto");
        zucchiniNoodles.setIngredients(Arrays.asList("1 zucchini", "2 tbsp pesto", "1 tbsp olive oil"));
        zucchiniNoodles.setInstructions(Arrays.asList("Spiralize zucchini", "Sauté 3 minutes", "Add pesto"));
        MEALS.add(zucchiniNoodles);

        // High-Protein Recipes
        MealPlan chickenSalad = new MealPlan("Grilled Chicken Salad", 400, 
                "Lean protein with fresh greens", R.drawable.grilled_chicken_salad, "High-Protein");
        chickenSalad.setIngredients(Arrays.asList("1 chicken breast", "1 cup spinach", "1/2 avocado", "1 tbsp olive oil"));
        chickenSalad.setInstructions(Arrays.asList("Grill chicken", "Toss salad", "Combine & serve"));
        MEALS.add(chickenSalad);

        MealPlan bakedSalmon = new MealPlan("Baked Salmon", 380, 
                "Omega-3 rich meal with veggies", R.drawable.salmon, "High-Protein");
        bakedSalmon.setIngredients(Arrays.asList("1 salmon fillet", "1/2 cup broccoli", "1/2 zucchini", "1 tbsp olive oil"));
        bakedSalmon.setInstructions(Arrays.asList("Season salmon", "Bake 15 mins", "Serve with veggies"));
        MEALS.add(bakedSalmon);

        // Indian High-Protein Recipes
        MealPlan sattuDrink = new MealPlan("Sattu Drink", 150,
                "Traditional protein-rich drink", R.drawable.sattu_drink, "High-Protein, Vegetarian");
        sattuDrink.setIngredients(Arrays.asList("2 tbsp sattu", "1 cup water", "1 lemon", "Black salt", "Cumin powder"));
        sattuDrink.setInstructions(Arrays.asList("Mix sattu with water", "Add lemon juice and spices", "Stir well and serve chilled"));
        MEALS.add(sattuDrink);

        MealPlan rajmaChawal = new MealPlan("Rajma Chawal", 450,
                "Kidney beans curry with rice", R.drawable.rajma_chawal, "High-Protein, Vegetarian");
        rajmaChawal.setIngredients(Arrays.asList("1 cup kidney beans", "1 cup rice", "1 onion", "2 tomatoes", "Spices"));
        rajmaChawal.setInstructions(Arrays.asList("Soak and pressure cook beans", "Prepare curry with spices", "Serve with rice"));
        MEALS.add(rajmaChawal);

        MealPlan palakPaneer = new MealPlan("Palak Paneer", 350,
                "Cottage cheese in spinach gravy", R.drawable.palak_paneer, "High-Protein, Vegetarian, Keto");
        palakPaneer.setIngredients(Arrays.asList("200g paneer", "2 cups spinach", "Garlic", "Green chilies", "Cream"));
        palakPaneer.setInstructions(Arrays.asList("Blanch spinach", "Make spiced gravy", "Add paneer and cream"));
        MEALS.add(palakPaneer);
    }

    private static MealPlan createQuinoaSalad() {
        MealPlan quinoaSalad = new MealPlan(
            "Quinoa Salad",
            280,
            "Protein-packed vegetarian salad",
            R.drawable.quinoa_salad,
            "Vegetarian"
        );
        quinoaSalad.setIngredients(Arrays.asList("1 cup quinoa", "1/2 cucumber", "1 tomato", "1 tbsp olive oil"));
        quinoaSalad.setInstructions(Arrays.asList("Cook quinoa", "Chop vegetables", "Mix all ingredients"));
        return quinoaSalad;
    }
}