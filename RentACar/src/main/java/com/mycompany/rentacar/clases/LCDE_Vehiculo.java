/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.rentacar.clases;

/**
 *
 * @author guill
 */
public class LCDE_Vehiculo {

    Nodo cabeza;
    int cantNodos;

    public LCDE_Vehiculo() {
        cabeza = null;
        cantNodos = 0;
    }

    public void adicionarCabeza() {
        Nodo nuevo = new Nodo();
        String placa = new String();
        nuevo.obj.setPlaca(placa);
        //nuevo.obj.setPrecio(Double.NaN);
        //nuevo.obj.setListaImagenes(rutaImagenes);

        nuevo.siguiente = cabeza;
        if (cabeza != null) {
            cabeza.anterior = nuevo;
        }
        cabeza = nuevo;
        cantNodos++;
    }

    public boolean vacia() {
        if (cabeza == null) {
            return true;
        } else {
            return false;
        }
    }

    public Nodo getCabeza() {
        if (vacia()) {
            return null;
        } else {
            return cabeza;
        }
    }

    public Nodo getCola() {
        Nodo n = null;
        if (vacia()) {
            return null;
        } else {
            n = cabeza;
            while (n != null) {
                if (n.siguiente == null) {
                    break;
                }
                n = n.siguiente;
            }
        }
        return n;
    }

    public void recorrerAdelante() {
        if (vacia()) {
            System.out.println("Lista Vacia");
        } else {
            System.out.println("Elementos de la lista");
            Nodo n = cabeza;
            while (n != null) {
                System.out.println(n);
                n = n.siguiente;
            }
        }
    }
}
