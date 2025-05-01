package com.example.pruebavalidaciones.Model;


import com.example.pruebavalidaciones.Model.DTO.DatosRegistroPacienteDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "pacientes")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Paciente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPaciente;
    private String nombre;
    private String email;
    private String telefono;
    private Direccion direccion;
    @ManyToOne
    @JoinColumn(referencedColumnName = "idMedico")
    private Medico medico;
    private boolean estado;

    public Paciente(DatosRegistroPacienteDTO datosRegistroPacienteDTO){
        this.nombre = datosRegistroPacienteDTO.getNombre();
        this.email = datosRegistroPacienteDTO.getEmail();
        this.telefono = datosRegistroPacienteDTO.getTelefono();
        this.direccion = new Direccion(datosRegistroPacienteDTO.getDireccion());
        this.estado =true;
    }
}
