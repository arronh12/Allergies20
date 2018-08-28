package com.example.arron.allergies20.Models;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.ColorInt;
import android.support.annotation.NonNull;

@Entity(tableName = "food_table")
public class Allergies {

    @PrimaryKey
    private int fid;

    @ColumnInfo(name = "food_name")
    private String foodName;

    @ColumnInfo(name = "food_type")
    private String foodType;

    @ColumnInfo(name = "allergy_type")
    private String allergyType;

    @ColumnInfo(name = "food_info")
    private String foodInfo;

    @ColumnInfo(name = "food_risk")
    private int foodRiskPicker;

    public Allergies(String foodName, String foodType, String allergyType, String foodInfo, int foodRiskPicker) {
        this.foodName = foodName;
        this.foodType = foodType;
        this.allergyType = allergyType;
        this.foodInfo = foodInfo;
        this.foodRiskPicker = foodRiskPicker;
    }

    @Override
    public String toString() {
        return "Allergies{" +
                "fid=" + fid +
                ", foodName='" + foodName + '\'' +
                ", foodType='" + foodType + '\'' +
                ", allergyType='" + allergyType + '\'' +
                ", foodInfo='" + foodInfo + '\'' +
                ", foodRiskPicker=" + foodRiskPicker +
                '}';
    }

    public int getFid() {
        return fid;
    }

    public void setFid(int fid) {
        this.fid = fid;
    }

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

    public String getFoodInfo() {
        return foodInfo;
    }

    public void setFoodInfo(String foodInfo) {
        this.foodInfo = foodInfo;
    }

    public int getFoodRiskPicker() {
        return foodRiskPicker;
    }

    public void setFoodRiskPicker(int foodRiskPicker) {
        this.foodRiskPicker = foodRiskPicker;
    }
}
