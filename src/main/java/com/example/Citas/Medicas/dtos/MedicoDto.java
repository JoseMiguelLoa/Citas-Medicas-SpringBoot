package com.example.Citas.Medicas.dtos;

import com.example.Citas.Medicas.models.CitaModel;
import com.example.Citas.Medicas.models.PacienteModel;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class MedicoDto
{

    private  Long id;

    private String numColegiado;

    private List<PacienteModel> pacientes; //Creamos una variable para crear la relación de muchos a muchos com pacientes

    private List<CitaModel> citas;//Creamos una variable para crear la relación de uno a muchos con cita



}
