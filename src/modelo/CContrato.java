package modelo;

import controlador.ClassConectaBD;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Angel
 */

public class CContrato {
    
    private String departamento, categoria, id_contrato, trabajador, tipo;
    private Date fecha_inicio, fecha_fin;
    private ClassConectaBD conexion;
    private CftpClient ftp;
    private Object [][] contratosActivos;
    private Pattern pt;
    private Matcher mt;
    
    public CContrato(){
        
        conexion = new ClassConectaBD();
        ftp = new CftpClient();
        
    }
    
    public void getContratos(JTable tablaResultados){
        
        DefaultTableModel modelo = (DefaultTableModel) tablaResultados.getModel();
        
        contratosActivos = conexion.ejecutarConsulta2("getContratosTrabajadores()", new Object []{}, 8);
        
        modelo.setRowCount(0);
        
        Object [] row = new Object[8];
        
        for (int i = 0; i < contratosActivos.length; i++) {
            
            modelo.addRow(row);
            
            modelo.setValueAt(contratosActivos [i][0], i, 0);
            modelo.setValueAt(contratosActivos [i][1], i, 1);
            modelo.setValueAt(contratosActivos [i][2], i, 2);
            modelo.setValueAt(contratosActivos [i][3], i, 3);
            modelo.setValueAt(contratosActivos [i][4], i, 4);
            modelo.setValueAt(getFechaLarga((Date) contratosActivos [i][5]), i, 5);
            modelo.setValueAt(getFechaLarga((Date) contratosActivos [i][6]), i, 6);
            modelo.setValueAt(contratosActivos [i][7], i, 7);
            
        }

    }
    
    public void buscaSobreDepartamento(JTable tablaResultados, String departamento){
        
        DefaultTableModel modelo = (DefaultTableModel) tablaResultados.getModel();
        
        modelo.setRowCount(0);
        
        Object [] row = new Object[8];
        
        int j = 0;
        
        for (int i = 0; i < contratosActivos.length; i++) {
            
            if(contratosActivos [i][2].equals(departamento)){
                
                modelo.addRow(row);
                modelo.setValueAt(contratosActivos [i][0], j, 0);
                modelo.setValueAt(contratosActivos [i][1], j, 1);
                modelo.setValueAt(contratosActivos [i][2], j, 2);
                modelo.setValueAt(contratosActivos [i][3], j, 3);
                modelo.setValueAt(contratosActivos [i][4], j, 4);
                modelo.setValueAt(getFechaLarga((Date) contratosActivos [i][5]), j, 5);
                modelo.setValueAt(getFechaLarga((Date) contratosActivos [i][6]), j, 6);
                modelo.setValueAt(contratosActivos [i][7], j, 7);
                j++;
            }
                       
        }
  
    }

    public void buscaSobreTrabajador(JTable tablaResultados, String dato){
        
        DefaultTableModel modelo = (DefaultTableModel) tablaResultados.getModel();
        
        modelo.setRowCount(0);
        
        Object [] row = new Object[8];
        
        if(dato.equals("")){
            
            for (int i = 0; i < contratosActivos.length; i++) {

                modelo.addRow(row);

                modelo.setValueAt(contratosActivos [i][0], i, 0);
                modelo.setValueAt(contratosActivos [i][1], i, 1);
                modelo.setValueAt(contratosActivos [i][2], i, 2);
                modelo.setValueAt(contratosActivos [i][3], i, 3);
                modelo.setValueAt(contratosActivos [i][4], i, 4);
                modelo.setValueAt(getFechaLarga((Date) contratosActivos [i][5]), i, 5);
                modelo.setValueAt(getFechaLarga((Date) contratosActivos [i][6]), i, 6);
                modelo.setValueAt(contratosActivos [i][7], i, 7);

            }
        }
        else{
                
            int j = 0;

            pt = Pattern.compile(".*" + dato.toLowerCase() + ".*");

            for (int i = 0; i < contratosActivos.length; i++) {

                mt = pt.matcher(contratosActivos [i][1].toString().toLowerCase());

                if(mt.matches()){

                    modelo.addRow(row);
                    modelo.setValueAt(contratosActivos [i][0], j, 0);
                    modelo.setValueAt(contratosActivos [i][1], j, 1);
                    modelo.setValueAt(contratosActivos [i][2], j, 2);
                    modelo.setValueAt(contratosActivos [i][3], j, 3);
                    modelo.setValueAt(contratosActivos [i][4], j, 4);
                    modelo.setValueAt(getFechaLarga((Date) contratosActivos [i][5]), j, 5);
                    modelo.setValueAt(getFechaLarga((Date) contratosActivos [i][6]), j, 6);
                    modelo.setValueAt(contratosActivos [i][7], j, 7);
                    j++;
                }

            }
        }
  
    }

