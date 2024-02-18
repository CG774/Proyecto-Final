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
        int estadoGaveta = -1; // Usamos -1 como valor predeterminado para indicar que no se encontró o hay error.

        try (PreparedStatement ejecutar = conectado.prepareStatement(consulta)) {
            ejecutar.setInt(1, idGaveta);
            try (ResultSet resultado = ejecutar.executeQuery()) {
                if (resultado.next()) {
                    estadoGaveta = resultado.getInt("id_estado");
                }
            }
        } catch (SQLException e) {
            System.err.println("Error al obtener el estado de la gaveta: " + e.getMessage());
            // Aquí podrías manejar el error de manera más específica si es necesario.
        }

        return estadoGaveta;
    }

    public DefaultTableModel obtenerLasGavetasPorColor(String color) {
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Código");
        modelo.addColumn("Color");
        modelo.addColumn("Tamaño");
        modelo.addColumn("Peso Máximo");
        modelo.addColumn("Es Propia");
        modelo.addColumn("Estado");

        PreparedStatement pstmt = null;
        ResultSet resultado = null;

        try {
            // La consulta ahora solo se condiciona por el color
            String consulta = "SELECT g.codigo_GA, g.color, g.tamanio, g.peso_maximo, g.es_propia, e.descripcion AS estado_descripcion FROM gavetas g JOIN estados_gavetas e ON g.id_estado = e.id_estado WHERE 1=1";

            // Agregar condición para filtrar por color si se ha especificado
            if (color != null && !color.isEmpty()) {
                consulta += " AND g.color = ?";
            }

            pstmt = conectado.prepareStatement(consulta);

            // Establecer el color como parámetro si se ha especificado
            if (color != null && !color.isEmpty()) {
                pstmt.setString(1, color);
            }

            resultado = pstmt.executeQuery();

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
            JOptionPane.showMessageDialog(null, "Error al obtener las gavetas: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            try {
                if (resultado != null) {
                    resultado.close();
                }
                if (pstmt != null) {
                    pstmt.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }

        return modelo;
    }

    public void actualizarEstadoGavetasPorColor(String color) {
        PreparedStatement pstmt = null;

        try {
            String updateQuery = "UPDATE gavetas SET id_estado = 1 WHERE color = ?";
            pstmt = conectado.prepareStatement(updateQuery);
            pstmt.setString(1, color);

            int affectedRows = pstmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Se han actualizado " + affectedRows + " gavetas a DISPONIBLE", "Actualización exitosa", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al actualizar las gavetas: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            try {
                if (pstmt != null) {
                    pstmt.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

}
