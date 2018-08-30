package com.example.arron.allergies20.Activities;

import android.arch.persistence.room.Room;
import android.content.Intent;
import android.database.sqlite.SQLiteConstraintException;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.LinearLayoutCompat;
import android.support.v7.widget.Toolbar;
import android.text.InputType;
import android.view.MenuInflater;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.NumberPicker;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.arron.allergies20.Data.DAOaccess;
import com.example.arron.allergies20.Layouts.Base;
import com.example.arron.allergies20.Main.mainApp;
import com.example.arron.allergies20.Models.Allergies;
import com.example.arron.allergies20.R;
import com.example.arron.allergies20.Data.foodDataBase;

import java.util.List;


public class Add extends Base {

    EditText foodName, info;
    Spinner foodType;
    RadioGroup allergiesType;
    NumberPicker riskPicker;


    LinearLayoutCompat multiBox;

    String foodNameOut = "", infoOut = "", foodTypeOut = "", allergiesTypeOut = "";
    int riskPickerOut = 0;

    //Variables for gluten
    String glutenGramsValue = "";
    int glutenGramsOut = 0;
    String problemFoodOut = "";

    EditText problemFood;
    EditText glutenGrams;

    //variables for peanuts
    EditText peanutsTrace;

    //variables for dairy
    EditText dairyML;




    /*******************************************************************************************
     * Oncreate
     * @param
     ********************************************************************************************/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        mainAppObject = new mainApp();

        foodDataBase db = Room.databaseBuilder(getApplicationContext(),foodDataBase.class ,"foods_db").fallbackToDestructiveMigration().allowMainThreadQueries().build();
        dbAccess = db.DBaccess();

        foodName = (EditText) findViewById(R.id.foodNameText);
        foodType = (Spinner) findViewById(R.id.foodSpinner);
        allergiesType = (RadioGroup) findViewById(R.id.allergiesRGroup);
        info = (EditText) findViewById(R.id.infoText);

        riskPicker = (NumberPicker) findViewById(R.id.riskPicker);
        riskPicker.setMaxValue(5);
        riskPicker.setMinValue(0);

        multiBox = (LinearLayoutCompat) findViewById(R.id.multiBox);


        //radio group listener for changes
        allergiesType.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                multiBox.removeAllViews();

