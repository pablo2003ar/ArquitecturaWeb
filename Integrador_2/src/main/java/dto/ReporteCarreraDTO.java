package dto;

import Entities.Carrera;
import Entities.Estudiante;

import java.util.HashMap;
import java.util.List;

public class ReporteCarreraDTO {
    private List<Carrera> carreras;
    //private HashMap<String,HashMap<Integer,List<Estudiante>>> reporte;
    private List<Estudiante> estudiantes;
    private List<Integer> anio;

    public ReporteCarreraDTO() {
    }

    public List<Carrera> getCarreras() {
        return carreras;
    }

    public void setCarreras(List<Carrera> carreras) {
        this.carreras = carreras;
    }

    public List<Estudiante> getEstudiantes() {
        return estudiantes;
    }

    public void setEstudiantes(List<Estudiante> estudiantes) {
        this.estudiantes = estudiantes;
    }

    public List<Integer> getAnio() {
        return anio;
    }

    public void setAnio(List<Integer> anio) {
        this.anio = anio;
    }
}
