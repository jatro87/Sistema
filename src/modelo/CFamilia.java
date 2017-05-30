package modelo;

import controlador.ClassConectaBD;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Angel
 */

public class CFamilia {
    
    private ClassConectaBD conexion;
    private String estadoCivil, esposa;
    private CError error;
    private CHistorialSistema consola;
    
    public CFamilia (){
        conexion = new ClassConectaBD();
        consola = new CHistorialSistema();
    }
    
    public void getEstadoCivil(JComboBox lista){
        
        lista.removeAllItems();
        
        lista.addItem("Selecciona");
        
        Object [][] res = conexion.ejecutarConsulta2("getListadoEstadoCivil()", new Object [] {}, 1);
        
        for (int i = 0; i < res.length; i++) {
            lista.addItem(res[i][0]);
        }
        
        lista.addItem("*Nuevo");
        
    }
    
    public String setNuevoEstadoCivil(String nombre){
        Object [] res = conexion.ejecutarConsulta1("setNuevoEstadoCivil(?,?)",
                new Object []{nombre}, new String []{"String"});
        
        return (String) res[0];
    }
    
    public void getConcuvina(String noFicha){
        
        Object [] res = conexion.ejecutarConsulta1("getConcubinaTrabajador(?,?)",
                new Object []{noFicha}, new String []{"String"});
        
        setEsposa(res [0].toString());
        
        
    }
    
    public void agregarHijos(Object [] datos, JTable tabla, int numHijo){
        
        DefaultTableModel model = (DefaultTableModel) tabla.getModel();
        
        Object [] rows = new Object [2];

        model.addRow(rows);  
        model.setValueAt(datos [0], numHijo, 0);
        model.setValueAt(datos [1], numHijo, 1);

    }
    
    public boolean getListadoHijos(JTable tabla, String noFicha){
        
        boolean flag = false;
        
        Object [][] res = conexion.ejecutarConsulta2("getListadoHijos(?)",
                new Object [] {noFicha}, 2);   
        
        DefaultTableModel model = (DefaultTableModel) tabla.getModel();
        
        Object [] rows = new Object [2];

        for (int i = model.getRowCount(); i > 0; i--) {
            model.removeRow(i-1);
        }
        
        for (int i = 0; i < res.length; i++) {
            
            model.addRow(rows);  
            model.setValueAt(res [i][0] , i, 0);
            model.setValueAt(res [i][1] , i, 1);
        
            flag = true;
            
        }

        return flag;
        
    }
    
    public void setEstadoCivil(String estadoCivil){
        this.estadoCivil = estadoCivil;
    }
    
    public void setEsposa (String nombre){
        esposa = nombre;
    }
    
    public void setHijos(JTable tabla, String noFicha){
        
        DefaultTableModel model = (DefaultTableModel) tabla.getModel();
        
        for (int i = 0; i < model.getRowCount(); i++) {
            
            conexion.ejecutarConsulta1("setHijo(?,?,?)",
                    new Object[]{noFicha,model.getValueAt(i, 0),model.getValueAt(i, 1)},
                    new String []{});
            
        }

    }
    
    public String getEstadoCivil(){
        return estadoCivil;
    }
    
    public String getEsposa(){
        return esposa;               
    }
}
