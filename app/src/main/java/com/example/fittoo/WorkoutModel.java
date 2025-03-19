package com.example.fittoo;

public class WorkoutModel extends Workout {
    private String name;
    private String description;
    private int imageResId;
    private int sets = 3;
    private int reps = 12;

    public WorkoutModel(String name, String description, int imageResId) {
        super(name, description, String.valueOf(imageResId), 3, 12, "60 seconds", "Strength", "Intermediate");
        this.name = name;
        this.description = description;
        this.imageResId = imageResId;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getImageResId() {
        return imageResId;
    }

    public int getSets() {
        return sets;
    }

    public int getReps() {
        return reps;
    }
}