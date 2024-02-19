package DIU;

import DIU.Controlador.ConexionBDD;
import DIU.Controlador.Controlador_Productos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author carlo
 */
public class VerInventario extends javax.swing.JInternalFrame {

    /**
     * Creates new form Inventario
     */
    public VerInventario() {
        initComponents();
        Controlador_Productos conProd = new Controlador_Productos();
        List<String> nombresProductos = conProd.obtenerNombresProductos();
        jcProductos.removeAllItems();

        for (String nombre : nombresProductos) {
            jcProductos.addItem(nombre);
        }
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
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Número");
        modelo.addColumn("Producto");
        modelo.addColumn("Cantidad Total en KG");

        ConexionBDD con = new ConexionBDD();
        Connection conexion = con.conectar();

        PreparedStatement ps = null;
        ResultSet rs = null;

        String consulta;

        try {
            if ("".equals(nombre)) {
                consulta = "SELECT * FROM detalle_inventario ORDER BY nombre_producto ASC";
                ps = conexion.prepareStatement(consulta);
            } else {
                consulta = "SELECT * FROM detalle_inventario WHERE nombre_producto LIKE ? ORDER BY nombre_producto ASC";
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
                fila[1] = rs.getString("nombre_producto");
                fila[2] = rs.getString("cantidad_total_kg") + " kg";
                modelo.addRow(fila); // Añade la fila al modelo de la tabla
            }

            // Establece el modelo en la JTable (Asume que jtbProducto es tu JTable)
            jtblInventario.setModel(modelo);

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

    public DefaultTableModel filtrar(DefaultTableModel tabla, String opcion) {
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Número");
        modelo.addColumn("Producto");
        modelo.addColumn("Cantidad Total en KG");

        try {
            for (int i = 0; i < tabla.getRowCount(); i++) {
                String nombreProducto = tabla.getValueAt(i, 1).toString();

                if (nombreProducto.contains(opcion)) {
                    Object[] fila = new Object[3];
                    fila[0] = modelo.getRowCount() + 1;
                    fila[1] = tabla.getValueAt(i, 1);
                    fila[2] = tabla.getValueAt(i, 2);
                    modelo.addRow(fila);
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al filtrar: " + e.getMessage());
        }

        return modelo;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtblInventario = new javax.swing.JTable();
        lblTitulo = new javax.swing.JLabel();
        jcProductos = new javax.swing.JComboBox<>();
        jbFiltrarInven = new javax.swing.JButton();

        setClosable(true);
        setMaximizable(true);
        setTitle("Ver Inventario");

        jPanel1.setBackground(new java.awt.Color(255, 246, 137));

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 20)); // NOI18N
        jLabel1.setText("INVENTARIO");

        jtblInventario.setBackground(new java.awt.Color(86, 84, 15));
        jtblInventario.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jtblInventario.setForeground(new java.awt.Color(255, 255, 255));
        jtblInventario.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(jtblInventario);

        lblTitulo.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lblTitulo.setText("Nombre Producto:");

        jcProductos.setBackground(new java.awt.Color(86, 84, 15));
        jcProductos.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jcProductos.setForeground(new java.awt.Color(255, 255, 255));
        jcProductos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecciona" }));
        jcProductos.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jcProductosFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jcProductosFocusLost(evt);
            }
        });
        jcProductos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jcProductosMouseClicked(evt);
            }
        });
        jcProductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcProductosActionPerformed(evt);
            }
        });

        jbFiltrarInven.setBackground(new java.awt.Color(86, 84, 15));
        jbFiltrarInven.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jbFiltrarInven.setForeground(new java.awt.Color(255, 255, 255));
        jbFiltrarInven.setText("Revertir Filtrado");
        jbFiltrarInven.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbFiltrarInvenActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 811, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jcProductos, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jbFiltrarInven, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(40, 40, 40))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTitulo)
                    .addComponent(jcProductos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbFiltrarInven, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(46, 46, 46)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 324, Short.MAX_VALUE)
                .addGap(40, 40, 40))
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
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jcProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcProductosActionPerformed

    }//GEN-LAST:event_jcProductosActionPerformed

    private void jbFiltrarInvenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbFiltrarInvenActionPerformed
        mostrarTabla("");
    }//GEN-LAST:event_jbFiltrarInvenActionPerformed

    private void jcProductosFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jcProductosFocusGained
        
    }//GEN-LAST:event_jcProductosFocusGained

    private void jcProductosFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jcProductosFocusLost
        

    }//GEN-LAST:event_jcProductosFocusLost

    private void jcProductosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jcProductosMouseClicked
        String nombreProducto = jcProductos.getSelectedItem().toString();
        DefaultTableModel modelo = (DefaultTableModel) jtblInventario.getModel();
        modelo = filtrar(modelo, nombreProducto);
        jtblInventario.setModel(modelo);
    }//GEN-LAST:event_jcProductosMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton jbFiltrarInven;
    private javax.swing.JComboBox<String> jcProductos;
    private javax.swing.JTable jtblInventario;
    private javax.swing.JLabel lblTitulo;
    // End of variables declaration//GEN-END:variables
}
