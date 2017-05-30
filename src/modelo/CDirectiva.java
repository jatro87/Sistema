/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import controlador.ClassConectaBD;
import javax.swing.JComboBox;

/**
 *
 * @author Tadeo
 */
public class CDirectiva {
    
    private String cargo;
    private ClassConectaBD conexion;
    CTrabajador trabajador;
    
    
    public CDirectiva(){
        cargo = "";
        trabajador = null;
        conexion = new ClassConectaBD();
    }
    
    public void getCargosDirectiva(JComboBox lista){
        
        lista.removeAllItems();
        
        lista.addItem("Selecciona");
        
        Object [][] res = conexion.ejecutarConsulta2("getListadoPuestosDirectiva()", new Object [] {}, 1);
        
        for (int i = 0; i < res.length; i++) {
            lista.addItem(res[i][0]);
        }
        
        lista.addItem("*Nuevo");
        
    }
    
    public String setNuevoCargoDirectiva(String nuevoTipo){

        Object [] res = conexion.ejecutarConsulta1("setNuevoCargoDirectiva(?,?)",
                new Object [] {nuevoTipo},
                new String []{"String"});
        
        return (String)res[0];
        
    }
    
    public void setTrabajador(CTrabajador trabajador){
        this.trabajador = trabajador;
    }
    
    public void setCargo(String cargo){
        this.cargo = cargo;
    }
    
    public CTrabajador getTrabajador(){
        return trabajador;
    }
    
    public String getCargo(){
        return cargo;
    }
    
}
