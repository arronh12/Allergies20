package com.example.arron.allergies20.Layouts;

import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.arron.allergies20.Data.DAOaccess;
import com.example.arron.allergies20.Main.mainApp;
import com.example.arron.allergies20.Models.Allergies;
import com.example.arron.allergies20.R;

import java.util.List;

public class Base extends AppCompatActivity {

    public mainApp mainAppObject;
    public static DAOaccess dbAccess;
    public static List<Allergies> foods;


}
