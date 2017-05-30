package modelo;

import controlador.ClassConectaBD;
import java.io.File;
import java.util.Date;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Tadeo
 */

public class CTrabajador{
    
    private final ClassConectaBD conexion;
    public CDomicilio domicilio;
    public CSalud salud;
    public CEstudios estudios;
    public CFamilia familia;
    public CContrato contrato;
    private final CftpClient ftp;
    private final CHistorialSistema consola;
    
    private String nombre,apellidoP,apellidoM;
    private String rfc,clave,noficha,curp;
    private String recomendacion,apodo, estadoCivil, sexo;
    private String fechaNacimiento;
    private File fotoTrabajador;
    
    
    public CTrabajador (){
        domicilio = new CDomicilio();
        salud = new CSalud();
        estudios = new CEstudios();
        familia = new CFamilia();
        conexion = new ClassConectaBD();
        contrato = new CContrato();
        ftp = new CftpClient();
        consola = new CHistorialSistema();
    }

    public String registrarTrabajador(){
        
        Object res [] = conexion.ejecutarConsulta1("setTrabajador(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)", 
                        new Object[]{
                            nombre,
                            apellidoP,
                            apellidoM,
                            domicilio.getCalle(),
                            domicilio.getColonia(),
                            domicilio.getNumero(),
                            domicilio.getCodigoPostal(),
                            domicilio.getCiudad(),
                            rfc,
                            curp,
                            clave,
                            noficha,
                            estudios.getEstudios(),
                            estudios.getEspecialidad(),
                            salud.getConvenioMedico(),
                            salud.getTipoSangre(),
                            new Date(fechaNacimiento),
                           // telefono,
                            recomendacion,
                            apodo,
                            familia.getEstadoCivil(),
                            familia.getEsposa(),
                            sexo
                        }, 
                        new String []{
                            "String"
                        });
        
        return res[0].toString();
        
    }

    public boolean buscaTrabajadorConicidencias(String busqueda, JTable tabla){
        
        boolean flag = false;
        
        Object [][] res = conexion.ejecutarConsulta2("getBusquedaTrabajadores(?)", new Object [] {busqueda}, 4);
        
        DefaultTableModel model = (DefaultTableModel) tabla.getModel();
        
        Object [] rows = new Object [4];

        for (int i = model.getRowCount(); i > 0; i--) {
            model.removeRow(i-1);
        }
        
        for (int i = 0; i < res.length; i++) {
            
            model.addRow(rows);  
            model.setValueAt(res[i][0], i, 0);
            model.setValueAt(res[i][1], i, 1);
            model.setValueAt(res[i][2], i, 2);
            model.setValueAt(res[i][3], i, 3);

            flag = true;

        }

        return flag;   
        
    }
    
    public Object [] setNuevaFicha(String fichaAnterior, String fichaNueva, String motivo){
        
        Object res [] = conexion.ejecutarConsulta1("setCambioFicha(?,?,?,?,?)", new Object []{fichaAnterior, fichaNueva, motivo}, new String[]{"String", "String"});
        
        return res;
        
    }
    
    public boolean getNombreTrabajadorBD(){
      
        Object [][] res = conexion.ejecutarConsulta2("getNombreTrabajador(?)", new Object [] {noficha}, 3);
        
        try{

            this.nombre = res [0][0].toString();
            this.apellidoP = res [0][1].toString();
            this.apellidoM = res [0][2].toString();
            
            return true;
       
        }catch(ArrayIndexOutOfBoundsException x){
            return false;
        }

    }
    
    public void getTelefonosTrabajador(String noFicha, JTable tabla){
        
        Object [][] res = conexion.ejecutarConsulta2("getTelefonosTrabajador(?)", new Object [] {noFicha}, 2);
        
        DefaultTableModel model = (DefaultTableModel) tabla.getModel();
        
        Object [] rows = new Object [2];

        for (int i = model.getRowCount(); i > 0; i--) {
            model.removeRow(i-1);
        }
        
        for (int i = 0; i < res.length; i++) {
            
            model.addRow(rows);  
            model.setValueAt(res[i][0], i, 0);
            model.setValueAt(res[i][1], i, 1);

        }

    }
    
