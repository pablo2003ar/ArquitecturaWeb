package interfaces;

import Entities.Carrera;

public interface CarreraRepository {
    Carrera getCarreraById(int id);
    Carrera getCarreraByNombre(String Nombre);
    Carrera saveCarrera(Carrera c);
    void deleteCarrera(Carrera c);
}
