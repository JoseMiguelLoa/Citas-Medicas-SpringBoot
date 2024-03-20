package com.example.Citas.Medicas.models;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
@Table(name = "Diagnostico")
public class DiagnosticoModel  {
    //Declaración de las variables que serán las columnas de la tabla diagnóstico y sus getter y setters gracias a lombok

    @Id //Identificador primario
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Genera un valor automáticamente para la clave primaria
    private Long id; //ID del diagnóstico



    @Column //Definimos que esta variable es una columna (Opcional)
    private String valoracionEspecialista; //Valoración del especialista en el diagnóstico

    @Column
    private String enfermedad;


    @OneToOne
    @JoinColumn(name = "cita_id", referencedColumnName = "id" )
    private CitaModel cita;
}
