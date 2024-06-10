/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.rentacar;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;
/**
 * FXML Controller class
 *
 * @author guill
 */
public class VerVehiculosController implements Initializable {


    @FXML
    private Button btSalir;
    @FXML
    private Label lbMarca;
    @FXML
    private Label lbModelo;
    @FXML
    private Label lbprecio;
    @FXML
    private TextField txtPrecioMinimo;
    @FXML
    private Label lbprecio1;
    @FXML
    private TextField txtPrecioMaximo;
    @FXML
    private TableColumn<?, ?> tbColumnPlaca;
    @FXML
    private TableColumn<?, ?> tbColumnModelo;
    @FXML
    private TableColumn<?, ?> tbColumnMarca;
    @FXML
    private TableColumn<?, ?> tbColumnKilometraje;
    @FXML
    private TableColumn<?, ?> tbColumnPrecio;
    @FXML
    private TableColumn<?, ?> tbColumnUbicacion;
    @FXML
    private Label lbprecio2;
    @FXML
    private TextField txtKilometrajeMinimo;
    @FXML
    private Label lbprecio11;
    @FXML
    private TextField txtKilometrajeMaximo;
    @FXML
    private ComboBox<String> cbMarcaNew;
    @FXML
    private ComboBox<String> cbModeloNew;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    @FXML
    private void volverAlMenu() {
        btSalir.setOnAction((t) -> {
            try {
                App.setRoot("primary");
            } catch (IOException ex) {
                Logger.getLogger(SecondaryController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        
        
    }

}
