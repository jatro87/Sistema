package vista;

import com.toedter.calendar.JTextFieldDateEditor;
import java.awt.Component;
import java.io.File;
import java.util.ArrayList;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import modelo.CDibujaFoto;
import modelo.CError;
import modelo.CExpediente;
import modelo.CFocusComponent;
import modelo.CHistorialSistema;
import modelo.CTrabajador;

/**
 *
 * @author jatro
 */

public class jd_altaTrabajador extends javax.swing.JDialog {

    private CTrabajador trabajador = null;
    private jd_hijos hijos = null;
    private ArrayList <Component> listaComponentes;
    private jd_telefonos telefonos= null;
    private int numHijos = 0, numeTelefonos = 0;
    private File archOrig = null;
    private JFileChooser jfc;
    private CDibujaFoto foto;
    private boolean continuar;
    private CExpediente nuevoExpediente;
    private CError error;
    private CHistorialSistema consola;
    private CFocusComponent ordenComponentes;
    
    public jd_altaTrabajador(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
         consola = new CHistorialSistema();
        trabajador = new CTrabajador();
        trabajador.domicilio.getColonias(jcb_colonia);
        trabajador.domicilio.getCiudades(jcb_ciudades);
        trabajador.salud.getGruposSanguineos(jcb_tipoSanguineo);
        trabajador.estudios.getGradoEstudios(jcb_escolaridad);
        trabajador.estudios.getEspecialidad(jcb_especialidad);
        trabajador.familia.getEstadoCivil(jcb_estadoCivil);
        
        foto = new CDibujaFoto(jPanel3);
        jPanel3.add(foto);
        
        jfc = new JFileChooser();
        jfc.setFileFilter(new FileNameExtensionFilter("Archivo Imagen", "jpg" , "jpeg", "png"));
        
        telefonos = new jd_telefonos(parent, true);
        
        buttonGroup1.add(jRadioButton1);
        buttonGroup1.add(jRadioButton2);
        
        nuevoExpediente = new CExpediente();
        
        listaComponentes = new ArrayList();
        
        listaComponentes.add(jtf_nombre);
        listaComponentes.add(jtf_apellidoP);
        listaComponentes.add(jtf_apellidoM);
        listaComponentes.add(jtf_calle);
        listaComponentes.add(jcb_colonia);
        listaComponentes.add(jtf_numero);
        listaComponentes.add(jtf_codigoPostal);
        listaComponentes.add(jcb_ciudades);
        listaComponentes.add(jtf_rfc);
        listaComponentes.add(jtf_curp);
        listaComponentes.add(jtf_clave);
        listaComponentes.add(jtf_noFicha);
        listaComponentes.add(jcb_escolaridad);
        listaComponentes.add(jcb_especialidad);
        listaComponentes.add(jcb_tipoSanguineo);
        listaComponentes.add(jtf_recomendacion);
        listaComponentes.add(jtf_apodo);
        listaComponentes.add(jcb_estadoCivil);
        listaComponentes.add(jtf_esposa);
        listaComponentes.add(jRadioButton1);
        listaComponentes.add(jRadioButton2);
        listaComponentes.add(jb_guardar);
        
        ordenComponentes = new CFocusComponent(listaComponentes);
        setFocusTraversalPolicy(ordenComponentes);
        
        JTextFieldDateEditor editor = (JTextFieldDateEditor) jdc_nacimiento.getDateEditor();
        editor.setEditable(false);
        
        setLocationRelativeTo(parent);  
 
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jtf_nombre = new javax.swing.JTextField();
        jtf_apellidoP = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jtf_apellidoM = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jtf_calle = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jtf_numero = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel9 = new javax.swing.JLabel();
        jtf_rfc = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jtf_curp = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jtf_clave = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jtf_noFicha = new javax.swing.JTextField();
        jcb_colonia = new javax.swing.JComboBox();
        jLabel10 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jcb_escolaridad = new javax.swing.JComboBox();
        jLabel16 = new javax.swing.JLabel();
        jcb_especialidad = new javax.swing.JComboBox();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jcb_convenioMedico = new javax.swing.JCheckBox();
        jLabel19 = new javax.swing.JLabel();
        jcb_tipoSanguineo = new javax.swing.JComboBox();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jdc_nacimiento = new com.toedter.calendar.JDateChooser();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jtf_recomendacion = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        jtf_apodo = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        jtf_numeroConvenio = new javax.swing.JTextField();
        jb_guardar = new javax.swing.JButton();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jcb_estadoCivil = new javax.swing.JComboBox();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel28 = new javax.swing.JLabel();
        jtf_esposa = new javax.swing.JTextField();
        jLabel29 = new javax.swing.JLabel();
        jcb_hijos = new javax.swing.JCheckBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        jt_hijos = new javax.swing.JTable();
        jb_agregarHijos = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jb_agregarFoto = new javax.swing.JButton();
        jLabel30 = new javax.swing.JLabel();
        jtf_codigoPostal = new javax.swing.JTextField();
        jLabel31 = new javax.swing.JLabel();
        jcb_ciudades = new javax.swing.JComboBox();
        jLabel32 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jt_telefonos = new javax.swing.JTable();
        jb_agregarTelefonos = new javax.swing.JButton();
        jcb_telefonos = new javax.swing.JCheckBox();
        jLabel33 = new javax.swing.JLabel();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Alta Trabajador");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel1.setText("Nombre:");

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel2.setText("Apellido Paterno:");

        jtf_nombre.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jtf_nombre.setForeground(new java.awt.Color(0, 102, 0));

        jtf_apellidoP.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jtf_apellidoP.setForeground(new java.awt.Color(0, 102, 0));

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel3.setText("Apellido Materno:");

        jtf_apellidoM.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jtf_apellidoM.setForeground(new java.awt.Color(0, 102, 0));

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Domicilio");

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel5.setText("Calle:");

        jtf_calle.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jtf_calle.setForeground(new java.awt.Color(0, 102, 0));

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel6.setText("Colonia:");

        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel7.setText("Numero:");

        jtf_numero.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jtf_numero.setForeground(new java.awt.Color(0, 102, 0));

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jLabel9.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel9.setText("Rfc:");

        jtf_rfc.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jtf_rfc.setForeground(new java.awt.Color(0, 102, 0));

        jLabel11.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel11.setText("Curp:");

        jtf_curp.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jtf_curp.setForeground(new java.awt.Color(0, 102, 0));

        jLabel12.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel12.setText("Clave:");

        jtf_clave.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jtf_clave.setForeground(new java.awt.Color(0, 102, 0));

        jLabel13.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel13.setText("No. ficha:");

        jtf_noFicha.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jtf_noFicha.setForeground(new java.awt.Color(0, 102, 0));

        jcb_colonia.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jcb_colonia.setForeground(new java.awt.Color(0, 102, 0));
        jcb_colonia.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecciona", "*Nuevo" }));
        jcb_colonia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcb_coloniaActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("Identificacion");

        jLabel14.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("Escolaridad");

        jLabel15.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel15.setText("Estudios:");

        jcb_escolaridad.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jcb_escolaridad.setForeground(new java.awt.Color(0, 102, 0));
        jcb_escolaridad.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecciona", "*Nuevo" }));
        jcb_escolaridad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcb_escolaridadActionPerformed(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel16.setText("Especialidad:");

        jcb_especialidad.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jcb_especialidad.setForeground(new java.awt.Color(0, 102, 0));
        jcb_especialidad.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecciona", "*Nuevo" }));
        jcb_especialidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcb_especialidadActionPerformed(evt);
            }
        });

        jLabel17.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel17.setText("Salud");

        jLabel18.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel18.setText("Convenio Medico:");

        jcb_convenioMedico.setBackground(new java.awt.Color(255, 255, 255));
        jcb_convenioMedico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcb_convenioMedicoActionPerformed(evt);
            }
        });

        jLabel19.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel19.setText("Tipo Sanguineo:");

        jcb_tipoSanguineo.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jcb_tipoSanguineo.setForeground(new java.awt.Color(0, 102, 0));
        jcb_tipoSanguineo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecciona", "*Nuevo" }));
        jcb_tipoSanguineo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcb_tipoSanguineoActionPerformed(evt);
            }
        });

        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jLabel20.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel20.setText("Extras");

        jLabel21.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel21.setText("Fecha Nacimiento:");

        jdc_nacimiento.setForeground(new java.awt.Color(0, 102, 0));
        jdc_nacimiento.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N

        jLabel22.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel22.setText("Telefonos:");

        jLabel23.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel23.setText("Recomendado:");

        jtf_recomendacion.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jtf_recomendacion.setForeground(new java.awt.Color(0, 102, 0));

        jLabel24.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel24.setText("Apodo:");

        jtf_apodo.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jtf_apodo.setForeground(new java.awt.Color(0, 102, 0));

        jLabel25.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel25.setText("Numero:");

        jtf_numeroConvenio.setEditable(false);
        jtf_numeroConvenio.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jtf_numeroConvenio.setForeground(new java.awt.Color(0, 102, 0));

        jb_guardar.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jb_guardar.setText("Guardar");
        jb_guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_guardarActionPerformed(evt);
            }
        });

        jLabel26.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel26.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel26.setText("Familiares");

        jLabel27.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel27.setText("Estado Civil:");

        jcb_estadoCivil.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jcb_estadoCivil.setForeground(new java.awt.Color(0, 102, 0));
        jcb_estadoCivil.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecciona", "*Nuevo" }));
        jcb_estadoCivil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcb_estadoCivilActionPerformed(evt);
            }
        });

        jSeparator3.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jLabel28.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel28.setText("Esposa(o):");

        jtf_esposa.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jtf_esposa.setForeground(new java.awt.Color(0, 102, 0));

        jLabel29.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel29.setText("Hijos:");

        jcb_hijos.setBackground(new java.awt.Color(255, 255, 255));
        jcb_hijos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcb_hijosActionPerformed(evt);
            }
        });

        jt_hijos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "Nacimiento"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jt_hijos);

        jb_agregarHijos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/icon_add.png"))); // NOI18N
        jb_agregarHijos.setEnabled(false);
        jb_agregarHijos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_agregarHijosActionPerformed(evt);
            }
        });

        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/Logo SUTSHA Azul finalSF_3.png"))); // NOI18N

        jPanel2.setBackground(new java.awt.Color(0, 0, 0));

        jPanel3.setBackground(new java.awt.Color(204, 255, 204));

        jb_agregarFoto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/icon_add.png"))); // NOI18N
        jb_agregarFoto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_agregarFotoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(148, Short.MAX_VALUE)
                .addComponent(jb_agregarFoto)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(261, Short.MAX_VALUE)
                .addComponent(jb_agregarFoto)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel30.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel30.setText("Codigo Postal:");

        jtf_codigoPostal.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jtf_codigoPostal.setForeground(new java.awt.Color(0, 102, 0));

        jLabel31.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel31.setText("Ciudad");

        jcb_ciudades.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jcb_ciudades.setForeground(new java.awt.Color(0, 102, 0));
        jcb_ciudades.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecciona", "*Nuevo" }));
        jcb_ciudades.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcb_ciudadesActionPerformed(evt);
            }
        });

        jLabel32.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel32.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel32.setText("Personales");

        jt_telefonos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Telefono", "Tipo"
            }
        ));
        jScrollPane2.setViewportView(jt_telefonos);

        jb_agregarTelefonos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/icon_add.png"))); // NOI18N
        jb_agregarTelefonos.setEnabled(false);
        jb_agregarTelefonos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_agregarTelefonosActionPerformed(evt);
            }
        });

        jcb_telefonos.setBackground(new java.awt.Color(255, 255, 255));
        jcb_telefonos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcb_telefonosActionPerformed(evt);
            }
        });

        jLabel33.setText("Sexo:");

        jRadioButton1.setBackground(new java.awt.Color(255, 255, 255));
        jRadioButton1.setText("H");

        jRadioButton2.setBackground(new java.awt.Color(255, 255, 255));
        jRadioButton2.setText("M");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel32, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel12)
                                .addGap(18, 18, 18)
                                .addComponent(jtf_clave, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel31)
                                .addGap(18, 18, 18)
                                .addComponent(jcb_ciudades, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel30)
                                .addGap(18, 18, 18)
                                .addComponent(jtf_codigoPostal, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(jtf_apellidoP, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(18, 18, 18)
                                .addComponent(jtf_apellidoM, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addComponent(jtf_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(18, 18, 18)
                                .addComponent(jtf_calle, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(18, 18, 18)
                                .addComponent(jcb_colonia, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addGap(18, 18, 18)
                                .addComponent(jtf_numero, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addGap(18, 18, 18)
                                .addComponent(jtf_rfc, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel11)
                                .addGap(18, 18, 18)
                                .addComponent(jtf_curp, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel13)
                                .addGap(18, 18, 18)
                                .addComponent(jtf_noFicha))
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 2, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel15)
                                .addGap(18, 18, 18)
                                .addComponent(jcb_escolaridad, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel16)
                                .addGap(18, 18, 18)
                                .addComponent(jcb_especialidad, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel18)
                                .addGap(18, 18, 18)
                                .addComponent(jcb_convenioMedico))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel25)
                                .addGap(18, 18, 18)
                                .addComponent(jtf_numeroConvenio, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel19)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jcb_tipoSanguineo, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel21)
                                .addGap(18, 18, 18)
                                .addComponent(jdc_nacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(22, 22, 22))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addGap(10, 10, 10))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel24)
                                .addGap(18, 18, 18)
                                .addComponent(jtf_apodo, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel23)
                                .addGap(18, 18, 18)
                                .addComponent(jtf_recomendacion, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel22)
                        .addGap(18, 18, 18)
                        .addComponent(jcb_telefonos)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jb_agregarTelefonos)
                        .addGap(32, 32, 32)))
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jb_guardar))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel29)
                        .addGap(18, 18, 18)
                        .addComponent(jcb_hijos)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jb_agregarHijos))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel33)
                                .addGap(18, 18, 18)
                                .addComponent(jRadioButton1)
                                .addGap(18, 18, 18)
                                .addComponent(jRadioButton2))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                            .addComponent(jLabel27)
                                            .addGap(18, 18, 18))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addComponent(jLabel28)
                                            .addGap(32, 32, 32)))
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jcb_estadoCivil, 0, 161, Short.MAX_VALUE)
                                        .addComponent(jtf_esposa)))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jSeparator3, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator2)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jSeparator1)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel32)
                                    .addGap(18, 18, 18)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel1)
                                        .addComponent(jtf_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(18, 18, 18)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel2)
                                        .addComponent(jtf_apellidoP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(18, 18, 18)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel3)
                                        .addComponent(jtf_apellidoM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(18, 18, 18)
                                    .addComponent(jLabel4)
                                    .addGap(18, 18, 18)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel5)
                                        .addComponent(jtf_calle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(18, 18, 18)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel6)
                                        .addComponent(jcb_colonia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(18, 18, 18)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel7)
                                        .addComponent(jtf_numero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(18, 18, 18)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel30)
                                        .addComponent(jtf_codigoPostal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(18, 18, 18)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel31)
                                        .addComponent(jcb_ciudades, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(18, 18, 18)
                                    .addComponent(jLabel10)
                                    .addGap(18, 18, 18)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel9)
                                        .addComponent(jtf_rfc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(18, 18, 18)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel11)
                                        .addComponent(jtf_curp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(18, 18, 18)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel12)
                                        .addComponent(jtf_clave, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(18, 18, 18)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel13)
                                        .addComponent(jtf_noFicha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addComponent(jLabel14)
                                            .addGap(18, 18, 18)
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(jLabel15)
                                                .addComponent(jcb_escolaridad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGap(18, 18, 18)
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(jLabel16)
                                                .addComponent(jcb_especialidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGap(18, 18, 18)
                                            .addComponent(jLabel17)
                                            .addGap(18, 18, 18)
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jcb_convenioMedico))
                                            .addGap(18, 18, 18)
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jtf_numeroConvenio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGap(18, 18, 18)
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(jLabel19)
                                                .addComponent(jcb_tipoSanguineo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGap(18, 18, 18)
                                            .addComponent(jLabel20)
                                            .addGap(18, 18, 18)
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jdc_nacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGap(18, 18, 18)
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addComponent(jb_agregarTelefonos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addComponent(jcb_telefonos))
                                            .addGap(18, 18, 18)
                                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGap(18, 18, 18)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel23)
                                        .addComponent(jtf_recomendacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel24)
                                        .addComponent(jtf_apodo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel26)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel27)
                                    .addComponent(jcb_estadoCivil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel28)
                                    .addComponent(jtf_esposa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(21, 21, 21)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jcb_hijos)
                                                .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(jb_agregarHijos))
                                        .addGap(18, 18, 18)
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel33)
                                            .addComponent(jRadioButton1)
                                            .addComponent(jRadioButton2)))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addGap(135, 135, 135)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jb_guardar))))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jcb_coloniaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcb_coloniaActionPerformed
        // TODO add your handling code here:
        try{
            
            if(jcb_colonia.getSelectedItem().equals("*Nuevo")){
                
                String res;
                res = JOptionPane.showInputDialog(this, "Introduce la colonia:", "Nueva Colonia", JOptionPane.DEFAULT_OPTION);   
            
                if(res != null){

                    JOptionPane.showMessageDialog(this, trabajador.domicilio.setColoniaBD(res), "Aviso", JOptionPane.INFORMATION_MESSAGE); 
                    trabajador.domicilio.getColonias(jcb_colonia);
                    
                }
            }
            
        }catch(NullPointerException x){           
            error = new  CError();
            error.setExepcion(x);
            error.setClase("jd_altaTrabajador");
            error.setFechaHora();
            error.setMetodo(" jcb_coloniaActionPerformed(java.awt.event.ActionEvent evt)");
            consola.setError(error);
        }
    }//GEN-LAST:event_jcb_coloniaActionPerformed

    private void jcb_escolaridadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcb_escolaridadActionPerformed
        // TODO add your handling code here:
        try{
            
            if(jcb_escolaridad.getSelectedItem().equals("*Nuevo")){
                
                String res;
                res = JOptionPane.showInputDialog(this, "Introduce el grado de estudios:", "Nuevo Grado", JOptionPane.DEFAULT_OPTION);   
            
                if(res != null){

                    JOptionPane.showMessageDialog(this, trabajador.estudios.setGradoEstudios(res), "Aviso", JOptionPane.INFORMATION_MESSAGE); 
                    trabajador.estudios.getGradoEstudios(jcb_escolaridad);
                    
                }
            }
            
        }catch(NullPointerException x){
            error = new  CError();
            error.setExepcion(x);
            error.setClase("jd_altaTrabajador");
            error.setFechaHora();
            error.setMetodo("jcb_escolaridadActionPerformed(java.awt.event.ActionEvent evt)");
            consola.setError(error);
        }
    }//GEN-LAST:event_jcb_escolaridadActionPerformed

    private void jcb_tipoSanguineoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcb_tipoSanguineoActionPerformed
        // TODO add your handling code here:
        try{
            
            if(jcb_tipoSanguineo.getSelectedItem().equals("*Nuevo")){
                
                String res;
                res = JOptionPane.showInputDialog(this, "Introduce el tipo de sangre:", "Nuevo grupo sanguineo", JOptionPane.DEFAULT_OPTION);   
            
                if(res != null){

                    JOptionPane.showMessageDialog(this, trabajador.salud.setGrupoSanguineo(res), "Aviso", JOptionPane.INFORMATION_MESSAGE); 
                    trabajador.salud.getGruposSanguineos(jcb_tipoSanguineo);
                    
                }
            }
            
        }catch(NullPointerException x){
            error = new  CError();
            error.setExepcion(x);
            error.setClase("jd_altaTrabajador");
            error.setFechaHora();
            error.setMetodo(" jcb_tipoSanguineoActionPerformed(java.awt.event.ActionEvent evt)");
            consola.setError(error);            
        }
    }//GEN-LAST:event_jcb_tipoSanguineoActionPerformed

    private void jcb_especialidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcb_especialidadActionPerformed
        // TODO add your handling code here:
        try{
            
            if(jcb_especialidad.getSelectedItem().equals("*Nuevo")){
                
                String res;
                res = JOptionPane.showInputDialog(this, "Introduce la nueva especialidad:", "Nueva Especialidad", JOptionPane.DEFAULT_OPTION);   
            
                if(res != null){

                    JOptionPane.showMessageDialog(this, trabajador.estudios.setNuevaEspecialidad(res), "Aviso", JOptionPane.INFORMATION_MESSAGE); 
                    trabajador.estudios.getEspecialidad(jcb_especialidad);
                    
                }
            }
            
        }catch(NullPointerException x){
            error = new  CError();
            error.setExepcion(x);
            error.setClase("jd_altaTrabajador");
            error.setFechaHora();
            error.setMetodo("jcb_especialidadActionPerformed(java.awt.event.ActionEvent evt) ");
            consola.setError(error);      
        }
    }//GEN-LAST:event_jcb_especialidadActionPerformed

    private void jcb_convenioMedicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcb_convenioMedicoActionPerformed
        // TODO add your handling code here:
        if(jcb_convenioMedico.isSelected())
            jtf_numeroConvenio.setEditable(true);
        else
            jtf_numeroConvenio.setEditable(false);      
    }//GEN-LAST:event_jcb_convenioMedicoActionPerformed

    private void jcb_estadoCivilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcb_estadoCivilActionPerformed
        // TODO add your handling code here:
        try{
            
            if(jcb_estadoCivil.getSelectedItem().equals("*Nuevo")){
                
                String res;
                res = JOptionPane.showInputDialog(this, "Introduce el nuevo estado civil: ", "Nuevo Estado Civil", JOptionPane.DEFAULT_OPTION);   
            
                if(res != null){

                    JOptionPane.showMessageDialog(this, trabajador.familia.setNuevoEstadoCivil(res), "Aviso", JOptionPane.INFORMATION_MESSAGE); 
                    trabajador.familia.getEstadoCivil(jcb_estadoCivil);
                    
                }
            }
            
        }catch(NullPointerException x){
            error = new  CError();
            error.setExepcion(x);
            error.setClase("jd_altaTrabajador");
            error.setFechaHora();
            error.setMetodo(" jcb_estadoCivilActionPerformed(java.awt.event.ActionEvent evt) ");
            consola.setError(error);              
        }
    }//GEN-LAST:event_jcb_estadoCivilActionPerformed

    private void jcb_hijosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcb_hijosActionPerformed
        // TODO add your handling code here:
        if(jcb_hijos.isSelected())
            jb_agregarHijos.setEnabled(true);
        else
            jb_agregarHijos.setEnabled(false);      
    }//GEN-LAST:event_jcb_hijosActionPerformed

    private void jb_agregarHijosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_agregarHijosActionPerformed
        // TODO add your handling code here:
        if(hijos == null){
            hijos = new jd_hijos(null, true);
            hijos.setVisible(true);
            if(hijos.getDatos() != null){
                trabajador.familia.agregarHijos(hijos.getDatos(), jt_hijos, numHijos);
                numHijos ++;
            }
        }
        else{
            hijos.setVisible(true); 
            if(hijos.getDatos() != null){
                trabajador.familia.agregarHijos(hijos.getDatos(), jt_hijos, numHijos);
                numHijos ++;
            }
        }
    }//GEN-LAST:event_jb_agregarHijosActionPerformed

    private void jb_agregarFotoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_agregarFotoActionPerformed
        // TODO add your handling code here:
        if(JFileChooser.APPROVE_OPTION == jfc.showOpenDialog(this)){

            archOrig = jfc.getSelectedFile();

            foto.setFoto(archOrig);
            foto.repaint();

        }
    }//GEN-LAST:event_jb_agregarFotoActionPerformed

    private void jb_guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_guardarActionPerformed
        // TODO add your handling code here:
        if(!jtf_nombre.getText().equals("") || !jtf_apellidoP.getText().equals("") || !jtf_apellidoM.getText().equals("")){

            trabajador.setNombre(jtf_nombre.getText());
            trabajador.setApellidoP(jtf_apellidoP.getText());
            trabajador.setApellidoM(jtf_apellidoM.getText());

            if(!jtf_calle.getText().equals("") || !jtf_numero.getText().equals("") || !jtf_codigoPostal.getText().equals("") || !jcb_colonia.getSelectedItem().equals("Selecciona") || !jcb_ciudades.getSelectedItem().equals("Selecciona")){

                trabajador.domicilio.setCodigoPostal(jtf_codigoPostal.getText());
                trabajador.domicilio.setCiudad(jcb_ciudades.getSelectedItem().toString());
                trabajador.domicilio.setCalle(jtf_calle.getText());
                trabajador.domicilio.setNumero(jtf_numero.getText());
                trabajador.domicilio.setColonia(jcb_colonia.getSelectedItem().toString());

                if(!jtf_rfc.getText().equals("") || !jtf_clave.getText().equals("") || !jtf_curp.getText().equals("") || !jtf_noFicha.getText().equals("")){

                    trabajador.setRfc(jtf_rfc.getText());
                    trabajador.setCurp(jtf_curp.getText());
                    trabajador.setClave(jtf_clave.getText());
                    trabajador.setNoFicha(jtf_noFicha.getText());

                    if(!jcb_escolaridad.getSelectedItem().equals("Selecciona")){

                        trabajador.estudios.setEstudios(jcb_escolaridad.getSelectedItem().toString());
                        
                        if(jcb_escolaridad.getSelectedItem().equals("Primaria") || jcb_escolaridad.getSelectedItem().equals("Secundaria") || jcb_escolaridad.getSelectedItem().equals("Preparatoria") || jcb_escolaridad.getSelectedItem().equals("No"))
                            trabajador.estudios.setEspecialidad(jcb_escolaridad.getSelectedItem().toString());
                        else
                            trabajador.estudios.setEspecialidad(jcb_especialidad.getSelectedItem().toString());

                        if(jcb_convenioMedico.isSelected()){

                            if(!jtf_numeroConvenio.getText().equals("")){

                                continuar = true;
                                trabajador.salud.setConvenioMedico(jtf_numeroConvenio.getText());

                            }
                            else
                            continuar = false;

                        }
                        else{

                            continuar = true;
                            trabajador.salud.setConvenioMedico("No");

                        }

                        if(!jcb_tipoSanguineo.getSelectedItem().equals("Selecciona") && continuar){

                            trabajador.salud.setTipoSangre(jcb_tipoSanguineo.getSelectedItem().toString());

                            if(!jtf_recomendacion.getText().equals("") || !jtf_apodo.getText().equals("") || !((JTextField)jdc_nacimiento.getDateEditor().getUiComponent()).getText().equals("")){
//                                trabajador.setTelefono(jtf_telefono.getText());
                                trabajador.setApodo(jtf_apodo.getText());
                                trabajador.setRecomendacion(jtf_recomendacion.getText());
                                trabajador.setNacimiento(jdc_nacimiento.getDate().toString());

                                if(!jcb_estadoCivil.getSelectedItem().equals("Selecciona")){

                                    trabajador.familia.setEstadoCivil(jcb_estadoCivil.getSelectedItem().toString());

                                    if(jtf_esposa.getText().equals(""))
                                        trabajador.familia.setEsposa("No");
                                    else
                                        trabajador.familia.setEsposa(jtf_esposa.getText());

                                    if(jRadioButton1.isSelected())
                                        trabajador.setSexo("H");
                                    else
                                        trabajador.setSexo("M");
                                    
                                    String aux = trabajador.registrarTrabajador();
                                    
                                    if(aux.equals("Trabajador Registrado Correctamente.")){
                                        
                                        JOptionPane.showMessageDialog(this, aux, "Aviso", JOptionPane.INFORMATION_MESSAGE);

                                        if(archOrig != null)
                                            JOptionPane.showMessageDialog(this, nuevoExpediente.setExpediente(trabajador.getNoFicha(), "Trabajador", "Fotografias", "Foto", "Fotografia del Trabajador.", "Sin Ubicacion Fisica", archOrig, archOrig.getName().substring(archOrig.getName().lastIndexOf("."))), "Aviso", JOptionPane.INFORMATION_MESSAGE);
                                        else
                                            JOptionPane.showMessageDialog(this, nuevoExpediente.setExpediente(trabajador.getNoFicha(), "Trabajador", "Fotografias", "Foto", "Fotografia del Trabajador.", "Sin Ubicacion Fisica", new File("temp" + File.separator + "sin_foto.jpg"),".jpg"), "Aviso", JOptionPane.INFORMATION_MESSAGE);

                                        if(jcb_hijos.isSelected())
                                            trabajador.familia.setHijos(jt_hijos, trabajador.getNoFicha());

                                        if(jcb_telefonos.isSelected())
                                            trabajador.setTelefonos(jt_telefonos);

                                        limpiarDatos();
                                        
                                    }
                                    else
                                        JOptionPane.showMessageDialog(this, aux, "Aviso", JOptionPane.INFORMATION_MESSAGE);

                                }else
                                    continuar = false;
                            }
                            else
                                continuar = false;
                        }
                        else
                            continuar = false;
                    }
                    else
                        continuar = false;
                }
                else
                    continuar = false;
            }
            else
                continuar = false;
        }
        else
            continuar = false;

        if(!continuar)
            JOptionPane.showMessageDialog(this, "Verifica los datos por favor.", "Aviso", JOptionPane.WARNING_MESSAGE);

    }//GEN-LAST:event_jb_guardarActionPerformed

    private void jb_agregarTelefonosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_agregarTelefonosActionPerformed
        // TODO add your handling code here:
            telefonos.setVisible(true);
            Object [] res = telefonos.getDatos();
            if(res != null){
                trabajador.agregarTelefonos(res, jt_telefonos, numeTelefonos);
                numeTelefonos ++;
            }
    }//GEN-LAST:event_jb_agregarTelefonosActionPerformed

    private void jcb_ciudadesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcb_ciudadesActionPerformed
        // TODO add your handling code here:
        try{
            
            if(jcb_ciudades.getSelectedItem().equals("*Nuevo")){
                
                String res;
                res = JOptionPane.showInputDialog(this, "Introduce el nombre de la nueva ciudad: ", "Nueva Ciudad", JOptionPane.DEFAULT_OPTION);   
            
                if(res != null){

                    JOptionPane.showMessageDialog(this, trabajador.domicilio.setCiudadBD(res), "Aviso", JOptionPane.INFORMATION_MESSAGE); 
                    trabajador.domicilio.getCiudades(jcb_ciudades);
                    
                }
            }
            
        }catch(NullPointerException x){
            error = new  CError();
            error.setExepcion(x);
            error.setClase("jd_altaTrabajador");
            error.setFechaHora();
            error.setMetodo("jcb_ciudadesActionPerformed(java.awt.event.ActionEvent evt)");
            consola.setError(error);                    
        } 
 
    }//GEN-LAST:event_jcb_ciudadesActionPerformed

    private void jcb_telefonosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcb_telefonosActionPerformed
        // TODO add your handling code here:
        if(jcb_telefonos.isSelected())
            jb_agregarTelefonos.setEnabled(true);
        else
            jb_agregarTelefonos.setEnabled(false);
    }//GEN-LAST:event_jcb_telefonosActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        // TODO add your handling code here:
        limpiarDatos();
        dispose();
    }//GEN-LAST:event_formWindowClosed

    private void limpiarDatos(){
        
        jtf_apellidoM.setText("");
        jtf_apellidoP.setText("");
        jtf_apodo.setText("");
        jtf_calle.setText("");
        jtf_clave.setText("");
        jtf_curp.setText("");
        jtf_esposa.setText("");
        jtf_noFicha.setText("");
        jtf_nombre.setText("");
        jtf_numero.setText("");
        jtf_numeroConvenio.setText("");
        jtf_recomendacion.setText("");
        jtf_rfc.setText("");
        jtf_codigoPostal.setText("");
        
        jcb_colonia.setSelectedItem("Selecciona");
        jcb_escolaridad.setSelectedItem("Selecciona");
        jcb_especialidad.setSelectedItem("Selecciona");
        jcb_estadoCivil.setSelectedItem("Selecciona");
        jcb_tipoSanguineo.setSelectedItem("Selecciona");
        jcb_ciudades.setSelectedItem("Selecciona");
        
        jcb_convenioMedico.setSelected(false);
        jcb_hijos.setSelected(false);
        
        jb_agregarHijos.setEnabled(false);
        jb_agregarTelefonos.setEnabled(false);
        
        DefaultTableModel model = (DefaultTableModel) jt_hijos.getModel();

        for (int i = model.getRowCount(); i > 0; i--) {
            model.removeRow(i-1);
        }
        
        model = (DefaultTableModel) jt_telefonos.getModel();
        
        for (int i = model.getRowCount(); i > 0; i--) {
            model.removeRow(i-1);
        }
        

        foto.setFoto(null);
        foto.repaint();
        jPanel3.repaint();
        jRadioButton2.setSelected(false);
        jRadioButton1.setSelected(false);
        jcb_telefonos.setSelected(false);

        numHijos = 0;
        numeTelefonos = 0;
        
        ((JTextField)jdc_nacimiento.getDateEditor().getUiComponent()).setText("");
        
        archOrig = null;
        
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
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
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JButton jb_agregarFoto;
    private javax.swing.JButton jb_agregarHijos;
    private javax.swing.JButton jb_agregarTelefonos;
    private javax.swing.JButton jb_guardar;
    private javax.swing.JComboBox jcb_ciudades;
    private javax.swing.JComboBox jcb_colonia;
    private javax.swing.JCheckBox jcb_convenioMedico;
    private javax.swing.JComboBox jcb_escolaridad;
    private javax.swing.JComboBox jcb_especialidad;
    private javax.swing.JComboBox jcb_estadoCivil;
    private javax.swing.JCheckBox jcb_hijos;
    private javax.swing.JCheckBox jcb_telefonos;
    private javax.swing.JComboBox jcb_tipoSanguineo;
    private com.toedter.calendar.JDateChooser jdc_nacimiento;
    private javax.swing.JTable jt_hijos;
    private javax.swing.JTable jt_telefonos;
    private javax.swing.JTextField jtf_apellidoM;
    private javax.swing.JTextField jtf_apellidoP;
    private javax.swing.JTextField jtf_apodo;
    private javax.swing.JTextField jtf_calle;
    private javax.swing.JTextField jtf_clave;
    private javax.swing.JTextField jtf_codigoPostal;
    private javax.swing.JTextField jtf_curp;
    private javax.swing.JTextField jtf_esposa;
    private javax.swing.JTextField jtf_noFicha;
    private javax.swing.JTextField jtf_nombre;
    private javax.swing.JTextField jtf_numero;
    private javax.swing.JTextField jtf_numeroConvenio;
    private javax.swing.JTextField jtf_recomendacion;
    private javax.swing.JTextField jtf_rfc;
    // End of variables declaration//GEN-END:variables
}
