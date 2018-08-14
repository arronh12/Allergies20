package com.example.arron.allergies20.Activities;

import android.content.Context;
import android.content.Intent;
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
import android.widget.Toast;

import com.example.arron.allergies20.Layouts.Base;
import com.example.arron.allergies20.R;

import java.util.ArrayList;
import java.util.List;

public class ViewFoods extends Base {

    ListView listView;
    ArrayList<String> foods;
    private ArrayAdapter<String> FoodsListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_foods);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        listView = (ListView) findViewById(R.id.viewFoodsList);
        ArrayList<String> foods = new ArrayList<String>();

        foods = mainAppObject.returnFoodNames();

        FoodsListAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,foods);
        listView.setAdapter(FoodsListAdapter);

        /*listView.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        String food = String.valueOf(parent.getItemAtPosition(position));

                        //pass(food);
                    }
                });*/
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
                case R.id.menu_viewfoods:
                    startActivity(new Intent(ViewFoods.this,ViewFoods.class));
            }
            return super.onOptionsItemSelected(item);
        }
    }
