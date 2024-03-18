package com.example.Citas.Medicas.dtos;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class DiagnosticoDto {

    //Declaración de las variables que serán las columnas de la tabla diagnóstico y sus getter y setters gracias a lombok
    private Long id; //ID del diagnóstico

    private String valoracionEspecialista; //Valoración del especialista en el diagnóstico

    private String enfermedad;
}
