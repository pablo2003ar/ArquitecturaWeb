package com.example.Integrador_3.controller;

import com.example.Integrador_3.repository.CarreraRepository;
import com.example.Integrador_3.model.Carrera;


import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("carrera")
@Api(value = "CarrerasController", description = "REST API Descripcion de carreras")
public class CarreraControllerJpa {

    @Qualifier("carreraRepository")
    @Autowired
    private final CarreraRepository repository;

    public CarreraControllerJpa(@Qualifier("carreraRepository")CarreraRepository repository) {
        this.repository = repository;
    }

    //ENCONTRAR TODAS LAS CARRERAS
    @GetMapping("/")
    public Iterable<Carrera> getCarreras() {
        return repository.findAll();
    }

    //DAR DE ALTA UNA CARRERA
    @PostMapping("/")
    public Carrera newCarrera(@RequestBody Carrera c) {
        return repository.save(c);
    }

    @GetMapping("/name")
    public Carrera getCarrera(String name) {
        return repository.findBynombre(name);
    }






}