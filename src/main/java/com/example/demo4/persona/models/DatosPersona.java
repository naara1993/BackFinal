
package com.example.demo4.persona.models;


import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class DatosPersona implements Serializable {
    @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int  id;
    
    @Basic
    private String nombreCompleto;
    private String domicilio;
    private String profesion;

  public DatosPersona() {
      
    }
    public DatosPersona( int id,String nombreCompleto, String domicilio, String profesion) {
        this.id=id;
        this.nombreCompleto = nombreCompleto;
        this.domicilio = domicilio;
        this.profesion = profesion;
    }
    



    public DatosPersona(String nombreCompleto, String domicilio, String profesion) {
        this.nombreCompleto = nombreCompleto;
        this.domicilio = domicilio;
        this.profesion = profesion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public String getProfesion() {
        return profesion;
    }

    public void setProfesion(String profesion) {
        this.profesion = profesion;
    }
    
    
}
