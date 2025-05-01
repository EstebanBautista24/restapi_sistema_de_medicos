package com.example.pruebavalidaciones.Errores;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

@RestControllerAdvice //proxy programacion orientada a aspectos
public class TratamientoErrores {
    @ExceptionHandler(EntityNotFoundException.class) //excepcion a tratar cuando de esa excepcion
    public ResponseEntity<?> tratarError404(){
        return ResponseEntity.notFound().build();
    }
    @ExceptionHandler(MethodArgumentNotValidException.class) //excepcion a tratar cuando de esa excepcion
    public ResponseEntity<?> tratarError400(MethodArgumentNotValidException ex){
        List<DatosError> error = ex.getFieldErrors().stream().map(f->new DatosError(f)).toList();
        return ResponseEntity.badRequest().body(error); //enviar cuerpo en el error
        //return ResponseEntity.badRequest().build();//solo envia bad request sin nada
    }
    private record DatosError(String campo,String error){
        public DatosError(FieldError errors){
                this(errors.getField(),errors.getDefaultMessage());

        }
    }
}
