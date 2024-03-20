package com.example.Citas.Medicas.controllers;


import com.example.Citas.Medicas.services.MedicoPacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/MedPac") //Introducimos una ruta para los métodos
public class MedicoPacienteController {

    @Autowired //Inyección de dependencias
    private MedicoPacienteService medicoPacienteService;

    @PutMapping(path = "/{idM}/{idP}")
    public String savePacienteMedico(@PathVariable("idM") Long idM, @PathVariable("idP") Long idP){
        return this.medicoPacienteService.savePacienteMedico(idM,idP);
    }




}
