package DIU.Controlador;

import DIU.Modelo.Modelo_Proveedor;
import java.awt.Component;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Controlador_Proveedor {

    private Modelo_Proveedor proveedores;
    ConexionBDD conectar = new ConexionBDD();
    Connection conectado = conectar.conectar();
    PreparedStatement ejecutar;
    ResultSet resultado;

    public void AgregarProveedor(Modelo_Proveedor proveedor) {
        try {
            // Asume que 'conectado' es una conexión activa a la base de datos
            // Prepara la llamada al procedimiento almacenado 'AgregarProveedor'
            String SQL = "{CALL AgregarProveedor(?, ?)}"; // Suponiendo que el SP espera dos parámetros: nombre y teléfono
            try (CallableStatement ejecutar = conectado.prepareCall(SQL)) {
                // Establece los parámetros del procedimiento almacenado
                ejecutar.setString(1, proveedor.getNombre_proveedor()); // Primer parámetro: nombre del proveedor
                ejecutar.setString(2, proveedor.getTelefono_proveedor()); // Segundo parámetro: teléfono del proveedor

                // Ejecuta el procedimiento almacenado
                boolean resultado = ejecutar.execute();

                if (resultado) {
                    System.out.println("Proveedor creado con éxito");
                } else {
                    System.out.println("No se agregó el Proveedor");
                }
            }
        } catch (SQLException e) {
            System.out.println("Ha ocurrido un error al agregar el proveedor: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Ha ocurrido un fallo no esperado: " + e.getMessage());
        }
    }

    public int repiteProveedor(String nombreProv) {

        String consulta = "select * from proveedores where nombre_proveedor = '" + nombreProv + "'";
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

    public void eliminarProveedor(int idProducto) {
        //TRY Y CATCH
        try {
            //GENERAR LA CONSULTA SQL
            String consulta = "DELETE FROM proveedores WHERE  id_proveedor = ?";
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

    public void actualizarProveedor(Modelo_Proveedor p, int idProveedor) {
        // TRY Y CATCH
        try {
            // Preparar la llamada al procedimiento almacenado
            String llamadaSP = "{CALL ActualizarProveedorPorId(?, ?, ?)}";
            ejecutar = conectado.prepareStatement(llamadaSP);

            // Establecer los parámetros del procedimiento almacenado
            ejecutar.setInt(1, idProveedor); // Asume que idProducto es el ID que deseas actualizar
            ejecutar.setString(2, p.getNombre_proveedor());
            ejecutar.setString(3, p.getTelefono_proveedor());// Nuevo nombre del producto

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

    public int obtenerIdProveedor(String nombreProveedor) throws SQLException {
        int idProveedor = 0;
        String consulta = "SELECT ObtenerIdPorNombreProveedor(?) AS id_proveedor";

        try (PreparedStatement stmt = conectado.prepareStatement(consulta)) {
            stmt.setString(1, nombreProveedor);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    idProveedor = rs.getInt("id_proveedor");
                }
            }
        } catch (SQLException e) {
            // Manejo de excepciones
        }

        return idProveedor;
    }

}
