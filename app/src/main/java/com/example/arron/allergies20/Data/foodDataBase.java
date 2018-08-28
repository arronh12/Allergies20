package com.example.arron.allergies20.Data;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.example.arron.allergies20.Models.Allergies;

@Database(entities = {Allergies.class}, version = 1)
public abstract class foodDataBase extends RoomDatabase{

    public abstract DAOaccess DBaccess();

}
