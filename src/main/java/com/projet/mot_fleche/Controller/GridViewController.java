package com.projet.mot_fleche.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.control.ToggleGroup;
import javafx.scene.paint.Color;

public class GridViewController {

        @FXML
        private MenuButton menuButton;

        @FXML
        private RadioButton item1, item2, item3, item4;

        @FXML
        private GridPane gridPaneCarre;

    private ToggleGroup toggleGroup;


    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    @FXML
    public void initialize() {
        toggleGroup = new ToggleGroup();

        item1.setToggleGroup(toggleGroup);
        item2.setToggleGroup(toggleGroup);
        item3.setToggleGroup(toggleGroup);
        item4.setToggleGroup(toggleGroup);

        item4.setOnAction(event -> setGridvalue(item4));
        item3.setOnAction(event -> setGridvalue(item3));
        item2.setOnAction(event -> setGridvalue(item2));
        item1.setOnAction(event -> setGridvalue(item1));

    }
    private int rows;


    public void setGridvalue(RadioButton selectedItem) {
            String id = selectedItem.getId();
            switch (id) {
                case "item1":
                    setRows(5);
                    System.out.println("item1 selected");
                    break;
                case "item2":
                   setRows(6);
                    break;
                case "item3":
                    setRows(7);
                    break;
                case "item4":
                    setRows(8);
                    break;
            }

    }


    public void createSquareGrid(ActionEvent event){
            //reset de la grille
        gridPaneCarre.getChildren().clear();
              // Create a BorderStroke
              BorderStroke borderStroke = new BorderStroke(
                      Color.GRAY, // border color
                      BorderStrokeStyle.SOLID, // border style
                      new CornerRadii(15), // corner radii
                      new BorderWidths(5) // border widths
              );
              BorderStroke borderStrokeCase = new BorderStroke(
                      Color.LIGHTGRAY, // border color
                      BorderStrokeStyle.SOLID, // border style
                      new CornerRadii(7.5), // corner radii
                      new BorderWidths(5) // border widths
              );
            int rows = getRows();
            //random number for definition
              int randomY = (int)(Math.random()*rows);
              int randomX = (int)(Math.random()*rows);


            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < rows; j++) {
                    TextField cell = new TextField();

                    cell.setMinSize(100, 100);
                    cell.setBorder(new Border(borderStrokeCase));
                    gridPaneCarre.setPadding(new Insets(5, 5, 5, 5));
                    gridPaneCarre.setBorder(new Border(borderStroke));
                    gridPaneCarre.add(cell, j, i);


                }
            }
            Button definition = new Button("Definition");
            definition.setMinSize(80, 80);
            definition.setAlignment(Pos.CENTER);
            gridPaneCarre.add(definition, randomX, randomY);
    }
}


