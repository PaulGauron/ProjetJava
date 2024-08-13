package com.projet.mot_fleche.classes;

import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class ModelGrille {

    private int hauteur;
    private int largeur;
    private int[][] Modele;

    public void setModele(int[][] modele) {
        this.Modele = modele;
    }

    public void initializeModel(int largeur) {
        for (int i = 0; i < largeur; i++) {
            for (int j = 0; j < largeur; j++) {
                this.Modele[i][j] = 0;
            }
        }
    }

    public void initializeModel(int largeur, int hauteur) {
        for (int i = 0; i < this.hauteur; i++) {
            for (int j = 0; j < this.largeur; j++) {
                Modele[i][j] = 0;
            }
        }
    }

    public ModelGrille() {
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

    public void completePattern(int nbPattern, GridPane gridPane) {
        switch (nbPattern) {
            case 1:
                Mot mot = new Mot("filou", 5);
                Mot mot1 = new Mot("lois", 4);
                Mot mot2 = new Mot("si", 2);
                Mot mot3 = new Mot("ni", 2);
                Mot mot4 = new Mot("rein", 4);
                Mot mot5 = new Mot("moisi", 5);
                Mot mot6 = new Mot("unis", 4);
                Mot mot7 = new Mot("viril", 5);
                Mot mot8 = new Mot("le", 2);
                List<Mot> listeMot = Arrays.asList(mot, mot1, mot2, mot3, mot4, mot5, mot6, mot7, mot8);
                List<char[]> listeMotDecomposer = new ArrayList<>();
                for (Mot m : listeMot) {
                    listeMotDecomposer.add(m.decomposition());
                }
                int count = 0;
                for (char[] m : listeMotDecomposer) {
                    int i = 0;
                    boolean firstpass = true;
                    for (Character lettre : m) {
                       // System.out.println("i :" + i + " count" + count + " mot" + Arrays.toString(m));
                        Label labelCase = new Label(lettre.toString().toUpperCase());
                        labelCase.setFont(new Font("Arial", 18));
                        switch (count) {
                            case 0:
                                if (firstpass) {
                                    i += 1;
                                    firstpass = false;
                                }
                                StackPane lettreMot = (StackPane) gridPane.getChildren().get(i);
                                lettreMot.getChildren().add(labelCase);
                                break;
                            case 1:
                                if (firstpass) {
                                    i += 9;
                                    firstpass = false;
                                }
                                StackPane lettreMot1 = (StackPane) gridPane.getChildren().get(i);
                                lettreMot1.getChildren().add(labelCase);
                                break;
                            case 2:
                                if (firstpass) {
                                    i += 18;
                                    firstpass = false;
                                }
                                StackPane lettreMot2 = (StackPane) gridPane.getChildren().get(i);
                                lettreMot2.getChildren().add(labelCase);
                                break;
                            case 3:
                                if (firstpass) {
                                    i += 3;
                                    firstpass = false;
                                }
                                StackPane lettreMot3 = (StackPane) gridPane.getChildren().get(i);
                                lettreMot3.getChildren().add(labelCase);
                                break;
                            case 4:
                                if (firstpass) {
                                    i += 7;
                                    firstpass = false;
                                }
                                StackPane lettreMot4 = (StackPane) gridPane.getChildren().get(i);
                                lettreMot4.getChildren().add(labelCase);
                                break;
                            case 5:
                                if (firstpass) {
                                    i += 15;
                                    firstpass = false;
                                }
                                StackPane lettreMot5 = (StackPane) gridPane.getChildren().get(i);
                                lettreMot5.getChildren().add(labelCase);
                                break;
                            case 6:
                                if (firstpass) {
                                    i += 21;
                                    firstpass = false;
                                }
                                StackPane lettreMot6 = (StackPane) gridPane.getChildren().get(i);
                                lettreMot6.getChildren().add(labelCase);
                                break;
                            case 7:
                                if (firstpass) {
                                    i += 5;
                                    firstpass = false;
                                }
                                StackPane lettreMot7 = (StackPane) gridPane.getChildren().get(i);
                                lettreMot7.getChildren().add(labelCase);
                                break;
                            case 8:
                                if (firstpass) {
                                    i += 11;
                                    firstpass = false;
                                }
                                StackPane lettreMot8 = (StackPane) gridPane.getChildren().get(i);
                                lettreMot8.getChildren().add(labelCase);
                                break;
                        }
                        if (count < 5) { //après 5 les mots sont en horizontal
                            i += 5;
                        } else {
                            i += 1;
                        }

                    }
                    count++;
                }
                break;
            case 2:

        }

    }

    public int getIdCase(int i, int j) {
        return this.Modele[i][j];
    }

    public void setIdCase(int i, int j, int idCase) {
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
