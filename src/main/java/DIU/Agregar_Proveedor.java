/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package DIU;

import DIU.Controlador.ConexionBDD;
import DIU.Controlador.Controlador_Productos;
import DIU.Controlador.Controlador_Proveedor;
import DIU.Modelo.Modelo_Proveedor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author carlo
 */
public class Agregar_Proveedor extends javax.swing.JInternalFrame {

    private int indiceTabla;

    public Agregar_Proveedor() {
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

    public void mostrarTabla(String nombre) {
        // Inicializa el modelo para la tabla
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("NRO");
        modelo.addColumn("ID_PROVEEDOR");
        modelo.addColumn("NOMBRE_PROVEEDOR");
        modelo.addColumn("TELEFONO_PROVEEDOR");
        modelo.addColumn("PRODUCTO");

        // Obtiene la conexión a la base de datos
        ConexionBDD con = new ConexionBDD(); // Asumiendo que esto crea una conexión a la base de datos.
        Connection conexion = con.conectar();

        PreparedStatement ps = null;
        ResultSet rs = null;

        String consulta;

        try {
            // Decide la consulta a ejecutar basada en si el nombre es proporcionado
            if ("".equals(nombre)) {
                consulta = "SELECT * FROM vista_proveedores ORDER BY nombre_proveedor ASC;";
                ps = conexion.prepareStatement(consulta);
            } else {
                consulta = "SELECT * FROM vista_proveedores WHERE nombre_proveedor LIKE ? ORDER BY nombre_proveedor ASC";
                ps = conexion.prepareStatement(consulta);
                ps.setString(1, "%" + nombre + "%");
            }

            // Ejecuta la consulta
            rs = ps.executeQuery();

            // Procesa los resultados
            int cont = 0;
            while (rs.next()) {
                Object[] fila = new Object[5]; // Crea un array de objetos para la fila
                cont++;
                fila[0] = cont;
                fila[1] = rs.getInt("id_proveedor");
                fila[2] = rs.getString("nombre_proveedor");
                fila[3] = rs.getString("telefono_proveedor");
                fila[4] = rs.getString("nombre_producto");
                modelo.addRow(fila); // Añade la fila al modelo de la tabla
            }

            // Establece el modelo en la JTable (Asume que jtbProducto es tu JTable)
            jtblProveedores.setModel(modelo);

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

    public int obtenerIdProveedorSeleccionado() {
        int filaSeleccionada = jtblProveedores.getSelectedRow(); // Obtiene la fila seleccionada

        // Verifica que la fila seleccionada es válida
        if (filaSeleccionada != -1) {
            // Obtiene el modelo de la tabla
            DefaultTableModel modelo = (DefaultTableModel) jtblProveedores.getModel();

            // Obtiene el valor del ID de producto de la primera columna
            // Asume que el ID del producto está en la primera columna (índice 0)
            return (Integer) modelo.getValueAt(filaSeleccionada, 1); // Devuelve el ID del producto
        } else {
            return -1; // Devuelve -1 si no se selecciona ninguna fila válida
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel5 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        txtTelefonoProove = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtNombreProducto = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtNombreProove1 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtblProveedores = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        btnActualizar = new javax.swing.JButton();
        btnAgregarProove = new javax.swing.JButton();
        btnElimiProove = new javax.swing.JButton();

        setClosable(true);
        setTitle("Agregar proveedor");

        jLabel5.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel5.setText("Nombre del proveedor:");

        jLabel6.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel6.setText("Teléfono del proveedor:");

        txtNombreProducto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNombreProductoKeyReleased(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel7.setText("Nombre del producto:");

        txtNombreProove1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreProove1ActionPerformed(evt);
            }
        });
        txtNombreProove1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNombreProove1KeyReleased(evt);
            }
        });

