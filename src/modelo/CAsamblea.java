package modelo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author GRISELDA
 */

public class CAsamblea {
    
    private final File origenArchivoNomina;    
    private final File listadoAsistencia;
    private final File listadoFaltas;
    private final File informacionAsamblea;
    
    private BufferedWriter  wr;
    private String noAsamblea, encargado;
    private Date fechaAsamblea;
    
    private static ArrayList<String> nombreTrabajador = null;
    private static ArrayList<String> fichaTrabajador = null;
    private static ArrayList<String> salarioTrabajador = null;
    
    private static ArrayList<String> asistenciaAsamblea = null;
    
    public CAsamblea(){
        
      origenArchivoNomina = new File("Asamblea" + File.separator + "Nomina.csv");
      listadoAsistencia = new File("Asamblea" + File.separator + "Listado Asistencias.csv");
      listadoFaltas = new File("Asamblea" + File.separator + "Listado Faltas.csv");
      informacionAsamblea = new File("Asamblea" + File.separator + "Datos Asamblea.txt");
              
      if(nombreTrabajador == null){
        nombreTrabajador = new ArrayList<>();
        fichaTrabajador = new ArrayList<>();
        salarioTrabajador = new ArrayList<>();
        asistenciaAsamblea = new ArrayList<>();
      }
      
    }
    
    public void setNoAsamblea(String noAsamblea){
        this.noAsamblea = noAsamblea;
    }
    
    public void setEncargado(String encargado){
        this.encargado = encargado;
    }
    
    public String buscarTrabajador(String ficha, String tipoAsistencia, JTable tabla){
        
        DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
        
        for (int i = 0; i < this.fichaTrabajador.size(); i++) {
            
            if(this.fichaTrabajador.get(i).equals(ficha)){
                
                if(asistenciaAsamblea.contains(ficha))
                    return "Asistencia Ya Registrada";
                
                
                modelo.addRow(new Object []{this.fichaTrabajador.get(i), this.nombreTrabajador.get(i), new Date()});
                
                asistenciaAsamblea.add(ficha);
                
                generarArchivoRespaldo(this.fichaTrabajador.get(i), this.nombreTrabajador.get(i), tipoAsistencia, null);
                
                return nombreTrabajador.get(i);
                
            }
            
        }
        
        return null;

    }

