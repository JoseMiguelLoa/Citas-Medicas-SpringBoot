package com.example.Citas.Medicas.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;


//Clase de la tabla Pacientes
@EqualsAndHashCode(callSuper = true)// El equals y el hashcode lo obtiene/hereda de la clase padre  usuario
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
@PrimaryKeyJoinColumn(referencedColumnName = "id", name="idU")
@Table(name = "Paciente")
public class PacienteModel extends UsuarioModel{
    //Declaración de las variables que serán las columnas de la tabla Paciente y sus getter y setters gracias a lombok

    @Column (unique = true)
    private String NSS;


    @Column (unique = true)
    private  String numTarjeta;

    @Column
    private String telefono;


    @Column
    private String direccion;


    @ManyToMany(mappedBy = "pacientes")
    private List<MedicoModel> medicos; //Creamos una variable para crear la relación de muchos a muchos com médicos


    @OneToMany(mappedBy = "paciente")
    private List<CitaModel> citas;//Creamos una variable para crear la relación de uno a muchos con cita

}
