package org.example;

import Entities.Carrera;
import Entities.Estudiante;
import Entities.Inscripciones;
import Factory.FactoryEntityManager;
import RepositoryImpl.CarreraRepositoryImpl;
import RepositoryImpl.EstudianteRepositoryImpl;
import RepositoryImpl.InscripcionesRepositoryImpl;
import dto.CarreraDTO;
import dto.EstudianteDTO;
import dto.ReporteCarreraDTO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.sql.Timestamp;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        FactoryEntityManager factoryEntityManager = FactoryEntityManager.getFactoryEntityManager(1);
        EstudianteRepositoryImpl estudianteRepository = factoryEntityManager.getEstudiante();
        CarreraRepositoryImpl carreraRepository = factoryEntityManager.getCarrera();
        InscripcionesRepositoryImpl inscripcionesRepository = factoryEntityManager.getInscripciones();

        /*
        //Alta Carreras
        Carrera c1 = new Carrera("Tecnicatura Universitaria en Desarrollo de Aplicaciones Informáticas");
        Carrera c2 = new Carrera("Ingeniería de Sistemas");
        Carrera c3 = new Carrera("Profesorado de Informática");
        Carrera c4 = new Carrera("Tecnicatura Universitaria en Administración de Redes Informáticas");

        carreraRepository.saveCarrera(c1);
        carreraRepository.saveCarrera(c2);
        carreraRepository.saveCarrera(c3);
        carreraRepository.saveCarrera(c4);

        //A) Dar de alta estudiantes.
        Estudiante estudiante = new Estudiante(111111,"E1", "E1", 10, "Olavarria", "M");
        Estudiante estudiante2 = new Estudiante(22222,"E2", "E2", 10, "Tandil", "M");
        Estudiante estudiante3 = new Estudiante(333333,"E3", "E3", 10, "Azul", "F");
        Estudiante estudiante4 = new Estudiante(44444,"E4", "E4", 10, "Olavarria", "F");
        Estudiante estudiante5 = new Estudiante(555555,"E5", "E5", 10, "Tandil", "M");
        Estudiante estudiante6 = new Estudiante(6666666,"E6", "E6", 10, "Olavarria", "F");

        estudianteRepository.saveEstudiante(estudiante);
        estudianteRepository.saveEstudiante(estudiante2);
        estudianteRepository.saveEstudiante(estudiante3);
        estudianteRepository.saveEstudiante(estudiante4);
        estudianteRepository.saveEstudiante(estudiante5);
        estudianteRepository.saveEstudiante(estudiante6);

        //B) Matricular un estudiante en una carrera
        Inscripciones inscripciones = new Inscripciones(estudiante,c1,2020,2017,0);
        Inscripciones inscripciones2 = new Inscripciones(estudiante2,c2,2021,2018,0);
        Inscripciones inscripciones3 = new Inscripciones(estudiante3,c3,2022,2019,0);
        Inscripciones inscripciones4 = new Inscripciones(estudiante4,c4,2023,2020,0);
        Inscripciones inscripciones5 = new Inscripciones(estudiante5,c1,2024,2021,0);
        Inscripciones inscripciones6 = new Inscripciones(estudiante6,c2,2025,2022,0);
        Inscripciones inscripciones7 = new Inscripciones(estudiante,c3,2026,2023,0);

        inscripcionesRepository.saveInscripciones(inscripciones);
        inscripcionesRepository.saveInscripciones(inscripciones2);
        inscripcionesRepository.saveInscripciones(inscripciones3);
        inscripcionesRepository.saveInscripciones(inscripciones4);
        inscripcionesRepository.saveInscripciones(inscripciones5);
        inscripcionesRepository.saveInscripciones(inscripciones6);
        inscripcionesRepository.saveInscripciones(inscripciones7);

         */



        /*
        //C) Recuperar todos los estudiantes segun un criterio de ordenamiento simple
        System.out.println(estudianteRepository.getEstudiantesPorApellido());

        //D) Recuperar un estudiante en base a su nro de libreta
        System.out.println(estudianteRepository.getEstudianteLibreta(1));

        //E)Recuperar todos los estudiantes en base a su genero
        System.out.println(estudianteRepository.getEstudiantesPorGenero("f"));

        //F)Recuperar carreras con estudiantes inscriptos y ordenar por cantidad
        System.out.println(carreraRepository.getCarreraByInscriptos());

        //G) Recuperar los estudiantes de una carrera determinada filtrado por ciudad
        System.out.println(estudianteRepository.getEstudiantesByCarrera(2,"Olavarria"));

         */


        System.out.println(inscripcionesRepository.getReporte());


    }
}