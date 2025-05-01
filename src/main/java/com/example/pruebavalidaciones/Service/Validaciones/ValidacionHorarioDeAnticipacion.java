package com.example.pruebavalidaciones.Service.Validaciones;

import com.example.pruebavalidaciones.Model.DTO.DatosRegistroConsulta;
import jakarta.validation.ValidationException;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.LocalDateTime;

@Component
public class ValidacionHorarioDeAnticipacion implements IValidacion{
    @Override
    public void validar(DatosRegistroConsulta datosRegistroConsulta){
        LocalDateTime now = LocalDateTime.now();
        if(Duration.between(now,datosRegistroConsulta.getFechaConsulta()).toMinutes()<30){
            throw new ValidationException("la consulta debe tener 30minutos de anticipacion");
        }
    }
}
