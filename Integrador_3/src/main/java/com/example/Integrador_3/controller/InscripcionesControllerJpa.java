package com.example.Integrador_3.controller;

import com.example.Integrador_3.model.Inscripciones;
import com.example.Integrador_3.repository.InscripcionesRepository;

import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("inscripciones")
@Api(value = "InscripcionesController", description = "REST API Descripcion de inscripciones")

public class InscripcionesControllerJpa {
    @Qualifier("inscripcionesRepository")
    @Autowired
    private final InscripcionesRepository repository;



    public InscripcionesControllerJpa(@Qualifier("inscripcionesRepository")InscripcionesRepository repository) {
        super();
        this.repository = repository;
    }

    //DAR DE ALTA UN ESTUDIANTE
    @PostMapping("/")
    public Inscripciones newIncripcion(@RequestBody Inscripciones i) {
        return repository.save(i);
    }

    //ENCONTRAR TODAS LAS INSCRIPCIONES
    @GetMapping("/")
    public Iterable<Inscripciones> getInscripciones() {
        return repository.findAll();
    }

}
