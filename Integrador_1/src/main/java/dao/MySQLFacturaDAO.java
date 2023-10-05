package dao;

import factory.MySQLJDBCDAOFactory;
import models.Cliente;
import models.Factura;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

public class MySQLFacturaDAO implements Dao<Factura> {


    @Override
    public void insertar(Factura factura) {
        String insert = "INSERT INTO factura(idFactura, idCliente) VALUES (?, ?)";

        PreparedStatement preparedStatement = null;
        Connection connection = MySQLJDBCDAOFactory.createConnection();
        try {
            preparedStatement = connection.prepareStatement(insert);
            preparedStatement.setInt(1, factura.getIdFactura());
            preparedStatement.setInt(2, factura.getIdCliente());
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
        String tabla = "CREATE TABLE IF NOT EXISTS factura(" +
                "idFactura INT," +
                "idCliente INT," +
                "PRIMARY KEY(idFactura)," +
                "FOREIGN KEY (idCliente) REFERENCES cliente(idCliente)" +
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
