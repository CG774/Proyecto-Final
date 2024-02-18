/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DIU.Controlador;

import DIU.Modelo.Modelo_Entradas_Inventario;
import DIU.Modelo.Modelo_Envios;
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

    public void agregarEnvio(Modelo_Envios envio) {
        CallableStatement ejecutar = null;
        try {
            String procedimiento = "{call AgregarEnvio(?, ?, ?, ?)}";
            ejecutar = conectado.prepareCall(procedimiento);
            ejecutar.setInt(1, envio.getId_producto());
            ejecutar.setInt(2, envio.getId_gaveta());
            ejecutar.setBigDecimal(3, envio.getCantidad_kg());
            ejecutar.setInt(4, envio.getId_envio_general());

            ejecutar.executeUpdate();

            JOptionPane.showMessageDialog(null, "Envío agregado exitosamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al agregar el envío: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            try {
                if (ejecutar != null) {
                    ejecutar.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
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

    public DefaultTableModel obtenerDatosVistaEnvio() {
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("ID Envío");
        modelo.addColumn("Nombre Producto");
        modelo.addColumn("Código Gaveta"); // Cambiado de "ID Gaveta" a "Código Gaveta"
        modelo.addColumn("Cantidad (kg)");
        modelo.addColumn("Nombre Supermercado");
        modelo.addColumn("Código Envío General");

        PreparedStatement ejecutar = null;
        ResultSet resultado = null;

        try {
            String consulta = "SELECT * FROM vista_envios"; // Asumiendo que vista_envios ya está definida en tu DB
            ejecutar = conectado.prepareStatement(consulta);
            resultado = ejecutar.executeQuery();

            while (resultado.next()) {
                Object[] fila = new Object[6];
                fila[0] = resultado.getInt("id_envio");
                fila[1] = resultado.getString("nombre_producto"); // Corregido para usar "nombre_producto"
                fila[2] = resultado.getString("codigo_gaveta"); // Corregido para usar "codigo_gaveta" y obtener String
                fila[3] = resultado.getBigDecimal("cantidad_en_kg"); // Usar getBigDecimal para "cantidad_en_kg"
                fila[4] = resultado.getString("nombre_supermercado"); // Corregido para usar "nombre_supermercado"
                fila[5] = resultado.getString("codigoEnvioG"); // Confirmado, usar "codigoEnvioG"
                modelo.addRow(fila);
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al obtener datos de vista_envios: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            try {
                if (resultado != null) {
                    resultado.close();
                }
                if (ejecutar != null) {
                    ejecutar.close();
                }
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
