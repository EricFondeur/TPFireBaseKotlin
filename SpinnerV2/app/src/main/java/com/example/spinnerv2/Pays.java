package com.example.spinnerv2;

public class Pays {
    String continent;
    String pays;
    String capital;
    int flag;
    int hymne;
    boolean etat;

    public Pays(String continent, String pays, String capital, int flag, int hymne) {
        this.continent = continent;
        this.pays = pays;
        this.capital = capital;
        this.flag = flag;
        this.hymne = hymne;
    }

    public int getHymne() {
        return hymne;
    }

    public void setHymne(int hymne) {
        this.hymne = hymne;
    }

    public boolean isEtat() {
        return etat;
    }

    public void setEtat(boolean etat) {
        this.etat = etat;
    }

    public String getPays() {
        return pays;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }

    public String getContinent() {
        return continent;
    }

    public void setContinent(String continent) {
        this.continent = continent;
    }
}
