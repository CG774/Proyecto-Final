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

    private Modelo_Productos productos;
    ConexionBDD conectar = new ConexionBDD();
    Connection conectado = conectar.conectar();
    PreparedStatement ejecutar;
    ResultSet resultado;

    //Transaccionabilidad
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
        } catch (Exception e) {
            System.out.println("Ha ocurrido un fallo, por favor compruebe que los datos de la conexión a la base de datos sean correctos.");
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

    public int repiteProducto(String nombreProd) {

        String consulta = "select * from productos where nombre_producto = '" + nombreProd + "'";
        //INICIAR SESIÓN A NIVEL DE MYSQL
        int i = 0;
        try {
            ejecutar = (PreparedStatement) conectado.prepareStatement(consulta);

            ResultSet resul = ejecutar.executeQuery();
            if (resul.next()) {
                Component rootPane = null;
                JOptionPane.showMessageDialog(rootPane, "NOMBRE YA EXISTE");
                ejecutar.close();
                i = 1;
            } else {
                i = 2;
            }
        } catch (SQLException e) {
            Component rootPane = null;
            JOptionPane.showMessageDialog(rootPane, "NO EXISTE");
        }
        return i;

    }

    public DefaultTableModel buscarProductos(String nombreProducto) {
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("ID Producto");
        modelo.addColumn("Nombre");
        try {
            String SQL = "{CALL BuscarProductoPorNombre(?)}";
            ejecutar = conectado.prepareStatement(SQL);

            ejecutar.setString(1, nombreProducto);

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

    public void eliminarProducto(int idProducto) {
        //TRY Y CATCH
        try {
            //GENERAR LA CONSULTA SQL
            String consulta = "DELETE FROM productos WHERE  id_producto = ?";
            //INICIAR SESIÓN A NIVEL DE MYSQL
            ejecutar = (PreparedStatement) conectado.prepareStatement(consulta);
            ejecutar.setInt(1, idProducto);
            int resul = ejecutar.executeUpdate();
            if (resul > 0) {
                Component rootPane = null;
                JOptionPane.showMessageDialog(rootPane, "ELIMINADO CON EXITO");
                ejecutar.close();
            }

        } catch (SQLException e) {
            Component rootPane = null;
            JOptionPane.showMessageDialog(rootPane, "NO SE PUEDE ELIMANAR- EN USO");
        }
    }

    public void actualizarProducto(Modelo_Productos p, int idProducto) {
        // TRY Y CATCH
        try {
            // Preparar la llamada al procedimiento almacenado
            String llamadaSP = "{CALL ActualizarProductoPorID(?, ?)}";
            ejecutar = conectado.prepareStatement(llamadaSP);

            // Establecer los parámetros del procedimiento almacenado
            ejecutar.setInt(1, idProducto); // Asume que idProducto es el ID que deseas actualizar
            ejecutar.setString(2, p.getNombreProducto()); // Nuevo nombre del producto

            // Ejecutar el procedimiento almacenado
            int resul = ejecutar.executeUpdate();
            if (resul > 0) {
                Component rootPane = null;
                JOptionPane.showMessageDialog(rootPane, "NOMBRE DEL PRODUCTO ACTUALIZADO CON EXITO");
            }
        } catch (SQLException e) {
            Component rootPane = null;
            JOptionPane.showMessageDialog(rootPane, "NO SE PUDO ACTUALIZAR: " + e.getMessage());
        } finally {
            // Cerrar el PreparedStatement para liberar recursos
            if (ejecutar != null) {
                try {
                    ejecutar.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
        public int obtenerIdProducto (String nombreProveedor) throws SQLException {
        int idProducto = 0;
        String consulta = "SELECT ObtenerIdPorNombreProducto(?) AS id_producto";

        try (PreparedStatement stmt = conectado.prepareStatement(consulta)) {
            stmt.setString(1, nombreProveedor);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    idProducto = rs.getInt("id_proveedor");
                }
            }
        } catch (SQLException e) {
            // Manejo de excepciones
        }

        return idProducto;
    }

}
