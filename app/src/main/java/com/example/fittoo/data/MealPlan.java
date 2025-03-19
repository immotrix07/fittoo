package com.example.fittoo.data;

import java.util.List;

public class MealPlan {
    public String name;
    public int calories;
    public String duration;
    public int imageResId;
    public String type;
    public List<String> ingredients;
    public List<String> instructions;

    public MealPlan(String name, int calories, String duration, int imageResId, String type, List<String> ingredients, List<String> instructions) {
        this.name = name;
        this.calories = calories;
        this.duration = duration;
        this.imageResId = imageResId;
        this.type = type;
        this.ingredients = ingredients;
        this.instructions = instructions;
    }
}