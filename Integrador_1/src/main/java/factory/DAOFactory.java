package factory;

import dao.ClienteDAO;
import dao.Dao;
import dao.ProductoDAO;
import models.Cliente;
import models.Factura;
import models.FacturaProducto;
import models.Producto;

public abstract class DAOFactory {
    public static final int MYSQL_JDBC = 1;
    public static final int DERBY_JDBC = 2;
    public static final int JPA_HIBERNATE = 3;

    public abstract ClienteDAO getClienteDAO();
    public abstract ProductoDAO getProductoDAO();
    public abstract Dao<FacturaProducto> getFacturaProductoDAO();
    public abstract Dao<Factura> getFacturaDAO();
    public static DAOFactory getDAOFactory(int whichFactory) {
        switch (whichFactory) {
            case MYSQL_JDBC : return MySQLJDBCDAOFactory.getInstance();
            default: return null;
        }
    }

}
