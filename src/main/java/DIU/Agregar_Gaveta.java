/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package DIU;

import DIU.Controlador.Controlador_Estados_GA;
import DIU.Controlador.Controlador_Gavetas;
import DIU.Modelo.Modelo_Estados_GA;
import DIU.Modelo.Modelo_Gavetas;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author carlo
 */
public class Agregar_Gaveta extends javax.swing.JInternalFrame {

    /**
     * Creates new form Agregar_Gaveta
     */
    public Agregar_Gaveta() {
        initComponents();
        cargarDatos();
    }

    public void cargarDatos() {
        DefaultTableModel modelo = (DefaultTableModel) JtablaGavta.getModel();
        Controlador_Gavetas conGaveta = new Controlador_Gavetas();
        modelo = conGaveta.obtenerTodasLasGavetas();
        JtablaGavta.setModel(modelo);
    }

    public int obtenerIdProductoSeleccionado() {
        int filaSeleccionada = JtablaGavta.getSelectedRow();
        int idGav = 0;
        String cod = "";
        Controlador_Gavetas conGav = new Controlador_Gavetas();
        if (filaSeleccionada != -1) {
            DefaultTableModel modelo = (DefaultTableModel) JtablaGavta.getModel();
            cod = (String) modelo.getValueAt(filaSeleccionada, 0);
            idGav = conGav.obtenerIdGavetaPorCodigo(cod);
            return idGav;
        } else {
            return -1;
        }
    }

