package com.example.Citas.Medicas.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
@Table(name = "Cita")
public class CitaModel {


    @Id//Identificador primario
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Genera un valor automáticamente para la clave primaria
    private Long id; //ID de la cita


    @Column //Definimos que esta variable es una columna (Opcional)
    private Date fechaHora; //Fecha de la cita


    @Column //Definimos que esta variable es una columna (Opcional)
    private String motivoCita; //Motivo de la cita


    @Column //Definimos que esta variable es una columna (Opcional)
    private int attribute11; //??


    // Realizamos las relaciones de muchos a uno de la tabla paciente, médico y diagnóstico
    @ManyToOne
    @JoinColumn(name = "pacienteId")
    private PacienteModel paciente;



    @ManyToOne
    @JoinColumn(name = "medicoId")
    private MedicoModel medico;


    @OneToOne( mappedBy = "cita", cascade = CascadeType.ALL)
    private DiagnosticoModel diagnostico;

}
