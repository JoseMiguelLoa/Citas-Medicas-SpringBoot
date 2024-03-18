package com.example.Citas.Medicas.services;

import com.example.Citas.Medicas.Interfaces.ICita;
import com.example.Citas.Medicas.dtos.CitaDto;
import com.example.Citas.Medicas.mapper.CitaMapper;
import com.example.Citas.Medicas.models.CitaModel;
import com.example.Citas.Medicas.models.DiagnosticoModel;
import com.example.Citas.Medicas.models.MedicoModel;
import com.example.Citas.Medicas.models.PacienteModel;
import com.example.Citas.Medicas.repositories.ICitaRepository;
import com.example.Citas.Medicas.repositories.IDiagnosticoRepository;
import com.example.Citas.Medicas.repositories.IMedicoRepository;
import com.example.Citas.Medicas.repositories.IPacienteRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class CitaService implements ICita {
    @Autowired  //Inyección de dependencias
    ICitaRepository citaRepository; //Uso del repositorio donde se almacenan las citas

    @Autowired  //Inyección de dependencias
    IPacienteRepository pacienteRepository; //Uso del repositorio donde se almacenan los pacientes

    @Autowired  //Inyección de dependencias
    IDiagnosticoRepository diagnosticoRepository; //Uso del repositorio donde se almacenan los diagnósticos
    @Autowired
    private CitaMapper citaMapper; // Variable del mapper

    @Autowired  //Inyección de dependencias
    IMedicoRepository medicoRepository; //Uso del repositorio donde se almacenan los médicos
    /**
     * Método que realiza la búsqueda de todos las citas en la base de datos
     * @return Lista de citas
     */
    public List<CitaDto> getCitas(){
        List <CitaModel> citas = citaRepository.findAll();
        return  citaMapper.ListaModelToListaDto(citas);
    }

    /**
     * Método que realiza el guardado de una cita pasado por parámetro
     * @param cita (CitaDto) los datos de la cita
     * @return La cita guardada
     */
    public CitaDto saveCita(CitaDto cita){
        String fallo = "";//String el cual almacenara en caso de haber fallos cuáles son
        CitaModel citaModel = citaMapper.DtoToModel(cita);
        //Declaración de las variables que almacenarán la id de cada uno
        Long medico_id = cita.getMedico_id();
        Long paciente_id = cita.getPaciente_id();
        Long diagnostico_id = cita.getDiagnostico_id();

        //Realización de la comprobación de sí está o no el id de cada uno de ellos en sus respectivas tablas
        Optional<DiagnosticoModel> diagnosticoOptional = diagnosticoRepository.findById(diagnostico_id);
        Optional<PacienteModel> pacienteOptional = pacienteRepository.findById(paciente_id);
        Optional<MedicoModel> medicoOptional = medicoRepository.findById(medico_id);

        if ( medicoOptional.isPresent() && pacienteOptional.isPresent() && diagnosticoOptional.isPresent()) {
            // Si todas las id's existe, asigna el médico, el diagnóstico y el paciente a la cita y guarda la guarda
            MedicoModel medicoModel = medicoOptional.get();
            PacienteModel pacienteModel = pacienteOptional.get();
            DiagnosticoModel diagnosticoModel = diagnosticoOptional.get();


            citaModel.setMedico(medicoModel);
            citaModel.setPaciente(pacienteModel);
            citaModel.setDiagnostico(diagnosticoModel);


            return citaMapper.ModelToDTO(citaRepository.save(citaModel));
        } else{
            if (pacienteOptional.isEmpty())
                // Si el paciente no existe, lanza una excepción
                fallo += "\nNo se pudo encontrar el paciente con el ID: " + paciente_id+"\n";

            if (diagnosticoOptional.isEmpty())
                // Si el diagnóstico no existe, lanza una excepción
                fallo += "\nNo se pudo encontrar el diagnóstico con el ID: " + diagnostico_id+"\n";

            if (medicoOptional.isEmpty())
                // Si el médico no existe, lanza una excepción
                fallo += "\nNo se pudo encontrar el médico con el ID: " + medico_id+"\n";


            throw new EntityNotFoundException(fallo);
        }





    }

    /**
     * Método que realiza la búsqueda de una cita que tenga la misma id pasada por parámetro
     * @param id (Long) Id de la cita
     * @return la cita con la id pasada por parámetro
     */
    public Optional<CitaDto> getById(Long id){
        CitaModel cita;
        if (citaRepository.findById(id).isPresent())
            cita =  citaRepository.findById(id).get();
        else
            cita = null;

        CitaDto citaDto = citaMapper.ModelToDTO(cita);
        return Optional.ofNullable(citaDto);
    }

    /**
     * Método que realiza la actualización de los campos que se hayan pasado más id para definir que cita es
     * @param request (CitaModel) Datos que se quieren cambiar
     * @param id (Long) Id de la cita
     * @return el cita que se ha modificado
     */
    public CitaDto updateById(CitaModel request , Long id){
        CitaModel cita = citaRepository.findById(id).get();

        if (request.getFechaHora() != null)
            cita.setFechaHora(request.getFechaHora());

        if (request.getMotivoCita() != null)
            cita.setMotivoCita(request.getMotivoCita());

        if (request.getAttribute11() > 0)
            cita.setAttribute11(request.getAttribute11());


        cita = citaRepository.save(cita);
        return citaMapper.ModelToDTO(cita);
    }


    /**
     * Borra la cita pasada por parámetro
     * @param id (Long) Id de la cita
     * @return True en caso de que se haya podido realizar el borrado de esa cita, False en caso no se haya podido realizar el borrado
     */
    public Boolean deleteCita (Long id){
        if (citaRepository.findById(id).isPresent()){
            try{
                citaRepository.deleteById(id);
                return true;
            }catch (Exception e){
                return false;
            }
        }else
            return false;
    }


}
