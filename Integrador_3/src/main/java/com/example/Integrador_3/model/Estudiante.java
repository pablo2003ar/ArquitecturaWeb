package com.example.Integrador_3.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Estudiante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long nroLibreta;
    @Column
    private int dni;
    @Column
    private String nombre;
    @Column
    private String apellido;
    @Column
    private int edad;
    @Column
    private String ciudad;
    @Column
    private String genero;

    public Estudiante(Long nroLibreta, int dni, String nombre, String apellido, int edad, String ciudad, String genero) {
        this.nroLibreta = nroLibreta;
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.ciudad = ciudad;
        this.genero = genero;
    }

    public Estudiante() {
    }
    public Estudiante(long nroLibreta, int dni, String nombre, String apellido, int edad, String ciudad, String genero) {
        this.nroLibreta = nroLibreta;
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.ciudad = ciudad;
        this.genero = genero;
    }
}
