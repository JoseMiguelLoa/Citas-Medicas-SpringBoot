package com.example.Citas.Medicas.controllers;

import com.example.Citas.Medicas.dtos.DiagnosticoDto;
import com.example.Citas.Medicas.models.DiagnosticoModel;
import com.example.Citas.Medicas.services.DiagnosticoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/Diagnostico") //Introducimos una ruta para los métodos
public class DiagnosticoController {

    @Autowired //Inyección de dependencias
    private DiagnosticoService diagnosticoService;

    //Método que realiza la búsqueda de todos los diagnóstico en la base de datos
    //Esta anotación se utiliza para mapear solicitudes HTTP GET.
    @GetMapping
    public List<DiagnosticoDto> getDiagnosticos(){
        return this.diagnosticoService.getDiagnostico();
    }


    //Método que realiza el guardado de un diagnóstico pasado por parámetro
    //Esta anotación se utiliza para mapear solicitudes HTTP POST.
    @PostMapping
    public DiagnosticoDto saveDiagnostico(@RequestBody DiagnosticoDto diagnostico){
        return this.diagnosticoService.saveDiagnostico(diagnostico);
    }

    //  Método que realiza la búsqueda de un diagnóstico que tenga la misma id pasada por parámetro
    @GetMapping(path = "/{id}")
    public Optional<DiagnosticoDto> getDiagnosticoById(@PathVariable Long id){

        return this.diagnosticoService.getById(id);
    }


    // Método que realiza la actualización de los campos que se hayan pasado más el id para definir que diagnóstico es
    @PutMapping(path = "/{id}")
    public DiagnosticoDto updateDiagnosticoById(@RequestBody DiagnosticoModel request, @PathVariable("id") Long id){
        return this.diagnosticoService.updateById(request, id);
    }


    //Borra el diagnóstico pasado por parámetro
    @DeleteMapping(path = "/{id}")
    public String deleteDiagnosticoById(@PathVariable("id") Long id){
        boolean ok = this.diagnosticoService.deleteDiagnostico(id);

        if (ok)
            return "Diagnóstico de id "+id+" se eliminó correctamente";
        else
            return "Error, ha habido un problema al eliminar el diagnóstico con id "+id;
    }
}
