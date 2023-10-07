package RepositoryImpl;

import Entities.Carrera;
import Entities.Estudiante;
import Entities.Inscripciones;
import Factory.MySQLEntityManagerFactory;
import dto.CarreraDTO;
import dto.ReporteCarreraDTO;
import interfaces.InscripcionesRepository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.math.BigInteger;
import java.util.List;
import java.util.stream.Collectors;

public class InscripcionesRepositoryImpl implements InscripcionesRepository {
    private EntityManager em;
    public InscripcionesRepositoryImpl(EntityManager em) {
        this.em = em;
    }
    @Override
    public Inscripciones getInscripcionesById(int id) {
        EntityManager entityManager = MySQLEntityManagerFactory.getEntityManager();
        entityManager.getTransaction().begin();
        Inscripciones inscripciones = entityManager.find(Inscripciones.class, id);
        entityManager.getTransaction().commit();
        entityManager.close();
        return inscripciones;
    }

    @Override
    public Inscripciones getInscripcionesByAntiguedad(int antiguedad) {
        EntityManager entityManager = MySQLEntityManagerFactory.getEntityManager();
        entityManager.getTransaction().begin();
        Inscripciones inscripciones = entityManager.find(Inscripciones.class, antiguedad);
        entityManager.getTransaction().commit();
        entityManager.close();
        return inscripciones;
    }


    @Override
    public void saveInscripciones(Inscripciones i) {
        EntityManager entityManager = MySQLEntityManagerFactory.getEntityManager();
        entityManager.getTransaction().begin();
        if (this.getInscripcionesById(i.getId()) == null) {
            entityManager.persist(i);
        } else {
           entityManager.merge(i);
        }
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public void deleteInscripciones(Inscripciones i) {
        EntityManager entityManager = MySQLEntityManagerFactory.getEntityManager();
        entityManager.getTransaction().begin();
        entityManager.remove(i);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    /*
    public List<ReporteCarreraDTO> getReporte() {
        EntityManager entityManager = MySQLEntityManagerFactory.getEntityManager();
        entityManager.getTransaction().begin();
        String jpql = "SELECT new dto.ReporteCarreraDTO(" +
                "i.id_carrera," +
                "COUNT(i.nroLibreta)," +
                "(SELECT COUNT(i.nroLibreta) FROM Inscripciones i WHERE i.graduado = 1)," +
                "YEAR(i.fechaInscripcion))" +
                "FROM Inscripciones i GROUP BY i.id_carrera, YEAR(i.fechaInscripcion) ORDER BY i.id_carrera ASC";
        Query query = entityManager.createQuery(jpql, ReporteCarreraDTO.class);
        List<ReporteCarreraDTO> resultados = query.getResultList();


        entityManager.getTransaction().commit();
        entityManager.close();

        return resultados;
    }

     */
    public List<ReporteCarreraDTO> getReporte() {
        EntityManager entityManager = MySQLEntityManagerFactory.getEntityManager();
            entityManager.getTransaction().begin();

            String jpql = "SELECT nombre, fechaInscripcion, COUNT(fechaInscripcion) as Inscripciones, 0 as graduados " +
                    "FROM carrera c INNER JOIN inscripciones i ON c.id = i.id_carrera_id " +
                    "GROUP BY c.id, fechaInscripcion " +
                    "HAVING fechaInscripcion != 0 " +
                    "UNION " +
                    "SELECT nombre, graduado, 0 as Inscripciones, COUNT(graduado) as graduados " +
                    "FROM carrera c INNER JOIN inscripciones i ON c.id = i.id_carrera_id " +
                    "GROUP BY c.id, graduado\r\n " +
                    "HAVING graduado != 0 " +
                    "ORDER BY nombre, fechaInscripcion ASC";


            Query query = entityManager.createNativeQuery(jpql);
            List<Object[]> resultados = query.getResultList();

            entityManager.getTransaction().commit();
            entityManager.close();
        List<ReporteCarreraDTO> reporteFinal = resultados.stream()
                .map(objects -> new ReporteCarreraDTO((String) objects[0]))
                .collect(Collectors.toList());

            return reporteFinal;





    }
}
