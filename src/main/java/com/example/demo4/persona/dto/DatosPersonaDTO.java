
package com.example.demo4.persona.dto;

import javax.validation.constraints.NotBlank;


public class DatosPersonaDTO {
@NotBlank
private String nombreCompleto;
private String domicilio;
private String profesion;

    public DatosPersonaDTO() {
    }

    public DatosPersonaDTO(String nombreCompleto, String domicilio, String profesion) {
        this.nombreCompleto = nombreCompleto;
        this.domicilio = domicilio;
        this.profesion = profesion;
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
