package com.example.arron.allergies20.Activities;

import android.arch.persistence.room.Update;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.NumberPicker;
import android.widget.RadioGroup;
import android.widget.Spinner;
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
    String choice, allergyName;
    Allergies uAllergy;
    Spinner foodTypeUpdate;
    NumberPicker riskUpdatePicker;
    LinearLayout allergyBox;
    RadioGroup allergyG;
    boolean checkEmpty = false;

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
        foodTypeUpdate = (Spinner) findViewById(R.id.foodTypeSpinner);
        allergyBox = (LinearLayout)findViewById(R.id.allergyBoxSelected);
        allergyG = (RadioGroup)findViewById(R.id.allergyG);
        riskUpdatePicker = (NumberPicker) findViewById(R.id.riskPickerView);
        riskUpdatePicker.setMinValue(0);
        riskUpdatePicker.setMaxValue(5);


        uAllergy = foods.get(foodNum);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflator = getMenuInflater();
        inflator.inflate(R.menu.food_menu, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId())
        {
            case R.id.menu_add:
                Toast.makeText(this, "add foods", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(UpdateFood.this,Add.class));
                break;
            case R.id.menu_view_foods:
                startActivity(new Intent(UpdateFood.this,ViewFoods.class));
                break;
            case R.id.menu_deleteAll:
                dbAccess.deleteAllfoodas();
                foods = dbAccess.getFoods();
                Toast.makeText(this,"All foods deleted form database...",Toast.LENGTH_LONG).show();
        }
        return super.onOptionsItemSelected(item);
    }

    public void foodNameUpdate(View v){
        resetChoiceBox();
        foodLabel.setText("Update Food Name");
        foodLabel.setVisibility(View.VISIBLE);
        foodOption.setVisibility(View.VISIBLE);
        goButton.setVisibility(View.VISIBLE);
        choice = "name";
    }

    public void foodTypeUpdate(View v){
        resetChoiceBox();
        foodLabel.setText("Update Food Type");
        foodLabel.setVisibility(View.VISIBLE);
        foodTypeUpdate.setVisibility(View.VISIBLE);
        goButton.setVisibility(View.VISIBLE);
        choice="type";
    }

    public void allergyTypeUpdate(View v){
        resetChoiceBox();
        foodLabel.setText("Update Food Type");
        foodLabel.setVisibility(View.VISIBLE);
        allergyBox.setVisibility(View.VISIBLE);
        goButton.setVisibility(View.VISIBLE);
        choice="allergy";
    }

    public void riskUpdateUpdate(View v){
        resetChoiceBox();
        foodLabel.setText("Update Risk Level");
        foodLabel.setVisibility(View.VISIBLE);
        riskUpdatePicker.setVisibility(View.VISIBLE);
        goButton.setVisibility(View.VISIBLE);
        choice="risk";
    }

    public void foodInfoUpdate(View v){
        resetChoiceBox();
        foodLabel.setText("Update Food Information");
        foodLabel.setVisibility(View.VISIBLE);
        foodOption.setVisibility(View.VISIBLE);
        goButton.setVisibility(View.VISIBLE);
        choice = "info";
    }

    public void upDatefoods(View v){

        if(foodOption.getText().toString().trim() == null){
            Toast.makeText(this,"Please input text to field...",Toast.LENGTH_LONG).show();
        }
        else {
            switch (choice) {
                case "name":
                    if(foodOption.getText() == null){
                        Toast.makeText(this,"Error field cant be empty",Toast.LENGTH_SHORT).show();
                    }
                    else if(foodOption.getText().toString().trim() == ""){
                        Toast.makeText(this,"Error field cant be empty",Toast.LENGTH_SHORT).show();
                    }
                    else {
                        uAllergy.setFoodName(foodOption.getText().toString().toLowerCase().trim());
                        dbAccess.updateFood(uAllergy);
                        resetChoiceBox();
                        Toast.makeText(this, "food name updated...", Toast.LENGTH_SHORT).show();
                    }
                    break;
                case "type":
                    uAllergy.setFoodType(foodTypeUpdate.getSelectedItem().toString());
                    dbAccess.updateFood(uAllergy);
                    resetChoiceBox();
                    Toast.makeText(this,"food type updated...",Toast.LENGTH_SHORT).show();
                    break;
                case "allergy":
                    allergyG.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                        @Override
                        public void onCheckedChanged(RadioGroup group, int checkedId) {
                            switch (checkedId) {
                                case R.id.DradioB:
                                    uAllergy.setAllergyType("Dairy");
                                    break;
                                case R.id.PradioB:
                                    allergyName = "Penut";
                                    uAllergy.setAllergyType("Penut");
                                    break;
                                case R.id.GradioB:
                                    allergyName = "Gluten";
                                    uAllergy.setAllergyType("gluten");
                                    break;
                                    default:
                                        allergyName = "Empty";
                                        uAllergy.setAllergyType(allergyName);
                            }
                        }
                    });
                    dbAccess.updateFood(uAllergy);
                    resetChoiceBox();
                    Toast.makeText(this,"Allergy type Updated...",Toast.LENGTH_SHORT).show();
                    break;
                case "risk":
                    uAllergy.setFoodRiskPicker(riskUpdatePicker.getValue());
                    dbAccess.updateFood(uAllergy);
                    resetChoiceBox();
                    Toast.makeText(this,"Risk Level updated...",Toast.LENGTH_SHORT).show();
                    break;
                case "info":
                    uAllergy.setFoodInfo(foodOption.getText().toString());
                    dbAccess.updateFood(uAllergy);
                    resetChoiceBox();
                    Toast.makeText(this,"food information updated...",Toast.LENGTH_SHORT).show();

            }
        }

    }

    private void resetChoiceBox(){
        foodLabel.setText("");
        foodLabel.setVisibility(View.GONE);
        foodOption.setVisibility(View.GONE);
        goButton.setVisibility(View.GONE);
        foodTypeUpdate.setVisibility(View.GONE);
        allergyBox.setVisibility(View.GONE);
        riskUpdatePicker.setVisibility(View.GONE);
        choice = null;
    }

    public void BoxinputCheck(){

    }




}
