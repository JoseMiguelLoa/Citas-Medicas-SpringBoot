package com.example.Citas.Medicas.repositories;

import com.example.Citas.Medicas.models.PacienteModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPacienteRepository extends JpaRepository<PacienteModel,Long> {
}
