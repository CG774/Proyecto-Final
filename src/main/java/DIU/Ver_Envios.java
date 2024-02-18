/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package DIU;

import DIU.Controlador.ConexionBDD;
import DIU.Controlador.Controlador_Envios;
import DIU.Controlador.Controlador_Gavetas;
import DIU.Controlador.Controlador_Productos;
import DIU.Modelo.Modelo_Envios;
import java.awt.Color;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
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
public class Ver_Envios extends javax.swing.JInternalFrame {

    /**
     * Creates new form Ver_Envios
     */
    public Ver_Envios() {
        initComponents();
        Controlador_Productos conProd = new Controlador_Productos();
        List<String> nombresProductos = conProd.obtenerNombresProductos();
        jcProductos.removeAllItems(); // Limpiar el JComboBox antes de añadir nuevos elementos

        for (String nombre : nombresProductos) {
            jcProductos.addItem(nombre);
        }
        cargarDatos();
    }

    ConexionBDD conexion = new ConexionBDD();
    //OBJETO 
    Connection conectado = (Connection) conexion.conectar();
    //DOWNCASTING
    PreparedStatement sesion;
    ResultSet res;
    Statement stmt;

    public void cargarDatos() {
        DefaultTableModel modelo = (DefaultTableModel) jtbEnvios.getModel();
        Controlador_Envios conEnvio = new Controlador_Envios();
        modelo = conEnvio.obtenerDatosVistaEnvio();
        jtbEnvios.setModel(modelo);
    }

