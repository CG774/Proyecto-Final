/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package DIU;

import DIU.Controlador.ConexionBDD;
import DIU.Controlador.Controlador_Productos;
import DIU.Modelo.Modelo_Productos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author carlo
 */
public class Agregar_Producto extends javax.swing.JInternalFrame {

    public static int id_Producto;

    public Agregar_Producto() {
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
        modelo.addColumn("ID_PRODUCTO");
        modelo.addColumn("NOMBRE_PRODUCTO");

        // Obtiene la conexión a la base de datos
        ConexionBDD con = new ConexionBDD(); // Asumiendo que esto crea una conexión a la base de datos.
        Connection conexion = con.conectar();

        PreparedStatement ps = null;
        ResultSet rs = null;

        String consulta;

        try {
            // Decide la consulta a ejecutar basada en si el nombre es proporcionado
            if ("".equals(nombre)) {
                consulta = "SELECT * FROM productos ORDER BY nombre_producto ASC";
                ps = conexion.prepareStatement(consulta);
            } else {
                consulta = "SELECT * FROM productos WHERE nombre_producto LIKE ? ORDER BY nombre_producto ASC";
                ps = conexion.prepareStatement(consulta);
                ps.setString(1, "%" + nombre + "%");
            }

            // Ejecuta la consulta
            rs = ps.executeQuery();

            int cont = 0;
            while (rs.next()) {
                cont++;
                Object[] fila = new Object[3]; // Crea un array de objetos para la fila
                fila[0] = cont;
                fila[1] = rs.getInt("id_producto");
                fila[2] = rs.getString("nombre_producto");
                modelo.addRow(fila); // Añade la fila al modelo de la tabla
            }

            // Establece el modelo en la JTable (Asume que jtbProducto es tu JTable)
            jtbProducto.setModel(modelo);

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

    public int obtenerIdProductoSeleccionado() {
        int filaSeleccionada = jtbProducto.getSelectedRow(); // Obtiene la fila seleccionada

        // Verifica que la fila seleccionada es válida
        if (filaSeleccionada != -1) {
            // Obtiene el modelo de la tabla
            DefaultTableModel modelo = (DefaultTableModel) jtbProducto.getModel();

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

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtbProducto = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        txtNombreProdu = new javax.swing.JTextField();
        btnActualizar = new javax.swing.JButton();
        btnAgregarProduc = new javax.swing.JButton();
        btbEliminarProducto = new javax.swing.JButton();

        setClosable(true);
        setTitle("Agregar Producto");

        jtbProducto.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 14)); // NOI18N
        jtbProducto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "ID Producto", "Nombre"
            }
        ));
        jScrollPane1.setViewportView(jtbProducto);

        jLabel1.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel1.setText("Nombre del producto");

        txtNombreProdu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreProduActionPerformed(evt);
            }
        });
        txtNombreProdu.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNombreProduKeyReleased(evt);
            }
        });

        btnActualizar.setText("Actualizar");
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });

        btnAgregarProduc.setText("Agregar");
        btnAgregarProduc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarProducActionPerformed(evt);
            }
        });

        btbEliminarProducto.setText("Eliminar");
        btbEliminarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btbEliminarProductoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(25, 25, 25)
                                .addComponent(txtNombreProdu, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(369, 369, 369))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btbEliminarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(59, 59, 59)
                        .addComponent(btnActualizar)
                        .addGap(44, 44, 44)
                        .addComponent(btnAgregarProduc)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtNombreProdu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(42, 42, 42)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btbEliminarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(3, 3, 3))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(btnAgregarProduc, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
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

    private void btnAgregarProducActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarProducActionPerformed

        if (txtNombreProdu.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor, complete todos los campos.", "Error", JOptionPane.ERROR_MESSAGE);
            return;

        }

        String NombreProduc = txtNombreProdu.getText();

        Modelo_Productos productModel = new Modelo_Productos(NombreProduc);
        Controlador_Productos productControl = new Controlador_Productos();
        int exist = productControl.repiteProducto(NombreProduc);
        if (exist == 2) {
            productControl.AgregarProducto(productModel);
        }
        txtNombreProdu.setText("");
        mostrarTabla("");
    }//GEN-LAST:event_btnAgregarProducActionPerformed

    private void btbEliminarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btbEliminarProductoActionPerformed
        int id = obtenerIdProductoSeleccionado();
        if (id == -1) {
            JOptionPane.showMessageDialog(rootPane, "POR FAVOR SELECCIONE CON UN CLICK EN EL PRODUCTO");
            return;
        }

        Controlador_Productos productControl = new Controlador_Productos();
        productControl.eliminarProducto(id);

        txtNombreProdu.setText("");
        mostrarTabla("");

    }//GEN-LAST:event_btbEliminarProductoActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        int id = obtenerIdProductoSeleccionado();
        if (id == -1) {
            JOptionPane.showMessageDialog(rootPane, "POR FAVOR SELECCIONE CON UN PRODUCTO");
            return;
        }
        int filaSeleccionada = jtbProducto.getSelectedRow();

        if (filaSeleccionada != -1) {
            // Asumiendo que el nombre del producto está en la columna 2, basado en la discusión anterior.
            String nombreProducto = jtbProducto.getValueAt(filaSeleccionada, 2).toString();
            System.out.println("nom: "+nombreProducto);

            // Usando el método existente para obtener el ID del producto seleccionado.
            int idProductoSeleccionado = obtenerIdProductoSeleccionado();

            if (idProductoSeleccionado != -1) {
                Controlador_Productos controladorProducto = new Controlador_Productos();
                // Suponiendo que 'repiteProducto' verifica la existencia u otra lógica específica.
                int exist = controladorProducto.repiteProducto(nombreProducto);

                if (exist == 2) {
                    // Crear el modelo de producto con el nombre. El ID no es necesario aquí si 'actualizarProducto' lo maneja.
                    Modelo_Productos modeloProducto = new Modelo_Productos(0, nombreProducto); // El '0' es un placeholder.
                    // Llamada al método de actualización con el modelo y el ID del producto.
                    controladorProducto.actualizarProducto(modeloProducto, idProductoSeleccionado);
                }
                
            } else {
                // Manejar el caso de no haber seleccionado un producto válido.
                
            }
        } else {
            // Manejar el caso de no haber fila seleccionada.
            JOptionPane.showMessageDialog(rootPane, closable, "POR FAVOR SELECCIONE UNA FILA", ERROR);
        }

        txtNombreProdu.setText("");
        mostrarTabla("");

    }//GEN-LAST:event_btnActualizarActionPerformed

    private void txtNombreProduKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreProduKeyReleased
        // TODO add your handling code here:
        mostrarTabla(txtNombreProdu.getText());
    }//GEN-LAST:event_txtNombreProduKeyReleased

    private void txtNombreProduActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreProduActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreProduActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btbEliminarProducto;
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnAgregarProduc;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTable jtbProducto;
    private javax.swing.JTextField txtNombreProdu;
    // End of variables declaration//GEN-END:variables
}
