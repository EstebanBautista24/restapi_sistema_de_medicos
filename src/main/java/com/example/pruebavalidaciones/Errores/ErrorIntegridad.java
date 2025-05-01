package com.example.pruebavalidaciones.Errores;

public class ErrorIntegridad extends RuntimeException{
    public ErrorIntegridad(String mensaje){
        super(mensaje);
    }
}
