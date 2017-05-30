package modelo;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

/**
 *
 * @author Angel
 */
public class CDibujaFoto extends JPanel{
    
    private File archOrig;
    private BufferedImage img;
    
    
    public CDibujaFoto(JPanel parent){
        setSize(parent.getSize());
    }
    
    @Override
    public void paint(Graphics g){
        
        if(img != null)
            g.drawImage(img, 0, 0,getWidth(),getHeight(), this);
        else{
            g.setColor(Color.white);
            g.fillRect(0, 0, WIDTH, HEIGHT);
        }
        
        setOpaque(false);
        super.paintComponent(g);
        
    }
    
    public void setFoto(File archOrig){
        if(archOrig != null)
            try {
                
                img = ImageIO.read(archOrig);
                
        } catch (IOException ex) {
            Logger.getLogger(CDibujaFoto.class.getName()).log(Level.SEVERE, null, ex);
        }
        else
            img = null;
    }
    
    
}
