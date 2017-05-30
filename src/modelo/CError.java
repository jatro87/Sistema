package modelo;

import java.util.Date;

/**
 * 
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class CError {

    private String exepcion;
    private Date fecha;
    private String clase;
    private String metodo;
    
    public CError(){
        
    }
    
    public void setExepcion(Exception x){
        this.exepcion = x.getLocalizedMessage();
    }
    
    public void setClase(String clase){
        this.clase = clase;
    }
    
    public void setMetodo(String metodo){
        this.metodo = metodo;
    }
    
    public void setFechaHora(){
        fecha = new Date();
    }
    
    @Override
    public String toString(){
        
        return "\n\t ++++++++++ Error Del Sistema ++++++++++"
                + "\n Nombre De La Clase: " + clase
                + "\n Nombre Del Metodo: " + metodo
                + "\n Fecha & Hora: " + fecha.toString()
                + "\n Error: " + exepcion + "\n";       
        
    }
    
}
