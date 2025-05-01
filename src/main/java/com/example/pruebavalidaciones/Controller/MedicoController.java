package com.example.pruebavalidaciones.Controller;

import com.example.pruebavalidaciones.Model.DTO.MedicoActualizarDTO;
import com.example.pruebavalidaciones.Model.DTO.MedicoDTO;
import com.example.pruebavalidaciones.Model.Medico;
import com.example.pruebavalidaciones.Repository.IMedicoRepository;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/medico")
@SecurityRequirement(name = "bearer-key")
public class MedicoController {
    @Autowired
    private IMedicoRepository medicoRepository;

    @GetMapping
    public Page<MedicoDTO> getAllMedicos(@PageableDefault(sort = "nombre") Pageable pageable) {
        return medicoRepository.findAll(pageable).map(m->new MedicoDTO(m));

    }

    @PostMapping
    public void registrarMedico(@RequestBody @Valid MedicoDTO medico){
        medicoRepository.save(new Medico(medico));
        System.out.println("registro creado");
    }


    @PutMapping
    @Transactional // comit de los datos actualizados cuando se termina la ejecucion del metodo
    public void ActualizarMedico(@RequestBody @Valid MedicoActualizarDTO medico){
        Medico medico1 = medicoRepository.getReferenceById(medico.getIdMedico());
        medico1.ActualizarMedico(medico);

    }

    @DeleteMapping("/{id}")
    @Transactional
    //@Secured("ROLE_ADMIN")  restringir el acceso
    public void deleteMedico(@PathVariable Long id){
        Medico medico = medicoRepository.getReferenceById(id);
        medicoRepository.delete(medico);
    }
}
