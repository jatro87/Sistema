package modelo;

import java.io.File;
import java.io.IOException;

/**
 *
 * @author jatro
 */

public class CEjecutaArchivo {
    
    private File arch;
    
    public void setFile(File arch){
        this.arch = arch;
    }
    
    public boolean ejecuta(){
        
        try {

            Runtime r = Runtime.getRuntime();
            Process pro = r.exec("chrome " + arch.getCanonicalPath().replaceAll(" ", "-"));
            
        } catch (IOException ex) {
            return false;
        }
        
        return true;
        
    }
    
    public boolean ejecutaActualizacion(){
        
         try {

            Runtime r = Runtime.getRuntime();

            Process pro = r.exec("cmd /c start  C:\\Sutsha\\Actualizacion.bat" );
            
            System.exit(0);
            
        } catch (IOException ex) {
             System.out.println("Error - 2");
            return false;
        }
        
        return true;       
    }
        
}
