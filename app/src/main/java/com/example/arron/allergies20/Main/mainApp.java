package com.example.arron.allergies20.Main;

import com.example.arron.allergies20.Models.Allergies;

import java.util.ArrayList;

public class mainApp {
    ArrayList<Allergies> foodsList = new ArrayList<>();

    public void addToList(String nameIn, String typeIn, String allergyIn, String infoIn, int foodRiskPickerIn){
        foodsList.add(new Allergies(nameIn, typeIn, allergyIn, infoIn, foodRiskPickerIn));
    }

    public void print(){

       for(int i = 0; i < foodsList.size();i++){
           System.out.println(foodsList.get(i).toString());
       }
    }
}
