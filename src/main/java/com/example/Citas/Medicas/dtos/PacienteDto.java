package com.example.Citas.Medicas.dtos;


import lombok.*;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class PacienteDto {


    private Long id;


    private String NSS;//Número de la seguridad social


    private  String numTarjeta;


    private String telefono;


    private String direccion;


}
