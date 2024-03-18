package com.example.Citas.Medicas.services;

import com.example.Citas.Medicas.Interfaces.IUsuario;
import com.example.Citas.Medicas.dtos.UsuarioDto;
import com.example.Citas.Medicas.mapper.UsuarioMapper;
import com.example.Citas.Medicas.models.UsuarioModel;
import com.example.Citas.Medicas.repositories.IUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

//Clase donde se realizan todas los métodos de la tabla usuario
@Service
public class UsuarioService implements IUsuario {

    @Autowired  //Inyección de dependencias
    IUsuarioRepository usuarioRepository; //Uso del repositorio donde se almacenan los usuarios

    @Autowired
    private UsuarioMapper usuarioMapper; // Variable del mapper

    /**
     * Método que realiza la búsqueda de todos los usuarios en la base de datos
     * @return Lista de usuarios
     */
    public List<UsuarioDto> getUsuarios() {
        List<UsuarioModel> usuarios = usuarioRepository.findAll();
        return usuarioMapper.ListaModelToListaDto(usuarios);
    }

    /**
     * Método que realiza el guardado de un usuario pasado por parámetro
     * @param usuario (UsuarioDto) los datos del usuario
     * @return El usuario guardado
     */
    public UsuarioDto saveUsuario(UsuarioModel usuario){
        // Convertir el UsuarioDto a UsuarioModel utilizando el mapper

        return usuarioMapper.ModelToDTO(usuarioRepository.save(usuario));
    }

    /**
     * Método que realiza la búsqueda de un usuario que tenga la misma id pasada por parámetro
     *
     * @param id (Long) Id del usuario
     * @return el usuario con la id pasada por parámetro
     */
    public Optional<UsuarioDto> getById(Long id){
        UsuarioModel usuario;
        if (usuarioRepository.findById(id).isPresent())
             usuario =  usuarioRepository.findById(id).get();
        else
            usuario = null;

        UsuarioDto usuarioDto = usuarioMapper.ModelToDTO(usuario);
        return Optional.ofNullable(usuarioDto);
    }


    /**
     * Método que realiza la actualización de los campos que se hayan pasado más el id para definir que usuario es
     * @param request (UsuarioModel) Datos que se quieren cambiar
     * @param id (Long) Id del usuario
     * @return el usuario que se ha modificado
     */
    public UsuarioDto updateById(UsuarioModel request , Long id){
        UsuarioModel usuario;
        if ( usuarioRepository.findById(id).isPresent()){

                usuario = usuarioRepository.findById(id).get();

            if (request.getNombre() != null)
                usuario.setNombre(request.getNombre());

            if (request.getApellidos() != null)
                usuario.setApellidos(request.getApellidos());

            if (request.getUsuario() != null)
                usuario.setUsuario(request.getUsuario());

            if (request.getClave() != null)
                usuario.setClave(request.getClave());

            usuario = usuarioRepository.save(usuario);
        }else
            usuario = null;


        return   usuarioMapper.ModelToDTO(usuario);
    }


    /**
     * Borra el usuario pasado por parámetro
     * @param id (Long) Id del paciente
     * @return True en caso de que se haya podido realizar el borrado de esa persona, False en caso no se haya podido realizar el borrado
     */
    public Boolean deleteUsuario (Long id){
        if (usuarioRepository.findById(id).isPresent()){
            try{
                usuarioRepository.deleteById(id);
                return true;
            }catch (Exception e){
                return false;
            }
        }else
            return false;
    }


}
