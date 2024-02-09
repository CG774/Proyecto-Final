/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package DIU;

import DIU.Controlador.Controlador_Proveedor;
import DIU.Modelo.Modelo_Proveedor;
import java.sql.PreparedStatement;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author carlo
 */
public class Agregar_Proveedor extends javax.swing.JInternalFrame {

    private int indiceTabla;
    public Agregar_Proveedor() {
        initComponents();
        cargarDatosProveedores();
    }

    private void cargarDatosProveedores() {
        Controlador_Proveedor productControl = new Controlador_Proveedor();
        DefaultTableModel modelo = productControl.obtenerDatosProveedor();
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
        btnAgregarProove = new javax.swing.JButton();
        btnElimiProove = new javax.swing.JButton();

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
        jtbProveedor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtbProveedorMouseClicked(evt);
            }
        });
        jtbProveedor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtbProveedorKeyPressed(evt);
            }
        });
        jScrollPane5.setViewportView(jtbProveedor);

        jLabel5.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel5.setText("Nombre del proveedor:");

        btnEditarProove.setText("Actualizar");
        btnEditarProove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarProoveActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel6.setText("Teléfono del proveedor:");

        txtNombreProove.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNombreProoveKeyReleased(evt);
            }
        });

        btnAgregarProove.setText("Agregar");
        btnAgregarProove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarProoveActionPerformed(evt);
            }
        });

        btnElimiProove.setText("Eliminar");
        btnElimiProove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnElimiProoveActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(532, 532, 532)
                        .addComponent(btnElimiProove, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnEditarProove, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                        .addComponent(btnAgregarProove, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 801, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel5Layout.createSequentialGroup()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel5))
                                .addGap(37, 37, 37)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txtNombreProove, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtTelefonoProove, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(14, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtNombreProove, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtTelefonoProove, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAgregarProove, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEditarProove, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnElimiProove, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel5);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEditarProoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarProoveActionPerformed

        String nombreAnterior = (String) jtbProveedor.getValueAt(indiceTabla, 1);
       String telefonoAnterior = (String) jtbProveedor.getValueAt(indiceTabla, 2);

        String nuevoNombre = txtNombreProove.getText();
        String nuevoTelefono = txtTelefonoProove.getText();

       
        if (!nombreAnterior.equals(nuevoNombre) || !telefonoAnterior.equals(nuevoTelefono)) {
            Modelo_Proveedor modeloProve = new Modelo_Proveedor();
            Controlador_Proveedor controlProvee = new Controlador_Proveedor();

            modeloProve.setNombre(nuevoNombre);
            modeloProve.setTelefono(nuevoTelefono);

            controlProvee.actualizarProveedor(modeloProve, nombreAnterior, telefonoAnterior);
            cargarDatosProveedores();
        }
    }//GEN-LAST:event_btnEditarProoveActionPerformed

    private void btnAgregarProoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarProoveActionPerformed
        DefaultTableModel modelo = (DefaultTableModel) jtbProveedor.getModel();
        Modelo_Proveedor modeloProve = new Modelo_Proveedor();
        Controlador_Proveedor controlProvee = new Controlador_Proveedor();
        String nombre = txtNombreProove.getText();
        String telefono = txtTelefonoProove.getText();
        modeloProve.setNombre(nombre);
        modeloProve.setTelefono(telefono);
        controlProvee.AgregarProveedor(modeloProve);
        modelo = controlProvee.obtenerDatosProveedor();
        jtbProveedor.setModel(modelo);
        
    }//GEN-LAST:event_btnAgregarProoveActionPerformed

    private void btnElimiProoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnElimiProoveActionPerformed
        String nombre = txtNombreProove.getText();
        String numero = txtTelefonoProove.getText();
        DefaultTableModel modelo = (DefaultTableModel) jtbProveedor.getModel();
        Modelo_Proveedor modeloProve = new Modelo_Proveedor();
        Controlador_Proveedor controlProvee = new Controlador_Proveedor();
        modeloProve.setNombre(nombre);
        modeloProve.setTelefono(numero);
        controlProvee.eliminarProveedor(modeloProve);
        modelo = controlProvee.obtenerDatosProveedor();
        jtbProveedor.setModel(modelo);
    }//GEN-LAST:event_btnElimiProoveActionPerformed

    private void jtbProveedorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtbProveedorMouseClicked
        int indice = jtbProveedor.getSelectedRow();
        if (indice != -1) {
            String nombre = (String) jtbProveedor.getValueAt(indice, 1);
            txtNombreProove.setText(nombre);
            String telefono = (String) jtbProveedor.getValueAt(indice, 2);
            txtTelefonoProove.setText(telefono);

            indiceTabla = indice;
        }
        
    }//GEN-LAST:event_jtbProveedorMouseClicked

    private void jtbProveedorKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtbProveedorKeyPressed
        
    }//GEN-LAST:event_jtbProveedorKeyPressed

    private void txtNombreProoveKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreProoveKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreProoveKeyReleased

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregarProove;
    private javax.swing.JButton btnEditarProove;
    private javax.swing.JButton btnElimiProove;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTable jtbProveedor;
    private javax.swing.JTextField txtNombreProove;
    private javax.swing.JTextField txtTelefonoProove;
    // End of variables declaration//GEN-END:variables
}
