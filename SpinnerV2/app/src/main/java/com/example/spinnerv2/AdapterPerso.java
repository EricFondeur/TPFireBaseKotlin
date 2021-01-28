package com.example.spinnerv2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;

import java.util.ArrayList;

public class AdapterPerso extends BaseAdapter {
    private Context leContext;
    private LayoutInflater objeInflater;
    private ArrayList<Pays> lesPays;
    public AdapterPerso (Context context, ArrayList<Pays> ArrayMois){
        leContext = context;
        objeInflater= LayoutInflater.from(context);
        lesPays = ArrayMois;
    }

    public ArrayList<Pays> getArrayPays(){
        return lesPays;
    }

    @Override
    public int getCount() {
        return lesPays.size();
    }

    @Override
    public Object getItem(int position) {
        return lesPays.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ConstraintLayout ItemView;
        if (convertView == null) {
            ItemView=(ConstraintLayout)objeInflater.inflate(R.layout.itemviewperso, parent, false);
        }else{
            ItemView=(ConstraintLayout) convertView;
        }

        TextView txtPays = ItemView.findViewById(R.id.TxtPays);
        TextView txtCapital = ItemView.findViewById(R.id.TxtCapital);
        ImageView drapeauPays = ItemView.findViewById(R.id.DrapeauPays);

        txtPays.setText(lesPays.get(position).getPays());
        txtCapital.setText(lesPays.get(position).getCapital());
        drapeauPays.setImageResource(lesPays.get(position).getFlag());

        return ItemView;
    }
}
