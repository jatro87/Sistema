package modelo;

import controlador.ClassConectaBD;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import org.apache.commons.net.ftp.FTPFileFilter;
import org.apache.commons.net.ftp.FTPReply;

public class CftpClient {

    private static String ip = null;
    private static String port = null;
    
    private final ClassConectaBD conexion;
    private final FTPClient ftp;
    private BufferedInputStream archOut;
    private OutputStream archInp;
    private FTPFileFilter filter;
    private CUser usuario;
    private CDireccionServidor url;
    private CError error;
    private CTransaccion transaccion;
    private final CHistorialSistema consola;
    
    public CftpClient(){
        
        ftp = new FTPClient();
        conexion = new ClassConectaBD();
        usuario = new CUser();
        url = new CDireccionServidor();
        consola = new CHistorialSistema();
        
        filter = new FTPFileFilter() {
 
                @Override
                public boolean accept(FTPFile ftpFile) {
                    
                    if(ftpFile.getName().contains(".jpeg") || ftpFile.getName().contains(".jpg") || ftpFile.getName().contains(".JPEG") || ftpFile.getName().contains(".JPG"))
                    
                        return true;
                    
                    else
                        return false;

                }
            };
        
    }
    
    private boolean conectFTP(){
        
        try {

            ftp.connect(url.getURL().trim(),21);
            ftp.login(usuario.getUsuario(), usuario.getContraseña());
            
            if(FTPReply.isPositiveCompletion(ftp.getReplyCode()))
                return true;

        } catch (IOException ex) {
            error = new CError();
            error.setClase("CftpClient");
            error.setExepcion(ex);
            error.setFechaHora();
            error.setMetodo("conectFTP()");
            consola.setError(error);
        }

        return false;
        
    }
    
    private void logoutFTP(){
        
        try {
            
            ftp.logout();
            ftp.disconnect();
            
        } catch (IOException ex) {
            error = new CError();
            error.setClase("CftpClient");
            error.setExepcion(ex);
            error.setFechaHora();
            error.setMetodo("logoutFTP()");
            consola.setError(error);
        }
        
    }
    
    public FTPFile [] getListaContratos(){
            
        FTPFile [] list = null;
        
        try {
         
            ftp.connect(url.getURL().trim(),21);
            ftp.login("Sistema", "sindicato.2109");

            ftp.setFileType(FTP.BINARY_FILE_TYPE,FTP.BINARY_FILE_TYPE);

            ftp.enterLocalActiveMode();

            list = ftp.listFiles("Scanner//",filter);

            logoutFTP();
            
        } catch (IOException ex) {
            error = new CError();
            error.setClase("CftpClient");
            error.setExepcion(ex);
            error.setFechaHora();
            error.setMetodo("getListaContratos()");
            consola.setError(error);
        }
        
        return list;
        
    }
    
    public boolean cambioFicha(String noFichaActual, String noFichaNuevo){
       
        try {
            
            conectFTP();
            
            ftp.setFileType(FTP.BINARY_FILE_TYPE,FTP.BINARY_FILE_TYPE);

            ftp.enterLocalActiveMode();
            
            FTPFile [] list = ftp.listDirectories("Trabajador" + "//");
            
            for (int i = 0; i < list.length; i++) {

                if(list[i].getName().equals(noFichaActual)){

                    return ftp.rename("Trabajador//" + noFichaActual,  "Trabajador//" + noFichaNuevo);
                    
                }

            }
            
            return false;
     
        } catch (IOException ex) {
            error = new CError();
            error.setClase("CftpClient");
            error.setExepcion(ex);
            error.setFechaHora();
            error.setMetodo("cambioFicha(String noFichaActual, String noFichaNuevo)");
            consola.setError(error);
            return false;
        }
        
    }
    
    
    public boolean borrarArchivo(String ruta){
        
        try {
            
            conectFTP();
            
            ftp.setFileType(FTP.BINARY_FILE_TYPE,FTP.BINARY_FILE_TYPE);
            
            ftp.enterLocalActiveMode();
            
            ftp.deleteFile(ruta);
            
            logoutFTP();
            
            return true;
            
        } catch (IOException ex) {
            error = new CError();
            error.setClase("CftpClient");
            error.setExepcion(ex);
            error.setFechaHora();
            error.setMetodo("borrarArchivo(String ruta)");
            consola.setError(error);
        }
        
        return false;
        
    }
    
