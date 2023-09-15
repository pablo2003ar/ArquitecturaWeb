package dao;

import factory.MySQLJDBCDAOFactory;
import models.Cliente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MySQLClienteDAO implements ClienteDAO {

    public MySQLClienteDAO() {
    }

    @Override
    public void insertar(Cliente cliente) {
        String insert = "INSERT INTO cliente(idCliente, nombre, email) VALUES (?, ?, ?)";
        PreparedStatement preparedStatement = null;

        Connection connection = MySQLJDBCDAOFactory.createConnection();
        try {
            preparedStatement = connection.prepareStatement(insert);
            preparedStatement.setInt(1, cliente.getIdCliente());
            preparedStatement.setString(2, cliente.getNombre());
            preparedStatement.setString(3, cliente.getEmail());
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
        String tabla = "CREATE TABLE IF NOT EXISTS cliente(" +
                "idCliente INT," +
                "nombre VARCHAR(500)," +
                "email VARCHAR(150)," +
                "PRIMARY KEY(idCliente))";
        Connection connection = MySQLJDBCDAOFactory.createConnection();
        try {
            connection.prepareStatement(tabla).execute();
            connection.commit();
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public ArrayList<Cliente> ordenarClientesMayorFacturacion() {

        ArrayList<Cliente> clientes = new ArrayList<>();
        PreparedStatement preparedStatement = null;
        Connection connection = MySQLJDBCDAOFactory.createConnection();
        try {
            String consultaSQL = "SELECT c.idCliente, c.nombre, c.email, SUM(fp.cantidad*p.valor) as totalFacturado FROM cliente c INNER JOIN factura f ON c.idCliente = f.idCliente INNER JOIN factura_producto fp ON fp.idFactura = f.idFactura INNER JOIN producto p ON p.idProducto = fp.idProducto GROUP BY c.idCliente ORDER BY totalFacturado DESC ";

            preparedStatement = connection.prepareStatement(consultaSQL);
            ResultSet resultado = preparedStatement.executeQuery();

            while (resultado.next()) {
                int idCliente = resultado.getInt("idCliente");
                String nombre = resultado.getString("nombre");
                String email = resultado.getString("email");


                Cliente cliente = new Cliente(idCliente, nombre, email);
                clientes.add(cliente);
            }

            connection.commit();
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return clientes;
    }
}
