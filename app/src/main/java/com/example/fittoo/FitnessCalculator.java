package com.example.fittoo;

public class FitnessCalculator {
    public enum Gender {
        MALE,
        FEMALE
    }

    public enum ActivityLevel {
        SEDENTARY(1.2),
        LIGHT(1.375),
        MODERATE(1.55),
        ACTIVE(1.725),
        VERY_ACTIVE(1.9);

        private final double multiplier;

        ActivityLevel(double multiplier) {
            this.multiplier = multiplier;
        }

        public double getMultiplier() {
            return multiplier;
        }
    }

    public static class FitnessData {
        private double weight; // in kg
        private double height; // in cm
        private double waistCircumference; // in cm
        private int age;
        private Gender gender;
        private ActivityLevel activityLevel;

        public FitnessData(double weight, double height, double waistCircumference,
                          int age, Gender gender, ActivityLevel activityLevel) {
            validateInputs(weight, height, waistCircumference, age);
            this.weight = weight;
            this.height = height;
            this.waistCircumference = waistCircumference;
            this.age = age;
            this.gender = gender;
            this.activityLevel = activityLevel;
        }

        private void validateInputs(double weight, double height, double waistCircumference, int age) {
            if (weight <= 0 || height <= 0 || waistCircumference <= 0 || age <= 0) {
                throw new IllegalArgumentException("All measurements must be positive values");
            }
            if (age > 120) {
                throw new IllegalArgumentException("Age must be less than 120 years");
            }
            if (weight > 500) {
                throw new IllegalArgumentException("Weight must be less than 500 kg");
            }
            if (height > 300) {
                throw new IllegalArgumentException("Height must be less than 300 cm");
            }
            if (waistCircumference > 300) {
                throw new IllegalArgumentException("Waist circumference must be less than 300 cm");
            }
        }
    }

    public static class FitnessRecommendation {
        private final String goal;
        private final double bmr;
        private final double tdee;
        private final double whtr;

        public FitnessRecommendation(String goal, double bmr, double tdee, double whtr) {
            this.goal = goal;
            this.bmr = bmr;
            this.tdee = tdee;
            this.whtr = whtr;
        }

        public String getGoal() { return goal; }
        public double getBmr() { return bmr; }
        public double getTdee() { return tdee; }
        public double getWhtr() { return whtr; }
    }

    public static FitnessRecommendation calculateRecommendation(FitnessData data) {
        double whtr = calculateWHtR(data.waistCircumference, data.height);
        double bmr = calculateBMR(data);
        double tdee = calculateTDEE(bmr, data.activityLevel);

        String goal = determineGoal(whtr, tdee);

        return new FitnessRecommendation(goal, bmr, tdee, whtr);
    }

    private static double calculateWHtR(double waistCircumference, double height) {
        return waistCircumference / height;
    }

    private static double calculateBMR(FitnessData data) {
        // Mifflin-St Jeor Equation
        double bmr = (10 * data.weight) + (6.25 * data.height) - (5 * data.age);
        if (data.gender == Gender.MALE) {
            bmr += 5;
        } else {
            bmr -= 161;
        }
        return bmr;
    }

    private static double calculateTDEE(double bmr, ActivityLevel activityLevel) {
        return bmr * activityLevel.getMultiplier();
    }

    private static String determineGoal(double whtr, double tdee) {
        if (whtr > 0.5) {
            return "Weight Loss";
        } else if (whtr < 0.5) {
            return "Muscle Gain";
        } else {
            return "Body Recomposition";
        }
    }
}