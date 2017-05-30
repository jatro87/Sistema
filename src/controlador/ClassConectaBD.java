package controlador;

import java.awt.image.BufferedImage;
import java.io.*;
import java.sql.*;
import javax.imageio.ImageIO;
import modelo.CDireccionServidor;
import modelo.CError;
import modelo.CHistorialSistema;
import modelo.CTransaccion;
import modelo.CUser;

/**
 *
 * @author Tadeo
 */

public final class ClassConectaBD {

    private CUser usuario;
    private CError error;
    private CTransaccion transaccion;
    private CDireccionServidor url;

    private static Connection conexion;
    private static CallableStatement procedimientoAlmacenado;
    private static ResultSet rs;
    private final CHistorialSistema consola;

    public ClassConectaBD(){
        
        consola = new CHistorialSistema();
        
    }
    
    public boolean conectar(){
              
        if(conexion == null){
            try{
                
                usuario = new CUser();
                url = new CDireccionServidor();
                
                Class.forName("com.mysql.jdbc.Driver").newInstance();
                conexion = DriverManager.getConnection("jdbc:mysql://" + url.getURL().trim() + ":3306/sistema?noAccessToProcedureBodies=true&autoReconnect=true&?useUnicode=yes",usuario.getUsuario(),usuario.getContraseña());
                
                conexion.setAutoCommit(false);

            }catch(SQLException | ClassNotFoundException | InstantiationException | IllegalAccessException e ){    
                error = new  CError();
                error.setExepcion(e);
                error.setClase("ClassConectaBD");
                error.setFechaHora();
                error.setMetodo("conectar()");
                consola.setError(error);
                return false;
            } 
        }
        
        return true;
        
    }
    
    public void descoBase(){
        
        try{
            
            conexion.close();
            
        }catch (SQLException e){ 
                error = new  CError();
                error.setExepcion(e);
                error.setClase("ClassConectaBD");
                error.setFechaHora();
                error.setMetodo("descoBase()");
                consola.setError(error);
        }
    }
    
    ////////////////////////////////////////////////////////////////////////////
    /////////////////////// Consultas //////////////////////////////////////////
    
