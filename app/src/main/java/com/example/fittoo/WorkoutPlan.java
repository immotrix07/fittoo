package com.example.fittoo;

public class WorkoutPlan {
    private String name;
    private String description;
    private String category;
    private String difficulty;
    private String gender;
    private int animationResourceId;
    private int sets;
    private int reps;
    private int restTime;
    private String equipment;
    private boolean completed;

    public WorkoutPlan(String name, String description, String category, String difficulty,
                      String gender, int animationResourceId, int sets, int reps,
                      int restTime, String equipment) {
        this.name = name;
        this.description = description;
        this.category = category;
        this.difficulty = difficulty;
        this.gender = gender;
        this.animationResourceId = animationResourceId;
        this.sets = sets;
        this.reps = reps;
        this.restTime = restTime;
        this.equipment = equipment;
        this.completed = false;
    }

    public String getName() { return name; }
    public String getDescription() { return description; }
    public String getCategory() { return category; }
    public String getDifficulty() { return difficulty; }
    public String getGender() { return gender; }
    public int getAnimationResourceId() { return animationResourceId; }
    public int getSets() { return sets; }
    public int getReps() { return reps; }
    public int getRestTime() { return restTime; }
    public String getEquipment() { return equipment; }
    public boolean isCompleted() { return completed; }
    
    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
}