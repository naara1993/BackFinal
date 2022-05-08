
package com.example.demo4.seccionHabilidadesBlandas.dto;

import javax.validation.constraints.NotBlank;



public class HabilidadesBlandasDTO {

@NotBlank
private String imagen;
private String nombre;

    public HabilidadesBlandasDTO(String imagen, String nombre) {
        this.imagen = imagen;
        this.nombre = nombre;
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

    public HabilidadesBlandasDTO() {
    }


    
}
