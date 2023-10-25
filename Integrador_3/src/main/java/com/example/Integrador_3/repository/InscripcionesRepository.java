package com.example.Integrador_3.repository;
import com.example.Integrador_3.model.Inscripciones;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface InscripcionesRepository extends JpaRepository<Inscripciones, Integer>{
    @EntityGraph(attributePaths = { "nroLibreta", "id_carrera" })
    List<Inscripciones> findAll();  // O cualquier otro método que necesites
}
