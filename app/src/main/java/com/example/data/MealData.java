package com.example.data;

import java.util.ArrayList;
import java.util.List;

import com.example.fittoo.models.MealPlan;
import com.example.fittoo.R;

public class MealData {

    /*
     * List of Available Dishes by Diet Type:
     * 1. Paneer_Bhurji
2. Baingan_Bharta
3. Tandoori_Chicken
4. Butter_Chicken_Low_Carb_Version
5. Methi_Thepla_Almond_Flour_Version
6. Ghee_Roasted_Chicken
7. Cauliflower_Rice_Pulao
8. Spinach_Cheese_Stuffed_Mushrooms
9. Keto_Dal_Makhani
10. Keto_Dosa_Almond_Flour_Version
11. Scrambled_Eggs_Avocado
12. Zucchini_Noodles
13. Egg_Curry
14. Palak_Paneer
15. Grilled_Chicken_Salad
16. Oatmeal_Bowl
17. Quinoa_Chickpea_Salad
18. Chia_Seed_Pudding
19. Sattu_Drink
20. Rajma_Chawal
21. Soya_Chunks_Curry
22. Dahi_Chana_Chaat
23. Moong_Dal_Cheela
24. Bhuna_Chana_Jaggery
25. Chana_Masala
26. Matar_Paneer
27. Ragi_Roti
28. Dahi_Pakhala
29. Roasted_Sweet_Potatoes
30. Aloo_Gobi
31. Bhindi_Masala
32. Tinda_Masala
33. Lauki_Chana_Dal
34. Sarson_Ka_Saag
35. Kala_Chana_Curry
36. Vegetable_Pulao
37. Tofu_Bhurji
38. Masoor_Dal
39. Sprouted_Moong_Salad
40. Stuffed_Capsicum
     
     */

    public static List<MealPlan> getMealPlans() {
        List<MealPlan> mealPlans = new ArrayList<>();

        // High-Protein Meal Plans
        mealPlans.add(new MealPlan(
            "High-Protein Meal Plan",
            2200,
            "Optimal for muscle gain and recovery",
            R.drawable.meal_grilled_chicken,
            "High-Protein"
        ));

        // Vegan Meal Plans
        mealPlans.add(new MealPlan(
            "Vegan Meal Plan",
            1800,
            "Plant-based nutrition for health",
            R.drawable.meal_quinoa_salad,
            "Vegan"
        ));

        // Keto Meal Plans
        mealPlans.add(new MealPlan(
            "Keto Meal Plan",
            2000,
            "Low-carb, high-fat for ketosis",
            R.drawable.meal_keto_salad,
            "Keto"
        ));

        // Balanced Diet Plans
        mealPlans.add(new MealPlan(
            "Balanced Diet Plan",
            2000,
            "Nutritionally balanced meals",
            R.drawable.meal_oatmeal,
            "Balanced"
        ));

        return mealPlans;
    }
}