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
                "Diet"
        ));
        meals.get(meals.size()-1).setIngredients(Arrays.asList("½ cup rolled oats", "1 cup almond milk", "1 tbsp honey", "½ banana", "1 tbsp chia seeds"));
        meals.get(meals.size()-1).setInstructions(Arrays.asList("Combine oats and milk", "Cook on medium heat 5 mins", "Top with banana and seeds"));

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

        // Indian High-Protein Recipes
        MealPlan sattuDrink = new MealPlan("Sattu Drink", 150,
                "Traditional protein-rich drink", R.drawable.meal_default, "High-Protein, Vegetarian");
        sattuDrink.setIngredients(Arrays.asList("2 tbsp sattu", "1 cup water", "1 lemon", "Black salt", "Cumin powder"));
        sattuDrink.setInstructions(Arrays.asList("Mix sattu with water", "Add lemon juice and spices", "Stir well and serve chilled"));
        meals.add(sattuDrink);

        MealPlan rajmaChawal = new MealPlan("Rajma Chawal", 450,
                "Kidney beans curry with rice", R.drawable.meal_default, "High-Protein, Vegetarian");
        rajmaChawal.setIngredients(Arrays.asList("1 cup kidney beans", "1 cup rice", "1 onion", "2 tomatoes", "Spices"));
        rajmaChawal.setInstructions(Arrays.asList("Soak and pressure cook beans", "Prepare curry with spices", "Serve with rice"));
        meals.add(rajmaChawal);

        MealPlan palakPaneer = new MealPlan("Palak Paneer", 350,
                "Cottage cheese in spinach gravy", R.drawable.meal_default, "High-Protein, Vegetarian, Keto");
        palakPaneer.setIngredients(Arrays.asList("200g paneer", "2 cups spinach", "Garlic", "Green chilies", "Cream"));
        palakPaneer.setInstructions(Arrays.asList("Blanch spinach", "Make spiced gravy", "Add paneer and cream"));
        meals.add(palakPaneer);

        MealPlan soyaChunks = new MealPlan("Soya Chunks Curry", 300,
                "Plant-based protein curry", R.drawable.meal_default, "High-Protein, Vegan");
        soyaChunks.setIngredients(Arrays.asList("1 cup soya chunks", "2 onions", "2 tomatoes", "Garam masala"));
        soyaChunks.setInstructions(Arrays.asList("Soak soya chunks", "Prepare curry base", "Cook until tender"));
        meals.add(soyaChunks);

        MealPlan eggCurry = new MealPlan("Egg Curry", 320,
                "Spiced egg curry", R.drawable.meal_default, "High-Protein, Keto");
        eggCurry.setIngredients(Arrays.asList("4 eggs", "2 onions", "2 tomatoes", "Garam masala"));
        eggCurry.setInstructions(Arrays.asList("Boil eggs", "Prepare curry base", "Simmer with eggs"));
        meals.add(eggCurry);

        MealPlan dahiChana = new MealPlan("Dahi Chana Chaat", 280,
                "Protein-rich chickpea yogurt snack", R.drawable.meal_default, "High-Protein, Vegetarian");
        dahiChana.setIngredients(Arrays.asList("1 cup chickpeas", "1 cup yogurt", "Chaat masala", "Mint chutney", "Onions"));
        dahiChana.setInstructions(Arrays.asList("Soak chickpeas", "Mix with yogurt", "Add spices and garnish"));
        meals.add(dahiChana);

        MealPlan moongCheela = new MealPlan("Moong Dal Cheela", 250,
                "Protein-packed lentil pancakes", R.drawable.meal_default, "High-Protein, Vegan");
        moongCheela.setIngredients(Arrays.asList("1 cup moong dal", "Onions", "Green chilies", "Spices"));
        moongCheela.setInstructions(Arrays.asList("Soak and grind dal", "Make thin pancakes", "Cook until golden"));
        meals.add(moongCheela);

        MealPlan bhunaChana = new MealPlan("Bhuna Chana & Jaggery", 200,
                "Roasted chickpeas with jaggery", R.drawable.meal_default, "High-Protein, Vegan");
        bhunaChana.setIngredients(Arrays.asList("1 cup roasted chickpeas", "2 tbsp jaggery", "Black salt"));
        bhunaChana.setInstructions(Arrays.asList("Roast chickpeas", "Crush jaggery", "Mix and serve"));
        meals.add(bhunaChana);

        MealPlan chanaMasala = new MealPlan("Chana Masala", 320,
                "Spiced chickpea curry", R.drawable.meal_default, "High-Protein, Vegan");
        chanaMasala.setIngredients(Arrays.asList("2 cups chickpeas", "Onions", "Tomatoes", "Garam masala"));
        chanaMasala.setInstructions(Arrays.asList("Pressure cook chickpeas", "Prepare masala", "Simmer together"));
        meals.add(chanaMasala);

        MealPlan matarPaneer = new MealPlan("Matar Paneer", 350,
                "Cottage cheese and peas curry", R.drawable.meal_default, "High-Protein, Vegetarian");
        matarPaneer.setIngredients(Arrays.asList("200g paneer", "1 cup peas", "Onion-tomato gravy", "Spices"));
        matarPaneer.setInstructions(Arrays.asList("Prepare gravy", "Add peas and paneer", "Cook until done"));
        meals.add(matarPaneer);

        MealPlan ragiRoti = new MealPlan("Ragi Roti", 180,
                "Finger millet flatbread", R.drawable.meal_default, "High-Protein, Vegan");
        ragiRoti.setIngredients(Arrays.asList("1 cup ragi flour", "Onions", "Spices", "Water"));
        ragiRoti.setInstructions(Arrays.asList("Knead dough", "Roll thin", "Cook on griddle"));
        meals.add(ragiRoti);

        MealPlan dahiPakhala = new MealPlan("Dahi Pakhala", 220,
                "Fermented rice with yogurt", R.drawable.meal_default, "High-Protein, Vegetarian");
        dahiPakhala.setIngredients(Arrays.asList("2 cups rice", "1 cup yogurt", "Curry leaves", "Green chilies"));
        dahiPakhala.setInstructions(Arrays.asList("Soak cooked rice", "Add yogurt", "Season and ferment"));
        meals.add(dahiPakhala);

        // Add new Indian Keto and High-Protein recipes
        MealPlan tandooriChicken = new MealPlan("Tandoori Chicken", 450,
                "Spiced and roasted chicken thighs", R.drawable.meal_default, "Keto, High-Protein");
        tandooriChicken.setIngredients(Arrays.asList("2 chicken thighs", "½ cup yogurt", "1 tbsp lemon juice", "1 tsp turmeric",
                "1 tsp garam masala", "1 tsp cumin powder", "1 tsp red chili powder", "1 tbsp ginger-garlic paste", "1 tbsp butter"));
        tandooriChicken.setInstructions(Arrays.asList("Marinate chicken with yogurt, spices, and lemon juice for 2 hours",
                "Preheat oven to 200°C and bake for 25-30 minutes", "Brush with butter and serve hot"));
        meals.add(tandooriChicken);

        MealPlan butterChicken = new MealPlan("Butter Chicken (Low-Carb Version)", 400,
                "Creamy and rich chicken curry", R.drawable.meal_default, "Keto, High-Protein");
        butterChicken.setIngredients(Arrays.asList("200g chicken breast", "2 tbsp butter", "½ cup heavy cream",
                "1 tomato (pureed)", "1 tsp garam masala", "1 tsp turmeric", "1 tsp cumin", "½ tsp salt"));
        butterChicken.setInstructions(Arrays.asList("Sauté chicken in butter until golden",
                "Add tomato puree and spices, cook for 5 minutes", "Stir in cream, simmer for 10 minutes, and serve"));
        meals.add(butterChicken);

        MealPlan paneerBhurji = new MealPlan("Paneer Bhurji", 350,
                "Spiced scrambled cottage cheese", R.drawable.meal_default, "Keto, Vegetarian, High-Protein");
        paneerBhurji.setIngredients(Arrays.asList("200g paneer (crumbled)", "1 tbsp ghee", "1 green chili (chopped)",
                "½ onion (chopped)", "½ tomato (chopped)", "½ tsp turmeric", "½ tsp garam masala"));
        paneerBhurji.setInstructions(Arrays.asList("Heat ghee in a pan, sauté onions and chilies",
                "Add tomatoes, turmeric, and garam masala, cook until soft", "Mix in crumbled paneer, stir well, and serve hot"));
        meals.add(paneerBhurji);

        MealPlan bainganBharta = new MealPlan("Baingan Bharta", 250,
                "Smoky roasted eggplant curry", R.drawable.meal_default, "Keto, Vegan");
        bainganBharta.setIngredients(Arrays.asList("1 large eggplant", "1 tbsp mustard oil", "1 onion (chopped)",
                "2 cloves garlic (minced)", "1 tomato (chopped)", "1 tsp cumin seeds", "½ tsp turmeric", "½ tsp garam masala"));
        bainganBharta.setInstructions(Arrays.asList("Roast eggplant on an open flame, peel, and mash",
                "Heat oil, sauté cumin seeds, onions, and garlic", "Add tomatoes, turmeric, and garam masala, cook until soft",
                "Stir in mashed eggplant, cook for 5 minutes, and serve"));
        meals.add(bainganBharta);

        MealPlan methiThepla = new MealPlan("Methi Thepla (Almond Flour Version)", 200,
                "Keto-friendly fenugreek flatbread", R.drawable.meal_default, "Keto, Vegetarian");
        methiThepla.setIngredients(Arrays.asList("1 cup almond flour", "½ cup chopped methi (fenugreek leaves)",
                "1 tbsp yogurt", "½ tsp turmeric", "½ tsp cumin powder", "1 tbsp ghee"));
        methiThepla.setInstructions(Arrays.asList("Mix all ingredients into a dough", "Roll out into thin flatbreads",
                "Cook on a griddle with ghee until golden"));
        meals.add(methiThepla);

        MealPlan gheeRoastedChicken = new MealPlan("Ghee Roasted Chicken", 400,
                "Spiced chicken cooked in ghee", R.drawable.meal_default, "Keto, High-Protein");
        gheeRoastedChicken.setIngredients(Arrays.asList("2 chicken drumsticks", "2 tbsp ghee", "1 tsp turmeric",
                "1 tsp garam masala", "1 tsp red chili powder", "1 tsp salt"));
        gheeRoastedChicken.setInstructions(Arrays.asList("Heat ghee in a pan, add chicken and spices",
                "Cook covered for 20 minutes, flipping occasionally", "Serve hot"));
        meals.add(gheeRoastedChicken);

        MealPlan cauliflowerRicePulao = new MealPlan("Cauliflower Rice Pulao", 180,
                "Low-carb version of traditional pulao", R.drawable.meal_default, "Keto, Vegan");
        cauliflowerRicePulao.setIngredients(Arrays.asList("1 cup cauliflower rice", "½ cup mixed vegetables",
                "1 tbsp ghee", "½ tsp cumin seeds", "½ tsp turmeric", "½ tsp garam masala"));
        cauliflowerRicePulao.setInstructions(Arrays.asList("Heat ghee, sauté cumin seeds and vegetables",
                "Add cauliflower rice and spices, cook for 5 minutes", "Serve warm"));
        meals.add(cauliflowerRicePulao);

        MealPlan stuffedMushrooms = new MealPlan("Spinach & Cheese Stuffed Mushrooms", 250,
                "Cheesy stuffed mushroom caps", R.drawable.meal_default, "Keto, Vegetarian");
        stuffedMushrooms.setIngredients(Arrays.asList("6 large mushrooms", "½ cup spinach (chopped)",
                "½ cup mozzarella cheese", "1 tbsp olive oil", "½ tsp black pepper"));
        stuffedMushrooms.setInstructions(Arrays.asList("Remove mushroom stems and brush caps with oil",
                "Mix spinach, cheese, and black pepper, stuff into mushrooms", "Bake at 180°C for 15 minutes"));
        meals.add(stuffedMushrooms);

        MealPlan ketoDalMakhani = new MealPlan("Keto Dal Makhani", 300,
                "Low-carb version of creamy black lentils", R.drawable.meal_default, "Keto, Vegetarian");
        ketoDalMakhani.setIngredients(Arrays.asList("½ cup black gram (urad dal, soaked overnight)", "¼ cup heavy cream",
                "2 tbsp butter", "1 tsp cumin", "1 tsp garam masala", "½ tsp turmeric"));
        ketoDalMakhani.setInstructions(Arrays.asList("Cook soaked dal until soft", "Heat butter, sauté spices, and mix in dal",
                "Stir in cream, simmer for 10 minutes, and serve"));
        meals.add(ketoDalMakhani);

        MealPlan ketoDosa = new MealPlan("Keto Dosa (Almond Flour Version)", 200,
                "Low-carb version of traditional dosa", R.drawable.meal_default, "Keto, Vegetarian");
        ketoDosa.setIngredients(Arrays.asList("½ cup almond flour", "1 tbsp coconut flour", "½ tsp salt", "½ cup water"));
        ketoDosa.setInstructions(Arrays.asList("Mix all ingredients into a batter", "Spread thin on a hot pan",
                "Cook until golden brown, then flip and serve"));
        meals.add(ketoDosa);

        // Add new Indian Vegan and High-Protein recipes
        MealPlan alooGobi = new MealPlan("Aloo Gobi", 250,
                "Spiced potato and cauliflower curry", R.drawable.meal_default, "Vegan, Gluten-Free");
        alooGobi.setIngredients(Arrays.asList("2 potatoes (cubed)", "1 small cauliflower (florets)", "1 onion (chopped)",
                "2 tomatoes (pureed)", "1 tsp turmeric", "1 tsp cumin seeds", "1 tsp coriander powder", "Salt to taste", "2 tbsp oil"));
        alooGobi.setInstructions(Arrays.asList("Heat oil in a pan, add cumin seeds",
                "Add onions and sauté until golden", "Stir in tomatoes, turmeric, and coriander powder",
                "Add potatoes and cauliflower, mix well", "Cover and cook until tender"));
        meals.add(alooGobi);

        MealPlan bhindiMasala = new MealPlan("Bhindi Masala", 220,
                "Spiced okra curry", R.drawable.meal_default, "Vegan, Gluten-Free");
        bhindiMasala.setIngredients(Arrays.asList("200g okra (chopped)", "1 onion (sliced)", "1 tomato (chopped)",
                "1 tsp cumin seeds", "1 tsp garam masala", "½ tsp turmeric", "2 tbsp oil"));
        bhindiMasala.setInstructions(Arrays.asList("Heat oil in a pan, add cumin seeds",
                "Add onions, sauté until golden", "Add tomatoes, turmeric, and garam masala",
                "Stir in okra, cook on low heat until soft"));
        meals.add(bhindiMasala);

        MealPlan tindaMasala = new MealPlan("Tinda Masala", 200,
                "Round gourd curry", R.drawable.meal_default, "Vegan, Gluten-Free");
        tindaMasala.setIngredients(Arrays.asList("250g round gourd (tinda) peeled and chopped", "1 onion (chopped)",
                "1 tomato (chopped)", "1 tsp turmeric", "1 tsp garam masala", "2 tbsp oil"));
        tindaMasala.setInstructions(Arrays.asList("Heat oil in a pan, add onions",
                "Stir in tomatoes, turmeric, and garam masala", "Add tinda pieces, mix well",
                "Cover and cook until soft"));
        meals.add(tindaMasala);

        MealPlan laukiChanaDal = new MealPlan("Lauki Chana Dal", 280,
                "Bottle gourd with split chickpeas", R.drawable.meal_default, "Vegan, High-Protein");
        laukiChanaDal.setIngredients(Arrays.asList("1 cup bottle gourd (chopped)", "½ cup chana dal (split chickpeas, soaked)",
                "1 onion (chopped)", "1 tomato (chopped)", "1 tsp turmeric", "1 tsp cumin seeds", "2 tbsp oil"));
        laukiChanaDal.setInstructions(Arrays.asList("Heat oil, add cumin seeds",
                "Add onions, sauté until golden", "Stir in tomatoes, turmeric, and soaked chana dal",
                "Add lauki, pressure cook for 3 whistles"));
        meals.add(laukiChanaDal);

        MealPlan sarsonKaSaag = new MealPlan("Sarson Ka Saag", 230,
                "Mustard greens curry", R.drawable.meal_default, "Vegan, Gluten-Free");
        sarsonKaSaag.setIngredients(Arrays.asList("2 cups mustard greens", "1 cup spinach", "1 onion (chopped)",
                "2 cloves garlic (minced)", "1 green chili (chopped)", "1 tsp garam masala", "2 tbsp oil"));
        sarsonKaSaag.setInstructions(Arrays.asList("Boil mustard greens and spinach",
                "Blend into a paste", "Heat oil, sauté onions and garlic",
                "Stir in blended greens, season with garam masala"));
        meals.add(sarsonKaSaag);

        MealPlan kalaChana = new MealPlan("Kala Chana Curry", 300,
                "Black chickpeas curry", R.drawable.meal_default, "Vegan, High-Protein");
        kalaChana.setIngredients(Arrays.asList("1 cup black chickpeas (soaked overnight)", "1 onion (chopped)",
                "2 tomatoes (chopped)", "1 tsp cumin seeds", "1 tsp garam masala", "2 tbsp oil"));
        kalaChana.setInstructions(Arrays.asList("Heat oil, add cumin seeds",
                "Sauté onions, add tomatoes and spices", "Stir in soaked chickpeas, pressure cook for 5 whistles"));
        meals.add(kalaChana);

        MealPlan vegetablePulao = new MealPlan("Vegetable Pulao", 320,
                "Spiced rice with mixed vegetables", R.drawable.meal_default, "Vegan, Gluten-Free");
        vegetablePulao.setIngredients(Arrays.asList("1 cup basmati rice", "1 carrot (chopped)", "½ cup peas",
                "1 onion (sliced)", "1 bay leaf", "1 cinnamon stick", "2 tbsp oil"));
        vegetablePulao.setInstructions(Arrays.asList("Heat oil, sauté onions with spices",
                "Add chopped vegetables and rice", "Pour in 2 cups water, cook until rice is done"));
        meals.add(vegetablePulao);

        MealPlan tofuBhurji = new MealPlan("Tofu Bhurji", 250,
                "Spiced scrambled tofu", R.drawable.meal_default, "Vegan, High-Protein");
        tofuBhurji.setIngredients(Arrays.asList("200g tofu (crumbled)", "1 onion (chopped)", "1 tomato (chopped)",
                "1 green chili (chopped)", "1 tsp garam masala", "2 tbsp oil"));
        tofuBhurji.setInstructions(Arrays.asList("Heat oil, sauté onions",
                "Stir in tomatoes, chili, and garam masala", "Add crumbled tofu, mix well"));
        meals.add(tofuBhurji);

        MealPlan masoorDal = new MealPlan("Masoor Dal", 270,
                "Red lentils curry", R.drawable.meal_default, "Vegan, High-Protein");
        masoorDal.setIngredients(Arrays.asList("1 cup red lentils (masoor dal)", "1 onion (chopped)", "2 tomatoes (chopped)",
                "2 cloves garlic (minced)", "1 tsp cumin seeds", "1 tsp turmeric", "2 tbsp oil"));
        masoorDal.setInstructions(Arrays.asList("Heat oil, add cumin seeds",
                "Sauté onions, garlic, and tomatoes", "Stir in lentils and turmeric, add water",
                "Simmer until dal is soft"));
        meals.add(masoorDal);

        return meals;
    }
}