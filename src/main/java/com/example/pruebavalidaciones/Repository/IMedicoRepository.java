package com.example.pruebavalidaciones.Repository;

import com.example.pruebavalidaciones.Model.Especialidad;
import com.example.pruebavalidaciones.Model.Medico;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
public interface IMedicoRepository extends JpaRepository<Medico,Long> {
    Page<Medico> findMedicoByEstadoIsTrue(Pageable pageable);

    @Query("SELECT M from Medico M where M.estado = TRUE AND M.idMedico NOT IN (SELECT  C.idMedico.idMedico FROM Consulta C WHERE C.fechaConsulta=:fechaConsulta) AND M.especialidad =:especialidad ORDER BY RAND() LIMIT 1")
    Medico encontrarMedicoConEspecialidad(Especialidad especialidad, LocalDateTime fechaConsulta);

    @Query("select M.estado FROM Medico  M where M.idMedico =:id")
    public Boolean getActivoById(Long id);
}
