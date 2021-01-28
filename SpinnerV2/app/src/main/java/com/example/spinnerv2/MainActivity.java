package com.example.spinnerv2;

import androidx.appcompat.app.AppCompatActivity;


import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{
    Spinner spinner;
    int lesDrapeau[]={R.drawable.france, R.drawable.ireland};
    int lesDrapeauAsie[]={R.drawable.japan, R.drawable.china};
    int lesDrapeauAfrique[]={R.drawable.algeria, R.drawable.tunisia};
    int HymneEu[]={R.raw.france, R.raw.irlande};
    int HymneAs[]={R.raw.japon, R.raw.chine};
    int HymneAf[]={R.raw.algerie, R.raw.tunisie};
    String continent[]={"Choisir le continent", "Europe", "Asie", "Afrique"};
    String pays[]={"France", "Ireland"};
    String paysAsie[]={"Japon", "Chine"};
    String paysAfrique[]={"Algerie", "Tunisie"};
    String capital[]={"Paris", "Helsinki", "Dublin"};
    String capitalAsie[]={"Tokyo", "Pékin"};
    String capitalAfrique[]={"Alger", "Tunis"};
    ArrayList<Pays> listPays=new ArrayList<Pays>();
    ArrayList<Pays> listPaysAffiche=new ArrayList<Pays>();
    ArrayAdapter<String> adapter;
    AdapterPerso adapterPerso;
    AdapterPerso adapterAffiche;
    ListView listEurope;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Init();
        Ajout();
        spinner.setOnItemSelectedListener(this);
        MiseEnPlaceSpinner();
        listEurope.setOnItemClickListener(new LstClickItem());
    }


    private void Init(){
        spinner = findViewById(R.id.Spinner);
        listEurope = findViewById(R.id.List);
    }
    private  void Ajout(){
        for (int i=0; i<2; i++){
            listPays.add(new Pays("Europe", pays[i], capital[i], lesDrapeau[i], HymneEu[i]));
            listPays.add(new Pays("Asie", paysAsie[i], capitalAsie[i], lesDrapeauAsie[i], HymneAs[i]));
            listPays.add(new Pays("Afrique", paysAfrique[i], capitalAfrique[i], lesDrapeauAfrique[i], HymneAf[i]));
        }
        adapterPerso = new AdapterPerso(this, listPays);
        adapterAffiche = new AdapterPerso(this, listPaysAffiche);
    }
    @SuppressLint("ResourceType")
    private void MiseEnPlaceSpinner(){
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, continent);
        adapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        if (spinner.getSelectedItem()=="Choisir le continent"){
            listEurope.setAdapter(adapterAffiche);
        }else if (spinner.getSelectedItem()=="Europe"){
            Affiche("Europe");
        }else if (spinner.getSelectedItem()=="Asie"){
            Affiche("Asie");
        }else if (spinner.getSelectedItem()=="Afrique"){
            Affiche("Afrique");
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    private void Affiche(String continent){
        listPaysAffiche.clear();
        for (int i =0; i<adapterPerso.getArrayPays().size();i++){
            if (adapterPerso.getArrayPays().get(i).getContinent()==continent){
                adapterAffiche.getArrayPays().add(adapterPerso.getArrayPays().get(i));
                listEurope.setAdapter(adapterAffiche);
            }
        }
    }

    private void Exports(Intent intent, String pays, String capital, int flag, int hymne){
        intent.putExtra("pays", pays);
        intent.putExtra("capital", capital);
        intent.putExtra("flag", flag);
        intent.putExtra("hymne", hymne);
    }

    private class LstClickItem implements AdapterView.OnItemClickListener{

        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            AdapterPerso adapterPerso = (AdapterPerso)parent.getAdapter();
            Exports(intentPays, adapterPerso.getArrayPays().get(position).getPays(), adapterPerso.getArrayPays().get(position).getCapital(), adapterPerso.getArrayPays().get(position).getFlag(), adapterPerso.getArrayPays().get(position).getHymne());
            startActivityForResult(intentPays, APPEL_PAYS);
            adapterPerso.notifyDataSetChanged();
        }
    }
}