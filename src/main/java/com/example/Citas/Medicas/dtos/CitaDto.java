package com.example.Citas.Medicas.dtos;


import lombok.*;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class CitaDto {

    private Long id; //ID de la cita

    private Date fechaHora; //Fecha de la cita

    private String motivoCita; //Motivo de la cita

    private int attribute11; //??

    // Realizamos las relaciones de muchos a uno de la tabla paciente, médico y de uno a uno con la tabla diagnóstico
    private Long paciente_id;

    private Long medico_id;

    private Long diagnostico_id;
}
