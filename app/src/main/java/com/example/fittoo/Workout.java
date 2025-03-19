package com.example.fittoo;

public class Workout {
    private String name;
    private String description;
    private String imageUrl;
    private int sets;
    private int reps;
    private String restTime;
    private String category; // HIIT or Steady State
    private String difficultyLevel; // Beginner or Advanced

    public Workout(String name, String description, String imageUrl, int sets, int reps, String restTime, String category, String difficultyLevel) {
        this.name = name;
        this.description = description;
        this.imageUrl = imageUrl;
        this.sets = sets;
        this.reps = reps;
        this.restTime = restTime;
        this.category = category;
        this.difficultyLevel = difficultyLevel;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public int getSets() {
        return sets;
    }

    public int getReps() {
        return reps;
    }

    public String getRestTime() {
        return restTime;
    }

    public String getImageResource() {
        return imageUrl;
    }

    public String getCategory() {
        return category;
    }

    public String getDifficultyLevel() {
        return difficultyLevel;
    }
}