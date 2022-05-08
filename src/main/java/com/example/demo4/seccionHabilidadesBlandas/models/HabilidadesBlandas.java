
package com.example.demo4.seccionHabilidadesBlandas.models;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class HabilidadesBlandas implements Serializable {
     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     private int id;
     @Basic
     private String imagen;
     private String nombre;

    public HabilidadesBlandas() {
    }

    public HabilidadesBlandas(int id, String imagen, String nombre) {
        this.id = id;
        this.imagen = imagen;
        this.nombre = nombre;
    }

    public HabilidadesBlandas(String imagen, String nombre) {
        this.imagen = imagen;
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
     
     
    
}
