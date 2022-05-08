
package com.example.demo4.seccionHabilidadesTecnicas.dto;

import javax.validation.constraints.NotBlank;

public class HabilidadesTecnicasDTO {
    @NotBlank
    private String imagen;

    public HabilidadesTecnicasDTO() {
    }

    public HabilidadesTecnicasDTO(String imagen) {
        this.imagen = imagen;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }
    
}
