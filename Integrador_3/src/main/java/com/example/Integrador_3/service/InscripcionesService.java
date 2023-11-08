package com.example.Integrador_3.service;

import com.example.Integrador_3.dto.ReporteCarreraDTO;
import com.example.Integrador_3.model.Inscripciones;
import com.example.Integrador_3.repository.InscripcionesRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service("InscripcionesService")
public class InscripcionesService implements BaseService<Inscripciones> {
    @Autowired
    private InscripcionesRepository inscripcionesRepo;

    @Override
    @Transactional
    public List<Inscripciones> findAll() throws Exception {
        return inscripcionesRepo.findAll();
    }

    @Override
    public Inscripciones findById(Long id) throws Exception {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Inscripciones save(Inscripciones i) throws Exception {
        return inscripcionesRepo.save(i);
    }

    @Override
    public Inscripciones update(Long id, Inscripciones entity) throws Exception {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean delete(Long id) throws Exception {
        // TODO Auto-generated method stub
        return false;
    }

    public List<ReporteCarreraDTO> getReportes() throws Exception {
        List<Object[]> resultados = inscripcionesRepo.getReporte();

        List<ReporteCarreraDTO> reporteFinal = resultados.stream()
                .map(objects -> new ReporteCarreraDTO((String) objects[0], (int) objects[1], (Long) objects[2], (Long) objects[3]))
                .collect(Collectors.toList());

        return reporteFinal;
    }

}
