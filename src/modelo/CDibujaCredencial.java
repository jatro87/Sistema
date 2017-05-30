package modelo;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

/**
 *
 * @author Tadeo
 */

public class CDibujaCredencial extends JPanel{
    
    private File fotoTrabajador;
    private File frontalCredencial;
    private File traseraCredencial;
    private String cara = "";
    private BufferedImage img;
    private BufferedImage bi;
    private CTrabajador trab;
    private CDirectiva directiva;
    private CPDF pdf;
    
    public CDibujaCredencial(JPanel lienzo){
        setSize(lienzo.getSize());
        pdf = new CPDF();
    }
    
    public void setFileDibujo(File foto, File frontal, File trasera){
        this.fotoTrabajador = foto;
        this.frontalCredencial = frontal;
        this.traseraCredencial = trasera;

    }
    
    public void queCredencialDibujo(String cara){
        this.cara = cara;
    }
    
    public void setTrabajador(CTrabajador trab){
        this.trab = trab;
    }
    
    public void setDirectiva(CDirectiva dire){
        this.directiva = dire;
    }
    
    @Override
    public void paint(Graphics g){
        
        switch(cara){
            
            case "Trabajador": {
                
                try {
                    
                    img = ImageIO.read(frontalCredencial);

                    g.drawImage(img, 0, 0,getWidth(),getHeight(), this);
            
                    FontMetrics fm = g.getFontMetrics();
            
                    /*
                     Dibujo El Nombre
                    */

                    g.setFont(new Font("Britannic Bold",Font.BOLD,24));
                    g.setColor(Color.WHITE);

                    int x = (getWidth() - fm.stringWidth("Nombre:")) / 2;
                    int y = (fm.getAscent() + (getHeight() - (fm.getAscent() + fm.getDescent())) / 2);
                    g.drawString("Nombre:",x - 25, y - 10);

                    g.setColor(Color.BLACK);
                    g.setFont(new Font("Britannic Bold",Font.BOLD,22));
                    fm = g.getFontMetrics();

                    x = (getWidth() - fm.stringWidth(trab.getNombre())) / 2;
                    y = (fm.getAscent() + (getHeight() - (fm.getAscent() + fm.getDescent())) / 2);
                    g.drawString(trab.getNombre(),x, y + 15);

                    x = (getWidth() - fm.stringWidth(trab.getApellidoP() + " " + trab.getApellidoM())) / 2;
                    y = (fm.getAscent() + (getHeight() - (fm.getAscent() + fm.getDescent())) / 2);
                    g.drawString(trab.getApellidoP() + " " + trab.getApellidoM(),x, y + 40);

                    /*
                     Dibujo El Departamento
                    */

                    fm = g.getFontMetrics();
                    g.setFont(new Font("Britannic Bold",Font.BOLD,24));
                    g.setColor(Color.WHITE);

                    x = (getWidth() - fm.stringWidth("Departamento:")) / 2;
                    y = (fm.getAscent() + (getHeight() - (fm.getAscent() + fm.getDescent())) / 2);
                    g.drawString("Departamento:",x , y + 75);

                    g.setColor(Color.BLACK);
                    g.setFont(new Font("Britannic Bold",Font.BOLD,24));
                    fm = g.getFontMetrics();

                    x = (getWidth() - fm.stringWidth(trab.contrato.getDepartamento())) / 2;
                    y = (fm.getAscent() + (getHeight() - (fm.getAscent() + fm.getDescent())) / 2);
                    g.drawString(trab.contrato.getDepartamento(),x , y + 105);
                    
                    fm = g.getFontMetrics();
                    g.setFont(new Font("Britannic Bold",Font.BOLD,28));
                    g.setColor(Color.RED);

                    x = (getWidth() - fm.stringWidth(trab.getNoFicha())) / 2;
                    y = (fm.getAscent() + (getHeight() - (fm.getAscent() + fm.getDescent())) / 2);
                    g.drawString(trab.getNoFicha(),x - 60, y + 200);

                    img = ImageIO.read(fotoTrabajador);
                    g.drawImage(img, 102, 57, 110, 150, this);
                    
                    } catch (IOException ex) {
                        Logger.getLogger(CDibujaCredencial.class.getName()).log(Level.SEVERE, null, ex);
                    }

                    break;
            }
            case "Limpiar": {
                
                g.setColor(Color.WHITE);
                g.fillRect(0, 0, getWidth(), getHeight());

                break;
            }  
            case "Directiva": {
                                
                try {

                    img = ImageIO.read(frontalCredencial);

                    g.drawImage(img, 0, 0,getWidth(),getHeight(), this);
            
                    FontMetrics fm = g.getFontMetrics();
            
                    /*
                     Dibujo El Nombre
                    */

                    g.setFont(new Font("Britannic Bold",Font.BOLD,24));
                    g.setColor(Color.GREEN);

                    int x = (getWidth() - fm.stringWidth("Nombre:")) / 2;
                    int y = (fm.getAscent() + (getHeight() - (fm.getAscent() + fm.getDescent())) / 2);
                    g.drawString("Nombre:",x - 25, y - 10);

                    g.setColor(Color.BLACK);
                    g.setFont(new Font("Britannic Bold",Font.BOLD,22));
                    fm = g.getFontMetrics();

                    x = (getWidth() - fm.stringWidth(directiva.trabajador.getNombre())) / 2;
                    y = (fm.getAscent() + (getHeight() - (fm.getAscent() + fm.getDescent())) / 2);
                    g.drawString(directiva.trabajador.getNombre(),x, y + 15);

                    x = (getWidth() - fm.stringWidth(directiva.trabajador.getApellidoP() + " " + directiva.trabajador.getApellidoM())) / 2;
                    y = (fm.getAscent() + (getHeight() - (fm.getAscent() + fm.getDescent())) / 2);
                    g.drawString(directiva.trabajador.getApellidoP() + " " + directiva.trabajador.getApellidoM(),x, y + 40);

                    /*
                     Dibujo El Cargo
                    */

                    fm = g.getFontMetrics();
                    g.setFont(new Font("Britannic Bold",Font.BOLD,24));
                    g.setColor(Color.GREEN);

                    x = (getWidth() - fm.stringWidth("Cargo:")) / 2;
                    y = (fm.getAscent() + (getHeight() - (fm.getAscent() + fm.getDescent())) / 2);
                    g.drawString("Cargo:",x , y + 75);

                    g.setColor(Color.BLACK);
                    g.setFont(new Font("Britannic Bold",Font.BOLD,24));
                    fm = g.getFontMetrics();

                    x = (getWidth() - fm.stringWidth(directiva.getCargo())) / 2;
                    y = (fm.getAscent() + (getHeight() - (fm.getAscent() + fm.getDescent())) / 2);
                    g.drawString(directiva.getCargo(),x , y + 105);
                    
                    fm = g.getFontMetrics();
                    g.setFont(new Font("Britannic Bold",Font.BOLD,28));
                    g.setColor(Color.RED);

                    x = (getWidth() - fm.stringWidth(directiva.trabajador.getNoFicha())) / 2;
                    y = (fm.getAscent() + (getHeight() - (fm.getAscent() + fm.getDescent())) / 2);
                    g.drawString(directiva.trabajador.getNoFicha(),x - 60, y + 200);

                    img = ImageIO.read(fotoTrabajador);
                    g.drawImage(img, 102, 57, 110, 150, this);
                    
                    } catch (IOException ex) {
                        Logger.getLogger(CDibujaCredencial.class.getName()).log(Level.SEVERE, null, ex);
                    }

                    break;
            }
           
  
        }
        
        setOpaque(false);
        super.paintComponent(g);      
  
    }
    
