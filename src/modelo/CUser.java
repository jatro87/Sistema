package modelo;

import controlador.ClassConectaBD;

/**
 *
 * @author hp
 */

public class CUser {
    
    private static String usua = "";
    private static String contra = "";
    private static String nivel = "";
    private ClassConectaBD conexion = null;
    
    public CUser(){
        
    }
    
//    public void conectar(){
////        conexion = new ClassConectaBD();
//    }
    
    public void setUsuario(String user){
        usua = user;
    }
    
    public void setContraseña(String pass){
        contra = pass;
    }
    
//    public String acceso(){
//
//        Object res [] = conexion.ejecutarConsulta1("login(?,?,?,?)", 
//                        new Object []{usua,contra}, new String []{"String","String"});
//        
//        try{
//            
//            nivel = res [0].toString();
//            
//            return res [1].toString();
//            
//        }catch(NullPointerException e){
//            return res [1].toString();
//        }
//        
//    }
    
    public boolean actualizaContraseña(String contraseña){
        
        try{
        
            conexion.ejecutarConsulta1("setNuevaContraseña(?,?)", 
                            new Object []{contraseña, usua}, new String []{});

            return true;
            
        }catch(Exception e){
            System.out.println(e);
        }

        return false;
  
    }
    
    public String getNombreTrabajador(){
        
        Object res [][];
        
        try{

            res = conexion.ejecutarConsulta2("getNombreTrabajador(?)", 
                            new Object []{usua}, 3);

            return res [0][0].toString() + " " + res[0][1].toString() + " " + res[0][2].toString();
            
        }catch(Exception e){
            System.out.println(e);
            return null;
        }
 
    }

    public String getUsuario(){
        return usua;
    }
    
    public String getContraseña(){
        return contra;
    }
    
    public String getNivel(){
        return nivel;
    }
}
