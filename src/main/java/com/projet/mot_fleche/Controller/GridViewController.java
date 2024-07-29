package com.projet.mot_fleche.Controller;


import com.projet.mot_fleche.classes.Definition;
import com.projet.mot_fleche.classes.ModelGrille;
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
        private RadioButton id5x5, id6x6, id7x7, id8x8;

        @FXML
        private GridPane gridPaneCarre;

    private ToggleGroup toggleGroup;


    @FXML
    public void initialize() {
        toggleGroup = new ToggleGroup();

        id5x5.setToggleGroup(toggleGroup);
        id6x6.setToggleGroup(toggleGroup);
        id7x7.setToggleGroup(toggleGroup);
        id8x8.setToggleGroup(toggleGroup);

        id5x5.setOnAction(event -> setGridvalue(id5x5));
        id6x6.setOnAction(event -> setGridvalue(id6x6));
        id7x7.setOnAction(event -> setGridvalue(id7x7));
        id8x8.setOnAction(event -> setGridvalue(id8x8));

    }
    ModelGrille grille = new ModelGrille();


    public void setGridvalue(RadioButton selectedItem) {
            String id = selectedItem.getId();

            int row = Integer.parseInt(id.substring(4));
           /* switch (id) {
                case "item1":
                    System.out.println("item1 selected " + row);
                    break;
                case "item2":
                    System.out.println("item2 selected" + row);
                    break;
                case "item3":System.out.println("item3 selected" + row);
                    break;
                case "item4":
                    System.out.println("item4 selected" + row);
                    break;
            }*/
       grille.setLargeur(row);
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
                      Color.rgb(110,107,107), // border color
                      BorderStrokeStyle.SOLID, // border style
                      new CornerRadii(7.5), // corner radii
                      new BorderWidths(5) // border widths
              );

            //random number for definition
              int randomY = (int)(Math.random()*grille.getLargeur());
              int randomX = (int)(Math.random()*grille.getLargeur());


            for (int i = 0; i < grille.getLargeur(); i++) {
                for (int j = 0; j < grille.getLargeur(); j++) {
                    TextField cell = new TextField();
                    cell.setDisable(true);
                    cell.setMinSize(100, 100);
                    cell.setBorder(new Border(borderStrokeCase));
                    gridPaneCarre.setPadding(new Insets(5, 5, 5, 5));
                    gridPaneCarre.setBorder(new Border(borderStroke));
                    gridPaneCarre.add(cell, j, i);


                }
            }
        Definition def = new Definition("definition","HorizontalIndirect");
            def.setMenuButtonSize(90,80);
            gridPaneCarre.add(def.getMenuButton(), randomX, randomY);
    }
}


