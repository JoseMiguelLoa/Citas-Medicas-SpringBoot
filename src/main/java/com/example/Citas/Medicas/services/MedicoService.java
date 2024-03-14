package com.example.Citas.Medicas.services;

import com.example.Citas.Medicas.Interfaces.IMedico;
import com.example.Citas.Medicas.models.MedicoModel;
import com.example.Citas.Medicas.repositories.IMedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class MedicoService  implements IMedico {

    @Autowired  //Inyección de dependencias
    IMedicoRepository medicoRepository; //Uso del repositorio donde se almacenan los médicos

    @Autowired  //Inyección de dependencias
    UsuarioService usuarioService; //Uso del repositorio donde se almacenan los usuarios

    /**
     * Método que realiza la búsqueda de todos los pacientes en la base de datos
     * @return Lista de pacientes
     */
    public ArrayList<MedicoModel> getMedicos(){
        return (ArrayList<MedicoModel>) medicoRepository.findAll();
    }

    /**
     * Método que realiza el guardado de un médico pasado por parámetro
     * @param medico (MedicoModel) los datos del paciente
     * @return El médico guardado
     */
    public MedicoModel saveMedico(MedicoModel medico){
        return medicoRepository.save(medico);
    }

    /**
     * Método que realiza la búsqueda de un médico que tenga la misma id pasada por parámetro
     * @param id (Long) Id del médico
     * @return el médico con la id pasada por parámetro
     */
    public Optional<MedicoModel> getById(Long id){
        return medicoRepository.findById(id);
    }

    /**
     * Método que realiza la actualización de los campos que se hayan pasado más el id para definir que médico es
     * @param request (MedicoModel)  Datos que se quieren cambiar
     * @param id (Long) Id del médico
     * @return el médico que se ha modificado
     */
    public MedicoModel updateById(MedicoModel request , Long id){
        MedicoModel medico = medicoRepository.findById(id).get();

        usuarioService.updateById( request,id);//Hacemos uso del método creado anteriormente en la clase UsuarioService para realizar la actualización de los datos

        if (request.getNumColegiado() != null)
            medico.setNumColegiado(request.getNumColegiado());

        medico= medicoRepository.save(medico);
        return medico;
    }


    /**
     * Borra el Médico pasado por parámetro
     * @param id (Long) Id del medico
     * @return True en caso de que se haya podido realizar el borrado de esa persona, False en caso no se haya podido realizar el borrado
     */
    public Boolean deleteMedico (Long id){
        try{
            medicoRepository.deleteById(id);
            return true;
        }catch (Exception e){
            return false;
        }
    }
}