    public boolean validarEnvio(Modelo_Envios modeloEnvio, String textoCantidad) {
        Controlador_Gavetas cg = new Controlador_Gavetas();
        int estadoGaveta = cg.obtenerEstadoGavetaPorId(modeloEnvio.getId_gaveta());
        if (estadoGaveta == 2) {
            JOptionPane.showMessageDialog(null, "La gaveta seleccionada no está disponible.", "Error de Validación", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if (modeloEnvio.getId_producto() <= 0) {
            JOptionPane.showMessageDialog(null, "El producto seleccionado no es válido.", "Error de Validación", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if (modeloEnvio.getId_gaveta() <= 0) {
            JOptionPane.showMessageDialog(null, "La gaveta seleccionada no es válida.", "Error de Validación", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        try {
            BigDecimal cantidadKg = new BigDecimal(textoCantidad);
            if (cantidadKg.compareTo(BigDecimal.ZERO) <= 0) {
                throw new NumberFormatException("La cantidad debe ser mayor que cero.");
            }
            modeloEnvio.setCantidad_kg(cantidadKg);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Por favor, introduce un número válido para la cantidad: ", "Error de formato", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtbEnvios = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtCodigoGaveta = new javax.swing.JTextField();
        txtCantidad = new javax.swing.JTextField();
        btnAgregarEG = new javax.swing.JButton();
        jcProductos = new javax.swing.JComboBox<>();

        setClosable(true);
        setMaximizable(true);
        setTitle("Envios");

        jPanel1.setBackground(new java.awt.Color(255, 246, 137));

        jtbEnvios.setBackground(new java.awt.Color(86, 84, 15));
        jtbEnvios.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jtbEnvios.setForeground(new java.awt.Color(255, 255, 255));
        jtbEnvios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(jtbEnvios);

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel1.setText("Ingrese el codigo de la gaveta:");

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel2.setText("Nombre del producto a enviar:");

        jLabel3.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel3.setText("Cantidad en  KG:");

        txtCodigoGaveta.setBackground(new java.awt.Color(86, 84, 15));
        txtCodigoGaveta.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        txtCodigoGaveta.setForeground(new java.awt.Color(255, 255, 255));

        txtCantidad.setBackground(new java.awt.Color(86, 84, 15));
        txtCantidad.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        txtCantidad.setForeground(new java.awt.Color(255, 255, 255));
        txtCantidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCantidadActionPerformed(evt);
            }
        });
        txtCantidad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCantidadKeyTyped(evt);
            }
        });

        btnAgregarEG.setBackground(new java.awt.Color(86, 84, 15));
        btnAgregarEG.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btnAgregarEG.setForeground(new java.awt.Color(255, 255, 255));
        btnAgregarEG.setText("Agregar");
        btnAgregarEG.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarEGActionPerformed(evt);
            }
        });

        jcProductos.setBackground(new java.awt.Color(86, 84, 15));
        jcProductos.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jcProductos.setForeground(new java.awt.Color(255, 255, 255));
        jcProductos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-elegir-" }));
        jcProductos.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jcProductosFocusGained(evt);
            }
        });
        jcProductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcProductosActionPerformed(evt);
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
                        .addComponent(jScrollPane2)
                        .addGap(42, 42, 42))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtCodigoGaveta, javax.swing.GroupLayout.DEFAULT_SIZE, 156, Short.MAX_VALUE)
                            .addComponent(jcProductos, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(33, 33, 33)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnAgregarEG, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(btnAgregarEG, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtCodigoGaveta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)
                            .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(29, 29, 29)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jcProductos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 433, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtCantidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCantidadActionPerformed

    }//GEN-LAST:event_txtCantidadActionPerformed

    private void btnAgregarEGActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarEGActionPerformed
        try {
            Controlador_Productos productControl = new Controlador_Productos();
            Controlador_Envios enviosControl = new Controlador_Envios();
            Controlador_Gavetas gavetasControl = new Controlador_Gavetas();

            String nombreProducto = jcProductos.getSelectedItem().toString();
            Modelo_Envios modeloEnvio = new Modelo_Envios();

            int idProducto = productControl.obtenerIdPorNombre(nombreProducto);
            int idGaveta = gavetasControl.obtenerIdGavetaPorCodigo(txtCodigoGaveta.getText());
            modeloEnvio.setId_producto(idProducto);
            modeloEnvio.setId_gaveta(idGaveta);
            String textoCantidad = txtCantidad.getText();

            int idEnvioGeneral = enviosControl.obtenerIdUltimoEnvioGeneral();
            modeloEnvio.setId_envio_general(idEnvioGeneral);

            if (!validarEnvio(modeloEnvio, textoCantidad)) {
                return;
            }

            enviosControl.agregarEnvio(modeloEnvio);
            cargarDatos();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Por favor, introduce un codigo de gaveta existente", "Error de formato", JOptionPane.ERROR_MESSAGE);

        }

    }//GEN-LAST:event_btnAgregarEGActionPerformed

    private void txtCantidadKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCantidadKeyTyped


    }//GEN-LAST:event_txtCantidadKeyTyped

    private void jcProductosFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jcProductosFocusGained

    }//GEN-LAST:event_jcProductosFocusGained

    private void jcProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcProductosActionPerformed

    }//GEN-LAST:event_jcProductosActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregarEG;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JComboBox<String> jcProductos;
    private javax.swing.JTable jtbEnvios;
    private javax.swing.JTextField txtCantidad;
    private javax.swing.JTextField txtCodigoGaveta;
    // End of variables declaration//GEN-END:variables

    private boolean validarDecimal(String decimal) {
        String regex = "^-?\\d+(\\.\\d+)?$";
        Pattern pat = Pattern.compile(regex);

        Matcher mat = pat.matcher(decimal);
        if (mat.matches()) { // Usar matches() para validar la cadena completa
            txtCantidad.setForeground(Color.black); // Decimal válido en color negro
            return true; // Retorna true si el patrón coincide, es decir, es un decimal válido
        } else {
            txtCantidad.setForeground(Color.red); // Decimal inválido en color rojo
            return false; // Retorna false si no coincide, es decir, no es un decimal válido
        }
    }

    private void limmpiar() {
        txtCantidad.setText("");
        txtCodigoGaveta.setText("");

    }

    public boolean comprobarEstadoGaveta(int idGaveta) {
        String consulta = "SELECT id, id_estado FROM gavetas WHERE id = ?"; // Consulta ajustada para seleccionar también id_estado

        try (PreparedStatement ejecutar = conectado.prepareStatement(consulta)) {
            ejecutar.setInt(1, idGaveta);

            try (ResultSet resul = ejecutar.executeQuery()) {
                // Verifica si el resultado está presente y el estado es 1
                if (resul.next() && resul.getInt("id_estado") == 1) {
                    return true; // La gaveta está disponible
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al comprobar el estado de la gaveta: " + e.getMessage());
        }

        return false; // La gaveta no está disponible o ocurrió un error
    }

}
