package com.example.pruebavalidaciones.Model;

import com.example.pruebavalidaciones.Model.DTO.DatosRegistroConsulta;
import jakarta.persistence.*;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode(of = "idConsulta")
@Entity
@Table
public class Consulta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idConsulta;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(referencedColumnName = "idPaciente")
    private Paciente paciente;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(referencedColumnName = "idMedico")
    private Medico idMedico;

    private LocalDateTime fechaConsulta;

    public Consulta(DatosRegistroConsulta datosRegistroConsulta,Paciente paciente,Medico medico) {
        this.paciente = paciente;
        this.idMedico = medico;
        this.fechaConsulta = datosRegistroConsulta.getFechaConsulta();

    }
}
