/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package DIU;

import DIU.Controlador.ConexionBDD;
import DIU.Controlador.Controlador_Productos;
import DIU.Controlador.Controlador_Proveedor;
import DIU.Modelo.Modelo_Envios;
import DIU.Modelo.Modelo_Proveedor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author carlo
 */
public class Agregar_Proveedor extends javax.swing.JInternalFrame {

    public Agregar_Proveedor() {
        initComponents();
        cargarDatos();
    }

    public void cargarDatos() {
        DefaultTableModel modelo = (DefaultTableModel) jtblProveedores.getModel();
        Controlador_Proveedor conProve = new Controlador_Proveedor();
        modelo = conProve.obtenerDatosProveedores();
        jtblProveedores.setModel(modelo);
    }

    private boolean validarDatos(String nombre, String telefono, String correo) {
        String regexNombre = "^[A-Za-zÁÉÍÓÚáéíóúñÑ\\s]+$";
        String regexTelefono = "^[0-9]{10}$";
        String regexCorreo = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Z|a-z]{2,6}$";

        Pattern patternNombre = Pattern.compile(regexNombre);
        Matcher matcherNombre = patternNombre.matcher(nombre);

        Pattern patternTelefono = Pattern.compile(regexTelefono);
        Matcher matcherTelefono = patternTelefono.matcher(telefono);

        Pattern patternCorreo = Pattern.compile(regexCorreo);
        Matcher matcherCorreo = patternCorreo.matcher(correo);

