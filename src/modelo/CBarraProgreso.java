package modelo;

import java.awt.Color;
import vista.jd_progreso;

/**
 *
 * @author hp
 */

public class CBarraProgreso extends Thread{

    private static int progreso;
    private static String texto;
    private jd_progreso prog;
    
    public CBarraProgreso(){
        
    }
    
    public void setProgreso(int progreso){
        this.progreso = progreso;
    }
    
    public void setTexto(String texto){
        this.texto = texto;
    }
    
    public void setJDProgreso(jd_progreso prog){
        this.prog = prog;
    }
    
    @Override
    public void run(){

        progreso = 0;
        texto = "Inciando ...";
        
        while(progreso < 100){
                
                if(texto.equals("Error"))
                    prog.jProgressBar1.setBackground(Color.RED);
                else
                    prog.jProgressBar1.setBackground(Color.WHITE);
                
                prog.jLabel2.setText(texto);
                prog.jProgressBar1.setValue(progreso);

        }

    }
    
}
