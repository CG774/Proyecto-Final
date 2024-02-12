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
        String SQL = "CALL AgregarProveedor(?, ?, ?)"; // Asume que el SP espera tres parámetros

        try (CallableStatement ejecutar = conectado.prepareCall(SQL)) {
            // Establece los parámetros del procedimiento almacenado
            ejecutar.setString(1, proveedor.getNombre_proveedor()); // Primer parámetro: nombre del proveedor
            ejecutar.setString(2, proveedor.getTelefono_proveedor()); // Segundo parámetro: teléfono del proveedor
            ejecutar.setInt(3, proveedor.getId_producto()); // Tercer parámetro: ID del producto

            // Ejecuta el procedimiento almacenado
            int resultado = ejecutar.executeUpdate();

            // Verifica si se agregó el proveedor con éxito
            if (resultado > 0) {
                JOptionPane.showMessageDialog(null, "PROVEEDOR REGISTRADO CON ÉXITO");
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo registrar el proveedor");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error al agregar el proveedor: " + e.getMessage());
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
         String consulta = "select * from proveedores where nombre_proveedor = '" + nombreProveedor+ "'";
            //INICIAR SESIÓN A NIVEL DE MYSQL
            int id = 0;
            try{
            ejecutar = (PreparedStatement) conectado. prepareStatement(consulta);

            ResultSet resul = ejecutar.executeQuery();
            if (resul.next()){
                id = resul.getInt(1);
                Component rootPane = null;
               JOptionPane.showMessageDialog(rootPane, "Proveedor ENCONTRADO");
                ejecutar.close();
            }
            }catch (SQLException e){
            Component rootPane = null;
                JOptionPane.showMessageDialog(rootPane, "Proveedor NO EXISTE!");
        }
            return id;
    }

    public int obtenerProductodelProveedor(String  nombreProveedor) throws SQLException{
        String consulta = "select * from proveedores where nombre_proveedor = '" + nombreProveedor+ "'";
            //INICIAR SESIÓN A NIVEL DE MYSQL
            int id = 0;
            try{
            ejecutar = (PreparedStatement) conectado. prepareStatement(consulta);

            ResultSet resul = ejecutar.executeQuery();
            if (resul.next()){
                id = resul.getInt(4);
                Component rootPane = null;
                JOptionPane.showMessageDialog(rootPane, "proveedor ENCONTRADO");
                ejecutar.close();
            }
            }catch (SQLException e){
            Component rootPane = null;
                JOptionPane.showMessageDialog(rootPane, "proveedor NO EXISTE");
        }
            return id;
    }

}
