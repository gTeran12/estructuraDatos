package com.mycompany.rentacar;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */


import Clases.Accidentes;
import Clases.Foto;
import Clases.Marca;
import Clases.Servicio;
import Clases.Tipo;
import Clases.Transmision;
import com.mycompany.rentacar.App;
import com.mycompany.rentacar.clases.ArrayList;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Base64;
import java.util.HashMap;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.StringProperty;
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
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.stage.FileChooser;

/**
 * FXML Controller class
 *
 * @author guill
 */
public class CrearVehiculoController implements Initializable {


    @FXML
    private Label lbMarca;
    @FXML
    private ComboBox<String> cbMarca;
    @FXML
    private Label lbModelo;
    @FXML
    private ComboBox<String> cbModelo;
    //@FXML
    //private ComboBox<String> cbTipo;
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
    private Label lbPlaca;
    @FXML
    private TextField txtPlaca;
    @FXML
    private Button btCancelar;
    @FXML
    private Button btGuardar;
    @FXML
    private Label lbanio;
    @FXML
    private TextField txtanio;
    @FXML
    private Label lbprecio;
    @FXML
    private Label lbImagen;
    @FXML
    private Label lbTransmision1;
    @FXML
    private Label lbKilometraje1;
    @FXML
    private TextField txtAccidente;
    @FXML
    private ImageView addAccidente;
    @FXML
    private Label lbServicios;
    @FXML
    private TextField txtServicio;
    @FXML
    private ImageView addServicio;
    @FXML
    private ComboBox<String> cbMotor;
    @FXML
    private TextField txtPeso;
    
    //private ArrayList<Tipo> etiquetaTipo = new ArrayList<>();
    private ArrayList<Transmision> etiquetaTransmision = new ArrayList<>();
    private ArrayList<Marca> etiquetamarcas = new ArrayList<>();
    private ArrayList<String> etiquetaUbicacion = new ArrayList<>();
    private ArrayList<String> etiquetaMotor = new ArrayList<>();
    private HashMap<String, ArrayList<String>> modelosPorMarca = new HashMap<>();
    private ObservableList<Accidentes> listaAccidente = FXCollections.observableArrayList();
    private ObservableList<Servicio> listaServicio = FXCollections.observableArrayList();
    private ArrayList<Image> fotos = new ArrayList<>();

    @FXML
    private TableView<Accidentes> tbViewAccidentes;
    @FXML
    private TableColumn<Accidentes, String> tbColumnAccidentes;
    @FXML
    private TableView<Servicio> tbViewServicios;
    @FXML
    private TableColumn<Servicio, String> tbColumnservicios;
    @FXML
    private Button btAddImagen;
    @FXML
    private ImageView ivVehiculo;

    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        cargarDatos();
        cargarComboBox();
        cargarModelos();
        agregarAccidente();
        agregarServicio();
        configurarTabla();
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

    public void cargarDatos() {
        //MARCA
        //TODO: cargarMarcas Archivos TXT, 
        etiquetamarcas.add(new Marca("Hyunday"));
        etiquetamarcas.add(new Marca("Toyota"));
        etiquetamarcas.add(new Marca("KIA"));
        
        //MODELO
        //TODO: debe cargarMarcas Archivos TXT
        ArrayList<String> modeloHyunday =  new ArrayList<>();
        modeloHyunday.add("Elantra");
        modeloHyunday.add("Tucson");
        modeloHyunday.add("Creta");
        
        ArrayList<String> modeloKIA =  new ArrayList<>();
        modeloKIA.add("Pregio");
        modeloKIA.add("Picanto");
        modeloKIA.add("Cerato");
        modeloKIA.add("Soluto");
        
        modelosPorMarca.put("Hyunday", modeloHyunday);
        modelosPorMarca.put("KIA", modeloKIA);
        System.out.println(modeloHyunday.toString());
        //{"Hyundai":["Electra","Creta","Tucson",...]}
        //{"KIA":["Pregio","Picanto","Cerato",...]}
        
        //MOTOR
        etiquetaMotor.add("Gasolina");
        etiquetaMotor.add("Diesel");


        //TRANSMISION
        etiquetaTransmision.add(new Transmision("Manual"));
        etiquetaTransmision.add(new Transmision("Automatica"));
        //UBICACION
        etiquetaUbicacion.add("Guayaquil");
        etiquetaUbicacion.add("Quito");
        etiquetaUbicacion.add("Santo Domingo");
        etiquetaUbicacion.add("Esmeraldas");

    }
    //Action que al seleccion la marca carga los modelos de dicha marca
    private void cargarModelos(){
        cbMarca.setOnAction((t) -> {
            cargarModelosPorMarca();
        });
        
        addAccidente.setOnMouseClicked((t) -> {
            agregarAccidente();
        });
        addServicio.setOnMouseClicked((t) -> {
            agregarServicio();
        });
    }
    