    public boolean setFileExpediente(String tipoExpediente,String expediente,String clasificacion, String nombreArchivo, File origen, String extension){
        
        try {
            
            conectFTP();
            
            ftp.setFileType(FTP.BINARY_FILE_TYPE,FTP.BINARY_FILE_TYPE);

            archOut = new BufferedInputStream(new FileInputStream(origen));
            
            ftp.enterLocalActiveMode();
            
            FTPFile [] list = ftp.listDirectories();
            boolean crearDirectorio = true;
            
            for (FTPFile list1 : list) {   
                if (list1.getName().equals(tipoExpediente)) {
                    crearDirectorio = false;
                }     
            }
            
            if(crearDirectorio)
                ftp.makeDirectory(tipoExpediente);

            list = ftp.listDirectories(tipoExpediente + "//");
            crearDirectorio = true;
            
            for (FTPFile list1 : list) {  
                if (list1.getName().equals(expediente)) {
                    crearDirectorio = false;
                }      
            }
            
            if(crearDirectorio)
                ftp.makeDirectory(tipoExpediente + "//" + expediente);
            
            
            if(!"Ninguna".equals(clasificacion)){            
                
                list = ftp.listDirectories(tipoExpediente + "//" + expediente);
                crearDirectorio = true;

                for (FTPFile list1 : list) {  
                    if (list1.getName().equals(clasificacion)) {
                        crearDirectorio = false;
                    }      
                }

                if(crearDirectorio)
                    ftp.makeDirectory(tipoExpediente + "//" + expediente + "//" + clasificacion);
                
                if(ftp.storeFile(tipoExpediente + "//" + expediente + "//" + "//" + clasificacion + "//" + nombreArchivo + extension, archOut)){
                    archOut.close();
                    logoutFTP();
                    return true;
                }
            }
            else{
                if(ftp.storeFile(tipoExpediente + "//" + expediente + "//" + nombreArchivo + extension, archOut)){
                    archOut.close();
                    logoutFTP();
                    return true;
                }   
            }
            
            return false;
            
        } catch (IOException ex) {
            error = new CError();
            error.setClase("CftpClient");
            error.setExepcion(ex);
            error.setFechaHora();
            error.setMetodo("setFileExpediente(String tipoExpediente,String expediente,String clasificacion, String nombreArchivo, File origen, String extension)");
            consola.setError(error);
            return false;
        }
   
    }
    
    public boolean getArchivo(String direccionArchivo){
        
        try {

            conectFTP();

            ftp.setFileType(FTP.BINARY_FILE_TYPE,FTP.BINARY_FILE_TYPE);
            
            archInp = new BufferedOutputStream(new FileOutputStream(System.getProperty("java.io.tmpdir") + File.separator + direccionArchivo));

            ftp.enterLocalActiveMode();
            
            ftp.retrieveFile("Scanner//" + direccionArchivo, archInp);
            
            archInp.close();
            
            logoutFTP();
            
            return true;
 
        } catch (IOException ex) {
            error = new CError();
            error.setClase("CftpClient");
            error.setExepcion(ex);
            error.setFechaHora();
            error.setMetodo("getArchivo(String direccionArchivo)");
            consola.setError(error);
            return false;
        }
        
    }
    
        public boolean getUpdate(String direccionArchivo){
        
        try {

            conectFTP();

            ftp.setFileType(FTP.BINARY_FILE_TYPE,FTP.BINARY_FILE_TYPE);
            
            archInp = new BufferedOutputStream(new FileOutputStream(System.getProperty("user.dir") + File.separator + "Update.rar"));

            ftp.enterLocalActiveMode();
            
            ftp.retrieveFile("Software//Sistema//" + direccionArchivo, archInp);
            
            archInp.close();
            
            logoutFTP();
            
            return true;
 
        } catch (IOException ex) {
            error = new CError();
            error.setClase("CftpClient");
            error.setExepcion(ex);
            error.setFechaHora();
            error.setMetodo("getUpdate(String direccionArchivo)");
            consola.setError(error);
            return false;
        }
        
    }
    
    public boolean getFileExpediente(String tipoExpediente, String expediente,String clasificacion, String nombre, String extension){
        
        try {

            conectFTP();
            
            ftp.setFileType(FTP.BINARY_FILE_TYPE,FTP.BINARY_FILE_TYPE);
    
            archInp = new BufferedOutputStream(new FileOutputStream(System.getProperty("java.io.tmpdir") + File.separator + nombre.replaceAll(" ", "-") + extension));
            
            ftp.enterLocalActiveMode();
            
            if(!clasificacion.equals("Ninguna"))            
                ftp.retrieveFile(tipoExpediente + "//" + expediente + "//" + clasificacion + "//" + nombre + extension, archInp);
            else
                ftp.retrieveFile(tipoExpediente + "//" + expediente + "//" + nombre + extension, archInp);
            
            archInp.close();
            
            logoutFTP();
            
            return true;
 
        } catch (IOException ex) {
            error = new CError();
            error.setClase("CftpClient");
            error.setExepcion(ex);
            error.setFechaHora();
            error.setMetodo("getFileExpediente(String tipoExpediente, String expediente,String clasificacion, String nombre, String extension)");
            consola.setError(error);
            return false;
        }
        
    }

}
