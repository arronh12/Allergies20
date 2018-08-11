package com.example.arron.allergies20.Models;

public class Gluten extends Allergies {

    public int grams;
    public String problemFood;

    public Gluten(String foodName, String foodType, String allergyType, String foodInfo, int foodRiskPicker, int grams, String problemFood) {
        super(foodName, foodType, allergyType, foodInfo, foodRiskPicker);
        this.grams = grams;
        this.problemFood = problemFood;
    }

    public int getGrams() {
        return grams;
    }

    public void setGrams(int grams) {
        this.grams = grams;
    }

    public String getProblemFood() {
        return problemFood;
    }

    public void setProblemFood(String problemFood) {
        this.problemFood = problemFood;
    }
}
