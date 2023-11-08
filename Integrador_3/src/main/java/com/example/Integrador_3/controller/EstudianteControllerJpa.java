package com.example.Integrador_3.controller;

import com.example.Integrador_3.dto.EstudianteDTO;
import com.example.Integrador_3.model.Estudiante;

import com.example.Integrador_3.service.EstudianteService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("est")
@Api(value = "EstudianteController", description = "REST API Descripcion de estudiante")
public class EstudianteControllerJpa {
    @Autowired
    private EstudianteService estudianteServ;

    @PostMapping("/")
    public void newEstudiante(@RequestBody Estudiante e) {
        try {
            estudianteServ.save(e);
        } catch (Exception e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
    }

    @GetMapping("/")
    public Iterable<Estudiante> getEstudiantes() {
        try {
            return estudianteServ.findAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @GetMapping("/{numLib}")
    public ResponseEntity<?> getEstudianteByLibreta(@PathVariable Long numLib) {
        Estudiante estudiante = estudianteServ.findByLibreta(numLib);
        try{
            return ResponseEntity.status(HttpStatus.OK).body(new EstudianteDTO(estudiante.getNroLibreta(), estudiante.getDni(), estudiante.getApellido(), estudiante.getEdad(), estudiante.getCiudad(), estudiante.getGenero()));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"Error\":\"No existe numero de libreta.\"}");
        }
    }

    @GetMapping("/order")
    public ResponseEntity<?> getEstudiantesByOrder() {
        try {
            List<EstudianteDTO> estudiantes = estudianteServ.findAllOrder();
            if (estudiantes.isEmpty()) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No existen estudiantes.");
            }
            return ResponseEntity.status(HttpStatus.OK).body(estudiantes);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error en el servidor: " + e.getMessage());
        }
    }



    @GetMapping("/genero/{genero}")
    public ResponseEntity<?> getEstudianteByGenero(@PathVariable String genero) {
        try {
            List<EstudianteDTO> estudiantes = estudianteServ.findByGenero(genero);

            if (estudiantes.isEmpty()) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"Error\":\"No existen estudiantes con ese genero.\"}");
            } else {
                return ResponseEntity.status(HttpStatus.OK).body(estudiantes);
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"Error\":\"No existe.\"}");
        }
    }

    @GetMapping("/{id_carrera}/{ciudad}")
    public ResponseEntity<?> getEstudianteByCarreraCiudad(@PathVariable int id_carrera, @PathVariable String ciudad) {
        try {
            List<EstudianteDTO> estudiantes = estudianteServ.getEstudianteByCarrera(id_carrera, ciudad);

            if (estudiantes.isEmpty()) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"Error\":\"No existe la carrera o la ciudad.\"}");
            } else {
                return ResponseEntity.status(HttpStatus.OK).body(estudiantes);
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"Error\":\"No existe.\"}");
        }
    }




}
