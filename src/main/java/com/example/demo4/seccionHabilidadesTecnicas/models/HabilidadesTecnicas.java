
package com.example.demo4.seccionHabilidadesTecnicas.models;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class HabilidadesTecnicas implements Serializable {
     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     private int id;
     @Basic
     private String imagen;

    public HabilidadesTecnicas() {
    }

    public HabilidadesTecnicas(int id, String imagen) {
        this.id = id;
        this.imagen = imagen;
    }

    public HabilidadesTecnicas(String imagen) {
        this.imagen = imagen;
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
    
    
    
}
