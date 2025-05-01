package com.example.pruebavalidaciones.Service.Validaciones;

import com.example.pruebavalidaciones.Model.DTO.DatosRegistroConsulta;
import jakarta.validation.ValidationException;
import org.springframework.stereotype.Component;

import java.time.DayOfWeek;

@Component
public class ValidacionHorarioConsulta implements IValidacion {

    @Override
    public void validar(DatosRegistroConsulta datosRegistroConsulta){


        if(DayOfWeek.SUNDAY.equals(datosRegistroConsulta.getFechaConsulta().getDayOfWeek())|| datosRegistroConsulta.getFechaConsulta().getHour()<7||datosRegistroConsulta.getFechaConsulta().getHour()>19){
            throw new ValidationException("El domingo no hay atencion");
        }
    }
}
