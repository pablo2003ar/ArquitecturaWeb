package Entities;

import javax.persistence.*;
import java.sql.Timestamp;
@Entity
public class Inscripciones {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne(fetch = FetchType.LAZY)
    private Estudiante nroLibreta;
    @ManyToOne(fetch = FetchType.LAZY)
    private Carrera id_carrera;
    @Column
    private int graduado;
    @Column
    private int fechaInscripcion;
    @Column
    private int antiguedad;

    public Inscripciones(){}

    public Inscripciones(Estudiante nroLibreta, Carrera id_carrera, int graduado, int fechaInscripcion, int antiguedad) {
        this.nroLibreta = nroLibreta;
        this.id_carrera = id_carrera;
        this.graduado = graduado;
        this.fechaInscripcion = fechaInscripcion;
        this.antiguedad = antiguedad;
    }

    public int getId() {
        return id;
    }

    public Estudiante getDni() {
        return nroLibreta;
    }

    public Estudiante getNroLibreta() {
        return nroLibreta;
    }

    public Carrera getId_carrera() {
        return id_carrera;
    }

    public void setId_carrera(Carrera id_carrera) {
        this.id_carrera = id_carrera;
    }

    public int isGraduado() {
        return graduado;
    }

    public void setGraduado(int graduado) {
        this.graduado = graduado;
    }

    public int getFechaInscripcion() {
        return fechaInscripcion;
    }

    public void setFechaInscripcion(int fechaInscripcion) {
        this.fechaInscripcion = fechaInscripcion;
    }

    public int getAntiguedad() {
        return antiguedad;
    }

    public void setAntiguedad(int antiguedad) {
        this.antiguedad = antiguedad;
    }

    @Override
    public String toString() {
        return "Inscripciones{" +
                "id=" + id +
                ", Libreta=" + nroLibreta +
                ", id_carrera=" + id_carrera +
                ", graduado=" + graduado +
                ", fechaInscripcion=" + fechaInscripcion +
                ", antiguedad=" + antiguedad +
                '}';
    }
}
