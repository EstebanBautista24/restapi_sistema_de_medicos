package com.example.pruebavalidaciones.Model.DTO;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class DatosRegistroPacienteDTO {
    public String nombre;
    public String email;
    public String telefono;
    @JsonAlias("direccion")
    public DireccionDTO direccion;

}
