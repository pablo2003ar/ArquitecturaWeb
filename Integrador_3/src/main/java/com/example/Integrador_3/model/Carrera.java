package com.example.Integrador_3.model;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data

public class Carrera {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column
    private String nombre;

    public Carrera(String nombre) {
        super();
        this.nombre = nombre;
    }

    public Carrera() {
    }
}
