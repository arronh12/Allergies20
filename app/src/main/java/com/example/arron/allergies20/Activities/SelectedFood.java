package com.example.arron.allergies20.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.example.arron.allergies20.Layouts.Base;
import com.example.arron.allergies20.Models.Allergies;
import com.example.arron.allergies20.R;

import static com.example.arron.allergies20.R.menu.food_menu;

public class SelectedFood extends Base {

    private TextView foodName, foodType;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.food_selected);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Intent intent = getIntent();
        int foodNum = intent.getIntExtra("position", 0);

        Toast.makeText(this,foods.get(foodNum).getFoodName(),Toast.LENGTH_SHORT).show();

        foodName = (TextView)findViewById(R.id.foodNameSelected);
        foodName.setText(foods.get(foodNum).getFoodName());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(food_menu, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId())
        {
            case R.id.menu_add:
                Toast.makeText(this, "add", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(SelectedFood.this,Add.class));
                break;
            case R.id.menu_view_foods:
                startActivity(new Intent(SelectedFood.this,ViewFoods.class));
        }
        return super.onOptionsItemSelected(item);
    }
}
