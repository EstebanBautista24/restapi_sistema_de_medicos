package com.example.pruebavalidaciones.Repository;

import com.example.pruebavalidaciones.Model.Consulta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
public interface IConsultaRepository extends JpaRepository<Consulta,Long> {
    @Query("SELECT COUNT(C) > 0  FROM Consulta C WHERE C.paciente =:id AND C.fechaConsulta between :primera AND :ultima")
    public boolean existeConsultaEntre(Long id, LocalDateTime primera, LocalDateTime ultima);

    @Query("SELECT COUNT(C)>0 FROM Consulta C WHERE C.idMedico =:idMedico AND C.fechaConsulta=:fechaConsulta")
    public boolean existeConsultaMedico(Long idMedico, LocalDateTime fechaConsulta);
}
