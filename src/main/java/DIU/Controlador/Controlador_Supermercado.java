package DIU.Controlador;

import DIU.Modelo.Modelo_Supermercado;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Controlador_Supermercado {
    ConexionBDD conectar = new ConexionBDD();
    Connection conectado = conectar.conectar();
    PreparedStatement ejecutar;

    public void agregarSupermercado(Modelo_Supermercado supermerca) {
        try {
            String procedimiento = "{call AgregarSupermercado(?, ?)}";
            ejecutar = conectado.prepareCall(procedimiento);
            ejecutar.setString(1, supermerca.getNombre());
            ejecutar.setString(2, supermerca.getTelefono());

            ejecutar.executeUpdate();

            JOptionPane.showMessageDialog(null, "Supermercado agregado exitosamente.");

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al agregar el supermercado:\n" + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        } finally {
            try {
                if (ejecutar != null) ejecutar.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    public DefaultTableModel obtenerSupermercados() {
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("ID Supermercado");
        modelo.addColumn("Nombre");
        modelo.addColumn("Teléfono");

        try {
            String procedimiento = "{call ObtenerSupermercados()}";
            ejecutar = conectado.prepareCall(procedimiento);
            ResultSet resultado = ejecutar.executeQuery();

            while (resultado.next()) {
                Object[] fila = new Object[3];
                fila[0] = resultado.getInt("id_supermercado");
                fila[1] = resultado.getString("nombre");
                fila[2] = resultado.getString("telefono");
                modelo.addRow(fila);
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al obtener todos los supermercados:\n" + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        } finally {
            try {
                if (ejecutar != null) ejecutar.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }

        return modelo;
    }

    public void actualizarSupermercado(Modelo_Supermercado supermercado) {
        try {
            String procedimiento = "{call ActualizarSupermercado(?, ?, ?)}";
            ejecutar = conectado.prepareCall(procedimiento);
            ejecutar.setInt(1, supermercado.getId_supermercado());
            ejecutar.setString(2, supermercado.getNombre());
            ejecutar.setString(3, supermercado.getTelefono());

            ejecutar.executeUpdate();

            JOptionPane.showMessageDialog(null, "Supermercado actualizado exitosamente.");

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al actualizar el supermercado:\n" + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        } finally {
            try {
                if (ejecutar != null) ejecutar.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
}
