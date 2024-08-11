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
    private  String intitule;

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    private  String direction;
    private  int id;
    private  Label DefLabel;
    private StackPane defintion;


    public Definition(String intitule, String direction,int id) {
        this.intitule = intitule;
        this.direction = direction;
        this.id = id;
        initializeStackpane();
    }


    private void initializeStackpane() {
        this.DefLabel = new Label(this.intitule);
        this.defintion = new StackPane(this.DefLabel);
        setStackPaneSize(80,80);
        DefLabel.setStyle("-fx-text-fill: white;");
        if(this.id == 0) {
            this.defintion.setBackground(Background.fill(Color.BLACK));
        }else{
            this.defintion.setBackground(Background.fill(Color.BLUE));
        }
        }

    public StackPane getStackpane() {
        return defintion;
    }

    public void ajouter() {
        System.out.println("Définition ajoutée : " + intitule + ", " + direction);
    }

    public void supprimer() {
        defintion.getChildren().remove(DefLabel);
        defintion.setBackground(Background.fill(Color.WHITE));
    }

    public void setStackPaneSize(double width, double height) {
        this.defintion.setMinWidth(width);
        this.defintion.setMinHeight(height);
    }
}
