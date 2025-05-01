package com.example.pruebavalidaciones.Service.Validaciones;

import com.example.pruebavalidaciones.Model.DTO.DatosRegistroConsulta;
import com.example.pruebavalidaciones.Model.Paciente;
import com.example.pruebavalidaciones.Repository.IConsultaRepository;
import jakarta.validation.ValidationException;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class ValidacionConsultaPaciente  implements IValidacion{

    private IConsultaRepository consultaRepository;
    @Override
    public void validar(DatosRegistroConsulta datosRegistroConsulta){
        LocalDateTime primera = datosRegistroConsulta.getFechaConsulta().withHour(7);
        LocalDateTime ultima = datosRegistroConsulta.getFechaConsulta().withHour(18);
        if(!consultaRepository.existeConsultaEntre(datosRegistroConsulta.getIdPaciente(),primera,ultima)){
            throw new ValidationException("El paciente ya tiene una consulta ese dia");
        }
    }
}
