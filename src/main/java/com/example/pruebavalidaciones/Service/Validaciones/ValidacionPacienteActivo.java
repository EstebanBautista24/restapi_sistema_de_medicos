package com.example.pruebavalidaciones.Service.Validaciones;

import com.example.pruebavalidaciones.Model.DTO.DatosRegistroConsulta;
import com.example.pruebavalidaciones.Repository.IPacienteRepository;
import jakarta.validation.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidacionPacienteActivo implements IValidacion{
    @Autowired
    private IPacienteRepository pacienteRepository;

    @Override
    public void validar(DatosRegistroConsulta datosRegistroConsulta){
        if(datosRegistroConsulta.getIdPaciente()==null){
            throw new ValidationException("El paciente no puede ser nulo");
        }
        if(!pacienteRepository.getActivoById(datosRegistroConsulta.getIdPaciente())){
            throw new ValidationException("El paciente no esta activo");
        }
    }
}
