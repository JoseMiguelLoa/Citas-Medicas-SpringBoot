package com.example.Citas.Medicas.dtos;

import com.example.Citas.Medicas.models.DiagnosticoModel;
import com.example.Citas.Medicas.models.MedicoModel;
import com.example.Citas.Medicas.models.PacienteModel;
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

    // Realizamos la relaciones de muchos a uno de la tabla paciente , medico y  de uno a uno con  la tabla diagnostico
    private PacienteModel paciente;

    private MedicoModel medico;

    private DiagnosticoModel diagnostico;
}
