package com.example.Integrador_3.repository;
import com.example.Integrador_3.model.Carrera;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarreraRepository extends JpaRepository<Carrera, Integer> {
    public Carrera findBynombre(String name);
}
