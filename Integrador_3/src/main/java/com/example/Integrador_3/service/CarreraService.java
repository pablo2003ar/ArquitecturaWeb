package com.example.Integrador_3.service;

import com.example.Integrador_3.model.Carrera;
import com.example.Integrador_3.repository.CarreraRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service("CarreraService")
public class CarreraService implements BaseService<Carrera>{
    @Autowired
    private CarreraRepository carreraRepo;

    @Override
    @Transactional
    public List<Carrera> findAll() throws Exception {
        return carreraRepo.findAll();
    }

    @Override
    public Carrera findById(Long id) throws Exception {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Carrera save(Carrera c) throws Exception {
        return carreraRepo.save(c);
    }

    @Override
    public Carrera update(Long id, Carrera entity) throws Exception {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean delete(Long id) throws Exception {
        // TODO Auto-generated method stub
        return false;
    }

    public List<Carrera> findCarrerasWithInscriptosOrderedByCount() {
        List<Object[]> result = carreraRepo.findCarrerasWithInscriptosOrderedByCount();
        List<Carrera> carreras = new ArrayList<>();

        for (Object[] objects : result) {
            Carrera carrera = (Carrera) objects[0];
            carreras.add(carrera);
        }

        return carreras;
    }
}
