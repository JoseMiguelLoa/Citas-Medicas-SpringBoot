package com.example.Citas.Medicas.services;

import com.example.Citas.Medicas.Interfaces.IMedicoPaciente;
import com.example.Citas.Medicas.models.DiagnosticoModel;
import com.example.Citas.Medicas.models.MedicoModel;
import com.example.Citas.Medicas.models.PacienteModel;
import com.example.Citas.Medicas.repositories.IMedicoRepository;
import com.example.Citas.Medicas.repositories.IPacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MedicoPacienteService implements IMedicoPaciente {
    @Autowired  //Inyección de dependencias
    IMedicoRepository medicoRepository; //Uso del repositorio donde se almacenan los médicos

    @Autowired  //Inyección de dependencias
    IPacienteRepository pacienteRepository; //Uso del repositorio donde se almacenan los pacientes


    public String savePacienteMedico(Long idM, Long idP) {

        String fallo = "";//String el cual almacenara en caso de haber fallos cuáles son


        //Declaración de las variables que almacenarán la id de cada uno
        Long medico_id = idM;
        Long paciente_id = idP;

        //Realización de la comprobación de sí está o no el id de cada uno de ellos en sus respectivas tablas
        Optional<PacienteModel> pacienteOptional = pacienteRepository.findById(paciente_id);
        Optional<MedicoModel> medicoOptional = medicoRepository.findById(medico_id);

        if (medicoOptional.isPresent() && pacienteOptional.isPresent()) {

            //Guardamos el paciente y el médico
            PacienteModel pacienteModel = pacienteOptional.get();
            MedicoModel medicoModel = medicoOptional.get();


            //Realizamos el guardado del nuevo médico que se le asigna al paciente
            List<MedicoModel> medicosDePaciente = pacienteModel.getMedicos();
            medicosDePaciente.add(medicoModel);
            pacienteModel.setMedicos(medicosDePaciente);

            //Realizamos el guardado del nuevo paciente que se le asigna al médico
            List<PacienteModel> pacientesDeMedico = medicoModel.getPacientes();
            pacientesDeMedico.add(pacienteModel);
            medicoModel.setPacientes(pacientesDeMedico);


            //Guardo los cambios realizados;
            medicoRepository.save(medicoModel);
            pacienteRepository.save(pacienteModel);

            return "Realizado";

        } else {
            if (pacienteOptional.isEmpty())
                // Si el paciente no existe, lanza una excepción
                fallo += "\nNo se pudo encontrar el paciente con el ID: " + paciente_id + "\n";


            if (medicoOptional.isEmpty())
                // Si el médico no existe, lanza una excepción
                fallo += "\nNo se pudo encontrar el médico con el ID: " + medico_id + "\n";

            return fallo;
        }
    }
}
