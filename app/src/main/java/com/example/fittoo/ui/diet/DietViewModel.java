package com.example.fittoo.ui.diet;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.example.fittoo.data.MealData;
import com.example.fittoo.models.MealPlan;
import java.util.List;

public class DietViewModel extends ViewModel {
    private MutableLiveData<List<MealPlan>> mealPlans = new MutableLiveData<>();

    public DietViewModel() {
        loadMealsAsync();
    }

    private void loadMealsAsync() {
        new Thread(() -> {
            List<MealPlan> meals = MealData.getSampleMeals();
            mealPlans.postValue(meals);
        }).start();
    }

    public LiveData<List<MealPlan>> getMealPlans() {
        return mealPlans;
    }
}