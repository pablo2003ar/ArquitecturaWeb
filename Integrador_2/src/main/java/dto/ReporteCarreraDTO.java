package dto;

import Entities.Carrera;
import Entities.Estudiante;

import java.math.BigInteger;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class ReporteCarreraDTO {
    private String carreras;

    private Long cantInscriptos;
    private Long cantGraduados;

    private Long anio;

    public ReporteCarreraDTO(String carreras) {
        this.carreras = carreras;
    }

    public String getCarreras() {
        return carreras;
    }

    public Long getCantInscriptos() {
        return cantInscriptos;
    }

    public Long getCantGraduados() {
        return cantGraduados;
    }

    public Long getAnio() {
        return anio;
    }

    @Override
    public String toString() {
        return "ReporteCarreraDTO{" +
                "carreras=" + carreras +
                ", cantInscriptos=" + cantInscriptos +
                ", cantGraduados=" + cantGraduados +
                ", anio=" + anio +
                '}';
    }
}
