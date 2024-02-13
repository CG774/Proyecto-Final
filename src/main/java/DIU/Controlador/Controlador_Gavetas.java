package DIU.Controlador;

import DIU.Modelo.Modelo_Gavetas;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;

public class Controlador_Gavetas {

    ConexionBDD conectar = new ConexionBDD();
    Connection conectado = conectar.conectar();
    CallableStatement ejecutar;

    public void agregarGaveta(Modelo_Gavetas gaveta) {
        try {
            String procedimiento = "{call AgregarGaveta(?, ?, ?, ?, ?)}";
            ejecutar = conectado.prepareCall(procedimiento);
            ejecutar.setString(1, gaveta.getColor());
            ejecutar.setString(2, gaveta.getTamanio());
            ejecutar.setDouble(3, gaveta.getPesoMaximo());
            ejecutar.setString(4, gaveta.getEsPropia());

            // Obtener el ID del estado correctamente
            int idEstado = gaveta.getIdEstado().getIdEstado();
            ejecutar.setInt(5, idEstado);

            ejecutar.executeUpdate();

            System.out.println("Gaveta agregada exitosamente.");

        } catch (SQLException e) {
            System.out.println("Error al agregar la gaveta: " + e.getMessage());
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

    public DefaultTableModel obtenerTodasLasGavetas() {
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("ID");
        modelo.addColumn("Color");
        modelo.addColumn("Tamaño");
        modelo.addColumn("Peso Máximo");
        modelo.addColumn("Es Propia");
        modelo.addColumn("Estado");

        String procedimiento = "{CALL ObtenerTodasLasGavetas()}"; // Asegúrate de usar la sintaxis correcta para llamar al SP

        try (Connection conn = conectado; // Asume que 'conectado' es tu objeto Connection
                 CallableStatement ejecutar = conn.prepareCall(procedimiento); ResultSet resultado = ejecutar.executeQuery()) {

            while (resultado.next()) {
                Object[] fila = new Object[6]; // Ajusta el número de columnas según sea necesario
                fila[0] = resultado.getInt("id");
                fila[1] = resultado.getString("color");
                fila[2] = resultado.getString("tamanio");
                fila[3] = resultado.getDouble("peso_maximo");
                fila[4] = resultado.getString("es_propia");
                fila[5] = resultado.getString("estado_descripcion"); // Asegúrate de que este nombre coincida con el alias en tu SP
                modelo.addRow(fila);
            }

        } catch (SQLException e) {
            System.out.println("Error al obtener todas las gavetas: " + e.getMessage());
        }

        return modelo;
    }

    public void actualizarGaveta(Modelo_Gavetas gaveta) {
        try {
            String procedimiento = "{call ActualizarGaveta(?, ?, ?, ?, ?, ?)}";
            ejecutar = conectado.prepareCall(procedimiento);

            ejecutar.setInt(1, gaveta.getId());
            ejecutar.setString(2, gaveta.getColor());
            ejecutar.setString(3, gaveta.getTamanio());
            ejecutar.setDouble(4, gaveta.getPesoMaximo());
            ejecutar.setString(5, gaveta.getEsPropia());
            int idEstado = gaveta.getIdEstado().getIdEstado();
            ejecutar.setInt(6, idEstado);

            ejecutar.executeUpdate();

            System.out.println("Gaveta actualizada exitosamente.");

        } catch (SQLException e) {
            System.out.println("Error al actualizar la gaveta: " + e.getMessage());
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
