package com.example.Integrador_3.controller;

import com.example.Integrador_3.dto.ReporteCarreraDTO;
import com.example.Integrador_3.model.Inscripciones;
import com.example.Integrador_3.repository.InscripcionesRepository;

import com.example.Integrador_3.service.InscripcionesService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("inscripciones")
@Api(value = "InscripcionesController", description = "REST API Descripcion de inscripciones")

public class InscripcionesControllerJpa {
    @Autowired
    private InscripcionesService inscripcionesServ;


    //DAR DE ALTA UN ESTUDIANTE
    @PostMapping("/")
    public Inscripciones newIncripcion(@RequestBody Inscripciones i) throws Exception {
        return inscripcionesServ.save(i);
    }

    //ENCONTRAR TODAS LAS INSCRIPCIONES
    @GetMapping("/")
    public Iterable<Inscripciones> getInscripciones() throws Exception {
        return inscripcionesServ.findAll();
    }

    @GetMapping("/reporte")
    public Iterable<ReporteCarreraDTO> getReporte() throws Exception {
        return inscripcionesServ.getReportes();
    }

}