                switch (checkedId) {
                    case R.id.DradioB:
                        dairyRadio();
                        break;
                    case R.id.PradioB:
                        peanutsRadio();
                        break;
                    case R.id.GradioB:
                        glutenRadio();
                        break;
                }
            }
        });
    }
    /*********************************************************************************************/

    /******************************************************************************************
     //methods for changing aspects of multibox layout based on radio group selection....
     *******************************************************************************************/

    private void glutenRadio() {


        TextView glutenGramsLabel = (TextView) getLayoutInflater().inflate(R.layout.add_muliti_label, null);
        glutenGramsLabel.setText("Grams: ");

        TextView problemFoodLabels = (TextView) getLayoutInflater().inflate(R.layout.add_muliti_label, null);
        problemFoodLabels.setText("Problem Food: ");

        glutenGrams = (EditText) getLayoutInflater().inflate(R.layout.add_multi_input, null);
        glutenGrams.setTextAppearance(R.style.inputBoxes);
        glutenGrams.setHint("Gs");
        glutenGrams.setWidth(75);
        glutenGrams.setRawInputType(InputType.TYPE_CLASS_NUMBER);

        problemFood = (EditText) getLayoutInflater().inflate(R.layout.add_multi_input, null);
        problemFood.setWidth(400);

        LinearLayoutCompat multiBoxLevel1 = new LinearLayoutCompat(this);
        multiBoxLevel1.setOrientation(LinearLayout.HORIZONTAL);

        LinearLayoutCompat multiBoxLevel2 = new LinearLayoutCompat(this);
        multiBoxLevel2.setOrientation(LinearLayout.HORIZONTAL);
        multiBoxLevel2.setPadding(2, 50, 0, 0);

        multiBoxLevel1.addView(glutenGramsLabel, 0);
        multiBoxLevel1.addView(glutenGrams, 1);
        multiBoxLevel2.addView(problemFoodLabels, 0);
        multiBoxLevel2.addView(problemFood, 1);

        multiBox.addView(multiBoxLevel1);
        multiBox.addView(multiBoxLevel2);

        allergiesTypeOut = "Gluten";

    }

    private void dairyRadio() {
        TextView dairyMlLabel = (TextView) getLayoutInflater().inflate(R.layout.add_muliti_label, null);
        dairyMlLabel.setText("ML: ");

        dairyML = (EditText) getLayoutInflater().inflate(R.layout.add_multi_input, null);
        dairyML.setTextAppearance(R.style.inputBoxes);
        dairyML.setWidth(75);
        dairyML.setInputType(InputType.TYPE_CLASS_NUMBER);

        LinearLayoutCompat multiBoxLevel1 = new LinearLayoutCompat(this);
        multiBoxLevel1.setOrientation(LinearLayout.HORIZONTAL);

        multiBoxLevel1.addView(dairyMlLabel);
        multiBoxLevel1.addView(dairyML);

        multiBox.addView(multiBoxLevel1);

        allergiesTypeOut = "Dairy";


    }

    private void peanutsRadio() {

        TextView peanutsTraceLabel = (TextView) getLayoutInflater().inflate(R.layout.add_muliti_label, null);
        peanutsTraceLabel.setText("Penuts Trace: ");

        peanutsTrace = (EditText) getLayoutInflater().inflate(R.layout.add_multi_input, null);
        peanutsTrace.setTextAppearance(R.style.inputBoxes);
        peanutsTrace.setHint("gs");
        peanutsTrace.setWidth(75);
        peanutsTrace.setInputType(InputType.TYPE_CLASS_NUMBER);

        LinearLayoutCompat multiBoxLevel1 = new LinearLayoutCompat(this);
        multiBoxLevel1.setOrientation(LinearLayout.HORIZONTAL);

        multiBoxLevel1.addView(peanutsTraceLabel);
        multiBoxLevel1.addView(peanutsTrace);

        multiBox.addView(multiBoxLevel1);
        allergiesTypeOut = "Peaunts";

    }

    /*******************************************************************************************/


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
                startActivity(new Intent(Add.this,Add.class));
                break;
            case R.id.menu_view_foods:
                startActivity(new Intent(Add.this,ViewFoods.class));
        }
        return super.onOptionsItemSelected(item);
    }

    /*********************************************************************************************
     * methods for onClicks
     * @param v
     ********************************************************************************************/
    public void addClicked(View v) {


        if (addIsEmpty() == true) {
            Toast.makeText(this, "Error, Please fill out all fields first!", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(this, "Food Added to Library, Thank You!", Toast.LENGTH_LONG).show();

            switch(allergiesType.getCheckedRadioButtonId()){
                case R.id.GradioB:
                    glutenGramsOut = Integer.parseInt(glutenGrams.getText().toString().trim());
                    mainAppObject.addToListGluten(foodNameOut,foodTypeOut,allergiesTypeOut,infoOut,riskPickerOut,glutenGramsOut,problemFoodOut);
                    break;
                case R.id.DradioB:
                    int dairyMLOut = Integer.parseInt(dairyML.getText().toString().trim());
                    mainAppObject.addToListDairy(foodNameOut,foodTypeOut,allergiesTypeOut,infoOut,riskPickerOut,dairyMLOut);
                    break;
                case R.id.PradioB:
                    int traceAmountOut = Integer.parseInt(peanutsTrace.getText().toString().trim());
                    mainAppObject.addToListPeanuts(foodNameOut,foodTypeOut,allergiesTypeOut,infoOut,riskPickerOut,traceAmountOut);
            }
        }
        List<Allergies> foodsListData = dbAccess.getFoods();

        Allergies allergy = new Allergies(foodNameOut,foodTypeOut,allergiesTypeOut,infoOut,riskPickerOut);

        allergy.setFoodName(foodNameOut.trim().toLowerCase());
        allergy.setFoodType(foodTypeOut);
        allergy.setAllergyType(allergiesTypeOut);
        allergy.setFoodInfo(infoOut);
        allergy.setFoodRiskPicker(riskPickerOut);
        allergy.setFid(foodsListData.size());
        dbAccess.addFoodLists(allergy);


        try{
            for(int i = 0; i < foodsListData.size(); i++) {
                System.out.println(foodsListData.get(i).toString());

            }
        } catch(SQLiteConstraintException e){
            Toast.makeText(this,"Already exits",Toast.LENGTH_SHORT).show();
        }

    }

    public void clearClicked(View v) {

        startActivity(new Intent(Add.this, Add.class));
        Toast.makeText(this,"Add Fields Cleared...",Toast.LENGTH_SHORT).show();

        foodNameOut = ""; infoOut = ""; foodTypeOut = ""; allergiesTypeOut = "";
        riskPickerOut = 0;
        allergiesTypeOut = "";

        glutenGramsOut = 0; problemFoodOut = "";
    }

    /*********************************************************************************************/

    //method for checking if fields are empty.
    private boolean addIsEmpty() {
        foodNameOut = foodName.getText().toString();
        infoOut = info.getText().toString();
        foodTypeOut = foodType.getSelectedItem().toString();
        riskPickerOut = riskPicker.getValue();


        switch (allergiesType.getCheckedRadioButtonId()) {
            case R.id.GradioB:
                if (foodName.getText().toString().trim().isEmpty() || info.getText().toString().trim().isEmpty()|| glutenGrams.getText().toString().isEmpty()||problemFood.getText().toString().trim().isEmpty()) {
                    return true;
                } else {
                    return false;
                }
            case R.id.DradioB:
                if (foodName.getText().toString().trim().isEmpty() || info.getText().toString().trim().isEmpty()|| dairyML.getText().toString().isEmpty()) {
                    return true;
                } else {
                    return false;
                }
            case R.id.PradioB:
                if (foodName.getText().toString().trim().isEmpty() || info.getText().toString().trim().isEmpty()|| peanutsTrace.getText().toString().isEmpty()) {
                    return true;
                } else {
                    return false;
                }
            default:
                return true;

        }
    }
}
