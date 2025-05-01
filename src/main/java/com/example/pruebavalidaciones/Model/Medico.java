package com.example.pruebavalidaciones.Model;


import com.example.pruebavalidaciones.Model.DTO.MedicoActualizarDTO;
import com.example.pruebavalidaciones.Model.DTO.MedicoDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "Medico")
@Entity(name = "Medico")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Medico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idMedico;
    private String nombre;
    private String email;
    @Enumerated(EnumType.STRING)
    private Especialidad especialidad;
    @Embedded
    private Direccion direccion;
    private boolean estado;

    public Medico(MedicoDTO medicoDTO){
        this.nombre = medicoDTO.getNombre();
        this.email = medicoDTO.getEmail();
        this.especialidad = medicoDTO.getEspecialidad();
        this.direccion = new Direccion(medicoDTO.getDireccionDTO());
        this.estado = true;
    }

    public void ActualizarMedico(MedicoActualizarDTO medicoDTO){
        if (medicoDTO.getNombre()!=null){
            this.nombre = medicoDTO.getNombre();
        }
        if (medicoDTO.getDireccionDTO()!=null){
            this.direccion = direccion.actualizar(medicoDTO.getDireccionDTO());
        }

    }
    public void eliminarMedico(){
        this.estado = false;
    }
}
