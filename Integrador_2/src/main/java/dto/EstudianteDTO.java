package dto;

import javax.persistence.Column;
import java.io.Serializable;

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

    public EstudianteDTO() {

    }

    public int getNroLibreta() {
        return nroLibreta;
    }


    public int getDni() {
        return dni;
    }


    public String getNombre() {
        return nombre;
    }


    public String getApellido() {
        return apellido;
    }


    public int getEdad() {
        return edad;
    }


    public String getCiudad() {
        return ciudad;
    }


    public String getGenero() {
        return genero;
    }


    @Override
    public String toString() {
        return "EstudianteDTO{" +
                "nroLibreta=" + nroLibreta +
                ", dni=" + dni +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", edad=" + edad +
                ", ciudad='" + ciudad + '\'' +
                ", genero='" + genero + '\'' +
                '}';
    }
}
