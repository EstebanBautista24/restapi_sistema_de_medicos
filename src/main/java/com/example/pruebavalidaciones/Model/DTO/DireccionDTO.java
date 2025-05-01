package com.example.pruebavalidaciones.Model.DTO;


import com.example.pruebavalidaciones.Model.Direccion;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DireccionDTO {
    private String calle;
    private String complemento;

    public DireccionDTO(Direccion direccion)  {
        this.calle = direccion.getCalle();
        this.complemento = direccion.getComplemento();

    }
}