    public boolean validarGaveta(Modelo_Gavetas gaveta) {
        String regexLetras = "^[a-zA-Z]+$";

        String color = gaveta.getColor();
        if (color == null || !color.matches(regexLetras)) {
            JOptionPane.showMessageDialog(null, "Error: El color solo debe contener letras.", "Error de Validación", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }

    private void limpiarFormulario() {
        txtColorG.setText("");
        txtPesoG.setText("");
        jrbtnPequeño.setSelected(false);
        jrbtnMediano.setSelected(false);
        jrbtnGrande.setSelected(false);
        jcbSi.setSelected(false);
        jcbNo.setSelected(false);
    }

    private boolean isNumeric(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btngUnidades = new javax.swing.ButtonGroup();
        btngTamanios = new javax.swing.ButtonGroup();
        btngPropiedad = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        JtablaGavta = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtPesoG = new javax.swing.JTextField();
        jrbtnMediano = new javax.swing.JRadioButton();
        jrbtnPequeño = new javax.swing.JRadioButton();
        jcbSi = new javax.swing.JCheckBox();
        jrbtnGrande = new javax.swing.JRadioButton();
        jcbNo = new javax.swing.JCheckBox();
        btnAgregarG = new javax.swing.JButton();
        btnEditarrG = new javax.swing.JButton();
        txtColorG = new javax.swing.JTextField();

        setClosable(true);
        setMaximizable(true);
        setTitle("Agregar Gaveta");

        jPanel1.setBackground(new java.awt.Color(255, 246, 137));

        JtablaGavta.setBackground(new java.awt.Color(86, 84, 15));
        JtablaGavta.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        JtablaGavta.setForeground(new java.awt.Color(255, 255, 255));
        JtablaGavta.setModel(new javax.swing.table.DefaultTableModel(
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
                {null, null, null, null, null, null}
            },
            new String [] {
                "Código Gaveta", "Color", "Tamaño", "Peso Máximo", "Propiedad Interna", "Estado"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(JtablaGavta);

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel1.setText("Color:");

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel2.setText("Peso Máximo(Kg):");

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel3.setText("¿Es Propia de la Empresa?:");

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel4.setText("Tamaño:");

        txtPesoG.setBackground(new java.awt.Color(86, 84, 15));
        txtPesoG.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        txtPesoG.setForeground(new java.awt.Color(255, 255, 255));

        jrbtnMediano.setBackground(new java.awt.Color(86, 84, 15));
        btngTamanios.add(jrbtnMediano);
        jrbtnMediano.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jrbtnMediano.setForeground(new java.awt.Color(255, 255, 255));
        jrbtnMediano.setText("Mediana");
        jrbtnMediano.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrbtnMedianoActionPerformed(evt);
            }
        });

        jrbtnPequeño.setBackground(new java.awt.Color(86, 84, 15));
        btngTamanios.add(jrbtnPequeño);
        jrbtnPequeño.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jrbtnPequeño.setForeground(new java.awt.Color(255, 255, 255));
        jrbtnPequeño.setText("Pequeña");

        jcbSi.setBackground(new java.awt.Color(86, 84, 15));
        btngPropiedad.add(jcbSi);
        jcbSi.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jcbSi.setForeground(new java.awt.Color(255, 255, 255));
        jcbSi.setText("Si");
        jcbSi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbSiActionPerformed(evt);
            }
        });

        jrbtnGrande.setBackground(new java.awt.Color(86, 84, 15));
        btngTamanios.add(jrbtnGrande);
        jrbtnGrande.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jrbtnGrande.setForeground(new java.awt.Color(255, 255, 255));
        jrbtnGrande.setText("Grande");

        jcbNo.setBackground(new java.awt.Color(86, 84, 15));
        btngPropiedad.add(jcbNo);
        jcbNo.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jcbNo.setForeground(new java.awt.Color(255, 255, 255));
        jcbNo.setText("No");
        jcbNo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbNoActionPerformed(evt);
            }
        });

        btnAgregarG.setBackground(new java.awt.Color(86, 84, 15));
        btnAgregarG.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btnAgregarG.setForeground(new java.awt.Color(255, 255, 255));
        btnAgregarG.setIcon(new javax.swing.ImageIcon("C:\\Users\\carlo\\Documents\\IST 17J\\Semestre 3\\Programacion visual\\Proyecto-Final\\src\\main\\resource\\Imagenes\\Agregar.png")); // NOI18N
        btnAgregarG.setText("Agregar");
        btnAgregarG.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarGActionPerformed(evt);
            }
        });

        btnEditarrG.setBackground(new java.awt.Color(86, 84, 15));
        btnEditarrG.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btnEditarrG.setForeground(new java.awt.Color(255, 255, 255));
        btnEditarrG.setIcon(new javax.swing.ImageIcon("C:\\Users\\carlo\\Documents\\IST 17J\\Semestre 3\\Programacion visual\\Proyecto-Final\\src\\main\\resource\\Imagenes\\Editar.png")); // NOI18N
        btnEditarrG.setText("Editar");
        btnEditarrG.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarrGActionPerformed(evt);
            }
        });

        txtColorG.setBackground(new java.awt.Color(86, 84, 15));
        txtColorG.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        txtColorG.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 995, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(25, 25, 25)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtPesoG, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtColorG, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(100, 100, 100)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jrbtnPequeño, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jcbSi, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jcbNo, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jrbtnMediano, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jrbtnGrande, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(177, 177, 177))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnEditarrG, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40)
                        .addComponent(btnAgregarG, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(72, 72, 72))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtColorG, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jrbtnPequeño)
                    .addComponent(jrbtnMediano)
                    .addComponent(jrbtnGrande))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtPesoG, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jcbSi)
                            .addComponent(jcbNo))))
                .addGap(20, 20, 20)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 310, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAgregarG, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEditarrG, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20))
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

    private void jcbSiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbSiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jcbSiActionPerformed

    private void jcbNoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbNoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jcbNoActionPerformed

    private void jrbtnMedianoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrbtnMedianoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jrbtnMedianoActionPerformed

    private void btnEditarrGActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarrGActionPerformed
        DefaultTableModel modelo = (DefaultTableModel) JtablaGavta.getModel();
        Modelo_Estados_GA moEsGa = new Modelo_Estados_GA();
        Controlador_Gavetas conGavetas = new Controlador_Gavetas();
        Controlador_Estados_GA conEsGa = new Controlador_Estados_GA();
        Modelo_Estados_GA moEstaGa = new Modelo_Estados_GA();
        Modelo_Gavetas moGa = new Modelo_Gavetas();
        int fila = JtablaGavta.getSelectedRow();
        int idGa = obtenerIdProductoSeleccionado();

        if (idGa == -1) {
            JOptionPane.showMessageDialog(rootPane, "POR FAVOR SELECCIONE CON UN PRODUCTO");
            return;
        }

        moGa.setId(idGa);
        moGa.setCodigo((String) JtablaGavta.getValueAt(fila, 0));
        moGa.setColor(JtablaGavta.getValueAt(fila, 1).toString().toUpperCase());
        moGa.setTamanio(JtablaGavta.getValueAt(fila, 2).toString().toUpperCase());

        Object pesoMaximoObj = JtablaGavta.getValueAt(fila, 3);
        if (pesoMaximoObj instanceof Number || isNumeric(pesoMaximoObj.toString())) {
            moGa.setPesoMaximo(Double.parseDouble(pesoMaximoObj.toString()));
        } else {
            JOptionPane.showMessageDialog(rootPane, "El valor de peso_maximo no es un número válido.");
            return;
        }

        moGa.setEsPropia(JtablaGavta.getValueAt(fila, 4).toString().toUpperCase());

        String idEstado = (String) JtablaGavta.getValueAt(fila, 5);
        moEstaGa.setDescripcion(idEstado);
        int id = conEsGa.ObtenerIdEstadoPorDescripcion(moEstaGa);
        if (id == 1 || id == 2 ) {
            moEsGa.setIdEstado(id);
        } else {
            JOptionPane.showMessageDialog(rootPane, "El valor de id estado no es válido.");
            return;
        }

        moGa.setIdEstado(moEsGa);
        conGavetas.actualizarGaveta(moGa);
        modelo = conGavetas.obtenerTodasLasGavetas();
        JtablaGavta.setModel(modelo);

    }//GEN-LAST:event_btnEditarrGActionPerformed

    private void btnAgregarGActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarGActionPerformed
        DefaultTableModel modelo = (DefaultTableModel) JtablaGavta.getModel();
        Modelo_Estados_GA moEstaGa = new Modelo_Estados_GA();
        Modelo_Gavetas moGa = new Modelo_Gavetas();
        Controlador_Estados_GA conEstaGa = new Controlador_Estados_GA();
        Controlador_Gavetas conGa = new Controlador_Gavetas();
        moEstaGa.setDescripcion("DISPONIBLE");
        moEstaGa.setIdEstado(conEstaGa.ObtenerIdEstadoPorDescripcion(moEstaGa));
        String color = txtColorG.getText();
        String tamaño = "";

        if (jrbtnPequeño.isSelected()) {
            tamaño = "Pequeño";
        } else if (jrbtnMediano.isSelected()) {
            tamaño = "Mediano";
        } else if (jrbtnGrande.isSelected()) {
            tamaño = "Grande";
        }

        double pesoMaximo = 0.0;

        try {
            pesoMaximo = Double.parseDouble(txtPesoG.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Error: El peso máximo debe ser un número válido.", "Error de Validación", JOptionPane.ERROR_MESSAGE);
            limpiarFormulario();
            return;
        }

        String esPropia = "";
        if (jcbSi.isSelected()) {
            esPropia = "SI";
        } else if (jcbNo.isSelected()) {
            esPropia = "NO";
        }

        moGa.setColor(color.toUpperCase());
        moGa.setEsPropia(esPropia.toUpperCase());
        moGa.setPesoMaximo(pesoMaximo);
        moGa.setTamanio(tamaño.toUpperCase());
        if (!validarGaveta(moGa)) {
            limpiarFormulario();
            return;
        }

        moGa.setIdEstado(moEstaGa);
        conGa.agregarGaveta(moGa);
        modelo = conGa.obtenerTodasLasGavetas();
        JtablaGavta.setModel(modelo);
        limpiarFormulario();
    }//GEN-LAST:event_btnAgregarGActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable JtablaGavta;
    private javax.swing.JButton btnAgregarG;
    private javax.swing.JButton btnEditarrG;
    private javax.swing.ButtonGroup btngPropiedad;
    private javax.swing.ButtonGroup btngTamanios;
    private javax.swing.ButtonGroup btngUnidades;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JCheckBox jcbNo;
    private javax.swing.JCheckBox jcbSi;
    private javax.swing.JRadioButton jrbtnGrande;
    private javax.swing.JRadioButton jrbtnMediano;
    private javax.swing.JRadioButton jrbtnPequeño;
    private javax.swing.JTextField txtColorG;
    private javax.swing.JTextField txtPesoG;
    // End of variables declaration//GEN-END:variables
}
