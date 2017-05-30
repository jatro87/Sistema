/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.print.Doc;
import javax.print.DocFlavor;
import javax.print.DocPrintJob;
import javax.print.PrintException;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.print.SimpleDoc;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;

/**
 *
 * @author Fondo Ahorro
 */
public class CPrint {
    
    private File pdf;
    private FileInputStream fis;
    private DocFlavor docFormat;
    private Doc document;
    private PrintRequestAttributeSet attributeSet;
    private PrintService defaultPrintService;
    private DocPrintJob printJob;
    
    public CPrint(){
        docFormat = DocFlavor.INPUT_STREAM.AUTOSENSE;
        attributeSet = new HashPrintRequestAttributeSet();
        defaultPrintService = PrintServiceLookup.lookupDefaultPrintService();
    }
    
    public void setDocument(File pdf){
        this.pdf = pdf;
    }
    
    public boolean print(){
        
        try {
                   
            fis = new FileInputStream(pdf);

            document = new SimpleDoc(fis, docFormat, null);

            printJob = defaultPrintService.createPrintJob();
             
            printJob.print(document, attributeSet);
            
            return true;
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(CPrint.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } catch (PrintException ex) {
            Logger.getLogger(CPrint.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
  
    }
    
    
    
    
}
