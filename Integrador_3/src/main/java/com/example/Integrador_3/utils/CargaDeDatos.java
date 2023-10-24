package com.example.Integrador_3.utils;

import com.example.Integrador_3.model.Estudiante;
import com.example.Integrador_3.repository.EstudianteRepository;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
public class CargaDeDatos {
    @Bean
    CommandLineRunner initDatabase(@Qualifier("estudianteRepository") EstudianteRepository repository) {
        return args -> {
            log.info("Preloading " + repository.save(new Estudiante((long) 1,35451214,"Pablo", "Urreta",30,"Olavarria", "M")));
            log.info("Preloading " + repository.save(new Estudiante((long)2,254487,"Luciana", "Olmeda",18,"Olavarria", "F")));
            log.info("Preloading " + repository.save(new Estudiante((long)3,3225441,"Roberta", "Cacha",25,"Azul", "NoBinary")));
        };
    }
}

