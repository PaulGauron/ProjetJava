package com.projet.mot_fleche.Controller;

import com.projet.mot_fleche.classes.ModelGrille;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.control.ToggleGroup;
import javafx.scene.paint.Color;

public class RectangleGridViewController {

    @FXML
    private RadioButton id8x6, id8x5, id8x4, id7x5,id7x4,id6x4;

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

        id8x5.setToggleGroup(toggleGroup2);
        id8x4.setToggleGroup(toggleGroup2);
        id8x6.setToggleGroup(toggleGroup2);
        id7x4.setToggleGroup(toggleGroup2);
        id7x5.setToggleGroup(toggleGroup2);
        id6x4.setToggleGroup(toggleGroup2);

        id8x6.setOnAction(event -> setGridvalue(id8x6));
        id8x5.setOnAction(event -> setGridvalue(id8x5));
        id8x4.setOnAction(event -> setGridvalue(id8x4));
        id7x5.setOnAction(event -> setGridvalue(id7x5));
        id7x4.setOnAction(event -> setGridvalue(id7x4));
        id6x4.setOnAction(event -> setGridvalue(id6x4));
    }

    ModelGrille grille = new ModelGrille();

    public void setGridvalue(RadioButton selectedItem) {
        String id = selectedItem.getId();
        int row = Integer.parseInt(id.substring(2,3));
        int col = Integer.parseInt(id.substring(4));
        grille.setLargeur(col);
        grille.setHauteur(row);
        grille.initializeModel(col,row);
       /* switch (id) {
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
        }*/

    }

    private StackPane createCell(int i, int j){
        BorderStroke borderStrokeCase2 = new BorderStroke(
                Color.LIGHTGRAY, // border color
                BorderStrokeStyle.SOLID, // border style
                new CornerRadii(7.5), // corner radii
                new BorderWidths(5) // border widths
        );

        StackPane cell = new StackPane();
        cell.setMinSize(100, 100);
        cell.setBorder(new Border(borderStrokeCase2));
        ContextMenu contextMenu = new ContextMenu();
        MenuItem option1 = new MenuItem("ajouter def");
        contextMenu.getItems().addAll(option1);
        cell.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if (event.getButton() == MouseButton.PRIMARY) {
                    contextMenu.show(cell, event.getScreenX(), event.getScreenY());
                }
            }
        });

        // Add actions to the menu items
        option1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                //System.out.println("("+i+","+j+")"+"case selected");
            }
        });
        return cell;
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
        gridPaneRectangle.setPadding(new Insets(5, 5, 5, 5));
        gridPaneRectangle.setBorder(new Border(borderStroke2));

        //random number for definition
        int randomY = (int)(Math.random()*grille.getLargeur());
        int randomX = (int)(Math.random()*grille.getHauteur());


        for (int i = 0; i < grille.getLargeur(); i++) {
            for (int j = 0; j < grille.getHauteur(); j++) {
                StackPane cell = createCell(i,j);
                gridPaneRectangle.add(cell, j, i);
            }
        }
        Button definition = new Button("Definition");
        gridPaneRectangle.add(definition, randomX, randomY);
    }
}
