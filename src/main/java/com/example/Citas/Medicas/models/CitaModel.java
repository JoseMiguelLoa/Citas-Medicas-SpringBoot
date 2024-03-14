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
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Genera un valor automaticamente para la clave primaria
    private Long id; //ID de la cita


    @Column //Definimos que esta variable es una columna (Opcional)
    private Date fechaHora; //Fecha de la cita


    @Column //Definimos que esta variable es una columna (Opcional)
    private String motivoCita; //Motivo de la cita


    @Column //Definimos que esta variable es una columna (Opcional)
    private int attribute11; //??


    // Realizamos la relaciones de muchos a uno de la tabla paciente , medico y diagnostico

    @ManyToOne
    @JoinColumn(name = "pacinete_id")
    private PacienteModel paciente;



    @ManyToOne
    @JoinColumn(name = "medico_id")
    private MedicoModel medico;


    @OneToOne
    @JoinColumn(name = "diagnostico_id", referencedColumnName = "id")
    private DiagnosticoModel diagnostico;

}