    public boolean getDatosTrabajador(){

        Object [][] res = conexion.ejecutarConsulta2("getDatosTrabajador(?)",
                new Object [] {this.noficha}, 20);       
        
        if(res != null){
                        
           this.noficha = res [0][0].toString(); 
           this.nombre = res [0][1].toString();
           this.apellidoP = res [0][2].toString();
           this.apellidoM = res [0][3].toString();
           this.domicilio.setCalle(res [0][4].toString());
           this.domicilio.setNumero(res [0][5].toString());
           this.domicilio.setColonia(res [0][6].toString());
           this.domicilio.setCiudad(res [0][7].toString());
           this.domicilio.setCodigoPostal(res [0][8].toString());
           this.curp = res [0][9].toString();
           this.clave = res [0][10].toString();
           this.rfc = res [0][11].toString();
           this.estudios.setEstudios(res [0][12].toString());
           
           if(res [0][13].equals("Primaria") || res [0][13].equals("Secundaria") || res [0][13].equals("Preparatoria"))
               this.estudios.setEspecialidad("No");
           else
            this.estudios.setEspecialidad(res [0][13].toString());
           
           this.salud.setConvenioMedico(res [0][14].toString());
           this.salud.setTipoSangre(res [0][15].toString());
           this.fechaNacimiento =  res [0][16].toString();
           this.recomendacion = res [0][17].toString();
           this.apodo = res [0][18].toString();
           this.estadoCivil = res [0][19].toString();
           
           res = conexion.ejecutarConsulta2("getFotoExpedienteTrabajador(?)",
                new Object [] {noficha}, 4);
           
           if(ftp.getFileExpediente("Trabajador", res[0][0].toString(), res[0][1].toString(), res[0][2].toString(), res[0][3].toString())){
               
               fotoTrabajador = new File(System.getProperty("java.io.tmpdir") + File.separator + res[0][2].toString() + res[0][3].toString());
               
           }  
           
           return true;
 
        }
        
        return false;
        
    }
    
//    public void getFotoTrabajador(){
//        
//        ftp.getFileExpediente("Trabajador", noficha, "Fotografias", nombre, telefono);
//  
//    }
    
    public void agregarTelefonos(Object [] datos, JTable tabla, int numTelefono){
        
        if(datos[0] != null  && datos[1] != null){
            DefaultTableModel model = (DefaultTableModel) tabla.getModel();

            Object [] rows = new Object [2];

            model.addRow(rows);  
            model.setValueAt(datos [0], numTelefono, 0);
            model.setValueAt(datos [1], numTelefono, 1);
        }

    }
    
    public void eliminaTelefono(String noTelefono){

        conexion.ejecutarConsulta1("eliminaTelefonoTrabajador(?,?)",
                new Object[]{noficha,noTelefono},
                new String []{});
        
    }
    
    public void setTelefonos(JTable tabla){
        
        DefaultTableModel model = (DefaultTableModel) tabla.getModel();
        
        for (int i = 0; i < model.getRowCount(); i++) {
            
            conexion.ejecutarConsulta1("setTelefono(?,?,?)",
                    new Object[]{noficha,model.getValueAt(i, 0),model.getValueAt(i, 1)},
                    new String []{});
            
        }

    }
    
    public void agregarTelefonoNuevo(String telefono, String tipoTelefono){
        
        conexion.ejecutarConsulta1("setNuevoTelefono(?,?,?)",
                new Object[]{noficha,telefono,tipoTelefono},
                new String []{});
        
    }
    
    public void actualizaTelefono(String telefonoAnterior,String telefonoNuevo){
        
        conexion.ejecutarConsulta1("updateTelefonosTrabajadores(?,?,?)",
                new Object[]{noficha,telefonoAnterior,telefonoNuevo},
                new String []{});
        
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    
    public void setApellidoP(String apellidoP){
        this.apellidoP = apellidoP;
    }
    
    public void setApellidoM(String apellidoM){
        this.apellidoM = apellidoM;
    }

    public void setRfc(String rfc){
        this.rfc = rfc;
    }

    public void setClave(String clave){
        this.clave = clave;
    }
    
    public void setCurp(String curp){
        this.curp = curp;
    }
    
    public void setEstadocivil(String estadoCivil){
        this.estadoCivil = estadoCivil;
    }
    
    public void setFoto(File foto){
        this.fotoTrabajador = foto;
    }
    
    public void setNoFicha(String noFicha){
        this.noficha = noFicha.replaceAll(" ", "").trim();
    }
    
    public void setRecomendacion(String recomendado){
        this.recomendacion = recomendado;
    }
    
    public void setApodo(String apodo){
        this.apodo = apodo;
    }
    
    public void setNacimiento(String nacimiento){
        this.fechaNacimiento = nacimiento;
    }
    
    public void setSexo(String sexo){
        this.sexo = sexo;
    }
    
    public String getNombre(){
        return nombre;
    }
    
    public String getSexo(){
        return sexo;
    }
    
    public String getApellidoP(){
        return apellidoP;
    }
    
    public String getApellidoM(){
        return apellidoM;
    }
   
    public String getRFC(){
        return rfc;
    }

    public String getClave(){
        return clave;
    }
    
    public String getCurp(){
        return curp;
    }
    
    public String getNoFicha(){
        return noficha;
    }
    
    public File getFoto(){
        return fotoTrabajador;
    }

    public String getRecomendacion(){
        return recomendacion;
    }
    
    public String getApodo(){
        return apodo;
    }
    
    public String getEstadoCivil(){
        return estadoCivil;
    }
    
    public String getFechaNacimiento(){
        return fechaNacimiento;
    }
}
