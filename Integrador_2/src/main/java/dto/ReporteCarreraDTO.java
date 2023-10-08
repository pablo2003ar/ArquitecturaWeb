package dto;

import Entities.Carrera;
import Entities.Estudiante;

import java.math.BigInteger;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class ReporteCarreraDTO {
    private String carreras;

    private int anio;
    private BigInteger cantInscriptos;
    private BigInteger cantGraduados;

    public ReporteCarreraDTO(String carreras, int anio, BigInteger cantInscriptos, BigInteger cantGraduados) {
        this.carreras = carreras;
        this.anio = anio;
        this.cantInscriptos = cantInscriptos;
        this.cantGraduados = cantGraduados;
    }

    public String getCarreras() {
        return carreras;
    }

    public int getAnio() {
        return anio;
    }

    public BigInteger getCantInscriptos() {
        return cantInscriptos;
    }

    public BigInteger getCantGraduados() {
        return cantGraduados;
    }

    @Override
    public String toString() {
        return "ReporteCarreraDTO{" +
                "carreras='" + carreras + '\'' +
                ", anio=" + anio +
                ", cantInscriptos=" + cantInscriptos +
                ", cantGraduados=" + cantGraduados +
                '}';
    }
}
