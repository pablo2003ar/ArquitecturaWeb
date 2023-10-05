package interfaces;

import Entities.Estudiante;

public interface EstudianteRepository {
    Estudiante getEstudianteById(int nroLibreta);
    Estudiante getEstudianteByApellido(String Apellido);
    Estudiante saveEstudiante(Estudiante e);
    void deleteEstudiante(Estudiante e);

}
