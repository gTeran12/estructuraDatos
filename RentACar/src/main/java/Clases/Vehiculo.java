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
    
    
    
}
