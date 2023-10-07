package RepositoryImpl;

import Entities.Estudiante;
import Factory.MySQLEntityManagerFactory;
import dto.CarreraDTO;
import dto.EstudianteDTO;
import interfaces.EstudianteRepository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

public class EstudianteRepositoryImpl implements EstudianteRepository {
    private EntityManager em;
    public EstudianteRepositoryImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public Estudiante getEstudianteByNroLibreta(int nroLibreta) {
        EntityManager entityManager = MySQLEntityManagerFactory.getEntityManager();
        entityManager.getTransaction().begin();
        Estudiante estudiante = entityManager.find(Estudiante.class, nroLibreta);
        entityManager.getTransaction().commit();
        entityManager.close();
        return estudiante;
    }


    @Override
    public EstudianteDTO getEstudianteLibreta(int nroLibreta) {
        EntityManager entityManager = MySQLEntityManagerFactory.getEntityManager();
        entityManager.getTransaction().begin();
        String jpql = "SELECT new dto.EstudianteDTO(e.nroLibreta, e.dni, e.nombre," +
                    "e.apellido, e.edad, e.ciudad, e.genero) FROM Estudiante e WHERE e.nroLibreta = ?1 ";
        Query query = entityManager.createQuery(jpql).setParameter(1,1);
        EstudianteDTO resultado = (EstudianteDTO) query.getSingleResult();
        entityManager.getTransaction().commit();
        entityManager.close();
        return resultado;
    }

    @Override
    public void saveEstudiante(Estudiante e) {
        EntityManager entityManager = MySQLEntityManagerFactory.getEntityManager();
        entityManager.getTransaction().begin();
        if (this.getEstudianteByNroLibreta(e.getNroLibreta()) == null) {
            entityManager.persist(e);
        } else {
            entityManager.merge(e);
        }
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public void deleteEstudiante(Estudiante e) {
        EntityManager entityManager = MySQLEntityManagerFactory.getEntityManager();
        entityManager.getTransaction().begin();
        entityManager.remove(e);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public List<EstudianteDTO> getEstudiantesPorApellido() {
        EntityManager entityManager = MySQLEntityManagerFactory.getEntityManager();
        entityManager.getTransaction().begin();

        String jpql = "SELECT new dto.EstudianteDTO(e.nroLibreta, e.dni, e.nombre," +
                " e.apellido, e.edad, e.ciudad, e.genero) FROM Estudiante e ORDER BY e.apellido";

        Query query = entityManager.createQuery(jpql, EstudianteDTO.class);
        List<EstudianteDTO> resultados = query.getResultList();

        entityManager.getTransaction().commit();
        entityManager.close();

        return resultados;
    }

    public List<EstudianteDTO> getEstudiantesPorGenero(String genero) {
        EntityManager entityManager = MySQLEntityManagerFactory.getEntityManager();
        entityManager.getTransaction().begin();

        String jpql = "SELECT new dto.EstudianteDTO(e.nroLibreta, e.dni, e.nombre," +
                " e.apellido, e.edad, e.ciudad, e.genero) FROM Estudiante e WHERE e.genero = ?1";

        Query query = entityManager.createQuery(jpql, EstudianteDTO.class).setParameter(1,genero);
        List<EstudianteDTO> resultados = query.getResultList();

        entityManager.getTransaction().commit();
        entityManager.close();

        return resultados;
    }


    public List<EstudianteDTO> getEstudiantesByCarrera(int carrera, String ciudad) {
        EntityManager entityManager = MySQLEntityManagerFactory.getEntityManager();
        entityManager.getTransaction().begin();


        String jpql = "SELECT new dto.EstudianteDTO(i.nroLibreta.nroLibreta," +
                "i.nroLibreta.dni," +
                "i.nroLibreta.nombre," +
                "i.nroLibreta.apellido," +
                "i.nroLibreta.edad," +
                "i.nroLibreta.ciudad," +
                "i.nroLibreta.genero)" +
                " FROM Inscripciones i JOIN i.nroLibreta e JOIN i.id_carrera c WHERE c.id = ?1 AND e.ciudad = ?2";

        Query query = entityManager.createQuery(jpql, EstudianteDTO.class).setParameter(1,carrera).setParameter(2, ciudad);
        List<EstudianteDTO> resultados = query.getResultList();

        entityManager.getTransaction().commit();
        entityManager.close();

        return resultados;
    }


}
