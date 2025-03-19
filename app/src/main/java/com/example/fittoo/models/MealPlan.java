package com.example.fittoo.models;

import java.util.ArrayList;
import java.util.List;

public class MealPlan {
    private String name;
    private int calories;
    private String description;
    private int imageResource;
    private List<String> tags;
    private String category;
    private String dietType;
    private List<String> ingredients;
    private List<String> instructions;

    public MealPlan(String name, int calories, String description, int imageResource, String dietType) {
        this.tags = new ArrayList<>();
        this.ingredients = new ArrayList<>();
        this.instructions = new ArrayList<>();
        this.name = name;
        this.calories = calories;
        this.description = description;
        this.imageResource = imageResource;
        this.dietType = dietType;
        this.category = dietType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getImageResource() {
        return imageResource;
    }

    public void setImageResource(int imageResource) {
        this.imageResource = imageResource;
    }

    public String getDietType() {
        return dietType;
    }

    public void setDietType(String dietType) {
        this.dietType = dietType;
    }

    public List<String> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<String> ingredients) {
        this.ingredients = ingredients;
    }

    public List<String> getInstructions() {
        return instructions;
    }

    public void setInstructions(List<String> instructions) {
        this.instructions = instructions;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}