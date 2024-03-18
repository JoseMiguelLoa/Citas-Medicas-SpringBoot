package com.example.Citas.Medicas.controllers;

import com.example.Citas.Medicas.models.MedicoModel;
import com.example.Citas.Medicas.services.MedicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/Medico") //Introducimos una ruta para las métodos
public class MedicoController {

    @Autowired //Inyección de dependencias
    private MedicoService medicoService;

    //Método que realiza la búsqueda de todos los médicos en la base de datos
    //Esta anotación se utiliza para mapear solicitudes HTTP GET.
    @GetMapping
    public ArrayList<MedicoModel> getMedicos(){
        return this.medicoService.getMedicos();
    }

    //Método que realiza el guardado de un médico pasado por parámetro
    //Esta anotación se utiliza para mapear solicitudes HTTP POST.
    @PostMapping
    public MedicoModel saveMedico(@RequestBody MedicoModel medico){
        return this.medicoService.saveMedico(medico);
    }

    //  Método que realiza la búsqueda de un médico que tenga la misma id pasada por parámetro
    @GetMapping(path = "/{id}")
    public Optional<MedicoModel> getMedicoById(@PathVariable Long id){

        return this.medicoService.getById(id);
    }


    // Método que realiza la actualización de los campos que se hayan pasado más el id para definir que médico es
    //Esta anotación se utiliza para mapear solicitudes HTTP PUT.
    @PutMapping(path = "/{id}")
    public MedicoModel updateMedicoById(@RequestBody MedicoModel request, @PathVariable("id") Long id){
        return this.medicoService.updateById(request, id);
    }


    //Borra el médico pasado por parámetro
    //Esta anotación se utiliza para mapear solicitudes HTTP DELETE.
    @DeleteMapping(path = "/{id}")
    public String deleteMedicoById(@PathVariable("id") Long id){
        boolean ok = this.medicoService.deleteMedico(id);

        if (ok)
            return "Médico de id "+id+" se eliminó correctamente";
        else
            return "Error, ha habido un problema al eliminar el médico con id "+id;
    }
}