package interfaces;

import Entities.Inscripciones;

public interface InscripcionesRepository {
    Inscripciones getInscripcionesById(int id);
    Inscripciones getInscripcionesByAntiguedad(int antiguedad);
    Inscripciones saveInscripciones(Inscripciones i);
    void deleteInscripciones(Inscripciones i);
}
