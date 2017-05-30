package modelo;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CPDF {
    
    private Document credencialesPDF;
    private ArrayList <CTrabajador> listaImpresion;
    private Image img;
    private File arch;
    
    public CPDF(){
         arch = new File(System.getProperty("java.io.tmpdir") + File.separator + "cred.pdf");  
         listaImpresion = new ArrayList<CTrabajador>();
    }
    
    public void setTrabajador(CTrabajador t){        
        
        listaImpresion.add(t);
        
    }
    
    public boolean preparaDocumentoPDF(){        

        try {    
            
            credencialesPDF = new Document();
            
            PdfWriter.getInstance(credencialesPDF, new FileOutputStream(arch));           
            
            credencialesPDF.open(); 
            
            credencialesPDF.setPageSize(PageSize.A4);
            credencialesPDF.setMargins(20f, 20f, 20f, 20f);
            
            int y = 80;
            
            for (int i = 0; i < listaImpresion.size(); i++) {
                
                if( (i % 4) == 0){

                    credencialesPDF.newPage();
                    img = Image.getInstance(System.getProperty("java.io.tmpdir") + File.separator + listaImpresion.get(i).getNoFicha() + "-F.png");
                    img.setRotationDegrees(90f);
                    img.setAbsolutePosition(35f, y);
                    img.scalePercent(55f);
                    credencialesPDF.add(img);
                    
                    img = Image.getInstance(System.getProperty("java.io.tmpdir") + File.separator + listaImpresion.get(i).getNoFicha() + "-B.png");
                    img.scalePercent(55f);
                    img.setRotationDegrees(270f);
                    img.setAbsolutePosition(280f, y);                    
                    credencialesPDF.add(img);
                    
                    y = 80;
                    
                }else{
                    
                    y = y + 170;
                                        
                    img = Image.getInstance(System.getProperty("java.io.tmpdir") + File.separator + listaImpresion.get(i).getNoFicha() + "-F.png");
                    img.setRotationDegrees(90f);
                    img.setAbsolutePosition(35f, y);
                    img.scalePercent(55f);
                    credencialesPDF.add(img);
                    
                    img = Image.getInstance(System.getProperty("java.io.tmpdir") + File.separator + listaImpresion.get(i).getNoFicha() + "-B.png");
                    img.scalePercent(55f);
                    img.setRotationDegrees(270f);
                    img.setAbsolutePosition(280f, y);                    
                    credencialesPDF.add(img);
   
                }
 
            }

            credencialesPDF.close();
            
            return true;
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(CPDF.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } catch (DocumentException ex) {
            Logger.getLogger(CPDF.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } catch (IOException ex) {
            Logger.getLogger(CPDF.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    public File getFile(){
        return arch;
    }
    
    
}
