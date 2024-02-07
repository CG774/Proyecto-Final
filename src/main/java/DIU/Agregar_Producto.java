/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package DIU;

import DIU.Controlador.ConexionBDD;
import DIU.Controlador.Controlador_Productos;
import DIU.Modelo.Modelo_Productos;
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
public class Agregar_Producto extends javax.swing.JInternalFrame {

    public static int idProducto;

    public Agregar_Producto() {
        initComponents();
        cargarDatosProductos();

    }
    ConexionBDD conexion = new ConexionBDD();
    //OBJETO 
    Connection conectado = (Connection) conexion.conectar();
    //DOWNCASTING
    PreparedStatement sesion;

    private void cargarDatosProductos() {
        Controlador_Productos productControl = new Controlador_Productos();
        DefaultTableModel modelo = productControl.obtenerDatosProductos();
        jtbProducto.setModel(modelo);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtbProducto = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        txtNombreProdu = new javax.swing.JTextField();
        btnBuscarProduc = new javax.swing.JButton();
        btnEditarProduc = new javax.swing.JButton();
        btnAgregarProduc = new javax.swing.JButton();
        btbEliminarProducto = new javax.swing.JButton();

        setClosable(true);
        setTitle("Agregar Producto");

        jtbProducto.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 14)); // NOI18N
        jtbProducto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "ID Producto", "Nombre"
            }
        ));
        jtbProducto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtbProductoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtbProducto);

        jLabel1.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel1.setText("Nombre del producto");

        txtNombreProdu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreProduActionPerformed(evt);
            }
        });

        btnBuscarProduc.setText("Buscar");
        btnBuscarProduc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarProducActionPerformed(evt);
            }
        });

        btnEditarProduc.setText("Editar");
        btnEditarProduc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarProducActionPerformed(evt);
            }
        });

        btnAgregarProduc.setText("Agregar");
        btnAgregarProduc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarProducActionPerformed(evt);
            }
        });

        btbEliminarProducto.setText("Eliminar");
        btbEliminarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btbEliminarProductoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(25, 25, 25)
                                .addComponent(txtNombreProdu, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(162, 162, 162)
                                .addComponent(btnBuscarProduc, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(122, 122, 122))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btbEliminarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(41, 41, 41)
                        .addComponent(btnEditarProduc, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(44, 44, 44)
                        .addComponent(btnAgregarProduc)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtNombreProdu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscarProduc, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnEditarProduc, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btbEliminarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(3, 3, 3))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(btnAgregarProduc, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
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

    private void btnBuscarProducActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarProducActionPerformed
        if (txtNombreProdu.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor, complete todos los campos.", "Error", JOptionPane.ERROR_MESSAGE);
            return;

        }
        Controlador_Productos productControl = new Controlador_Productos();
        DefaultTableModel modelo = productControl.buscarProductos(txtNombreProdu.getText());
        jtbProducto.setModel(modelo);

    }//GEN-LAST:event_btnBuscarProducActionPerformed

    private void btnAgregarProducActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarProducActionPerformed

        if (txtNombreProdu.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor, complete todos los campos.", "Error", JOptionPane.ERROR_MESSAGE);
            return;

        }

        String NombreProduc = txtNombreProdu.getText();

        Modelo_Productos productModel = new Modelo_Productos(NombreProduc);
        Controlador_Productos productControl = new Controlador_Productos();
        int exist = productControl.repiteProducto(NombreProduc);
        if (exist == 2) {
            productControl.AgregarProducto(productModel);
        }
        cargarDatosProductos();


    }//GEN-LAST:event_btnAgregarProducActionPerformed

    private void txtNombreProduActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreProduActionPerformed
        if (txtNombreProdu.getText().isBlank());
    }//GEN-LAST:event_txtNombreProduActionPerformed

    private void btbEliminarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btbEliminarProductoActionPerformed
        if (idProducto == 0) {
            JOptionPane.showMessageDialog(rootPane, "POR FAVOR SELECCIONE CON UN CLICK EN EL PRODUCTO");
            return;
        }
        Controlador_Productos productControl = new Controlador_Productos();
        productControl.eliminarProducto(idProducto);

        idProducto = 0;
        cargarDatosProductos();
    }//GEN-LAST:event_btbEliminarProductoActionPerformed

    private void jtbProductoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtbProductoMouseClicked
        String nombre = txtNombreProdu.getText();
        int indice = jtbProducto.getSelectedRow();
        String consulta = "SELECT * FROM proyecto.productos  LIMIT " + indice + "," + 1;
        //INICIAR SESIÓN A NIV
        try {
            sesion = (PreparedStatement) conectado.prepareStatement(consulta);
            ResultSet resul = sesion.executeQuery();
            while (resul.next()) {
                idProducto = resul.getInt(1);
            }
        } catch (SQLException e) {
            Component rootPane = null;
            JOptionPane.showMessageDialog(rootPane, "NO SE PUEDE ELIMINAR");
        }
    }//GEN-LAST:event_jtbProductoMouseClicked

    private void btnEditarProducActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarProducActionPerformed
        if (idProducto == 0) {
            JOptionPane.showMessageDialog(rootPane, "POR FAVOR SELECCIONE CON UN CLICK EN EL PRODUCTO");
            return;
        }
        String nuevoNombreProducto = JOptionPane.showInputDialog("Ingrese un nuevo nombre");

        System.out.println(nuevoNombreProducto);

        Modelo_Productos nuevoProducto = new Modelo_Productos(idProducto, nuevoNombreProducto);
        Controlador_Productos productControl = new Controlador_Productos();
        productControl.actualizarProducto(nuevoProducto, idProducto);

        idProducto = 0;
        cargarDatosProductos();

    }//GEN-LAST:event_btnEditarProducActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btbEliminarProducto;
    private javax.swing.JButton btnAgregarProduc;
    private javax.swing.JButton btnBuscarProduc;
    private javax.swing.JButton btnEditarProduc;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTable jtbProducto;
    private javax.swing.JTextField txtNombreProdu;
    // End of variables declaration//GEN-END:variables
}
