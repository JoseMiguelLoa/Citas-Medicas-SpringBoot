package com.example.Citas.Medicas.dtos;


import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class UsuarioDto {

    //Declaración de las variables que serán las columnas de la tabla usuario y sus getter y setters gracias a lombok
    private Long id; //ID del usuario


    private String nombre; //Nombre del usuario


    private String apellidos; //apellidos del usuario


    private String usuario; //Nombre del perfil del usuario


    private String clave; //contraseña del usuario
}