        if (!matcherNombre.matches()) {
            JOptionPane.showMessageDialog(null, "El nombre solo puede contener letras y espacios.", "Error de validación", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        if (!matcherTelefono.matches()) {
            JOptionPane.showMessageDialog(null, "El teléfono solo puede contener dígitos.", "Error de validación", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        if (!matcherCorreo.matches()) {
            JOptionPane.showMessageDialog(null, "El correo electrónico no es válido.", "Error de validación", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        return true;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel5 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        txtTelefonoProove = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtCorreo = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtNombreProove = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtblProveedores = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        btnActualizar = new javax.swing.JButton();
        btnAgregarProove = new javax.swing.JButton();
        btnElimiProove = new javax.swing.JButton();

        setClosable(true);
        setMaximizable(true);
        setTitle("Agregar proveedor");

        jPanel5.setBackground(new java.awt.Color(255, 246, 137));

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel5.setText("Nombre del proveedor:");

        txtTelefonoProove.setBackground(new java.awt.Color(86, 84, 15));
        txtTelefonoProove.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        txtTelefonoProove.setForeground(new java.awt.Color(255, 255, 255));

        jLabel6.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel6.setText("Teléfono del proveedor:");

        txtCorreo.setBackground(new java.awt.Color(86, 84, 15));
        txtCorreo.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        txtCorreo.setForeground(new java.awt.Color(255, 255, 255));
        txtCorreo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCorreoKeyReleased(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel7.setText("Correo:");

        txtNombreProove.setBackground(new java.awt.Color(86, 84, 15));
        txtNombreProove.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        txtNombreProove.setForeground(new java.awt.Color(255, 255, 255));
        txtNombreProove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreProoveActionPerformed(evt);
            }
        });
        txtNombreProove.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNombreProoveKeyReleased(evt);
            }
        });

        jtblProveedores.setAutoCreateRowSorter(true);
        jtblProveedores.setBackground(new java.awt.Color(86, 84, 15));
        jtblProveedores.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jtblProveedores.setForeground(new java.awt.Color(255, 255, 255));
        jtblProveedores.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Código Proveedor", "Nombre", "Teléfono", "Correo"
            }
        ));
        jScrollPane1.setViewportView(jtblProveedores);

        jPanel1.setBackground(new java.awt.Color(255, 246, 137));

        btnActualizar.setBackground(new java.awt.Color(86, 84, 15));
        btnActualizar.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btnActualizar.setForeground(new java.awt.Color(255, 255, 255));
        btnActualizar.setIcon(new javax.swing.ImageIcon("C:\\Users\\carlo\\Documents\\IST 17J\\Semestre 3\\Programacion visual\\Proyecto-Final\\src\\main\\resource\\Imagenes\\Editar.png")); // NOI18N
        btnActualizar.setText("Actualizar");
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });

        btnAgregarProove.setBackground(new java.awt.Color(86, 84, 15));
        btnAgregarProove.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btnAgregarProove.setForeground(new java.awt.Color(255, 255, 255));
        btnAgregarProove.setIcon(new javax.swing.ImageIcon("C:\\Users\\carlo\\Documents\\IST 17J\\Semestre 3\\Programacion visual\\Proyecto-Final\\src\\main\\resource\\Imagenes\\Agregar.png")); // NOI18N
        btnAgregarProove.setText("Agregar");
        btnAgregarProove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarProoveActionPerformed(evt);
            }
        });

        btnElimiProove.setBackground(new java.awt.Color(86, 84, 15));
        btnElimiProove.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btnElimiProove.setForeground(new java.awt.Color(255, 255, 255));
        btnElimiProove.setIcon(new javax.swing.ImageIcon("C:\\Users\\carlo\\Documents\\IST 17J\\Semestre 3\\Programacion visual\\Proyecto-Final\\src\\main\\resource\\Imagenes\\Eliminar.png")); // NOI18N
        btnElimiProove.setText("Eliminar");
        btnElimiProove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnElimiProoveActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(54, Short.MAX_VALUE)
                .addComponent(btnElimiProove, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(btnActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(btnAgregarProove, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE, false)
                    .addComponent(btnAgregarProove, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnElimiProove, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(40, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel5))
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addComponent(txtNombreProove, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                                .addGap(25, 25, 25)
                                .addComponent(txtTelefonoProove, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(60, 60, 60)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 934, Short.MAX_VALUE))
                .addGap(40, 40, 40))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNombreProove, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel7)
                    .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtTelefonoProove, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 301, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        Modelo_Proveedor moPove = new Modelo_Proveedor();
        Controlador_Proveedor conProve = new Controlador_Proveedor();
        int filaSeleccionada = jtblProveedores.getSelectedRow();
        if (filaSeleccionada == -1) {
            JOptionPane.showMessageDialog(null, "Por favor, seleccione un proveedor de la tabla", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        String codigo = jtblProveedores.getValueAt(filaSeleccionada, 0).toString();
        String nombreProveedor = jtblProveedores.getValueAt(filaSeleccionada, 1).toString().toUpperCase();
        String telefonoProveedor = jtblProveedores.getValueAt(filaSeleccionada, 2).toString();
        String correo = jtblProveedores.getValueAt(filaSeleccionada, 3).toString();

        if (!validarDatos(nombreProveedor, telefonoProveedor, correo)) {
            JOptionPane.showMessageDialog(null, "Los datos ingresados no son válidos", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        moPove.setCodigo(codigo);
        moPove.setCorreo(correo);
        moPove.setId_proveedor(conProve.obtenerIdProveedorPorCodigo(codigo));
        moPove.setNombre_proveedor(nombreProveedor);
        moPove.setTelefono_proveedor(telefonoProveedor);

        conProve.actualizarProveedor(moPove);

        cargarDatos();
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void btnAgregarProoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarProoveActionPerformed
        String nombreProveedor = txtNombreProove.getText().toUpperCase();
        String telefonoProveedor = txtTelefonoProove.getText();
        String correo = txtCorreo.getText();

        if (!validarDatos(nombreProveedor, telefonoProveedor, correo)) {
            JOptionPane.showMessageDialog(null, "Los datos ingresados no son válidos", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Modelo_Proveedor proveedor = new Modelo_Proveedor();
        proveedor.setNombre_proveedor(nombreProveedor);
        proveedor.setTelefono_proveedor(telefonoProveedor);
        proveedor.setCorreo(correo);

        Controlador_Proveedor controlador = new Controlador_Proveedor();
        controlador.agregarProveedor(proveedor);

        cargarDatos();

    }//GEN-LAST:event_btnAgregarProoveActionPerformed

    private void btnElimiProoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnElimiProoveActionPerformed
        int filaSeleccionada = jtblProveedores.getSelectedRow();
        Controlador_Proveedor conProve = new Controlador_Proveedor();

        if (filaSeleccionada == -1) {
            JOptionPane.showMessageDialog(null, "Por favor, seleccione un proveedor de la tabla", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String codigo = (jtblProveedores.getValueAt(filaSeleccionada, 0).toString());
        int confirmacion = JOptionPane.showConfirmDialog(null, "¿Está seguro de eliminar este proveedor?", "Confirmación", JOptionPane.YES_NO_OPTION);

        if (confirmacion == JOptionPane.YES_OPTION) {
            Controlador_Proveedor controlador = new Controlador_Proveedor();
            int idProveedor = conProve.obtenerIdProveedorPorCodigo(codigo);
            controlador.eliminarProveedor(idProveedor);
            cargarDatos();
        }
    }//GEN-LAST:event_btnElimiProoveActionPerformed

    private void txtCorreoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCorreoKeyReleased

    }//GEN-LAST:event_txtCorreoKeyReleased

    private void txtNombreProoveKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreProoveKeyReleased

    }//GEN-LAST:event_txtNombreProoveKeyReleased

    private void txtNombreProoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreProoveActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreProoveActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnAgregarProove;
    private javax.swing.JButton btnElimiProove;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jtblProveedores;
    private javax.swing.JTextField txtCorreo;
    private javax.swing.JTextField txtNombreProove;
    private javax.swing.JTextField txtTelefonoProove;
    // End of variables declaration//GEN-END:variables

}
