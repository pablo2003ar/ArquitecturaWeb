package org.example;

//IMPORTS
import java.sql.*;
import dao.ClienteDAO;
import dao.Dao;
import dao.ProductoDAO;
import factory.DAOFactory;
import factory.MySQLJDBCDAOFactory;
import models.Cliente;
import models.Factura;
import models.FacturaProducto;
import models.Producto;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        //Limpieza de Base de Datos
        clearDatabase("factura_producto");
        clearDatabase("producto");
        clearDatabase("factura");
        clearDatabase("cliente");

        DAOFactory mySQLJDBCDAOFactory = DAOFactory.getDAOFactory(1);
        ClienteDAO clienteDao =  mySQLJDBCDAOFactory.getClienteDAO();
        ProductoDAO productoDao = mySQLJDBCDAOFactory.getProductoDAO();
        Dao<Factura> facturaDao = mySQLJDBCDAOFactory.getFacturaDAO();
        Dao<FacturaProducto> facturaProductoDao = mySQLJDBCDAOFactory.getFacturaProductoDAO();

        //Creacion de Tablas en la base de datos.
        clienteDao.crear();
        productoDao.crear();
        facturaDao.crear();
        facturaProductoDao.crear();

        //Se agregan los elementos definidos en los archivos CVS a la base de datos
        //PRODUCTOS.CVS
        CSVParser parser = null;
        try {
            parser = CSVFormat.DEFAULT.withHeader().parse(new
                    FileReader("ArquitecturaWeb/productos.csv"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        for(CSVRecord row: parser) {
            Producto producto = new Producto(Integer.valueOf(row.get("idProducto")),  row.get("nombre"),  Float.valueOf(row.get("valor")));
            productoDao.insertar(producto);
        }

        //CLIENVES.CVS
        CSVParser parserCliente = null;
        try {
            parserCliente = CSVFormat.DEFAULT.withHeader().parse(new FileReader("ArquitecturaWeb/clientes.csv"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        for(CSVRecord row: parserCliente) {
            Cliente cliente = new Cliente(Integer.valueOf(row.get("idCliente")), row.get("nombre"), row.get("email"));
            clienteDao.insertar(cliente);
        }

        //FACTURAS.CVS
        CSVParser parserFactura = null;
        try {
            parserFactura = CSVFormat.DEFAULT.withHeader().parse(new FileReader("ArquitecturaWeb/facturas.csv"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        for(CSVRecord row: parserFactura) {
            Factura factura = new Factura(Integer.valueOf(row.get("idFactura")), Integer.valueOf(row.get("idCliente")));
            facturaDao.insertar(factura);
        }

        //FACTURAS_PRODUCTOS.CVS
        CSVParser parserFacturaProducto = null;
        try {
            parserFacturaProducto = CSVFormat.DEFAULT.withHeader().parse(new FileReader("ArquitecturaWeb/facturas-productos.csv"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        for(CSVRecord row: parserFacturaProducto) {
            FacturaProducto facturaProducto = new FacturaProducto(Integer.valueOf(row.get("idFactura")), Integer.valueOf(row.get("idProducto")), Integer.valueOf(row.get("cantidad")));
            facturaProductoDao.insertar(facturaProducto);
        }

        //Respuesta a consigna 4 - Lista de Clientes por facturacion.
        ArrayList<Cliente> clientes = clienteDao.ordenarClientesMayorFacturacion();
        for (int i = 0; i < clientes.size(); i++) {
            System.out.println(clientes.get(i));
        }

        //Respuesta a consigna 3 - El producto que mas recaudo
        Producto producto = productoDao.obtenerProductoMayorRecaudacion();
        System.out.println();
        System.out.println(producto);
        System.out.println( "El producto que mas recaudo es el: " + producto.getIdProducto());
    }

    //Metodo que borra las tablas de la base de datos, si existen. Se realiza para evitar errores.
    private static void clearDatabase(String table_name) {
        String delete = "DROP TABLE IF EXISTS integrador1." + table_name;
        PreparedStatement preparedStatement = null;
        Connection connection = MySQLJDBCDAOFactory.createConnection();
        try {
            preparedStatement = connection.prepareStatement(delete);
            preparedStatement.executeUpdate();
            preparedStatement.close();
            connection.commit();
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


}