package com.example.Citas.Medicas.Interfaces;

import com.example.Citas.Medicas.models.DiagnosticoModel;

import java.util.ArrayList;
import java.util.Optional;

public interface IDiagnostico {
    ArrayList<DiagnosticoModel> getDiagnostico();

    DiagnosticoModel saveDiagnostico(DiagnosticoModel diagnostico);

    Optional<DiagnosticoModel> getById(Long id);

    DiagnosticoModel updateById(DiagnosticoModel request , Long id);

    Boolean deleteDiagnostico (Long id);
}
