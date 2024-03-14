package com.example.Citas.Medicas.dtos;

import com.example.Citas.Medicas.models.CitaModel;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class DiagnosticoDto {

    //Declaración de las variables que serán las columnas de la tabla diagnostico y sus getter y setters gracias a lombok
    private Long id; //ID del diagnóstico

    private String valoracionEspecialista; //Valoración del especialista en el diagnóstico

    private String enfermedad;

    private CitaModel cita; //Relación 1 a 1 de la tabla diagnostico-cita
}
