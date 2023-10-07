package interfaces;

import Entities.Estudiante;
import dto.EstudianteDTO;

public interface EstudianteRepository {
    Estudiante getEstudianteByNroLibreta(int nroLibreta);

    EstudianteDTO getEstudianteLibreta(int nroLibreta);
    void saveEstudiante(Estudiante e);
    void deleteEstudiante(Estudiante e);

}
