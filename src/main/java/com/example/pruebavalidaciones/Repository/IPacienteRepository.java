package com.example.pruebavalidaciones.Repository;

import com.example.pruebavalidaciones.Model.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IPacienteRepository extends JpaRepository<Paciente,Long> {
    @Query("select P.estado FROM Paciente P where P.idPaciente =:id")
    public Boolean getActivoById(Long id);
}
