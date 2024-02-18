package DIU.Controlador;

import DIU.Modelo.Modelo_Gavetas;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
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
        modelo.addColumn("Código");
        modelo.addColumn("Color");
        modelo.addColumn("Tamaño");
        modelo.addColumn("Peso Máximo");
        modelo.addColumn("Es Propia");
        modelo.addColumn("Estado");

        try {
            String procedimiento = "{call ObtenerTodasLasGavetas()}";
            ejecutar = conectado.prepareCall(procedimiento);
            ResultSet resultado = ejecutar.executeQuery();

            while (resultado.next()) {
                Object[] fila = new Object[6];
                fila[0] = resultado.getString("codigo_GA");
                fila[1] = resultado.getString("color");
                fila[2] = resultado.getString("tamanio");
                fila[3] = resultado.getDouble("peso_maximo");
                fila[4] = resultado.getString("es_propia");
                fila[5] = resultado.getString("estado_descripcion");
                modelo.addRow(fila);
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al obtener todas las gavetas: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
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

    public void actualizarGaveta(Modelo_Gavetas gaveta) {
        try {
            String procedimiento = "{call ActualizarGaveta(?, ?, ?, ?, ?, ?)}";
            ejecutar = conectado.prepareCall(procedimiento);

            ejecutar.setString(1, gaveta.getCodigo());
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
    public int obtenerIdGavetaPorCodigo(String codigo) {
        int idGaveta = -1;
        try {
            String procedimiento = "{call ObtenerIdGavetaPorCodigo(?, ?)}";
            ejecutar = conectado.prepareCall(procedimiento);
            ejecutar.setString(1, codigo);
            ejecutar.registerOutParameter(2, java.sql.Types.INTEGER);
            ejecutar.execute();

            idGaveta = ejecutar.getInt(2);

        } catch (SQLException e) {
            System.out.println("Error al obtener el ID de la gaveta por código: " + e.getMessage());
        } finally {
            try {
                if (ejecutar != null) {
                    ejecutar.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }

        return idGaveta;
    }
    public int obtenerEstadoGavetaPorId(int idGaveta) {
        String consulta = "SELECT id_estado FROM gavetas WHERE id = ?";
        int estadoGaveta = -1;

        try (PreparedStatement ejecutar = conectado.prepareStatement(consulta)) {
            ejecutar.setInt(1, idGaveta);
            try (ResultSet resultado = ejecutar.executeQuery()) {
                if (resultado.next()) {
                    estadoGaveta = resultado.getInt("id_estado");
                }
            }
        } catch (SQLException e) {
            System.err.println("Error al obtener el estado de la gaveta: " + e.getMessage());
        }

        return estadoGaveta;
    }
}
