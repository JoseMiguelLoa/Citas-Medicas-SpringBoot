package com.example.Citas.Medicas.services;

import com.example.Citas.Medicas.Interfaces.IPaciente;
import com.example.Citas.Medicas.models.PacienteModel;
import com.example.Citas.Medicas.repositories.IPacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

//Clase donde se realizan todas los métodos de la tabla paciente
@Service
public class PacienteService implements IPaciente {

    @Autowired  //Inyección de dependencias
    IPacienteRepository pacienteRepository; //Uso del repositorio donde se almacenan los pacientes

    @Autowired  //Inyección de dependencias
    UsuarioService usuarioService; //Uso del repositorio donde se almacenan los usuarios

    /**
     * Método que realiza la búsqueda de todos los pacientes en la base de datos
     * @return Lista de pacientes
     */
    public ArrayList<PacienteModel> getPacientes(){
        return (ArrayList<PacienteModel>) pacienteRepository.findAll();
    }


    /**
     * Método que realiza el guardado de un paciente pasado por parámetro
     * @param paciente (PacienteModel) los datos del paciente
     * @return El paciente guardado
     */
    public PacienteModel savePaciente(PacienteModel paciente){
        return pacienteRepository.save(paciente);
    }


    /**
     * Método que realiza la búsqueda de un paciente que tenga la misma id pasada por parámetro
     * @param id (Long) Id del paciente
     * @return el paciente con la id pasada por parámetro
     */
    public Optional<PacienteModel> getById(Long id){
        return pacienteRepository.findById(id);
    }


    /**
     * Método que realiza la actualización de los campos que se hayan pasado más el id para definir que paciente es
     * @param request (PacienteModel)  Datos que se quieren cambiar
     * @param id (Long) Id del paciente
     * @return el paciente que se ha modificado
     */
    public PacienteModel updateById(PacienteModel request , Long id){
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
        return paciente;
    }

    /**
     * Borra el paciente pasado por parámetro
     * @param id (Long) Id del paciente
     * @return True en caso de que se haya podido realizar el borrado de esa persona, False en caso no se haya podido realizar el borrado
     */
    public Boolean deletePaciente (Long id){
        try{
            pacienteRepository.deleteById(id);
            return true;
        }catch (Exception e){
            return false;
        }
    }


}
