
package DIU;



public class Menu extends javax.swing.JFrame {

    
    public Menu() {
        initComponents();
        
    }

    private void ajustarTamanoVentanaInterna(javax.swing.JInternalFrame ventanaInterna) {
        int anchoEscritorio = Escritorio3.getWidth();
        int altoEscritorio = Escritorio3.getHeight();
        ventanaInterna.setMaximumSize(new java.awt.Dimension(anchoEscritorio, altoEscritorio));
        ventanaInterna.setSize(anchoEscritorio, altoEscritorio);
        
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jBackground = new javax.swing.JPanel();
        JpanelDerecho = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        lblElLOGo = new javax.swing.JLabel();
        JpanelIzquierdo = new javax.swing.JPanel();
        Escritorio3 = new javax.swing.JDesktopPane();
        jLabel56 = new javax.swing.JLabel();
        jLabel57 = new javax.swing.JLabel();
        jLabel58 = new javax.swing.JLabel();
        jLabel59 = new javax.swing.JLabel();
        jLabel60 = new javax.swing.JLabel();
        jLabel61 = new javax.swing.JLabel();
        jLabel62 = new javax.swing.JLabel();
        jLabel63 = new javax.swing.JLabel();
        jLabel64 = new javax.swing.JLabel();
        jLabel65 = new javax.swing.JLabel();
        jLabel66 = new javax.swing.JLabel();
        jLabel67 = new javax.swing.JLabel();
        jLabel68 = new javax.swing.JLabel();
        jLabel69 = new javax.swing.JLabel();
        jLabel70 = new javax.swing.JLabel();
        jLabel71 = new javax.swing.JLabel();
        jLabel72 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jmInventario = new javax.swing.JMenu();
        JmiVerInventario = new javax.swing.JMenuItem();
        JmOperaciones = new javax.swing.JMenu();
        JmientradaGavetas = new javax.swing.JMenuItem();
        jmiSalidaGavetas = new javax.swing.JMenuItem();
        JmEnvios = new javax.swing.JMenu();
        JmiVerEnvios = new javax.swing.JMenuItem();
        JmProveedores = new javax.swing.JMenu();
        jmiAgregar = new javax.swing.JMenuItem();
        JmGavetas = new javax.swing.JMenu();
        jmiAgregarGaveta = new javax.swing.JMenuItem();
        JmSupermercados = new javax.swing.JMenu();
        jmiAgregarSupermercado = new javax.swing.JMenuItem();
        JmProductos = new javax.swing.JMenu();
        jmiAgregarProduct = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        jmiVerReporte = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        JpanelDerecho.setBackground(new java.awt.Color(0, 153, 51));

        jLabel13.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 20)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("DE INVENTARIO");

