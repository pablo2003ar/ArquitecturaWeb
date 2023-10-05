package dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public interface Dao<T> {

    void insertar(T t);

    void crear();
}
