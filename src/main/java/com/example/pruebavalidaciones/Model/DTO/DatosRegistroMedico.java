package com.example.pruebavalidaciones.Model.DTO;

import com.example.pruebavalidaciones.Model.Especialidad;
import com.fasterxml.jackson.annotation.JsonAlias;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class DatosRegistroMedico {
    @NotBlank(message = "no debe estar vacio")
    private String nombre;
    @NotBlank
    @Email
    private String email;
    @NotBlank
    private Especialidad especialidad;
    @JsonAlias("direccion")
    @NotNull
    private DireccionDTO direccionDTO;
}
