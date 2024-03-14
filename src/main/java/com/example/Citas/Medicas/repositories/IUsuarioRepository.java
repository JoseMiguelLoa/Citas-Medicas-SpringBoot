package com.example.Citas.Medicas.repositories;

import com.example.Citas.Medicas.models.UsuarioModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface IUsuarioRepository extends JpaRepository<UsuarioModel,Long> {


}
