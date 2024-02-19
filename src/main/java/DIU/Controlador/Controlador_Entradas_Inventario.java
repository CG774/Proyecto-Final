package DIU.Controlador;

import DIU.Modelo.Modelo_Entradas_Inventario;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Controlador_Entradas_Inventario {

    private ConexionBDD conectar = new ConexionBDD();
    private Connection conectado = conectar.conectar();

    public List<String> obtenerNombresProductos(int idProveedor) {
        List<String> nombresProductos = new ArrayList<>();

        try {
            String query = "{CALL ObtenerListaNombresProd(?)}";
            try (CallableStatement statement = conectado.prepareCall(query)) {
                statement.setInt(1, idProveedor);

                try (ResultSet resultSet = statement.executeQuery()) {
                    while (resultSet.next()) {
                        String nombreProducto = resultSet.getString("nombre_producto");
                        nombresProductos.add(nombreProducto);
                    }
                }
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al obtener la lista de nombres de productos.", "Error", JOptionPane.ERROR_MESSAGE);
        }
        return nombresProductos;
    }

    public DefaultTableModel obtenerEntradas() {
        DefaultTableModel modelo = new DefaultTableModel();


        modelo.addColumn("Código de entrada");
        modelo.addColumn("Proveedor");
        modelo.addColumn("Producto");
        modelo.addColumn("Cantidad (kg)");
        modelo.addColumn("Fecha de entrada");

        try {
            String query = "{CALL obtenerEntradas()}";
            try (CallableStatement statement = conectado.prepareCall(query)) {
                try (ResultSet resultSet = statement.executeQuery()) {
                    while (resultSet.next()) {
                        String codigoEntrada = resultSet.getString("codigo_entrada");
                        String proveedor = resultSet.getString("proveedor");
                        String producto = resultSet.getString("producto");
                        double cantidad = resultSet.getDouble("cantidad_kg");
                        String fechaEntrada = resultSet.getString("fecha_entrada");

                        modelo.addRow(new Object[]{codigoEntrada, proveedor, producto, cantidad, fechaEntrada});
                    }
                }
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al obtener las entradas del inventario.", "Error", JOptionPane.ERROR_MESSAGE);
        }

        return modelo;
    }
    public void agregarEntradaInventario(Modelo_Entradas_Inventario entradas) {
        try {
            String query = "{CALL agregarEntradaInven(?, ?, ?, ?)}";
            try (CallableStatement statement = conectado.prepareCall(query)) {
                statement.setInt(1, entradas.getId_proveedor());
                statement.setInt(2, entradas.getId_producto());
                statement.setDouble(3, entradas.getCantidadKg());

                statement.setTimestamp(4, new Timestamp(System.currentTimeMillis()));

                statement.execute();

                JOptionPane.showMessageDialog(null, "Entrada al inventario agregada con éxito.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al agregar entrada al inventario.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    public DefaultTableModel filtrarEntradasPorFecha(String seleccion) {
        DefaultTableModel modelo = new DefaultTableModel();

        modelo.addColumn("Código Entrada");
        modelo.addColumn("Proveedor");
        modelo.addColumn("Producto");
        modelo.addColumn("Cantidad (kg)");
        modelo.addColumn("Fecha Entrada");

        try {
            String query = "{CALL FiltrarEntradasPorFecha(?)}";
            try (CallableStatement statement = conectado.prepareCall(query)) {
                statement.setString(1, seleccion);

                try (ResultSet resultSet = statement.executeQuery()) {
                    while (resultSet.next()) {
                        String codigoEntrada = resultSet.getString("codigo_entrada");
                        String proveedor = resultSet.getString("proveedor");
                        String producto = resultSet.getString("producto");
                        double cantidadKg = resultSet.getDouble("cantidad_kg");
                        String fechaEntrada = resultSet.getString("fecha_entrada");

                        modelo.addRow(new Object[]{codigoEntrada, proveedor, producto, cantidadKg, fechaEntrada});
                    }
                }
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al filtrar las entradas por fecha.", "Error", JOptionPane.ERROR_MESSAGE);
        }

        return modelo;
    }
}