    public void creaImagenCredencialTrabajador(){

        try {
            
            bi = new BufferedImage(278, 448, BufferedImage.TYPE_INT_ARGB);
            
            Graphics2D g = bi.createGraphics();
            
            img = ImageIO.read(frontalCredencial);
            g.drawImage(img, 0, 0,278,448, this);
            
            img = ImageIO.read(fotoTrabajador);
            g.drawImage(img, 90, 50, 98, 130, this);
            
            FontMetrics fm = g.getFontMetrics();
            
            g.setFont(new Font("Britannic Bold",Font.BOLD,24));
            g.setColor(Color.WHITE);
            int x = (278 - fm.stringWidth("Nombre:")) / 2;
            int y = (fm.getAscent() + (448 - (fm.getAscent() + fm.getDescent())) / 2);
            g.drawString("Nombre:",x - 23, y - 10);
            
            g.setColor(Color.BLACK);
            g.setFont(new Font("Britannic Bold",Font.BOLD,22));
            
            fm = g.getFontMetrics();
            
            x = (278 - fm.stringWidth(trab.getNombre())) / 2;
            y = (fm.getAscent() + (448 - (fm.getAscent() + fm.getDescent())) / 2);
            g.drawString(trab.getNombre(),x, y + 13);
            
            x = (278 - fm.stringWidth(trab.getApellidoP() + " " + trab.getApellidoM())) / 2;
            y = (fm.getAscent() + (448 - (fm.getAscent() + fm.getDescent())) / 2);
            g.drawString(trab.getApellidoP() + " " + trab.getApellidoM(),x, y + 33);
            
            fm = g.getFontMetrics();
            g.setFont(new Font("Britannic Bold",Font.BOLD,24));
            g.setColor(Color.WHITE);
            
            x = (278 - fm.stringWidth("Departamento:")) / 2;
            y = (fm.getAscent() + (448 - (fm.getAscent() + fm.getDescent())) / 2);
            g.drawString("Departamento:",x, y + 65);
            
            g.setColor(Color.BLACK);
            g.setFont(new Font("Britannic Bold",Font.BOLD,22));
            fm = g.getFontMetrics();
            
            x = (278 - fm.stringWidth(trab.contrato.getDepartamento())) / 2;
            y = (fm.getAscent() + (448 - (fm.getAscent() + fm.getDescent())) / 2);
            g.drawString(trab.contrato.getDepartamento(),x, y + 93);
            
            fm = g.getFontMetrics();
            g.setFont(new Font("Britannic Bold",Font.BOLD,30));
            g.setColor(Color.RED);
            
            x = (278 - fm.stringWidth(trab.getNoFicha())) / 2;
            y = (fm.getAscent() + (448 - (fm.getAscent() + fm.getDescent())) / 2);
            g.drawString(trab.getNoFicha(),x - 80, y + 195);//450
            
            try {
                
                ImageIO.write(bi, "PNG", new File(System.getProperty("java.io.tmpdir") + File.separator + trab.getNoFicha() + "-F" + ".png"));
                
            } catch (IOException ex) {
                Logger.getLogger(CDibujaCredencial.class.getName()).log(Level.SEVERE, null, ex);
            }

            img = ImageIO.read(traseraCredencial);
            g.drawImage(img, 0, 0,278,448, this);

            g.setColor(Color.WHITE);
            g.fillRect(5, 10, 266, 40);
            
            //barcode font
            g.setFont(new Font("3 of 9 Barcode",Font.PLAIN,45));
            g.setColor(Color.BLACK);
            
            fm = g.getFontMetrics();
            
            x = (278 - fm.stringWidth("*" + trab.getNoFicha() + "*")) / 2;
            y = (fm.getAscent() + (488 - (fm.getAscent() + fm.getDescent())) / 2);
            g.drawString("*" + trab.getNoFicha() + "*",x, y - 213);
                      
            try {
                
                ImageIO.write(bi, "PNG", new File(System.getProperty("java.io.tmpdir") + File.separator + trab.getNoFicha() + "-B" + ".png"));
                
            } catch (IOException ex) {
                Logger.getLogger(CDibujaCredencial.class.getName()).log(Level.SEVERE, null, ex);
            }    
            
            pdf.setTrabajador(trab);
            
        } catch (IOException ex) {
            Logger.getLogger(CDibujaCredencial.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }  
    
    public void creaImagenCredencialDirectiva(){

        try {
            
            bi = new BufferedImage(278, 448, BufferedImage.TYPE_INT_ARGB);
            
            Graphics2D g = bi.createGraphics();
            
            img = ImageIO.read(frontalCredencial);
            g.drawImage(img, 0, 0,278,448, this);
            
            img = ImageIO.read(fotoTrabajador);
            g.drawImage(img, 90, 50, 98, 130, this);
            
            FontMetrics fm = g.getFontMetrics();
            
            g.setFont(new Font("Britannic Bold",Font.BOLD,24));
            g.setColor(Color.GREEN);
            int x = (278 - fm.stringWidth("Nombre:")) / 2;
            int y = (fm.getAscent() + (448 - (fm.getAscent() + fm.getDescent())) / 2);
            g.drawString("Nombre:",x - 23, y - 10);
            
            g.setColor(Color.BLACK);
            g.setFont(new Font("Britannic Bold",Font.BOLD,22));
            
            fm = g.getFontMetrics();
            
            x = (278 - fm.stringWidth(directiva.trabajador.getNombre())) / 2;
            y = (fm.getAscent() + (448 - (fm.getAscent() + fm.getDescent())) / 2);
            g.drawString(directiva.trabajador.getNombre(),x, y + 13);
            
            x = (278 - fm.stringWidth(directiva.trabajador.getApellidoP() + " " + directiva.trabajador.getApellidoP())) / 2;
            y = (fm.getAscent() + (448 - (fm.getAscent() + fm.getDescent())) / 2);
            g.drawString(directiva.trabajador.getApellidoP() + " " + directiva.trabajador.getApellidoM(),x, y + 33);
            
            fm = g.getFontMetrics();
            g.setFont(new Font("Britannic Bold",Font.BOLD,24));
            g.setColor(Color.GREEN);
            
            x = (278 - fm.stringWidth("Cargo:")) / 2;
            y = (fm.getAscent() + (448 - (fm.getAscent() + fm.getDescent())) / 2);
            g.drawString("Cargo:",x, y + 65);
            
            g.setColor(Color.BLACK);
            g.setFont(new Font("Britannic Bold",Font.BOLD,22));
            fm = g.getFontMetrics();
            
            x = (278 - fm.stringWidth(directiva.getCargo())) / 2;
            y = (fm.getAscent() + (448 - (fm.getAscent() + fm.getDescent())) / 2);
            g.drawString(directiva.getCargo(),x, y + 93);
            
            fm = g.getFontMetrics();
            g.setFont(new Font("Britannic Bold",Font.BOLD,30));
            g.setColor(Color.RED);
            
            x = (278 - fm.stringWidth(directiva.trabajador.getNoFicha())) / 2;
            y = (fm.getAscent() + (448 - (fm.getAscent() + fm.getDescent())) / 2);
            g.drawString(directiva.trabajador.getNoFicha(),x - 80, y + 195);//450
            
            try {
                
                ImageIO.write(bi, "PNG", new File(System.getProperty("java.io.tmpdir") + File.separator + directiva.trabajador.getNoFicha() + "-F" + ".png"));
                
            } catch (IOException ex) {
                Logger.getLogger(CDibujaCredencial.class.getName()).log(Level.SEVERE, null, ex);
            }

            img = ImageIO.read(traseraCredencial);
            g.drawImage(img, 0, 0,278,448, this);

            g.setColor(Color.WHITE);
            g.fillRect(5, 10, 266, 40);
            
            //barcode font
            g.setFont(new Font("3 of 9 Barcode",Font.PLAIN,50));
            g.setColor(Color.BLACK);
            
            fm = g.getFontMetrics();
            
            x = (278 - fm.stringWidth("*" + directiva.trabajador.getNoFicha() + "*")) / 2;
            y = (fm.getAscent() + (488 - (fm.getAscent() + fm.getDescent())) / 2);
            g.drawString("*" + directiva.trabajador.getNoFicha() + "*",x, y - 213);
                      
            try {
                
                ImageIO.write(bi, "PNG", new File(System.getProperty("java.io.tmpdir") + File.separator + directiva.trabajador.getNoFicha() + "-B" + ".png"));
                
            } catch (IOException ex) {
                Logger.getLogger(CDibujaCredencial.class.getName()).log(Level.SEVERE, null, ex);
            }    
            
            pdf.setTrabajador(directiva.getTrabajador());
            
        } catch (IOException ex) {
            Logger.getLogger(CDibujaCredencial.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }    
    
    public File generaPDF(){
        if(pdf.preparaDocumentoPDF())
            return pdf.getFile();
        
        return null;
    }
    
}
