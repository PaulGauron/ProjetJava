package com.projet.mini_projet.controller;

import com.projet.mini_projet.DAO.ClientDAO;
import com.projet.mini_projet.modele.Client;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MiniProfilerController {

    private Stage stage;
    private Parent root;
    private Scene scene;

    @FXML
    private Button refresh;

    @FXML
    private TableView<Client> clientTableView;

    private final ObservableList<Client> Client = FXCollections.observableArrayList();
    private TableView.TableViewSelectionModel<Client> tvSelCustomer;

    @FXML
    void onActionUpdateCustomer(ActionEvent event) {
        if(tvSelCustomer.isEmpty()){
            displayErrorAlert("Select a customer first");
        }
        else{
            com.projet.mini_projet.modele.Client.setClientActuelle(tvSelCustomer.getSelectedItem());
            displayScreen(event, "/View/UpdateCustomerScreen.fxml");
        }
    }

    protected void displayErrorAlert(String errorString){
        Alert alert = new Alert(Alert.AlertType.ERROR, errorString, ButtonType.OK);
        alert.showAndWait();
    }


    // Query the DB to repopulate table
    @FXML
    void onActionRefreshTable(){
        Client.clear();
        try{
            //System.out.println(ClientTableView.getSelectionModel().getSelectedItem());
            Client.add(ClientDAO.getCustomer(1));

        }
        catch(SQLException e){
            Logger.getLogger("errorlog.txt").log(Level.WARNING,null,e);
          //  displayErrorAlert("Error retrieving customers from database");
        }
        clientTableView.getColumns();
       // clientTableView.setItems(Client);
       // tvSelCustomer = ClientTableView.getSelectionModel();
    }

    protected void displayScreen(Event event, String resourcePath) {
        stage = (Stage) ((Control) event.getSource()).getScene().getWindow();
        try {
            root = FXMLLoader.load(getClass().getResource(resourcePath), ResourceBundle.getBundle("fr"));
            scene = new Scene(root, 1060, 720);
            scene.getStylesheets().add("Resources/generalStylesheet.css");
            root.requestFocus();
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    }