package modelo;

import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;

/**
 *
 * @author GRISELDA
 */

public class CReloj extends Thread{
    
    private boolean detener;
    private JLabel mostrarHora;
    private Calendar hora;
    
    public CReloj(){
        detener = false;
        hora = Calendar.getInstance();
    }
    
    public void setJLabel(JLabel mostrarHora){
        this.mostrarHora = mostrarHora;
    }
    
    @Override
    public void run(){
        
        String formatoHora;
        
        while(!detener){
        
            try {
                
                hora = Calendar.getInstance();
                
                if(hora.get(Calendar.HOUR_OF_DAY) < 10)
                    formatoHora = "0" + hora.get(Calendar.HOUR_OF_DAY) + ":";
                else
                    formatoHora = hora.get(Calendar.HOUR_OF_DAY) + ":";
                    
                if(hora.get(Calendar.MINUTE) < 10)
                    formatoHora += "0" + hora.get(Calendar.MINUTE) + ":";
                else
                    formatoHora += hora.get(Calendar.MINUTE) + ":";
                
                if(hora.get(Calendar.SECOND) < 10)
                    formatoHora += "0" + hora.get(Calendar.SECOND);
                else
                    formatoHora += hora.get(Calendar.SECOND);

                mostrarHora.setText(formatoHora);
                
                sleep(100);
                
            } catch (InterruptedException ex) {
                Logger.getLogger(CReloj.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }

    }
    
    
}
