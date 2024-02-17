/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package DIU;

import DIU.Controlador.ConexionBDD;
import DIU.Controlador.Controlador_Entradas_Inventario;
import DIU.Controlador.Controlador_Proveedor;
import DIU.Modelo.Modelo_Entradas_Inventario;
import java.awt.Color;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author USER-HP
 */
public class Agregar_Entradas_Inventario extends javax.swing.JInternalFrame {

    /**
     * Creates new form Inventario
     */
    public Agregar_Entradas_Inventario() {
        initComponents();
        mostrarTabla("");
    }

    ConexionBDD conexion = new ConexionBDD();
    //OBJETO 
    Connection conectado = (Connection) conexion.conectar();
    //DOWNCASTING
    PreparedStatement sesion;
    ResultSet res;
    Statement stmt;

    public void mostrarTabla(String fecha) {
        // Inicializa el modelo para la tabla
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("ID");
        modelo.addColumn("ID_PROVEEDOR");
        modelo.addColumn("ID_PRODUCTO");
        modelo.addColumn("CANTIDAD_KG");
        modelo.addColumn("FECHA_ENTRADA");

        // Obtiene la conexión a la base de datos
        ConexionBDD con = new ConexionBDD();
        Connection conexion = con.conectar();

        PreparedStatement ps = null;
        ResultSet rs = null;

        String consulta;

        try {
            // Decide la consulta a ejecutar basada en si el nombre es proporcionado
            if ("".equals(fecha)) {
                consulta = "SELECT * FROM vista_entradas_inventario";
                ps = conexion.prepareStatement(consulta);
            } else {
                consulta = "SELECT * FROM vista_entradas_inventario WHERE fechaEntrada > ?";
                ps = conexion.prepareStatement(consulta);
                ps.setString(1, fecha);

            }

            // Ejecuta la consulta
            rs = ps.executeQuery();

            // Procesa los resultados
            while (rs.next()) {
                Object[] fila = new Object[5]; // Crea un array de objetos para la fila
                fila[0] = rs.getInt("EntradaID");
                fila[1] = rs.getString("Proveedor");
                fila[2] = rs.getString("Producto");
                fila[3] = rs.getDouble("CantidadKg");
                fila[4] = rs.getDate("FechaEntrada");
                modelo.addRow(fila); // Añade la fila al modelo de la tabla
            }

            // Establece el modelo en la JTable (Asume que jtbProducto es tu JTable)
            tblEntradasI.setModel(modelo);

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al obtener datos de productos: " + e.getMessage());
        } finally {
            // Cierra los recursos
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (conexion != null) {
                    conexion.close();
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error al cerrar conexiones: " + e.getMessage());
            }
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        tblEntradasI = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        txtCantidad = new javax.swing.JTextField();
        btnAgregarENG = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        txtProveedor = new javax.swing.JTextField();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("ENTRADAS_INVENTARIO");

        tblEntradasI.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        tblEntradasI.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Código de entrada", "Proveedor", "Producto", "Cantidad", "Fecha_entrada"
            }
        ));
        jScrollPane2.setViewportView(tblEntradasI);

        jLabel4.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel4.setText("Cantidad:");

        txtCantidad.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        txtCantidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCantidadActionPerformed(evt);
            }
        });
        txtCantidad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCantidadKeyTyped(evt);
            }
        });

        btnAgregarENG.setBackground(new java.awt.Color(86, 84, 15));
        btnAgregarENG.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btnAgregarENG.setForeground(new java.awt.Color(255, 255, 255));
        btnAgregarENG.setIcon(new javax.swing.ImageIcon("C:\\Users\\carlo\\Documents\\IST 17J\\Semestre 3\\Programacion visual\\Proyecto-Final\\src\\main\\resource\\Imagenes\\Agregar.png")); // NOI18N
        btnAgregarENG.setText("Agregar");
        btnAgregarENG.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnAgregarENG.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarENGActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel2.setText("Nombre de proveedor:");

        txtProveedor.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        txtProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtProveedorActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnAgregarENG, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 871, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(txtProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(38, 38, 38))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(btnAgregarENG, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(33, 33, 33)
                .addComponent(jScrollPane2)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtCantidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCantidadActionPerformed

    }//GEN-LAST:event_txtCantidadActionPerformed

    private void btnAgregarENGActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarENGActionPerformed
        if (txtCantidad.getText().isEmpty() && txtProveedor.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor, complete todos los campos.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        try {
           

            if (validarDecimal(txtCantidad.getText())) { // Asumiendo que este método retorna un booleano
                BigDecimal numeroDecimal = new BigDecimal(txtCantidad.getText());
                
                Controlador_Proveedor controlProveedor = new Controlador_Proveedor();

                int proveedor = controlProveedor.obtenerIdProveedor(txtProveedor.getText());
                int producto = controlProveedor.obtenerProductodelProveedor(txtProveedor.getText());

                Modelo_Entradas_Inventario modelEntrada = new Modelo_Entradas_Inventario(0, proveedor, producto, numeroDecimal);
                Controlador_Entradas_Inventario controlEntrada = new Controlador_Entradas_Inventario();
                controlEntrada.AgregarEntradaInventario(modelEntrada);
            } else {
                // Manejar el caso donde la cantidad no es un decimal válido
                JOptionPane.showMessageDialog(null, "La cantidad proporcionada no es un número decimal válido.");
            }
            limpiar();
        } catch (SQLException ex) {
          
        }
        limpiar();
        mostrarTabla("");

    }//GEN-LAST:event_btnAgregarENGActionPerformed

    private void txtCantidadKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCantidadKeyTyped

    }//GEN-LAST:event_txtCantidadKeyTyped

    private void txtProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtProveedorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtProveedorActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregarENG;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblEntradasI;
    private javax.swing.JTextField txtCantidad;
    private javax.swing.JTextField txtProveedor;
    // End of variables declaration//GEN-END:variables

    private boolean validarDecimal(String decimal) {
        String regex = "^-?\\d+(\\.\\d+)?$";
        Pattern pat = Pattern.compile(regex);

        Matcher mat = pat.matcher(decimal);
        if (mat.matches()) { 
            txtCantidad.setForeground(Color.black);
            return true;
        } else {
            txtCantidad.setForeground(Color.red);
            return false; 
        }
    }

    private void limpiar() {
        txtCantidad.setText("");
        txtProveedor.setText("");
    }
}
