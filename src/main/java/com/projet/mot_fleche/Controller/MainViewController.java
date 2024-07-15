package com.projet.mot_fleche.Controller;

import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MainViewController {

    private Parent root;
    private Scene scene;
    private Stage stage;

    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }

    @FXML
    protected void onGrilleCarreButton(ActionEvent event) throws IOException{
        try {
            /*FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/projet/mot_fleche/GrilleView.fxml"));
            Parent root = fxmlLoader.load(); */

            root =  FXMLLoader.load(getClass().getResource("/com/projet/mot_fleche/GrilleView.fxml"));

            // Passer des paramètres au contrôleur de la nouvelle vue
           /* GrilleController grille = fxmlLoader.getController();
            grille.initializeGrid(5, 5);  //créer une grille 5x5

            Stage stage = new Stage();*/
            stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
            stage.setTitle("Grille");
            scene  = new Scene(root);
            stage.setScene(scene);
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