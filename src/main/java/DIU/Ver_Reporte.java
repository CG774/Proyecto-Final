/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package DIU;

import DIU.Controlador.Controlador_Entradas_Inventario;
import DIU.Controlador.Controlador_Envios;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.swing.ButtonModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author carlo
 */
public class Ver_Reporte extends javax.swing.JInternalFrame {

    /**
     * Creates new form Ver_Reporte
     */
    public Ver_Reporte() {
        initComponents();
        cargarDatos();
    }
    
    public void cargarDatos(){
        DefaultTableModel modelo = (DefaultTableModel) jtblEnvioRep.getModel();
        Controlador_Envios enviRep = new Controlador_Envios();
        modelo = enviRep.obtenerDatosVistaEnvio();
        jtblEnvioRep.setModel(modelo);
        
        DefaultTableModel modelo2 = (DefaultTableModel) jtblEntradaRep.getModel();
        Controlador_Entradas_Inventario repEntra = new Controlador_Entradas_Inventario();
        modelo2 = repEntra.obtenerDatosVistaEntrada();
        jtblEntradaRep.setModel(modelo2);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        rbgRepEnvi = new javax.swing.ButtonGroup();
        rbgRepEntra = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtblEntradaRep = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtblEnvioRep = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        rbtnMes = new javax.swing.JRadioButton();
        rbtnDía = new javax.swing.JRadioButton();
        rbtnSemana = new javax.swing.JRadioButton();
        jLabel4 = new javax.swing.JLabel();
        rbtnDía2 = new javax.swing.JRadioButton();
        rbtnSemana2 = new javax.swing.JRadioButton();
        rbtnMes2 = new javax.swing.JRadioButton();
        btnExportrRep = new javax.swing.JButton();
        btnFiltarRepEnvi = new javax.swing.JButton();
        btnFiltarRepEntra = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        btnlimpiar2 = new javax.swing.JButton();

        setClosable(true);
        setMaximizable(true);
        setTitle("Ver Reportes");

        jLabel2.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel2.setText("Reporte de envios:");

        jLabel3.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel3.setText("Reporte de entradas:");

        jtblEntradaRep.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Id", "Gaveta", "Proveedor", "Producto", "Cantidad", "Fecha Entrante"
            }
        ));
        jScrollPane1.setViewportView(jtblEntradaRep);

        jtblEnvioRep.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Id Envío", "ID Gaveta", "Supermercado", "Producto", "Cantidad", "Fecha de envío"
            }
        ));
        jScrollPane2.setViewportView(jtblEnvioRep);

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 20)); // NOI18N
        jLabel1.setText("Reportes por:");

        rbgRepEnvi.add(rbtnMes);
        rbtnMes.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        rbtnMes.setText("Mes");
        rbtnMes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtnMesActionPerformed(evt);
            }
        });

        rbgRepEnvi.add(rbtnDía);
        rbtnDía.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        rbtnDía.setText("Día");
        rbtnDía.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtnDíaActionPerformed(evt);
            }
        });

        rbgRepEnvi.add(rbtnSemana);
        rbtnSemana.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        rbtnSemana.setText("Semana");
        rbtnSemana.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtnSemanaActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 20)); // NOI18N
        jLabel4.setText("Reportes por:");

        rbgRepEntra.add(rbtnDía2);
        rbtnDía2.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        rbtnDía2.setText("Día");

        rbgRepEntra.add(rbtnSemana2);
        rbtnSemana2.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        rbtnSemana2.setText("Semana");
        rbtnSemana2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtnSemana2ActionPerformed(evt);
            }
        });

        rbgRepEntra.add(rbtnMes2);
        rbtnMes2.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        rbtnMes2.setText("Mes");
        rbtnMes2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtnMes2ActionPerformed(evt);
            }
        });

        btnExportrRep.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        btnExportrRep.setText("Exportar PDF");

        btnFiltarRepEnvi.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        btnFiltarRepEnvi.setText("Filtrar");
        btnFiltarRepEnvi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFiltarRepEnviActionPerformed(evt);
            }
        });

        btnFiltarRepEntra.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        btnFiltarRepEntra.setText("Filtrar");
        btnFiltarRepEntra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFiltarRepEntraActionPerformed(evt);
            }
        });

        btnLimpiar.setText("Limpiar");
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });

        btnlimpiar2.setText("Limpiar");
        btnlimpiar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnlimpiar2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(56, 56, 56)
                                .addComponent(rbtnDía)
                                .addGap(18, 18, 18)
                                .addComponent(rbtnSemana)
                                .addGap(18, 18, 18)
                                .addComponent(rbtnMes)
                                .addGap(18, 18, 18)
                                .addComponent(btnLimpiar))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(53, 53, 53)
                                .addComponent(rbtnDía2)
                                .addGap(18, 18, 18)
                                .addComponent(rbtnSemana2)
                                .addGap(18, 18, 18)
                                .addComponent(rbtnMes2)
                                .addGap(18, 18, 18)
                                .addComponent(btnlimpiar2))
                            .addComponent(jLabel3)
                            .addComponent(btnExportrRep, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnFiltarRepEntra, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnFiltarRepEnvi, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 964, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(40, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(rbtnMes)
                            .addComponent(rbtnDía)
                            .addComponent(rbtnSemana)
                            .addComponent(btnLimpiar)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(btnFiltarRepEnvi, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(rbtnDía2)
                            .addComponent(rbtnSemana2)
                            .addComponent(rbtnMes2)
                            .addComponent(btnlimpiar2))
                        .addGap(5, 5, 5)
                        .addComponent(jLabel3))
                    .addComponent(btnFiltarRepEntra, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(btnExportrRep, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void rbtnMesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtnMesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rbtnMesActionPerformed

    private void rbtnSemanaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtnSemanaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rbtnSemanaActionPerformed

    private void rbtnSemana2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtnSemana2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rbtnSemana2ActionPerformed

    private void rbtnMes2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtnMes2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rbtnMes2ActionPerformed

    private void btnFiltarRepEnviActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFiltarRepEnviActionPerformed
        DefaultTableModel modelo = (DefaultTableModel) jtblEnvioRep.getModel();
        Controlador_Envios enviRep = new Controlador_Envios();
        modelo = enviRep.obtenerDatosVistaEnvio();
        String seleccion = "";
        if (rbtnDía.isSelected()) {
            seleccion = rbtnDía.getText();
        } else if (rbtnSemana.isSelected()) {
            seleccion = rbtnSemana.getText();
        } else if (rbtnMes.isSelected()) {
            seleccion = rbtnMes.getText();
        }

        modelo = enviRep.filtrarEnviosPorFecha(seleccion);
        jtblEnvioRep.setModel(modelo);
    }//GEN-LAST:event_btnFiltarRepEnviActionPerformed

    private void btnFiltarRepEntraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFiltarRepEntraActionPerformed
        DefaultTableModel modelo2 = (DefaultTableModel) jtblEntradaRep.getModel();
        
        Controlador_Entradas_Inventario repEntra = new Controlador_Entradas_Inventario();
        modelo2 = repEntra.obtenerDatosVistaEntrada();
        String seleccion = "";
        if (rbtnDía2.isSelected()) {
            seleccion = rbtnDía2.getText();
        } else if (rbtnSemana2.isSelected()) {
            seleccion = rbtnSemana2.getText();
        } else if (rbtnMes2.isSelected()) {
            seleccion = rbtnMes2.getText();
        }
        modelo2 = repEntra.filtrarEntradasPorFecha(seleccion);
        jtblEntradaRep.setModel(modelo2);
    }//GEN-LAST:event_btnFiltarRepEntraActionPerformed

    private void rbtnDíaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtnDíaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rbtnDíaActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        cargarDatos();
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void btnlimpiar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnlimpiar2ActionPerformed
        cargarDatos();
    }//GEN-LAST:event_btnlimpiar2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnExportrRep;
    private javax.swing.JButton btnFiltarRepEntra;
    private javax.swing.JButton btnFiltarRepEnvi;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton btnlimpiar2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jtblEntradaRep;
    private javax.swing.JTable jtblEnvioRep;
    private javax.swing.ButtonGroup rbgRepEntra;
    private javax.swing.ButtonGroup rbgRepEnvi;
    private javax.swing.JRadioButton rbtnDía;
    private javax.swing.JRadioButton rbtnDía2;
    private javax.swing.JRadioButton rbtnMes;
    private javax.swing.JRadioButton rbtnMes2;
    private javax.swing.JRadioButton rbtnSemana;
    private javax.swing.JRadioButton rbtnSemana2;
    // End of variables declaration//GEN-END:variables
}