    //Metodo que carga los modelos por marca al momento que selecciona una marca
    private void cargarModelosPorMarca(){
        String marcaSeleccionada = cbMarca.getValue();
        cbModelo.getItems().clear();
        if(marcaSeleccionada != null && modelosPorMarca.containsKey(marcaSeleccionada)){
            cbModelo.getItems().addAll(modelosPorMarca.get(marcaSeleccionada));
        }
    }
    
    public void configurarTabla(){
        tbColumnAccidentes.setCellValueFactory(new PropertyValueFactory<>("descripcion"));
        tbViewAccidentes.setItems(listaAccidente);
        
        tbColumnservicios.setCellValueFactory(new PropertyValueFactory<>("descripcion"));
        tbViewServicios.setItems(listaServicio);
        
    }
    
    public void agregarAccidente(){
        String descripcionAccidente = txtAccidente.getText();
        if(descripcionAccidente != null && !descripcionAccidente.isEmpty()){
            listaAccidente.add(new Accidentes(descripcionAccidente));
            txtAccidente.clear();
        }
        for(int i = 0; i<listaAccidente.size(); i++){
            System.out.println(listaAccidente.get(i).getDescripcion());
        }
    }

    public void agregarServicio(){
        String descripcionServicio = txtServicio.getText();
        if(descripcionServicio != null && !descripcionServicio.isEmpty()){
            listaServicio.add(new Servicio(descripcionServicio));
            txtServicio.clear();
        }
    }
    
    public void cargarComboBox(){
        if(cbTransmision.getItems().isEmpty()){
            for(Transmision transmision:etiquetaTransmision){
                cbTransmision.getItems().add(transmision.getNombre());
            }
        }
        if(cbMarca.getItems().isEmpty()){
            for(Marca marca:etiquetamarcas){
                cbMarca.getItems().add(marca.getNombre());
                
            }
        }if(cbUbicacion.getItems().isEmpty()){
            for(String ubi:etiquetaUbicacion){
                cbUbicacion.getItems().add(ubi);
                
            }
        }
        if (cbMotor.getItems().isEmpty()) {
            for(String motor:etiquetaMotor){
                cbMotor.getItems().add(motor);
            }
            
        }
        
    }

    @FXML
    private void cargarImagen(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Imágenes", "*.png", "*.jpg", "*.jpeg", "*.gif"));
        List<File> files = fileChooser.showOpenMultipleDialog(null);
        if (files != null && !files.isEmpty()) {
            for (File file : files) {
                Image image = new Image(file.toURI().toString());
                fotos.add(image);

                //Convertir img a byte y luego a cadena
                try {
                    String imageBytesString = convertirImagenABytesString(file);
                    System.out.println("Imagen como String de Bytes" + imageBytesString);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            ivVehiculo.setImage(fotos.get(0));
            int indiceImagenActual = 0;
        }
    }
    
    public String convertirImagenABytesString(File file) throws IOException{
        FileInputStream fis = new FileInputStream(file);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];
        int bytesRead;
        while((bytesRead = fis.read(buffer)) != -1){
            baos.write(buffer, 0, bytesRead);
        }
        fis.close();
        byte[] imageBytes = baos.toByteArray();
        return Base64.getEncoder().encodeToString(imageBytes);
    }
    
    public Image convertirStringAImagen(String imageBytesString) {
        byte[] imageBytes = Base64.getDecoder().decode(imageBytesString);
        ByteArrayInputStream bais = new ByteArrayInputStream(imageBytes);
        return new Image(bais);
    }

}


    



