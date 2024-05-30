package com.mycompany.rentacar;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */


import com.mycompany.rentacar.App;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
/**
 * FXML Controller class
 *
 * @author guill
 */
public class CrearVehiculoController implements Initializable {


    @FXML
    private Label lbMarca;
    @FXML
    private ComboBox<?> cbMarca;
    @FXML
    private Label lbModelo;
    @FXML
    private ComboBox<?> cbModelo;
    @FXML
    private Label lbTipo;
    @FXML
    private ComboBox<?> cbTipo;
    @FXML
    private TextField txtPrecio;
    @FXML
    private Label lbKilometraje;
    @FXML
    private TextField txtKilometraje;
    @FXML
    private Label lbTransmision;
    @FXML
    private ComboBox<?> cbTransmision;
    @FXML
    private Label lbUbicacion;
    @FXML
    private ComboBox<?> cbUbicacion;
    @FXML
    private Label lbAccidentes;
    @FXML
    private ComboBox<?> cbAccidentes;
    @FXML
    private Label lbPlaca;
    @FXML
    private TextField txtPlaca;
    @FXML
    private Label lbDescripcion;
    @FXML
    private TextArea txtDescripcion;
    @FXML
    private Button btCancelar;
    @FXML
    private Button btGuardar;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    @FXML
    private void cancelar() {
        btCancelar.setOnAction((t)->{
            try {
                App.setRoot("primary");
            } catch (IOException ex) {
                Logger.getLogger(CrearVehiculoController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }

    @FXML
    private void guardar(MouseEvent event) {
    }

}
