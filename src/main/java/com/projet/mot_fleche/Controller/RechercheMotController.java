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
    private GridPane gridPaneResult;

    @FXML
    private Label ResultatRecherche;

    Fichier listeMot = new Fichier();
    int idY=0,idX = 0;
    ArrayList<String> list = listeMot.getListeDeMots();

    private int nblettre = 0;
    private String firstLetter = "";
    ArrayList<String> listResult = new ArrayList<>();


public void setNblettre(ActionEvent event){
    MenuItem menuItem = (MenuItem) event.getSource();  // Récupère le texte de l'élément de menu
    String selectedValue = menuItem.getText();
    nblettre = Integer.parseInt(selectedValue);
}

public void setFirstLetter(ActionEvent event){
        MenuItem menuItem = (MenuItem) event.getSource();
        String selectedValue = menuItem.getText();
        firstLetter = selectedValue;
}

public void onResetButton(){
    idY = 0;
    idX = 0;
    nblettre = 0;
    firstLetter = "";
    ResultatRecherche.setText("");
    gridPaneResult.getChildren().clear();
}

@FXML
protected void RechercheMot() {
    idX = 0;
    idY = 0;
    gridPaneResult.getChildren().clear();
    listResult.clear();
    ResultatRecherche.setFont(Font.font(24.0));
    if(nblettre != 0 && !Objects.equals(firstLetter, "")){
        ResultatRecherche.setText("nombre de lettres : " + nblettre + "   || 1er Lettre : " + firstLetter );
        for (String m  : list) {
            if (m.startsWith(firstLetter) && m.length() == nblettre) {
                listResult.add(m);
            }
        }
    }
    else if(!Objects.equals(firstLetter, "")) {
        ResultatRecherche.setText("1er lettre : " + firstLetter );
        for (String m  : list) {
            if (m.startsWith(firstLetter)) {
                listResult.add(m);
            }
        }
    }
    else{
        ResultatRecherche.setText("nombre de lettres : " + nblettre );
        for (String m  : list) {
            if( m.length() == nblettre){
                listResult.add(m);
            }
        }
    }
    for(String mResult : listResult) {
        TextField cell = new TextField(mResult);
        cell.setDisable(true);
        gridPaneResult.add(cell, idY, idX);
        System.out.println("idX : "+idX +"idY : "+ idY);
        idY++;
        if (idY == 7){idX++; idY = 0;}
    }

    // Create a ScrollPane and set the GridPane as its content
    ScrollPane scrollPane = new ScrollPane();
    scrollPane.setContent(gridPaneResult);
    scrollPane.setFitToWidth(true);
    scrollPane.setFitToHeight(true);
    scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
    scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
}
}
