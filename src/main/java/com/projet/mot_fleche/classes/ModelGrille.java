package com.projet.mot_fleche.classes;

import java.lang.reflect.Array;

public class ModelGrille {

    private int hauteur;
    private int largeur;
    private int[][] Modele;

    public void setModele(int[][] modele) {
        this.Modele = modele;
    }

    public void initializeModel(int largeur){
        for (int i = 0; i < largeur; i++){
            for (int j = 0; j < largeur; j++){
                this.Modele[i][j] = 0;
            }
        }
    }

    public void initializeModel(int largeur, int hauteur){
        for (int i = 0; i < this.hauteur; i++){
            for (int j = 0; j < this.largeur; j++){
                Modele[i][j] = 0;
            }
        }
    }

    public ModelGrille(){
        this.hauteur = 0;
        this.largeur = 0;
        this.Modele = new int[this.largeur][this.largeur];
    }

    public void afficher() {
        for (int i = 0; i < largeur; i++) {
            for (int j = 0; j < largeur; j++) {
                System.out.print(Modele[i][j] + " ");
            }
            System.out.println();
        }
    }

    public int getIdCase(int i,int j) {
        return this.Modele[i][j];
    }

    public void setIdCase(int i,int j,int idCase) {
        this.Modele[i][j] = idCase;
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
