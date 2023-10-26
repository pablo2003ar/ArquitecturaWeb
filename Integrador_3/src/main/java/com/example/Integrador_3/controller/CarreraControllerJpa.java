package com.example.Integrador_3.controller;

import com.example.Integrador_3.repository.CarreraRepository;
import com.example.Integrador_3.model.Carrera;


import com.example.Integrador_3.service.CarreraService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("carrera")
@Api(value = "CarrerasController", description = "REST API Descripcion de carreras")
public class CarreraControllerJpa {

    @Autowired
    private CarreraService carreraServ;

    //ENCONTRAR TODAS LAS CARRERAS
    @GetMapping("/")
    public Iterable<Carrera> getCarreras() throws Exception {
        return carreraServ.findAll();
    }

    //DAR DE ALTA UNA CARRERA
    @PostMapping("/")
    public Carrera newCarrera(@RequestBody Carrera c) throws Exception {
        return carreraServ.save(c);
    }

    @GetMapping("/con-inscriptos")
    public List<Carrera> getCarrerasConInscriptosOrdenadasPorCantidad() {
        return carreraServ.findCarrerasWithInscriptosOrderedByCount();
    }
}