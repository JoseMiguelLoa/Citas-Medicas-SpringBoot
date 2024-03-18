package com.example.Citas.Medicas.dtos;


import lombok.*;


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


}
