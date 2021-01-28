package com.example.tpfirebasekotlin

class Livre {
    lateinit var id : String
    lateinit var titre : String
    lateinit var auteur : String
    var nombrePage : Int? = null
    var hall : Int? = null
    lateinit var  dispo : String

    constructor(
        id: String,
        titre: String,
        auteur: String,
        nombrePage: Int?,
        hall: Int?,
        dispo: String
    ) {
        this.id = id
        this.titre = titre
        this.auteur = auteur
        this.nombrePage = nombrePage
        this.hall = hall
        this.dispo = dispo
    }
}
