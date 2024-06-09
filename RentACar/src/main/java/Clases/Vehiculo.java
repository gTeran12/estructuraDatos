/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import com.mycompany.rentacar.clases.ArrayList;

/**
 *
 * @author guill
 */
public class Vehiculo {
    private String marca;
    private Modelo modelo;
    private int anio;
    private String ubicacion;
    private Tipo tipo;
    private Double precio;
    private Transmision transmision;
    private Double kilometraje;
    private String placa;
    private String rutaArchivo = "src/main/resources/files/vehiculos.txt";
    
    private ArrayList<Accidentes> accidentesRecords;
    private ArrayList<Mantenimiento> mantenimientoRecords;

    public Vehiculo(String marca, Modelo modelo, int anio, String ubicacion, Tipo tipo, Double precio, Transmision transmision, Double kilometraje, String placa) {
        this.marca = marca;
        this.modelo = modelo;
        this.anio = anio;
        this.ubicacion = ubicacion;
        this.tipo = tipo;
        this.precio = precio;
        this.transmision = transmision;
        this.kilometraje = kilometraje;
        this.placa = placa;
    }

    public Vehiculo(String marca, Modelo modelo, int anio, String ubicacion, Tipo tipo, Double precio, Transmision transmision, Double kilometraje, String placa, ArrayList<Accidentes> accidentesRecords, ArrayList<Mantenimiento> mantenimientoRecords) {
        this.marca = marca;
        this.modelo = modelo;
        this.anio = anio;
        this.ubicacion = ubicacion;
        this.tipo = tipo;
        this.precio = precio;
        this.transmision = transmision;
        this.kilometraje = kilometraje;
        this.placa = placa;
        this.accidentesRecords = accidentesRecords;
        this.mantenimientoRecords = mantenimientoRecords;
    }

    

    
    
    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public Modelo getModelo() {
        return modelo;
    }

    public void setModelo(Modelo modelo) {
        this.modelo = modelo;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public Transmision getTransmision() {
        return transmision;
    }

    public void setTransmision(Transmision transmision) {
        this.transmision = transmision;
    }

    public Double getKilometraje() {
        return kilometraje;
    }

    public void setKilometraje(Double kilometraje) {
        this.kilometraje = kilometraje;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getRutaArchivo() {
        return rutaArchivo;
    }

    public void setRutaArchivo(String rutaArchivo) {
        this.rutaArchivo = rutaArchivo;
    }

    public ArrayList<Accidentes> getAccidentesRecords() {
        return accidentesRecords;
    }

    public void setAccidentesRecords(ArrayList<Accidentes> accidentesRecords) {
        this.accidentesRecords = accidentesRecords;
    }

    public ArrayList<Mantenimiento> getMantenimientoRecords() {
        return mantenimientoRecords;
    }

    public void setMantenimientoRecords(ArrayList<Mantenimiento> mantenimientoRecords) {
        this.mantenimientoRecords = mantenimientoRecords;
    }
}
