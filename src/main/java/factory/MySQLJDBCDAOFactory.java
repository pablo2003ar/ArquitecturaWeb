package factory;

import dao.*;
import java.sql.*;
import models.Cliente;
import models.Factura;
import models.FacturaProducto;
import models.Producto;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLJDBCDAOFactory extends DAOFactory {

    public static final String DRIVER = "com.mysql.cj.jdbc.Driver";

    //Verificar la ruta de la conexion JDBC ya que la ruta puede variar dependiendo el puerto y nombre de la base de datos.
    public static final String DBURL = "jdbc:mysql://localhost:3306/integrador1";



    private static MySQLJDBCDAOFactory instance;

    private  MySQLJDBCDAOFactory() {

    }

        public static MySQLJDBCDAOFactory getInstance() {
            if (instance == null) {
                instance = new MySQLJDBCDAOFactory();
            }
            return instance;
        }

    public static Connection createConnection() {
        Connection connection = null;
        try {
            Class.forName(DRIVER).getDeclaredConstructor().newInstance();
            //Verificar usuario y contraseña para la conxion de la base de datos MySQL ya que puede variar dependiendo la configuracion de cada tester.
            connection = DriverManager.getConnection(DBURL, "root", "");
            connection.setAutoCommit(false);
        } catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
                 | NoSuchMethodException | SecurityException | ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            System.exit(1);
        }
        return connection;
    }

    @Override
    public ClienteDAO getClienteDAO() {
        return new MySQLClienteDAO();
    }

    @Override
    public ProductoDAO getProductoDAO() {
        return new MySQLProductoDAO();    }

    @Override
    public Dao<FacturaProducto> getFacturaProductoDAO() {
        return new MySQLFacturaProductoDAO();    }

    @Override
    public Dao<Factura> getFacturaDAO() {
        return new MySQLFacturaDAO();    }
}
