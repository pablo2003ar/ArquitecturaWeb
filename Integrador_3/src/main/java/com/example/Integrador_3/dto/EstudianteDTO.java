package com.example.Integrador_3.dto;

import lombok.Getter;

@Getter

public class EstudianteDTO {
    private Long nroLibreta;
    private int dni;
    private String nombre;
    private String apellido;
    private int edad;
    private String ciudad;
    private String genero;

    public EstudianteDTO(Long nroLibreta, int dni, String apellido) {
        this.nroLibreta = nroLibreta;
        this.dni = dni;
        this.apellido = apellido;
        /*
        this.edad = edad;
        this.ciudad = ciudad;
        this.genero = genero;

         */
    }
}
