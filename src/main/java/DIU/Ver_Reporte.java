/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package DIU;

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
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

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
        btnFiltarRep = new javax.swing.JButton();
        btnFiltarRep3 = new javax.swing.JButton();

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

        rbtnMes.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        rbtnMes.setText("Mes");
        rbtnMes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtnMesActionPerformed(evt);
            }
        });

        rbtnDía.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        rbtnDía.setText("Día");

        rbtnSemana.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        rbtnSemana.setText("Semana");
        rbtnSemana.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtnSemanaActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 20)); // NOI18N
        jLabel4.setText("Reportes por:");

        rbtnDía2.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        rbtnDía2.setText("Día");

        rbtnSemana2.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        rbtnSemana2.setText("Semana");
        rbtnSemana2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtnSemana2ActionPerformed(evt);
            }
        });

        rbtnMes2.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        rbtnMes2.setText("Mes");
        rbtnMes2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtnMes2ActionPerformed(evt);
            }
        });

        btnExportrRep.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        btnExportrRep.setText("Exportar PDF");

        btnFiltarRep.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        btnFiltarRep.setText("Filtrar");

        btnFiltarRep3.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        btnFiltarRep3.setText("Filtrar");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(56, 56, 56)
                                .addComponent(rbtnDía)
                                .addGap(18, 18, 18)
                                .addComponent(rbtnSemana)
                                .addGap(18, 18, 18)
                                .addComponent(rbtnMes))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(53, 53, 53)
                                .addComponent(rbtnDía2)
                                .addGap(18, 18, 18)
                                .addComponent(rbtnSemana2)
                                .addGap(18, 18, 18)
                                .addComponent(rbtnMes2))
                            .addComponent(jLabel3)
                            .addComponent(btnExportrRep, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 563, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnFiltarRep3, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnFiltarRep, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane2)
                    .addComponent(jScrollPane1))
                .addContainerGap(20, Short.MAX_VALUE))
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
                        .addGap(23, 23, 23)
                        .addComponent(btnFiltarRep, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)))
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
                            .addComponent(rbtnMes2))
                        .addGap(5, 5, 5)
                        .addComponent(jLabel3))
                    .addComponent(btnFiltarRep3, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
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


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnExportrRep;
    private javax.swing.JButton btnFiltarRep;
    private javax.swing.JButton btnFiltarRep3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jtblEntradaRep;
    private javax.swing.JTable jtblEnvioRep;
    private javax.swing.JRadioButton rbtnDía;
    private javax.swing.JRadioButton rbtnDía2;
    private javax.swing.JRadioButton rbtnMes;
    private javax.swing.JRadioButton rbtnMes2;
    private javax.swing.JRadioButton rbtnSemana;
    private javax.swing.JRadioButton rbtnSemana2;
    // End of variables declaration//GEN-END:variables
}