        jLabel20.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 20)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText("SISTEMA");

        jLabel21.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 20)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setText("\"GavetaTracker\"");

        jLabel22.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 20)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setText("DE GAVETAS");

        lblElLOGo.setIcon(new javax.swing.ImageIcon("C:\\Users\\carlo\\Documents\\NetBeansProjects\\Proyecto_de_aula\\src\\main\\resource\\Imagenes\\logo.png")); // NOI18N

        javax.swing.GroupLayout JpanelDerechoLayout = new javax.swing.GroupLayout(JpanelDerecho);
        JpanelDerecho.setLayout(JpanelDerechoLayout);
        JpanelDerechoLayout.setHorizontalGroup(
            JpanelDerechoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JpanelDerechoLayout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addGroup(JpanelDerechoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel21)
                    .addComponent(jLabel20)
                    .addComponent(jLabel13)
                    .addComponent(lblElLOGo)
                    .addComponent(jLabel22))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        JpanelDerechoLayout.setVerticalGroup(
            JpanelDerechoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JpanelDerechoLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(lblElLOGo)
                .addGap(53, 53, 53)
                .addComponent(jLabel20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(12, 12, 12)
                .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(209, 209, 209))
        );

        jLabel56.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 20)); // NOI18N
        jLabel56.setText(" AGRÍCOLA ARENAS");

        jLabel58.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel58.setText("Agrícola Arenas, una empresa agrícola familiar de varias generaciones, se diversifica en la ");

        jLabel59.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel59.setText("comercialización directa desde 2007. Su experiencia y enfoque innovador en técnicas agrícolas ");

        jLabel60.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel60.setText("sostenibles la lleva a colaborar con grandes supermercados. Priorizan prácticas amigables con el ");

        jLabel61.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel61.setText("medio ambiente, reduciendo el uso de químicos sintéticos, y fomentan la conexión social mediante ");

        jLabel62.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel62.setText("empleo y educación agrícola.");

        jLabel63.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel63.setText("Buscamos cumplir con las demandas de nuestros clientes ofreciendo alimentos saludables y ");

        jLabel64.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel64.setText("frescos, cultivados y procesados bajo rigurosos estándares de calidad y eficiencia. Nuestra meta es ");

        jLabel65.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel65.setText("alcanzar altos niveles de productividad, rentabilidad y generación de empleo, contribuyendo al ");

        jLabel66.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel66.setText("desarrollo empresarial y personal.");

        jLabel67.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel67.setText("Aspiramos a liderar la producción y comercialización de productos agrícolas de alta calidad ");

        jLabel68.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel68.setText("mediante un modelo Agro-empresarial. Buscamos equilibrar impactos sociales, económicos y ");

        jLabel69.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel69.setText("ambientales para fortalecer nuestra competitividad y expandirnos a mercados nacionales e ");

        jLabel70.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel70.setText("internacionales.");

        jLabel71.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 20)); // NOI18N
        jLabel71.setText("VISIÓN");

        jLabel72.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 20)); // NOI18N
        jLabel72.setText("MISIÓN");

        Escritorio3.setLayer(jLabel56, javax.swing.JLayeredPane.DEFAULT_LAYER);
        Escritorio3.setLayer(jLabel57, javax.swing.JLayeredPane.DEFAULT_LAYER);
        Escritorio3.setLayer(jLabel58, javax.swing.JLayeredPane.DEFAULT_LAYER);
        Escritorio3.setLayer(jLabel59, javax.swing.JLayeredPane.DEFAULT_LAYER);
        Escritorio3.setLayer(jLabel60, javax.swing.JLayeredPane.DEFAULT_LAYER);
        Escritorio3.setLayer(jLabel61, javax.swing.JLayeredPane.DEFAULT_LAYER);
        Escritorio3.setLayer(jLabel62, javax.swing.JLayeredPane.DEFAULT_LAYER);
        Escritorio3.setLayer(jLabel63, javax.swing.JLayeredPane.DEFAULT_LAYER);
        Escritorio3.setLayer(jLabel64, javax.swing.JLayeredPane.DEFAULT_LAYER);
        Escritorio3.setLayer(jLabel65, javax.swing.JLayeredPane.DEFAULT_LAYER);
        Escritorio3.setLayer(jLabel66, javax.swing.JLayeredPane.DEFAULT_LAYER);
        Escritorio3.setLayer(jLabel67, javax.swing.JLayeredPane.DEFAULT_LAYER);
        Escritorio3.setLayer(jLabel68, javax.swing.JLayeredPane.DEFAULT_LAYER);
        Escritorio3.setLayer(jLabel69, javax.swing.JLayeredPane.DEFAULT_LAYER);
        Escritorio3.setLayer(jLabel70, javax.swing.JLayeredPane.DEFAULT_LAYER);
        Escritorio3.setLayer(jLabel71, javax.swing.JLayeredPane.DEFAULT_LAYER);
        Escritorio3.setLayer(jLabel72, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout Escritorio3Layout = new javax.swing.GroupLayout(Escritorio3);
        Escritorio3.setLayout(Escritorio3Layout);
        Escritorio3Layout.setHorizontalGroup(
            Escritorio3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Escritorio3Layout.createSequentialGroup()
                .addGap(306, 306, 306)
                .addComponent(jLabel56, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(Escritorio3Layout.createSequentialGroup()
                .addGap(199, 199, 199)
                .addComponent(jLabel57))
            .addGroup(Escritorio3Layout.createSequentialGroup()
                .addGap(113, 113, 113)
                .addComponent(jLabel58, javax.swing.GroupLayout.PREFERRED_SIZE, 604, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(Escritorio3Layout.createSequentialGroup()
                .addGap(113, 113, 113)
                .addComponent(jLabel59, javax.swing.GroupLayout.PREFERRED_SIZE, 634, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(Escritorio3Layout.createSequentialGroup()
                .addGap(113, 113, 113)
                .addComponent(jLabel60, javax.swing.GroupLayout.PREFERRED_SIZE, 647, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(Escritorio3Layout.createSequentialGroup()
                .addGap(113, 113, 113)
                .addComponent(jLabel61, javax.swing.GroupLayout.PREFERRED_SIZE, 662, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(Escritorio3Layout.createSequentialGroup()
                .addGap(113, 113, 113)
                .addComponent(jLabel62, javax.swing.GroupLayout.PREFERRED_SIZE, 662, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(Escritorio3Layout.createSequentialGroup()
                .addGap(357, 357, 357)
                .addComponent(jLabel72, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(Escritorio3Layout.createSequentialGroup()
                .addGap(113, 113, 113)
                .addComponent(jLabel63, javax.swing.GroupLayout.PREFERRED_SIZE, 662, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(Escritorio3Layout.createSequentialGroup()
                .addGap(113, 113, 113)
                .addComponent(jLabel64, javax.swing.GroupLayout.PREFERRED_SIZE, 662, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(Escritorio3Layout.createSequentialGroup()
                .addGap(113, 113, 113)
                .addComponent(jLabel65, javax.swing.GroupLayout.PREFERRED_SIZE, 662, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(Escritorio3Layout.createSequentialGroup()
                .addGap(113, 113, 113)
                .addComponent(jLabel66, javax.swing.GroupLayout.PREFERRED_SIZE, 662, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(Escritorio3Layout.createSequentialGroup()
                .addGap(362, 362, 362)
                .addComponent(jLabel71, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(Escritorio3Layout.createSequentialGroup()
                .addGap(113, 113, 113)
                .addComponent(jLabel67, javax.swing.GroupLayout.PREFERRED_SIZE, 662, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(Escritorio3Layout.createSequentialGroup()
                .addGap(113, 113, 113)
                .addComponent(jLabel68, javax.swing.GroupLayout.PREFERRED_SIZE, 662, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(Escritorio3Layout.createSequentialGroup()
                .addGap(113, 113, 113)
                .addComponent(jLabel69, javax.swing.GroupLayout.PREFERRED_SIZE, 662, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(Escritorio3Layout.createSequentialGroup()
                .addGap(113, 113, 113)
                .addComponent(jLabel70, javax.swing.GroupLayout.PREFERRED_SIZE, 662, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        Escritorio3Layout.setVerticalGroup(
            Escritorio3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Escritorio3Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel56)
                .addGap(18, 18, 18)
                .addComponent(jLabel57)
                .addGap(6, 6, 6)
                .addComponent(jLabel58)
                .addGap(6, 6, 6)
                .addComponent(jLabel59)
                .addGap(6, 6, 6)
                .addComponent(jLabel60)
                .addGap(6, 6, 6)
                .addComponent(jLabel61)
                .addGap(6, 6, 6)
                .addComponent(jLabel62)
                .addGap(6, 6, 6)
                .addComponent(jLabel72)
                .addGap(18, 18, 18)
                .addComponent(jLabel63)
                .addGap(6, 6, 6)
                .addComponent(jLabel64)
                .addGap(6, 6, 6)
                .addComponent(jLabel65)
                .addGap(6, 6, 6)
                .addComponent(jLabel66)
                .addGap(6, 6, 6)
                .addComponent(jLabel71)
                .addGap(18, 18, 18)
                .addComponent(jLabel67)
                .addGap(6, 6, 6)
                .addComponent(jLabel68, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(jLabel69)
                .addGap(6, 6, 6)
                .addComponent(jLabel70))
        );

        javax.swing.GroupLayout JpanelIzquierdoLayout = new javax.swing.GroupLayout(JpanelIzquierdo);
        JpanelIzquierdo.setLayout(JpanelIzquierdoLayout);
        JpanelIzquierdoLayout.setHorizontalGroup(
            JpanelIzquierdoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 894, Short.MAX_VALUE)
            .addGroup(JpanelIzquierdoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(Escritorio3))
        );
        JpanelIzquierdoLayout.setVerticalGroup(
            JpanelIzquierdoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
            .addGroup(JpanelIzquierdoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(JpanelIzquierdoLayout.createSequentialGroup()
                    .addComponent(Escritorio3)
                    .addContainerGap()))
        );

        javax.swing.GroupLayout jBackgroundLayout = new javax.swing.GroupLayout(jBackground);
        jBackground.setLayout(jBackgroundLayout);
        jBackgroundLayout.setHorizontalGroup(
            jBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jBackgroundLayout.createSequentialGroup()
                .addGap(289, 289, 289)
                .addComponent(JpanelIzquierdo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(JpanelDerecho, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jBackgroundLayout.setVerticalGroup(
            jBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(JpanelIzquierdo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(JpanelDerecho, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jMenuBar1.setBackground(new java.awt.Color(255, 255, 102));

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

        JmEnvios.setText("Envios");

        JmiVerEnvios.setText("Ver envios");
        JmiVerEnvios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JmiVerEnviosActionPerformed(evt);
            }
        });
        JmEnvios.add(JmiVerEnvios);

        jMenuBar1.add(JmEnvios);

        JmProveedores.setText("Proveedores");

        jmiAgregar.setText("Agregar");
        jmiAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiAgregarActionPerformed(evt);
            }
        });
        JmProveedores.add(jmiAgregar);

        jMenuBar1.add(JmProveedores);

        JmGavetas.setText("Gavetas");

        jmiAgregarGaveta.setText("Agregar");
        jmiAgregarGaveta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiAgregarGavetaActionPerformed(evt);
            }
        });
        JmGavetas.add(jmiAgregarGaveta);

        jMenuBar1.add(JmGavetas);

        JmSupermercados.setText("Supermercados");

        jmiAgregarSupermercado.setText("Agregar");
        jmiAgregarSupermercado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiAgregarSupermercadoActionPerformed(evt);
            }
        });
        JmSupermercados.add(jmiAgregarSupermercado);

        jMenuBar1.add(JmSupermercados);

        JmProductos.setText("Productos");

        jmiAgregarProduct.setText("Agregar");
        jmiAgregarProduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiAgregarProductActionPerformed(evt);
            }
        });
        JmProductos.add(jmiAgregarProduct);

        jMenuBar1.add(JmProductos);

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
            .addComponent(jBackground, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jBackground, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JmiVerInventarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JmiVerInventarioActionPerformed
        VerInventario inven= new VerInventario();
        Escritorio3.add(inven);
        inven.show();
        ajustarTamanoVentanaInterna(inven);
    }//GEN-LAST:event_JmiVerInventarioActionPerformed

    private void JmientradaGavetasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JmientradaGavetasActionPerformed
        Entrada_Gavetas entrada= new Entrada_Gavetas();
        Escritorio3.add(entrada);
        entrada.show();
        ajustarTamanoVentanaInterna(entrada);
    }//GEN-LAST:event_JmientradaGavetasActionPerformed

    private void jmiSalidaGavetasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiSalidaGavetasActionPerformed
        Envios_Gavetas salida= new Envios_Gavetas();
        Escritorio3.add(salida);
        salida.show();
        ajustarTamanoVentanaInterna(salida);
    }//GEN-LAST:event_jmiSalidaGavetasActionPerformed

    private void jmiAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiAgregarActionPerformed
        Agregar_Proveedor agregarPro= new Agregar_Proveedor();
        Escritorio3.add(agregarPro);
        agregarPro.show();
        ajustarTamanoVentanaInterna(agregarPro);

    }//GEN-LAST:event_jmiAgregarActionPerformed

    private void jmiAgregarGavetaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiAgregarGavetaActionPerformed
        Agregar_Gaveta agregarGa= new Agregar_Gaveta();
        Escritorio3.add(agregarGa);
        agregarGa.show();
        ajustarTamanoVentanaInterna(agregarGa);
    }//GEN-LAST:event_jmiAgregarGavetaActionPerformed

    private void jmiAgregarSupermercadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiAgregarSupermercadoActionPerformed
        Agregar_Supermercado agregarSup= new Agregar_Supermercado();
        Escritorio3.add(agregarSup);
        agregarSup.show();
        ajustarTamanoVentanaInterna(agregarSup);

    }//GEN-LAST:event_jmiAgregarSupermercadoActionPerformed

    private void jmiVerReporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiVerReporteActionPerformed
        Ver_Reporte verRep= new Ver_Reporte();
        Escritorio3.add(verRep);
        verRep.show();
        ajustarTamanoVentanaInterna(verRep);

    }//GEN-LAST:event_jmiVerReporteActionPerformed

    private void JmiVerEnviosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JmiVerEnviosActionPerformed
        Ver_Envios envios = new Ver_Envios();
        Escritorio3.add(envios);
        envios.show();
        ajustarTamanoVentanaInterna(envios);

    }//GEN-LAST:event_JmiVerEnviosActionPerformed

    private void jmiAgregarProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiAgregarProductActionPerformed
        Agregar_Producto product = new Agregar_Producto();
        Escritorio3.add(product);
        product.show();
        ajustarTamanoVentanaInterna(product);

    }//GEN-LAST:event_jmiAgregarProductActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane Escritorio;
    private javax.swing.JDesktopPane Escritorio1;
    private javax.swing.JDesktopPane Escritorio2;
    private javax.swing.JDesktopPane Escritorio3;
    private javax.swing.JMenu JmEnvios;
    private javax.swing.JMenu JmGavetas;
    private javax.swing.JMenu JmOperaciones;
    private javax.swing.JMenu JmProductos;
    private javax.swing.JMenu JmProveedores;
    private javax.swing.JMenu JmSupermercados;
    private javax.swing.JMenuItem JmiVerEnvios;
    private javax.swing.JMenuItem JmiVerInventario;
    private javax.swing.JMenuItem JmientradaGavetas;
    private javax.swing.JPanel JpanelDerecho;
    private javax.swing.JPanel JpanelIzquierdo;
    private javax.swing.JPanel jBackground;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel66;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JLabel jLabel68;
    private javax.swing.JLabel jLabel69;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel70;
    private javax.swing.JLabel jLabel71;
    private javax.swing.JLabel jLabel72;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu jmInventario;
    private javax.swing.JMenuItem jmiAgregar;
    private javax.swing.JMenuItem jmiAgregarGaveta;
    private javax.swing.JMenuItem jmiAgregarProduct;
    private javax.swing.JMenuItem jmiAgregarSupermercado;
    private javax.swing.JMenuItem jmiSalidaGavetas;
    private javax.swing.JMenuItem jmiVerReporte;
    private javax.swing.JLabel lblElLOGo;
    // End of variables declaration//GEN-END:variables
}
