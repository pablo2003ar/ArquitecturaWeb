package com.example.Integrador_3.controller;

import com.example.Integrador_3.dto.CarreraDTO;
import com.example.Integrador_3.dto.EstudianteDTO;
import com.example.Integrador_3.repository.CarreraRepository;
import com.example.Integrador_3.model.Carrera;


import com.example.Integrador_3.service.CarreraService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<?> getCarrerasConInscriptosOrdenadasPorCantidad() {
        try {
            List<CarreraDTO> carreras = carreraServ.findCarrerasWithInscriptosOrderedByCount();
            if (carreras.isEmpty()) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"Error\":\"No existen inscriptos en las carreras.\"}");

            } else {
                return ResponseEntity.status(HttpStatus.OK).body(carreras);
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"Error\":\"No existe.\"}");
        }
    }
}