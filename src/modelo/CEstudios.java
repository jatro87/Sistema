package modelo;

import controlador.ClassConectaBD;
import javax.swing.JComboBox;

/**
 *
 * @author Tadeo
 */

public class CEstudios {
    
    private ClassConectaBD conexion;
    private String especialidad,estudios;
    
    public CEstudios (){
        conexion = new ClassConectaBD();
    }
    
    public void getGradoEstudios(JComboBox lista){
        
        lista.removeAllItems();
        
        lista.addItem("Selecciona");
        
        Object [][] res = conexion.ejecutarConsulta2("getListadoEstudios()", new Object [] {}, 1);
        
        for (int i = 0; i < res.length; i++) {
            lista.addItem(res[i][0]);
        }
        
        lista.addItem("*Nuevo");
        
    }
    
    public String setGradoEstudios(String nombre){
        Object [] res = conexion.ejecutarConsulta1("setNuevosEstudios(?,?)",
                new Object []{nombre}, new String []{"String"});
        
        return (String) res[0];
    }

    public void getEspecialidad(JComboBox lista){
        
        lista.removeAllItems();
        
        lista.addItem("Selecciona");
        
        Object [][] res = conexion.ejecutarConsulta2("getListadoEspecialidades()", new Object [] {}, 1);
        
        for (int i = 0; i < res.length; i++) {
            lista.addItem(res[i][0]);
        }
        
        lista.addItem("*Nuevo");
        
    }
    
    public String setNuevaEspecialidad(String nombre){
        Object [] res = conexion.ejecutarConsulta1("setNuevaEspecialidad(?,?)",
                new Object []{nombre}, new String []{"String"});
        
        return (String) res[0];
    }    
    
    public void setEstudios(String estudios){
        this.estudios = estudios;
    }
    
    public void setEspecialidad(String especialidad){
        this.especialidad = especialidad;
    }
    
    public String getEspecialidad(){
        return especialidad;
    }
    
    public String getEstudios(){
        return estudios;
    }
}
