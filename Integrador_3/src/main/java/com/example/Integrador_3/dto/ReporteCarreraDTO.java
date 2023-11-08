package com.example.Integrador_3.dto;

public class ReporteCarreraDTO {
    private String carreras;

    private int anio;
    private Long cantInscriptos;
    private Long cantGraduados;

    public ReporteCarreraDTO(String carreras, int anio, Long cantInscriptos, Long cantGraduados) {
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

    public Long getCantInscriptos() {
        return cantInscriptos;
    }

    public Long getCantGraduados() {
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
