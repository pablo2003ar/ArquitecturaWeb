package com.example.Integrador_3.controller;

import com.example.Integrador_3.dto.EstudianteDTO;
import com.example.Integrador_3.model.Estudiante;
import com.example.Integrador_3.repository.EstudianteRepository;

import com.example.Integrador_3.service.EstudianteService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
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
    public EstudianteDTO getEstudianteByLibreta(@PathVariable Long numLib) throws Exception {
        Estudiante estudiante = estudianteServ.findByLibreta(numLib);
        try{
            return new EstudianteDTO(estudiante.getNroLibreta(), estudiante.getDni(), estudiante.getApellido());
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @GetMapping("/order")
    public List<EstudianteDTO> getEstudiantesByOrder() {
        try {
            return estudianteServ.findAllOrder();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @GetMapping("/genero/{genero}")
    public List<EstudianteDTO> getEstudianteByGenero(@PathVariable String genero) throws Exception {
        try{
            return estudianteServ.findByGenero(genero);
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }



}
