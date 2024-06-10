/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.rentacar;

import Clases.Marca;
import Clases.Modelo;
import Clases.Transmision;
import Clases.Vehiculo;
import com.mycompany.rentacar.clases.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
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
    private TableColumn<String, String> tbColumnPlaca;
    @FXML
    private TableColumn<String, String> tbColumnModelo;
    @FXML
    private TableColumn<String, String> tbColumnMarca;
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
     @FXML
    private TableView<Vehiculo> tableViewVehiculos;
    
    
    private ArrayList<Marca> etiquetamarcas = new ArrayList<>();
    private HashMap<String, ArrayList<String>> modelosPorMarca = new HashMap<>();
    private ArrayList<Vehiculo> vehiculos = new ArrayList<>();
    private ObservableList<Vehiculo> vehiculosData = FXCollections.observableArrayList();

    @FXML
    private Button btBuscar;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        volverAlMenu();
        cargarDatos();
        cargarVehiculosDesdeArchivo();
        configurarTabla();
        configurarFiltros();
        
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
    
    private void cargarVehiculosDesdeArchivo() {
        String archivoVehiculos = "src/main/resources/files/vehiculos.txt";
        try (BufferedReader br = new BufferedReader(new FileReader(archivoVehiculos))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(":");
                if (partes.length > 1) {
                    Vehiculo vehiculo = new Vehiculo();
                    vehiculo.setPlaca(partes[0]);

                    String[] datos = partes[1].split("\\|");
                    vehiculo.setMarca(datos[0]);
                    vehiculo.setModelo(new Modelo(datos[1]));
                    vehiculo.setAnio(Integer.parseInt(datos[2]));
                    vehiculo.setKilometraje(Double.parseDouble(datos[3]));
                    vehiculo.setPrecio(Double.parseDouble(datos[4]));
                    vehiculo.setMotor(datos[5]);
                    vehiculo.setTransmision(new Transmision(datos[6]));
                    vehiculo.setPeso(Double.parseDouble(datos[7]));
                    vehiculo.setUbicacion(datos[8]);
                    ArrayList<String> newAccidentes = new ArrayList<>();
                    //System.out.println(datos[9].split(","));
                    for(int i=0; i<datos[9].split(",").length; i++){
                        newAccidentes.add(datos[9].split(",")[i]);
                    }
                    vehiculo.setAccidentesRecords(newAccidentes);
                    ArrayList<String> newServicios = new ArrayList<>();
                    //System.out.println(datos[9].split(","));
                    for(int i=0; i<datos[10].split(",").length; i++){
                        newServicios.add(datos[10].split(",")[i]);
                    }
                    vehiculo.setServicioRecords(newServicios);
                    ArrayList<String> newImagenes = new ArrayList<>();
                    //System.out.println(datos[9].split(","));
                    for(int i=0; i<datos[11].split(",").length; i++){
                        newImagenes.add(datos[11].split(",")[i]);
                    }
                    //vehiculo.setListaImagenes(ArrayList.asList(datos[11].split(",")));
                    vehiculos.add(vehiculo);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    private void configurarTabla() {
        tbColumnPlaca.setCellValueFactory(new PropertyValueFactory<>("placa"));
        tbColumnModelo.setCellValueFactory(new PropertyValueFactory<>("modelo"));
        tbColumnMarca.setCellValueFactory(new PropertyValueFactory<>("marca"));
        tbColumnKilometraje.setCellValueFactory(new PropertyValueFactory<>("kilometraje"));
        tbColumnPrecio.setCellValueFactory(new PropertyValueFactory<>("precio"));
        tbColumnUbicacion.setCellValueFactory(new PropertyValueFactory<>("ubicacion"));

        tableViewVehiculos.setItems(vehiculosData);
    }
    
    private void configurarFiltros() {
        cbMarcaNew.setOnAction((t) -> {
            cargarModelosPorMarca();
        });
    }
    
    @FXML
    private void buscarVehiculos(ActionEvent event) {
        filtrarVehiculos();
    }
    
    private void filtrarVehiculos() {
        String marcaSeleccionada = cbMarcaNew.getValue();
        String modeloSeleccionado = cbModeloNew.getValue();
        String precioMinimoTexto = txtPrecioMinimo.getText();
        String precioMaximoTexto = txtPrecioMaximo.getText();
        String kilometrajeMinimoTexto = txtKilometrajeMinimo.getText();
        String kilometrajeMaximoTexto = txtKilometrajeMaximo.getText();
        
        Double precioMinimo = (precioMinimoTexto.isEmpty()) ? null : Double.parseDouble(precioMinimoTexto);
        Double precioMaximo = (precioMaximoTexto.isEmpty()) ? null : Double.parseDouble(precioMaximoTexto);
        Double kilometrajeMinimo = (kilometrajeMinimoTexto.isEmpty()) ? null : Double.parseDouble(kilometrajeMinimoTexto);
        Double kilometrajeMaximo = (kilometrajeMaximoTexto.isEmpty()) ? null : Double.parseDouble(kilometrajeMaximoTexto);
        vehiculosData.clear();

        for (Vehiculo vehiculo : vehiculos) {
            boolean coincideMarca = (marcaSeleccionada == null || vehiculo.getMarca().equals(marcaSeleccionada));
            boolean coincideModelo = (modeloSeleccionado == null || vehiculo.getModelo().getNombreModelo().equals(modeloSeleccionado));
            boolean coincidePrecio = (precioMinimo == null || vehiculo.getPrecio() >= precioMinimo) && (precioMaximo == null || vehiculo.getPrecio() <= precioMaximo);
            boolean coincideKilometraje = (kilometrajeMinimo == null || vehiculo.getKilometraje() >= kilometrajeMinimo) && (kilometrajeMaximo == null || vehiculo.getKilometraje() <= kilometrajeMaximo);
            if (coincideMarca && coincideModelo && coincidePrecio && coincideKilometraje) {
                vehiculosData.add(vehiculo);
            }
        }
    }
    
    

}