    public synchronized Object [] ejecutarConsulta1(String nombreProcedimiento,Object [] valoresPorEnviar,String [] valoresPorRecibir){

        Object [] resultadoConsulta = new Object [valoresPorRecibir.length];

            try {

                procedimientoAlmacenado = conexion.prepareCall("{ call " + nombreProcedimiento + " }");

                for (int i = 0; i < valoresPorEnviar.length; i++) {

                    if(valoresPorEnviar [i] instanceof String){
                        procedimientoAlmacenado.setString(i + 1, (String)valoresPorEnviar [i]);
                    }
                    else if(valoresPorEnviar [i] instanceof Integer){ 
                        procedimientoAlmacenado.setInt(i + 1, (Integer)valoresPorEnviar [i]); 
                    }
                    else if(valoresPorEnviar [i] instanceof Long){ 
                        procedimientoAlmacenado.setLong(i + 1, (Long)valoresPorEnviar [i]); 
                    }
                    else if(valoresPorEnviar [i] instanceof Double){ 
                        procedimientoAlmacenado.setDouble(i + 1, (Double)valoresPorEnviar [i]);
                    }
                    else if(valoresPorEnviar [i] instanceof Boolean){
                        procedimientoAlmacenado.setBoolean(i + 1, (Boolean)valoresPorEnviar [i]);
                    }
                    else if(valoresPorEnviar [i] instanceof Float){
                        procedimientoAlmacenado.setFloat(i + 1, (Float)valoresPorEnviar [i]);
                    }
                    else if(valoresPorEnviar [i] instanceof java.util.Date){
                        java.util.Date fecha = (java.util.Date)valoresPorEnviar[i];
                        java.sql.Timestamp fechasql = new java.sql.Timestamp (fecha.getTime());
                        procedimientoAlmacenado.setTimestamp(i+1, fechasql);
                    }
                    else if(valoresPorEnviar [i] instanceof File){

                        try {

                            FileInputStream fis = new FileInputStream((File)valoresPorEnviar [i]);
                            procedimientoAlmacenado.setBinaryStream(i+1, fis,(int)((File)valoresPorEnviar [i]).length());

                        } catch (FileNotFoundException ex) {
                             error = new  CError();
                             error.setExepcion(ex);
                             error.setClase("ClassConectaBD");
                             error.setFechaHora();
                             error.setMetodo("ejecutarConsulta1(" + nombreProcedimiento + ",Object [] valoresPorEnviar,String [] valoresPorRecibir)");
                             consola.setError(error);                            
                        }
                    }  
                }

                for (int i = 0; i < valoresPorRecibir.length; i++) {

                    switch (valoresPorRecibir [i]) { 

                        case "String":
                            procedimientoAlmacenado.registerOutParameter(valoresPorEnviar.length + (i + 1),Types.VARCHAR);                       
                          break;                        
                        case "Integer":                       
                            procedimientoAlmacenado.registerOutParameter(valoresPorEnviar.length + (i + 1),Types.INTEGER);            
                            break;                
                        case "Double":
                            procedimientoAlmacenado.registerOutParameter(valoresPorEnviar.length + (i + 1),Types.DOUBLE);                      
                            break;            
                        case "Boolean":
                            procedimientoAlmacenado.registerOutParameter(valoresPorEnviar.length + (i + 1),Types.BOOLEAN);
                            break;      
                        case "Date":        
                            procedimientoAlmacenado.registerOutParameter(valoresPorEnviar.length + (i + 1),Types.DATE); 
                            break;
                        case "Long":        
                            procedimientoAlmacenado.registerOutParameter(valoresPorEnviar.length + (i + 1),Types.BIGINT); 
                            break;
                        case "Float":        
                            procedimientoAlmacenado.registerOutParameter(valoresPorEnviar.length + (i + 1),Types.FLOAT);
                            break;
                        case "File":
                            procedimientoAlmacenado.registerOutParameter(valoresPorEnviar.length + (i + 1),Types.BLOB);
                    }    
                }

                procedimientoAlmacenado.executeQuery();

                for (int i = 0; i < valoresPorRecibir.length; i++) {

                    switch (valoresPorRecibir [i]) {

                        case "String":     
                            resultadoConsulta [i] = procedimientoAlmacenado.getString(valoresPorEnviar.length + (i + 1));                    
                            break;                   
                        case "Integer":                       
                            resultadoConsulta [i] = procedimientoAlmacenado.getInt(valoresPorEnviar.length + (i + 1));                      
                            break;
                        case "Long":                       
                            resultadoConsulta [i] = procedimientoAlmacenado.getLong(valoresPorEnviar.length + (i + 1));                      
                            break;   
                        case "Double":                       
                            resultadoConsulta [i] = procedimientoAlmacenado.getDouble(valoresPorEnviar.length + (i + 1));                     
                            break;                       
                        case "Boolean":                    
                            resultadoConsulta [i] = procedimientoAlmacenado.getBoolean(valoresPorEnviar.length + (i + 1));      
                            break;   
                        case "Date":
                            resultadoConsulta [i] = procedimientoAlmacenado.getDate(valoresPorEnviar.length + (i + 1));
                            break;
                        case "Float":
                            resultadoConsulta [i] = procedimientoAlmacenado.getFloat(valoresPorEnviar.length + (i + 1));
                            break;
                        case "File":

                            Blob blob = procedimientoAlmacenado.getBlob(valoresPorEnviar.length + (i + 1));

                            if(blob != null){

                                byte[] data = blob.getBytes(1, (int)blob.length());

                                BufferedImage img;

                                File rutaImagen = new File("temp" + File.separator + "img.jpg");

                                resultadoConsulta [i] = rutaImagen;

                                try {

                                    img = ImageIO.read(new ByteArrayInputStream(data));

                                    if(img != null)
                                        ImageIO.write(img, "jpg", rutaImagen);

                                    else
                                        resultadoConsulta [i] = null;

                                } catch (IOException ex) {      
                                     error = new  CError();
                                     error.setExepcion(ex);
                                     error.setClase("ClassConectaBD");
                                     error.setFechaHora();
                                     error.setMetodo("ejecutarConsulta1(" + nombreProcedimiento + ",Object [] valoresPorEnviar,String [] valoresPorRecibir)");
                                     consola.setError(error); 
                                }

                            }
                            else
                                resultadoConsulta [i] = null;

                            break;

                    }
                }

                conexion.commit();
                
                transaccion = new CTransaccion();
                transaccion.setClase("ClassConectaBD");
                transaccion.setFechaHora();
                transaccion.setMetodo("ejecutarConsulta1(String nombreProcedimiento,Object [] valoresPorEnviar,String [] valoresPorRecibir)");
                transaccion.setProcedimiento(nombreProcedimiento);
                consola.seTransaccion(transaccion);
                
            }catch(SQLException ex){    
                error = new  CError();
                error.setExepcion(ex);
                error.setClase("ClassConectaBD");
                error.setFechaHora();
                error.setMetodo("ejecutarConsulta1(" + nombreProcedimiento + ",Object [] valoresPorEnviar,String [] valoresPorRecibir)");
                consola.setError(error);                
                try {
                    conexion.rollback();
                } catch (SQLException ex1) {
                     error = new  CError();
                    error.setExepcion(ex1);
                    error.setClase("ClassConectaBD");
                    error.setFechaHora();
                    error.setMetodo("ejecutarConsulta1(" + nombreProcedimiento + ",Object [] valoresPorEnviar,String [] valoresPorRecibir)");
                    consola.setError(error);
                }

            }
            finally{
                try {
                    procedimientoAlmacenado.close();
                } catch (SQLException ex) {    
                     error = new  CError();
                     error.setExepcion(ex);
                     error.setClase("ClassConectaBD");
                     error.setFechaHora();
                     error.setMetodo("ejecutarConsulta1(" + nombreProcedimiento + ",Object [] valoresPorEnviar,String [] valoresPorRecibir)");
                     consola.setError(error);    
                }
            }
        
        return resultadoConsulta;
        
    }

