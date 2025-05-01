package com.example.pruebavalidaciones.Model;


import com.example.pruebavalidaciones.Model.DTO.DireccionDTO;
import jakarta.persistence.Embeddable;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@NoArgsConstructor
@Data
public class Direccion {

    private String calle;
    private String complemento;

    public Direccion(DireccionDTO direccionDTO) {
        this.calle = direccionDTO.getCalle();
        this.complemento = direccionDTO.getComplemento();
    }
    public Direccion actualizar(DireccionDTO direccionDTO) {
        this.calle = direccionDTO.getCalle();
        this.complemento = direccionDTO.getComplemento();
        return this;
    }
}
