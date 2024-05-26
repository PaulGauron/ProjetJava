module com.projet.mini_projet {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires jdk.hotspot.agent;


    opens com.projet.mini_projet to javafx.fxml;
    exports com.projet.mini_projet;
    exports com.projet.mini_projet.controller;
    opens com.projet.mini_projet.controller to javafx.fxml;
}