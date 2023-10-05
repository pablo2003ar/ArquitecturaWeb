package RepositoryImpl;

import Entities.Estudiante;
import interfaces.EstudianteRepository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

public class EstudianteRepositoryImpl implements EstudianteRepository {
    private EntityManager em;
    public EstudianteRepositoryImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public Estudiante getEstudianteById(int nroLibreta) {
        return em.find(Estudiante.class, nroLibreta);
    }

    @Override
    public Estudiante getEstudianteByApellido(String apellido) {
        TypedQuery<Estudiante> q = em.createQuery("SELECT e FROM Estudiante e WHERE e.apellido = :apellido",Estudiante.class);
        q.setParameter("apellido", apellido);
        return q.getSingleResult();
    }

    @Override
    public Estudiante saveEstudiante(Estudiante e) {
        if (this.getEstudianteById(e.getNroLibreta()) == null) {
            em.persist(e);
        } else {
            e = em.merge(e);
        }
        return e;
    }

    @Override
    public void deleteEstudiante(Estudiante e) {
        em.remove(e);
    }
}