        jtblProveedores.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jtblProveedores);

        btnActualizar.setText("Actualizar");
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });

        btnAgregarProove.setText("Agregar");
        btnAgregarProove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarProoveActionPerformed(evt);
            }
        });

        btnElimiProove.setText("Eliminar");
        btnElimiProove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnElimiProoveActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(btnElimiProove, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnAgregarProove, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(31, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAgregarProove, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnElimiProove, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19))
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel5))
                        .addGap(37, 37, 37)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtTelefonoProove, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNombreProove1, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtNombreProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 820, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap(15, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNombreProove1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel7)
                    .addComponent(txtNombreProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtTelefonoProove, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 16, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        try {
            int id = obtenerIdProveedorSeleccionado();
            if (id == -1) {
                JOptionPane.showMessageDialog(rootPane, "POR FAVOR SELECCIONE CON UN PROVEEDOR");
                return;
            }
            Controlador_Proveedor cp = new Controlador_Proveedor();
            int idPr = cp.obtenerProductodelProveedor(txtNombreProove1.getText());
            int filaSeleccionada = jtblProveedores.getSelectedRow();
            
            if (filaSeleccionada != -1) {
                // Asumiendo que el nombre del proveedor está en la columna 1 y el teléfono en la columna 2.
                String nombreProveedor = jtblProveedores.getValueAt(filaSeleccionada, 2).toString();
                String telefonoProveedor = jtblProveedores.getValueAt(filaSeleccionada, 3).toString();
                
                // Supongamos que tienes un método similar para obtener el ID del proveedor seleccionado.
                int idProveedorSeleccionado = obtenerIdProveedorSeleccionado();
                
                if (idProveedorSeleccionado != -1) {
                    Controlador_Proveedor controladorProveedor = new Controlador_Proveedor();
                    // Suponiendo que 'repiteProveedor' verifica la existencia u otra lógica específica.
                    int exist = controladorProveedor.repiteProveedor(nombreProveedor);
                    
                    if (exist == 2) {
                        // Crear el modelo de proveedor con el nombre y teléfono. El ID no es necesario aquí si 'actualizarProveedor' lo maneja.
                        Modelo_Proveedor modeloProveedor = new Modelo_Proveedor(0, nombreProveedor, telefonoProveedor, idPr); // El '0' es un placeholder.
                        // Llamada al método de actualización con el modelo y el ID del proveedor.
                        controladorProveedor.actualizarProveedor(modeloProveedor, idProveedorSeleccionado);
                    }
                } else {
                    // Manejar el caso de no haber seleccionado un proveedor válido.
                }
            } else {
                // Manejar el caso de no haber fila seleccionada.
                JOptionPane.showMessageDialog(rootPane, closable, "POR FAVOR SELECCIONE UNA FILA", ERROR);
            }
            
            limpiar();
            mostrarTabla("");
        } catch (SQLException ex) {
            Logger.getLogger(Agregar_Proveedor.class.getName()).log(Level.SEVERE, null, ex);
        }


    }//GEN-LAST:event_btnActualizarActionPerformed

    private void btnAgregarProoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarProoveActionPerformed

        try {
            if (txtNombreProducto.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Por favor, complete todos los campos.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            String nombreProvedor = txtNombreProove1.getText();
            String numeroProvedor = txtTelefonoProove.getText();
            String nombreProducto = txtNombreProducto.getText();

            Controlador_Productos productControl = new Controlador_Productos();
            int id1 = productControl.obtenerIdPorNombreProducto(nombreProducto);

            Controlador_Proveedor cp = new Controlador_Proveedor();

            int exist = cp.repiteProveedor(nombreProvedor);
            if (exist == 2) {

                Modelo_Proveedor modeloProveedor = new Modelo_Proveedor(0, nombreProvedor, numeroProvedor, id1);
                Controlador_Proveedor controladorProveedor = new Controlador_Proveedor();
                controladorProveedor.AgregarProveedor(modeloProveedor);

            }
        } catch (SQLException ex) {

        }
        limpiar();
        mostrarTabla("");


    }//GEN-LAST:event_btnAgregarProoveActionPerformed

    private void btnElimiProoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnElimiProoveActionPerformed
        int id = obtenerIdProveedorSeleccionado();
        if (id == -1) {
            JOptionPane.showMessageDialog(rootPane, "POR FAVOR SELECCIONE CON UN PROVEEDOR");
            return;
        }

        Controlador_Proveedor proveedorControl = new Controlador_Proveedor();
        proveedorControl.eliminarProveedor(id);

        limpiar();
        mostrarTabla("");

    }//GEN-LAST:event_btnElimiProoveActionPerformed

    private void txtNombreProductoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreProductoKeyReleased

    }//GEN-LAST:event_txtNombreProductoKeyReleased

    private void txtNombreProove1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreProove1KeyReleased
        mostrarTabla(txtNombreProove1.getText());
    }//GEN-LAST:event_txtNombreProove1KeyReleased

    private void txtNombreProove1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreProove1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreProove1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnAgregarProove;
    private javax.swing.JButton btnElimiProove;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jtblProveedores;
    private javax.swing.JTextField txtNombreProducto;
    private javax.swing.JTextField txtNombreProove1;
    private javax.swing.JTextField txtTelefonoProove;
    // End of variables declaration//GEN-END:variables

    private void limpiar() {
        txtNombreProducto.setText("");
        txtNombreProove1.setText("");
        txtTelefonoProove.setText("");
    }

}
