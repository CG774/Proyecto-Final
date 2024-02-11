package DIU.Controlador;

import DIU.Modelo.Modelo_Proveedor;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class Controlador_Proveedor {
    private Modelo_Proveedor proveedor;
    ConexionBDD conectar = new ConexionBDD();
    Connection conectado = conectar.conectar();
    CallableStatement ejecutar;
    ResultSet resultado;
    
    public int ObtenerIdProductoPorNombre(String nombreProducto) {
        int idProducto = 0;

        try {
            String procedimiento = "{call ObtenerIdProductoPorNombre(?)}";
            ejecutar = conectado.prepareCall(procedimiento);
            ejecutar.setString(1, nombreProducto);
            resultado = ejecutar.executeQuery();

            if (resultado.next()) {
                idProducto = resultado.getInt("IdProducto");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al obtener el ID del producto por nombre: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            try {
                if (resultado != null) resultado.close();
                if (ejecutar != null) ejecutar.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }

        return idProducto;
    }
    public void AgregarProveedor(Modelo_Proveedor p) {
        try {
            String procedimiento = "{call AgregarProveedor(?, ?)}";
            ejecutar = conectado.prepareCall(procedimiento);
            ejecutar.setString(1, p.getNombre());
            ejecutar.setInt(2, p.getProducto().getIdProducto());
            ejecutar.executeUpdate();

            JOptionPane.showMessageDialog(null, "Proveedor agregado exitosamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al agregar el proveedor: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            try {
                if (ejecutar != null) ejecutar.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
    public DefaultTableModel ObtenerProveedores() {
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("id_proveedor");
        modelo.addColumn("nombre_proveedor");
        modelo.addColumn("id_producto");

        try {
            // Llamar al procedimiento almacenado
            String procedimiento = "{call ObtenerProveedores()}";
            ejecutar = conectado.prepareCall(procedimiento);
            resultado = ejecutar.executeQuery();

            // Llenar el modelo con los resultados
            while (resultado.next()) {
                Object[] fila = {
                    resultado.getInt("id_proveedor"),
                    resultado.getString("nombre_proveedor"),
                    resultado.getInt("id_producto")
                };
                modelo.addRow(fila);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al obtener los proveedores: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            try {
                // Cerrar recursos
                if (resultado != null) resultado.close();
                if (ejecutar != null) ejecutar.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }

        return modelo;
    }
    public int ObtenerIdProveedorPorNombre(Modelo_Proveedor p) {
        int idProveedor = 0;
        try {
            String procedimiento = "{call ObtenerIdProveedorPorNombre(?, ?)}";
            ejecutar = conectado.prepareCall(procedimiento);
            ejecutar.setString(1, p.getNombre());
            ejecutar.registerOutParameter(2, java.sql.Types.INTEGER);
            ejecutar.executeUpdate();

            idProveedor = ejecutar.getInt(2);
            

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al obtener el ID del proveedor por nombre: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            try {
                // Cerrar recursos
                if (ejecutar != null) ejecutar.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return idProveedor;
    }
    public void EliminarProveedor(Modelo_Proveedor p) {
        try {
            String procedimiento = "{call EliminarProveedor(?)}";
            ejecutar = conectado.prepareCall(procedimiento);
            ejecutar.setInt(1, p.getId());
            ejecutar.executeUpdate();

            JOptionPane.showMessageDialog(null, "Proveedor eliminado exitosamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al eliminar el proveedor: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            try {
                // Cerrar recursos
                if (ejecutar != null) ejecutar.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
    public void EditarProveedor(Modelo_Proveedor p) {
        try {
            String procedimiento = "{call EditarProveedor(?, ?, ?)}";
            ejecutar = conectado.prepareCall(procedimiento);
            ejecutar.setInt(1, p.getId());
            ejecutar.setString(2, p.getNombre());
            ejecutar.setInt(3, p.getProducto().getIdProducto());
            ejecutar.executeUpdate();

            JOptionPane.showMessageDialog(null, "Proveedor editado exitosamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al editar el proveedor: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            try {
                if (ejecutar != null) ejecutar.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
}