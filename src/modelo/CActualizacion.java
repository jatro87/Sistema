package modelo;

import controlador.ClassConectaBD;
import java.io.File;
import javax.swing.ImageIcon;

public class CActualizacion {
    
    private final ClassConectaBD conexion;
    private String _version, _clasificacion, _versionReciente, _extension, _toolTip;
    
    public CActualizacion(){
        conexion = new ClassConectaBD();
    }
    
    public boolean getUpdate(){
        
        Object [] res = conexion.ejecutarConsulta1("getUpdate(?,?,?,?,?)",
                new Object[]{"Cuauhpipiltin V 1.0"}, new String []{"String","String", "String", "String"});
        
        if(!res[0].equals("Software Actualizado")){
            _version = res[0].toString();
            _clasificacion = res [1].toString();
            _versionReciente = res [2].toString();
            _extension = res [3].toString();
            _toolTip = "Clic para Actualizar";
            return true;
        }
        else
            return false;
        
    }
    
    public Object [] getNotificacion(){
        
        return new Object []{_version,_toolTip,
            new ImageIcon(getClass().getResource("/iconos/Actualizacion.png"))};

    }

}
