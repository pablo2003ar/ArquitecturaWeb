package org.example;

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
        DAOFactory mySQLJDBCDAOFactory = DAOFactory.getDAOFactory(1);

        ClienteDAO clienteDao =  mySQLJDBCDAOFactory.getClienteDAO();
        ProductoDAO productoDao = mySQLJDBCDAOFactory.getProductoDAO();
        Dao<Factura> facturaDao = mySQLJDBCDAOFactory.getFacturaDAO();
        Dao<FacturaProducto> facturaProductoDao = mySQLJDBCDAOFactory.getFacturaProductoDAO();

        clienteDao.crear();
        productoDao.crear();
        facturaDao.crear();
        facturaProductoDao.crear();

        /*
        CSVParser parser = null;
        try {
            parser = CSVFormat.DEFAULT.withHeader().parse(new
                    FileReader("productos.csv"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        for(CSVRecord row: parser) {
            Producto producto = new Producto(Integer.valueOf(row.get("idProducto")),  row.get("nombre"),  Float.valueOf(row.get("valor")));
            productoDao.insertar(producto);
        }


        // Para clientes.csv
        CSVParser parserCliente = null;
        try {
            parserCliente = CSVFormat.DEFAULT.withHeader().parse(new FileReader("clientes.csv"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        for(CSVRecord row: parserCliente) {
            Cliente cliente = new Cliente(Integer.valueOf(row.get("idCliente")), row.get("nombre"), row.get("email"));
            clienteDao.insertar(cliente);
        }

        CSVParser parserFactura = null;
        try {
            parserFactura = CSVFormat.DEFAULT.withHeader().parse(new FileReader("facturas.csv"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        for(CSVRecord row: parserFactura) {
            Factura factura = new Factura(Integer.valueOf(row.get("idFactura")), Integer.valueOf(row.get("idCliente")));
            facturaDao.insertar(factura);
        }

        CSVParser parserFacturaProducto = null;
        try {
            parserFacturaProducto = CSVFormat.DEFAULT.withHeader().parse(new FileReader("facturas-productos.csv"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        for(CSVRecord row: parserFacturaProducto) {
            FacturaProducto facturaProducto = new FacturaProducto(Integer.valueOf(row.get("idFactura")), Integer.valueOf(row.get("idProducto")), Integer.valueOf(row.get("cantidad")));
            facturaProductoDao.insertar(facturaProducto);
        }
        */

        ArrayList<Cliente> clientes = clienteDao.ordenarClientesMayorFacturacion();
        for (int i = 0; i < clientes.size(); i++) {
            System.out.println(clientes.get(i));
        }

        Producto producto = productoDao.obtenerProductoMayorRecaudacion();
        System.out.println(producto);
    }
}