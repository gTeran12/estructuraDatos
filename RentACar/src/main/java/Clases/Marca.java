/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import com.mycompany.rentacar.clases.ArrayList;
import com.mycompany.rentacar.clases.LinkedList;
import java.util.HashMap;

/**
 *
 * @author guill
 */
public class Marca {
    public String nombre;
    //public LinkedList<Modelo> linkedListModelo;

            
    public Marca(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    /**public void cargarModelosAMarca(){
        HashMap<Marca,LinkedList<Modelo>> mapaMarca = new HashMap<>();
        linkedListModelo.append(new Modelo("RIO"));
        linkedListModelo.append(new Modelo("PICANTO"));
        linkedListModelo.append(new Modelo("SONET"));
        linkedListModelo.append(new Modelo("CERATO"));
        linkedListModelo.append(new Modelo("SELTOS"));
        for(int i = 0; i < linkedListModelo.getLength(); i++){
            mapaMarca.put(new Marca("KIA"), linkedListModelo);
        }**/
        
    }
    /***
    public void addModeloAMarca() {
        HashMap<Marca, ArrayList<Modelo>> marcasModelos = new HashMap<>();
        ArrayList<Modelo> modelos = new ArrayList<>();
        modelos.add(new Modelo("RIO"));
        modelos.add(new Modelo("PREGIO"));
        modelos.add(new Modelo("STONIC"));
        marcasModelos.put(new Marca("KIA"), modelos);

    }**/
    

