package com.example.fittoo;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.fittoo.adapters.MealPlanAdapter;
import com.example.fittoo.models.MealPlan;
import com.google.android.material.chip.ChipGroup;
import com.google.android.material.chip.Chip;
import java.util.ArrayList;
import java.util.List;
import com.example.fittoo.data.MealData;
import androidx.appcompat.widget.SearchView;

public class DietFragment extends Fragment {
    private RecyclerView rvMeals;
    private MealPlanAdapter mealAdapter;
    private ChipGroup filterChipGroup;
    private SearchView searchView;
    
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_diet, container, false);
        
<<<<<<< HEAD
        rvMeals = view.findViewById(R.id.rv_meals);
        filterChipGroup = view.findViewById(R.id.filter_chip_group);
        searchView = view.findViewById(R.id.searchView);
=======
        dietRecycler = view.findViewById(R.id.rv_meals);
        dietRecycler.setLayoutManager(new LinearLayoutManager(getContext()));
>>>>>>> origin/master
        
        setupMeals();
        setupFilters();
        setupSearch();
        
        return view;
    }

    private void setupMeals() {
        rvMeals.setLayoutManager(new GridLayoutManager(requireContext(), 2));
        mealAdapter = new MealPlanAdapter(MealData.getSampleMeals(), this::onMealClicked);
        rvMeals.setAdapter(mealAdapter);
    }

    private void setupFilters() {
        filterChipGroup.setOnCheckedStateChangeListener((group, checkedIds) -> {
            List<String> selectedFilters = new ArrayList<>();
            for (int id : checkedIds) {
                Chip chip = group.findViewById(id);
                selectedFilters.add(chip.getText().toString());
            }
            mealAdapter.filterMeals(selectedFilters);
        });
    }

    private void setupSearch() {
        searchView.setIconifiedByDefault(false);
        searchView.setQueryHint("Search meals...");
        searchView.setMaxWidth(Integer.MAX_VALUE);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                filterMeals(query);
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                filterMeals(newText);
                return true;
            }
        });
    }

    private void filterMeals(String query) {
        if (mealAdapter != null) {
            mealAdapter.filterBySearch(query);
        }
    }

    private void onMealClicked(MealPlan meal) {
        Intent intent = new Intent(requireContext(), RecipeDetailActivity.class);
        intent.putExtra(RecipeDetailActivity.EXTRA_MEAL_NAME, meal.getName());
        intent.putExtra(RecipeDetailActivity.EXTRA_MEAL_CALORIES, meal.getCalories());
        intent.putExtra(RecipeDetailActivity.EXTRA_MEAL_INGREDIENTS, String.join(", ", meal.getIngredients()));
        intent.putExtra(RecipeDetailActivity.EXTRA_MEAL_INSTRUCTIONS, String.join("\n", meal.getInstructions()));
        intent.putExtra(RecipeDetailActivity.EXTRA_MEAL_IMAGE_RES_ID, meal.getImageResourceId());
        intent.putExtra(RecipeDetailActivity.EXTRA_MEAL_DIET_TYPE, meal.getDietType());
        startActivity(intent);
    }
}