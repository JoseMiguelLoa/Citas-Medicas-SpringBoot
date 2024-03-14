package com.example.Citas.Medicas.repositories;

import com.example.Citas.Medicas.models.CitaModel;
import com.example.Citas.Medicas.models.DiagnosticoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IDiagnosticoRepository extends JpaRepository<DiagnosticoModel,Long> {
}
