package com.projet.mot_fleche;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class GridPaneExample extends Application {

    private static final int GRID_SIZE = 3; // Example grid size

    @Override
    public void start(Stage primaryStage) {
        GridPane gridPane = new GridPane();

        for (int row = 0; row < GRID_SIZE; row++) {
            for (int col = 0; col < GRID_SIZE; col++) {
                StackPane cell = createCell(row, col);
                gridPane.add(cell, col, row);
            }
        }

        Scene scene = new Scene(gridPane, 300, 300);
        primaryStage.setTitle("Clickable Grid Example");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private StackPane createCell(int row, int col) {
        StackPane cell = new StackPane();
        cell.setPrefSize(100, 100);
        cell.setStyle("-fx-border-color: black; -fx-background-color: lightgray;");

        // Create a ContextMenu
        ContextMenu contextMenu = new ContextMenu();
        MenuItem option1 = new MenuItem("Option 1");
        MenuItem option2 = new MenuItem("Option 2");

        // Add actions to the menu items
        option1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                showAlert("Option 1 selected for cell (" + row + ", " + col + ")");
            }
        });

        option2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                showAlert("Option 2 selected for cell (" + row + ", " + col + ")");
            }
        });

        contextMenu.getItems().addAll(option1, option2);

        // Set right-click event handler
        cell.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if (event.getButton() == MouseButton.SECONDARY) {
                    contextMenu.show(cell, event.getScreenX(), event.getScreenY());
                }
            }
        });

        return cell;
    }

    private void showAlert(String message) {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Information");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
