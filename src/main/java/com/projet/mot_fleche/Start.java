package com.projet.mot_fleche;


import com.projet.mot_fleche.Fichier;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.application.Application;


import java.io.IOException;
import java.util.Objects;


public class Start extends Application{

	public static void  test(){
		Fichier fichier = new Fichier();
		fichier.printMotsDebut("s");
	}

	@Override
	public void start(Stage primaryStage) throws IOException {
		Parent root =  FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/com/projet/mot_fleche/MainView.fxml")));
		primaryStage.setTitle("Accueil");
		Scene scene = new Scene(root, 800, 600);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {  launch();	}

}
