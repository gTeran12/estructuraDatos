/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.rentacar;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

/**
 *
 * @author Hackzll
 */
public class EditarVehiculoController {

    @FXML
    private Label lbMarca;
    @FXML
    private ComboBox<?> cbMarca;
    @FXML
    private Label lbModelo;
    @FXML
    private ComboBox<?> cbModelo;
    @FXML
    private Label lbprecio;
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
    private Label lbPlaca;
    @FXML
    private TextField txtPlaca;
    @FXML
    private Label lbImagen;
    @FXML
    private ImageView ivVehiculo;
    @FXML
    private Button btCancelar;
    @FXML
    private Button btGuardar;
    @FXML
    private Label lbanio;
    @FXML
    private TextField txtanio;
    @FXML
    private Label lbTransmision1;
    @FXML
    private ComboBox<?> cbMotor;
    @FXML
    private Label lbKilometraje1;
    @FXML
    private TextField txtPeso;
    @FXML
    private Label lbAccidentes;
    @FXML
    private TextField txtAccidente;
    @FXML
    private ImageView addAccidente;
    @FXML
    private TableView<?> tbViewAccidentes;
    @FXML
    private TableColumn<?, ?> tbColumnAccidentes;
    @FXML
    private Label lbServicios;
    @FXML
    private TextField txtServicio;
    @FXML
    private ImageView addServicio;
    @FXML
    private TableView<?> tbViewServicios;
    @FXML
    private TableColumn<?, ?> tbColumnservicios;
    @FXML
    private Button btAddImagen;

    @FXML
    private void cancelar(ActionEvent event) {
    }

    @FXML
    private void guardar(ActionEvent event) {
    }

    @FXML
    private void cargarImagen(ActionEvent event) {
    }
    
}
