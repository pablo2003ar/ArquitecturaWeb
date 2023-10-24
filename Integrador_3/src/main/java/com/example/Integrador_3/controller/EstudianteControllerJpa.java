package com.example.Integrador_3.controller;

import com.example.Integrador_3.model.Estudiante;
import com.example.Integrador_3.repository.EstudianteRepository;

import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("est")
@Api(value = "EstudianteController", description = "REST API Descripcion de estudiante")
public class EstudianteControllerJpa {
    @Qualifier("estudianteRepository")
    @Autowired
    private final EstudianteRepository repository;

    public EstudianteControllerJpa(@Qualifier("estudianteRepository") EstudianteRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/")
    public Iterable<Estudiante> getEstudiantes() {
        return repository.findAll();
    }
}
