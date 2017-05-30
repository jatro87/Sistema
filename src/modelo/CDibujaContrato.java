package modelo;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import static java.awt.image.ImageObserver.HEIGHT;
import static java.awt.image.ImageObserver.WIDTH;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

/**
 *
 * @author hp
 */

public class CDibujaContrato extends JPanel{
    
//    private File archOrig;
    private BufferedImage img;
//    private double zoom;
    double x = 0,y = 0; // esquinaSuperiorIzquierda
    int x_raton, y_raton; //posicion del raton
    double ancho_imagen, alto_imagen;
    int ancho_original_imagen = 0, alto_original_imagen = 0;
    int ancho_panel, alto_panel;
    
    public CDibujaContrato(JPanel parent){
        setSize(parent.getSize());
    }
    
    @Override
    public void paint(Graphics g){

        Graphics2D g2d=(Graphics2D)g;
        
        if(img != null){

            g2d.drawImage(img, (int)(x + 0.5), (int)(y + 0.5), (int)(ancho_imagen + 0.5), (int)(alto_imagen + 0.5), this);
 
        }
        else{
            
            g2d.setColor(Color.white);
            g2d.fillRect(0, 0, WIDTH, HEIGHT);
            
        }
        
        setOpaque(false);
        super.paintComponent(g);
        
    }
    
    public void setFoto(File archOrig){
        if(archOrig != null)
            try {
                
                img = ImageIO.read(archOrig);
                
                ancho_original_imagen = img.getWidth();
                alto_original_imagen = img.getHeight();
                ancho_imagen = getWidth();
                alto_imagen = getHeight();
                              
        } catch (IOException ex) {
            Logger.getLogger(CDibujaFoto.class.getName()).log(Level.SEVERE, null, ex);
        }
        else
            img = null;
    }   

    public void acercar(){
        
        if (ancho_original_imagen == -1){
		return;
	}

		//
		// Se acerca un 1% y se llama a repaint()
		//
	x = x_raton - (x_raton - x) * 1.01;
	y = y_raton - (y_raton - y) * 1.01;
	alto_imagen = alto_imagen * 1.01;
	ancho_imagen = ancho_imagen * 1.01;
	
        repaint();
              
    }
    
    public void Alejar(){
            
        if (ancho_original_imagen == -1){
                ancho_imagen = getWidth();
                alto_imagen = getHeight();
                repaint();
                return;
            }

        //
        // Se limita la imagen para que no se pueda reducir mas que
        // el tamano del applet. En caso de que no vaya a quedar
        //	mas pequena, se cambia.
        // Se reduce la imagen un 1%
        //
        if (((alto_imagen * 0.99) >= getSize().height) &&
                ((ancho_imagen * 0.99) >=  getSize().width)){
                
            alto_imagen = alto_imagen * 0.99;
            ancho_imagen = ancho_imagen * 0.99;

            x = x_raton - (x_raton - x) * 0.99;
            y = y_raton - (y_raton - y) * 0.99;
            
            if (x>0.0) 
                x = 0.0;
            if (y>0.0) 
                y = 0.0;

            repaint();
        }
}
    public void Desplazar(){
            
        double desp_x = 0;
        double desp_y = 0;
        double modulo = 0;

        desp_x = (x_raton - getSize().width/2);
        desp_y = (y_raton - getSize().height/2);

        //
        // una cuenta aproximada del modulo, por aquello de no
        // hacer cuentas muy complejas
        //
        modulo = (Math.abs(desp_x) + Math.abs(desp_y));

        desp_x = desp_x / modulo * 4.0;
        desp_y = desp_y / modulo * 4.0;

        if ((x + desp_x <= 0) && 
                (x + desp_x + (int)(ancho_imagen + 0.5)) >= getSize().width)
                        x = x + desp_x;

        if ((y + desp_y <= 0) && 
                (y + desp_y + (int)(alto_imagen + 0.5)) >= getSize().height)
                        y = y + desp_y;

            repaint();
            
    }
    
    public void setCoordenadasRaton(int x, int y){
     
        this.x_raton = x;
        this.y_raton = y;

    }
    
    public void nuevo(){
       
        img = null;
        x = 0;
        y = 0; // esquinaSuperiorIzquierda
        x_raton = 0;
        y_raton = 0; //posicion del raton
        ancho_imagen = 0;
        alto_imagen = 0;
        ancho_original_imagen = 0;
        alto_original_imagen = 0;
        ancho_panel = 0;
        alto_panel = 0;
        
    }
    
}
