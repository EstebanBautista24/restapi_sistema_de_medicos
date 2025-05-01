package com.example.pruebavalidaciones.Model.DTO;

import com.example.pruebavalidaciones.Model.Especialidad;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DatosRegistroConsulta {
    @NotNull
    private Long idPaciente;
    private Long idMedico;
    @NotNull
    @Future
    private LocalDateTime fechaConsulta;
    private Especialidad especialidad;
}
