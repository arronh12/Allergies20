package com.example.arron.allergies20.Models;

public class Penuts extends Allergies {

    public int traceGrams;

    public Penuts(String foodName, String foodType, String allergyType, String foodInfo, int foodRiskPicker, int traceGrams) {
        super(foodName, foodType, allergyType, foodInfo, foodRiskPicker);
        this.traceGrams = traceGrams;
    }

    public int getTraceGrams() {
        return traceGrams;
    }

    public void setTraceGrams(int traceGrams) {
        this.traceGrams = traceGrams;
    }
}
