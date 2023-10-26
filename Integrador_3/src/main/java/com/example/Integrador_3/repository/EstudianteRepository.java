package com.example.Integrador_3.repository;

import com.example.Integrador_3.model.Estudiante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EstudianteRepository extends JpaRepository<Estudiante, Long> {
    public Estudiante findBynroLibreta(Long nunLib);
    public List<Estudiante> findByOrderByApellidoAsc();
    public List<Estudiante> findBygenero(String genero);
}
