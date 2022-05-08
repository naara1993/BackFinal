
package com.example.demo4.habilidadesTecnicasBlandas.models;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Experiencia implements Serializable {
     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     private int id;
     @Basic 
     private String puesto;
     private String empresa;
     private String fecha_inicio;
     private String fecha_final;
     private String descripcion;
     private String imagen;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public String getFecha_inicio() {
        return fecha_inicio;
    }

    public void setFecha_inicio(String fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }

    public String getFecha_final() {
        return fecha_final;
    }

    public void setFecha_final(String fecha_final) {
        this.fecha_final = fecha_final;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public Experiencia(String puesto, String empresa, String fecha_inicio, String fecha_final, String descripcion, String imagen) {
        this.puesto = puesto;
        this.empresa = empresa;
        this.fecha_inicio = fecha_inicio;
        this.fecha_final = fecha_final;
        this.descripcion = descripcion;
        this.imagen = imagen;
    }

    public Experiencia(int id, String puesto, String empresa, String fecha_inicio, String fecha_final, String descripcion, String imagen) {
        this.id = id;
        this.puesto = puesto;
        this.empresa = empresa;
        this.fecha_inicio = fecha_inicio;
        this.fecha_final = fecha_final;
        this.descripcion = descripcion;
        this.imagen = imagen;
    }

    public Experiencia() {
    }
}
