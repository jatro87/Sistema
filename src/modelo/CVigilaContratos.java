package modelo;

import org.apache.commons.net.ftp.FTPFile;

/**
 *
 * @author hp
 */

public class CVigilaContratos{
    
    private FTPFile [] listaArchivos;
    private boolean terminar;
    private CftpClient ftp;
    private int posicion;
    
    public CVigilaContratos(){
       terminar = true;
       posicion = 0;
       ftp = new CftpClient();
    }
    
    public String siguiente(){
       
        String aux = null;
        
        if(posicion < listaArchivos.length){           
            aux = listaArchivos [posicion].getName();
            posicion ++;        
        }
        else{
            posicion = 0;
            aux = listaArchivos [posicion].getName();            
            posicion ++;            
        }
        
        return aux;
        
    }
    
    public String getArchivoActual(){
        return listaArchivos [posicion-1].getName();
    }
     
    public boolean existenArchivos(){
        
        return listaArchivos.length > 0;
        
    }
    
    public boolean deleteFile(){
        
        return ftp.borrarArchivo("Scanner//" + getArchivoActual());
        
    }
    
//    public synchronized void terminaPrograma(){
//        terminar = false;
//    }
    
//    @Override
    public void actualizarListado(){

            listaArchivos = ftp.getListaContratos();

    }
    
}
