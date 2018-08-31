package com.example.arron.allergies20.Activities;

import android.arch.persistence.room.Room;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteConstraintException;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.view.MenuItemCompat;
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

import static com.example.arron.allergies20.R.menu.food_menu;

public class ViewFoods extends Base {

    ListView listView;
    private FoodsViewAdapter fAdapter;
    SearchView search;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_foods);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        search = (SearchView)findViewById(R.id.searchBox);
        search.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                userInput(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                userInput(newText);
                return false;
            }
        });

        foodDataBase db = Room.databaseBuilder(getApplicationContext(),foodDataBase.class ,"foods_db").allowMainThreadQueries().build();
        dbAccess = db.DBaccess();
        foods = dbAccess.getFoods();

        listView = (ListView)findViewById(R.id.viewFoodsList);
        fAdapter = new FoodsViewAdapter(this,foods);
        listView.setAdapter(fAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent intent = new Intent(ViewFoods.this, SelectedFood.class);
                intent.putExtra("position", position);
                startActivity(intent);
            }
        });
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
                startActivity(new Intent(ViewFoods.this,Add.class));
                break;
            case R.id.menu_view_foods:
                startActivity(new Intent(ViewFoods.this,ViewFoods.class));
                break;
            case R.id.menu_deleteAll:
                dbAccess.deleteAllfoodas();
                foods = dbAccess.getFoods();
                Toast.makeText(this,"All foods deleted form database...",Toast.LENGTH_LONG).show();
        }
        return super.onOptionsItemSelected(item);
    }

    public void startList(View v){
        foods = dbAccess.getFoods();
        listView = (ListView)findViewById(R.id.viewFoodsList);
        fAdapter = new FoodsViewAdapter(this,foods);
        listView.setAdapter(fAdapter);
    }


    public void userInput(String quiryIn){
        quiryIn.trim().toLowerCase();
        List list = dbAccess.userInput(quiryIn);
        foods = list;
        fAdapter = new FoodsViewAdapter(this,list);
        listView.setAdapter(fAdapter);
    }



    }
