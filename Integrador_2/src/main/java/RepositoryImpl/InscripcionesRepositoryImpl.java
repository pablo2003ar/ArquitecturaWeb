package RepositoryImpl;

import Entities.Carrera;
import Entities.Estudiante;
import Entities.Inscripciones;
import interfaces.InscripcionesRepository;

import javax.persistence.EntityManager;

public class InscripcionesRepositoryImpl implements InscripcionesRepository {
    private EntityManager em;
    public InscripcionesRepositoryImpl(EntityManager em) {
        this.em = em;
    }
    @Override
    public Inscripciones getInscripcionesById(int id) {
        return em.find(Inscripciones.class, id);
    }

    @Override
    public Inscripciones getInscripcionesByAntiguedad(int antiguedad) {
        return em.find(Inscripciones.class, antiguedad);
    }

    @Override
    public Inscripciones saveInscripciones(Inscripciones i) {
        if (this.getInscripcionesById(i.getId()) == null) {
            em.persist(i);
        } else {
            i = em.merge(i);
        }
        return i;
    }

    @Override
    public void deleteInscripciones(Inscripciones i) {
        em.remove(i);
    }
}
