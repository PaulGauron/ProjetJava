module com.projet.mot_fleche {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.projet.mot_fleche to javafx.fxml;
    exports com.projet.mot_fleche;
}