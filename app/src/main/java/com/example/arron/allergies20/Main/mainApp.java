package com.example.arron.allergies20.Main;

import com.example.arron.allergies20.Models.Allergies;
import com.example.arron.allergies20.Models.Dairy;
import com.example.arron.allergies20.Models.Gluten;
import com.example.arron.allergies20.Models.Penuts;

import java.util.ArrayList;

public class mainApp {
    ArrayList<Allergies> foodsList = new ArrayList<>();

    public void addToListGluten(String nameIn, String typeIn, String allergyIn, String infoIn, int foodRiskPickerIn,int glutenGramsIn, String problemFoodIn){
        foodsList.add(new Gluten(nameIn, typeIn, allergyIn, infoIn, foodRiskPickerIn, glutenGramsIn,problemFoodIn));
    }

    public void addToListPeanuts(String nameIn, String typeIn, String allergyIn, String infoIn, int foodRiskPickerIn,int traceAmountIn){
        foodsList.add(new Penuts(nameIn, typeIn, allergyIn, infoIn, foodRiskPickerIn, traceAmountIn));
    }

    public void addToListDairy(String nameIn, String typeIn, String allergyIn, String infoIn, int foodRiskPickerIn,int mlAmountIn){
        foodsList.add(new Dairy(nameIn, typeIn, allergyIn, infoIn, foodRiskPickerIn, mlAmountIn));
    }

    public ArrayList<String> returnFoodNames(){

        ArrayList<String> ListFoods = new ArrayList<>();
       for(int i = 0; i < foodsList.size();i++){

           ListFoods.add(foodsList.get(i).getFoodName());
           }
           return ListFoods;
    }
}
