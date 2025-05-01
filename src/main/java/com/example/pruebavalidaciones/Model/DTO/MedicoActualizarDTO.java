package com.example.pruebavalidaciones.Model.DTO;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MedicoActualizarDTO {
    @NotNull
    private Long idMedico;
    private String nombre;
    private DireccionDTO direccionDTO;

}
