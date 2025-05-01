package com.example.pruebavalidaciones.Service.Validaciones;

import com.example.pruebavalidaciones.Model.DTO.DatosRegistroConsulta;
import com.example.pruebavalidaciones.Repository.IConsultaRepository;
import jakarta.validation.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class ValidacionMedicoConsulta implements IValidacion {
    @Autowired
    private IConsultaRepository consultaRepository;

    @Override
    public void validar(DatosRegistroConsulta datosRegistroConsulta){

        if(!consultaRepository.existeConsultaMedico(datosRegistroConsulta.getIdMedico(),datosRegistroConsulta.getFechaConsulta())){
            throw new ValidationException("El medico ya tiene una consulta en esa fecha");
        }
}
}
