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
    private String Motor;
    private Transmision transmision;
    private Double peso;
    private Double kilometraje;
    private String placa;
    
    private ArrayList<String> accidentesRecords;
    private ArrayList<String> servicioRecords;
    private ArrayList<String> listaImagenes;

    public Vehiculo() {
    }

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

    public Vehiculo(String marca, Modelo modelo, int anio, String ubicacion, Tipo tipo, Double precio, String Motor, Transmision transmision, Double peso, Double kilometraje, String placa, ArrayList<String> accidentesRecords, ArrayList<String> servicioRecords, ArrayList<String> listaImagenes) {
        this.marca = marca;
        this.modelo = modelo;
        this.anio = anio;
        this.ubicacion = ubicacion;
        this.tipo = tipo;
        this.precio = precio;
        this.Motor = Motor;
        this.transmision = transmision;
        this.peso = peso;
        this.kilometraje = kilometraje;
        this.placa = placa;
        this.accidentesRecords = accidentesRecords;
        this.servicioRecords = servicioRecords;
        this.listaImagenes = listaImagenes;
    }


    public String getMotor() {
        return Motor;
    }

    public void setMotor(String Motor) {
        this.Motor = Motor;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public ArrayList<String> getListaImagenes() {
        return listaImagenes;
    }

    public void setListaImagenes(ArrayList<String> rutaImagenes) {
        this.listaImagenes = rutaImagenes;
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


    public ArrayList<String> getAccidentesRecords() {
        return accidentesRecords;
    }

    public void setAccidentesRecords(ArrayList<String> accidentesRecords) {
        this.accidentesRecords = accidentesRecords;
    }

    public ArrayList<String> getServicioRecords() {
        return servicioRecords;
    }

    public void setServicioRecords(ArrayList<String> servicioRecords) {
        this.servicioRecords = servicioRecords;
    }

    @Override
    public String toString() {
        return placa + ":" + marca + "|" + modelo + "|" + anio + "|" + kilometraje + "|" + precio + "|" + Motor + "|" + 
               transmision + "|" + peso + "|" + ubicacion + "|" + String.join(",", accidentesRecords) + "|" + 
               String.join(",", servicioRecords) + "|" + String.join(",", listaImagenes);
    }
    public String toString2() {
        return placa + ":" + marca + "|" + modelo + "|" + anio + "|" + kilometraje + "|" + precio + "|" + Motor + "|" + 
               transmision + "|" + peso + "|" + ubicacion + "|" + String.join(",", accidentesRecords) + "|" + 
               String.join(",", servicioRecords);
    }
    
}
