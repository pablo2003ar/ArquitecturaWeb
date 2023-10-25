package com.example.Integrador_3.utils;

import com.example.Integrador_3.model.Carrera;
import com.example.Integrador_3.model.Estudiante;
import com.example.Integrador_3.model.Inscripciones;
import com.example.Integrador_3.repository.CarreraRepository;
import com.example.Integrador_3.repository.EstudianteRepository;
import com.example.Integrador_3.repository.InscripcionesRepository;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
public class CargaDeDatos {

    @Autowired
    private EstudianteRepository estudianteRepository;
    @Autowired
    private CarreraRepository carreraRepository;

    @Bean
    CommandLineRunner initEstudiante(@Qualifier("estudianteRepository") EstudianteRepository repository) {
        return args -> {
            log.info("Preloading " + repository.save(new Estudiante((long)1,35451214,"Pablo", "Urreta",30,"Olavarria", "M")));
            log.info("Preloading " + repository.save(new Estudiante((long)2,254487,"Luciana", "Olmeda",18,"Olavarria", "F")));
            log.info("Preloading " + repository.save(new Estudiante((long)3,3225441,"Roberta", "Cacha",25,"Azul", "NoBinary")));
        };
    }
    @Bean
    CommandLineRunner initCarrera(@Qualifier("carreraRepository") CarreraRepository repository) {
        return args -> {
            log.info("Preloading " + repository.save(new Carrera("Tecnicatura Universitaria en Desarrollo de Aplicaciones Informáticas")));
            log.info("Preloading " + repository.save(new Carrera("Profesorado de Informática")));
            log.info("Preloading " + repository.save(new Carrera("Tecnicatura Universitaria en Administración de Redes Informáticas")));
        };
    }

    @Bean
    CommandLineRunner initInscripciones(@Qualifier("inscripcionesRepository") InscripcionesRepository repository) {
        return args -> {
            Estudiante e1 = estudianteRepository.findById((long)1).orElse(null);
            Carrera c1 = carreraRepository.findById(1).orElse(null);
            log.info("Preloading " + repository.save(new Inscripciones(e1,c1,0,2022,1)));
        };
    }
}

