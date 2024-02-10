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

    public DefaultTableModel AgregarProveedor(Modelo_Proveedor p) {
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("ID Proveedor");
        modelo.addColumn("Nombre");
        modelo.addColumn("Teléfono");

        try {
            String SQL = "CALL AgregarProveedor('" + p.getNombre() + "','" + p.getTelefono() + "')";
            ejecutar = conectado.prepareCall(SQL);

            boolean res = ejecutar.execute();

            if (!res) { 
                
            } else {
                
                ResultSet rs = ejecutar.getResultSet();

                
                while (rs.next()) {
                    Object[] fila = new Object[3];
                    fila[0] = rs.getInt("id_proveedor");
                    fila[1] = rs.getString("nombre_proveedor");
                    fila[2] = rs.getString("telefono");
                    modelo.addRow(fila);
                }

                rs.close();
            }
            JOptionPane.showMessageDialog(null, "Proveedor agregado exitosamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se pueden repetir nombres o números telefónicos", "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        } 
        return modelo;
    }
    public DefaultTableModel obtenerDatosProveedor() {
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("ID Proveedor");
        modelo.addColumn("Nombre");
        modelo.addColumn("Teléfono");

        try {
            String SQL = "CALL ObtenerProveedores()";
            ejecutar = conectado.prepareCall(SQL);
            resultado = ejecutar.executeQuery();

            while (resultado.next()) {
                Object[] fila = new Object[3];
                fila[0] = resultado.getInt("id_proveedor");
                fila[1] = resultado.getString("nombre_proveedor");
                fila[2] = resultado.getString("telefono");
                modelo.addRow(fila);
            }
        } catch (Exception e) {
            System.out.println("Error al obtener datos de proveedores: " + e.getMessage());
        } finally {
            // Cerrar recursos
            try {
                if (resultado != null) {
                    resultado.close();
                }
                if (ejecutar != null) {
                    ejecutar.close();
                }
            } catch (Exception ex) {
                System.out.println("Error al cerrar recursos: " + ex.getMessage());
            }
        }

        return modelo;
    }
    
    public DefaultTableModel buscarProveedorPorNombre(String nombreProveedor) {
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("ID Proveedor");
        modelo.addColumn("Nombre");
        modelo.addColumn("Teléfono");

        try {
            String SQL = "CALL BuscarProveedorPorNombre('"+ nombreProveedor +"')";
            ejecutar = conectado.prepareCall(SQL);
            resultado = ejecutar.executeQuery();
            while (resultado.next()) {
                Object[] fila = new Object[3];
                fila[0] = resultado.getInt("id_proveedor");
                fila[1] = resultado.getString("nombre_proveedor");
                fila[2] = resultado.getString("telefono");
                modelo.addRow(fila);
            }
        } catch (Exception e) {
            System.out.println("Error al buscar proveedor por nombre: " + e.getMessage());
        } finally {
            
            try {
                if (resultado != null) {
                    resultado.close();
                }
                if (ejecutar != null) {
                    ejecutar.close();
                }
            } catch (Exception ex) {
                System.out.println("Error al cerrar recursos: " + ex.getMessage());
            }
        }

        return modelo;
    }
    public void eliminarProveedor(Modelo_Proveedor p) {
        try {
            String SQL = "CALL EliminarProveedor('" + p.getNombre() + "','" + p.getTelefono() + "')";
            ejecutar = conectado.prepareCall(SQL);
            ejecutar.executeUpdate();
            JOptionPane.showMessageDialog(null, "Proveedor eliminado exitosamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            System.out.println("FALLO PROVEE: Ha ocurrido un fallo, por favor compruebe que los datos de la conexión a la base de datos sean correctos.");
            e.printStackTrace();
        } 
    }
    public void editarProveedor(Modelo_Proveedor proveedor) {
        try {
            String SQL = "CALL EditarProveedor(?, ?, ?)";
            ejecutar = conectado.prepareCall(SQL);
            ejecutar.setInt(1, proveedor.getId());
            ejecutar.setString(2, proveedor.getNombre());
            ejecutar.setString(3, proveedor.getTelefono());
            ejecutar.executeUpdate();
            JOptionPane.showMessageDialog(null, "Proveedor editado exitosamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);

        } catch (Exception e) {
            System.out.println("Error al editar proveedor: " + e.getMessage());
            JOptionPane.showMessageDialog(null, "Error al editar proveedor: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            
            try {
                if (resultado != null) {
                    resultado.close();
                }
                if (ejecutar != null) {
                    ejecutar.close();
                }
            } catch (SQLException ex) {
                System.out.println("Error al cerrar recursos: " + ex.getMessage());
            }
        }
    }
    






}
