package com.mycompany.rentacar;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */


import Clases.Tipo;
import Clases.Transmision;
import com.mycompany.rentacar.App;
import com.mycompany.rentacar.clases.ArrayList;
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
    private ComboBox<String> cbTipo;
    @FXML
    private TextField txtPrecio;
    @FXML
    private Label lbKilometraje;
    @FXML
    private TextField txtKilometraje;
    @FXML
    private Label lbTransmision;
    @FXML
    private ComboBox<String> cbTransmision;
    @FXML
    private Label lbUbicacion;
    @FXML
    private ComboBox<String> cbUbicacion;
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
    
    private ArrayList<Tipo> etiquetaTipo = new ArrayList<>();
    private ArrayList<Transmision> etiquetaTransmision = new ArrayList<>();
    @FXML
    private Label lbanio;
    @FXML
    private TextField txtanio;
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        cargarDatos();
        cargarCombobox();
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
    private void guardar() {
        btGuardar.setOnAction((t)->{
        });
    }
    
    public void cargarDatos(){
        if(etiquetaTipo.isEmpty() && etiquetaTransmision.isEmpty()){
            //TIPO
            etiquetaTipo.add(new Tipo("Pesado"));
            etiquetaTipo.add(new Tipo("Liviano"));
            etiquetaTipo.add(new Tipo("Extra Pesado2"));
            //TRANSMISION
            etiquetaTransmision.add(new Transmision("Manual"));
            etiquetaTransmision.add(new Transmision("Automatica"));
            //Accidentes
            
        }
        
        
    }
    
    public void cargarCombobox(){
        if (cbTipo.getItems().isEmpty()){
            for (Tipo tipo: etiquetaTipo){
                cbTipo.getItems().add(tipo.getNombre());
            }
        }if (cbTransmision.getItems().isEmpty()){
            for (Transmision transmision: etiquetaTransmision){
                cbTransmision.getItems().add(transmision.getNombre());
                
            }
        }
    }

}
