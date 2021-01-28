package com.example.intentimplicite;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.app.SearchManager;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.security.Permission;

public class MainActivity extends AppCompatActivity {

    private Button composer;
    private Button appeller;
    private EditText Numero;
    private EditText Recherche;
    private Button Rechercher;
    private EditText message;
    private Button envoyer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ByView();
        composer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialNumbre();
            }
        });
        appeller.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                passer_appel();
            }
        });
        Rechercher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                recherche_google();
            }
        });
        envoyer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                envoyer_msg();
            }
        });
    }

    private void passer_appel() {
        String NumTel = "tel:"+Numero.getText().toString();
        Intent dialIntent = new Intent(Intent.ACTION_CALL, Uri.parse(NumTel));
        if (dialIntent.resolveActivity(getPackageManager()) != null)
            startActivity(dialIntent);
        else
            Toast.makeText(MainActivity.this,"Erreur",Toast.LENGTH_SHORT).show();
    }


    private void envoyer_msg() {
        String NumTel = "smsto:"+Numero.getText().toString();
        String text = message.getText().toString();
        Intent msg_Intent = new Intent(Intent.ACTION_SENDTO,Uri.parse(NumTel));
        msg_Intent.putExtra("sms_body", text);
        startActivity(msg_Intent);
    }


    //Méthode pour effectuer une recherche Google
    private void recherche_google() {
        String requette = Recherche.getText().toString();
        Intent SearchIntent = new Intent(Intent.ACTION_WEB_SEARCH);
        SearchIntent.putExtra(SearchManager.QUERY,requette);
        startActivity(SearchIntent);
    }


    //Méthode pour composer le numéro
    private void dialNumbre() {
        String NumTel = "tel:"+Numero.getText().toString();
        Intent dialIntent = new Intent(Intent.ACTION_DIAL, Uri.parse(NumTel));
        if (dialIntent.resolveActivity(getPackageManager()) != null)
            startActivity(dialIntent);
        else
            Toast.makeText(MainActivity.this,"Erreur",Toast.LENGTH_SHORT).show();
    }


    //Méthode pour lier le xml
    public void ByView (){
        composer = findViewById(R.id.buttondial);
        Numero = findViewById(R.id.edittel);
        Recherche = findViewById(R.id.editrequest);
        Rechercher = findViewById(R.id.buttonSearch);
        message = findViewById(R.id.editmessage);
        envoyer = findViewById(R.id.buttonenvoyer);
        appeller = findViewById(R.id.buttoncall);
    }

    private void Protection(){
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_CONTACTS)!= PackageManager.PERMISSION_GRANTED){
            if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.READ_CONTACTS)){
                showMyDialog(this);
            }else{
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_CONTACTS}, Permission_READ_CONTACTS);
            }
        }else{

        }
    }
}