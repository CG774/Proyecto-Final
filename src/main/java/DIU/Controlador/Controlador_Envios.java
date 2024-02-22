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
import java.sql.Timestamp;
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
        modelo.addColumn("NRO");
        modelo.addColumn("Código Envío");
        modelo.addColumn("Nombre Producto");
        modelo.addColumn("Código Gaveta");
        modelo.addColumn("Cantidad (kg)");
        modelo.addColumn("Nombre Supermercado");

        PreparedStatement ejecutar = null;
        ResultSet resultado = null;

        try {
            String consulta = "SELECT * FROM vista_envios";
            ejecutar = conectado.prepareStatement(consulta);
            resultado = ejecutar.executeQuery();

            int cont = 0;
            while (resultado.next()) {
                cont++;
                Object[] fila = new Object[6];
                fila[0] = cont;
                fila[1] = resultado.getString("codigoEnvioG");
                fila[2] = resultado.getString("nombre_producto");
                fila[3] = resultado.getString("codigo_GA");
                fila[4] = resultado.getBigDecimal("cantidad_en_kg");
                fila[5] = resultado.getString("nombre_supermercado");
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

    public DefaultTableModel obtenerEnviosREP() {
        DefaultTableModel modelo = new DefaultTableModel();

        modelo.addColumn("Código Envío");
        modelo.addColumn("Nombre Producto");
        modelo.addColumn("Código Gaveta");
        modelo.addColumn("Cantidad (kg)");
        modelo.addColumn("ID Envío General");
        modelo.addColumn("Nombre Supermercado");
        modelo.addColumn("Número Gavetas");
        modelo.addColumn("Fecha");

        try {
            String query = "SELECT codigoEnvioG, nombre_producto, codigo_GA, cantidad_en_kg, id_envio_general, nombre_supermercado, numero_gavetas, fecha FROM vista_enviosrep";
            try (CallableStatement statement = conectado.prepareCall(query)) {
                try (ResultSet resultSet = statement.executeQuery()) {
                    while (resultSet.next()) {
                        String codigoEnvioG = resultSet.getString("codigoEnvioG");
                        String nombreProducto = resultSet.getString("nombre_producto");
                        String codigoGA = resultSet.getString("codigo_GA");
                        double cantidadKg = resultSet.getDouble("cantidad_en_kg");
                        int idEnvioGeneral = resultSet.getInt("id_envio_general");
                        String nombreSupermercado = resultSet.getString("nombre_supermercado");
                        long numeroGavetas = resultSet.getLong("numero_gavetas");
                        Timestamp fecha = resultSet.getTimestamp("fecha");

                        modelo.addRow(new Object[]{codigoEnvioG, nombreProducto, codigoGA, cantidadKg, idEnvioGeneral, nombreSupermercado, numeroGavetas, fecha});
                    }
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al obtener los envíos.", "Error", JOptionPane.ERROR_MESSAGE);
        }

        return modelo;
    }

    public DefaultTableModel filtrarEnviosPorFecha(String seleccion) {
        DefaultTableModel modelo = new DefaultTableModel();

        modelo.addColumn("Código Envío");
        modelo.addColumn("Nombre Producto");
        modelo.addColumn("Código Gaveta");
        modelo.addColumn("Cantidad (kg)");
        modelo.addColumn("ID Envío General");
        modelo.addColumn("Nombre Supermercado");
        modelo.addColumn("Número Gavetas");
        modelo.addColumn("Fecha");

        try (CallableStatement statement = conectado.prepareCall("{CALL FiltrarEnviosPorFecha(?)}")) {
            statement.setString(1, seleccion);

            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    String codigoEnvioG = resultSet.getString("codigoEnvioG");
                    String nombreProducto = resultSet.getString("nombre_producto");
                    String codigoGA = resultSet.getString("codigo_GA");
                    double cantidadKg = resultSet.getDouble("cantidad_en_kg");
                    int idEnvioGeneral = resultSet.getInt("id_envio_general");
                    String nombreSupermercado = resultSet.getString("nombre_supermercado");
                    long numeroGavetas = resultSet.getLong("numero_gavetas");
                    Timestamp fecha = resultSet.getTimestamp("fecha");

                    modelo.addRow(new Object[]{codigoEnvioG, nombreProducto, codigoGA, cantidadKg, idEnvioGeneral, nombreSupermercado, numeroGavetas, fecha});
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al filtrar los envíos por fecha.", "Error", JOptionPane.ERROR_MESSAGE);
        }

        return modelo;
    }

}
