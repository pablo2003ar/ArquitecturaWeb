package com.example.Integrador_3.model;
import jakarta.persistence.*;
import lombok.Data;
@Entity
@Data
public class Inscripciones {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "nroLibreta")
    private Estudiante nroLibreta;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_carrera")
    private Carrera id_carrera;
    @Column
    private int graduado;
    @Column(name = "fecha")
    private int fechaInscripcion;
    @Column
    private int antiguedad;

    public Inscripciones(Estudiante nroLibreta, Carrera id_carrera, int graduado, int fechaInscripcion, int antiguedad) {
        super();
        this.nroLibreta = nroLibreta;
        this.id_carrera = id_carrera;
        this.graduado = graduado;
        this.fechaInscripcion = fechaInscripcion;
        this.antiguedad = antiguedad;
    }

    public Inscripciones() {
    }
}
