
package com.example.demo4.sobreMi.models;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class SobreMi implements Serializable {
     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int  id;
     @Basic
     private String cadena;

    public SobreMi() {
    }

    public SobreMi(String cadena) {
        this.cadena = cadena;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCadena() {
        return cadena;
    }

    public void setCadena(String cadena) {
        this.cadena = cadena;
    }
    
    
}
