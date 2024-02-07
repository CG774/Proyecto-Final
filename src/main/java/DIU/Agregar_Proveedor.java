/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package DIU;

import DIU.Controlador.ConexionBDD;
import DIU.Controlador.Controlador_Productos;
import DIU.Controlador.Controlador_Proveedor;
import DIU.Modelo.Modelo_Proveedor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author carlo
 */
public class Agregar_Proveedor extends javax.swing.JInternalFrame {

    /**
     * Creates new form Argegar_Proveedor
     */
    public Agregar_Proveedor() {
        initComponents();
        cargarDatosProveedores();
    }



    private void cargarDatosProveedores() {
        Controlador_Proveedor proveeControl = new Controlador_Proveedor();
        DefaultTableModel modelo = proveeControl.obtenerDatosProveedores();
        jtbProveedor.setModel(modelo);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel5 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jtbProveedor = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        btnEditarProove = new javax.swing.JButton();
        txtTelefonoProove = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtNombreProove = new javax.swing.JTextField();
        btnBuscarProove = new javax.swing.JButton();
        btnAgregarProove = new javax.swing.JButton();
        btnEditarProove1 = new javax.swing.JButton();

        setClosable(true);
        setTitle("Agregar proveedor");

        jtbProveedor.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "ID Producto", "Nombre", "Teléfono"
            }
        ));
        jScrollPane5.setViewportView(jtbProveedor);

        jLabel5.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel5.setText("Nombre del proveedor:");

        btnEditarProove.setText("Editar");
        btnEditarProove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarProoveActionPerformed(evt);
            }
        });

        txtTelefonoProove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTelefonoProoveActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel6.setText("Teléfono del proveedor:");

        txtNombreProove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreProoveActionPerformed(evt);
            }
        });

        btnBuscarProove.setText("Buscar");
        btnBuscarProove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarProoveActionPerformed(evt);
            }
        });

        btnAgregarProove.setText("Agregar");
        btnAgregarProove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarProoveActionPerformed(evt);
            }
        });

        btnEditarProove1.setText("Eliminar");
        btnEditarProove1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarProove1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(522, 522, 522)
                        .addComponent(btnEditarProove1, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(btnEditarProove, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnAgregarProove, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addContainerGap(20, Short.MAX_VALUE)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 801, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel5))
                                .addGap(37, 37, 37)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txtNombreProove, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtTelefonoProove, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnBuscarProove, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txtNombreProove, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(txtTelefonoProove, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnBuscarProove, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAgregarProove, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEditarProove, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEditarProove1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEditarProoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarProoveActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEditarProoveActionPerformed

    private void btnBuscarProoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarProoveActionPerformed
        Controlador_Proveedor contrProve = new Controlador_Proveedor();
        DefaultTableModel modelo = contrProve.buscarProveedorPorNombre(txtNombreProove.getText());
        jtbProveedor.setModel(modelo);
    }//GEN-LAST:event_btnBuscarProoveActionPerformed

    private void btnAgregarProoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarProoveActionPerformed
        if (txtNombreProove.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor, complete todos los campos.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        String nombreP = txtNombreProove.getText();
        String telefonoP = txtTelefonoProove.getText();

        Modelo_Proveedor productModel = new Modelo_Proveedor(0, nombreP, telefonoP);
        Controlador_Proveedor proveetControl = new Controlador_Proveedor();

        proveetControl.AgregarProveedor(productModel);

        cargarDatosProveedores();
    }//GEN-LAST:event_btnAgregarProoveActionPerformed

    private void btnEditarProove1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarProove1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEditarProove1ActionPerformed

    private void txtNombreProoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreProoveActionPerformed
        if (txtNombreProove.getText().isBlank());
    }//GEN-LAST:event_txtNombreProoveActionPerformed

    private void txtTelefonoProoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTelefonoProoveActionPerformed
        if (txtTelefonoProove.getText().isBlank());
    }//GEN-LAST:event_txtTelefonoProoveActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregarProove;
    private javax.swing.JButton btnBuscarProove;
    private javax.swing.JButton btnEditarProove;
    private javax.swing.JButton btnEditarProove1;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTable jtbProveedor;
    private javax.swing.JTextField txtNombreProove;
    private javax.swing.JTextField txtTelefonoProove;
    // End of variables declaration//GEN-END:variables
}
