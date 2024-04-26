package com.example.Citas.Medicas.services;

import com.example.Citas.Medicas.Interfaces.IMedico;
import com.example.Citas.Medicas.dtos.MedicoDto;
import com.example.Citas.Medicas.dtos.PacienteDto;
import com.example.Citas.Medicas.mapper.MedicoMapper;
import com.example.Citas.Medicas.mapper.PacienteMapper;
import com.example.Citas.Medicas.models.MedicoModel;
import com.example.Citas.Medicas.repositories.IMedicoRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MedicoService  implements IMedico {

    @Autowired  //Inyección de dependencias
    IMedicoRepository medicoRepository; //Uso del repositorio donde se almacenan los médicos

    @Autowired
    private PacienteMapper pacienteMapper; // Variable del mapper

    @Autowired  //Inyección de dependencias
    UsuarioService usuarioService; //Uso del repositorio donde se almacenan los usuarios

    @Autowired
    private MedicoMapper medicoMapper; // Variable del mapper
    /**
     * Método que realiza la búsqueda de todos los medicos en la base de datos
     * @return Lista de medicos
     */
    public List<MedicoDto> getMedicos(){
        List<MedicoModel> medicos = medicoRepository.findAll();
        return medicoMapper.ListaModelToListaDto(medicos);
    }

    /**
     * Método que realiza el guardado de un médico pasado por parámetro
     * @param medico (MedicoModel) los datos del médico
     * @return El médico guardado
     */
    public MedicoDto saveMedico(MedicoModel medico){
        return medicoMapper.ModelToDTO(medicoRepository.save(medico));
    }

    /**
     * Método que realiza la búsqueda de un médico que tenga la misma id pasada por parámetro
     * @param id (Long) Id del médico
     * @return el médico con la id pasada por parámetro
     */
    public Optional<MedicoDto> getById(Long id){
        MedicoModel medico;
        if (medicoRepository.findById(id).isPresent())
            medico = medicoRepository.findById(id).get();
        else
            throw new EntityNotFoundException("No se ha encontrado el médico");

        MedicoDto medicoDto = medicoMapper.ModelToDTO(medico);
        return Optional.ofNullable(medicoDto);
    }

    /**
     * Método que realiza la actualización de los campos que se hayan pasado más id para definir que médico es
     * @param request (MedicoModel) Datos que se quieren cambiar
     * @param id (Long) Id del médico
     * @return el médico que se ha modificado
     */
    public MedicoDto updateById(MedicoModel request , Long id){
        if (medicoRepository.findById(id).isPresent()){
            MedicoModel medico = medicoRepository.findById(id).get();

            usuarioService.updateById( request,id);//Hacemos uso del método creado anteriormente en la clase UsuarioService para realizar la actualización de los datos

            if (request.getNumColegiado() != null)
                medico.setNumColegiado(request.getNumColegiado());

            medico= medicoRepository.save(medico);
            return medicoMapper.ModelToDTO(medico);
        }else
            throw new EntityNotFoundException("No se ha encontrado el médico de id:"+id);

    }


    /**
     * Borra el Médico pasado por parámetro
     * @param id (Long) Id del medico
     * @return True en caso de que se haya podido realizar el borrado de esa persona, False en caso no se haya podido realizar el borrado
     */
    public Boolean deleteMedico (Long id){
        if (medicoRepository.findById(id).isPresent()){
            try{
                medicoRepository.deleteById(id);
                return true;
            }catch (Exception e){
                return false;
            }
        }else
            return false;
    }


    /**
     * Método que muestra los pacientes de un médico pasado por parámetro con su id.
     * @param id (Long) Id del médico
     * @return List<PacienteDto> La lista de pacientes del médico
     */
    public List<PacienteDto> ListaDePacientesMedico(Long id){
        Optional <MedicoModel> medicoModel = medicoRepository.findById(id);
        if(medicoModel.isPresent())
            return  pacienteMapper.ListaModelToListaDto(medicoModel.get().getPacientes());
        else
            throw new EntityNotFoundException("Medico de Id: "+id+" no se ha encontrado");
    }
}
