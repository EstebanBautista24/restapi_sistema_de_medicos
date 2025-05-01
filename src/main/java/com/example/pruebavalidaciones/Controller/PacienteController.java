package com.example.pruebavalidaciones.Controller;


import com.example.pruebavalidaciones.Model.DTO.DatosRegistroPacienteDTO;
import com.example.pruebavalidaciones.Model.Paciente;
import com.example.pruebavalidaciones.Repository.IPacienteRepository;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/pacientes")
@SecurityRequirement(name = "bearer-key")
public class PacienteController {
    @Autowired
    private IPacienteRepository pacienteRepository;

    @GetMapping
    public ResponseEntity<List<Paciente>> getAllPacientes() {
        HttpHeaders headers = new HttpHeaders();
        return new ResponseEntity<>(pacienteRepository.findAll(),headers, HttpStatus.OK);
    }

    @PostMapping
    @Transactional
    public ResponseEntity<Paciente> registrar(@RequestBody @Valid DatosRegistroPacienteDTO datos, UriComponentsBuilder uriBuilder) {
        Paciente paciente = new Paciente(datos);
        pacienteRepository.save(paciente);

        var uri = uriBuilder.path("/pacientes/{id}").buildAndExpand(paciente.getIdPaciente()).toUri();
        return ResponseEntity.created(uri).body(paciente);
    }

}
