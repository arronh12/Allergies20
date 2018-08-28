package com.example.arron.allergies20.Activities;

import android.arch.persistence.room.Room;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteConstraintException;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

import com.example.arron.allergies20.Data.foodDataBase;
import com.example.arron.allergies20.Layouts.Base;
import com.example.arron.allergies20.Layouts.FoodsViewAdapter;
import com.example.arron.allergies20.Models.Allergies;
import com.example.arron.allergies20.R;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ViewFoods extends Base {

    ListView listView;
    List<Allergies> foods;
    private FoodsViewAdapter fAdapter;
    SearchView search;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_foods);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //search = (SearchView)findViewById(R.id.searchView);

        foodDataBase db = Room.databaseBuilder(getApplicationContext(),foodDataBase.class ,"foods_db").allowMainThreadQueries().build();
        dbAccess = db.DBaccess();
        foods = dbAccess.getFoods();

        listView = (ListView)findViewById(R.id.viewFoodsList);

        fAdapter = new FoodsViewAdapter(this,foods);
        listView.setAdapter(fAdapter);
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
                Toast.makeText(this, "add", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(ViewFoods.this,Add.class));
                break;
            case R.id.menu_viewfoods:
                startActivity(new Intent(ViewFoods.this,ViewFoods.class));
        }
        return super.onOptionsItemSelected(item);
    }



        public void dataTester(View v){
        List<Allergies> foodsListData = dbAccess.getFoods();
            try{
                for(int i = 0; i < foodsListData.size(); i++) {
                    System.out.println(foodsListData.toString());

                }
            } catch(SQLiteConstraintException e){
                Toast.makeText(this,"Already exits",Toast.LENGTH_SHORT).show();
            }
        }
    }
