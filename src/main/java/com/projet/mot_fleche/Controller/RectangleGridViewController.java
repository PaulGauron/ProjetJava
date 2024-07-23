package com.projet.mot_fleche.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.control.ToggleGroup;
import javafx.scene.paint.Color;

public class RectangleGridViewController {

    @FXML
    private RadioButton item5, item6, item7, item8,item9,item10;

    @FXML
    private GridPane gridPaneRectangle;

    private ToggleGroup toggleGroup2;

    public int getCols() {
        return cols;
    }

    public void setCols(int cols) {
        this.cols = cols;
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    private int rows;
    private int cols;

    @FXML
    public void initialize(){
        toggleGroup2 = new ToggleGroup();

        item5.setToggleGroup(toggleGroup2);
        item6.setToggleGroup(toggleGroup2);
        item7.setToggleGroup(toggleGroup2);
        item8.setToggleGroup(toggleGroup2);
        item9.setToggleGroup(toggleGroup2);
        item10.setToggleGroup(toggleGroup2);

        item5.setOnAction(event -> setGridvalue(item5));
        item6.setOnAction(event -> setGridvalue(item6));
        item7.setOnAction(event -> setGridvalue(item7));
        item8.setOnAction(event -> setGridvalue(item8));
        item9.setOnAction(event -> setGridvalue(item9));
        item10.setOnAction(event -> setGridvalue(item10));
    }

    public void setGridvalue(RadioButton selectedItem) {
        String id = selectedItem.getId();
        switch (id) {
            case "item5":
                setCols(8);
                setRows(4);
                break;
            case "item6":
                setCols(8);
                setRows(5);
                break;
            case "item7":
                setCols(8);
                setRows(6);
                break;
            case "item8":
                setCols(7);
                setRows(4);
                break;
            case "item9":
                setCols(7);
                setRows(5);
                break;
            case "item10":
                setCols(6);
                setRows(4);
                break;
        }

    }

    public void createRectangleGrid(ActionEvent event){
        //reset de la grille
        gridPaneRectangle.getChildren().clear();
        // Create a BorderStroke
        BorderStroke borderStroke2 = new BorderStroke(
                Color.GRAY, // border color
                BorderStrokeStyle.SOLID, // border style
                new CornerRadii(15), // corner radii
                new BorderWidths(5) // border widths
        );
        BorderStroke borderStrokeCase2 = new BorderStroke(
                Color.LIGHTGRAY, // border color
                BorderStrokeStyle.SOLID, // border style
                new CornerRadii(7.5), // corner radii
                new BorderWidths(5) // border widths
        );
        int rows = getRows();
        int cols = getCols();
        //random number for definition
        int randomY = (int)(Math.random()*rows);
        int randomX = (int)(Math.random()*cols);


        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                TextField cell = new TextField();

                cell.setMinSize(100, 100);
                cell.setBorder(new Border(borderStrokeCase2));
                gridPaneRectangle.setPadding(new Insets(5, 5, 5, 5));
                gridPaneRectangle.setBorder(new Border(borderStroke2));
                gridPaneRectangle.add(cell, j, i);


            }
        }
        Button definition = new Button("Definition");
        gridPaneRectangle.add(definition, randomX, randomY);
    }
}
