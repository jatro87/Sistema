package vista;

import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.SwingWorker;
import javax.swing.filechooser.FileNameExtensionFilter;
import modelo.CBarraProgreso;
import modelo.CEjecutaArchivo;
import modelo.CExpediente;

/**
 *
 * @author jatro
 */

public class jd_registroArchivo extends javax.swing.JDialog {

    private final JFileChooser jfc;
    private File archOri;
    private final CExpediente exp;
    private String expediente, tipoExpediente, nombreArchivo, descripcion, ubicacion, clasificacion, extension;
    private boolean continuar;
    private CBarraProgreso barritaProgreso;
    private CEjecutaArchivo visualizar;
    jd_progreso prog;
    
    public jd_registroArchivo(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        
        jfc = new JFileChooser();
               
        jfc.setFileFilter(new FileNameExtensionFilter("Archivo Comprimido", "zip"));
        jfc.setFileFilter(new FileNameExtensionFilter("Archivo GIMP", "xcf" , "xcf"));
        jfc.setFileFilter(new FileNameExtensionFilter("Archivo Imagen", "jpg" , "jpeg", "png"));
        jfc.setFileFilter(new FileNameExtensionFilter("Documento Office", "pptx" , "pps", "xlsm","xlsx" , "docx", "doc"));
        jfc.setFileFilter(new FileNameExtensionFilter("Documento PDF", "pdf"));

        jfc.setFileSelectionMode(JFileChooser.FILES_ONLY);
        jfc.setMultiSelectionEnabled(false);
        prog = new jd_progreso(parent, true);
        exp = new CExpediente();
        visualizar = new CEjecutaArchivo();
        exp.getUbicacionesExpedientes(jcb_ubicacion);
        exp.getClasificacionExpediente(jcb_clasificaicon);
        setLocationRelativeTo(parent);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLayeredPane1 = new javax.swing.JLayeredPane();
        jp_contenedor = new javax.swing.JPanel();
        jl_abrirArchivo = new javax.swing.JLabel();
        jb_abrirArchivo = new javax.swing.JButton();
        jl_nombreArchivo = new javax.swing.JLabel();
        jtf_nombreArchivo = new javax.swing.JTextField();
        jl_descripcion = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jl_ubicacion = new javax.swing.JLabel();
        jcb_ubicacion = new javax.swing.JComboBox();
        jb_guardar = new javax.swing.JButton();
        jb_salir = new javax.swing.JButton();
        jtf_ubicacionArchivo = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jcb_clasificaicon = new javax.swing.JComboBox();
        jButton1 = new javax.swing.JButton();

        javax.swing.GroupLayout jLayeredPane1Layout = new javax.swing.GroupLayout(jLayeredPane1);
        jLayeredPane1.setLayout(jLayeredPane1Layout);
        jLayeredPane1Layout.setHorizontalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jLayeredPane1Layout.setVerticalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Agregar Documento");
        setResizable(false);

        jp_contenedor.setBackground(new java.awt.Color(255, 255, 255));

        jl_abrirArchivo.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jl_abrirArchivo.setText("Archivo:");

        jb_abrirArchivo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/agregar.png"))); // NOI18N
        jb_abrirArchivo.setToolTipText("Dialogo Para Seleccionar un Archivo");
        jb_abrirArchivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_abrirArchivoActionPerformed(evt);
            }
        });

        jl_nombreArchivo.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jl_nombreArchivo.setText("Nombre:");

        jtf_nombreArchivo.setForeground(new java.awt.Color(0, 0, 204));
        jtf_nombreArchivo.setToolTipText("Nombre del Documento");

        jl_descripcion.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jl_descripcion.setText("Descripcion:");

        jTextArea1.setColumns(20);
        jTextArea1.setForeground(new java.awt.Color(0, 0, 204));
        jTextArea1.setLineWrap(true);
        jTextArea1.setRows(5);
        jTextArea1.setToolTipText("Introduce una descripcion del documento.");
        jScrollPane1.setViewportView(jTextArea1);

        jl_ubicacion.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jl_ubicacion.setText("Ubicacion:");

        jcb_ubicacion.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jcb_ubicacion.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecciona", "*Nuevo" }));
        jcb_ubicacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcb_ubicacionActionPerformed(evt);
            }
        });

        jb_guardar.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jb_guardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/Save-icon.png"))); // NOI18N
        jb_guardar.setText("Guardar");
        jb_guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_guardarActionPerformed(evt);
            }
        });

        jb_salir.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jb_salir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/salir.png"))); // NOI18N
        jb_salir.setText("Salir");
        jb_salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_salirActionPerformed(evt);
            }
        });

        jtf_ubicacionArchivo.setEditable(false);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel1.setText("Categoria:");

        jcb_clasificaicon.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jcb_clasificaicon.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecciona", "*Nuevo" }));
        jcb_clasificaicon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcb_clasificaiconActionPerformed(evt);
            }
        });

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/preview.png"))); // NOI18N
        jButton1.setToolTipText("Visualizar Archivo");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jp_contenedorLayout = new javax.swing.GroupLayout(jp_contenedor);
        jp_contenedor.setLayout(jp_contenedorLayout);
        jp_contenedorLayout.setHorizontalGroup(
            jp_contenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jp_contenedorLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jp_contenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jp_contenedorLayout.createSequentialGroup()
                        .addGroup(jp_contenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jl_descripcion)
                            .addComponent(jl_nombreArchivo)
                            .addComponent(jl_abrirArchivo)
                            .addComponent(jl_ubicacion)
                            .addComponent(jLabel1))
                        .addGap(18, 18, 18)
                        .addGroup(jp_contenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 296, Short.MAX_VALUE)
                            .addComponent(jcb_ubicacion, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jp_contenedorLayout.createSequentialGroup()
                                .addGroup(jp_contenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jtf_nombreArchivo, javax.swing.GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE)
                                    .addComponent(jtf_ubicacionArchivo))
                                .addGap(18, 18, 18)
                                .addComponent(jb_abrirArchivo)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jcb_clasificaicon, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jp_contenedorLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jb_guardar)
                        .addGap(18, 18, 18)
                        .addComponent(jb_salir)))
                .addContainerGap())
        );
        jp_contenedorLayout.setVerticalGroup(
            jp_contenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jp_contenedorLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jp_contenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jb_abrirArchivo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jp_contenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jl_abrirArchivo, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jtf_ubicacionArchivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jp_contenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jl_nombreArchivo)
                    .addComponent(jtf_nombreArchivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jp_contenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jl_descripcion)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jp_contenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jcb_ubicacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jl_ubicacion, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jp_contenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jcb_clasificaicon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jp_contenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jb_salir)
                    .addComponent(jb_guardar))
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
            .addComponent(jp_contenedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jb_abrirArchivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_abrirArchivoActionPerformed
        // TODO add your handling code here:
        if(JFileChooser.APPROVE_OPTION == jfc.showOpenDialog(this)){
            
            archOri = jfc.getSelectedFile();
            jtf_ubicacionArchivo.setText(archOri.getName());
            extension =  archOri.getName();
            extension = extension.substring(extension.lastIndexOf("."));
            
        }
    }//GEN-LAST:event_jb_abrirArchivoActionPerformed

    private void jb_guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_guardarActionPerformed
        // TODO add your handling code here:
            barritaProgreso = new CBarraProgreso();
            barritaProgreso.setJDProgreso(prog);
            barritaProgreso.setProgreso(0);
            barritaProgreso.setTexto("Registrando Archivo  ...");
            barritaProgreso.start();
            
            SwingWorker<String, Void> worker = new SwingWorker<String, Void>() {
            
                @Override
                protected String doInBackground(){
                    
                    continuar = true;

                    if(continuar && !jtf_nombreArchivo.getText().equals(""))
                        nombreArchivo = jtf_nombreArchivo.getText();
                    else
                        continuar = false;

                    if(continuar && !jTextArea1.getText().equals(""))
                        descripcion = jTextArea1.getText();
                    else
                        continuar = false;

                    if(continuar && !jcb_ubicacion.getSelectedItem().equals("Selecciona"))
                        ubicacion = jcb_ubicacion.getSelectedItem().toString();
                    else
                        continuar = false;

                    if(continuar && !jcb_clasificaicon.getSelectedItem().equals("Selecciona"))
                        clasificacion = jcb_clasificaicon.getSelectedItem().toString();
                    else
                        continuar = false;

                     barritaProgreso.setProgreso(50);
                     barritaProgreso.setTexto("Copiando Archivo  ...");
                    
                    if(continuar && archOri.exists()){
                        
                         barritaProgreso.setProgreso(50);
                         
                         String res = exp.setExpediente(expediente, tipoExpediente,clasificacion, nombreArchivo,
                                        descripcion, ubicacion, archOri, extension);
                         barritaProgreso.setTexto(res );
                         
                         if(res.equals("Expediente Registrado.")){
                             archOri.delete();
                         }
                         else
                             barritaProgreso.setTexto("Error");

                      barritaProgreso.setProgreso(80);
                      barritaProgreso.setTexto("Registrando en la Base de Datos  ...");
                        
                        jtf_nombreArchivo.setText("");
                        jtf_ubicacionArchivo.setText("");
                        jTextArea1.setText("");
                        jcb_ubicacion.setSelectedItem("Selecciona");
                        dispose();

                    }

                    if(!continuar)
                        JOptionPane.showMessageDialog(null, "Introduce los Datos Correctamente.", "Aviso", JOptionPane.WARNING_MESSAGE);
                    
                    return "";
                    
                }   
            
                @Override
                protected void done() {
                    barritaProgreso.setProgreso(100);
                    barritaProgreso.setTexto("Completado ...");
                    prog.setVisible(false);
                }
            };
            
            worker.execute();
            prog.setVisible(true);
            
    }//GEN-LAST:event_jb_guardarActionPerformed

    private void jb_salirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_salirActionPerformed
        // TODO add your handling code here:
        jcb_ubicacion.setSelectedItem("Selecciona");
        dispose();
    }//GEN-LAST:event_jb_salirActionPerformed

    private void jcb_ubicacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcb_ubicacionActionPerformed
        // TODO add your handling code here:
        try{

            if(jcb_ubicacion.getSelectedItem().equals("*Nuevo")){

                String res;
                res = JOptionPane.showInputDialog(this, "Introduce el nuevo tipo de expediente:", "Nuevo Tipo", JOptionPane.DEFAULT_OPTION);   

                if(res != null){

                    JOptionPane.showMessageDialog(this, exp.setNuevaUbicacionExpediente(res), "Aviso", JOptionPane.INFORMATION_MESSAGE); 
                    exp.getUbicacionesExpedientes(jcb_ubicacion);

                }
                else
                    JOptionPane.showMessageDialog(this, "Valor Incorrecto", "Aviso", JOptionPane.WARNING_MESSAGE);

            }
            }catch(NullPointerException e){    
            }
    }//GEN-LAST:event_jcb_ubicacionActionPerformed

    private void jcb_clasificaiconActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcb_clasificaiconActionPerformed
        // TODO add your handling code here:
        try{

            if(jcb_clasificaicon.getSelectedItem().equals("*Nuevo")){

                String res;
                res = JOptionPane.showInputDialog(this, "Introduce la Nueva Clasificacion:", "Nuevo Tipo", JOptionPane.DEFAULT_OPTION);   

                if(res != null){

                    JOptionPane.showMessageDialog(this, exp.setNuevaClasificacionExpediente(res), "Aviso", JOptionPane.INFORMATION_MESSAGE); 
                    exp.getClasificacionExpediente(jcb_clasificaicon);

                }
                else
                    JOptionPane.showMessageDialog(this, "Valor Incorrecto", "Aviso", JOptionPane.WARNING_MESSAGE);

            }
        }catch(NullPointerException e){    
        }
    }//GEN-LAST:event_jcb_clasificaiconActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        if(!jtf_ubicacionArchivo.getText().equals("")){
            visualizar.setFile(archOri);
            visualizar.ejecuta();          
        }
        else{
            JOptionPane.showMessageDialog(this, "Selecciona un archivo.", "Aviso",JOptionPane.INFORMATION_MESSAGE);
        }
   
    }//GEN-LAST:event_jButton1ActionPerformed

    public void setExpediente(String exp,String tipoExp){
        this.expediente = exp;
        this.tipoExpediente = tipoExp;
    }
    
    public void expedienteExistente(String ubicacion, boolean existe){
      
        if(existe)
            jcb_ubicacion.setSelectedItem(ubicacion);
        
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JButton jb_abrirArchivo;
    private javax.swing.JButton jb_guardar;
    private javax.swing.JButton jb_salir;
    private javax.swing.JComboBox jcb_clasificaicon;
    private javax.swing.JComboBox jcb_ubicacion;
    private javax.swing.JLabel jl_abrirArchivo;
    private javax.swing.JLabel jl_descripcion;
    private javax.swing.JLabel jl_nombreArchivo;
    private javax.swing.JLabel jl_ubicacion;
    private javax.swing.JPanel jp_contenedor;
    private javax.swing.JTextField jtf_nombreArchivo;
    private javax.swing.JTextField jtf_ubicacionArchivo;
    // End of variables declaration//GEN-END:variables
}