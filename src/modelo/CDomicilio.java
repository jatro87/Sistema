package modelo;

import controlador.ClassConectaBD;
import javax.swing.JComboBox;

/**
 *
 * @author Tadeo
 */
public class CDomicilio {
    
    private String nombreColonia, numero, calle, codigoPostal, ciudad;
    private ClassConectaBD conexion;
    
    public CDomicilio(){
        nombreColonia = null;
        conexion = new ClassConectaBD();
    }
    
    public String setColoniaBD(String nombre){
        Object [] res = conexion.ejecutarConsulta1("setNuevaColonia(?,?)",
                new Object []{nombre}, new String []{"String"});
        
        return (String) res[0];
    }
    
    public String setCiudadBD(String nombre){
        Object [] res = conexion.ejecutarConsulta1("setNuevaCiudad(?,?)",
                new Object []{nombre}, new String []{"String"});
        
        return (String) res[0];
    }
    
    public void getColonias(JComboBox lista){
        
        lista.removeAllItems();
        
        lista.addItem("Selecciona");
        
        Object [][] res = conexion.ejecutarConsulta2("getListadoColonias()", new Object [] {}, 1);
        
        for (int i = 0; i < res.length; i++) {
            lista.addItem(res[i][0]);
        }
        
        lista.addItem("*Nuevo");
        
    }
    
    public void getCiudades(JComboBox lista){
        
        lista.removeAllItems();
        
        lista.addItem("Selecciona");
        
        Object [][] res = conexion.ejecutarConsulta2("getListadoCiudades()", new Object [] {}, 1);
        
        for (int i = 0; i < res.length; i++) {
            lista.addItem(res[i][0]);
        }
        
        lista.addItem("*Nuevo");
        
    }

//    public void setColonia(String nombreColonia){
//        this.nombreColonia = nombreColonia;
//    }
//    
//    public void setIdColonia(int idColonia){
//        this.IdColonia = idColonia;
//    }
    public void setColonia(String colonia){
        this.nombreColonia = colonia;
    }
    
    public void setCiudad(String ciudad){
        this.ciudad = ciudad;
    }
    
    public void setCodigoPostal(String codigoPostal){
        this.codigoPostal = codigoPostal;
    }
    
    public String getColonia(){
        return nombreColonia;
    }
    
    public void setCalle(String calle){
        this.calle = calle;
    }
    
    public String getCalle(){
        return calle;
    }
    
    public void setNumero(String numero){
        this.numero = numero;
    }
    
    public String getNumero(){
        return numero;
    }
    
    public String getCiudad(){
        return ciudad;
    }
    
    public String getCodigoPostal(){
        return codigoPostal;
    }
     
}
