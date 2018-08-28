package com.example.arron.allergies20.Layouts;

import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.arron.allergies20.Data.DAOaccess;
import com.example.arron.allergies20.Main.mainApp;
import com.example.arron.allergies20.R;

public class Base extends AppCompatActivity {

    public mainApp mainAppObject;
    public static DAOaccess dbAccess;


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId())
        {
            case R.id.menu_add:
                Toast.makeText(this, "add foods", Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflator = getMenuInflater();
        inflator.inflate(R.menu.food_menu, menu);
        return true;
    }
}
