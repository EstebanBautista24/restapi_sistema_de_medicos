package com.example.pruebavalidaciones.Service.Validaciones;

import com.example.pruebavalidaciones.Model.DTO.DatosRegistroConsulta;
import com.example.pruebavalidaciones.Repository.IMedicoRepository;
import jakarta.validation.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidacionMedicoActivo implements IValidacion{

    @Autowired
    private IMedicoRepository medicoRepository;
    @Override
    public void validar(DatosRegistroConsulta datosRegistroConsulta) {
        if(!medicoRepository.getActivoById(datosRegistroConsulta.getIdMedico())){

            throw new ValidationException("El medico no esta activo");
        }
    }
}
