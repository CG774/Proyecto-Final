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
import javax.swing.table.DefaultTableModel;

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
    public DefaultTableModel obtenerDatosVistaEnvio() {
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("ID Envío");
        modelo.addColumn("Nombre Producto");
        modelo.addColumn("ID Gaveta");
        modelo.addColumn("Número Gavetas");
        modelo.addColumn("Cantidad (kg)");
        modelo.addColumn("Nombre Supermercado");
        modelo.addColumn("Fecha de envío");

        try {
            String procedimiento = "{call ObtenerDatosVistaEnvio()}";
            ejecutar = conectado.prepareCall(procedimiento);
            ResultSet resultado = ejecutar.executeQuery();

            while (resultado.next()) {
                Object[] fila = new Object[7];
                fila[0] = resultado.getInt("id_envio");
                fila[1] = resultado.getString("nombre_producto");
                fila[2] = resultado.getInt("id_gaveta");
                fila[3] = resultado.getInt("numero_gavetas");
                fila[4] = resultado.getDouble("cantidad_en_kg");
                fila[5] = resultado.getString("nombre_supermercado");
                fila[6] = resultado.getDate("fecha");
                modelo.addRow(fila);
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al obtener datos de vista_envios: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            try {
                if (ejecutar != null) ejecutar.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }

        return modelo;
    }
    public DefaultTableModel filtrarEnviosPorFecha(String seleccion) {
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("ID Envío");
        modelo.addColumn("Nombre Producto");
        modelo.addColumn("ID Gaveta");
        modelo.addColumn("Número Gavetas");
        modelo.addColumn("Cantidad (kg)");
        modelo.addColumn("Nombre Supermercado");
        modelo.addColumn("Fecha de envío");

        // Llama al SP para filtrar los envíos según la selección
        try (CallableStatement cs = conectado.prepareCall("{call FiltrarEnviosPorFecha(?)}")) {
            cs.setString(1, seleccion);
            ResultSet resultado = cs.executeQuery();

            while (resultado.next()) {
                Object[] fila = new Object[7];
                fila[0] = resultado.getInt("id_envio");
                fila[1] = resultado.getString("nombre_producto");
                fila[2] = resultado.getInt("id_gaveta");
                fila[3] = resultado.getInt("numero_gavetas");
                fila[4] = resultado.getDouble("cantidad_en_kg");
                fila[5] = resultado.getString("nombre_supermercado");
                fila[6] = resultado.getDate("fecha");
                modelo.addRow(fila);
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al filtrar envíos por fecha: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

        return modelo;
    }
}
