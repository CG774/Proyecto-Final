package DIU.Controlador;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Controlador_Envios_General {

    ConexionBDD conectar = new ConexionBDD();
    Connection conectado = conectar.conectar();
    CallableStatement ejecutar;

    public void agregarEnvioGeneral(int idSupermercado) {
        CallableStatement ejecutar = null;
        try {
            String procedimiento = "{call AgregarEnvioGeneral(?)}";
            ejecutar = conectado.prepareCall(procedimiento);
            ejecutar.setInt(1, idSupermercado);

            ejecutar.executeUpdate();

            JOptionPane.showMessageDialog(null, "Envío general agregado exitosamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al agregar el envío general: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
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

    public DefaultTableModel obtenerEnviosGenerales() {
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Codigo Envío General");
        modelo.addColumn("Supermercado");
        modelo.addColumn("Fecha");

        try {
            String procedimiento = "SELECT * FROM vista_envios_generales;";
            ejecutar = conectado.prepareCall(procedimiento);
            ResultSet resultado = ejecutar.executeQuery();

            while (resultado.next()) {
                Object[] fila = new Object[3];
                fila[0] = resultado.getString("codigoEnvioG");
                fila[1] = resultado.getString("nombre_supermercado");
                fila[2] = resultado.getDate("fecha");
                modelo.addRow(fila);
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al obtener los datos: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            try {
                if (ejecutar != null) {
                    ejecutar.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }

        return modelo;
    }

    public int obtenerIdSupermercadoPorNombre(String nombreSupermercado) {
        try {
            String procedimiento = "{call ObtenerIdSupermercadoPorNombre(?, ?)}";
            ejecutar = conectado.prepareCall(procedimiento);
            ejecutar.setString(1, nombreSupermercado);
            ejecutar.registerOutParameter(2, java.sql.Types.INTEGER);

            ejecutar.execute();

            return ejecutar.getInt(2);

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al obtener el ID del supermercado por nombre: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            return -1;
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

}
