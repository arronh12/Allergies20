package com.example.arron.allergies20.Activities;

import android.arch.persistence.room.Update;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.arron.allergies20.Layouts.Base;
import com.example.arron.allergies20.Models.Allergies;
import com.example.arron.allergies20.R;

import static com.example.arron.allergies20.R.menu.food_menu;

public class UpdateFood extends Base {
    int foodNum;
    TextView foodLabel;
    EditText foodOption;
    Button goButton;
    String choice;
    Allergies uAllergy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_food);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Intent intent = getIntent();
        foodNum = intent.getIntExtra("position", 0);

        foodLabel = (TextView)findViewById(R.id.updateChoiceLabel);
        foodOption = (EditText)findViewById(R.id.updateCoiceInput);
        goButton = (Button)findViewById(R.id.updateGoButton);

        uAllergy = foods.get(foodNum);




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
                startActivity(new Intent(UpdateFood.this,Add.class));
                break;
            case R.id.menu_view_foods:
                startActivity(new Intent(UpdateFood.this,ViewFoods.class));
        }
        return super.onOptionsItemSelected(item);
    }

    public void foodNameUpdate(View v){
        foodLabel.setText("Update Food Name");
        foodLabel.setVisibility(View.VISIBLE);
        foodOption.setVisibility(View.VISIBLE);
        goButton.setVisibility(View.VISIBLE);
        choice = "name";
    }

    public void upDatefoods(View v){
        if(foodOption.getText().toString().trim() == null){
            Toast.makeText(this,"Please input text to field...",Toast.LENGTH_LONG).show();
        }
        else {
            switch (choice) {
                case "name":
                    uAllergy.setFoodName(foodOption.getText().toString().toLowerCase().trim());
                    dbAccess.updateFood(uAllergy);
                    resetChoiceBox();

            }
        }

    }

    private void resetChoiceBox(){
        foodLabel.setText("");
        foodLabel.setVisibility(View.GONE);
        foodOption.setVisibility(View.GONE);
        goButton.setVisibility(View.GONE);
        choice = null;
    }




}
