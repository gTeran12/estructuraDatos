/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

/**
 *
 * @author guill
 */
public class Modelo {
    private String nombreModelo;

    public Modelo(String nombreModelo) {
        this.nombreModelo = nombreModelo;
    }

    public String getNombreModelo() {
        return nombreModelo;
    }

    public void setNombreModelo(String nombreModelo) {
        this.nombreModelo = nombreModelo;
    }

    @Override
    public String toString() {
        return "Modelo{" + "nombreModelo=" + nombreModelo + '}';
    }
    
    
}
