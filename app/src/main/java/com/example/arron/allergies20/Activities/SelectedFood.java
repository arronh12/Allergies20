package com.example.arron.allergies20.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.arron.allergies20.Layouts.Base;
import com.example.arron.allergies20.Models.Allergies;
import com.example.arron.allergies20.R;

import static com.example.arron.allergies20.R.menu.food_menu;

public class SelectedFood extends Base {

    private TextView foodName, foodType, allergyType, selectedNum,infoSelected;
    private ProgressBar selectedBar;
    int foodNum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.food_selected);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Intent intent = getIntent();
        foodNum = intent.getIntExtra("position", 0);

        Toast.makeText(this,foods.get(foodNum).getFoodName(),Toast.LENGTH_SHORT).show();

        foodName = (TextView)findViewById(R.id.foodNameSelected);
        foodName.setText(foods.get(foodNum).getFoodName());

        foodType = (TextView)findViewById(R.id.foodtypeselected);
        foodType.setText(foods.get(foodNum).getFoodType());

        allergyType = (TextView)findViewById(R.id.allergytypeselected);
        allergyType.setText(foods.get(foodNum).getAllergyType());

        selectedBar = (ProgressBar)findViewById(R.id.progressBarselected);
        selectedBar.setProgress(foods.get(foodNum).getFoodRiskPicker() * 20);
        selectedNum = (TextView)findViewById(R.id.selectedNum);
        int NumIn = foods.get(foodNum).getFoodRiskPicker();
        selectedNum.setText(Integer.toString(NumIn));

        infoSelected = (TextView)findViewById(R.id.infoSelected);
        infoSelected.setText(foods.get(foodNum).getFoodInfo());


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

    public void deleteFood(View v){
        dbAccess.deleteFood(foods.get(foodNum));
        startActivity(new Intent(SelectedFood.this,ViewFoods.class));
        Toast.makeText(this,"Food Deleted...",Toast.LENGTH_SHORT).show();

    }

    public void update(View v){
        Intent intent = new Intent(SelectedFood.this, UpdateFood.class);
        intent.putExtra("foodNUm", foodNum);
        startActivity(intent);
        Toast.makeText(this,"Please select Option...",Toast.LENGTH_SHORT).show();
    }
}
