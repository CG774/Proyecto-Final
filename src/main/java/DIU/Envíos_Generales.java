/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package DIU;

import DIU.Controlador.Controlador_Envios_General;
import DIU.Controlador.Controlador_Supermercado;
import DIU.Modelo.Modelo_Envios_General;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author carlo
 */
public class Envíos_Generales extends javax.swing.JInternalFrame {

    public Envíos_Generales() {
        initComponents();
        cargarDatos();
        Controlador_Supermercado conSuper = new Controlador_Supermercado();
        List<String> nombresSupermercados = conSuper.obtenerNombresSupermercados();
        jcSupermercados.removeAllItems(); // Limpiar el JComboBox antes de añadir nuevos elementos

        for (String nombre : nombresSupermercados) {
            jcSupermercados.addItem(nombre);
        }

    }

    public void cargarDatos() {
        DefaultTableModel modelo = (DefaultTableModel) jtblEnviosGene.getModel();
        Controlador_Envios_General conSuper = new Controlador_Envios_General();
        modelo = conSuper.obtenerEnviosGenerales();
        jtblEnviosGene.setModel(modelo);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        btnAgregarEnGe = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtblEnviosGene = new javax.swing.JTable();
        jcSupermercados = new javax.swing.JComboBox<>();

        setClosable(true);
        setMaximizable(true);

        jPanel1.setBackground(new java.awt.Color(255, 246, 137));

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel2.setText("Seleccione un Supermercado");

        btnAgregarEnGe.setBackground(new java.awt.Color(86, 84, 15));
        btnAgregarEnGe.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btnAgregarEnGe.setForeground(new java.awt.Color(255, 255, 255));
        btnAgregarEnGe.setIcon(new javax.swing.ImageIcon("C:\\Users\\carlo\\Documents\\IST 17J\\Semestre 3\\Programacion visual\\Proyecto-Final\\src\\main\\resource\\Imagenes\\Agregar.png")); // NOI18N
        btnAgregarEnGe.setText("Agregar");
        btnAgregarEnGe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarEnGeActionPerformed(evt);
            }
        });

        jtblEnviosGene.setBackground(new java.awt.Color(86, 84, 15));
        jtblEnviosGene.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jtblEnviosGene.setForeground(new java.awt.Color(255, 255, 255));
        jtblEnviosGene.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID Envío", "ID Gaveta", "Supermercado", "Cantidad"
            }
        ));
        jScrollPane1.setViewportView(jtblEnviosGene);

        jcSupermercados.setBackground(new java.awt.Color(86, 84, 15));
        jcSupermercados.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jcSupermercados.setForeground(new java.awt.Color(255, 255, 255));
        jcSupermercados.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-elegir-" }));
        jcSupermercados.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jcSupermercadosFocusGained(evt);
            }
        });
        jcSupermercados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcSupermercadosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jcSupermercados, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(408, 408, 408)
                        .addComponent(btnAgregarEnGe, javax.swing.GroupLayout.DEFAULT_SIZE, 167, Short.MAX_VALUE)))
                .addGap(20, 20, 20))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jcSupermercados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(btnAgregarEnGe, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(68, 68, 68)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregarEnGeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarEnGeActionPerformed
        crearEnvioGeneral();

    }//GEN-LAST:event_btnAgregarEnGeActionPerformed

    private void jcSupermercadosFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jcSupermercadosFocusGained

    }//GEN-LAST:event_jcSupermercadosFocusGained

    private void jcSupermercadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcSupermercadosActionPerformed


    }//GEN-LAST:event_jcSupermercadosActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregarEnGe;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<String> jcSupermercados;
    private javax.swing.JTable jtblEnviosGene;
    // End of variables declaration//GEN-END:variables

    private void crearEnvioGeneral() {
        DefaultTableModel modelo = (DefaultTableModel) jtblEnviosGene.getModel();
        Modelo_Envios_General moEnGe = new Modelo_Envios_General();
        Controlador_Envios_General conEnGe = new Controlador_Envios_General();

        String nombre = jcSupermercados.getSelectedItem().toString();
        Controlador_Supermercado controlSuper = new Controlador_Supermercado();
        int idSupermercado = controlSuper.obtenerIdSupermercadoPorNombre(nombre);

        moEnGe.setId_supermercado(idSupermercado);
        conEnGe.agregarEnvioGeneral(moEnGe.getId_supermercado());
        modelo = conEnGe.obtenerEnviosGenerales();

        jtblEnviosGene.setModel(modelo);
    }
}
