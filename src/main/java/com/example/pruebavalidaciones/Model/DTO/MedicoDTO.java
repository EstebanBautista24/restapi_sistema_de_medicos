package com.example.pruebavalidaciones.Model.DTO;

import com.example.pruebavalidaciones.Model.Especialidad;
import com.example.pruebavalidaciones.Model.Medico;
import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class MedicoDTO {
    private Long id;
    private String nombre;
    private String email;
    private Especialidad especialidad;
    @JsonAlias("direccion")
    private DireccionDTO direccionDTO;


    public MedicoDTO(Medico medico) {
        this.id= medico.getIdMedico();
        this.nombre = medico.getNombre();
        this.email = medico.getEmail();
        this.especialidad = medico.getEspecialidad();
        this.direccionDTO = new DireccionDTO(medico.getDireccion());
    }
}