    public void buscaSobreCategoria(JTable tablaResultados, String categoria){
        
        DefaultTableModel modelo = (DefaultTableModel) tablaResultados.getModel();
        
        modelo.setRowCount(0);
        
        Object [] row = new Object[8];
        
        int j = 0;
        
        for (int i = 0; i < contratosActivos.length; i++) {
            
            if(contratosActivos [i][3].equals(categoria)){
                
                modelo.addRow(row);
                modelo.setValueAt(contratosActivos [i][0], j, 0);
                modelo.setValueAt(contratosActivos [i][1], j, 1);
                modelo.setValueAt(contratosActivos [i][2], j, 2);
                modelo.setValueAt(contratosActivos [i][3], j, 3);
                modelo.setValueAt(contratosActivos [i][4], j, 4);
                modelo.setValueAt(getFechaLarga((Date) contratosActivos [i][5]), j, 5);
                modelo.setValueAt(getFechaLarga((Date) contratosActivos [i][6]), j, 6);
                modelo.setValueAt(contratosActivos [i][7], j, 7);
                j++;
            }
                       
        }
  
    }
    
    public void getListaDepartamentos(JComboBox departamentos){
        
        departamentos.removeAllItems();
        
        departamentos.addItem("Selecciona");
        
        Object [][] res = conexion.ejecutarConsulta2("getListaDepartamentos()", new Object [] {}, 1);
        
        for (int i = 0; i < res.length; i++) {
            departamentos.addItem(res[i][0]);
        }
        
        departamentos.addItem("*Nuevo");
    }
    
    public boolean getArchivoContrato(String nombreArchivo){
        
        return ftp.getArchivo(nombreArchivo);
        
    }
    
    public void getListaCategorias(JComboBox categorias){
        
        categorias.removeAllItems();
        
        categorias.addItem("Selecciona");
        
        Object [][] res = conexion.ejecutarConsulta2("getListadoCategorias()", new Object [] {}, 1);
        
        for (int i = 0; i < res.length; i++) {
            categorias.addItem(res[i][0]);
        }
        
        categorias.addItem("*Nuevo");
    }
    
    public String setNuevoDepartamento(String nombre){
        Object [] res = conexion.ejecutarConsulta1("setNuevoDepartamento(?,?)",
                new Object []{nombre}, new String []{"String"});
        
        return (String) res[0];
    }
    
    public String setRegistraContrato(){
        Object [] res = conexion.ejecutarConsulta1("setRegistroContrato(?,?,?,?,?,?,?,?)",
                new Object []{id_contrato,trabajador,fecha_inicio, fecha_fin, departamento, categoria, tipo}, new String []{"String"});
        
        return (String) res[0];
    }
    
    public String setNuevaCategoria(String [] datos){
        Object [] res = conexion.ejecutarConsulta1("setNuevaCategoria(?,?,?)",
                new Object []{datos[0],datos[1]}, new String []{"String"});
        
        return (String) res[0];
    }
    
    public void setCategoria(String categoria){
        this.categoria = categoria;
    }
    
    public void setFechaInicio(Date fechaInicio){
        this.fecha_inicio = fechaInicio;
    }
    
    public void setFechaFin(Date fechaFin){
        this.fecha_fin = fechaFin;
    }
    
    public void setDepartamento(String dep){
        this.departamento = dep;
    }
    
    public void setNoContrato(String id){
        this.id_contrato = id;
    }
    
    public void setTipo(String tipo){
        this.tipo = tipo;
    }
    
    public void setTrabajador(String noficha){
        this.trabajador = noficha;
    }
    
    public void getHistorialContratos(JTable tabla, String noFicha){
        
        DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
        
         for (int i = modelo.getRowCount(); i > 0; i--) {
            modelo.removeRow(i-1);
        }       
        
        Object [] filas = new Object [7];
        
        Object [][] res = conexion.ejecutarConsulta2("getHistorialContratos(?)", new Object[]{noFicha}, 7);
        
        for (int i = 0; i < res.length; i++) {
            
            modelo.addRow(filas);
            
            modelo.setValueAt(res [i][0], i, 0);
            modelo.setValueAt(res [i][1], i, 1);
            modelo.setValueAt(res [i][2], i, 2);
            
            modelo.setValueAt(getFechaLarga((Date) res [i][3]), i, 3);
            modelo.setValueAt(getFechaLarga((Date) res [i][4]), i, 4);
            
            modelo.setValueAt(res [i][5], i, 5);
            modelo.setValueAt(res [i][6], i, 6);
            
        }
        
    }
    
    private String getFechaLarga(Date fecha){
        
        SimpleDateFormat formateador = new SimpleDateFormat("dd 'de' MMM 'del' yy", new Locale("es_ES"));
        
        return formateador.format(fecha);
   
    }
    
    
    public String getDepartamento(){
        return departamento;
    }
    
    public String getCategoria(){
        return departamento;
    }
    
    public Date getFechaInicio(){
        return fecha_inicio;
    }
    
    public Date getFechaFin(){
        return fecha_fin;
    }
    
    public String getIdContrato(){
        return  id_contrato;
    }
    
    public String getTrabajador(){
        return trabajador;
    }
    
    public String getTipo(){
        return tipo;
    }
    
}