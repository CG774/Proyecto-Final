/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package DIU;

import DIU.Controlador.ConexionBDD;
import DIU.Controlador.Controlador_Envios;
import DIU.Controlador.Controlador_Productos;
import DIU.Modelo.Modelo_Envios;
import java.awt.Color;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
        mostrarTabla("");
    }

    ConexionBDD conexion = new ConexionBDD();
    //OBJETO 
    Connection conectado = (Connection) conexion.conectar();
    //DOWNCASTING
    PreparedStatement sesion;
    ResultSet res;
    Statement stmt;

    public void mostrarTabla(String fecha) {
        // Inicializa el modelo para la tabla
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("ID_ENVIO");
        modelo.addColumn("PRODUCTO");
        modelo.addColumn("ID_GAVETA");
        modelo.addColumn("CANTIDAD_KILOGRAMOS");
        modelo.addColumn("ID_ENVIO_GENERAL");
        modelo.addColumn("FECHA");

        // Obtiene la conexión a la base de datos
        ConexionBDD con = new ConexionBDD();
        Connection conexion = con.conectar();

        PreparedStatement ps = null;
        ResultSet rs = null;

        String consulta;

        try {
            // Decide la consulta a ejecutar basada en si el nombre es proporcionado
            if ("".equals(fecha)) {
                consulta = "SELECT * FROM vista_envios order by id_envio desc";
                ps = conexion.prepareStatement(consulta);
            } else {
                consulta = "SELECT * FROM  vista_envios WHERE fecha_envio = ? order by id_envio desc";
                ps = conexion.prepareStatement(consulta);
                ps.setString(1, fecha);

            }

            // Ejecuta la consulta
            rs = ps.executeQuery();

            // Procesa los resultados
            while (rs.next()) {
                Object[] fila = new Object[6];
                fila[0] = rs.getInt("id_envio");
                fila[1] = rs.getString("nombre_producto");
                fila[2] = rs.getInt("id_gaveta");
                fila[3] = rs.getBigDecimal("cantidad_en_kg");
                fila[4] = rs.getInt("id_envio_general");
                fila[5] = rs.getDate("fecha_envio");
                modelo.addRow(fila); // Añade la fila al modelo de la tabla
            }

            // Establece el modelo en la JTable (Asume que jtbProducto es tu JTable)
            jtbEnvios.setModel(modelo);

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al obtener datos de productos: " + e.getMessage());
        } finally {
            // Cierra los recursos
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (conexion != null) {
                    conexion.close();
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error al cerrar conexiones: " + e.getMessage());
            }
        }

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
        txtIdGaveta = new javax.swing.JTextField();
        txtProducto = new javax.swing.JTextField();
        txtCantidad = new javax.swing.JTextField();
        btnAgregarEG = new javax.swing.JButton();

        setClosable(true);
        setMaximizable(true);
        setTitle("Envios");

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

        jLabel1.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel1.setText("Inrese el id de la gaveta:");

        jLabel2.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel2.setText("nombre del producto a enviar");

        jLabel3.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel3.setText("Cantidad en  KG:");

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

        btnAgregarEG.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        btnAgregarEG.setText("Agregar");
        btnAgregarEG.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarEGActionPerformed(evt);
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
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtIdGaveta, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(70, 70, 70)
                        .addComponent(btnAgregarEG, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 947, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(40, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtIdGaveta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)
                            .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(23, 23, 23))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(btnAgregarEG, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 410, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40))
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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtCantidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCantidadActionPerformed

    }//GEN-LAST:event_txtCantidadActionPerformed

    private void btnAgregarEGActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarEGActionPerformed

        try {
            String nombreProducto = txtProducto.getText();
            Controlador_Productos productControl = new Controlador_Productos();
            Controlador_Envios enviosControl = new Controlador_Envios();

            int idProducto = productControl.obtenerIdPorNombreProducto(nombreProducto);

            int idGaveta = Integer.parseInt(txtIdGaveta.getText());

            // Comprobar si el ID de la gaveta existe y está disponible
            boolean gavetaExiste = enviosControl.comprobarIdExiste(idGaveta);
            boolean gavetaDisponible = enviosControl.comprobarEstadoGaveta(idGaveta);

            if (gavetaExiste && gavetaDisponible) {
                if (validarDecimal(txtCantidad.getText())) { 
                    BigDecimal numeroDecimal = new BigDecimal(txtCantidad.getText());
                    int envioGen = enviosControl.obtenerIdUltimoEnvioGeneral();

                    Modelo_Envios modeloEnvio = new Modelo_Envios(0, idProducto, idGaveta, numeroDecimal, envioGen);
                    enviosControl.AgregarEnvio(modeloEnvio);
                } else {
                    //cantidad no es un decimal válido
                    JOptionPane.showMessageDialog(null, "La cantidad proporcionada no es un número decimal válido.");
                }
            } else {
                //la gaveta no existe o no está disponible
                JOptionPane.showMessageDialog(null, "La gaveta no existe o no está disponible.");
            }
        } catch (NumberFormatException e) {
            // Manejar el error de formato numérico incorrecto, por ejemplo, en el ID de la gaveta
            JOptionPane.showMessageDialog(null, "Error en el formato del número: " + e.getMessage());
        } catch (Exception e) {
            // Manejar cualquier otro error no esperado
            JOptionPane.showMessageDialog(null, "Error al agregar el envío: " + e.getMessage());
        }

        limmpiar();
        mostrarTabla("");
    }//GEN-LAST:event_btnAgregarEGActionPerformed

    private void txtCantidadKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCantidadKeyTyped


    }//GEN-LAST:event_txtCantidadKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregarEG;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jtbEnvios;
    private javax.swing.JTextField txtCantidad;
    private javax.swing.JTextField txtIdGaveta;
    private javax.swing.JTextField txtProducto;
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
        txtIdGaveta.setText("");
        txtProducto.setText("");
    }

}
