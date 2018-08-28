package com.example.arron.allergies20.Layouts;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.arron.allergies20.Models.Allergies;
import com.example.arron.allergies20.R;

import java.util.ArrayList;
import java.util.List;

public class FoodsViewAdapter extends ArrayAdapter<Allergies>{
    private Context Mcontext;
    private List<Allergies> foodsListIN = new ArrayList<>();

    public FoodsViewAdapter(Context context, List<Allergies> foodsList){
        super(context, 0 ,foodsList);
        Mcontext = context;
        foodsListIN = foodsList;

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent)
    {
        View ListItem = convertView;
        if(ListItem == null)
            ListItem = LayoutInflater.from(Mcontext).inflate(R.layout.foods_view_items,parent,false);

        Allergies currentAllergy = foodsListIN.get(position);

        TextView name = (TextView) ListItem.findViewById(R.id.food_name_view);
        name.setText(currentAllergy.getFoodName());


        return ListItem;

    }

}
