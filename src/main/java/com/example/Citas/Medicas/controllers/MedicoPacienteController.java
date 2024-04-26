package com.example.Citas.Medicas.controllers;


import com.example.Citas.Medicas.models.PacienteModel;
import com.example.Citas.Medicas.services.MedicoPacienteService;
import com.example.Citas.Medicas.services.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("MedPac/") //Introducimos una ruta para los métodos
public class MedicoPacienteController {

    @Autowired //Inyección de dependencias
    private MedicoPacienteService medicoPacienteService;

    @PostMapping(path = "{idM}/{idP}")
    public String savePacienteMedico(@PathVariable("idM") Long idM, @PathVariable("idP") Long idP){
        return this.medicoPacienteService.savePacienteMedico(idM,idP);
    }


    @DeleteMapping(path = "delete/{idM}/{idP}")
    public String deleteMedicoDePaciente( @PathVariable("idM") Long idM, @PathVariable("idP") Long idP){
        return medicoPacienteService.deleteMedicoDePaciente(idM,idP);
    }




}
