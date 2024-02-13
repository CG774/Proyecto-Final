/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package DIU;

import DIU.Controlador.Controlador_Envios_General;
import DIU.Modelo.Modelo_Envios_General;
import java.sql.Date;
import java.util.Calendar;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author carlo
 */
public class Envíos_Generales extends javax.swing.JInternalFrame {

    
    public Envíos_Generales() {
        initComponents();
        cargarDatos();
    }
    public void cargarDatos(){
        DefaultTableModel modelo = (DefaultTableModel) jtblEnviosGene.getModel();
        Controlador_Envios_General conSuper = new Controlador_Envios_General();
        modelo = conSuper.obtenerEnviosGenerales();
        jtblEnviosGene.setModel(modelo);
    }
     public boolean validarData(String nombre, Date fecha) {
        String regexLetras = "^[a-zA-Z]+$";

        if (nombre == null || !nombre.matches(regexLetras)) {
            JOptionPane.showMessageDialog(null, "Error: El nombre solo debe contener letras.", "Error de Validación", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        Calendar calendar = Calendar.getInstance();
        Date fechaActual = new Date(calendar.getTime().getTime());

        if (fecha != null && fecha.after(fechaActual)) {
            JOptionPane.showMessageDialog(null, "Error: La fecha debe ser menor o igual a la actual.", "Error de Validación", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        return true;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtNombreSuperEnvios = new javax.swing.JTextField();
        btnAgregarEnGe = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtblEnviosGene = new javax.swing.JTable();
        JspFechas = new javax.swing.JSpinner();
        lblFecha = new javax.swing.JLabel();

        setClosable(true);
        setMaximizable(true);

        jLabel2.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel2.setText("Ingrese el nombre del supermercado:");

        btnAgregarEnGe.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        btnAgregarEnGe.setText("Agregar");
        btnAgregarEnGe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarEnGeActionPerformed(evt);
            }
        });

        jtblEnviosGene.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID Envío", "ID Gaveta", "Supermercado", "Cantidad"
            }
        ));
        jScrollPane1.setViewportView(jtblEnviosGene);

        Calendar calendar = Calendar.getInstance();
        calendar.set(2024, Calendar.FEBRUARY, 10);

        SpinnerDateModel model = new SpinnerDateModel(calendar.getTime(), null, null, Calendar.DAY_OF_MONTH);

        JSpinner jSpinner = new JSpinner(model);

        JSpinner.DateEditor dateEditor = new JSpinner.DateEditor(jSpinner, "dd/MM/yyyy");
        jSpinner.setEditor(dateEditor);

        JspFechas.setModel(model);
        JspFechas.setEditor(dateEditor);

        lblFecha.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        lblFecha.setText("Fecha:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(JspFechas, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtNombreSuperEnvios, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(478, 478, 478)
                                .addComponent(btnAgregarEnGe, javax.swing.GroupLayout.DEFAULT_SIZE, 146, Short.MAX_VALUE)))
                        .addGap(20, 20, 20))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtNombreSuperEnvios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(btnAgregarEnGe, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblFecha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(JspFechas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 372, javax.swing.GroupLayout.PREFERRED_SIZE)
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
        DefaultTableModel modelo = (DefaultTableModel) jtblEnviosGene.getModel();
        Modelo_Envios_General moEnGe = new Modelo_Envios_General();
        Controlador_Envios_General conEnGe = new Controlador_Envios_General();

        String nombre = txtNombreSuperEnvios.getText();
        int idSupermerca = conEnGe.obtenerIdSupermercadoPorNombre(nombre);
        java.util.Date fechaSeleccionada = (java.util.Date) JspFechas.getValue();
        java.sql.Date fechaSql = new java.sql.Date(fechaSeleccionada.getTime());
        moEnGe.setId_supermercado(idSupermerca);
        moEnGe.setFecha(fechaSql);
        if (validarData(nombre, fechaSql)) {
            conEnGe.agregarEnvioGeneral(moEnGe.getId_supermercado(), (Date) moEnGe.getFecha());
            modelo = conEnGe.obtenerEnviosGenerales();
            jtblEnviosGene.setModel(modelo);
        }
    }//GEN-LAST:event_btnAgregarEnGeActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JSpinner JspFechas;
    private javax.swing.JButton btnAgregarEnGe;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jtblEnviosGene;
    private javax.swing.JLabel lblFecha;
    private javax.swing.JTextField txtNombreSuperEnvios;
    // End of variables declaration//GEN-END:variables
}
