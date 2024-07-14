package com.projet.mot_fleche.Controller;

import javafx.scene.control.Label;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MainViewController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }

    @FXML
    protected void onGrilleCarreButton(){
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/projet/mot_fleche/GrilleView.fxml"));
            Parent root = fxmlLoader.load();

            // Passer des paramètres au contrôleur de la nouvelle vue
            GrilleController gridController = fxmlLoader.getController();
            gridController.initializeGrid(5, 5);  // Par exemple, créer une grille 5x5

            Stage stage = new Stage();
            stage.setTitle("Grille");
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    @FXML
    protected void onGrilleRectangleButton(){ }

    @FXML
    protected void onRechercheButton(){ }
}