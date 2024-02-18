/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package DIU;

import DIU.Controlador.Controlador_Supermercado;
import DIU.Modelo.Modelo_Supermercado;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author carlo
 */
public class Agregar_Supermercado extends javax.swing.JInternalFrame {

    /**
     * Creates new form Agregar_Supermercado
     */
    public Agregar_Supermercado() {
        initComponents();
        cargarDatos();
    }

    public void cargarDatos() {
        DefaultTableModel modelo = (DefaultTableModel) jtbSupermerca.getModel();
        Controlador_Supermercado conSuper = new Controlador_Supermercado();
        modelo = conSuper.obtenerSupermercados();
        jtbSupermerca.setModel(modelo);
    }

    public boolean validarSupermercado(Modelo_Supermercado supermercado) {
        String regexLetras = "^[a-zA-Z ]+$";
        String regexNumeros = "^[0-9]+$";

        String nombre = supermercado.getNombre();
        if (nombre == null || !nombre.matches(regexLetras)) {
            JOptionPane.showMessageDialog(null, "Error: El nombre solo debe contener letras.", "Error de Validación", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        String telefono = supermercado.getTelefono();
        if (telefono == null || !telefono.matches(regexNumeros) || telefono.length() != 10) {
            JOptionPane.showMessageDialog(null, "Error: El teléfono debe contener solo números y tener una longitud de 10 dígitos.", "Error de Validación", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        String encargado = supermercado.getEncargado();
        if (encargado == null || !encargado.matches(regexLetras)) {
            JOptionPane.showMessageDialog(null, "Error: El nombre del encargado solo debe contener letras.", "Error de Validación", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        return true;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jtbSupermerca = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        btnEditarSupermer = new javax.swing.JButton();
        txtNombreSuper = new javax.swing.JTextField();
        btnAgregarSupermer = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        txtTelefSuper = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtEncargado = new javax.swing.JTextField();

        setClosable(true);
        setMaximizable(true);
        setTitle("Agregar Supermercado");

        jPanel5.setBackground(new java.awt.Color(255, 246, 137));

        jtbSupermerca.setBackground(new java.awt.Color(86, 84, 15));
        jtbSupermerca.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jtbSupermerca.setForeground(new java.awt.Color(255, 255, 255));
        jtbSupermerca.setModel(new javax.swing.table.DefaultTableModel(
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
                "ID Supermercado", "Nombre", "Teléfono"
            }
        ));
        jScrollPane5.setViewportView(jtbSupermerca);

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel5.setText("Teléfono del Supermercado:");

        btnEditarSupermer.setBackground(new java.awt.Color(86, 84, 15));
        btnEditarSupermer.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btnEditarSupermer.setForeground(new java.awt.Color(255, 255, 255));
        btnEditarSupermer.setIcon(new javax.swing.ImageIcon("C:\\Users\\carlo\\Documents\\IST 17J\\Semestre 3\\Programacion visual\\Proyecto-Final\\src\\main\\resource\\Imagenes\\Editar.png")); // NOI18N
        btnEditarSupermer.setText("Editar");
        btnEditarSupermer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarSupermerActionPerformed(evt);
            }
        });

        txtNombreSuper.setBackground(new java.awt.Color(86, 84, 15));
        txtNombreSuper.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        txtNombreSuper.setForeground(new java.awt.Color(255, 255, 255));

        btnAgregarSupermer.setBackground(new java.awt.Color(86, 84, 15));
        btnAgregarSupermer.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btnAgregarSupermer.setForeground(new java.awt.Color(255, 255, 255));
        btnAgregarSupermer.setIcon(new javax.swing.ImageIcon("C:\\Users\\carlo\\Documents\\IST 17J\\Semestre 3\\Programacion visual\\Proyecto-Final\\src\\main\\resource\\Imagenes\\Agregar.png")); // NOI18N
        btnAgregarSupermer.setText("Agregar");
        btnAgregarSupermer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarSupermerActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel6.setText("Nombre del Supermercado:");

        txtTelefSuper.setBackground(new java.awt.Color(86, 84, 15));
        txtTelefSuper.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        txtTelefSuper.setForeground(new java.awt.Color(255, 255, 255));

        jLabel7.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel7.setText("Encargado");

        txtEncargado.setBackground(new java.awt.Color(86, 84, 15));
        txtEncargado.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        txtEncargado.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel5Layout.createSequentialGroup()
                            .addGap(619, 619, 619)
                            .addComponent(btnEditarSupermer, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnAgregarSupermer, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(15, 15, 15))
                        .addGroup(jPanel5Layout.createSequentialGroup()
                            .addGap(20, 20, 20)
                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel5)
                                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 1005, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtTelefSuper, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(35, 35, 35)
                                .addComponent(txtNombreSuper, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(83, 83, 83)
                        .addComponent(jLabel7)
                        .addGap(36, 36, 36)
                        .addComponent(txtEncargado, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel7)
                        .addComponent(txtEncargado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtNombreSuper, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel6)))
                .addGap(8, 8, 8)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtTelefSuper, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 328, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAgregarSupermer, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEditarSupermer, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEditarSupermerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarSupermerActionPerformed
        Controlador_Supermercado conSuper = new Controlador_Supermercado();
        Modelo_Supermercado moSuper = new Modelo_Supermercado();
        int filaSeleccionada = jtbSupermerca.getSelectedRow();
        if (filaSeleccionada == -1) {
            JOptionPane.showMessageDialog(null, "Por favor, seleccione un supermercado de la tabla", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String codigoSupermercado = jtbSupermerca.getValueAt(filaSeleccionada, 0).toString();
        String nombreSupermercado = jtbSupermerca.getValueAt(filaSeleccionada, 1).toString();
        String telefonoSupermercado = jtbSupermerca.getValueAt(filaSeleccionada, 2).toString();
        String encargadoSupermercado = jtbSupermerca.getValueAt(filaSeleccionada, 3).toString();

        moSuper.setCodSuper(codigoSupermercado);
        moSuper.setNombre(nombreSupermercado);
        moSuper.setTelefono(telefonoSupermercado);
        moSuper.setEncargado(encargadoSupermercado);

        if (!validarSupermercado(moSuper)) {
            return;
        }
        int idSupermercado = conSuper.obtenerIdSupermercadoPorCodigo(codigoSupermercado);
        if (idSupermercado == -1) {
            JOptionPane.showMessageDialog(null, "Error al obtener ID del supermercado con el código proporcionado", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        moSuper.setId_supermercado(idSupermercado);
        conSuper.actualizarSupermercado(moSuper);

        cargarDatos();
    }//GEN-LAST:event_btnEditarSupermerActionPerformed

    private void btnAgregarSupermerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarSupermerActionPerformed
        String nombreSupermercado = txtNombreSuper.getText();
        String telefonoSupermercado = txtTelefSuper.getText();
        String encargadoSupermercado = txtEncargado.getText();

        // Validación de campos obligatorios
        if (nombreSupermercado.isEmpty() || telefonoSupermercado.isEmpty() || encargadoSupermercado.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Todos los campos son obligatorios, excepto el código que se genera automáticamente.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        Modelo_Supermercado moSuper = new Modelo_Supermercado();
        moSuper.setNombre(nombreSupermercado);
        moSuper.setTelefono(telefonoSupermercado);
        moSuper.setEncargado(encargadoSupermercado);

        Controlador_Supermercado conSuper = new Controlador_Supermercado();
        conSuper.agregarSupermercado(moSuper);

        cargarDatos();
    }//GEN-LAST:event_btnAgregarSupermerActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregarSupermer;
    private javax.swing.JButton btnEditarSupermer;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTable jtbSupermerca;
    private javax.swing.JTextField txtEncargado;
    private javax.swing.JTextField txtNombreSuper;
    private javax.swing.JTextField txtTelefSuper;
    // End of variables declaration//GEN-END:variables
}
