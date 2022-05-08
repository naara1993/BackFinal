
package com.example.demo4.proyectos.dto;

import javax.validation.constraints.NotBlank;


public class ProyectosRealizadosDTO {
     @NotBlank
    private String nombreProyecto;
    private String descripcionProyecto;

    public ProyectosRealizadosDTO() {
    }

    public ProyectosRealizadosDTO(String nombreProyecto, String descripcionProyecto) {
        this.nombreProyecto = nombreProyecto;
        this.descripcionProyecto = descripcionProyecto;
    }

    public String getNombreProyecto() {
        return nombreProyecto;
    }

    public void setNombreProyecto(String nombreProyecto) {
        this.nombreProyecto = nombreProyecto;
    }

    public String getDescripcionProyecto() {
        return descripcionProyecto;
    }

    public void setDescripcionProyecto(String descripcionProyecto) {
        this.descripcionProyecto = descripcionProyecto;
    }
    
    
}
