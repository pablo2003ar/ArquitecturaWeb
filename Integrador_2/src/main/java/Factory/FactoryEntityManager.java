package Factory;

import RepositoryImpl.CarreraRepositoryImpl;
import RepositoryImpl.EstudianteRepositoryImpl;
import RepositoryImpl.InscripcionesRepositoryImpl;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public abstract class FactoryEntityManager {

    public static final int MYSQL_JDBC = 1;
    public static final int DERBY_JDBC = 2;
    public static final int JPA_HIBERNATE = 3;

    public abstract EstudianteRepositoryImpl getEstudiante();
    public abstract CarreraRepositoryImpl getCarrera();
    public abstract InscripcionesRepositoryImpl getInscripciones();
    public static FactoryEntityManager getFactoryEntityManager(int whichFactory) {
        switch (whichFactory) {
            case MYSQL_JDBC : return MySQLEntityManagerFactory.getInstance();
            default: return null;
        }
    }

}
