package com.example.Integrador_3.repository;
import com.example.Integrador_3.model.Inscripciones;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface InscripcionesRepository extends JpaRepository<Inscripciones, Integer>{
    @EntityGraph(attributePaths = { "nroLibreta", "id_carrera" })
    List<Inscripciones> findAll();

    @Query(value = "SELECT nombre, fecha, COUNT(fecha) as Inscripciones, 0 as graduados " +
            "FROM carrera c INNER JOIN inscripciones i ON c.id = i.id_carrera " +
            "GROUP BY c.id, fecha " +
            "HAVING fecha != 0 " +
            "UNION " +
            "SELECT nombre, graduado, 0 as Inscripciones, COUNT(graduado) as graduados " +
            "FROM carrera c INNER JOIN inscripciones i ON c.id = i.id_carrera " +
            "GROUP BY c.id, graduado\r\n " +
            "HAVING graduado IS NOT NULL " +
            "ORDER BY nombre, fecha ASC",
            nativeQuery = true)
    List<Object[]> getReporte();
}
