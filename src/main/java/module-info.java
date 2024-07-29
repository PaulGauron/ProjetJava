module com.projet.mot_fleche {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens com.projet.mot_fleche to javafx.fxml;
    exports com.projet.mot_fleche;
    exports com.projet.mot_fleche.Controller;
    opens com.projet.mot_fleche.Controller to javafx.fxml;
    exports com.projet.mot_fleche.classes;
    opens com.projet.mot_fleche.classes to javafx.fxml;
}