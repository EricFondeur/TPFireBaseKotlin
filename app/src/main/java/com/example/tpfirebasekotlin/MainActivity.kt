package com.example.tpfirebasekotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    lateinit var ajoutLivre: Button
    lateinit var livreDisp: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Init()
        ajoutLivre.setOnClickListener{
            startActivity(Intent(this@MainActivity,AjoutLivre::class.java))
        }
    }

    fun Init(){
        ajoutLivre=findViewById(R.id.AjoutLivre)
        livreDisp=findViewById(R.id.LivreDispo)
    }
}