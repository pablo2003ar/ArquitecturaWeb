package RepositoryImpl;

import Entities.Carrera;
import Entities.Estudiante;
import interfaces.CarreraRepository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

public class CarreraRepositoryImpl implements CarreraRepository {
    private EntityManager em;
    public CarreraRepositoryImpl(EntityManager em) {
        this.em = em;
    }
    @Override
    public Carrera getCarreraById(int id) {
        return em.find(Carrera.class, id);
    }

    @Override
    public Carrera getCarreraByNombre(String nombre) {
        TypedQuery<Carrera> q = em.createQuery("SELECT c FROM Carrera c WHERE c.nombre = :nombre",Carrera.class);
        q.setParameter("nombre", nombre);
        return q.getSingleResult();
    }

    @Override
    public Carrera saveCarrera(Carrera c) {
        if (this.getCarreraById(c.getId()) == null) {
            em.persist(c);
        } else {
            c = em.merge(c);
        }
        return c;
    }

    @Override
    public void deleteCarrera(Carrera c) {
        em.remove(c);
    }
}
