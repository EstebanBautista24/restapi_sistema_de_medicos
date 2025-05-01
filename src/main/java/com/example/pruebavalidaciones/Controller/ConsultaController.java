package com.example.pruebavalidaciones.Controller;

import com.example.pruebavalidaciones.Model.Consulta;
import com.example.pruebavalidaciones.Model.DTO.DatosRegistroConsulta;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.persistence.Id;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/consulta")
@SecurityRequirement(name = "bearer-key")
public class ConsultaController {

    @PostMapping
    public ResponseEntity<?> crearConsulta(@RequestBody @Valid DatosRegistroConsulta consulta) {
        System.out.println(consulta);
        return ResponseEntity.ok().body(consulta);
    }
}
