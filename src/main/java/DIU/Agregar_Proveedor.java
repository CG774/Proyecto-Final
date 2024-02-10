/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package DIU;

import DIU.Controlador.Controlador_Proveedor;
import DIU.Modelo.Modelo_Proveedor;
import java.awt.event.KeyEvent;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;
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
    public int obtenerIdProove() {
        int filaSeleccionada = jtbProveedor.getSelectedRow();
        if (filaSeleccionada != -1) {
            DefaultTableModel modelo = (DefaultTableModel) jtbProveedor.getModel();
            return (Integer) modelo.getValueAt(filaSeleccionada, 0);
        } else {
            return -1;
        }
    }
    public int validarData(Modelo_Proveedor proveedor) {
        String nombre = proveedor.getNombre();
        String telefono = proveedor.getTelefono();

        boolean nombreValido = nombre.matches("[a-zA-Z ]+");
        boolean telefonoValido = telefono.matches("^09\\d{8}$");

        if (!nombreValido) {
            JOptionPane.showMessageDialog(null, "Error: El nombre debe contener solo letras.", "Error de Validación", JOptionPane.ERROR_MESSAGE);
            return 1;
        }

        if (!telefonoValido) {
            JOptionPane.showMessageDialog(null, "Error: El número de teléfono debe tener 10 dígitos y empezar con '09'.", "Error de Validación", JOptionPane.ERROR_MESSAGE);
            return 1;
        }

        proveedor.setNombre(nombre.toUpperCase());
        return 0;
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
        setMaximizable(true);
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
                .addGap(769, 769, 769)
                .addComponent(btnElimiProove, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnEditarProove, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 1020, Short.MAX_VALUE)
                .addGap(20, 20, 20))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtTelefonoProove, javax.swing.GroupLayout.DEFAULT_SIZE, 217, Short.MAX_VALUE)
                    .addComponent(txtNombreProove))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnAgregarProove, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtNombreProove, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTelefonoProove, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAgregarProove, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 326, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnElimiProove, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEditarProove, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        getContentPane().add(jPanel5, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEditarProoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarProoveActionPerformed
        DefaultTableModel modelo = (DefaultTableModel) jtbProveedor.getModel();
        Modelo_Proveedor modeloProve = new Modelo_Proveedor();
        Controlador_Proveedor controlProvee = new Controlador_Proveedor();
        String nombre = txtNombreProove.getText();
        String telefono = txtTelefonoProove.getText();
        int idProove = obtenerIdProove();

        modeloProve.setNombre(nombre);
        modeloProve.setTelefono(telefono);
        modeloProve.setId(idProove);

        int resultVal = validarData(modeloProve);

        if (resultVal == 0) {
            controlProvee.editarProveedor(modeloProve);
            modelo = controlProvee.obtenerDatosProveedor();
            jtbProveedor.setModel(modelo);
        }
        txtNombreProove.setText("");
        txtTelefonoProove.setText("");
    }//GEN-LAST:event_btnEditarProoveActionPerformed

    private void btnAgregarProoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarProoveActionPerformed
        DefaultTableModel modelo = (DefaultTableModel) jtbProveedor.getModel();
        Modelo_Proveedor modeloProve = new Modelo_Proveedor();
        Controlador_Proveedor controlProvee = new Controlador_Proveedor();
        String nombre = txtNombreProove.getText();
        String telefono = txtTelefonoProove.getText();

        modeloProve.setNombre(nombre);
        modeloProve.setTelefono(telefono);

        int resultVal = validarData(modeloProve);
        

        if (resultVal == 0) {
            controlProvee.AgregarProveedor(modeloProve);
            modelo = controlProvee.obtenerDatosProveedor();
            jtbProveedor.setModel(modelo);
        }
        txtNombreProove.setText("");
        txtTelefonoProove.setText("");
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
        txtNombreProove.setText("");
        txtTelefonoProove.setText("");
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
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
        int indice = jtbProveedor.getSelectedRow();
            if (indice != -1) {
                String nombre = (String) jtbProveedor.getValueAt(indice, 1);
                txtNombreProove.setText(nombre);
                String telefono = (String) jtbProveedor.getValueAt(indice, 2);
                txtTelefonoProove.setText(telefono);
                indiceTabla = indice;
            }
        }
    }//GEN-LAST:event_jtbProveedorKeyPressed

    

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
