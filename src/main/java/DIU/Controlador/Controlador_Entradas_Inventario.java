/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DIU.Controlador;

import DIU.Modelo.Modelo_Entradas_Inventario;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author carlo
 */
public class Controlador_Entradas_Inventario {

    private Modelo_Entradas_Inventario proveedores;
    ConexionBDD conectar = new ConexionBDD();
    Connection conectado = conectar.conectar();
    PreparedStatement ejecutar;
    ResultSet resultado;
    
    public void AgregarEntradaInventario(Modelo_Entradas_Inventario entradaInv) {
        String SQL = "CALL AgregarEntradaInventario(?, ?, ?)"; // Asume correctos los nombres y parámetros del SP
        
       
        try (CallableStatement ejecutar = conectado.prepareCall(SQL)) {
            // Establece los parámetros del procedimiento almacenado
            ejecutar.setInt(1, entradaInv.getId_proveedor()); // ID del proveedor
            ejecutar.setInt(2, entradaInv.getId_producto()); // ID del producto
            ejecutar.setBigDecimal(3, entradaInv.getCantidadKg()); // Cantidad en Kg
            
            // Ejecuta el procedimiento almacenado
            int resultado = ejecutar.executeUpdate();
            
            // Verifica si se agregó la entrada al inventario con éxito
            if (resultado > 0) {
                JOptionPane.showMessageDialog(null, "ENTRADA AL INVENTARIO REGISTRADA CON ÉXITO");
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo registrar la entrada al inventario");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error al agregar la entrada al inventario: " + e.getMessage());
        }
    }

}
