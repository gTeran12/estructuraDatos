/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.rentacar;

import Clases.Accidentes;
import Clases.Modelo;
import Clases.Servicio;
import Clases.Transmision;
import Clases.Vehiculo;
import com.mycompany.rentacar.clases.ArrayList;
import com.mycompany.rentacar.clases.LCDE_Vehiculo;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * FXML Controller class
 *
 * @author guill
 */
public class VerVehiculoController implements Initializable {

    @FXML
    private Button btEditar;
    @FXML
    private Button btEliminar;
    @FXML
    private Button btSalir;
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
    private TextField txtPlaca;
    @FXML
    private Button btBuscar;

    private ArrayList<Vehiculo> vehiculos = new ArrayList<>();

    private ArrayList<Vehiculo> listaVehiculos = new ArrayList<>();
    
    private ObservableList<Accidentes> listaAccidente = FXCollections.observableArrayList();
    private ObservableList<Servicio> listaServicio = FXCollections.observableArrayList();
    //private LCDE_Vehiculo<Image> fotos = new ArrayList<>();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        editarVehiculo();
        eliminarVehiculo();
        volverAlMenu();
        cargarVehiculosDesdeArchivo();

    }

    @FXML
    private void editarVehiculo() {
        btEditar.setOnMouseClicked((t) -> {
            //TODO metodo para editar un vehiculo
            System.out.println("Edita vehiculo");
            try {
                App.setRoot("editarVehiculo");
            } catch (IOException ex) {
                Logger.getLogger(SecondaryController.class.getName()).log(Level.SEVERE, null, ex);
            }

        });
    }

    @FXML
    private void eliminarVehiculo() {
        btEliminar.setOnMouseClicked((t) -> {
            //TODO metodo para eliminar vehiculo
            System.out.println("Eliminar Vehiculo");
        });
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

    @FXML
    private void buscarVehiculo() {
        btBuscar.setOnMouseClicked((t) -> {
            Vehiculo vehiculoEncontrado = filtrarVehiculo();
            if (vehiculoEncontrado != null) {
                // Llenar los labels con los datos del vehículo encontrado
                lbPlaca.setText(vehiculoEncontrado.getPlaca());
                lbAnio.setText(String.valueOf(vehiculoEncontrado.getAnio()));
                lbUbicacion.setText(vehiculoEncontrado.getUbicacion());
                lbPrecioFijo.setText(String.valueOf(vehiculoEncontrado.getPrecio()));
                lbKilometraje.setText(String.valueOf(vehiculoEncontrado.getKilometraje()));
                // Cargar la imagen del vehículo, etc.
                System.out.println("Vehículo encontrado: " + vehiculoEncontrado.toString());
            } else {
                // Manejar el caso en que no se encuentre el vehículo
                lbPlaca.setText("No encontrado");
                lbAnio.setText("");
                lbUbicacion.setText("");
                lbPrecioFijo.setText("");
                lbKilometraje.setText("");
                // Manejar la imagen del vehículo, etc.
                System.out.println("No se encontró ningún vehículo con la placa ingresada.");
            }
        });
    }

    private Vehiculo filtrarVehiculo() {
        String buscarPorPlaca = txtPlaca.getText().trim();
        for (Vehiculo vehiculo : vehiculos) {
            if (vehiculo.getPlaca().equalsIgnoreCase(buscarPorPlaca)) {
                return vehiculo;
            }
        }
        System.out.println("No se encontró ningún vehículo con la placa: " + buscarPorPlaca);
        return null;
    }

    private void configurarTabla(){
        tbColumnAccidentes.setCellValueFactory(new PropertyValueFactory<>("descripcion"));
        tbColumnservicios.setCellValueFactory(new PropertyValueFactory<>("descripcion"));
        //tbViewServicios.setItems(listaServicio);
        //tbViewAccidentes.setItems(listaAccidente);
        
    }
    
    private void llenarTablaServicios(Vehiculo vehiculo) {
        listaServicio.clear();
        for (String servicioDescripcion : vehiculo.getServicioRecords()) {
            listaServicio.add(new Servicio(servicioDescripcion));
        }
        //tbViewServicios.setItems(listaServicio);
    }
    
    private void llenarTablaAccidentes(Vehiculo vehiculo) {
        listaAccidente.clear();
        for (String accidenteDescripcion : vehiculo.getAccidentesRecords()) {
            listaAccidente.add(new Accidentes(accidenteDescripcion));
        }
        //tbViewAccidentes.setItems(listaAccidente);
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
                    for (int i = 0; i < datos[9].split(",").length; i++) {
                        newAccidentes.add(datos[9].split(",")[i]);
                    }
                    vehiculo.setAccidentesRecords(newAccidentes);
                    ArrayList<String> newServicios = new ArrayList<>();
                    //System.out.println(datos[9].split(","));
                    for (int i = 0; i < datos[10].split(",").length; i++) {
                        newServicios.add(datos[10].split(",")[i]);
                    }
                    vehiculo.setServicioRecords(newServicios);
                    ArrayList<String> newImagenes = new ArrayList<>();
                    //System.out.println(datos[9].split(","));
                    for (int i = 0; i < datos[11].split(",").length; i++) {
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
}
