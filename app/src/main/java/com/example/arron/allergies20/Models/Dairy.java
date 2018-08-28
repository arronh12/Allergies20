package com.example.arron.allergies20.Models;

public class Dairy extends Allergies{

    public int ml;

    public Dairy(String foodName, String foodType, String allergyType, String foodInfo, int foodRiskPicker, int ml) {
        super(foodName, foodType, allergyType, foodInfo, foodRiskPicker);
        this.ml = ml;
    }

    public int getMl() {
        return ml;
    }

    public void setMl(int ml) {
        this.ml = ml;
    }
}
