package com.example.arron.allergies20.Activities;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.arron.allergies20.Layouts.Base;
import com.example.arron.allergies20.Main.mainApp;
import com.example.arron.allergies20.R;

public class Add extends Base {

    EditText foodName, info;
    Spinner foodType;
    RadioGroup allergiesType;
    NumberPicker riskPicker;

    String foodNameOut = "", infoOut="", foodTypeOut="", allergiesTypeOut="";
    int riskPickerOut = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        mainAppObject = new mainApp();

        foodName = (EditText)findViewById(R.id.foodNameText);
        foodType = (Spinner)findViewById(R.id.foodSpinner);
        allergiesType = (RadioGroup)findViewById(R.id.allergiesRGroup);
        info = (EditText)findViewById(R.id.infoText);
        riskPicker = (NumberPicker)findViewById(R.id.riskPicker);

        riskPicker.setMaxValue(5);
        riskPicker.setMinValue(0);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_add, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void addClicked(View v){

        if(addIsEmpty() == true){
            Toast.makeText(this, "Error, Please fill out all fields first!",Toast.LENGTH_LONG).show();
        }
        else{
            Toast.makeText(this, "Food Added to Library, Thank You!", Toast.LENGTH_LONG).show();

            mainAppObject.addToList(foodNameOut, foodTypeOut, allergiesTypeOut,infoOut,riskPickerOut);
            mainAppObject.print();
        }

    }

    public void clearClicked(View v){
    }

    private boolean addIsEmpty(){
        foodNameOut = foodName.getText().toString();
        infoOut = info.getText().toString();
        foodTypeOut = foodType.getSelectedItem().toString();
        riskPickerOut = riskPicker.getValue();

        if(foodName.getText().toString().trim().isEmpty()|| info.getText().toString().trim().isEmpty()){
            return true;
        }
        else return false;
    }
}
