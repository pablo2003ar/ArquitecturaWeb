package com.example.Integrador_3.service;

import com.example.Integrador_3.dto.EstudianteDTO;
import com.example.Integrador_3.model.Estudiante;
import com.example.Integrador_3.repository.EstudianteRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service("EstudianteService")
public class EstudianteService implements BaseService<Estudiante> {
    @Autowired
    private EstudianteRepository estudianteRepository;

    @Override
    @Transactional
    public List<Estudiante> findAll() throws Exception {
        return estudianteRepository.findAll();
    }

    @Override
    public Estudiante findById(Long id) throws Exception {
        return null;
    }

    @Override
    public Estudiante save(Estudiante e) throws Exception {
        try{
            return estudianteRepository.save(e);
        }catch (Exception ex){
            throw new Exception(ex.getMessage());
        }
    }

    @Override
    public Estudiante update(Long id, Estudiante entity) throws Exception {
        return null;
    }

    @Override
    public boolean delete(Long id) throws Exception {
        return false;
    }

    @Transactional
    public List<EstudianteDTO> findAllOrder() throws Exception {
        var resultado = estudianteRepository.findByOrderByApellidoAsc();
        try{
            return resultado.stream().map(estudiante -> new EstudianteDTO(estudiante.getNroLibreta(), estudiante.getDni(), estudiante.getApellido()))
                    .collect(Collectors.toList());

        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
    @Transactional
    public Estudiante findByLibreta(Long numLib) {
        return estudianteRepository.findBynroLibreta(numLib);
    }

    @Transactional
    public List<EstudianteDTO> findByGenero(String genero) throws Exception {
        var resultado = estudianteRepository.findBygenero(genero);
        try{
            return resultado.stream().map(estudiante -> new EstudianteDTO(estudiante.getNroLibreta(), estudiante.getDni(), estudiante.getApellido()))
                    .collect(Collectors.toList());

        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
}
