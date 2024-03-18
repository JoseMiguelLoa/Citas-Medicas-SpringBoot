package com.example.Citas.Medicas.Interfaces;

import com.example.Citas.Medicas.dtos.UsuarioDto;
import com.example.Citas.Medicas.models.UsuarioModel;

import java.util.List;
import java.util.Optional;

public interface IUsuario {
    List<UsuarioDto> getUsuarios();

    UsuarioDto saveUsuario(UsuarioModel usuario);

    Optional<UsuarioDto> getById(Long id);

    UsuarioDto updateById(UsuarioModel request , Long id);

    Boolean deleteUsuario (Long id);
}
