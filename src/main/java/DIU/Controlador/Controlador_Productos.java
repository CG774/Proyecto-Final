package DIU.Controlador;

import DIU.Modelo.Modelo_Productos;
import java.awt.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
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
    public void AgregarProducto(Modelo_Productos p){
        try {
            String SQL = "CALL AgregarProducto('" + p.getNombreProducto() + "')";
            ejecutar = conectado.prepareCall(SQL);
            int res = ejecutar.executeUpdate();
            if(res > 0){
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
            String SQL = "CALL ObtenerProductos()";
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
}
