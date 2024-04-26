package com.example.Citas.Medicas.controllers;

import com.example.Citas.Medicas.dtos.CitaDto;
import com.example.Citas.Medicas.models.CitaModel;
import com.example.Citas.Medicas.services.CitaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("Cita/") //Introducimos una ruta para los métodos
public class CitaController {

    @Autowired //Inyección de dependencias
    private CitaService citaService;

    //Método que realiza la búsqueda de todos las citas en la base de datos
    //Esta anotación se utiliza para mapear solicitudes HTTP GET.
    @GetMapping
    public List<CitaDto> getCita(){
        return this.citaService.getCitas();
    }

    //Método que realiza el guardado de una cita pasado por parámetro
    //Esta anotación se utiliza para mapear solicitudes HTTP POST.
    @PostMapping
    public CitaDto saveCita(@RequestBody CitaDto cita){
        return this.citaService.saveCita(cita);
    }


    //  Método que realiza la búsqueda de una cita que tenga la misma id pasada por parámetro
    @GetMapping(path = "{id}")
    public Optional<CitaDto> getCitaById(@PathVariable Long id){

        return this.citaService.getById(id);
    }


    // Método que realiza la actualización de los campos que se hayan pasado más id para definir que cita es
    //Esta anotación se utiliza para mapear solicitudes HTTP PUT.
    @PatchMapping(path = "{id}")
    public CitaDto updateCitaById(@RequestBody CitaModel request, @PathVariable("id") Long id){
        return this.citaService.updateById(request, id);
    }


    //Borra la cita pasada por parámetro
    //Esta anotación se utiliza para mapear solicitudes HTTP DELETE.
    @DeleteMapping(path = "{id}")
    public String deleteCitaById(@PathVariable("id") Long id){
        boolean ok = this.citaService.deleteCita(id);

        if (ok)
            return "Cita de id "+id+" se eliminó correctamente";
        else
            return "Error, ha habido un problema al eliminar la cita con id "+id;
    }
}
