package com.example.Citas.Medicas.controllers;

import com.example.Citas.Medicas.dtos.UsuarioDto;
import com.example.Citas.Medicas.models.UsuarioModel;
import com.example.Citas.Medicas.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/Usuario") //Introducimos una ruta para las métodos
public class UsuarioController {
    @Autowired //Inyección de dependencias
    private UsuarioService usuarioService;



    //Método que realiza la búsqueda de todos los usuarios en la base de datos
    //Esta anotación se utiliza para mapear solicitudes HTTP GET.
    @GetMapping
    public List<UsuarioDto> getUsuarios(){
        return this.usuarioService.getUsuarios();
    }


    //Método que realiza el guardado de un usuario pasado por parámetro
    //Esta anotación se utiliza para mapear solicitudes HTTP POST.
    @PostMapping
    public UsuarioModel saveUsuario(@RequestBody UsuarioModel usuario){
        return this.usuarioService.saveUsuario(usuario);
    }


    //  Método que realiza la búsqueda de un usuario que tenga la misma id pasada por parámetro
    @GetMapping(path = "/{id}")
    public Optional<UsuarioModel> getUsuarioById(@PathVariable Long id){

        return this.usuarioService.getById(id);
    }

    // Método que realiza la actualización de los campos que se hayan pasado más el id para definir que usuario es
    @PutMapping(path = "/{id}")
    public UsuarioModel updateUsuarioById(@RequestBody UsuarioModel request, @PathVariable("id") Long id){
        return this.usuarioService.updateById(request, id);
    }

    //Borra el usuario pasado por parámetro
    @DeleteMapping(path = "/{id}")
    public String deleteUsuarioById(@PathVariable("id") Long id){
        boolean ok = this.usuarioService.deleteUsuario(id);

        if (ok)
            return "Usuario de id "+id+" se eliminó correctamente";
        else
            return "Error, ha habido un problema al eliminar el usuario con id "+id;
    }
}
