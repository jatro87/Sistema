package vista;

import java.awt.Frame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.CExpediente;

/**
 *
 * @author jatro
 */

public class jd_expediente extends javax.swing.JDialog {

    private final CExpediente exp;
    private jd_registroArchivo regArch;
    private boolean existeExpediente;
    private DefaultTableModel model;
    
    public jd_expediente(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        
        exp = new CExpediente();
        exp.gettiposExpedientes(jcb_tipoexpediente);
        
        setLocationRelativeTo(parent);  
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        jmi_abrir = new javax.swing.JMenuItem();
        jp_contenedor = new javax.swing.JPanel();
        jl_numeroexpediente = new javax.swing.JLabel();
        jtf_numeroexpediente = new javax.swing.JTextField();
        jl_tipoexpediente = new javax.swing.JLabel();
        jcb_tipoexpediente = new javax.swing.JComboBox();
        jb_generarId = new javax.swing.JButton();
        jb_salir = new javax.swing.JButton();
        jp_contenedortabla = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jt_contenido = new javax.swing.JTable();
        jb_agregardocumentos = new javax.swing.JButton();
        jl_escudo = new javax.swing.JLabel();

        jmi_abrir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/nueva_ventana.png"))); // NOI18N
        jmi_abrir.setText("Arbir Documento");
        jmi_abrir.setToolTipText("Visualiza el Documento Seleccionado");
        jmi_abrir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmi_abrirActionPerformed(evt);
            }
        });
        jPopupMenu1.add(jmi_abrir);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Sutsha - Expedientes");
        setResizable(false);

        jp_contenedor.setBackground(new java.awt.Color(255, 255, 255));

        jl_numeroexpediente.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jl_numeroexpediente.setText("No. Expediente:");

        jtf_numeroexpediente.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jtf_numeroexpediente.setForeground(new java.awt.Color(255, 0, 0));
        jtf_numeroexpediente.setToolTipText("Introduce el numero de expediente ...");
        jtf_numeroexpediente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtf_numeroexpedienteActionPerformed(evt);
            }
        });

        jl_tipoexpediente.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jl_tipoexpediente.setText("Tipo Expediente:");

        jcb_tipoexpediente.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jcb_tipoexpediente.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecciona", "*Nuevo" }));
        jcb_tipoexpediente.setToolTipText("Tipo de expediente ...");
        jcb_tipoexpediente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcb_tipoexpedienteActionPerformed(evt);
            }
        });

        jb_generarId.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/recycle-29933_960_720.png"))); // NOI18N
        jb_generarId.setMnemonic('G');

        jb_salir.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jb_salir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/salir.png"))); // NOI18N
        jb_salir.setText("Salir");
        jb_salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_salirActionPerformed(evt);
            }
        });

        jp_contenedortabla.setBackground(new java.awt.Color(255, 255, 255));
        jp_contenedortabla.setBorder(javax.swing.BorderFactory.createCompoundBorder());

        jt_contenido.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jt_contenido.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Documento", "Ingreso", "Descripcion", "Ubicacion", "Clasificacion", "Tipo"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jt_contenido.setComponentPopupMenu(jPopupMenu1);
        jt_contenido.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jt_contenidoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jt_contenido);

        jb_agregardocumentos.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jb_agregardocumentos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/icon_add.png"))); // NOI18N
        jb_agregardocumentos.setText("Agregar");
        jb_agregardocumentos.setToolTipText("Agregar documentos al expediente ...");
        jb_agregardocumentos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_agregardocumentosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jp_contenedortablaLayout = new javax.swing.GroupLayout(jp_contenedortabla);
        jp_contenedortabla.setLayout(jp_contenedortablaLayout);
        jp_contenedortablaLayout.setHorizontalGroup(
            jp_contenedortablaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jp_contenedortablaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jp_contenedortablaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1)
                    .addGroup(jp_contenedortablaLayout.createSequentialGroup()
                        .addGap(0, 862, Short.MAX_VALUE)
                        .addComponent(jb_agregardocumentos)))
                .addContainerGap())
        );
        jp_contenedortablaLayout.setVerticalGroup(
            jp_contenedortablaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jp_contenedortablaLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jb_agregardocumentos, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jl_escudo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/Logo SUTSHA Azul finalSF_3.png"))); // NOI18N

        javax.swing.GroupLayout jp_contenedorLayout = new javax.swing.GroupLayout(jp_contenedor);
        jp_contenedor.setLayout(jp_contenedorLayout);
        jp_contenedorLayout.setHorizontalGroup(
            jp_contenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jp_contenedorLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jp_contenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jp_contenedortabla, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jp_contenedorLayout.createSequentialGroup()
                        .addGroup(jp_contenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jp_contenedorLayout.createSequentialGroup()
                                .addComponent(jl_numeroexpediente)
                                .addGroup(jp_contenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jp_contenedorLayout.createSequentialGroup()
                                        .addGap(93, 93, 93)
                                        .addComponent(jb_generarId))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jp_contenedorLayout.createSequentialGroup()
                                        .addGap(24, 24, 24)
                                        .addComponent(jtf_numeroexpediente, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jp_contenedorLayout.createSequentialGroup()
                                .addComponent(jl_tipoexpediente)
                                .addGap(18, 18, 18)
                                .addComponent(jcb_tipoexpediente, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jl_escudo))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jp_contenedorLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jb_salir)))
                .addContainerGap())
        );
        jp_contenedorLayout.setVerticalGroup(
            jp_contenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jp_contenedorLayout.createSequentialGroup()
                .addGroup(jp_contenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jp_contenedorLayout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addGroup(jp_contenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jl_numeroexpediente)
                            .addComponent(jtf_numeroexpediente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jb_generarId)
                        .addGap(18, 18, 18)
                        .addGroup(jp_contenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jcb_tipoexpediente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jl_tipoexpediente)))
                    .addGroup(jp_contenedorLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jl_escudo, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jp_contenedortabla, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jb_salir)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jp_contenedor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jp_contenedor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jtf_numeroexpedienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtf_numeroexpedienteActionPerformed

        String res = exp.getExpediente(jtf_numeroexpediente.getText(), jt_contenido);   
        
        if(res != null){
            jcb_tipoexpediente.setSelectedItem(res);
            jcb_tipoexpediente.setEnabled(false);
            existeExpediente = true;
        }
        else{
            jcb_tipoexpediente.setSelectedItem("Selecciona");  
            
            model = (DefaultTableModel) jt_contenido.getModel();
            for (int i = model.getRowCount(); i > 0; i--) {
                model.removeRow(i-1);
            }
            
            jcb_tipoexpediente.setEnabled(true);
            
            existeExpediente = false;
            
            JOptionPane.showMessageDialog(this, "El Expediente no Existe.", "Aviso", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_jtf_numeroexpedienteActionPerformed

    private void jcb_tipoexpedienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcb_tipoexpedienteActionPerformed
        try{

        if(jcb_tipoexpediente.getSelectedItem().equals("*Nuevo")){
            
            String res;
            res = JOptionPane.showInputDialog(this, "Introduce el nuevo tipo de expediente:", "Nuevo Tipo", JOptionPane.DEFAULT_OPTION);   
            
            if(res != null){
                
                JOptionPane.showMessageDialog(this, exp.setNuevoTipoExpediente(res), "Aviso", JOptionPane.INFORMATION_MESSAGE); 
                 exp.gettiposExpedientes(jcb_tipoexpediente);
                
            }
            else
                JOptionPane.showMessageDialog(this, "Valor Incorrecto", "Aviso", JOptionPane.WARNING_MESSAGE);

        }
        }catch(NullPointerException e){    
        }

    }//GEN-LAST:event_jcb_tipoexpedienteActionPerformed

    private void jb_agregardocumentosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_agregardocumentosActionPerformed

        if(!jtf_numeroexpediente.getText().isEmpty() &&  !jcb_tipoexpediente.getSelectedItem().equals("Selecciona"))
            
            if(regArch == null){
                regArch = new jd_registroArchivo((Frame) this.getParent(), true);
                regArch.setExpediente(jtf_numeroexpediente.getText(),jcb_tipoexpediente.getSelectedItem().toString());
                if(existeExpediente)
                    regArch.expedienteExistente((String)((DefaultTableModel) jt_contenido.getModel()).getValueAt(0, 3),existeExpediente);
                regArch.setVisible(true);
                exp.getExpediente(jtf_numeroexpediente.getText(), jt_contenido);
            }
            else{
                regArch.setExpediente(jtf_numeroexpediente.getText(),jcb_tipoexpediente.getSelectedItem().toString());
                if(existeExpediente)
                    regArch.expedienteExistente((String)((DefaultTableModel) jt_contenido.getModel()).getValueAt(0, 3),existeExpediente);
                regArch.setVisible(true);
                exp.getExpediente(jtf_numeroexpediente.getText(), jt_contenido);
            }
        
        else
            JOptionPane.showMessageDialog(this, "Introduce un Numero de Expediente o Tipo de Expediente Valido", "Aviso", JOptionPane.INFORMATION_MESSAGE);
            
    }//GEN-LAST:event_jb_agregardocumentosActionPerformed

    private void jmi_abrirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmi_abrirActionPerformed

        int i = jt_contenido.getSelectedRow();

        if(i != -1) 
            exp.getArchivo(jcb_tipoexpediente.getSelectedItem().toString(), jtf_numeroexpediente.getText(),
                    (String)((DefaultTableModel) jt_contenido.getModel()).getValueAt(i,4), // Clasificacion
                    (String)((DefaultTableModel) jt_contenido.getModel()).getValueAt(i, 0), //Nombre del Cocumento
                    (String)((DefaultTableModel) jt_contenido.getModel()).getValueAt(i, 5)); // Extension del documento

    }//GEN-LAST:event_jmi_abrirActionPerformed

    private void jb_salirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_salirActionPerformed

        model = (DefaultTableModel) jt_contenido.getModel();
        
        for (int i = model.getRowCount(); i > 0; i--) {
            model.removeRow(i-1);
        }
        
        jcb_tipoexpediente.setEnabled(true);
        jtf_numeroexpediente.setText("");
        
        dispose();
        
    }//GEN-LAST:event_jb_salirActionPerformed

    private void jt_contenidoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jt_contenidoMouseClicked

        if(jt_contenido.getSelectedRow() != -1){
            
            model = (DefaultTableModel) jt_contenido.getModel();
            jt_contenido.setToolTipText((String)model.getValueAt(jt_contenido.getSelectedRow(), 2));
            
        }
        
    }//GEN-LAST:event_jt_contenidoMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jb_agregardocumentos;
    private javax.swing.JButton jb_generarId;
    private javax.swing.JButton jb_salir;
    private javax.swing.JComboBox jcb_tipoexpediente;
    private javax.swing.JLabel jl_escudo;
    private javax.swing.JLabel jl_numeroexpediente;
    private javax.swing.JLabel jl_tipoexpediente;
    private javax.swing.JMenuItem jmi_abrir;
    private javax.swing.JPanel jp_contenedor;
    private javax.swing.JPanel jp_contenedortabla;
    private javax.swing.JTable jt_contenido;
    private javax.swing.JTextField jtf_numeroexpediente;
    // End of variables declaration//GEN-END:variables
}
