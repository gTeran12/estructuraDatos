module com.mycompany.alquilercarros {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.mycompany.alquilercarros to javafx.fxml;
    exports com.mycompany.alquilercarros;
}
