package com.projet.mot_fleche.Controller;

import com.projet.mot_fleche.classes.Fichier;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.*;
import javafx.event.ActionEvent;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;


import java.awt.*;
import java.util.ArrayList;
import java.util.Objects;

public class RechercheMotController {

    @FXML
    TextField TextTrou;

    @FXML
    private GridPane gridPaneResult;

    @FXML
    private Label ResultatRecherche;

    Fichier listeMot = new Fichier();
    int idY = 0, idX = 0;
    ArrayList<String> list = listeMot.getListeDeMots();

    private int nblettre = 0;
    private String firstLetter = "";
    ArrayList<String> listResult = new ArrayList<>();


    public void setNblettre(ActionEvent event) {
        MenuItem menuItem = (MenuItem) event.getSource();  // Récupère le texte de l'élément de menu
        String selectedValue = menuItem.getText();
        nblettre = Integer.parseInt(selectedValue);
    }

    public void setFirstLetter(ActionEvent event) {
        MenuItem menuItem = (MenuItem) event.getSource();
        String selectedValue = menuItem.getText();
        firstLetter = selectedValue;
    }

    public void onResetButton() {
        idY = 0;
        idX = 0;
        nblettre = 0;
        firstLetter = "";
        ResultatRecherche.setText("");
        gridPaneResult.getChildren().clear();
    }

    public char[] getTextFieldAsArray() {
        String content = TextTrou.getText(); // Récupère le texte du TextField

        // Convertit le texte en un tableau de caractères
        return content.toCharArray();
    }

    @FXML
    protected void RechercheMot() {
        idX = 0;
        idY = 0;
        gridPaneResult.getChildren().clear();
        listResult.clear();
        ResultatRecherche.setFont(Font.font(24.0));
        if (nblettre != 0 && !Objects.equals(firstLetter, "")) {
            ResultatRecherche.setText("nombre de lettres : " + nblettre + "   || 1er Lettre : " + firstLetter);
            for (String m : list) {
                if (m.startsWith(firstLetter) && m.length() == nblettre) {
                    listResult.add(m);
                }
            }
        } else if (!Objects.equals(firstLetter, "")) {
            ResultatRecherche.setText("1er lettre : " + firstLetter);
            for (String m : list) {
                if (m.startsWith(firstLetter)) {
                    listResult.add(m);
                }
            }
        } else {
            ResultatRecherche.setText("nombre de lettres : " + nblettre);
            for (String m : list) {
                if (m.length() == nblettre) {
                    listResult.add(m);
                }
            }
        }

        if (!TextTrou.getText().isEmpty()) {
            char[] MotTab = getTextFieldAsArray(); // Récupère le tableau de caractères du TextField

            for (String mResult : list) {
                boolean isMatch = true;

                // Vérifie si la longueur du mot correspond à celle du tableau
                if (mResult.length() == MotTab.length) {
                    // Comparaison lettre par lettre
                    for (int i = 0; i < MotTab.length; i++) {
                        // Ignore la comparaison si le caractère dans MotTab est '_'
                        if (MotTab[i] != '_' && MotTab[i] != mResult.charAt(i)) {
                            isMatch = false;
                            break; // Sort de la boucle si une lettre ne correspond pas
                        }
                    }

                    // Si toutes les lettres correspondent (sauf les '_'), ajoute le mot à la liste
                    if (isMatch) {
                        listResult.add(mResult);
                    }
                }
            }
            ResultatRecherche.setText("nombre de lettres : " + MotTab.length);
        }

        for (String mResult : listResult) {
            TextField cell = new TextField(mResult);
            cell.setDisable(true);
            gridPaneResult.add(cell, idY, idX);
            idY++;
            if (idY == 7) {
                idX++;
                idY = 0;
            }
        }

    }


}
