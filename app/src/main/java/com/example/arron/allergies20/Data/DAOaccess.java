package com.example.arron.allergies20.Data;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.example.arron.allergies20.Models.Allergies;

import java.util.List;

@Dao
public interface DAOaccess {
    @Insert
    public void addFoodLists(Allergies...allergies);

    @Delete
    void deleteFood(Allergies...allergies);

    @Query("DELETE  FROM food_table")
    void deleteAllfoodas();

    @Query("SELECT * FROM food_table")
    List<Allergies> getFoods();

    @Query("SELECT * FROM food_table WHERE food_name like :UserGuess")
    public List<Allergies> userInput(String UserGuess);


    @Update()
    public void updateFood(Allergies...allergies);

}
