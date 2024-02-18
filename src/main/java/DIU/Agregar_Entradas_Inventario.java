/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package DIU;

import DIU.Controlador.ConexionBDD;
import DIU.Controlador.Controlador_Entradas_Inventario;
import DIU.Controlador.Controlador_Productos;
import DIU.Controlador.Controlador_Proveedor;
import DIU.Modelo.Modelo_Entradas_Inventario;
import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
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
        cargarDatos();
    }

    public void cargarDatos() {
        DefaultTableModel modelo = (DefaultTableModel) tblEntradasI.getModel();
        Controlador_Entradas_Inventario conEntrada = new Controlador_Entradas_Inventario();
        modelo = conEntrada.obtenerEntradas();
        tblEntradasI.setModel(modelo);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblEntradasI = new javax.swing.JTable();
        btnAgregarENG = new javax.swing.JButton();
        txtProveedor = new javax.swing.JTextField();
        jcProductos = new javax.swing.JComboBox<>();
        txtCantidad = new javax.swing.JTextField();

        setBackground(new java.awt.Color(255, 246, 137));
        setClosable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("ENTRADAS_INVENTARIO");

        jPanel1.setBackground(new java.awt.Color(255, 246, 137));

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel2.setText("Código de proveedor:");

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel4.setText("Cantidad:");

        tblEntradasI.setBackground(new java.awt.Color(86, 84, 15));
        tblEntradasI.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        tblEntradasI.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        tblEntradasI.setForeground(new java.awt.Color(255, 255, 255));
        tblEntradasI.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Código de entrada", "Proveedor", "Producto", "Cantidad", "Fecha de entrada"
            }
        ));
        jScrollPane2.setViewportView(tblEntradasI);

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

        txtProveedor.setBackground(new java.awt.Color(86, 84, 15));
        txtProveedor.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        txtProveedor.setForeground(new java.awt.Color(255, 255, 255));
        txtProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtProveedorActionPerformed(evt);
            }
        });

        jcProductos.setBackground(new java.awt.Color(86, 84, 15));
        jcProductos.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jcProductos.setForeground(new java.awt.Color(255, 255, 255));
        jcProductos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Productos" }));
        jcProductos.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jcProductosFocusGained(evt);
            }
        });
        jcProductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcProductosActionPerformed(evt);
            }
        });

        txtCantidad.setBackground(new java.awt.Color(86, 84, 15));
        txtCantidad.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        txtCantidad.setForeground(new java.awt.Color(255, 255, 255));
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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtCantidad, javax.swing.GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE)
                            .addComponent(txtProveedor))
                        .addGap(44, 44, 44)
                        .addComponent(jcProductos, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 116, Short.MAX_VALUE)
                        .addComponent(btnAgregarENG, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2))
                .addGap(40, 40, 40))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jcProductos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(btnAgregarENG, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 449, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtCantidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCantidadActionPerformed

    }//GEN-LAST:event_txtCantidadActionPerformed

    private void btnAgregarENGActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarENGActionPerformed
        Controlador_Entradas_Inventario conEntrada = new Controlador_Entradas_Inventario();
        Modelo_Entradas_Inventario moEntrada = new Modelo_Entradas_Inventario();    
        Controlador_Proveedor conProve = new Controlador_Proveedor();
        Controlador_Productos conProductos = new Controlador_Productos();

        String codigoProveedor = txtProveedor.getText();
        String nombreProducto = jcProductos.getSelectedItem().toString();
        String cantidadStr = txtCantidad.getText();
        int idProduct = conProductos.obtenerIdPorNombre(nombreProducto);
        int codProve = conProve.obtenerIdProveedorPorCodigo(codigoProveedor);
        try {
            double cantidad = Double.parseDouble(cantidadStr);
            moEntrada.setCantidadKg(cantidad);
            
            moEntrada.setId_producto(idProduct);
            moEntrada.setId_proveedor(codProve);
            conEntrada.agregarEntradaInventario(moEntrada);
            cargarDatos();
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Ingrese una cantidad válida.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnAgregarENGActionPerformed

    private void txtCantidadKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCantidadKeyTyped

    }//GEN-LAST:event_txtCantidadKeyTyped

    private void txtProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtProveedorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtProveedorActionPerformed

    private void jcProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcProductosActionPerformed

    }//GEN-LAST:event_jcProductosActionPerformed

    private void jcProductosFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jcProductosFocusGained
        List<String> nombresProductos = new ArrayList<>();
        Controlador_Proveedor conProv = new Controlador_Proveedor();
        Controlador_Entradas_Inventario conEntrada = new Controlador_Entradas_Inventario();
        String codigoProvee = txtProveedor.getText();
        int idprovee = conProv.obtenerIdProveedorPorCodigo(codigoProvee);
        nombresProductos = conEntrada.obtenerNombresProductos(idprovee);
        jcProductos.removeAllItems();

        for (String nombreProducto : nombresProductos) {
            jcProductos.addItem(nombreProducto);
        }
    }//GEN-LAST:event_jcProductosFocusGained


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregarENG;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JComboBox<String> jcProductos;
    private javax.swing.JTable tblEntradasI;
    private javax.swing.JTextField txtCantidad;
    private javax.swing.JTextField txtProveedor;
    // End of variables declaration//GEN-END:variables

}
