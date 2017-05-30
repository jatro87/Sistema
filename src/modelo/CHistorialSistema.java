package modelo;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Calendar;
import javax.swing.JTextArea;

/**
 * 
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class CHistorialSistema {

    private static ArrayList <CError> errores= null;
    private static ArrayList <CTransaccion> transacciones = null;
    private static JTextArea panelErrores;
    private Calendar calenario;
    
    public CHistorialSistema(){
        if(errores == null && transacciones == null){
            errores = new ArrayList<>();
            transacciones = new ArrayList<>();
        }
    }
    
    public void seTransaccion(CTransaccion tran){
        transacciones.add(tran);
    }
    
    public void setError(CError error){
        errores.add(error);
    }
    
    public void setPanelErrores(JTextArea panel){
        CHistorialSistema.panelErrores = panel;
    }
    
    public void getErrores(){
        
        panelErrores.setText("");
        panelErrores.setForeground(Color.RED);
       
        for (int i = 0; i < errores.size(); i++) {
            
            panelErrores.append(errores.get(i).toString());

        }
        
    }
    
    public void getTransacciones(){
        
        panelErrores.setText("");
        panelErrores.setForeground(Color.GREEN);
       
        for (int i = 0; i < transacciones.size(); i++) {
            
            panelErrores.append(transacciones.get(i).toString());

        }
        
    }
    
}
