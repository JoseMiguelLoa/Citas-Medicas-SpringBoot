package com.example.Citas.Medicas.repositories;

import com.example.Citas.Medicas.models.CitaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICitaRepository extends JpaRepository<CitaModel,Long> {
}
