package com.example.pruebavalidaciones.Service;

import com.example.pruebavalidaciones.Errores.ErrorIntegridad;
import com.example.pruebavalidaciones.Model.Consulta;
import com.example.pruebavalidaciones.Model.DTO.DatosRegistroConsulta;
import com.example.pruebavalidaciones.Model.Medico;
import com.example.pruebavalidaciones.Model.Paciente;
import com.example.pruebavalidaciones.Repository.IConsultaRepository;
import com.example.pruebavalidaciones.Repository.IMedicoRepository;
import com.example.pruebavalidaciones.Repository.IPacienteRepository;
import com.example.pruebavalidaciones.Service.Validaciones.IValidacion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ConsultaService {
    @Autowired
    private IConsultaRepository consultaRepository;
    @Autowired
    private IMedicoRepository medicoRepository;
    @Autowired
    private IPacienteRepository pacienteRepository;

    @Autowired //se inyectan todas las implementaciones de las interfaz
    List<IValidacion> validaciones;

    public void agendar(DatosRegistroConsulta datosRegistroConsulta){
        Optional<Paciente> paciente = pacienteRepository.findById(datosRegistroConsulta.getIdPaciente());


      if(!paciente.isPresent()){
            throw new ErrorIntegridad("paciente no encontrado");
        }
      validaciones.forEach(v->v.validar(datosRegistroConsulta));
      Medico medico = encontrarMedico(datosRegistroConsulta);
        Consulta consulta = new Consulta(datosRegistroConsulta,paciente.get(),medico);

    }

    private Medico encontrarMedico(DatosRegistroConsulta datosRegistroConsulta) {
        if(datosRegistroConsulta.getIdMedico()!=null){
            return medicoRepository.getReferenceById(datosRegistroConsulta.getIdMedico());
        }
        else if(datosRegistroConsulta.getEspecialidad()==null){
            throw new ErrorIntegridad("Debe seleccionar especialidad");
        }
        return medicoRepository.encontrarMedicoConEspecialidad(datosRegistroConsulta.getEspecialidad(),datosRegistroConsulta.getFechaConsulta());
    }
}
