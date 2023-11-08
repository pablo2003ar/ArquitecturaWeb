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

    @Bean
    CommandLineRunner initEstudiante(@Qualifier("estudianteRepository") EstudianteRepository estudianteRepository, @Qualifier("carreraRepository") CarreraRepository carreraRepository, @Qualifier("inscripcionesRepository") InscripcionesRepository inscripcionesRepository) {
        return args -> {
            log.info("Cargando Datos..... "  );
            Carrera c1 = new Carrera("Tecnicatura Universitaria en Desarrollo de Aplicaciones Informáticas");
            Carrera c2 = new Carrera("Ingeniería de Sistemas");
            Carrera c3 = new Carrera("Profesorado de Informática");
            Carrera c4 = new Carrera("Tecnicatura Universitaria en Administración de Redes Informáticas");

            carreraRepository.save(c1);
            carreraRepository.save(c2);
            carreraRepository.save(c3);
            carreraRepository.save(c4);

            //A) Dar de alta estudiantes.
            Estudiante estudiante = new Estudiante((long) 1,32156465,"E1", "E1", 10, "Olavarria", "M");
            Estudiante estudiante2 = new Estudiante((long) 2,52646545,"E2", "E2", 10, "Tandil", "M");
            Estudiante estudiante3 = new Estudiante((long) 3,4545785,"E3", "E3", 10, "Azul", "F");
            Estudiante estudiante4 = new Estudiante((long) 4,41545254,"E4", "E4", 10, "Olavarria", "F");
            Estudiante estudiante5 = new Estudiante((long) 5,456241585,"E5", "E5", 10, "Tandil", "M");
            Estudiante estudiante6 = new Estudiante((long) 6,145654654,"E6", "E6", 10, "Olavarria", "F");

            estudianteRepository.save(estudiante);
            estudianteRepository.save(estudiante2);
            estudianteRepository.save(estudiante3);
            estudianteRepository.save(estudiante4);
            estudianteRepository.save(estudiante5);
            estudianteRepository.save(estudiante6);


            //B) Matricular un estudiante en una carrera
            Inscripciones inscripciones = new Inscripciones(estudiante,c1,2020,2017,0);
            Inscripciones inscripciones2 = new Inscripciones(estudiante2,c2,2021,2018,0);
            Inscripciones inscripciones3 = new Inscripciones(estudiante3,c3,2022,2019,0);
            Inscripciones inscripciones4 = new Inscripciones(estudiante4,c3,2023,2020,0);
            Inscripciones inscripciones5 = new Inscripciones(estudiante5,c1,2024,2021,0);
            Inscripciones inscripciones6 = new Inscripciones(estudiante6,c2,2025,2022,0);
            Inscripciones inscripciones7 = new Inscripciones(estudiante,c3,2026,2023,0);

            inscripcionesRepository.save(inscripciones);
            inscripcionesRepository.save(inscripciones2);
            inscripcionesRepository.save(inscripciones3);
            inscripcionesRepository.save(inscripciones4);
            inscripcionesRepository.save(inscripciones5);
            inscripcionesRepository.save(inscripciones6);
            inscripcionesRepository.save(inscripciones7);

        };
    }
}

