package com.projet.mot_fleche.Controller;

import com.projet.mot_fleche.classes.Definition;
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

    private int nbDef = 1;

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
                grille.setIdCase(i, j, 1);
                Definition def = new Definition("Hallo", "HD", 0);
                setContextMenu(def,i,j,1);
                gridPaneRectangle.add(def.getStackpane(), j, i);
                nbDef++;
                System.out.println("nbDef: " + nbDef);
            }
        });
        return cell;
    }

    private void setContextMenu(Definition def, int i, int j, int nbMenu) {
        ContextMenu contextMenu = new ContextMenu();
        MenuItem option1 = new MenuItem("ajouter definition");
        MenuItem option2 = new MenuItem("supprimer definition");
        contextMenu.getItems().addAll(option1, option2);
        def.getStackpane().setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if (event.getButton() == MouseButton.PRIMARY) {
                    contextMenu.show(def.getStackpane(), event.getScreenX(), event.getScreenY());
                }
            }
        });
        // Add actions to the menu items
        option1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                addAdditionalDefinition(def, i, j);
                nbDef++;
                System.out.println("nbDef: " + nbDef);
            }
        });
        // Add actions to the menu items
        option2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                def.supprimer();
                grille.setIdCase(i, j, 0);
                StackPane reset = createCell(i,j);
                gridPaneRectangle.add(reset, j, i);
                nbDef--;
            }
        });
    }

    private void addAdditionalDefinition(Definition existingDefinition, int i, int j) {
        grille.setIdCase(i, j, 2);
        Definition additionalDef = new Definition("Additional", "VD", 1);
        additionalDef.setStackPaneSize(40,40);
        // Set up the context menu for the additional definition
        ContextMenu contextMenu = new ContextMenu();
        MenuItem option1 = new MenuItem("supprimer definition 1");
        MenuItem option2 = new MenuItem("supprimer definition 2");
        MenuItem option3 = new MenuItem("supprimer toutes les definitions");
        contextMenu.getItems().addAll(option1, option2,option3);
        additionalDef.getStackpane().setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if (event.getButton() == MouseButton.PRIMARY) {
                    contextMenu.show(additionalDef.getStackpane(), event.getScreenX(), event.getScreenY());
                }
            }
        });
        option1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                existingDefinition.supprimer();
                grille.setIdCase(i,j,1);
                setContextMenu(additionalDef,i,j,1);
                gridPaneRectangle.add(additionalDef.getStackpane(), j, i);
                nbDef--;
            }
        });
        option2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                additionalDef.supprimer();
                grille.setIdCase(i, j, 1);
                setContextMenu(existingDefinition,i,j,1);
                gridPaneRectangle.add(existingDefinition.getStackpane(), j, i);
                nbDef--;
            }
        });
        option3.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                grille.setIdCase(i,j,0);
                additionalDef.supprimer();
                existingDefinition.supprimer();
                StackPane resetCase = createCell(i,j);
                gridPaneRectangle.add(resetCase,j,i);
                nbDef-=2;
            }

        });

        // Create a new StackPane to hold both definitions
        StackPane combinedStackPane = new StackPane();
        combinedStackPane.getChildren().addAll(existingDefinition.getStackpane(), additionalDef.getStackpane());
        gridPaneRectangle.add(combinedStackPane, j, i);
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
