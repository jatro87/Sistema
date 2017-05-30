package modelo;

import controlador.ClassConectaBD;
import java.util.Date;
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
    
    public CContrato(){
        
        conexion = new ClassConectaBD();
        ftp = new CftpClient();
        
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
            modelo.setValueAt(res [i][3], i, 3);
            modelo.setValueAt(res [i][4], i, 4);
            modelo.setValueAt(res [i][5], i, 5);
            modelo.setValueAt(res [i][6], i, 6);
            
        }
        
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