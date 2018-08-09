package com.example.arron.allergies20.Models;

public class Allergies {

public String foodName, foodType, allergyType, foodInfo;
       int foodRiskPicker;

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public String getFoodType() {
        return foodType;
    }

    public void setFoodType(String foodType) {
        this.foodType = foodType;
    }

    public String getAllergyType() {
        return allergyType;
    }

    public void setAllergyType(String allergyType) {
        this.allergyType = allergyType;
    }

    public int getFoodRiskPicker() {
        return foodRiskPicker;
    }

    public void setFoodRiskPicker(int foodRiskPicker) {
        this.foodRiskPicker = foodRiskPicker;
    }

    public String getFoodInfo() {
        return foodInfo;

    }

    public void setFoodInfo(String foodInfo) {
        this.foodInfo = foodInfo;
    }

    @Override
    public String toString() {
        return "Allergies{" +
                "foodName='" + foodName + '\'' +
                ", foodType='" + foodType + '\'' +
                ", allergyType='" + allergyType + '\'' +
                ", foodInfo='" + foodInfo + '\'' +
                ", foodRiskPicker=" + foodRiskPicker +
                '}';
    }

    public Allergies(String foodName, String foodType, String allergyType, String foodInfo, int foodRiskPicker) {
        this.foodName = foodName;
        this.foodType = foodType;
        this.allergyType = allergyType;
        this.foodInfo = foodInfo;
        this.foodRiskPicker = foodRiskPicker;
    }
}
