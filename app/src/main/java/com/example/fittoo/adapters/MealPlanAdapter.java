package com.example.fittoo.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.fittoo.R;
import com.example.fittoo.models.MealPlan;
import com.google.android.material.button.MaterialButton;
import java.util.ArrayList;
import java.util.List;

public class MealPlanAdapter extends RecyclerView.Adapter<MealPlanAdapter.ViewHolder> {
    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvMealName, tvCalories, tvIngredients, tvDietType;
        MaterialButton btnDetails;

        public ViewHolder(View view) {
            super(view);
            tvMealName = view.findViewById(R.id.tv_meal_name);
            tvCalories = view.findViewById(R.id.tv_calories);
            tvIngredients = view.findViewById(R.id.tv_ingredients);
            tvDietType = view.findViewById(R.id.tv_meal_type);
            btnDetails = view.findViewById(R.id.btn_details);
        }
    }
    public List<MealPlan> getAllMeals() {
        return allMeals;
    }

    public void updateMeals(List<MealPlan> filteredMeals) {
        this.meals = filteredMeals;
        notifyDataSetChanged();
    }

    private List<MealPlan> meals;
    private final List<MealPlan> allMeals;
    private final MealClickListener clickListener;

    public MealPlanAdapter(List<MealPlan> meals, MealClickListener clickListener) {
        this.meals = new ArrayList<>(meals);
        this.allMeals = new ArrayList<>(meals);
        this.clickListener = clickListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_meal_plan, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        MealPlan meal = meals.get(position);
        holder.tvMealName.setText(meal.getName());
        if (meal.getCalories() > 0) {
            holder.tvCalories.setText(String.format("%d kcal", meal.getCalories()));
            holder.tvCalories.setVisibility(View.VISIBLE);
        } else {
            holder.tvCalories.setVisibility(View.GONE);
        }
        
        if (meal.getIngredients() != null && !meal.getIngredients().isEmpty()) {
            holder.tvIngredients.setText("Ingredients: " + String.join(", ", meal.getIngredients()));
            holder.tvIngredients.setVisibility(View.VISIBLE);
        } else {
            holder.tvIngredients.setVisibility(View.GONE);
        }
        
        holder.tvDietType.setText(meal.getDietType());
        
        holder.btnDetails.setOnClickListener(v -> 
            clickListener.onMealClick(meal)
        );
    }

    @Override
    public int getItemCount() {
        return meals.size();
    }

    public void filterMeals(List<String> filters) {
        if (filters.isEmpty()) {
            meals = new ArrayList<>(allMeals);
        } else {
            List<MealPlan> filtered = new ArrayList<>();
            for (MealPlan meal : allMeals) {
                for (String filter : filters) {
                    if (meal.getDietType().equalsIgnoreCase(filter)) {
                        filtered.add(meal);
                        break;
                    }
                }
            }
            meals = filtered;
        }
        notifyDataSetChanged();
    }

    public void filterBySearch(String query) {
        if (query == null || query.trim().isEmpty()) {
            meals = new ArrayList<>(allMeals);
        } else {
            String lowercaseQuery = query.toLowerCase().trim();
            List<MealPlan> filtered = new ArrayList<>();
            for (MealPlan meal : allMeals) {
                if (meal.getName().toLowerCase().contains(lowercaseQuery) ||
                    meal.getDietType().toLowerCase().contains(lowercaseQuery) ||
                    (meal.getIngredients() != null && String.join(", ", meal.getIngredients()).toLowerCase().contains(lowercaseQuery))) {
                    filtered.add(meal);
                }
            }
            meals = filtered;
        }
        notifyDataSetChanged();
    }

    public void filterByCategory(String category) {
        List<MealPlan> filtered = new ArrayList<>();
        for (MealPlan meal : allMeals) {
            if (meal.getCategory().equalsIgnoreCase(category)) {
                filtered.add(meal);
            }
        }
        meals = filtered;
        notifyDataSetChanged();
    }



    public interface MealClickListener {
        void onMealClick(MealPlan meal);
    }
}