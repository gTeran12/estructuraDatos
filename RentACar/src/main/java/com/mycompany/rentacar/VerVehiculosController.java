/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.rentacar;

import Clases.Marca;
import Clases.Transmision;
import com.mycompany.rentacar.clases.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
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
    
    
    
    private ArrayList<Marca> etiquetamarcas = new ArrayList<>();
    private HashMap<String, ArrayList<String>> modelosPorMarca = new HashMap<>();
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        volverAlMenu();
        cargarDatos();
    }    
    
    @FXML
    private void volverAlMenu() {
        btSalir.setOnAction((t) -> {
            try {
                App.setRoot("secondary");
            } catch (IOException ex) {
                Logger.getLogger(SecondaryController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });    
    }
    
    public void cargarDatos() {
        cargarMarcasYModelos();
        cargarModelos();
        cargarComboBox();
    }
    
    private void cargarMarcasYModelos() {
        String archivoMarcasModelos = "src/main/resources/files/marca_modelo.txt";
        try (BufferedReader br = new BufferedReader(new FileReader(archivoMarcasModelos))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(":");
                if (partes.length > 1) {
                    String marca = partes[0].trim();
                    String[] modelos = partes[1].split(",");

                    // Añadir la marca a etiquetasMarcas
                    etiquetamarcas.add(new Marca(marca));

                    // Crear y llenar el ArrayList de modelos
                    ArrayList<String> listaModelos = new ArrayList<>();
                    for (String modelo : modelos) {
                        listaModelos.add(modelo.trim());
                    }

                    // Poner la marca y su lista de modelos en el HashMap
                    modelosPorMarca.put(marca, listaModelos);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    private void cargarModelos(){
        cbMarcaNew.setOnAction((t) -> {
            cargarModelosPorMarca();
        });
    }
    
    //Metodo que carga los modelos por marca al momento que selecciona una marca
    private void cargarModelosPorMarca(){
        String marcaSeleccionada = cbMarcaNew.getValue();
        cbModeloNew.getItems().clear();
        if(marcaSeleccionada != null && modelosPorMarca.containsKey(marcaSeleccionada)){
            cbModeloNew.getItems().addAll(modelosPorMarca.get(marcaSeleccionada));
        }
    }
    public void cargarComboBox(){
        if(cbMarcaNew.getItems().isEmpty()){
            for(Marca marca:etiquetamarcas){
                cbMarcaNew.getItems().add(marca.getNombre());
                
            }
        }
        
    }
    

}
