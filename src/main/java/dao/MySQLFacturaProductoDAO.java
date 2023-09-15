package dao;

import factory.MySQLJDBCDAOFactory;
import models.Cliente;
import models.FacturaProducto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MySQLFacturaProductoDAO implements Dao<FacturaProducto> {



    @Override
    public void insertar(FacturaProducto facturaProducto) {
        String insert = "INSERT INTO factura_producto(idFactura, idProducto, cantidad) VALUES (?, ?, ?)";

        PreparedStatement preparedStatement = null;
        Connection connection = MySQLJDBCDAOFactory.createConnection();
        try {
            preparedStatement = connection.prepareStatement(insert);
            preparedStatement.setInt(1, facturaProducto.getIdFactura());
            preparedStatement.setInt(2, facturaProducto.getIdProducto());
            preparedStatement.setInt(3, facturaProducto.getCantidad());
            preparedStatement.executeUpdate();
            preparedStatement.close();
            connection.commit();
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }



    @Override
    public void crear() {
        String tabla = "CREATE TABLE IF NOT EXISTS factura_producto(" +
                "idFactura INT," +
                "idProducto INT," +
                "cantidad INT," +
                "PRIMARY KEY(idFactura, idProducto)," +
                "FOREIGN KEY (idFactura) REFERENCES factura(idFactura)," +
                "FOREIGN KEY (idProducto) REFERENCES producto(idProducto)" +
                ")";
        try {
            Connection connection = MySQLJDBCDAOFactory.createConnection();

            connection.prepareStatement(tabla).execute();
            connection.commit();
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
