package com.example.Citas.Medicas.dtos;

import com.example.Citas.Medicas.models.CitaModel;
import com.example.Citas.Medicas.models.MedicoModel;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class PacienteDto {


    private Long id;


    private String NSS;


    private  String numTarjeta;


    private String telefono;


    private String direccion;


    private List<MedicoModel> medicos; //Creamos una variable para crear la relación de muchos a muchos com médicos


    private List<CitaModel> citas;//Creamos una variable para crear la relación de uno a muchos con cita
}
