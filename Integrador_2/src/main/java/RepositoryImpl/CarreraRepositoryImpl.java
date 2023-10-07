package RepositoryImpl;

import Entities.Carrera;
import Factory.MySQLEntityManagerFactory;
import dto.CarreraDTO;
import interfaces.CarreraRepository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

public class CarreraRepositoryImpl implements CarreraRepository {
    private EntityManager em;
    public CarreraRepositoryImpl(EntityManager em) {
        this.em = em;
    }
    @Override
    public Carrera getCarreraById(int id)
    {
        EntityManager entityManager = MySQLEntityManagerFactory.getEntityManager();
        entityManager.getTransaction().begin();
        Carrera carrera = entityManager.find(Carrera.class, id);
        entityManager.getTransaction().commit();
        entityManager.close();
        return carrera;
    }

    @Override
    public Carrera getCarreraByNombre(String nombre) {
        EntityManager entityManager = MySQLEntityManagerFactory.getEntityManager();
        entityManager.getTransaction().begin();
        TypedQuery<Carrera> q = entityManager.createQuery("SELECT c FROM Carrera c WHERE c.nombre = :nombre",Carrera.class);
        q.setParameter("nombre", nombre);
        Carrera carrera = q.getSingleResult();
        entityManager.getTransaction().commit();
        entityManager.close();
        return carrera;
    }

    @Override
    public void saveCarrera(Carrera c) {
        EntityManager entityManager = MySQLEntityManagerFactory.getEntityManager();
        entityManager.getTransaction().begin();
        if (this.getCarreraById(c.getId()) == null) {
            entityManager.persist(c);
        } else {
            entityManager.merge(c);
        }
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public void deleteCarrera(Carrera c) {
        EntityManager entityManager = MySQLEntityManagerFactory.getEntityManager();
        entityManager.getTransaction().begin();
        entityManager.remove(c);
        entityManager.getTransaction().commit();
        entityManager.close();
    }


    public List<CarreraDTO> getCarreraByInscriptos() {
        EntityManager entityManager = MySQLEntityManagerFactory.getEntityManager();
        entityManager.getTransaction().begin();
        String jpql = "SELECT DISTINCT new dto.CarreraDTO(i.id_carrera.id, i.id_carrera.nombre) " +
                "FROM Inscripciones i GROUP BY i.id_carrera ORDER BY COUNT(i.id_carrera) DESC ";
        Query query = em.createQuery(jpql, CarreraDTO.class);
        List<CarreraDTO> resultados = query.getResultList();
        entityManager.getTransaction().commit();
        entityManager.close();
        return resultados;
    }
}
