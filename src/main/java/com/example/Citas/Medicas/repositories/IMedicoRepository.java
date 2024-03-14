package com.example.Citas.Medicas.repositories;

import com.example.Citas.Medicas.models.MedicoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IMedicoRepository extends JpaRepository<MedicoModel,Long> {

}
