package com.example.data;

import java.util.ArrayList;
import java.util.List;

import com.example.fittoo.models.MealPlan;
import com.example.fittoo.R;

public class MealData {

    /*
     List of Available Dishes by Diet Type:
 1. Paneer_Bhurji
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

        // Add all meal plans with their corresponding images
        mealPlans.add(new MealPlan("Paneer Bhurji", 300, "Spiced scrambled cottage cheese", R.drawable.paneer_bhurji, "Vegetarian"));
        mealPlans.add(new MealPlan("Baingan Bharta", 250, "Roasted eggplant curry", R.drawable.baingan_bharta, "Vegetarian"));
        mealPlans.add(new MealPlan("Tandoori Chicken", 350, "Clay oven roasted chicken", R.drawable.tandoori_chicken, "Non-Vegetarian"));
        mealPlans.add(new MealPlan("Butter Chicken (Low Carb)", 400, "Keto-friendly butter chicken", R.drawable.butter_chicken_low_carb_version, "Keto"));
        mealPlans.add(new MealPlan("Methi Thepla (Almond Flour)", 200, "Keto-friendly flatbread", R.drawable.methi_thepla_almond_flour_version, "Keto"));
        mealPlans.add(new MealPlan("Ghee Roasted Chicken", 450, "Clarified butter roasted chicken", R.drawable.ghee_roasted_chicken, "Keto"));
        mealPlans.add(new MealPlan("Cauliflower Rice Pulao", 200, "Low-carb vegetable rice", R.drawable.cauliflower_rice_pulao, "Keto"));
        mealPlans.add(new MealPlan("Stuffed Mushrooms", 250, "Cheese and spinach stuffed mushrooms", R.drawable.spinach_cheese_stuffed_mushrooms, "Keto"));
        mealPlans.add(new MealPlan("Keto Dal Makhani", 300, "Low-carb creamy lentils", R.drawable.keto_dal_makhani, "Keto"));
        mealPlans.add(new MealPlan("Keto Dosa", 250, "Almond flour dosa", R.drawable.keto_dosa_almond_flour_version, "Keto"));
        mealPlans.add(new MealPlan("Scrambled Eggs & Avocado", 350, "High-fat breakfast", R.drawable.scrambled_eggs_avocado, "Keto"));
        mealPlans.add(new MealPlan("Zucchini Noodles", 150, "Low-carb pasta alternative", R.drawable.zucchini_noodles, "Keto"));
        mealPlans.add(new MealPlan("Egg Curry", 300, "Protein-rich curry", R.drawable.egg_curry, "Non-Vegetarian"));
        mealPlans.add(new MealPlan("Palak Paneer", 350, "Spinach with cottage cheese", R.drawable.palak_paneer, "Vegetarian"));
        mealPlans.add(new MealPlan("Grilled Chicken Salad", 300, "Healthy protein-rich salad", R.drawable.grilled_chicken_salad, "High-Protein"));
        mealPlans.add(new MealPlan("Oatmeal Bowl", 250, "Healthy breakfast bowl", R.drawable.oatmeal_bowl, "Balanced"));
        mealPlans.add(new MealPlan("Quinoa Chickpea Salad", 300, "Protein-rich vegan salad", R.drawable.quinoa_chickpea_salad, "Vegan"));
        mealPlans.add(new MealPlan("Chia Seed Pudding", 200, "Healthy dessert option", R.drawable.chia_seed_pudding, "Vegan"));
        mealPlans.add(new MealPlan("Sattu Drink", 150, "Traditional protein drink", R.drawable.sattu_drink, "Vegetarian"));
        mealPlans.add(new MealPlan("Rajma Chawal", 400, "Kidney beans with rice", R.drawable.rajma_chawal, "Vegetarian"));
        mealPlans.add(new MealPlan("Soya Chunks Curry", 250, "High-protein vegetarian curry", R.drawable.soya_chunks_curry, "Vegetarian"));
        mealPlans.add(new MealPlan("Dahi Chana Chaat", 200, "Yogurt chickpea salad", R.drawable.dahi_chana_chaat, "Vegetarian"));
        mealPlans.add(new MealPlan("Moong Dal Cheela", 250, "Lentil pancakes", R.drawable.moong_dal_cheela, "Vegetarian"));
        mealPlans.add(new MealPlan("Bhuna Chana Jaggery", 200, "Roasted chickpeas with jaggery", R.drawable.bhuna_chana_jaggery, "Vegetarian"));
        mealPlans.add(new MealPlan("Chana Masala", 300, "Spiced chickpea curry", R.drawable.chana_masala, "Vegetarian"));
        mealPlans.add(new MealPlan("Matar Paneer", 350, "Peas and cottage cheese curry", R.drawable.matar_paneer, "Vegetarian"));
        mealPlans.add(new MealPlan("Ragi Roti", 200, "Finger millet flatbread", R.drawable.ragi_roti, "Vegetarian"));
        mealPlans.add(new MealPlan("Dahi Pakhala", 250, "Fermented rice with yogurt", R.drawable.dahi_pakhala, "Vegetarian"));
        mealPlans.add(new MealPlan("Roasted Sweet Potatoes", 200, "Healthy carb option", R.drawable.roasted_sweet_potatoes, "Vegetarian"));
        mealPlans.add(new MealPlan("Aloo Gobi", 250, "Potato and cauliflower curry", R.drawable.aloo_gobi, "Vegetarian"));
        mealPlans.add(new MealPlan("Bhindi Masala", 200, "Spiced okra", R.drawable.bhindi_masala, "Vegetarian"));
        mealPlans.add(new MealPlan("Tinda Masala", 200, "Spiced apple gourd", R.drawable.tinda_masala, "Vegetarian"));
        mealPlans.add(new MealPlan("Lauki Chana Dal", 250, "Bottle gourd with lentils", R.drawable.lauki_chana_dal, "Vegetarian"));
        mealPlans.add(new MealPlan("Sarson Ka Saag", 300, "Mustard greens curry", R.drawable.sarson_ka_saag, "Vegetarian"));
        mealPlans.add(new MealPlan("Kala Chana Curry", 300, "Black chickpea curry", R.drawable.kala_chana_curry, "Vegetarian"));
        mealPlans.add(new MealPlan("Vegetable Pulao", 350, "Mixed vegetable rice", R.drawable.vegetable_pulao, "Vegetarian"));
        mealPlans.add(new MealPlan("Tofu Bhurji", 250, "Scrambled tofu", R.drawable.tofu_bhurji, "Vegan"));
        mealPlans.add(new MealPlan("Masoor Dal", 250, "Red lentil curry", R.drawable.masoor_dal, "Vegetarian"));
        mealPlans.add(new MealPlan("Sprouted Moong Salad", 200, "Healthy sprouts salad", R.drawable.sprouted_moong_salad, "Vegan"));
        mealPlans.add(new MealPlan("Stuffed Capsicum", 250, "Bell peppers with filling", R.drawable.stuffed_capsicum, "Vegetarian"));


        return mealPlans;
    }
}