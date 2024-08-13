package com.projet.mot_fleche.classes;

public class Mot {
    public int getLongeur() {
        return longeur;
    }

    public String getMot() {
        return mot;
    }

    public void setMot(String mot) {
        this.mot = mot;
        this.longeur = mot.length();
    }

    private int longeur;
    private String mot;

    public Mot(String mot, int longeur) {
        this.mot = mot;
        this.longeur = longeur;
    }

    public char[] decomposition(){
        return mot.toCharArray();
    }


}
