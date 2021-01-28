package com.example.tpappel;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText numTel;
    Button btnDial;
    EditText editRecherche;
    Button search;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Init();
        btnDial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialNumber();
            }
        });
    }


    private void Init(){
        numTel =  findViewById(R.id.NumTel);
        btnDial =  findViewById(R.id.BtnDial);
        editRecherche =  findViewById(R.id.EditRecherche);
        search =  findViewById(R.id.Search);
    }
    private void DialNumber(){
        String numero="tel:"+numTel.getText().toString();
        Intent dialIntent=new Intent(Intent.ACTION_DIAL, Uri.parse(numero));
        startActivity(dialIntent);
    }
}