    public synchronized Object [][] ejecutarConsulta2(String nombreProcedimiento,Object [] valoresPorEnviar,int numeroColumnas){

            try {

                procedimientoAlmacenado = conexion.prepareCall("{ call " + nombreProcedimiento + "}");

                for (int i = 0; i < valoresPorEnviar.length; i++) {


                    if(valoresPorEnviar [i] instanceof String){

                        procedimientoAlmacenado.setString(i + 1, (String)valoresPorEnviar [i]);

                    }
                    else if(valoresPorEnviar [i] instanceof Integer){

                        procedimientoAlmacenado.setInt(i + 1, (Integer)valoresPorEnviar [i]);

                    }         
                    else if(valoresPorEnviar [i] instanceof Double){

                        procedimientoAlmacenado.setDouble(i + 1, (Double)valoresPorEnviar [i]);

                    }
                    else if(valoresPorEnviar [i] instanceof Boolean){

                        procedimientoAlmacenado.setBoolean(i + 1, (Boolean)valoresPorEnviar [i]);

                    }
                    else if(valoresPorEnviar [i] instanceof java.util.Date){
                        java.util.Date fecha = (java.util.Date)valoresPorEnviar[i];
                        java.sql.Timestamp fechasql = new java.sql.Timestamp (fecha.getTime());
                        procedimientoAlmacenado.setTimestamp(i+1, fechasql);
                    }
                }   

                rs = procedimientoAlmacenado.executeQuery();

                int contador = 0;

                while(rs.next()){
                    contador ++;
                }

                Object [][] resultados = new Object [contador][numeroColumnas];

                rs.first();

                for (int i = 0; i < contador; i++) {

                    for (int j = 0; j < numeroColumnas; j++) {
                        resultados[i][j] = rs.getObject(j + 1);
                    }

                    rs.next();

                }

                conexion.commit();
                
                transaccion = new CTransaccion();
                transaccion.setClase("ClassConectaBD");
                transaccion.setFechaHora();
                transaccion.setMetodo("ejecutarConsulta2(String nombreProcedimiento,Object [] valoresPorEnviar,int numeroColumnas)");
                transaccion.setProcedimiento(nombreProcedimiento);
                consola.seTransaccion(transaccion);
               
                return resultados;

            }catch (SQLException ex) {
                     error = new  CError();
                     error.setExepcion(ex);
                     error.setClase("ClassConectaBD");
                     error.setFechaHora();
                     error.setMetodo("ejecutarConsulta2(" + nombreProcedimiento + ",Object [] valoresPorEnviar,int numeroColumnas)");
                     consola.setError(error);                
                try {
                    conexion.rollback();
                } catch (SQLException ex1) {
                     error = new  CError();
                     error.setExepcion(ex1);
                     error.setClase("ClassConectaBD");
                     error.setFechaHora();
                     error.setMetodo("ejecutarConsulta2(" + nombreProcedimiento + ",Object [] valoresPorEnviar,int numeroColumnas)");
                     consola.setError(error);     
                }
            }
        
       return null; 
 
    }
    
}
