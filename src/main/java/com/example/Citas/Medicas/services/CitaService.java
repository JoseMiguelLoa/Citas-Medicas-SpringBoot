package com.example.Citas.Medicas.services;

import com.example.Citas.Medicas.Interfaces.ICita;
import com.example.Citas.Medicas.models.CitaModel;
import com.example.Citas.Medicas.repositories.ICitaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class CitaService implements ICita {
    @Autowired  //Inyección de dependencias
    ICitaRepository citaRepository; //Uso del repositorio donde se almacenan las citas


    /**
     * Método que realiza la búsqueda de todos las citas en la base de datos
     * @return Lista de citas
     */
    public ArrayList<CitaModel> getCitas(){
        return (ArrayList<CitaModel>) citaRepository.findAll();
    }

    /**
     * Método que realiza el guardado de una cita pasado por parámetro
     * @param cita (CitaModel) los datos de la cita
     * @return La cita guardada
     */
    public CitaModel saveCita(CitaModel cita){
        return citaRepository.save(cita);
    }

    /**
     * Método que realiza la búsqueda de una cita que tenga la misma id pasada por parámetro
     * @param id (Long) Id de la cita
     * @return la cita con la id pasada por parámetro
     */
    public Optional<CitaModel> getById(Long id){return citaRepository.findById(id);}

    /**
     * Método que realiza la actualización de los campos que se hayan pasado más el id para definir que cita es
     * @param request (CitaModel)  Datos que se quieren cambiar
     * @param id (Long) Id de la cita
     * @return el cita que se ha modificado
     */
    public CitaModel updateById(CitaModel request , Long id){
        CitaModel cita = citaRepository.findById(id).get();

        if (request.getFechaHora() != null)
            cita.setFechaHora(request.getFechaHora());

        if (request.getMotivoCita() != null)
            cita.setMotivoCita(request.getMotivoCita());

        if (request.getAttribute11() > 0)
            cita.setAttribute11(request.getAttribute11());


        cita = citaRepository.save(cita);
        return cita;
    }


    /**
     * Borra la cita pasado por parámetro
     * @param id (Long) Id de la cita
     * @return True en caso de que se haya podido realizar el borrado de esa cita, False en caso no se haya podido realizar el borrado
     */
    public Boolean deleteCita (Long id){
        try{
            citaRepository.deleteById(id);
            return true;
        }catch (Exception e){
            return false;
        }
    }


}
