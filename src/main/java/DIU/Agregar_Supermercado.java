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

    public void cargarDatos(){
        DefaultTableModel modelo = (DefaultTableModel) jtbSupermerca.getModel();
        Controlador_Supermercado conSuper = new Controlador_Supermercado();
        modelo = conSuper.obtenerSupermercados();
        jtbSupermerca.setModel(modelo);
    }
    public int obtenerIdSuperSeleccionado() {
            int filaSeleccionada = jtbSupermerca.getSelectedRow();
            if (filaSeleccionada != -1) {
                DefaultTableModel modelo = (DefaultTableModel) jtbSupermerca.getModel();
                return (Integer) modelo.getValueAt(filaSeleccionada, 0);
            } else {
                return -1;
            }
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

        setClosable(true);
        setMaximizable(true);
        setTitle("Agregar Supermercado");

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

        jLabel5.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
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

        jLabel6.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel6.setText("Nombre del Supermercado:");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel5Layout.createSequentialGroup()
                            .addGap(24, 24, 24)
                            .addComponent(jLabel6)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtNombreSuper, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(34, 34, 34)
                            .addComponent(jLabel5)
                            .addGap(50, 50, 50)
                            .addComponent(txtTelefSuper, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(0, 0, Short.MAX_VALUE))
                        .addGroup(jPanel5Layout.createSequentialGroup()
                            .addGap(619, 619, 619)
                            .addComponent(btnEditarSupermer, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnAgregarSupermer, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(15, 15, 15)))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 1005, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtNombreSuper, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(txtTelefSuper, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(42, 42, 42)
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
        DefaultTableModel modelo = (DefaultTableModel) jtbSupermerca.getModel();
        Modelo_Supermercado moSuper = new Modelo_Supermercado();
        Controlador_Supermercado conSuper = new Controlador_Supermercado();
        int fila = jtbSupermerca.getSelectedRow();
        int idSuper = obtenerIdSuperSeleccionado();
        moSuper.setId_supermercado(idSuper);
        
        moSuper.setNombre(jtbSupermerca.getValueAt(fila, 1).toString().toUpperCase());
        moSuper.setTelefono(jtbSupermerca.getValueAt(fila, 2).toString());

        if (validarSupermercado(moSuper)) {
            conSuper.actualizarSupermercado(moSuper);
            modelo = conSuper.obtenerSupermercados();
            jtbSupermerca.setModel(modelo);
        }
    }//GEN-LAST:event_btnEditarSupermerActionPerformed

    private void btnAgregarSupermerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarSupermerActionPerformed
        DefaultTableModel modelo = (DefaultTableModel) jtbSupermerca.getModel();
        Modelo_Supermercado moSuper = new Modelo_Supermercado();
        Controlador_Supermercado conSuper = new Controlador_Supermercado();
        moSuper.setNombre(txtNombreSuper.getText().toUpperCase());
        moSuper.setTelefono(txtTelefSuper.getText());
        if (validarSupermercado(moSuper)) {
            conSuper.agregarSupermercado(moSuper);
            modelo = conSuper.obtenerSupermercados();
            jtbSupermerca.setModel(modelo);
        }
        
    }//GEN-LAST:event_btnAgregarSupermerActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregarSupermer;
    private javax.swing.JButton btnEditarSupermer;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTable jtbSupermerca;
    private javax.swing.JTextField txtNombreSuper;
    private javax.swing.JTextField txtTelefSuper;
    // End of variables declaration//GEN-END:variables
}
