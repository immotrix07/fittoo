package com.example.fittoo.ui.diet;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.fittoo.R;
import com.example.fittoo.adapters.DietCategoryAdapter;
import com.example.fittoo.adapters.MealPlanAdapter;
import com.example.fittoo.models.DietCategory;
import com.example.fittoo.models.MealPlan;
import com.google.android.material.chip.ChipGroup;
import com.google.android.material.chip.Chip;
import java.util.ArrayList;
import java.util.List;
import com.example.fittoo.data.MealData;
import java.util.Arrays;
import androidx.appcompat.widget.SearchView;

public class DietFragment extends Fragment {
    private RecyclerView rvMeals;
    private MealPlanAdapter mealAdapter;
    private ChipGroup filterChipGroup;
    private SearchView searchView;
    
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_diet, container, false);
        
        rvMeals = view.findViewById(R.id.rv_meals);
        filterChipGroup = view.findViewById(R.id.filter_chip_group);
        searchView = view.findViewById(R.id.searchView);
        
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
        // Configure SearchView
        searchView.setIconifiedByDefault(false);
        searchView.setQueryHint("Search meals...");
        searchView.setMaxWidth(Integer.MAX_VALUE);
        searchView.setClickable(true);
        searchView.setFocusable(true);

        // Make the entire search area clickable
        View searchPlate = searchView.findViewById(androidx.appcompat.R.id.search_plate);
        if (searchPlate != null) {
            searchPlate.setBackground(null);
        }

        // Set up the search icon click behavior
        View searchIcon = searchView.findViewById(androidx.appcompat.R.id.search_button);
        if (searchIcon != null) {
            searchIcon.setOnClickListener(v -> searchView.setIconified(false));
        }

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

        // Set up SearchView collapse listener
        searchView.setOnCloseListener(() -> {
            filterMeals("");
            return false;
        });

        // Make the entire search view clickable and expand on click
        searchView.setOnSearchClickListener(v -> {
            // Additional setup when search is opened if needed
        });

        // Set up SearchView collapse listener
        searchView.setOnCloseListener(() -> {
            filterMeals("");
            return false;
        });

        // Make the entire search view clickable and expand on click
        searchView.setOnSearchClickListener(v -> {
            // Additional setup when search is opened if needed
        });
    }

    private void filterMeals(String query) {
        if (mealAdapter != null) {
            mealAdapter.filterBySearch(query);
        }
    }

    private void onCategorySelected(DietCategory category) {
        // Update meals based on category
        mealAdapter.filterByCategory(category.getName());
    }

    private void onMealClicked(MealPlan meal) {
        // Launch detail activity
    }



    
}