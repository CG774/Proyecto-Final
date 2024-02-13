/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DIU.Controlador;

import DIU.Modelo.Modelo_Entradas_Inventario;
import DIU.Modelo.Modelo_Envios;
import java.awt.Component;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Controlador_Envios {

    private Modelo_Entradas_Inventario proveedores;
    ConexionBDD conectar = new ConexionBDD();
    Connection conectado = conectar.conectar();
    PreparedStatement ejecutar;
    ResultSet resultado;

    public void AgregarEnvio(Modelo_Envios envio) {
        String SQL = "CALL AgregarEnvio(?, ?, ?, ?)"; // Asume correctos los nombres y parámetros del SP

        try (CallableStatement ejecutar = conectado.prepareCall(SQL)) {
            // Establece los parámetros del procedimiento almacenado
            ejecutar.setInt(1, envio.getId_producto());
            ejecutar.setInt(2, envio.getId_gaveta());// ID del producto
            ejecutar.setBigDecimal(3, envio.getCantidad_kg());
            ejecutar.setInt(4, envio.getId_envio_general());

            // Ejecuta el procedimiento almacenado
            int resultado = ejecutar.executeUpdate();

            // Verifica si se agregó la entrada al inventario con éxito
            if (resultado > 0) {
                JOptionPane.showMessageDialog(null, "ENVIO REGISTRADO CON ÉXITO");
            } else {
                JOptionPane.showMessageDialog(null, "NO SE PUDO REGISTRARN");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error al agregar la entrada el envio " + e.getMessage());
        }
    }

    public int obtenerIdUltimoEnvioGeneral() throws SQLException {
        String consulta = "SELECT MAX(id_envio_general) AS MaxID FROM envios_generales";
        //INICIAR SESIÓN A NIVEL DE MYSQL
        int id = 0;
        try {
            ejecutar = (PreparedStatement) conectado.prepareStatement(consulta);

            ResultSet resul = ejecutar.executeQuery();
            if (resul.next()) {
                id = resul.getInt(1);
                ejecutar.close();
            }
        } catch (SQLException e) {
        }
        return id;
    }

    public boolean comprobarEstadoGaveta(int idGaveta) {
        // Definición de la consulta utilizando parámetros para prevenir inyección SQL
        String consulta = "SELECT id FROM gavetas WHERE id_estado = 1 AND id = ?";

        try (PreparedStatement ejecutar = conectado.prepareStatement(consulta)) {
            // Establece el valor del parámetro en la consulta
            ejecutar.setInt(1, idGaveta);

            try (ResultSet resul = ejecutar.executeQuery()) {
                // Si encuentra un resultado, la gaveta está disponible
                if (resul.next()) {
                    return true;
                }
            }
        } catch (SQLException e) {
            // Considera manejar este error de manera más apropiada según tu caso de uso
            JOptionPane.showMessageDialog(null, "Error al comprobar el estado de la gaveta: " + e.getMessage());
        }

        // Retorna false si la gaveta no está disponible o si ocurre un error
        return false;
    }

    public boolean comprobarIdExiste(int idGaveta) {
        // Definición de la consulta utilizando un parámetro
        String consulta = "SELECT id FROM gavetas WHERE id = ?";

        try (PreparedStatement ejecutar = conectado.prepareStatement(consulta)) {
            // Establece el valor del parámetro en la consulta
            ejecutar.setInt(1, idGaveta);

            try (ResultSet resul = ejecutar.executeQuery()) {
                // Retorna true si el ID existe
                return resul.next();
            }
        } catch (SQLException e) {
            // Log del error. Considera usar un logger o manejar el error según tu aplicación lo requiera
            JOptionPane.showMessageDialog(null, "Error al comprobar existencia del ID de la gaveta: " + e.getMessage());
        }

        // Retorna false si el ID no existe o si ocurre un error
        return false;
    }

}
