package modelo;

import controlador.ClassConectaBD;
import java.io.File;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Tadeo
 */

public class CCredencial {
    
    private final ClassConectaBD conexion;
    private CTrabajador trabajador;
    CDirectiva directiva;
    private CftpClient ftp;
    private File fotoTrabajador;
    private File frontalCredencial;
    private File traseraCredencial;
    private CDibujaCredencial lienzo;
    private CPrint print;
    
    public CCredencial(){
        
        conexion = new ClassConectaBD();
        trabajador = new  CTrabajador();
        directiva = new CDirectiva();
        ftp = new CftpClient();
        
        print = new CPrint();
        
    }
    
    public void setLienzo(JPanel lienzo){
        this.lienzo = new CDibujaCredencial(lienzo);
    }

    public String setNuevoMotivo(String nuevoTipo){

        Object [] res = conexion.ejecutarConsulta1("setNuevoMotivoCredencial(?,?)",
                new Object [] {nuevoTipo},
                new String []{"String"});
        
        return (String)res[0];
        
    }
    
    public void registraCredencial(String motivoImpresion, String tipoCredencial){

        if(tipoCredencial.equals("Directiva")){
        
            Object [] res = conexion.ejecutarConsulta1("setCredencialImpresa(?,?,?,?)",
                    new Object [] {trabajador.getNoFicha(),directiva.getCargo(),motivoImpresion,tipoCredencial},
                    new String []{});
        }
        else{
            
            Object [] res = conexion.ejecutarConsulta1("setCredencialImpresa(?,?,?,?)",
                    new Object [] {trabajador.getNoFicha(),trabajador.contrato.getDepartamento(),motivoImpresion,tipoCredencial},
                    new String []{});
            
        }
        
    }
    
    public void getHistorialCredenciales(JTable tabla, String noFicha){
        
        DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
        
         for (int i = modelo.getRowCount(); i > 0; i--) {
            modelo.removeRow(i-1);
        }       
        
        Object [] filas = new Object [7];
        
        Object [][] res = conexion.ejecutarConsulta2("getHistorialCredenciales(?)", new Object[]{noFicha}, 4);
        
        for (int i = 0; i < res.length; i++) {
            
            modelo.addRow(filas);
            
            modelo.setValueAt(res [i][0], i, 0);
            modelo.setValueAt(res [i][1], i, 1);
            modelo.setValueAt(res [i][2], i, 2);
            modelo.setValueAt(res [i][3], i, 3);
            
        }
        
    }
    
    public void registraCredencialPendiente(String motivoImpresion, String tipoCredencial){
        
        if(tipoCredencial.equals("Directiva")){
            
            Object [] res = conexion.ejecutarConsulta1("setCredencialPendiente(?,?,?,?)",
                    new Object [] {directiva.trabajador.getNoFicha(),directiva.getCargo(),motivoImpresion,tipoCredencial},
                    new String []{}); 
            
        }
        else{
          
            Object [] res = conexion.ejecutarConsulta1("setCredencialPendiente(?,?,?,?)",
                    new Object [] {trabajador.getNoFicha(),trabajador.contrato.getDepartamento(),motivoImpresion,tipoCredencial},
                    new String []{});
        
        }
        
    }
    
    public boolean getCredencialesImpresion(JTable tabla){
        
        boolean flag = false;
        
        Object [][] res = conexion.ejecutarConsulta2("getCredencialesPendientesImpresion()", new Object [] {}, 7);
        
        DefaultTableModel model = (DefaultTableModel) tabla.getModel();
        
        Object [] rows = new Object [7];

        for (int i = model.getRowCount(); i > 0; i--) {
            model.removeRow(i-1);
        }
        
        for (int i = 0; i < res.length; i++) {
            
            model.addRow(rows);  
            model.setValueAt(res[i][0], i, 0);
            model.setValueAt(res[i][1], i, 1);
            model.setValueAt(res[i][2], i, 2);
            model.setValueAt(res[i][3], i, 3);
            model.setValueAt(res[i][4], i, 4);
            model.setValueAt(res[i][5], i, 5);
            model.setValueAt(res[i][6], i, 6);
            flag = true;

        }

        return flag;
        
    }
    
    public boolean imprimeCredencialesPendientes(JTable tabla){
        
        lienzo = new CDibujaCredencial(new JPanel());
        
        DefaultTableModel model = (DefaultTableModel) tabla.getModel();
        
        for (int i = 0; i < model.getRowCount(); i++) {
            
            trabajador = new CTrabajador();
            
            getDatosCredencial(model.getValueAt(i, 0).toString(), model.getValueAt(i, 6).toString());
            
            if(model.getValueAt(i, 6).equals("Directiva")){
            
                directiva.setTrabajador(trabajador);
                directiva.setCargo(model.getValueAt(i, 3).toString());
                lienzo.setDirectiva(directiva);
                lienzo.queCredencialDibujo("Directiva");
                lienzo.setFileDibujo(fotoTrabajador, frontalCredencial, traseraCredencial);
                lienzo.creaImagenCredencialDirectiva();
                
            }
            else{
                
                trabajador.contrato.setDepartamento(model.getValueAt(i, 3).toString());
                lienzo.setTrabajador(trabajador);
                lienzo.queCredencialDibujo("Trabajador");
                lienzo.setFileDibujo(fotoTrabajador, frontalCredencial, traseraCredencial);
                lienzo.creaImagenCredencialTrabajador();
                
            }
            
        }

        return prepararImpresion();
        
    }
    
