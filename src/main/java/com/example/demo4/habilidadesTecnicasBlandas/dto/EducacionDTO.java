
package com.example.demo4.habilidadesTecnicasBlandas.dto;

import javax.validation.constraints.NotBlank;

public class EducacionDTO {
    @NotBlank
     private String escuela;
     private String titulo;
     private String fecha_inicio;
     private String fecha_final;
     private String imagen;

    public String getEscuela() {
        return escuela;
    }

    public void setEscuela(String escuela) {
        this.escuela = escuela;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
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

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public EducacionDTO(String escuela, String titulo, String fecha_inicio, String fecha_final, String imagen) {
        this.escuela = escuela;
        this.titulo = titulo;
        this.fecha_inicio = fecha_inicio;
        this.fecha_final = fecha_final;
        this.imagen = imagen;
    }
}
