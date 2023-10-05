package dao;

import models.Producto;

public interface ProductoDAO extends Dao<Producto> {

    Producto obtenerProductoMayorRecaudacion();
}
