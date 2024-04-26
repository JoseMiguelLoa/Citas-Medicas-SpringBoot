package com.example.Citas.Medicas.services;

import com.example.Citas.Medicas.Interfaces.IMedicoPaciente;
import com.example.Citas.Medicas.mapper.MedicoMapper;
import com.example.Citas.Medicas.models.MedicoModel;
import com.example.Citas.Medicas.models.PacienteModel;
import com.example.Citas.Medicas.repositories.IMedicoRepository;
import com.example.Citas.Medicas.repositories.IPacienteRepository;
import jakarta.transaction.Transactional;
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

    @Autowired
    MedicoMapper medicoMapper;

    @Autowired  //Inyección de dependencias
    MedicoService medicoService; //Uso del repositorio donde se almacenan los usuarios

    @Autowired  //Inyección de dependencias
    PacienteService pacienteService; //Uso del repositorio donde se almacenan los usuarios

    /**
     * Método que realiza el guardado en la tabla medico_paciente con las id's de ambos
     * @param idM (Long) la id del médico
     * @param idP (Long) la id del paciente
     * @return String el cual contiene el mensaje el cual determina si se ha o no guardado correctamente
     */
    public String savePacienteMedico(Long idM, Long idP) {

        String fallo = "";//String el cual almacenara en caso de haber fallos cuáles son


        //Declaración de las variables que almacenarán la id de cada uno
        Long medicoId = idM;
        Long pacienteId = idP;

        //Realización de la comprobación de sí está o no el id de cada uno de ellos en sus respectivas tablas
        Optional<PacienteModel> pacienteOptional = pacienteRepository.findById(pacienteId);
        Optional<MedicoModel> medicoOptional = medicoRepository.findById(medicoId);

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
                fallo += "\nNo se pudo encontrar el paciente con el ID: " + pacienteId + "\n";


            if (medicoOptional.isEmpty())
                // Si el médico no existe, lanza una excepción
                fallo += "\nNo se pudo encontrar el médico con el ID: " + medicoId + "\n";

            return fallo;
        }

    }

    /**
     * Método que realiza el borrado en la tabla medico_paciente con las id's de ambos
     * @param idM (Long) la id del médico
     * @param idP (Long) la id del paciente
     * @return String el cual contiene el mensaje el cual determina si se ha o no borrado correctamente
     */
    @Transactional
    public String deleteMedicoDePaciente(Long idM, Long idP) {
        String fallo = "";//String el cual almacenara en caso de haber fallos cuáles son
        // Buscar el paciente y el médico
        Optional<PacienteModel> pacienteOptional = pacienteRepository.findById(idP);
        Optional<MedicoModel> medicoOptional = medicoRepository.findById(idM);

        if (pacienteOptional.isPresent() && medicoOptional.isPresent()) {
            PacienteModel paciente = pacienteOptional.get();
            MedicoModel medico = medicoOptional.get();

            // Eliminar el médico del paciente
            paciente.getMedicos().removeIf(m -> m.getId().equals(idM));
            // Eliminar el paciente del médico
            medico.getPacientes().removeIf(p -> p.getId().equals(idP));

            // Guardar los cambios
            pacienteRepository.save(paciente);
            medicoRepository.save(medico);

            return "Relación médico-paciente eliminada correctamente";
        } else {
            if (pacienteOptional.isEmpty())
                // Si el paciente no existe, lanza una excepción
                fallo += "\nNo se pudo encontrar el paciente con el ID: " + idP + "\n";


            if (medicoOptional.isEmpty())
                // Si el médico no existe, lanza una excepción
                fallo += "\nNo se pudo encontrar el médico con el ID: " + idM + "\n";

            return fallo;
        }
    }

}