    public void borraCredencialesPendientes(){
        
        conexion.ejecutarConsulta1("setCredencialesImpresas()",
                new Object [] {},
                new String []{});
        
    }
    
    public boolean prepararImpresion(){

        print.setDocument(lienzo.generaPDF());
        
        return print.print();
//        return true;
    }
    
    public void generaCredencialArchivoTrabajador(){
        lienzo.creaImagenCredencialTrabajador();
    }
    
    public void generaCredencialArchivoDirectiva(){
        lienzo.creaImagenCredencialDirectiva();
    }
    
    public String getDatosCredencial(String noFicha, String tipoCredencial){

        Object res [] = conexion.ejecutarConsulta1("getDatosCredencial(?,?,?,?,?,?,?,?,?,?)",
                    new Object[]{noFicha},
                    new String []{"String","String","String","String","String","String","String","String","String"});

        if(res != null){
            
            if(res[0] != null){
                
                trabajador.setNombre(res [0].toString());
                trabajador.setApellidoP(res [1].toString());
                trabajador.setApellidoM(res [2].toString());
                trabajador.setNoFicha(noFicha);

            }
            else
                return "Trabajador no encontrado.";
            
            if(res [3] != null)
                trabajador.contrato.setDepartamento(res [3].toString());
            else
                trabajador.contrato.setDepartamento(null);

            if(res [4] != null){
                
                if(ftp.getFileExpediente(res[4].toString(), res[5].toString(),res[6].toString() ,res[7].toString(), res[8].toString())){
                    
                    fotoTrabajador = new File(System.getProperty("java.io.tmpdir") + File.separator + res[7].toString().replaceAll(" ", "-") + res[8].toString());
                    
                    Object res1 [][] = conexion.ejecutarConsulta2("getDiseñoCredencial(?,?)", new Object[]{noFicha,tipoCredencial}, 5);
                    
                    if(res1 != null){
                        
                        ftp.getFileExpediente(res1[0][0].toString(), res1[0][1].toString(), res1[0][2].toString(), res1[0][3].toString(), res1[0][4].toString());
                        
                        frontalCredencial = new File(System.getProperty("java.io.tmpdir") + File.separator + res1[0][3].toString().replaceAll(" ", "-") + res1[0][4].toString());
                        
                        ftp.getFileExpediente(res1[1][0].toString(), res1[1][1].toString(), res1[1][2].toString(), res1[1][3].toString(), res1[1][4].toString());
                        
                        traseraCredencial = new File(System.getProperty("java.io.tmpdir") + File.separator + res1[1][3].toString().replaceAll(" ", "-") + res1[1][4].toString());
                                                
                    }

                    return "Trabajador encontrado, verifica que los datos sean correctos";
                    
                }
                else
                    return "Parece existir un problema con el archivo fotografico del trabajador.";
  
            }
            else
                return "El trabajador no cuenta con un expediente fotografico";
            
        }
 
        return null;
        
    }
    
    public void dibujaCredencialTrabajador(){
        
        lienzo.setTrabajador(trabajador);
        lienzo.queCredencialDibujo("Trabajador");
        lienzo.setFileDibujo(fotoTrabajador, frontalCredencial, traseraCredencial);
        lienzo.repaint();
        
    }
    
    public void dibujaCredencialDirectiva(){
        
        lienzo.setDirectiva(directiva);
        lienzo.queCredencialDibujo("Directiva");
        lienzo.setFileDibujo(fotoTrabajador, frontalCredencial, traseraCredencial);
        lienzo.repaint();
        
    }
    
    public void getMotivosImpresion(JComboBox lista){
        
        lista.removeAllItems();
        
        lista.addItem("Selecciona");
        
        Object [][] res = conexion.ejecutarConsulta2("getListadoMotivosCredenciales()", new Object [] {}, 1);
        
        for (int i = 0; i < res.length; i++) {
            lista.addItem(res[i][0]);
        }
        
        lista.addItem("*Nuevo");
        
    }
    
    public CDirectiva getDatosDirectiva(){
        return directiva;
    }
    
    public CDibujaCredencial getLienzo(){
        return lienzo;
    }
    
    public CTrabajador getTrabajador(){
        return trabajador;
    }
    
    public File getFotoTrabajador(){
        return fotoTrabajador;
    }
    
    public File getFrontalCredencial(){
        return frontalCredencial;
    }
    
    public File getTraseraCredencial(){
        return traseraCredencial;
    }
    
}
