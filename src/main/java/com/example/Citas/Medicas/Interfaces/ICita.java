package com.example.Citas.Medicas.Interfaces;

import com.example.Citas.Medicas.dtos.CitaDto;
import com.example.Citas.Medicas.models.CitaModel;

import java.util.List;
import java.util.Optional;

public interface ICita {

    List<CitaDto> getCitas();

    CitaDto saveCita(CitaDto cita);

    Optional<CitaDto> getById(Long id);

    CitaDto updateById(CitaModel request , Long id);

    Boolean deleteCita (Long id);
}
