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
import java.util.Objects;

public class MainViewController {

    //private Parent root;
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
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/projet/mot_fleche/GridView.fxml"));
            Parent root = fxmlLoader.load();

            //root =  FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/com/projet/mot_fleche/GridView.fxml")));

            // Passer des paramètres au contrôleur de la nouvelle vue


            Stage stage = new Stage();
            //stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            stage.setTitle("Grille");
            scene  = new Scene(root,1080,980);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    @FXML
    protected void onGrilleRectangleButton(){
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/projet/mot_fleche/GridViewRectangle.fxml"));
            Parent root = fxmlLoader.load();

            Stage stage = new Stage();
            stage.setTitle("Grille Rectangle");
            scene  = new Scene(root,1080,980);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    protected void onRechercheButton(){ }
}