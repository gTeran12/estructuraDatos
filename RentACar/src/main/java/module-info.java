module com.mycompany.rentacar {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;
    requires java.logging;

    opens com.mycompany.rentacar to javafx.fxml;
    exports com.mycompany.rentacar;
}
