package com.example.tpfirebasekotlin

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.database.FirebaseDatabase

class AjoutLivre : AppCompatActivity() {

    lateinit var titre: EditText
    lateinit var auteur: EditText
    lateinit var nombrePage: EditText
    lateinit var hall:EditText
    lateinit var retour:Button
    lateinit var ajoutLivre: Button
    lateinit var livre:Livre

    var database = FirebaseDatabase.getInstance()
    var myRef = database.getReference("Livre")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ajout_livre)
        Init()
        retour.setOnClickListener{
            startActivity(Intent(this, MainActivity::class.java))
        }
        ajoutLivre.setOnClickListener{
            myRef.push().key
            livre= Livre(titre.text, )
        }
    }

    fun Init(){
        titre=findViewById(R.id.TitreZone)
        auteur=findViewById(R.id.AuteurZone)
        nombrePage=findViewById(R.id.NombrePageZone)
        hall=findViewById(R.id.HallZone)
        retour=findViewById(R.id.Retour)
        ajoutLivre=findViewById(R.id.AjoutLivre)
    }
}