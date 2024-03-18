package com.example.Citas.Medicas.Interfaces;

import com.example.Citas.Medicas.dtos.MedicoDto;
import com.example.Citas.Medicas.dtos.PacienteDto;
import com.example.Citas.Medicas.models.MedicoModel;

import java.util.List;
import java.util.Optional;

public interface IMedico {

    List<MedicoDto> getMedicos();

    MedicoDto saveMedico(MedicoModel medico);

    Optional<MedicoDto> getById(Long id);

    MedicoDto updateById(MedicoModel request , Long id);

    Boolean deleteMedico (Long id);

    List<PacienteDto> ListaDePacientesMedico(Long id);

}
