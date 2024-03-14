package com.example.Citas.Medicas.controllers;

import com.example.Citas.Medicas.models.PacienteModel;
import com.example.Citas.Medicas.services.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/Paciente") //Introducimos una ruta para las métodos
public class PacienteController {

    @Autowired //Inyección de dependencias
    private PacienteService pacienteService;

    //Método que realiza la búsqueda de todos los pacientes en la base de datos
    //Esta anotación se utiliza para mapear solicitudes HTTP GET.
    @GetMapping
    public ArrayList<PacienteModel> getPacientes(){
        return this.pacienteService.getPacientes();
    }

    //Método que realiza el guardado de un paciente pasado por parámetro
    //Esta anotación se utiliza para mapear solicitudes HTTP POST.
    @PostMapping
    public PacienteModel savePaciente(@RequestBody PacienteModel paciente){
        return this.pacienteService.savePaciente(paciente);
    }



    //  Método que realiza la búsqueda de un paciente que tenga la misma id pasada por parámetro
    @GetMapping(path = "/{id}")
    public Optional<PacienteModel> getPacienteById(@PathVariable Long id){

        return this.pacienteService.getById(id);
    }

    // Método que realiza la actualización de los campos que se hayan pasado más el id para definir que paciente es
    //Esta anotación se utiliza para mapear solicitudes HTTP PUT.
    @PutMapping(path = "/{id}")
    public PacienteModel updatePacienteById(@RequestBody PacienteModel request, @PathVariable("id") Long id){
        return this.pacienteService.updateById(request, id);
    }

    //Borra el paciente pasado por parámetro
    //Esta anotación se utiliza para mapear solicitudes HTTP DELETE.
    @DeleteMapping(path = "/{id}")
    public String deletePacienteById(@PathVariable("id") Long id){
        boolean ok = this.pacienteService.deletePaciente(id);

        if (ok)
            return "Paciente de id "+id+" se eliminó correctamente";
        else
            return "Error, ha habido un problema al eliminar el paciente con id "+id;
    }
}
