package com.example.pruebavalidaciones.Model.DTO;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.time.LocalDateTime;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class DetalleConsulta {
    private Long idConsulta;
    private Long idPaciente;
    private Long idMedico;
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
    private LocalDateTime fechaConsulta;

}
