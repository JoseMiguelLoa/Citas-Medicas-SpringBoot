package com.example.Citas.Medicas.services;

import com.example.Citas.Medicas.Interfaces.IDiagnostico;
import com.example.Citas.Medicas.models.DiagnosticoModel;
import com.example.Citas.Medicas.repositories.IDiagnosticoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class DiagnosticoService implements IDiagnostico {
    @Autowired  //Inyección de dependencias
    IDiagnosticoRepository diagnosticoRepository; //Uso del repositorio donde se almacenan los diagnosticos

    /**
     * Método que realiza la búsqueda de todos los diagnósticos en la base de datos
     * @return Lista de diagnósticos
     */
    public ArrayList<DiagnosticoModel> getDiagnostico(){
        return (ArrayList<DiagnosticoModel>) diagnosticoRepository.findAll();
    }

    /**
     * Método que realiza el guardado de un diagnóstico pasado por parámetro
     * @param diagnostico (DiagnosticoModel) los datos del diagnóstico
     * @return El diagnóstico  guardado
     */
    public DiagnosticoModel saveDiagnostico(DiagnosticoModel diagnostico){
        return diagnosticoRepository.save(diagnostico);
    }

    /**
     * Método que realiza la búsqueda de un diagnóstico que tenga la misma id pasada por parámetro
     * @param id (Long) Id del diagnóstico
     * @return El diagnóstico con la id pasada por parámetro
     */
    public Optional<DiagnosticoModel> getById(Long id){
        return diagnosticoRepository.findById(id);
    }


    /**
     * Método que realiza la actualización de los campos que se hayan pasado más el id para definir que diagnóstico es
     * @param request (DiagnosticoModel)  Datos que se quieren cambiar
     * @param id (Long) Id del diagnóstico
     * @return El diagnóstico que se ha modificado
     */
    public DiagnosticoModel updateById(DiagnosticoModel request , Long id){
        DiagnosticoModel diagnostico = diagnosticoRepository.findById(id).get();

        if (request.getValoracionEspecialista() != null)
            diagnostico.setValoracionEspecialista(request.getValoracionEspecialista());

        if (request.getEnfermedad() != null)
            diagnostico.setEnfermedad(request.getEnfermedad());


        diagnostico = diagnosticoRepository.save(diagnostico);
        return diagnostico;
    }

    /**
     * Borra el usuario pasado por parámetro
     * @param id (Long) Id del paciente
     * @return True en caso de que se haya podido realizar el borrado de esa persona, False en caso no se haya podido realizar el borrado
     */
    public Boolean deleteDiagnostico (Long id){
        try{
            diagnosticoRepository.deleteById(id);
            return true;
        }catch (Exception e){
            return false;
        }
    }
}
