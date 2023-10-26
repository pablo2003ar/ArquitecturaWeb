package com.example.Integrador_3.repository;
import com.example.Integrador_3.model.Carrera;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CarreraRepository extends JpaRepository<Carrera, Integer> {
    public Carrera findBynombre(String name);

    @Query("SELECT c, COUNT(i) AS inscriptos " +
            "FROM Carrera c " +
            "INNER JOIN Inscripciones i ON c.id = i.id_carrera.id " +
            "GROUP BY c.id " +
            "ORDER BY inscriptos DESC")
    List<Object[]> findCarrerasWithInscriptosOrderedByCount();
}
