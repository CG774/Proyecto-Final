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
        modelo = enviRep.obtenerEnviosREP();
        jtblEnvioRep.setModel(modelo);
        
        DefaultTableModel modelo2 = (DefaultTableModel) jtblEntradaRep.getModel();
        Controlador_Entradas_Inventario repEntra = new Controlador_Entradas_Inventario();
        modelo2 = repEntra.obtenerEntradas();
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

        jPanel1.setBackground(new java.awt.Color(255, 246, 137));

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel2.setText("Reporte de envios:");

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel3.setText("Reporte de entradas:");

        jtblEntradaRep.setBackground(new java.awt.Color(86, 84, 15));
        jtblEntradaRep.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jtblEntradaRep.setForeground(new java.awt.Color(255, 255, 255));
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
                "Código Entrada", "Código Gaveta", "Proveedor", "Producto", "Cantidad", "Fecha Entrante"
            }
        ));
        jScrollPane1.setViewportView(jtblEntradaRep);

        jtblEnvioRep.setBackground(new java.awt.Color(86, 84, 15));
        jtblEnvioRep.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jtblEnvioRep.setForeground(new java.awt.Color(255, 255, 255));
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
                "Código Envío", "Código Gaveta", "Supermercado", "Producto", "Cantidad", "Fecha de envío"
            }
        ));
        jScrollPane2.setViewportView(jtblEnvioRep);

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 20)); // NOI18N
        jLabel1.setText("Reportes por:");

        rbtnMes.setBackground(new java.awt.Color(86, 84, 15));
        rbgRepEnvi.add(rbtnMes);
        rbtnMes.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        rbtnMes.setForeground(new java.awt.Color(255, 255, 255));
        rbtnMes.setText("Mes actual");
        rbtnMes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtnMesActionPerformed(evt);
            }
        });

        rbtnDía.setBackground(new java.awt.Color(86, 84, 15));
        rbgRepEnvi.add(rbtnDía);
        rbtnDía.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        rbtnDía.setForeground(new java.awt.Color(255, 255, 255));
        rbtnDía.setText("Día actual");
        rbtnDía.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtnDíaActionPerformed(evt);
            }
        });

        rbtnSemana.setBackground(new java.awt.Color(86, 84, 15));
        rbgRepEnvi.add(rbtnSemana);
        rbtnSemana.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        rbtnSemana.setForeground(new java.awt.Color(255, 255, 255));
        rbtnSemana.setText("Semana actual");
        rbtnSemana.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtnSemanaActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 20)); // NOI18N
        jLabel4.setText("Reportes por:");

        rbtnDía2.setBackground(new java.awt.Color(86, 84, 15));
        rbgRepEntra.add(rbtnDía2);
        rbtnDía2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        rbtnDía2.setForeground(new java.awt.Color(255, 255, 255));
        rbtnDía2.setText("Día actual");

        rbtnSemana2.setBackground(new java.awt.Color(86, 84, 15));
        rbgRepEntra.add(rbtnSemana2);
        rbtnSemana2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        rbtnSemana2.setForeground(new java.awt.Color(255, 255, 255));
        rbtnSemana2.setText("Semana actual");
        rbtnSemana2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtnSemana2ActionPerformed(evt);
            }
        });

        rbtnMes2.setBackground(new java.awt.Color(86, 84, 15));
        rbgRepEntra.add(rbtnMes2);
        rbtnMes2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        rbtnMes2.setForeground(new java.awt.Color(255, 255, 255));
        rbtnMes2.setText("Mes actual");
        rbtnMes2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtnMes2ActionPerformed(evt);
            }
        });

        btnExportrRep.setBackground(new java.awt.Color(86, 84, 15));
        btnExportrRep.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btnExportrRep.setForeground(new java.awt.Color(255, 255, 255));
        btnExportrRep.setIcon(new javax.swing.ImageIcon("C:\\Users\\carlo\\Documents\\IST 17J\\Semestre 3\\Programacion visual\\Proyecto-Final\\src\\main\\resource\\Imagenes\\PDF.png")); // NOI18N
        btnExportrRep.setText("Exportar PDF");

        btnFiltarRepEnvi.setBackground(new java.awt.Color(86, 84, 15));
        btnFiltarRepEnvi.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btnFiltarRepEnvi.setForeground(new java.awt.Color(255, 255, 255));
        btnFiltarRepEnvi.setIcon(new javax.swing.ImageIcon("C:\\Users\\carlo\\Documents\\IST 17J\\Semestre 3\\Programacion visual\\Proyecto-Final\\src\\main\\resource\\Imagenes\\Filtrar.png.png")); // NOI18N
        btnFiltarRepEnvi.setText("Filtrar");
        btnFiltarRepEnvi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFiltarRepEnviActionPerformed(evt);
            }
        });

        btnFiltarRepEntra.setBackground(new java.awt.Color(86, 84, 15));
        btnFiltarRepEntra.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btnFiltarRepEntra.setForeground(new java.awt.Color(255, 255, 255));
        btnFiltarRepEntra.setIcon(new javax.swing.ImageIcon("C:\\Users\\carlo\\Documents\\IST 17J\\Semestre 3\\Programacion visual\\Proyecto-Final\\src\\main\\resource\\Imagenes\\Filtrar.png.png")); // NOI18N
        btnFiltarRepEntra.setText("Filtrar");
        btnFiltarRepEntra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFiltarRepEntraActionPerformed(evt);
            }
        });

        btnLimpiar.setBackground(new java.awt.Color(86, 84, 15));
        btnLimpiar.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btnLimpiar.setForeground(new java.awt.Color(255, 255, 255));
        btnLimpiar.setText("Limpiar");
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });

        btnlimpiar2.setBackground(new java.awt.Color(86, 84, 15));
        btnlimpiar2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btnlimpiar2.setForeground(new java.awt.Color(255, 255, 255));
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
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel2)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnLimpiar))
                        .addComponent(jScrollPane1)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel1)
                                    .addGap(56, 56, 56)
                                    .addComponent(rbtnDía)
                                    .addGap(38, 38, 38)
                                    .addComponent(rbtnSemana)
                                    .addGap(27, 27, 27)
                                    .addComponent(rbtnMes))
                                .addComponent(jLabel3)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel4)
                                    .addGap(50, 50, 50)
                                    .addComponent(rbtnDía2)
                                    .addGap(37, 37, 37)
                                    .addComponent(rbtnSemana2)
                                    .addGap(34, 34, 34)
                                    .addComponent(rbtnMes2)))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(btnlimpiar2, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(btnFiltarRepEnvi, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(btnFiltarRepEntra, javax.swing.GroupLayout.Alignment.TRAILING)))
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 964, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnExportrRep))
                .addContainerGap(50, Short.MAX_VALUE))
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
                            .addComponent(rbtnSemana)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnFiltarRepEnvi, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(btnLimpiar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(rbtnDía2)
                            .addComponent(rbtnSemana2)
                            .addComponent(rbtnMes2)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(btnFiltarRepEntra, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnlimpiar2)
                            .addComponent(jLabel3))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnExportrRep, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
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
        modelo2 = repEntra.obtenerEntradas();
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
