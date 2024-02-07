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

    ConexionBDD conectar = new ConexionBDD();
    Connection conectado = conectar.conectar();
    PreparedStatement ejecutar;
    ResultSet resultado;

    //Transaccionabilidad
    public void AgregarProducto(Modelo_Productos p) {
        try {
            String SQL = "CALL AgregarProducto('"+ p.getNombreProducto()+ "')";
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
        public void eliminarProducto (int idProducto){
        //TRY Y CATCH
        try {
            //GENERAR LA CONSULTA SQL
            String consulta = "DELETE FROM productos WHERE  id_producto = ?";
            //INICIAR SESIÓN A NIVEL DE MYSQL
            ejecutar = (PreparedStatement) conectado. prepareStatement(consulta);
            ejecutar.setInt(1, idProducto);
            int resul = ejecutar.executeUpdate();
            if (resul > 0){
                 Component rootPane = null;
                JOptionPane.showMessageDialog(rootPane, "ELIMINADO CON EXITO");
                ejecutar.close();
            }
            
        } catch (SQLException e){
             Component rootPane = null;
                JOptionPane.showMessageDialog(rootPane, "NO SE PUEDE ELIMANAR- EN USO");
        }
    } 
            public void actualizarProducto(Modelo_Productos  p,int idProducto){
         //TRY Y CATCH
        try {
            //GENERAR LA CONSULTA SQL
            String consulta = "UPDATE productos SET nombre_producto = ? WHERE  id_producto = ? ";
            //INICIAR SESIÓN A NIVEL DE MYSQL
            ejecutar = (PreparedStatement) conectado.prepareStatement(consulta);
            ejecutar.setString(1, p.getNombreProducto());
            ejecutar.setInt(2, p.getIdProducto());
            

            //EJECUTAR LA CONSULTA
            int resul = ejecutar.executeUpdate();
            if (resul > 0) {
                 Component rootPane = null;
                JOptionPane.showMessageDialog(rootPane, "NOMBRE DEL PRODUCTO ACTUALIZADO CON EXITO");
                ejecutar.close();
            }

        } catch (SQLException e) {
             Component rootPane = null;
                JOptionPane.showMessageDialog(rootPane, "NO SE PUDO ACTUALIZAR");
        }
    }
}
