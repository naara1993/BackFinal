
package com.example.demo4.sobreMi.dto;

import javax.validation.constraints.NotBlank;

public class SobreMiDTO {

@NotBlank
private String cadena;

    public String getCadena() {
        return cadena;
    }

    public void setCadena(String cadena) {
        this.cadena = cadena;
    }

    public SobreMiDTO() {
    }

    public SobreMiDTO(String cadena) {
        this.cadena = cadena;
    }


    
}
