package DIU.Controlador;

import DIU.Modelo.Modelo_Proveedor;
import java.awt.Component;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Controlador_Proveedor {

    private Modelo_Proveedor proveedores;
    ConexionBDD conectar = new ConexionBDD();
    Connection conectado = conectar.conectar();
    PreparedStatement ejecutar;
    ResultSet resultado;

    public void agregarProveedor(Modelo_Proveedor proveedor) {
        try (CallableStatement cs = conectado.prepareCall("{call AgregarProveedor(?, ?, ?, ?)}")) {
            cs.setString(1, proveedor.getCodigo());
            cs.setString(2, proveedor.getNombre_proveedor());
            cs.setString(3, proveedor.getTelefono_proveedor());
            cs.setString(4, proveedor.getCorreo());
            int resultado = cs.executeUpdate();

            if (resultado > 0) {
                JOptionPane.showMessageDialog(null, "PROVEEDOR AGREGADO CON ÉXITO");
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo agregar el proveedor");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error al agregar el proveedor: " + e.getMessage());
        }
    }

    public int obtenerIdProveedorPorCodigo(String codigoProveedor) {
        int idProveedor = 0;

        try (CallableStatement cs = conectado.prepareCall("{call ObtenerIdProveedorPorCodigo(?, ?)}")) {
            cs.setString(1, codigoProveedor);
            cs.registerOutParameter(2, java.sql.Types.INTEGER);
            cs.executeQuery();

            idProveedor = cs.getInt(2);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error al obtener el ID del proveedor: " + e.getMessage());
        }

        return idProveedor;
    }

    public DefaultTableModel obtenerDatosProveedores() {
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Código Proveedor");
        modelo.addColumn("Nombre");
        modelo.addColumn("Teléfono");
        modelo.addColumn("Correo");

        try {
            String procedimiento = "{call ObtenerDatosProveedores()}";
            ejecutar = conectado.prepareCall(procedimiento);
            ResultSet resultado = ejecutar.executeQuery();

            while (resultado.next()) {
                Object[] fila = new Object[4];
                resultado.getInt("id_proveedor");
                fila[0] = resultado.getString("codigo_Provee");
                fila[1] = resultado.getString("nombre_proveedor");
                fila[2] = resultado.getString("telefono_proveedor");
                fila[3] = resultado.getString("correo");
                modelo.addRow(fila);
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al obtener datos de proveedores: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            try {
                if (ejecutar != null) {
                    ejecutar.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }

        return modelo;
    }

    public void actualizarProveedor(Modelo_Proveedor proveedor) {
        try (CallableStatement cs = conectado.prepareCall("{call ActualizarProveedor(?, ?, ?, ?)}")) {
            cs.setInt(1,  proveedor.getId_proveedor());
            cs.setString(2, proveedor.getNombre_proveedor());
            cs.setString(3, proveedor.getTelefono_proveedor());
            cs.setString(4, proveedor.getCorreo());
            int resultado = cs.executeUpdate();

            if (resultado > 0) {
                JOptionPane.showMessageDialog(null, "PROVEEDOR ACTUALIZADO CON ÉXITO");
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo actualizar el proveedor");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error al actualizar el proveedor: " + e.getMessage());
        }
    }

    public void eliminarProveedor(int idProveedor) {
        try (CallableStatement cs = conectado.prepareCall("{call EliminarProveedor(?)}")) {
            cs.setInt(1, idProveedor);
            int resultado = cs.executeUpdate();

            if (resultado > 0) {
                JOptionPane.showMessageDialog(null, "PROVEEDOR ELIMINADO CON ÉXITO");
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo eliminar el proveedor");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error al eliminar el proveedor: " + e.getMessage());
        }
    }
}
