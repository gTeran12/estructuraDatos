module com.mycompany.rentacar {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;
    requires java.logging;

    opens com.mycompany.rentacar to javafx.fxml;
    opens Clases to javafx.base;
    exports com.mycompany.rentacar;
}
