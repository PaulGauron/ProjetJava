package com.projet.mot_fleche.Controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;

public class GrilleController {


        @FXML
        private GridPane gridPane;

        public void initializeGrid(int rows, int cols) {
            gridPane.getChildren().clear();
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    Button cell = new Button("(" + i + ", " + j + ")");
                    gridPane.add(cell, j, i);
                }
            }
        }
    }

