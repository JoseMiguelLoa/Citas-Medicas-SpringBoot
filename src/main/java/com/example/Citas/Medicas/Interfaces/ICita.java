package com.example.Citas.Medicas.Interfaces;

import com.example.Citas.Medicas.models.CitaModel;

import java.util.ArrayList;
import java.util.Optional;

public interface ICita {

    ArrayList<CitaModel> getCitas();

    CitaModel saveCita(CitaModel cita);

    Optional<CitaModel> getById(Long id);

    CitaModel updateById(CitaModel request , Long id);

    Boolean deleteCita (Long id);
}
