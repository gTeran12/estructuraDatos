/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.rentacar;

import Clases.Modelo;
import Clases.Transmision;
import Clases.Vehiculo;
import com.mycompany.rentacar.clases.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;

import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * FXML Controller class
 *
 * @author guill
 */
public class CardViewController implements Initializable {

    @FXML
    private ImageView imageView;
    @FXML
    private Label lbMarca;
    @FXML
    private Label lbModelo;
    @FXML
    private Label lbUbicacion;
    @FXML
    private Label lbPrecio;

    private ArrayList<Vehiculo> vehiculos = new ArrayList<>();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    public void setCardData(String ruta, String marca, String modelo, String ubicacion, String precio){
        Image imagen = new Image("imagen.jpg");
        imageView.setImage(imagen);
        lbMarca.setText(marca);
        lbModelo.setText(modelo);
        lbUbicacion.setText(ubicacion);
        lbPrecio.setText(precio);
    }
    
    public void cargarTarjetas() {
        for (Vehiculo vehiculo : vehiculos) {
            try {
                FXMLLoader cardLoader = new FXMLLoader(getClass().getResource("CardView.fxml"));
                Parent card = cardLoader.load();
                CardViewController controller = cardLoader.getController();
//                controller.setCardData("path/to/image.png", vehiculo.getMarca() + " " + vehiculo.getModelo().getNombre(), "Placa: " + vehiculo.getPlaca() + "\nAño: " + vehiculo.getAnio() + "\nUbicación: " + vehiculo.getUbicacion());
                //root.getChildren().add(card);
            } catch (IOException e) {
                e.printStackTrace();
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
