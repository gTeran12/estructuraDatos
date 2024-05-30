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
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import javafx.scene.control.Button;
/**
 * FXML Controller class
 *
 * @author guill
 */
public class SecondaryController implements Initializable {


    @FXML
    private Button btCliente;
    @FXML
    private Button vehiculo;
    @FXML
    private Button btSalir;
    @FXML
    private Button btRentar;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    @FXML
    private void accederCliente() {
        btCliente.setOnAction((t)->{
            try {
                App.setRoot("crearCliente");
            } catch (IOException ex) {
                Logger.getLogger(SecondaryController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }

    @FXML
    private void accederVehiculo() {
        vehiculo.setOnMouseClicked((t)->{
            try {
                App.setRoot("crearVehiculo");
            } catch (IOException ex) {
                Logger.getLogger(SecondaryController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }

    @FXML
    private void salir() {
        btSalir.setOnAction((t)->{
            try {
                App.setRoot("primary");
            } catch (IOException ex) {
                Logger.getLogger(SecondaryController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }

    @FXML
    private void accederRentar() {
        
    }

}
