package DIU.Controlador;

import DIU.Modelo.Modelo_Productos;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Controlador_Productos {

    private Modelo_Productos productos;
    ConexionBDD conectar = new ConexionBDD();
    Connection conectado = conectar.conectar();
    PreparedStatement ejecutar;
    ResultSet resultado;

    public void agregarProducto(Modelo_Productos producto) {
        try {
            String spAgregarProducto = "CALL AgregarProducto(?, ?, ?)";
            CallableStatement cst = conectado.prepareCall(spAgregarProducto);
            cst.setString(1, producto.getCodigoProduct());
            cst.setString(2, producto.getNombreProducto());
            cst.setInt(3, producto.getIdProvee());

            cst.execute();
            JOptionPane.showMessageDialog(null, "Producto agregado correctamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al agregar el producto: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public DefaultTableModel obtenerDatosProductos() {
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Código Producto");
        modelo.addColumn("Nombre Producto");
        modelo.addColumn("Nombre Proveedor");

        try {
            String spObtenerDatosProductos = "CALL ObtenerDatosProductos()";
            ejecutar = conectado.prepareStatement(spObtenerDatosProductos);
            ResultSet resultado = ejecutar.executeQuery();

            while (resultado.next()) {
                Object[] fila = new Object[3];
                resultado.getInt("id_producto");
                fila[0] = resultado.getString("codigo_Product");
                fila[1] = resultado.getString("nombre_producto");
                fila[2] = resultado.getString("nombre_proveedor");
                modelo.addRow(fila);
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al obtener datos de productos: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
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

    public int obtenerIdProductoPorCodigo(String codigoProducto) {
        try {
            String spObtenerIdProducto = "CALL ObtenerIdProductoPorCodigo(?, ?)";
            CallableStatement cst = conectado.prepareCall(spObtenerIdProducto);
            cst.setString(1, codigoProducto);
            cst.registerOutParameter(2, java.sql.Types.INTEGER);
            cst.execute();
            return cst.getInt(2);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al obtener ID del producto: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            return -1;
        }
    }

    public void actualizarProducto(Modelo_Productos producto) {
        try {
            String spActualizarProducto = "CALL ActualizarProducto(?, ?, ?)";
            CallableStatement cst = conectado.prepareCall(spActualizarProducto);
            cst.setInt(1, producto.getIdProducto());
            cst.setString(2, producto.getNombreProducto());
            cst.setInt(3, producto.getIdProvee());

            cst.execute();
            JOptionPane.showMessageDialog(null, "Producto actualizado correctamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al actualizar el producto: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void eliminarProducto(int idProducto) {
        try {
            String spEliminarProducto = "CALL EliminarProductoPorID(?)";
            CallableStatement cst = conectado.prepareCall(spEliminarProducto);
            cst.setInt(1, idProducto);
            cst.execute();
            JOptionPane.showMessageDialog(null, "Producto eliminado correctamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al eliminar el producto: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    public int obtenerIdProveedorPorCodigoProduct(String codigoProducto) {
        try {
            String spObtenerIdProveedor = "CALL ObtenerIdProveedorPorCodigoProducto(?, ?)";
            CallableStatement cst = conectado.prepareCall(spObtenerIdProveedor);
            cst.setString(1, codigoProducto);
            cst.registerOutParameter(2, java.sql.Types.INTEGER);
            cst.execute();
            return cst.getInt(2);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al obtener ID del proveedor: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            return -1;
        }
    }
    public int obtenerIdPorNombre(String nombreProducto) {
        int idProducto = -1;

        try {
            String query = "{CALL ObtenerIdPorNombre(?, ?)}";
            try (CallableStatement statement = conectado.prepareCall(query)) {
                statement.setString(1, nombreProducto);
                statement.registerOutParameter(2, java.sql.Types.INTEGER);
                statement.execute();

                idProducto = statement.getInt(2);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al obtener el ID del producto por nombre.", "Error", JOptionPane.ERROR_MESSAGE);
        }

        return idProducto;
    }
    public List<String> obtenerNombresProductos() {
        List<String> nombresProductos = new ArrayList<>();
        PreparedStatement ejecutar = null;
        ResultSet rs = null;
        try {
            String sql = "SELECT nombre_producto FROM productos";
            ejecutar = conectado.prepareStatement(sql);
            rs = ejecutar.executeQuery();

            while (rs.next()) {
                nombresProductos.add(rs.getString("nombre_producto"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
                if (ejecutar != null) ejecutar.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return nombresProductos;
    }
}
