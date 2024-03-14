package com.example.Citas.Medicas.models;

import jakarta.persistence.*;
import lombok.*;

//Clase de la tabla usuario
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Inheritance( strategy = InheritanceType.JOINED) //Para que la tabla usuario pueda ser heredada
@Table(name = "usuario")
public class UsuarioModel {

    //Declaración de las variables que serán las columnas de la tabla usuario y sus getter y setters gracias a lombok

    @Id //Identificador primario
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Genera un valor automaticamente para la clave primaria
    private Long id; //ID del usuario


    @Column //Definimos que esta variable es una columna (Opcional)
    private String nombre; //Nombre del usuario


    @Column
    private String apellidos; //apellidos del usuario

    @Column
    private String usuario; //Nombre del perfil del usuario

    @Column
    private String clave; //contraseña del usuario




}
