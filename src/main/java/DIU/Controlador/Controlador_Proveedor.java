/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DIU.Controlador;

import DIU.Modelo.Modelo_Proveedor;
import java.awt.Component;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author carlo
 */
public class Controlador_Proveedor {

    ConexionBDD conectar = new ConexionBDD();
    Connection conectado = conectar.conectar();
    PreparedStatement ejecutar;
    ResultSet resultado;

    public void AgregarProveedor(Modelo_Proveedor pr) {
        try {
            String SQL = "CALL AgregarProducto('"+ pr.getNombre_proveedor()+ pr.getTelefono()+
                    "')";
            ejecutar = conectado.prepareCall(SQL);
            int res = ejecutar.executeUpdate();
            if (res > 0) {
                System.out.println("Proveedor creado con éxito");

            } else {
                System.out.println("No se agregó el Proveedor");
            }
        } catch (Exception e) {
            System.out.println("Ha ocurrido un fallo, por favor compruebe que los datos de la conexión a la base de datos sean correctos.");
        }
    }
        public DefaultTableModel obtenerDatosProveedores() {
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("ID Producto");
        modelo.addColumn("Nombre");
        modelo.addColumn("Telefono");

        try {
            String SQL = "select * from proveedores";
            ejecutar = conectado.prepareStatement(SQL);
            resultado = ejecutar.executeQuery();

            while (resultado.next()) {
                Object[] fila = new Object[3];
                fila[0] = resultado.getInt("id_proveedor");
                fila[1] = resultado.getString("nombre_proveedor");
                fila[2] = resultado.getString("telefono");
                modelo.addRow(fila);
            }
        } catch (Exception e) {
            System.out.println("Error al obtener datos de productos: " + e.getMessage());
        }

        return modelo;
    }
        public int repiteProducto(String nombreProd) {

        String consulta = "select * from preveedores where nombre_proveedor = '" + nombreProd + "'";
        //INICIAR SESIÓN A NIVEL DE MYSQL
        int i = 0;
        try {
            ejecutar = (PreparedStatement) conectado.prepareStatement(consulta);

            ResultSet resul = ejecutar.executeQuery();
            if (resul.next()) {
                Component rootPane = null;
                JOptionPane.showMessageDialog(rootPane, "NOMBRE YA EXISTE");
                ejecutar.close();
                i = 1;
            } else {
                i = 2;
            }
        } catch (SQLException e) {
            Component rootPane = null;
            JOptionPane.showMessageDialog(rootPane, "NO EXISTE");
        }
        return i;

    }
public DefaultTableModel buscarProveedorPorNombre(String nombreProveedor) {
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("ID Proveedor");
        modelo.addColumn("Nombre");
        modelo.addColumn("Teléfono");

        try {
            String SQL = "CALL BuscarProveedorPorNombre('"+ nombreProveedor +"')";
            ejecutar = conectado.prepareCall(SQL);
            resultado = ejecutar.executeQuery();
            while (resultado.next()) {
                Object[] fila = new Object[3];
                fila[0] = resultado.getInt("id_proveedor");
                fila[1] = resultado.getString("nombre_proveedor");
                fila[2] = resultado.getString("telefono");
                modelo.addRow(fila);
            }
        } catch (Exception e) {
            System.out.println("Error al buscar proveedor por nombre: " + e.getMessage());
        } finally {
            
            try {
                if (resultado != null) {
                    resultado.close();
                }
                if (ejecutar != null) {
                    ejecutar.close();
                }
            } catch (Exception ex) {
                System.out.println("Error al cerrar recursos: " + ex.getMessage());
            }
        }

        return modelo;
    }

}
