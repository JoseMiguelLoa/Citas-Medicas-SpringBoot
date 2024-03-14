package com.example.Citas.Medicas.services;

import com.example.Citas.Medicas.Interfaces.IUsuario;
import com.example.Citas.Medicas.models.UsuarioModel;
import com.example.Citas.Medicas.repositories.IUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

//Clase donde se realizan todas los métodos de la tabla usuario
@Service
public class UsuarioService implements IUsuario {

    @Autowired  //Inyección de dependencias
    IUsuarioRepository usuarioRepository; //Uso del repositorio donde se almacenan los usuarios

    /**
     * Método que realiza la búsqueda de todos los usuarios en la base de datos
     * @return Lista de usuarios
     */
    public ArrayList<UsuarioModel> getUsuarios(){
        return (ArrayList<UsuarioModel>) usuarioRepository.findAll();
    }

    /**
     * Método que realiza el guardado de un usuario pasado por parámetro
     * @param usuario (UsuarioModel ) los datos del usuario
     * @return El usuario guardado
     */
    public UsuarioModel saveUsuario(UsuarioModel usuario){
        return usuarioRepository.save(usuario);
    }

    /**
     * Método que realiza la búsqueda de un usuario que tenga la misma id pasada por parámetro
     * @param id (Long) Id del usuario
     * @return el usuario con la id pasada por parámetro
     */
    public Optional<UsuarioModel> getById(Long id){
        return usuarioRepository.findById(id);
    }


    /**
     * Método que realiza la actualización de los campos que se hayan pasado más el id para definir que usuario es
     * @param request (UsuarioModel)  Datos que se quieren cambiar
     * @param id (Long) Id del usuario
     * @return el usuario que se ha modificado
     */
    public UsuarioModel updateById(UsuarioModel request , Long id){
        UsuarioModel usuario = usuarioRepository.findById(id).get();

        if (request.getNombre() != null)
            usuario.setNombre(request.getNombre());

        if (request.getApellidos() != null)
            usuario.setApellidos(request.getApellidos());

        if (request.getUsuario() != null)
            usuario.setUsuario(request.getUsuario());

        if (request.getClave() != null)
            usuario.setClave(request.getClave());

        usuario = usuarioRepository.save(usuario);
        return usuario;
    }


    /**
     * Borra el usuario pasado por parámetro
     * @param id (Long) Id del paciente
     * @return True en caso de que se haya podido realizar el borrado de esa persona, False en caso no se haya podido realizar el borrado
     */
    public Boolean deleteUsuario (Long id){
        try{
            usuarioRepository.deleteById(id);
            return true;
        }catch (Exception e){
            return false;
        }
    }


}
