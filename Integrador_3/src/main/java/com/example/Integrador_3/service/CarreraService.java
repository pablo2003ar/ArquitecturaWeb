package com.example.Integrador_3.service;

import com.example.Integrador_3.dto.CarreraDTO;
import com.example.Integrador_3.model.Carrera;
import com.example.Integrador_3.repository.CarreraRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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

    public List<CarreraDTO> findCarrerasWithInscriptosOrderedByCount() throws Exception{
        List<Carrera> result = carreraRepo.findCarrerasWithInscriptosOrderedByCount();
        try{
            return result.stream().map(carrera -> new CarreraDTO(carrera.getId(), carrera.getNombre()))
                    .collect(Collectors.toList());

        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
}