    public void cargaNominaMemoria(){
        
        nombreTrabajador.clear();
        fichaTrabajador.clear();
        salarioTrabajador.clear();
        
        BufferedReader br;
        
        try {
            
            br =new BufferedReader(new FileReader(origenArchivoNomina));
            
            String linea = br.readLine();
            
            while(linea != null){
                
                String [] contenido = linea.split(",");
                
                fichaTrabajador.add(contenido[0].trim());
                nombreTrabajador.add(contenido[1].trim());
                salarioTrabajador.add(contenido[2].trim());
                
                linea = br.readLine();
                
            }
            
            br.close();
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(CAsamblea.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(CAsamblea.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    public void mostrarTabla(JTable tabla){

        DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
        Object filas [] = new Object[3];
        
        for (int i = 0; i < fichaTrabajador.size(); i++) {
            
            modelo.addRow(filas);
            modelo.setValueAt(fichaTrabajador.get(i), i, 0);
            modelo.setValueAt(nombreTrabajador.get(i), i, 1);
            modelo.setValueAt(salarioTrabajador.get(i), i, 2);
            
        }

    }    
    
    public void busqueda(JTable tabla, String busqueda){
        
        ArrayList<Integer> posicionesEncontradas = new ArrayList <>();
        
        DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
        
        modelo.setRowCount(0);
                
        for (int i = 0; i < fichaTrabajador.size(); i++) {
            
            if(fichaTrabajador.get(i).contains(busqueda) || nombreTrabajador.get(i).contains(busqueda)){
                
                posicionesEncontradas.add(i);
                
            }
  
        }
        
        Object filas [] = new Object[3];
        
        for (int i = 0; i < posicionesEncontradas.size(); i++) {
            
            modelo.addRow(filas);
            modelo.setValueAt(fichaTrabajador.get(posicionesEncontradas.get(i)), i, 0);
            modelo.setValueAt(nombreTrabajador.get(posicionesEncontradas.get(i)), i, 1);
            modelo.setValueAt(salarioTrabajador.get(posicionesEncontradas.get(i)), i, 2);
            
        }

    }
    
    private void generarArchivoRespaldo(String ficha, String nombre, String tipoAsistencia, String salario){
        
        if(salario == null){
            try {

                wr = new BufferedWriter(new FileWriter(listadoAsistencia,true));

                wr.write(ficha + "," + nombre + "," + tipoAsistencia + "," + new Date().toString());
                wr.newLine();
                wr.close();

            } catch (IOException ex) {
                Logger.getLogger(CAsamblea.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else{
            
            try {

                wr = new BufferedWriter(new FileWriter(listadoFaltas,true));

                wr.write(ficha + "," + nombre + "," + salario);
                wr.newLine();
                wr.close();

            } catch (IOException ex) {
                Logger.getLogger(CAsamblea.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        
    }
    
    private void eliminaFaltaTrabajador(JTable faltas, String noFicha){
        
        DefaultTableModel modelo = (DefaultTableModel) faltas.getModel();

        for (int i = 0; i < modelo.getRowCount(); i++) {
            
            if(modelo.getValueAt(i, 0).equals(noFicha)){
                modelo.removeRow(i);
            }

        }
                
    }
    
    public void justificaFalta(JTable faltasJustificadas,JTable  faltas){

        try {
            
            DefaultTableModel modelo = (DefaultTableModel) faltasJustificadas.getModel();
            
            for (int i = 0; i < modelo.getRowCount(); i++) {
                
                eliminaFaltaTrabajador(faltas, modelo.getValueAt(i, 0).toString());
                
            }
            
            modelo = (DefaultTableModel) faltas.getModel();
            
            wr = new BufferedWriter(new FileWriter(listadoFaltas));
            
            for (int i = 0; i < modelo.getRowCount(); i++) {
                
                wr.write(modelo.getValueAt(i, 0) + "," + modelo.getValueAt(i, 1) + "," + modelo.getValueAt(i, 2));
                wr.newLine();
                
            }
            
            wr.close();
        } catch (IOException ex) {
            Logger.getLogger(CAsamblea.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    public void terminaAsamblea(){
        
        if(asistenciaAsamblea.size() != 0){
            
            DecimalFormat formateador = new DecimalFormat("####.##"); 

            for (int i = 0; i < fichaTrabajador.size(); i++) {

                if(!asistenciaAsamblea.contains(fichaTrabajador.get(i))){

                    generarArchivoRespaldo(fichaTrabajador.get(i), nombreTrabajador.get(i), null ,"" + formateador.format((Double.parseDouble(salarioTrabajador.get(i)) / 15)*2));

                }

            }
            
            try {

                wr = new BufferedWriter(new FileWriter(informacionAsamblea));

                wr.write(encargado + "," + noAsamblea + "," + new Date().toString());
                wr.newLine();
                wr.close();

            } catch (IOException ex) {
                Logger.getLogger(CAsamblea.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }
 
    public boolean cargaArchivoAsamblea(JTable asis, JTable fal){
        
        Object filas [];
        DefaultTableModel modelo;
        
        if(listadoAsistencia.exists() && listadoFaltas.exists()){
            
            try {
                
                BufferedReader br;
                
                br =new BufferedReader(new FileReader(listadoAsistencia));
                
                String linea = br.readLine();
                
                modelo = (DefaultTableModel) asis.getModel();
                
                modelo.setRowCount(0);
                
                while(linea != null){
                    
                    String [] contenido = linea.split(",");
                    
                    filas = new Object[]{contenido[0], contenido[1], contenido[3], contenido[2]};
                    
                    modelo.addRow(filas);
                    
                    linea = br.readLine();
                    
                }
                
                br.close();
                
                br = new BufferedReader(new FileReader(listadoFaltas));
                
                linea = br.readLine();
                
                modelo = (DefaultTableModel) fal.getModel();
                
                modelo.setRowCount(0);
                
                while(linea != null){
                    
                    String [] contenido = linea.split(",");
                    
                    filas = new Object[]{contenido[0], contenido[1], contenido[2]};
                    
                    modelo.addRow(filas);
                    
                    linea = br.readLine();
                    
                }
                
                br = new BufferedReader(new FileReader(informacionAsamblea));
                
                linea = br.readLine();

                String [] contenido = linea.split(",");  
                
                encargado = contenido [0];
                noAsamblea  = contenido[1];
                fechaAsamblea = new Date(contenido[2]);
                
                return true;

            } catch (FileNotFoundException ex) {
                Logger.getLogger(CAsamblea.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(CAsamblea.class.getName()).log(Level.SEVERE, null, ex);
            } 
   
        }
        
        return false;
        
    }
    
    public String getEncargado(){
        return encargado;
    }
    
    public String getAsamblea(){
        return noAsamblea;
    }
    
    public Date getFecha(){
        return fechaAsamblea;
    }
    
}
