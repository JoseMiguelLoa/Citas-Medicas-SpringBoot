package com.example.Citas.Medicas.Interfaces;

import com.example.Citas.Medicas.models.PacienteModel;

import java.util.ArrayList;
import java.util.Optional;

public interface IPaciente {

    ArrayList<PacienteModel> getPacientes();

    PacienteModel savePaciente(PacienteModel paciente);

    Optional<PacienteModel> getById(Long id);

    PacienteModel updateById(PacienteModel request , Long id);

    Boolean deletePaciente (Long id);
}
