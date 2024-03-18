package com.example.Citas.Medicas.Interfaces;

import com.example.Citas.Medicas.dtos.MedicoDto;
import com.example.Citas.Medicas.dtos.PacienteDto;
import com.example.Citas.Medicas.models.PacienteModel;

import java.util.List;
import java.util.Optional;

public interface IPaciente {

    List<PacienteDto> getPacientes();

    PacienteDto savePaciente(PacienteModel paciente);

    Optional<PacienteDto> getById(Long id);

    PacienteDto updateById(PacienteModel request , Long id);

    Boolean deletePaciente (Long id);

    List<MedicoDto> ListaDeMedicosPaciente(Long id);
}
