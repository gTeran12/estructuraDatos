/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author guill
 */
public class Accidentes {
    private final StringProperty descripcion;

    public Accidentes(String descripcion) {
        this.descripcion = new SimpleStringProperty(descripcion);
    }

    public String getDescripcion() {
        return descripcion.get();
    }

    public void setDescripcion(String descripcion) {
        this.descripcion.set(descripcion);
    }

    public StringProperty descripcionProperty() {
        return descripcion;
    }
}
