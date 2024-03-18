package com.example.Citas.Medicas.services;

import com.example.Citas.Medicas.Interfaces.IPaciente;
import com.example.Citas.Medicas.dtos.MedicoDto;
import com.example.Citas.Medicas.dtos.PacienteDto;
import com.example.Citas.Medicas.mapper.MedicoMapper;
import com.example.Citas.Medicas.mapper.PacienteMapper;
import com.example.Citas.Medicas.models.PacienteModel;
import com.example.Citas.Medicas.repositories.IPacienteRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

//Clase donde se realizan todas los métodos de la tabla paciente
@Service
public class PacienteService implements IPaciente {

    @Autowired  //Inyección de dependencias
    IPacienteRepository pacienteRepository; //Uso del repositorio donde se almacenan los pacientes

    @Autowired  //Inyección de dependencias
    UsuarioService usuarioService; //Uso del repositorio donde se almacenan los usuarios

    @Autowired
    private PacienteMapper pacienteMapper; // Variable del mapper

    @Autowired
    private MedicoMapper medicoMapper; // Variable del mapper
    /**
     * Método que realiza la búsqueda de todos los pacientes en la base de datos
     * @return Lista de pacientes
     */
    public List<PacienteDto> getPacientes(){
        List<PacienteModel> pacientes = pacienteRepository.findAll();
        return pacienteMapper.ListaModelToListaDto(pacientes);

    }


    /**
     * Método que realiza el guardado de un paciente pasado por parámetro
     * @param paciente (PacienteModel) los datos del paciente
     * @return El paciente guardado
     */
    public PacienteDto savePaciente(PacienteModel paciente){
        return pacienteMapper.ModelToDTO(pacienteRepository.save(paciente));
    }


    /**
     * Método que realiza la búsqueda de un paciente que tenga la misma id pasada por parámetro
     * @param id (Long) Id del paciente
     * @return el paciente con la id pasada por parámetro
     */
    public Optional<PacienteDto> getById(Long id){
        PacienteModel paciente;
        if (pacienteRepository.findById(id).isPresent())
            paciente =  pacienteRepository.findById(id).get();
        else
            paciente = null;

        PacienteDto pacienteDto = pacienteMapper.ModelToDTO(paciente);
        return Optional.ofNullable(pacienteDto);
    }


    /**
     * Método que realiza la actualización de los campos que se hayan pasado más el id para definir que paciente es
     * @param request (PacienteModel) Datos que se quieren cambiar
     * @param id (Long) Id del paciente
     * @return el paciente que se ha modificado
     */
    public PacienteDto updateById(PacienteModel request , Long id){
        if (pacienteRepository.findById(id).isPresent()){
            PacienteModel paciente = pacienteRepository.findById(id).get();

            usuarioService.updateById( request,id);//Hacemos uso del método creado anteriormente en la clase UsuarioService para realizar la actualización de los datos

            if (request.getNSS() != null)
                paciente.setNSS(request.getNSS());

            if (request.getNumTarjeta() != null)
                paciente.setNumTarjeta(request.getNumTarjeta());

            if (request.getTelefono() != null)
                paciente.setTelefono(request.getTelefono());

            if (request.getDireccion() != null)
                paciente.setDireccion(request.getDireccion());

            paciente = pacienteRepository.save(paciente);

            return pacienteMapper.ModelToDTO(paciente);
        }else
            throw new EntityNotFoundException("No se ha encontrado el paciente de id:"+id);

    }

    /**
     * Borra el paciente pasado por parámetro
     * @param id (Long) Id del paciente
     * @return True en caso de que se haya podido realizar el borrado de esa persona, False en caso no se haya podido realizar el borrado
     */
    public Boolean deletePaciente (Long id){
        if (pacienteRepository.findById(id).isPresent()){
            try{
                pacienteRepository.deleteById(id);
                return true;
            }catch (Exception e){
                return false;
            }
        }else
            return false;

    }

    /**
     * Método que muestra los medicos de un paciente pasado por parámetro con su id.
     * @param id (Long) Id del paciente
     * @return List<MedicoDto> La lista de médicos del paciente
     */
    public List<MedicoDto> ListaDeMedicosPaciente(Long id){
        Optional <PacienteModel> pacienteModel = pacienteRepository.findById(id);
        if(pacienteModel.isPresent())
            return  medicoMapper.ListaModelToListaDto(pacienteModel.get().getMedicos());
        else
            throw new EntityNotFoundException("Paciente de Id: "+id+" no se ha encontrado");

    }

}
