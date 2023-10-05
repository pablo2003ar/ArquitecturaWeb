package dto;

import Entities.Estudiante;

import java.util.List;

public class MatriculadosDTO {
    private String carrera;
    private List<Estudiante> matriculados;

    public MatriculadosDTO(String carrera, List<Estudiante> matriculados) {
        this.carrera = carrera;
        this.matriculados = matriculados;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public List<Estudiante> getMatriculados() {
        return matriculados;
    }

    public void setMatriculados(List<Estudiante> matriculados) {
        this.matriculados = matriculados;
    }
}
