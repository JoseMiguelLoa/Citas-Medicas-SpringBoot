package com.example.Citas.Medicas.services;

import com.example.Citas.Medicas.Interfaces.IDiagnostico;
import com.example.Citas.Medicas.dtos.DiagnosticoDto;
import com.example.Citas.Medicas.mapper.DiagnosticoMapper;
import com.example.Citas.Medicas.models.CitaModel;
import com.example.Citas.Medicas.models.DiagnosticoModel;
import com.example.Citas.Medicas.repositories.ICitaRepository;
import com.example.Citas.Medicas.repositories.IDiagnosticoRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DiagnosticoService implements IDiagnostico {
    @Autowired  //Inyección de dependencias
    IDiagnosticoRepository diagnosticoRepository; //Uso del repositorio donde se almacenan los diagnósticos

    @Autowired
    ICitaRepository citaRepository;

    @Autowired
    private DiagnosticoMapper diagnosticoMapper; // Variable del mapper

    /**
     * Método que realiza la búsqueda de todos los diagnósticos en la base de datos
     * @return Lista de diagnósticos
     */
    public List<DiagnosticoDto> getDiagnostico(){
        List<DiagnosticoModel> diagnostico = diagnosticoRepository.findAll();
        return diagnosticoMapper.ListaModelToListaDto(diagnostico);
    }

    /**
     * Método que realiza el guardado de un diagnóstico pasado por parámetro
     * @param diagnostico (DiagnosticoModel) los datos del diagnóstico
     * @return El diagnóstico guardado
     */
    public DiagnosticoDto saveDiagnostico(DiagnosticoDto diagnostico){
        DiagnosticoModel diagnosticoModel = diagnosticoMapper.DtoToModel(diagnostico);

        Long cita_id = diagnostico.getCita_id();

        Optional<CitaModel> citaOptional = citaRepository.findById(cita_id);

        if (citaOptional.isPresent()){
            CitaModel citaModel = citaOptional.get();

            diagnosticoModel.setCita(citaModel);

            return diagnosticoMapper.ModelToDTO(diagnosticoRepository.save(diagnosticoModel));
        }else
            throw new EntityNotFoundException( "\nNo se pudo encontrar la cita con el ID: " + cita_id+"\n");
    }

    /**
     * Método que realiza la búsqueda de un diagnóstico que tenga la misma id pasada por parámetro
     * @param id (Long) Id del diagnóstico
     * @return El diagnóstico con id pasada por parámetro
     */
    public Optional<DiagnosticoDto> getById(Long id){
        DiagnosticoModel diagnostico ;
        if (diagnosticoRepository.findById(id).isPresent())
            diagnostico =  diagnosticoRepository.findById(id).get();
        else
            diagnostico = null;

        DiagnosticoDto diagnosticoDto = diagnosticoMapper.ModelToDTO(diagnostico);
        return Optional.ofNullable(diagnosticoDto);
    }


    /**
     * Método que realiza la actualización de los campos que se hayan pasado más id para definir que diagnóstico es
     * @param request (DiagnosticoModel) Datos que se quieren cambiar
     * @param id (Long) Id del diagnóstico
     * @return El diagnóstico que se ha modificado
     */
    public DiagnosticoDto updateById(DiagnosticoModel request , Long id){
        DiagnosticoModel diagnostico = diagnosticoRepository.findById(id).get();

        if (request.getValoracionEspecialista() != null)
            diagnostico.setValoracionEspecialista(request.getValoracionEspecialista());

        if (request.getEnfermedad() != null)
            diagnostico.setEnfermedad(request.getEnfermedad());


        diagnostico = diagnosticoRepository.save(diagnostico);
        return diagnosticoMapper.ModelToDTO(diagnostico);
    }

    /**
     * Borra el usuario pasado por parámetro
     * @param id (Long) Id del diagnostico
     * @return True en caso de que se haya podido realizar el borrado de esa persona, False en caso no se haya podido realizar el borrado
     */
    public Boolean deleteDiagnostico (Long id){
        if (diagnosticoRepository.findById(id).isPresent()){
            try{
                diagnosticoRepository.deleteById(id);
                return true;
            }catch (Exception e){
                return false;
            }
        }else
            return false;
    }
}
