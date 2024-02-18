/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package DIU;

import DIU.Controlador.Controlador_Productos;
import DIU.Controlador.Controlador_Proveedor;
import DIU.Modelo.Modelo_Productos;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author carlo
 */
public class Agregar_Producto extends javax.swing.JInternalFrame {

    public static int id_Producto;

    public Agregar_Producto() {
        initComponents();
        cargarDatos();

    }

    public void cargarDatos() {
        DefaultTableModel modelo = (DefaultTableModel) jtbProducto.getModel();
        Controlador_Productos conProduc = new Controlador_Productos();
        modelo = conProduc.obtenerDatosProductos();
        jtbProducto.setModel(modelo);
    }

    private boolean validarDatos(String nombre) {
        String regexNombre = "^[A-Za-zÁÉÍÓÚáéíóúñÑ\\s]+$";

        Pattern patternNombre = Pattern.compile(regexNombre);
        Matcher matcherNombre = patternNombre.matcher(nombre);

        if (!matcherNombre.matches()) {
            JOptionPane.showMessageDialog(null, "El nombre solo puede contener letras y espacios.", "Error de validación", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtbProducto = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        txtNombreProdu = new javax.swing.JTextField();
        btnActualizar = new javax.swing.JButton();
        btnAgregarProduc = new javax.swing.JButton();
        btbEliminarProducto = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        txtCodigoProve = new javax.swing.JTextField();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Agregar Producto");

        jtbProducto.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jtbProducto.setModel(new javax.swing.table.DefaultTableModel(
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
                "Código Producto", "Nombre", "Proveedor"
            }
        ));
        jScrollPane1.setViewportView(jtbProducto);

        jLabel1.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel1.setText("Nombre del producto:");

        txtNombreProdu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreProduActionPerformed(evt);
            }
        });
        txtNombreProdu.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNombreProduKeyReleased(evt);
            }
        });

        btnActualizar.setBackground(new java.awt.Color(86, 84, 15));
        btnActualizar.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btnActualizar.setForeground(new java.awt.Color(255, 255, 255));
        btnActualizar.setText("Actualizar");
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });

        btnAgregarProduc.setBackground(new java.awt.Color(86, 84, 15));
        btnAgregarProduc.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btnAgregarProduc.setForeground(new java.awt.Color(255, 255, 255));
        btnAgregarProduc.setText("Agregar");
        btnAgregarProduc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarProducActionPerformed(evt);
            }
        });

        btbEliminarProducto.setBackground(new java.awt.Color(86, 84, 15));
        btbEliminarProducto.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btbEliminarProducto.setForeground(new java.awt.Color(255, 255, 255));
        btbEliminarProducto.setText("Eliminar");
        btbEliminarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btbEliminarProductoActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel2.setText("Codigo del proveedor:");

        txtCodigoProve.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCodigoProveActionPerformed(evt);
            }
        });
        txtCodigoProve.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCodigoProveKeyReleased(evt);
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
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 920, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(40, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addGap(23, 23, 23)
                                        .addComponent(txtCodigoProve, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addGap(28, 28, 28)
                                        .addComponent(txtNombreProdu, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(btbEliminarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(40, 40, 40)
                                .addComponent(btnActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(40, 40, 40)))
                        .addComponent(btnAgregarProduc, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(56, 56, 56))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtNombreProdu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtCodigoProve, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAgregarProduc, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btbEliminarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12))
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

    private void btnAgregarProducActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarProducActionPerformed
        Controlador_Proveedor conProvee = new Controlador_Proveedor();
        String nombreProducto = txtNombreProdu.getText();
        String codigoProveedor = txtCodigoProve.getText();

        if (nombreProducto.isEmpty() || codigoProveedor.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Todos los campos son obligatorios", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Modelo_Productos moProd = new Modelo_Productos();
        moProd.setNombreProducto(nombreProducto);
        moProd.setCodigoProduct(codigoProveedor);

        Controlador_Productos conProd = new Controlador_Productos();
        moProd.setIdProvee(conProvee.obtenerIdProveedorPorCodigo(codigoProveedor));
        conProd.agregarProducto(moProd);

        cargarDatos();

    }//GEN-LAST:event_btnAgregarProducActionPerformed

    private void btbEliminarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btbEliminarProductoActionPerformed
        Controlador_Proveedor conProvee = new Controlador_Proveedor();
        String nombreProducto = txtNombreProdu.getText();
        String codigoProveedor = txtCodigoProve.getText();

        if (nombreProducto.isEmpty() || codigoProveedor.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Todos los campos son obligatorios", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (!validarDatos(nombreProducto)) {
            return;
        }

        Modelo_Productos moProd = new Modelo_Productos();
        moProd.setNombreProducto(nombreProducto);
        moProd.setCodigoProduct(codigoProveedor);

        Controlador_Productos conProd = new Controlador_Productos();
        moProd.setIdProvee(conProvee.obtenerIdProveedorPorCodigo(codigoProveedor));
        conProd.agregarProducto(moProd);

        cargarDatos();
    }//GEN-LAST:event_btbEliminarProductoActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        Controlador_Productos conProd = new Controlador_Productos();
        Modelo_Productos moProd = new Modelo_Productos();
        int filaSeleccionada = jtbProducto.getSelectedRow();
        if (filaSeleccionada == -1) {
            JOptionPane.showMessageDialog(null, "Por favor, seleccione un producto de la tabla", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String codigoProducto = jtbProducto.getValueAt(filaSeleccionada, 0).toString();
        String nombreProducto = jtbProducto.getValueAt(filaSeleccionada, 1).toString();

        int idProducto = conProd.obtenerIdProductoPorCodigo(codigoProducto);

        if (idProducto == -1) {
            JOptionPane.showMessageDialog(null, "Error al obtener ID del producto", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (!validarDatos(nombreProducto)) {
            return;
        }

        moProd.setIdProducto(idProducto);
        moProd.setNombreProducto(nombreProducto.toUpperCase());
        moProd.setIdProvee(conProd.obtenerIdProveedorPorCodigoProduct(codigoProducto));
        conProd.actualizarProducto(moProd);
        cargarDatos();
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void txtNombreProduKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreProduKeyReleased

    }//GEN-LAST:event_txtNombreProduKeyReleased

    private void txtNombreProduActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreProduActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreProduActionPerformed

    private void txtCodigoProveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodigoProveActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCodigoProveActionPerformed

    private void txtCodigoProveKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodigoProveKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCodigoProveKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btbEliminarProducto;
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnAgregarProduc;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTable jtbProducto;
    private javax.swing.JTextField txtCodigoProve;
    private javax.swing.JTextField txtNombreProdu;
    // End of variables declaration//GEN-END:variables
}
