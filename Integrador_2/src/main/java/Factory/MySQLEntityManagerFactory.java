package Factory;

import RepositoryImpl.CarreraRepositoryImpl;
import RepositoryImpl.EstudianteRepositoryImpl;
import RepositoryImpl.InscripcionesRepositoryImpl;
import interfaces.CarreraRepository;
import interfaces.EstudianteRepository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class MySQLEntityManagerFactory extends FactoryEntityManager {
    private static final String PERSISTENCE_UNIT_NAME = "Integrador2";
    private static EntityManagerFactory emf;

    private static MySQLEntityManagerFactory instance;

    private  MySQLEntityManagerFactory() {

    }

    public static MySQLEntityManagerFactory getInstance() {
        if (instance == null) {
            instance = new MySQLEntityManagerFactory();
        }
        return instance;
    }

    public static EntityManager getEntityManager() {
        if (emf == null) {
            emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        }
        return emf.createEntityManager();
    }

    public static void closeEntityManagerFactory() {
        if (emf != null && emf.isOpen()) {
            emf.close();
        }
    }


    @Override
    public EstudianteRepositoryImpl getEstudiante() {
        return new EstudianteRepositoryImpl(MySQLEntityManagerFactory.getEntityManager());
    }

    @Override
    public CarreraRepositoryImpl getCarrera() {
        return new CarreraRepositoryImpl(MySQLEntityManagerFactory.getEntityManager());
    }

    @Override
    public InscripcionesRepositoryImpl getInscripciones() {
        return new InscripcionesRepositoryImpl(MySQLEntityManagerFactory.getEntityManager());
    }
}
