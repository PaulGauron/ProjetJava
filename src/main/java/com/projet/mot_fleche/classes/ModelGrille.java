package com.projet.mot_fleche.classes;

public class ModelGrille {

    private int hauteur;
    private int largeur;

   /* public ModelGrille(int largeur, int hauteur) {
        this.hauteur = hauteur;
        this.largeur = largeur;
    }*/

    public ModelGrille() {
        this.hauteur = 0;
        this.largeur = 0;
    }

    public int getHauteur() {
        return hauteur;
    }

    public void setHauteur(int hauteur) {
        this.hauteur = hauteur;
    }

    public int getLargeur() {
        return largeur;
    }

    public void setLargeur(int largeur) {
        this.largeur = largeur;
    }

}
