package dao;

import models.Cliente;

import java.lang.reflect.Array;
import java.util.ArrayList;

public interface ClienteDAO extends Dao<Cliente>{

    ArrayList<Cliente> ordenarClientesMayorFacturacion();

}
