/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package modelo;

import java.util.Date;

/**
 * 
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class CTransaccion {

    private String procedimiento;
    private Date fecha;
    private String clase;
    private String metodo;
    
    public CTransaccion(){
        
    }
    
    public void setProcedimiento(String x){
        this.procedimiento = x;
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
        
         return "\n\t ++++++++++ Transaccion Del Sistema ++++++++++"
                + "\n Nombre De La Clase: " + clase
                + "\n Nombre Del Metodo: " + metodo
                + "\n Fecha & Hora: " + fecha.toString()
                + "\n Nombre del Procedimiento:: " + procedimiento + "\n";      
         
    }
    
}
