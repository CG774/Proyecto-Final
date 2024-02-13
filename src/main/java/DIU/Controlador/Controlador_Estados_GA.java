package DIU.Controlador;

import DIU.Modelo.Modelo_Estados_GA;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Controlador_Estados_GA {

    ConexionBDD conectar = new ConexionBDD();
    Connection conectado = conectar.conectar();
    CallableStatement ejecutar;

    public int ObtenerIdEstadoPorDescripcion(Modelo_Estados_GA estados) {
        int idEstado = 0;
        try {
            String procedimiento = "{call ObtenerIdEstadoPorDescripcion(?, ?)}";
            ejecutar = conectado.prepareCall(procedimiento);
            ejecutar.setString(1, estados.getDescripcion());
            ejecutar.registerOutParameter(2, java.sql.Types.INTEGER);
            ejecutar.executeUpdate();

            idEstado = ejecutar.getInt(2);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al obtener el ID del estado por descripción: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            try {
                if (ejecutar != null) {
                    ejecutar.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }

        return idEstado;
    }
}

