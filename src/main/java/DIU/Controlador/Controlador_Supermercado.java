package DIU.Controlador;

import DIU.Modelo.Modelo_Supermercado;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Controlador_Supermercado {

    ConexionBDD conectar = new ConexionBDD();
    Connection conectado = conectar.conectar();
    PreparedStatement ejecutar;

    public void agregarSupermercado(Modelo_Supermercado supermercado) {
        try {
            String spAgregarSupermercado = "CALL AgregarSupermercado(?, ?, ?)";
            CallableStatement cst = conectado.prepareCall(spAgregarSupermercado);
            cst.setString(1, supermercado.getNombre());
            cst.setString(2, supermercado.getTelefono());
            cst.setString(3, supermercado.getEncargado());

            cst.execute();
            JOptionPane.showMessageDialog(null, "Supermercado agregado correctamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al agregar el supermercado: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public DefaultTableModel obtenerSupermercados() {
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Código Supermercado");
        modelo.addColumn("Nombre");
        modelo.addColumn("Teléfono");
        modelo.addColumn("Encargado");

        try {
            String procedimiento = "select codigo_Super , nombre , telefono , encargado from supermercados";
            ejecutar = conectado.prepareCall(procedimiento);
            ResultSet resultado = ejecutar.executeQuery();

            while (resultado.next()) {
                Object[] fila = new Object[4];
                fila[0] = resultado.getString("codigo_Super");
                fila[1] = resultado.getString("nombre");
                fila[2] = resultado.getString("telefono");
                fila[3] = resultado.getString("encargado");
                modelo.addRow(fila);
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al obtener todos los supermercados:\n" + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
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

    public void actualizarSupermercado(Modelo_Supermercado supermercado) {
        try {
            String spActualizarSupermercado = "CALL ActualizarSupermercado(?, ?, ?, ?)";
            CallableStatement cst = conectado.prepareCall(spActualizarSupermercado);
            cst.setInt(1, supermercado.getId_supermercado()); //
            cst.setString(2, supermercado.getNombre());
            cst.setString(3, supermercado.getTelefono());
            cst.setString(4, supermercado.getEncargado());

            cst.execute();
            JOptionPane.showMessageDialog(null, "Supermecadp actualizado correctamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al actualizar el Supermercado: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public int obtenerIdSupermercadoPorCodigo(String codigoSupermercado) {
        try {
            String spObtenerIdSupermercado = "CALL ObtenerIdSupermercadoPorCodigo(?, ?)";
            CallableStatement cst = conectado.prepareCall(spObtenerIdSupermercado);
            cst.setString(1, codigoSupermercado);
            cst.registerOutParameter(2, java.sql.Types.INTEGER);
            cst.execute();
            return cst.getInt(2);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al obtener ID del supermercado: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            return -1;
        }
    }

    public List<String> obtenerNombresSupermercados() {
        List<String> nombres = new ArrayList<>();
        try {
            // Usando la conexión ya establecida
            String sql = "SELECT nombre FROM supermercados";
            ejecutar = conectado.prepareStatement(sql);
            ResultSet rs = ejecutar.executeQuery();

            while (rs.next()) {
                nombres.add(rs.getString("nombre"));
            }

            rs.close();
            ejecutar.close();
        } catch (SQLException e) {
            e.printStackTrace(); // Considera un mejor manejo de excepciones según tu caso
        }
        return nombres;
    }

    public int obtenerIdSupermercadoPorNombre(String nombreSupermercado) {
        int idSupermercado = -1; // Valor predeterminado en caso de error o no encontrado
        CallableStatement cst = null;
        try {
            String spObtenerIdSupermercado = "CALL ObtenerIdSupermercadoPorNombre(?, ?)";
            cst = conectado.prepareCall(spObtenerIdSupermercado);
            cst.setString(1, nombreSupermercado);
            cst.registerOutParameter(2, java.sql.Types.INTEGER);

            cst.execute();

            idSupermercado = cst.getInt(2);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al obtener ID del supermercado: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            if (cst != null) {
                try {
                    cst.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return idSupermercado;
    }

}
