package com.projet.mot_fleche.classes;

import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;

public class Definition {
    private String intitule;
    private String direction;
    private MenuButton menuButton;

    public Definition(String intitule, String direction) {
        this.intitule = intitule;
        this.direction = direction;
        this.menuButton = new MenuButton(intitule);
        initializeMenuButton();
    }

    private void initializeMenuButton() {
        MenuItem optionA = new MenuItem("Ajouter définition");
        MenuItem optionB = new MenuItem("Supprimer définition");

        optionA.setOnAction(e -> ajouter());
        optionB.setOnAction(e -> supprimer());

        menuButton.getItems().addAll(optionA, optionB);
    }

    public MenuButton getMenuButton() {
        return menuButton;
    }

    public void ajouter() {
        System.out.println("Définition ajoutée : " + intitule + ", " + direction);
        // Code pour ajouter l'objet definition
    }

    public void supprimer() {
        System.out.println("Définition supprimée : " + intitule + ", " + direction);
        // Code pour supprimer l'objet definition
    }

    public void setMenuButtonSize(double width, double height) {
        menuButton.setPrefWidth(width);
        menuButton.setPrefHeight(height);
    }
}
