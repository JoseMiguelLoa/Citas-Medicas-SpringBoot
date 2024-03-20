package com.example.Citas.Medicas.Interfaces;

import com.example.Citas.Medicas.dtos.DiagnosticoDto;
import com.example.Citas.Medicas.models.DiagnosticoModel;

import java.util.List;
import java.util.Optional;

public interface IDiagnostico {
    List<DiagnosticoDto> getDiagnostico();

    DiagnosticoDto saveDiagnostico(DiagnosticoDto diagnostico);

    Optional<DiagnosticoDto> getById(Long id);

    DiagnosticoDto updateById(DiagnosticoModel request , Long id);

    Boolean deleteDiagnostico (Long id);



}
