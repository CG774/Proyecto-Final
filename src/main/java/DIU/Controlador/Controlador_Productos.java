package DIU.Controlador;

import DIU.Modelo.Modelo_Productos;
import java.awt.Component;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author carlo
 */
public class Controlador_Productos {

    private Modelo_Productos producto;
    ConexionBDD conectar = new ConexionBDD();
    Connection conectado = conectar.conectar();
    PreparedStatement ejecutar;
    ResultSet resultado;

    public void AgregarProducto(Modelo_Productos p) {
        try {
            String SQL = "CALL AgregarProducto('" + p.getNombreProducto() + "')";
            ejecutar = conectado.prepareCall(SQL);
            int res = ejecutar.executeUpdate();
            if (res > 0) {
                System.out.println("Producto creado con éxito");

            } else {
                System.out.println("No se agregó el Producto");
            }
        JOptionPane.showMessageDialog(null, "Producto agregado exitosamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al agregar el Producto: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public DefaultTableModel obtenerDatosProductos() {
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("ID Producto");
        modelo.addColumn("Nombre");

        try {
            String SQL = "select * from productos";
            ejecutar = conectado.prepareStatement(SQL);
            resultado = ejecutar.executeQuery();

            while (resultado.next()) {
                Object[] fila = new Object[2];
                fila[0] = resultado.getInt("id_producto");
                fila[1] = resultado.getString("nombre_producto");
                modelo.addRow(fila);
            }
        } catch (Exception e) {
            System.out.println("Error al obtener datos de productos: " + e.getMessage());
        }

        return modelo;
    }

    public DefaultTableModel buscarProductos(String nombreProducto) {
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("ID Producto");
        modelo.addColumn("Nombre");

        try {
            String SQL = "select * from productos where nombre_producto ='" + nombreProducto + "'";
            ejecutar = conectado.prepareStatement(SQL);
            resultado = ejecutar.executeQuery();

            while (resultado.next()) {
                Object[] fila = new Object[2];
                fila[0] = resultado.getInt("id_producto");
                fila[1] = resultado.getString("nombre_producto");
                modelo.addRow(fila);
            }
        } catch (Exception e) {
            System.out.println("Error al obtener datos de productos: " + e.getMessage());
        }

        return modelo;
    }
    public void EliminarProductoPorID(Modelo_Productos pro) {
        try {
            String SQL = "{CALL EliminarProductoPorID(?)}";
            ejecutar = conectado.prepareCall(SQL);
            ejecutar.setInt(1, pro.getIdProducto());
            int res = ejecutar.executeUpdate();

            if (res > 0) {
                JOptionPane.showMessageDialog(null, "Producto eliminado con éxito.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo eliminar el Producto.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al eliminar el producto: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            try {
                // Cerrar recursos
                if (ejecutar != null) ejecutar.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
    public void ActualizarProducto(Modelo_Productos p) {
        try {
            String SQL = "{CALL ActualizarProducto(?, ?)}";
            ejecutar = conectado.prepareCall(SQL);
            ejecutar.setInt(1, p.getIdProducto());
            ejecutar.setString(2, p.getNombreProducto());
            int res = ejecutar.executeUpdate();

            if (res > 0) {
                JOptionPane.showMessageDialog(null, "Producto actualizado con éxito.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo actualizar el Producto.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al actualizar el producto: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            try {
                if (ejecutar != null) ejecutar.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
}
