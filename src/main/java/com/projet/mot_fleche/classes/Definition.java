package com.projet.mot_fleche.classes;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

public class Definition {
    private final String intitule;
    private final String direction;
    private final int id;
    private StackPane defintion;

    public Definition(String intitule, String direction,int id) {
        this.intitule = intitule;
        this.direction = direction;
        this.id = id;
        initializeStackpane();
    }


    private void initializeStackpane() {
        Label DefLabel = new Label(this.intitule);
        if(this.id == 0 ){
            this.defintion = new StackPane(DefLabel);
            DefLabel.setStyle("-fx-text-fill: white;");
            this.defintion.setBackground(Background.fill(Color.BLACK));
        }else if(this.id == 1){
            this.defintion = new StackPane(DefLabel);
            this.defintion.setBackground(Background.fill(Color.BLACK));
        }else {
            this.defintion = new StackPane(DefLabel);
            this.defintion.setBackground(Background.fill(Color.BLACK));
        }

    }

    public StackPane getStackpane() {
        return defintion;
    }

    public void ajouter() {
        System.out.println("Définition ajoutée : " + intitule + ", " + direction);
        // Code pour ajouter l'objet definition
    }

    public void supprimer() {
        Label emptyLabel = new Label("");
        defintion.getChildren().add(emptyLabel); // Ajouter une étiquette vide
        defintion.setBackground(Background.fill(Color.WHITE));
    }

    public void setStackPaneSize(double width, double height) {
        defintion.setPrefWidth(width);
        defintion.setPrefHeight(height);
    }
}
