package com.example.Integrador_3.dto;

import lombok.Getter;

@Getter

public class EstudianteDTO {
    private int nroLibreta;
    private int dni;
    private String nombre;
    private String apellido;
    private int edad;
    private String ciudad;
    private String genero;

    public EstudianteDTO(int nroLibreta, int dni, String nombre, String apellido, int edad, String ciudad, String genero) {
        this.nroLibreta = nroLibreta;
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.ciudad = ciudad;
        this.genero = genero;
    }
}
