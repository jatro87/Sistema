package modelo;

import controlador.ClassConectaBD;
import javax.swing.JComboBox;

/**
 *
 * @author Tadeo
 */

public class CSalud {
    
    private ClassConectaBD conexion;
    
    private String convenioMedico, tipoSangre;
    
    public CSalud (){
        conexion = new ClassConectaBD();
    }
    
    public void getGruposSanguineos(JComboBox lista){
        
        lista.removeAllItems();
        
        lista.addItem("Selecciona");
        
        Object [][] res = conexion.ejecutarConsulta2("getListadoGrupoSanguineo()", new Object [] {}, 1);
        
        for (int i = 0; i < res.length; i++) {
            lista.addItem(res[i][0]);
        }
        
        lista.addItem("*Nuevo");
        
    }
    
    public String setGrupoSanguineo(String nombre){
        Object [] res = conexion.ejecutarConsulta1("setNuevoGrupoSanguineo(?,?)",
                new Object []{nombre}, new String []{"String"});
        
        return (String) res[0];
    }
    
    public void setConvenioMedico(String cnvenio){
        this.convenioMedico = cnvenio;
    }
    
    public void setTipoSangre(String tipoSangre){
        this.tipoSangre= tipoSangre;
    }
 
    public String getConvenioMedico(){
        return convenioMedico;
    }
    
    public String getTipoSangre(){
        return tipoSangre;
    }
    
}
