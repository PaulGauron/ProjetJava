package com.projet.mot_fleche.Controller;


import com.projet.mot_fleche.classes.Definition;
import com.projet.mot_fleche.classes.ModelGrille;
import com.projet.mot_fleche.classes.Mot;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.control.ToggleGroup;
import javafx.scene.paint.Color;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;

import java.util.*;


public class GridViewController {

    @FXML
    private MenuButton menuButton;

    @FXML
    private RadioButton id5x5, id6x6, id7x7, id8x8;

    @FXML
    private GridPane gridPaneCarre;

    @FXML
    private Button generateButton;

    private int nbDef = 1;


    @FXML
    public void initialize() {
        ToggleGroup toggleGroup = new ToggleGroup();

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
        grille.setModele(new int[row][row]);
        grille.setLargeur(row);
        grille.initializeModel(row);
    }


    private StackPane createCell(int i, int j) {
        BorderStroke borderStrokeCase = new BorderStroke(
                Color.rgb(110, 107, 107), // border color
                BorderStrokeStyle.SOLID, // border style
                new CornerRadii(7.5), // corner radii
                new BorderWidths(5) // border widths
        );

        StackPane cell = new StackPane();
        cell.setMinSize(100, 100);
        cell.setBorder(new Border(borderStrokeCase));
        ContextMenu contextMenu = new ContextMenu();
        MenuItem option1 = new MenuItem("ajouter definition");
        contextMenu.getItems().addAll(option1);
        cell.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if (event.getButton() == MouseButton.PRIMARY && nbDef < 6) {
                    contextMenu.show(cell, event.getScreenX(), event.getScreenY());
                }
            }
        });

        // Add actions to the menu items
        option1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (i == (grille.getLargeur() - 1) && j == (grille.getLargeur() - 1)) {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Information");
                    alert.setHeaderText(null);
                    alert.setContentText("Impossible d'ajouté une définition ici");
                } else {
                    Definition def = new Definition("Hallo", "", 0);
                    setDirection(def, i, j, contextMenu);
                }
            }
        });
        return cell;
    }

    private void setContextMenu(Definition def, int i, int j) {
        ContextMenu contextMenu = new ContextMenu();
        VBox vbox = new VBox();
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
                setDirection(def, i, j, contextMenu);

            }
        });
        // Add actions to the menu items
        option2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                def.supprimer();
                grille.setIdCase(i, j, 0);
                StackPane reset = createCell(i, j);
                gridPaneCarre.add(reset, j, i);
                nbDef--;
            }
        });

        if (grille.getIdCase(i, j) == 2) {
            def.setStackPaneSize(50, 50);
            contextMenu.getItems().remove(0, contextMenu.getItems().size());
            Definition additionalDef = new Definition("Additional", "VD", 1);
            additionalDef.setStackPaneSize(50, 50);
            // Set up the context menu for the additional definition
            MenuItem optionSupr1 = new MenuItem("supprimer definition 1");
            MenuItem optionSupr2 = new MenuItem("supprimer definition 2");
            MenuItem optionSupr3 = new MenuItem("supprimer toutes les definitions");
            contextMenu.getItems().addAll(optionSupr1, optionSupr2, optionSupr3);
            int caseNb = (j + 1 + i * 5) - 1;
            //System.out.println("i: " + i+" j: " + j + "case :" + caseNb);
            gridPaneCarre.getChildren().get(caseNb).setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    if (event.getButton() == MouseButton.PRIMARY) {
                        contextMenu.show(additionalDef.getStackpane(), event.getScreenX(), event.getScreenY());
                    }
                }
            });
            optionSupr1.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    def.supprimer();
                    grille.setIdCase(i, j, 1);
                    setContextMenu(additionalDef, i, j);
                    gridPaneCarre.add(additionalDef.getStackpane(), j, i);
                    nbDef--;
                }
            });
            optionSupr2.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    additionalDef.supprimer();
                    grille.setIdCase(i, j, 1);
                    setContextMenu(def, i, j);
                    gridPaneCarre.add(def.getStackpane(), j, i);
                    nbDef--;
                }
            });
            optionSupr3.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    grille.setIdCase(i, j, 0);
                    additionalDef.supprimer();
                    def.supprimer();
                    StackPane resetCase = createCell(i, j);
                    gridPaneCarre.add(resetCase, j, i);
                    nbDef -= 2;
                }

            });

            // Create a new StackPane to hold both definitions

            vbox.getChildren().addAll(def.getStackpane(), additionalDef.getStackpane());
            gridPaneCarre.add(vbox, j, i);
            nbDef++;
            System.out.println("nbDef: " + nbDef);
        }
    }


    private void setDirection(Definition def, int i, int j, ContextMenu direction) {
        direction.getItems().remove(0, direction.getItems().size());
        Image image = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/com/projet/mot_fleche/images/fleche_VI.png")));
        Image image2 = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/com/projet/mot_fleche/images/fleche_VD.png")));
        Image image3 = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/com/projet/mot_fleche/images/fleche_HI.png")));
        Image image4 = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/com/projet/mot_fleche/images/fleche_HD.png")));
        ImageView imageView = new ImageView(image);
        ImageView imageView2 = new ImageView(image2);
        ImageView imageView3 = new ImageView(image3);
        ImageView imageView4 = new ImageView(image4);
        MenuItem option1 = new MenuItem("fleche VI", imageView);
        MenuItem option2 = new MenuItem("fleche VD", imageView2);
        MenuItem option3 = new MenuItem("fleche HI", imageView3);
        MenuItem option4 = new MenuItem("fleche HD", imageView4);
        System.out.println("i :" + i + " j: " + j + " max : " + (grille.getLargeur() - 1));
        if (i == (grille.getLargeur() - 1)) {
            direction.getItems().add(option4);
        } else if (j == (grille.getLargeur() - 1)) {
            direction.getItems().add(option2);
        } else {
            direction.getItems().addAll(option1, option2, option3, option4);
        }
        def.getStackpane().setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if (event.getButton() == MouseButton.PRIMARY) {
                    direction.show(def.getStackpane(), event.getScreenX(), event.getScreenY());
                }
            }
        });
        option1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("fleche vi selected + idcase :" + grille.getIdCase(i, j));
                def.setDirection("VI");
                StackPane.setAlignment(imageView, javafx.geometry.Pos.TOP_CENTER);
                gridPaneCarre.add(imageView, j + 1, i);
                if (grille.getIdCase(i, j) == 0) {
                    setContextMenu(def, i, j);
                    gridPaneCarre.add(def.getStackpane(), j, i);
                    nbDef++;
                    grille.setIdCase(i, j, 1);
                    System.out.println("nbDef: " + nbDef);
                } else {
                    grille.setIdCase(i, j, 2);
                    setContextMenu(def, i, j);
                }

            }
        });
        option2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("fleche vd selected + idcase :" + grille.getIdCase(i, j));
                def.setDirection("VD");
                StackPane.setAlignment(imageView2, javafx.geometry.Pos.TOP_CENTER);
                gridPaneCarre.add(imageView2, j, i + 1);
                if (grille.getIdCase(i, j) == 0) {
                    setContextMenu(def, i, j);
                    gridPaneCarre.add(def.getStackpane(), j, i);
                    nbDef++;
                    grille.setIdCase(i, j, 1);
                    System.out.println("nbDef: " + nbDef);
                } else {
                    grille.setIdCase(i, j, 2);
                    setContextMenu(def, i, j);
                }
            }
        });
        option3.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("fleche hi selected + idcase :" + grille.getIdCase(i, j));
                def.setDirection("HI");
                StackPane.setAlignment(imageView3, javafx.geometry.Pos.TOP_CENTER);
                gridPaneCarre.add(imageView3, j, i + 1);
                if (grille.getIdCase(i, j) == 0) {
                    setContextMenu(def, i, j);
                    gridPaneCarre.add(def.getStackpane(), j, i);
                    nbDef++;
                    grille.setIdCase(i, j, 1);
                    System.out.println("nbDef: " + nbDef);
                } else {
                    grille.setIdCase(i, j, 2);
                    setContextMenu(def, i, j);
                }
            }
        });
        option4.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("fleche hd selected + idcase :" + grille.getIdCase(i, j));
                def.setDirection("HD");
                StackPane.setAlignment(imageView4, javafx.geometry.Pos.TOP_CENTER);
                gridPaneCarre.add(imageView4, j + 1, i);
                if (grille.getIdCase(i, j) == 0) {
                    setContextMenu(def, i, j);
                    gridPaneCarre.add(def.getStackpane(), j, i);
                    nbDef++;
                    grille.setIdCase(i, j, 1);
                    System.out.println("nbDef: " + nbDef);
                } else {
                    grille.setIdCase(i, j, 2);
                    setContextMenu(def, i, j);
                }
            }
        });


    }


    public void generateRandom() {
        // Grille 4

        int[][] grille4 = {
                {2, 4, 2, 4, 1},
                {6, 0, 5, 0, 5},
                {2, 3, 0, 1, 0},
                {6, 0, 0, 5, 0},
                {1, 3, 0, 0, 0}
        };
        grille.setModele(grille4);

        for (int i = 0; i < grille.getLargeur(); i++) {
            for (int j = 0; j < grille.getLargeur(); j++) {
                Definition def = new Definition("definition", "", 0);
                Image image4 = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/com/projet/mot_fleche/images/fleche_HD.png")));
                ImageView imageView4 = new ImageView(image4);
                Image image3 = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/com/projet/mot_fleche/images/fleche_HI.png")));
                ImageView imageView3 = new ImageView(image3);
                Image image2 = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/com/projet/mot_fleche/images/fleche_VI.png")));
                ImageView imageView2 = new ImageView(image2);
                Image image = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/com/projet/mot_fleche/images/fleche_VD.png")));
                ImageView imageView = new ImageView(image);
                if (grille.getIdCase(i, j) == 1) {
                    gridPaneCarre.add(def.getStackpane(), j, i);
                    setContextMenu(def, i, j);
                } else if (grille.getIdCase(i, j) == 2) {
                    gridPaneCarre.add(def.getStackpane(), j, i);
                    setContextMenu(def, i, j);
                }
                if (grille.getIdCase(i, j) == 3) {
                    def.setDirection("HD");
                    gridPaneCarre.add(imageView4, j, i);
                }
                if (grille.getIdCase(i, j) == 4) {
                    def.setDirection("VI");
                    gridPaneCarre.add(imageView2, j, i);

                }
                if (grille.getIdCase(i, j) == 5) {
                    def.setDirection("VD");
                    gridPaneCarre.add(imageView, j, i);
                }
                if (grille.getIdCase(i, j) == 6) {
                    def.setDirection("HI");
                    gridPaneCarre.add(imageView3, j, i);
                }
            }
        }
        grille.completePattern(1,gridPaneCarre);
        nbDef = 9;
        grille.afficher();
        generateButton.setDisable(false);
    }


    public void createSquareGrid(ActionEvent event) {
        //reset de la grille
        gridPaneCarre.getChildren().clear();
        grille.initializeModel(grille.getLargeur());
        nbDef = 1;
        // Create a BorderStroke
        BorderStroke borderStroke = new BorderStroke(
                Color.GRAY, // border color
                BorderStrokeStyle.SOLID, // border style
                new CornerRadii(15), // corner radii
                new BorderWidths(5) // border widths
        );
        //Set grid pane layout
        gridPaneCarre.setPadding(new Insets(5, 5, 5, 5));
        gridPaneCarre.setBorder(new Border(borderStroke));

        for (int i = 0; i < grille.getLargeur(); i++) {
            for (int j = 0; j < grille.getLargeur(); j++) {
                StackPane cell = createCell(i, j);
                gridPaneCarre.add(cell, j, i);
            }
        }
        //grille.afficher();
        generateButton.setVisible(true);
    }
}


