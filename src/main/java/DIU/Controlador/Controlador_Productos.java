package DIU.Controlador;

import DIU.Modelo.Modelo_Productos;
import java.awt.Component;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Controlador_Productos {

    private Modelo_Productos productos;
    ConexionBDD conectar = new ConexionBDD();
    Connection conectado = conectar.conectar();
    PreparedStatement ejecutar;
    ResultSet resultado;

    //Transaccionabilidad
    public void AgregarProducto(Modelo_Productos p) {
        // Asume que 'conectado' es una instancia válida de Connection
        String SQL = "CALL AgregarProducto(?)";

        try (CallableStatement ejecutar = conectado.prepareCall(SQL)) {
            ejecutar.setString(1, p.getNombreProducto());
            int res = ejecutar.executeUpdate();

            if (res > 0) {
                System.out.println("Producto creado con éxito");
                // Si tu conexión requiere commits explícitos, descomenta la siguiente línea
                // conectado.commit();
            } else {
                System.out.println("No se agregó el Producto");
            }
        } catch (SQLException e) {
            System.out.println("Ha ocurrido un fallo: " + e.getMessage());
            e.printStackTrace(); // Para más detalle sobre el error
        }
    }

    public boolean repiteProducto(String nombreProd) {
        // Definición de la consulta utilizando parámetros para prevenir inyección SQL
        String consulta = "SELECT * FROM productos WHERE nombre_producto = ?";
        boolean existe = false; // Asume inicialmente que el producto no existe

        try (PreparedStatement ejecutar = conectado.prepareStatement(consulta)) {
            // Establece el valor del parámetro en la consulta
            ejecutar.setString(1, nombreProd);

            try (ResultSet resul = ejecutar.executeQuery()) {
                // Si encuentra un resultado, el producto ya existe
                if (resul.next()) {
                    JOptionPane.showMessageDialog(null, "NOMBRE YA EXISTE");
                    existe = true;
                }
            }
        } catch (SQLException e) {
            // Manejar el error de manera más apropiada según tu caso de uso
            JOptionPane.showMessageDialog(null, "Error al verificar la existencia del producto: " + e.getMessage());
        }

        return existe;
    }

    public void eliminarProducto(int idProducto) {
        //TRY Y CATCH
        try {
            //GENERAR LA CONSULTA SQL
            String consulta = "DELETE FROM proyecto1.productos WHERE  id_producto = ?";
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

    public int obtenerIdPorNombreProducto(String nombreProducto) throws SQLException {
        // Utiliza la función 'ObtenerIdPorNombreProducto' de MySQL
        String consulta = "SELECT ObtenerIdPorNombreProducto(?) AS idProducto";
        int id = 0;
        PreparedStatement ejecutar = null;
        ResultSet resul = null;

        try {
            ejecutar = conectado.prepareStatement(consulta);
            ejecutar.setString(1, nombreProducto); // Establece el nombre del producto en el parámetro de la consulta

            resul = ejecutar.executeQuery();
            if (resul.next()) {
                id = resul.getInt("idProducto");
                JOptionPane.showMessageDialog(null, "Producto encontrado: ");
            } else {
                JOptionPane.showMessageDialog(null, "Producto no encontrado.");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al buscar el producto: " + e.getMessage());
        } finally {
            // Es importante cerrar los recursos para evitar fugas de memoria
            if (resul != null) {
                try {
                    resul.close();
                } catch (SQLException e) {
                    /* Manejo del error */ }
            }
            if (ejecutar != null) {
                try {
                    ejecutar.close();
                } catch (SQLException e) {
                    /* Manejo del error */ }
            }
        }
        return id;
    }
}
