package com.projet.mot_fleche;


import com.projet.mot_fleche.Fichier;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.application.Application;


import java.io.IOException;


public class Start extends Application{

	public static void  test(){
		Fichier fichier = new Fichier();
		fichier.printMots();
	}

	@Override
	public void start(Stage stage) throws IOException {
		test();
		/*FXMLLoader fxmlLoader = new FXMLLoader(Start.class.getResource("hello-view.fxml"));
		Scene scene = new Scene(fxmlLoader.load(), 320, 240);
		stage.setTitle("Hello!");
		stage.setScene(scene);
		stage.show();*/
	}

	public static void main(String[] args) {  launch();	}

}
