package dao;

import com.mysql.cj.jdbc.exceptions.MySQLQueryInterruptedException;
import factory.MySQLJDBCDAOFactory;
import models.Cliente;
import models.FacturaProducto;
import models.Producto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MySQLProductoDAO implements ProductoDAO {

    @Override
    public void insertar(Producto producto) {
        String insert = "INSERT INTO producto(idProducto, nombre, valor) VALUES (?, ?, ?)";

        PreparedStatement preparedStatement = null;
        Connection connection = MySQLJDBCDAOFactory.createConnection();
        try {
            preparedStatement = connection.prepareStatement(insert);
            preparedStatement.setInt(1, producto.getIdProducto());
            preparedStatement.setString(2, producto.getNombre());
            preparedStatement.setFloat(3, producto.getValor());
            preparedStatement.executeUpdate();
            preparedStatement.close();
            connection.commit();
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Producto obtenerProductoMayorRecaudacion() {


        PreparedStatement preparedStatement = null;
        Producto producto = null;
        Connection connection = MySQLJDBCDAOFactory.createConnection();
        try {
            String consultaSQL = "SELECT fp.idProducto, p.nombre, SUM(cantidad), valor, SUM(cantidad) * valor AS recaudo " +
                    "FROM factura_producto fp " +
                    "INNER JOIN producto p ON p.idProducto = fp.idProducto " +
                    "GROUP BY fp.idProducto " +
                    "ORDER BY recaudo DESC " +
                    "LIMIT 1";

            preparedStatement = connection.prepareStatement(consultaSQL);
            ResultSet resultado = preparedStatement.executeQuery();

            if (resultado.next()) {
                int idProducto = resultado.getInt("idProducto");
                String nombreProducto = resultado.getString("nombre");
                int cantidadVendida = resultado.getInt("SUM(cantidad)");
                int valor = resultado.getInt("valor");

                producto = new Producto(idProducto, nombreProducto, valor);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return producto;
    }

    @Override
    public void crear() {
        String tabla = "CREATE TABLE IF NOT EXISTS producto(" +
                "idProducto INT," +
                "nombre VARCHAR(45)," +
                "valor float," +
                "PRIMARY KEY(idProducto))";
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
