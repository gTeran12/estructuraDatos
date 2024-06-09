/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.rentacar;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.image.ImageView;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.image.ImageView;
/**
 * FXML Controller class
 *
 * @author guill
 */
public class VerVehiculoController implements Initializable {


    @FXML
    private Label lbPlaca;
    @FXML
    private ImageView imagenVehiculo;
    @FXML
    private ImageView previewPage;
    @FXML
    private ImageView nextPage;
    @FXML
    private Label lbAnio;
    @FXML
    private Label lbUbicacion;
    @FXML
    private Label lbPrecioFijo;
    @FXML
    private Label lbPrecio;
    @FXML
    private Label lbKilometraje;
    @FXML
    private TableView<?> tbViewServicios;
    @FXML
    private TableColumn<?, ?> tbColumnservicios;
    @FXML
    private TableView<?> tbViewAccidentes;
    @FXML
    private TableColumn<?, ?> tbColumnAccidentes;
    @FXML
    private Button btEditar;
    @FXML
    private Button btEliminar;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    @FXML
    private void editarVehiculo() {
        btEditar.setOnMouseClicked((t) -> {
            //TODO metodo para editar un vehiculo
        });
    }

    @FXML
    private void eliminarVehiculo( ) {
        btEliminar.setOnMouseClicked((t) -> {
            //TODO metodo para eliminar vehiculo
        });
    }

}
