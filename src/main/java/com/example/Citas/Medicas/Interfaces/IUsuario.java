package com.example.Citas.Medicas.Interfaces;

import com.example.Citas.Medicas.models.UsuarioModel;

import java.util.ArrayList;
import java.util.Optional;

public interface IUsuario {
    ArrayList<UsuarioModel> getUsuarios();

    UsuarioModel saveUsuario(UsuarioModel usuario);

    Optional<UsuarioModel> getById(Long id);

    UsuarioModel updateById(UsuarioModel request , Long id);

    Boolean deleteUsuario (Long id);
}
