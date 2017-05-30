package modelo;

import controlador.ClassConectaBD;
import java.io.File;
import java.util.Date;
import java.util.UUID;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author jatro
 */

public class CExpediente {
    
    private ClassConectaBD conexion;
    private CftpClient ftp;
    private CEjecutaArchivo execFil;
    
    public CExpediente(){
        conexion = new ClassConectaBD();
        ftp = new CftpClient();
        execFil = new CEjecutaArchivo();
    }
    
    public String getExpediente(String expediente,JTable tabla){
        
        Object [][] res = conexion.ejecutarConsulta2("getExpediente(?)", new Object [] {expediente}, 7);
        
        DefaultTableModel model = (DefaultTableModel) tabla.getModel();
        
        Object [] rows = new Object [6];

        for (int i = model.getRowCount(); i > 0; i--) {
            model.removeRow(i-1);
        }
        
        for (int i = 0; i < res.length; i++) {
            
            model.addRow(rows);  
            model.setValueAt(res[i][0], i, 0);
            model.setValueAt(res[i][1], i, 1);
            model.setValueAt(res[i][3], i, 2);
            model.setValueAt(res[i][4], i, 3);
            model.setValueAt(res[i][5], i, 4);
            model.setValueAt(res[i][6], i, 5);
            
        }
        try{
            
            return (String) res[0][2];
            
        }catch(ArrayIndexOutOfBoundsException e){
            
            return null;
            
        }
        
    }
    
    public String getResultadosBusqueda(String busqueda,String tipoExpediente, Date fecha1, Date fecha2, JTable tabla, boolean tipoExpediente_1, boolean fecha_1){
        
        Object [][] res = conexion.ejecutarConsulta2("busquedaExpedientes(?,?,?,?,?,?)", 
                new Object [] {busqueda, tipoExpediente, fecha1, fecha2,tipoExpediente_1, fecha_1}, 8);
        
        DefaultTableModel model = (DefaultTableModel) tabla.getModel();
        
        Object [] rows = new Object [8];

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
            model.setValueAt(res[i][7], i, 7);
            
        }
        try{
            
            return "";
            
        }catch(ArrayIndexOutOfBoundsException e){
            
            return "Ninguna coincidencia encontrada";
            
        }
        
    }
    
    public String setNuevoTipoExpediente(String nuevoTipo){

        Object [] res = conexion.ejecutarConsulta1("setTipoExpediente(?,?)",
                new Object [] {nuevoTipo},
                new String []{"String"});
        
        return (String)res[0];
        
    }
    
    public String setNuevaUbicacionExpediente (String nuevaUbicacion){
        
        Object [] res = conexion.ejecutarConsulta1("setUbicacionExpediente(?,?)",
                new Object [] {nuevaUbicacion},
                new String []{"String"});
        
        return (String)res[0];
    }
    
    public String setNuevaClasificacionExpediente (String nuevaClasificacion){
        
        Object [] res = conexion.ejecutarConsulta1("setClasificacionExpediente(?,?)",
                new Object [] {nuevaClasificacion},
                new String []{"String"});
        
        return (String)res[0];
    }
    
    public void gettiposExpedientes(JComboBox lista){
        
        lista.removeAllItems();
        
        lista.addItem("Selecciona");
        
        Object [][] res = conexion.ejecutarConsulta2("getListaTiposExpedientes()", new Object [] {}, 1);
        
        for (int i = 0; i < res.length; i++) {
            lista.addItem(res[i][0]);
        }
        
        lista.addItem("*Nuevo");

    }
    
        public void gettiposExpedientes2(JComboBox lista){
        
        lista.removeAllItems();
        
        lista.addItem("Selecciona");
        
        Object [][] res = conexion.ejecutarConsulta2("getListaTiposExpedientes()", new Object [] {}, 1);
        
        for (int i = 0; i < res.length; i++) {
            lista.addItem(res[i][0]);
        }

    }
    
    public void getClasificacionExpediente(JComboBox lista){
        
        lista.removeAllItems();
        
        lista.addItem("Selecciona");
        
        Object [][] res = conexion.ejecutarConsulta2("getClasificacionExpedientes()", new Object [] {}, 1);
        
        for (int i = 0; i < res.length; i++) {
            lista.addItem(res[i][0]);
        }
        
        lista.addItem("*Nuevo");   
        
    }
    
    public void getUbicacionesExpedientes(JComboBox lista){
        
        lista.removeAllItems();
        
        lista.addItem("Selecciona");
        
        Object [][] res = conexion.ejecutarConsulta2("getListaUbicacionesExpedientes()", new Object [] {}, 1);
        
        for (int i = 0; i < res.length; i++) {
            lista.addItem(res[i][0]);
        }
        
        lista.addItem("*Nuevo");
    }
    
    public String setExpediente(String expediente, String tipoExpediente,String clasificacion,String nombreArchivo,String descripcion, String ubicacion, File arch, String extension){

        if(ftp.setFileExpediente(tipoExpediente, expediente, clasificacion, nombreArchivo, arch, extension)){
            Object res [] = conexion.ejecutarConsulta1("setExpediente(?,?,?,?,?,?,?,?,?)",
                    new Object []{expediente,tipoExpediente,nombreArchivo,descripcion,clasificacion,ubicacion,UUID.randomUUID().toString(),extension},
                    new String []{"String"});
            
            return (String)res [0];
        }
        else
            return "Parece existir un problema con el servidor ftp, contacte al Administrador";
 
    }
    
    public boolean getArchivo(String tipoExpediente,String expediente,String clasificacion,String nombre, String extension){
        
        if(ftp.getFileExpediente(tipoExpediente, expediente, clasificacion, nombre, extension)){

            execFil.setFile(new File(System.getProperty("java.io.tmpdir") + File.separator + nombre + extension));
            
            return execFil.ejecuta();
            
        }
        
        return false;
        
    }
    
}
