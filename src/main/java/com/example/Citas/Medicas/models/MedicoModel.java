package com.example.Citas.Medicas.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@EqualsAndHashCode(callSuper = true)// El equals y el hashcode lo obtiene/hereda de la clase padre usuario
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
@PrimaryKeyJoinColumn(referencedColumnName = "id", name="idU")
@Table(name = "Medico")
public class MedicoModel extends UsuarioModel{
    //Declaración de las variables que serán las columnas de la tabla médico y sus getter y setters gracias a lombok
    @Column(unique = true)
    private String numColegiado;


    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinTable(
            name = "medico_paciente", joinColumns = @JoinColumn( name = "medico_Id" , referencedColumnName = "idU"),
            inverseJoinColumns = @JoinColumn( name = "paciente_id",referencedColumnName = "idU")
    )
    private List<PacienteModel> pacientes; //Creamos una variable para crear la relación de muchos a muchos com pacientes


    @OneToMany(mappedBy = "medico")
    private List<CitaModel> citas;//Creamos una variable para crear la relación de uno a muchos con cita




}
