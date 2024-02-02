/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package DIU;



public class Menu extends javax.swing.JFrame {

    
    public Menu() {
        initComponents();
        mostrarPrincipal();
    }

    private void mostrarPrincipal() {
        Principal principal = new Principal();
        Escritorio.add(principal);
        principal.setVisible(true);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Escritorio = new javax.swing.JDesktopPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        jmInventario = new javax.swing.JMenu();
        JmiVerInventario = new javax.swing.JMenuItem();
        JmOperaciones = new javax.swing.JMenu();
        JmientradaGavetas = new javax.swing.JMenuItem();
        jmiSalidaGavetas = new javax.swing.JMenuItem();
        JmProveedores = new javax.swing.JMenu();
        jmiAgregar = new javax.swing.JMenuItem();
        jmiEditar = new javax.swing.JMenuItem();
        JmGavetas = new javax.swing.JMenu();
        jmiAgregarGaveta = new javax.swing.JMenuItem();
        jmiEditarGaveta = new javax.swing.JMenuItem();
        JmSupermercados = new javax.swing.JMenu();
        jmiAgregarSupermercado = new javax.swing.JMenuItem();
        jmiEditarSupermercado = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        jmiVerReporte = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout EscritorioLayout = new javax.swing.GroupLayout(Escritorio);
        Escritorio.setLayout(EscritorioLayout);
        EscritorioLayout.setHorizontalGroup(
            EscritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 888, Short.MAX_VALUE)
        );
        EscritorioLayout.setVerticalGroup(
            EscritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 500, Short.MAX_VALUE)
        );

        jmInventario.setText("Inventario");

        JmiVerInventario.setText("Ver");
        JmiVerInventario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JmiVerInventarioActionPerformed(evt);
            }
        });
        jmInventario.add(JmiVerInventario);

        jMenuBar1.add(jmInventario);

        JmOperaciones.setText("Operaciones");

        JmientradaGavetas.setText("Entrada de gavetas");
        JmientradaGavetas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JmientradaGavetasActionPerformed(evt);
            }
        });
        JmOperaciones.add(JmientradaGavetas);

        jmiSalidaGavetas.setText("Salida de gavetas");
        jmiSalidaGavetas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiSalidaGavetasActionPerformed(evt);
            }
        });
        JmOperaciones.add(jmiSalidaGavetas);

        jMenuBar1.add(JmOperaciones);

        JmProveedores.setText("Proveedores");

        jmiAgregar.setText("Agregar");
        jmiAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiAgregarActionPerformed(evt);
            }
        });
        JmProveedores.add(jmiAgregar);

        jmiEditar.setText("Editar");
        jmiEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiEditarActionPerformed(evt);
            }
        });
        JmProveedores.add(jmiEditar);

        jMenuBar1.add(JmProveedores);

        JmGavetas.setText("Gavetas");

        jmiAgregarGaveta.setText("Agregar");
        jmiAgregarGaveta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiAgregarGavetaActionPerformed(evt);
            }
        });
        JmGavetas.add(jmiAgregarGaveta);

        jmiEditarGaveta.setText("Editar");
        jmiEditarGaveta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiEditarGavetaActionPerformed(evt);
            }
        });
        JmGavetas.add(jmiEditarGaveta);

        jMenuBar1.add(JmGavetas);

        JmSupermercados.setText("Supermercados");

        jmiAgregarSupermercado.setText("Agregar");
        jmiAgregarSupermercado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiAgregarSupermercadoActionPerformed(evt);
            }
        });
        JmSupermercados.add(jmiAgregarSupermercado);

        jmiEditarSupermercado.setText("Editar");
        jmiEditarSupermercado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiEditarSupermercadoActionPerformed(evt);
            }
        });
        JmSupermercados.add(jmiEditarSupermercado);

        jMenuBar1.add(JmSupermercados);

        jMenu5.setText("Reportes");

        jmiVerReporte.setText("Ver");
        jmiVerReporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiVerReporteActionPerformed(evt);
            }
        });
        jMenu5.add(jmiVerReporte);

        jMenuBar1.add(jMenu5);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Escritorio)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Escritorio)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JmiVerInventarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JmiVerInventarioActionPerformed
        VerInventario inven= new VerInventario();
        Escritorio.add(inven);
        inven.show();
    }//GEN-LAST:event_JmiVerInventarioActionPerformed

    private void jmiEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiEditarActionPerformed
        Editar_Proveedor editarPro= new Editar_Proveedor();
        Escritorio.add(editarPro);
        editarPro.show();
    }//GEN-LAST:event_jmiEditarActionPerformed

    private void JmientradaGavetasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JmientradaGavetasActionPerformed
        Entrada_Gavetas entrada= new Entrada_Gavetas();
        Escritorio.add(entrada);
        entrada.show();
    }//GEN-LAST:event_JmientradaGavetasActionPerformed

    private void jmiSalidaGavetasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiSalidaGavetasActionPerformed
        Salida_Gavetas salida= new Salida_Gavetas();
        Escritorio.add(salida);
        salida.show();
    }//GEN-LAST:event_jmiSalidaGavetasActionPerformed

    private void jmiAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiAgregarActionPerformed
        Agregar_Proveedor agregarPro= new Agregar_Proveedor();
        Escritorio.add(agregarPro);
        agregarPro.show();
    }//GEN-LAST:event_jmiAgregarActionPerformed

    private void jmiAgregarGavetaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiAgregarGavetaActionPerformed
        Agregar_Gaveta agregarGa= new Agregar_Gaveta();
        Escritorio.add(agregarGa);
        agregarGa.show();
    }//GEN-LAST:event_jmiAgregarGavetaActionPerformed

    private void jmiEditarGavetaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiEditarGavetaActionPerformed
        Editar_Gaveta editarGa= new Editar_Gaveta();
        Escritorio.add(editarGa);
        editarGa.show();
    }//GEN-LAST:event_jmiEditarGavetaActionPerformed

    private void jmiAgregarSupermercadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiAgregarSupermercadoActionPerformed
        Agregar_Supermercado agregarSup= new Agregar_Supermercado();
        Escritorio.add(agregarSup);
        agregarSup.show();
    }//GEN-LAST:event_jmiAgregarSupermercadoActionPerformed

    private void jmiEditarSupermercadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiEditarSupermercadoActionPerformed
        Editar_Supermercado editarSup= new Editar_Supermercado();
        Escritorio.add(editarSup);
        editarSup.show();
    }//GEN-LAST:event_jmiEditarSupermercadoActionPerformed

    private void jmiVerReporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiVerReporteActionPerformed
        Ver_Reporte verRep= new Ver_Reporte();
        Escritorio.add(verRep);
        verRep.show();
    }//GEN-LAST:event_jmiVerReporteActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JDesktopPane Escritorio;
    private javax.swing.JMenu JmGavetas;
    private javax.swing.JMenu JmOperaciones;
    private javax.swing.JMenu JmProveedores;
    private javax.swing.JMenu JmSupermercados;
    private javax.swing.JMenuItem JmiVerInventario;
    private javax.swing.JMenuItem JmientradaGavetas;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu jmInventario;
    private javax.swing.JMenuItem jmiAgregar;
    private javax.swing.JMenuItem jmiAgregarGaveta;
    private javax.swing.JMenuItem jmiAgregarSupermercado;
    private javax.swing.JMenuItem jmiEditar;
    private javax.swing.JMenuItem jmiEditarGaveta;
    private javax.swing.JMenuItem jmiEditarSupermercado;
    private javax.swing.JMenuItem jmiSalidaGavetas;
    private javax.swing.JMenuItem jmiVerReporte;
    // End of variables declaration//GEN-END:variables
}
