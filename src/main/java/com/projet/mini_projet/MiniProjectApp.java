package com.projet.mini_projet;

import com.projet.mini_projet.DAO.DBConnection;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MiniProjectApp extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MiniProjectApp.class.getResource("ViewCustomerScreen.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1020, 768);
        stage.setTitle("ERP Commande");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        DBConnection.startConnection();// Connect to MySQL DB
        launch();
        DBConnection.closeConnection(); // Disconnect from MySQL DB
    }
}