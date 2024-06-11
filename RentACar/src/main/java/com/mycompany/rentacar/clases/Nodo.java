/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.rentacar.clases;

import Clases.Vehiculo;


class Nodo {
    Vehiculo obj;
    Nodo anterior, siguiente;
    
    public Nodo(){
        obj = new Vehiculo();
        anterior = siguiente = null;
    }
    
    public String toString(){
        return obj.toString();
    }
}
