package com.example.Citas.Medicas.Interfaces;

import com.example.Citas.Medicas.models.MedicoModel;

import java.util.ArrayList;
import java.util.Optional;

public interface IMedico {

    ArrayList<MedicoModel> getMedicos();

    MedicoModel saveMedico(MedicoModel medico);

    Optional<MedicoModel> getById(Long id);

    MedicoModel updateById(MedicoModel request , Long id);

    Boolean deleteMedico (Long id);

}
